package com.timeSheet.modelDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class ResponseClientDTO {

	private UUID id;
	private String name;
	private String address;
	private String city;
	private String postalCode;
    private UUID countryId;

    public ResponseClientDTO() {
		super();
	}
}
