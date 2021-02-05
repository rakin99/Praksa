package com.timeSheet.repository.impl;

import com.timeSheet.model.Country;
import com.timeSheet.modelDTO.CountryDTO;
import com.timeSheet.repository.CountriesJpaRepository;
import com.timeSheet.service.impl.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class CountriesRepository implements com.timeSheet.repository.CountriesRepository {

    /*public static List<Country> countries=new ArrayList<>();
    static {
        UUID id1=UUID.fromString("c57ed59e-45f6-11eb-b378-0242ac130002");
        UUID id2=UUID.fromString("c57ed7ec-45f6-11eb-b378-0242ac130002");
        UUID id3=UUID.fromString("c57eda6c-45f6-11eb-b378-0242ac130002");
        UUID id4=UUID.fromString("c57edb52-45f6-11eb-b378-0242ac130002");
        try {
            Country c1 = new Country(id1,"Serbia");
            Country c2=new Country(id2,"USA");
            Country c3=new Country(id3,"England");
            Country c4=new Country(id4,"Canada");

            countries.add(c1);
            countries.add(c2);
            countries.add(c3);
            countries.add(c4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    @Autowired
    MapService mapService;

    @Autowired
    CountriesJpaRepository countriesJpaRepository;

    @Override
    public List<CountryDTO> findAll() throws Exception {
        return mapService.convertToCountriesDTO(mapService.conevrtToCountriesFromCountriesDB(countriesJpaRepository.findAll()));
    }
}
