package com.timeSheet.service;

import com.timeSheet.modelDTO.CountryDTO;

import java.util.List;

public interface CountriesService {
    List<CountryDTO> findAll() throws Exception;
}
