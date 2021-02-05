package com.timeSheet.ModelDB;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@AllArgsConstructor
@Entity
@Table(name="countries")
public class CountryDB {

    @Id
    @Column(name = "country_id", unique = true, nullable = false)
    private String id;

    @Column(name = "country_name", unique = true, nullable = false)
    private String name;

    public CountryDB() {
        super();
    }
}
