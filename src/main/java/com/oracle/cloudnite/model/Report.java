package com.oracle.cloudnite.model;

import java.util.HashMap;
import java.util.Map;

public class Report implements Comparable<Report> {

	public static Map<String, String> lobleadermap = new HashMap<String, String>();

	private String role;
	private String lob;
	private String name;
	private String iconlink;
	private String repcount;
	private String capture_targets_identified;// Capture Targets Identified

	private String unpiped_capture_opp_count;// Unpiped Capture Opp Count

	private String open_pipe_10_30;// Open Pipe 10 - 30%

	private String upside_pipe_40_50; // Upside Pipe 40 - 50%

	private String commit_pipe_60_90; // Commit Pipe 60 - 90%

	private String pipeline_consulting_attach_opps;// Pipeline Consulting Attach Opps

	private String won_deals; // Won Deals

	private String won_participation_rate; // Won Participation Rate

	private String won_consulting_attach_opps; // Won Consulting Attach Opps

	private String new_customers_with_consumption;// "New Customers with Consumption"

	private String customers_with_expansion_ucc;// "Customers with Expansion of UCC"

	private String customers_with_ucc_renewals; // "Customers with UCC Renewals"

	public Report() {

		lobleadermap.put("Enterprise",
				"http://solutionengineering.us.oracle.com:8000/assets/img/Mark_Dorsey_Leaderboard.png");
		lobleadermap.put("KAD",
				"http://solutionengineering.us.oracle.com:8000/assets/img/Sherry_Lautenbach_Leaderboard.png");
		lobleadermap.put("Mid Market",
				"http://solutionengineering.us.oracle.com:8000/assets/img/Mark_McNamara_Leaderboard.png");
		lobleadermap.put("SMB",
				"http://solutionengineering.us.oracle.com:8000/assets/img/chris_Gandolfo_Leaderboard.png");
		lobleadermap.put("OD Land",
				"http://solutionengineering.us.oracle.com:8000/assets/img/Joshua_Husk_Leaderboard.png");
	}

	public void setRepcount(String repcount) {
		this.repcount = repcount;
	}

	public String getRepcount() {
		return repcount;
	}

	public void setIconlink(String iconlink) {
		this.iconlink = iconlink;
	}

	public String getIconlink() {
		return iconlink;
	}

	public void setLob(String lob) {
		this.lob = lob;
		if (!lob.isEmpty())
			setIconlink(lobleadermap.get(lob));
	}

	public String getLob() {
		return lob;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapture_targets_identified() {
		return capture_targets_identified;
	}

	public void setCapture_targets_identified(String capture_targets_identified) {
		this.capture_targets_identified = capture_targets_identified;
	}

	public String getUnpiped_capture_opp_count() {
		return unpiped_capture_opp_count;
	}

	public void setUnpiped_capture_opp_count(String unpiped_capture_opp_count) {
		this.unpiped_capture_opp_count = unpiped_capture_opp_count;
	}

	public String getOpen_pipe_10_30() {
		return open_pipe_10_30;
	}

	public void setOpen_pipe_10_30(String open_pipe_10_30) {
		this.open_pipe_10_30 = open_pipe_10_30;
	}

	public String getUpside_pipe_40_50() {
		return upside_pipe_40_50;
	}

	public void setUpside_pipe_40_50(String upside_pipe_40_50) {
		this.upside_pipe_40_50 = upside_pipe_40_50;
	}

	public String getCommit_pipe_60_90() {
		return commit_pipe_60_90;
	}

	public void setCommit_pipe_60_90(String commit_pipe_60_90) {
		this.commit_pipe_60_90 = commit_pipe_60_90;
	}

	public String getPipeline_consulting_attach_opps() {
		return pipeline_consulting_attach_opps;
	}

	public void setPipeline_consulting_attach_opps(String pipeline_consulting_attach_opps) {
		this.pipeline_consulting_attach_opps = pipeline_consulting_attach_opps;
	}

	public String getWon_deals() {
		return won_deals;
	}

	public void setWon_deals(String won_deals) {
		this.won_deals = won_deals;
	}

	public String getWon_participation_rate() {
		return won_participation_rate;
	}

	public void setWon_participation_rate(String won_participation_rate) {
		this.won_participation_rate = won_participation_rate;
	}

	public String getWon_consulting_attach_opps() {
		return won_consulting_attach_opps;
	}

	public void setWon_consulting_attach_opps(String won_consulting_attach_opps) {
		this.won_consulting_attach_opps = won_consulting_attach_opps;
	}

	public String getNew_customers_with_consumption() {
		return new_customers_with_consumption;
	}

	public void setNew_customers_with_consumption(String new_customers_with_consumption) {
		this.new_customers_with_consumption = new_customers_with_consumption;
	}

	public String getCustomers_with_expansion_ucc() {
		return customers_with_expansion_ucc;
	}

	public void setCustomers_with_expansion_ucc(String customers_with_expansion_ucc) {
		this.customers_with_expansion_ucc = customers_with_expansion_ucc;
	}

	public String getCustomers_with_ucc_renewals() {
		return customers_with_ucc_renewals;
	}

	public void setCustomers_with_ucc_renewals(String customers_with_ucc_renewals) {
		this.customers_with_ucc_renewals = customers_with_ucc_renewals;
	}

	@Override
	public String toString() {
		return "Report [role=" + role + ", name=" + name + ", capture_targets_identified=" + capture_targets_identified
				+ ", unpiped_capture_opp_count=" + unpiped_capture_opp_count + ", open_pipe_10_30=" + open_pipe_10_30
				+ ", upside_pipe_40_50=" + upside_pipe_40_50 + ", commit_pipe_60_90=" + commit_pipe_60_90
				+ ", pipeline_consulting_attach_opps=" + pipeline_consulting_attach_opps + ", won_deals=" + won_deals
				+ ", won_participation_rate=" + won_participation_rate + ", won_consulting_attach_opps="
				+ won_consulting_attach_opps + ", new_customers_with_consumption=" + new_customers_with_consumption
				+ ", customers_with_expansion_ucc=" + customers_with_expansion_ucc + ", customers_with_ucc_renewals="
				+ customers_with_ucc_renewals + "]";
	}

	@Override
	public int compareTo(Report o) {
		return this.name.trim().toLowerCase().compareTo(o.getName().trim().toLowerCase());
	}

}
