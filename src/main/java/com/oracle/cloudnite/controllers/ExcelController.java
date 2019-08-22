package com.oracle.cloudnite.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.oracle.cloudnite.service.ExcelServiceImpl;

@RestController
@CrossOrigin
public class ExcelController {

	@Autowired
	private ExcelServiceImpl excelService;

	@PostMapping(path = "/excel/upload")
	public HashMap<String, String> uploadExcel(@RequestParam("excelfile") MultipartFile multipartFile)
			throws IOException {
		HashMap<String, String> excelUploadStatusMap = new HashMap<String, String>();
		excelUploadStatusMap = excelService.uploadExcelFile(multipartFile);
		return excelUploadStatusMap;
	}

	@GetMapping(path = { "/getreports", "/getreports/{name}/{role}/{lob}" }) /// {name}/{role}
	public List getReports(@PathVariable("name") Optional<String> name, @PathVariable("role") Optional<String> role,
			@PathVariable("lob") Optional<String> lob) { // @PathVariable("name")

		System.out.println("Name : " + name + "  Role : " + role+"  Lob : " + lob);

		return excelService.getReportsByName(name, role, lob);
	}

//	@GetMapping(path = "/getreports") /// {name}/{role}
//	public String getEVPReports(@PathVariable("name") String name, @PathVariable("role") String role) { // @PathVariable("name")
//
//		System.out.println("Name : " + name + "  Role : " + role);
//		excelService.getReportsByName(name, role);
//		return "Got you";
//	}
}
