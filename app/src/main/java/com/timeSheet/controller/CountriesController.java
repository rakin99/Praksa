package com.timeSheet.controller;

import java.util.List;

import com.timeSheet.modelDTO.CountryDTO;
import com.timeSheet.service.CountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(value = "/countries")
public class CountriesController {

	@Autowired
	CountriesService countriesService;

	@GetMapping
	public ResponseEntity<List<CountryDTO>> getCountry() throws Exception {
		return ResponseEntity.ok().body(countriesService.findAll());
	}
}
