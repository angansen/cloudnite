package com.oracle.cloudnite.service;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.oracle.cloudnite.dao.ConsumptionDao;
import com.oracle.cloudnite.model.Consumption;
import com.oracle.cloudnite.model.DataReader;
import com.oracle.cloudnite.model.Report;

@Service
@Transactional
public class ExcelServiceImpl {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	ConsumptionDao dao;

	public HashMap<String, String> uploadExcelFile(MultipartFile multipartFile) throws IOException {
		HashMap<String, String> uploadStatus = new HashMap<String, String>();
		InputStream inputStream;
		HashMap<String, Object> consumptionDataMap = null;
		try {
			inputStream = multipartFile.getInputStream();
			// List<Consumption> consumptions= DataReader.GetConsumptionData(inputStream);
			consumptionDataMap = DataReader.GetConsumptionData(inputStream);
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			uploadStatus.put("status", "false");
			uploadStatus.put("message", "Only xslx format is accepted");
			return uploadStatus;
		}
		if (!(Boolean) consumptionDataMap.get("status")) {
			uploadStatus.put("status", "false");
			uploadStatus.put("message", (String) consumptionDataMap.get("message"));
			return uploadStatus;
		}
		boolean saveStatus = saveAllData((List<Consumption>) consumptionDataMap.get("consumption"));
		if (saveStatus) {
			uploadStatus.put("status", "true");
			uploadStatus.put("message", "Successfully inserted data");
		} else {
			uploadStatus.put("status", "true");
			uploadStatus.put("message", "Error while inserting data");
		}
		return uploadStatus;

	}

	public List<Consumption> getReportsByName(Optional<String> name, Optional<String> role, Optional<String> lob) {

		// this is for SVP data
		if (!name.isPresent() && !role.isPresent() && !lob.isPresent()) {
			String sql = "select * from cloud_nite_scorecard where  SVP like '%Total'";
			return prepareResponse(getSVPData(sql), role);
		} else {

			String sql = "select * from cloud_nite_scorecard ";

			String nameString = name.get().replace(" ", ".");
			if (!lob.get().equalsIgnoreCase("smb")) {
				if (role.get().equalsIgnoreCase("svp")) {
					sql += "where gvp like '%Total' and svp='" + nameString + "'";
				} else if (role.get().equalsIgnoreCase("gvp")) {
					sql += "where rm like '%Total' and gvp='" + nameString + "'";
				} else if (role.get().equalsIgnoreCase("rm")) {
					sql += "where rm='" + nameString + "'";
				}
			} else {
				if (role.get().equalsIgnoreCase("svp")) {
					sql += "where gvp like '%Total' and svp='" + nameString + "'";
				} else if (role.get().equalsIgnoreCase("gvp")) {
					sql += "where avp like '%Total' and gvp='" + nameString + "'";
				} else if (role.get().equalsIgnoreCase("avp")) {
					sql += "where rm like '%Total' and avp='" + nameString + "'";
				} else if (role.get().equalsIgnoreCase("rm")) {
					sql += "where rm='" + nameString + "'";
				}
			}

			return prepareResponse(getSVPData(sql), role);
		}
	}

