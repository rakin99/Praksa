package com.timeSheet.repository;

import com.timeSheet.model.Country;
import com.timeSheet.modelDTO.CountryDTO;

import java.util.List;

public interface CountriesRepository {
    List<CountryDTO> findAll() throws Exception;
}
