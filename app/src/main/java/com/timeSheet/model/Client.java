package com.timeSheet.model;

import lombok.Getter;
import org.springframework.lang.NonNull;

import java.util.UUID;

@Getter
public class Client {

    private UUID id;
    private String name;
    private String address;
    private String city;
    private String postalCode;
    private UUID countryId;

    public Client(UUID id, String name, String address, String city, String postalCode, UUID countryId) throws Exception {
        super();
        if(name.trim().equals("") || name==null){
            throw new Exception("The name must not be a null or an empty string!");
        }
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.postalCode = postalCode;
        this.countryId = countryId;
    }

    public void setCountry(UUID country) {
        this.countryId = countryId;
    }
}
