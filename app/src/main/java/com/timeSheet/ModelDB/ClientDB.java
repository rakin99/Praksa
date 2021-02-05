package com.timeSheet.ModelDB;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Entity
@Table(name="clients")
public class ClientDB {

    @Id
    @Column(name = "client_id", unique = true, nullable = false)
    private String id;

    @Column(name = "client_name", unique = true, nullable = false)
    private String name;

    @Column(name = "client_address", unique = false, nullable = true)
    private String address;

    @Column(name = "client_city", unique = false, nullable = true)
    private String city;

    @Column(name = "client_postal_code", unique = false, nullable = true)
    private String postalCode;

    @Column(name = "client_country_id", unique = false, nullable = true)
    private UUID countryId;

    public ClientDB() {
        super();
    }

    @Override
    public String toString() {
        return "ClientDB{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", countryId=" + countryId +
                '}';
    }
}
