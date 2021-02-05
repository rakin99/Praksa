package com.timeSheet.repository;

import com.timeSheet.ModelDB.CountryDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CountriesJpaRepository extends JpaRepository<CountryDB,String> {
    List<CountryDB> findAll();
}
