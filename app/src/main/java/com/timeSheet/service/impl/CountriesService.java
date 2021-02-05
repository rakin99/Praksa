package com.timeSheet.service.impl;

import com.timeSheet.modelDTO.CountryDTO;
import com.timeSheet.repository.CountriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountriesService implements com.timeSheet.service.CountriesService {

    @Autowired
    CountriesRepository countriesRepository;

    @Override
    public List<CountryDTO> findAll() throws Exception {
        return countriesRepository.findAll();
    }
}
