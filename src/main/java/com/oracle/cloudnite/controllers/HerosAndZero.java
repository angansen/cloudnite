package com.oracle.cloudnite.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.cloudnite.model.HerosAndZeros;
import com.oracle.cloudnite.service.HerosAndZerosService;

@RestController
@CrossOrigin
public class HerosAndZero {
	@Autowired
	private HerosAndZerosService herosAndZerosService;

	@GetMapping(path = "/heros-zeros")
	public HashMap<String, List<HerosAndZeros>> getHerosAndZeros() {
		return herosAndZerosService.getHerosAndZerosData();
	
	}
}