	public List prepareResponse(List<Consumption> entries, Optional<String> role) {

		List<Report> reports = new ArrayList<Report>();

		if (entries.size() > 0) {
			String lob = entries.get(0).getLOB();
			for (Consumption consumption : entries) {
				Report report = new Report();
				report.setCapture_targets_identified(consumption.getCOMPLETED_CAPTURE() + "");
				report.setCommit_pipe_60_90(consumption.getCOMMIT_PIPE() + "");
				report.setCustomers_with_expansion_ucc(consumption.getCUSTOMERS_WITH_EXPANSION_UCC() + "");
				report.setCustomers_with_ucc_renewals(consumption.getCUSTOMERS_WITH_UCC_RENEWALS() + "");

				if (!role.isPresent()) {
					report.setName(consumption.getSVP().split(" ")[0].replace(".", " "));
					report.setRole("svp");

				} else if (role.get().equalsIgnoreCase("svp")) {
					report.setName(consumption.getGVP().split(" ")[0].replace(".", " "));
					report.setRole("gvp");
				} else if (role.get().equalsIgnoreCase("gvp")) {
					if (lob.equalsIgnoreCase("smb")) {
						report.setName(consumption.getAVP().split(" ")[0].replace(".", " "));
						report.setRole("avp");

					} else {
						report.setName(consumption.getRM().split(" ")[0].replace(".", " "));
						report.setRole("rm");
						report.setRepcount(getRepCount(consumption.getGVP(), consumption.getRM(), "gvp"));
					}
				} else if (role.get().equalsIgnoreCase("avp")) {
					report.setName(consumption.getRM().split(" ")[0].replace(".", " "));
					report.setRole("rm");
					report.setRepcount(getRepCount(consumption.getAVP(), consumption.getRM(), "avp"));
				} else if (role.get().equalsIgnoreCase("rm")) {
					report.setName(consumption.getREPS().split("@")[0].replace(".", " "));
					report.setRole("reps");
				}
				report.setLob(consumption.getLOB());
				report.setNew_customers_with_consumption(consumption.getNEW_CUSTOMERS_WITH_CONSUMPTION() + "");
				report.setOpen_pipe_10_30(consumption.getOPEN_PIPE() + "");
				report.setPipeline_consulting_attach_opps(consumption.getPIPELINE_CONSULTING() + "");
				report.setUnpiped_capture_opp_count(consumption.getUNPIPED_CAPTURE() + "");
				report.setUpside_pipe_40_50(consumption.getUPSIDE_PIPE() + "");
				report.setWon_consulting_attach_opps(consumption.getWON_CONSULTING_ATTACH() + "");
				report.setWon_deals(consumption.getWON_DEALS() + "");
				report.setWon_participation_rate(consumption.getWON_PARTICIPATION_RATE() + "");

				reports.add(report);
			}
		}
		
		Collections.sort(reports);
		return reports;
	}

	public String getRepCount(String name, String rm, String role) {

		try {
			BigDecimal numericvalue;
			String sql = "select count(*)as repcount, rm from cloud_nite_scorecard where " + role + "='" + name
					+ "' and rm ='" + rm.split(" ")[0] + "' group by rm";
			// System.out.println(" > " + name + " --- " + sql);
			List repcount = entityManager.createNativeQuery(sql).getResultList();
			return ((BigDecimal) ((Object[]) repcount.get(0))[0]).intValue() + "";
		} catch (Exception e) {
			System.out.println("Exception occured " + e);
			return "0";
		}
	}

	public List<Consumption> getSVPData(String query) {
		List<Consumption> datalist = entityManager.createNativeQuery(query, Consumption.class).getResultList();

//		//System.out.println("Reports Data: " + datalist);
		return datalist;
	}

	@Modifying(clearAutomatically = true)
	private void purgeTable() {
		String sql = "truncate table CLOUD_NITE_SCORECARD";

		int deleteCount = entityManager.createNativeQuery(sql).executeUpdate();

		System.out.println("Deleted records : " + deleteCount);
	}

	public boolean saveAllData(List<Consumption> usage) {
		purgeTable();
		String started = Calendar.getInstance().getTime().toString();
		int flag = 1;
		for (Consumption consumption : usage) {
			try {
				Consumption savedObj = dao.save(consumption);

			} catch (Throwable e) {
				System.out.println("Record insert error: " + e.getMessage());
				flag = 0;
			}
		}

		System.out.println("#########################################################");
		System.out.println("Job Started       @ " + started);
		System.out.println("Job Completed @ " + Calendar.getInstance().getTime().toString());
		System.out.println("#########################################################");
		if (flag == 1) {
			return true;
		}
		return false;
	}
}
