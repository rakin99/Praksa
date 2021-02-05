package com.timeSheet.modelDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class CountryDTO {

    private UUID id;
    private String name;
}
