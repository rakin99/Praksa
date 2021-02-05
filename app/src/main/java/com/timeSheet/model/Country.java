package com.timeSheet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Country {

    private UUID id;
    private String name;

    public Country(UUID id, String name) throws Exception {
        if(name.trim().equals("") || name==null){
            throw new Exception("The name must not be a null or an empty string!");
        }
        this.id = id;
        this.name = name;
    }
}
