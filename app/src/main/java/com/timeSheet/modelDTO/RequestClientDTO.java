package com.timeSheet.modelDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class RequestClientDTO implements Serializable {

    //@JsonProperty("name")
    private String name;
    //@JsonProperty("address")
    private String address;
    //@JsonProperty("city")
    private String city;
    //@JsonProperty("postalCode")
    private String postalCode;
    //@JsonProperty("country")
    private UUID countryId;

    public RequestClientDTO() {
        super();
    }
}
