package com.timeSheet.service.impl;

import com.timeSheet.ModelDB.ClientDB;
import com.timeSheet.ModelDB.CountryDB;
import com.timeSheet.model.Client;
import com.timeSheet.model.Country;
import com.timeSheet.modelDTO.CountryDTO;
import com.timeSheet.modelDTO.RequestClientDTO;
import com.timeSheet.modelDTO.ResponseClientDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class MapService implements com.timeSheet.service.MapService {

    public ResponseClientDTO convertToClientDTO(Client client) {
        ResponseClientDTO clientDTO = new ResponseClientDTO();
        clientDTO.setId(client.getId());
        clientDTO.setName(client.getName());
        clientDTO.setAddress(client.getAddress());
        clientDTO.setCity(client.getCity());
        clientDTO.setCountryId(client.getCountryId());
        clientDTO.setPostalCode(client.getPostalCode());
        return clientDTO;
    }

    public List<ResponseClientDTO> convertToClientsDTO(List<Client> clients){
        List<ResponseClientDTO> clientsDTO = new ArrayList<>();
        for (Client client:clients
             ) {
            ResponseClientDTO responseClientDTO=convertToClientDTO(client);
            clientsDTO.add(responseClientDTO);
        }
        return  clientsDTO;
    }

    public List<CountryDTO> convertToCountriesDTO(List<Country> countries){
        List<CountryDTO> countriesDTO = new ArrayList<>();
        for (Country country:countries
        ) {
            CountryDTO countryDTO=new CountryDTO(country.getId(),country.getName());
            countriesDTO.add(countryDTO);
        }
        return  countriesDTO;
    }

    @Override
    public Client convertToClient(RequestClientDTO requestClientDTO) throws Exception {
        Client client = new Client(UUID.randomUUID(),requestClientDTO.getName(),requestClientDTO.getAddress(),
                    requestClientDTO.getCity(),requestClientDTO.getPostalCode(),requestClientDTO.getCountryId());
        return client;
    }

    @Override
    public List<Client> conevrtToClientsFromClientsDB(List<ClientDB> clientsDB) throws Exception {
        List<Client> clients = new ArrayList<>();
        for (ClientDB clientDB:clientsDB
             ) {
            clients.add(new Client(UUID.fromString(clientDB.getId()),clientDB.getName(),clientDB.getAddress(),
                    clientDB.getCity(),clientDB.getPostalCode(),clientDB.getCountryId()));
        }
        return clients;
    }

    @Override
    public ClientDB convertToClientDBFromClient(Client client) {
        return new ClientDB(client.getId().toString(),client.getName(),client.getAddress(),
                client.getCity(),client.getPostalCode(),client.getCountryId());
    }

    @Override
    public Client convertToClientFromClientDB(ClientDB clientDB) throws Exception {
        return new Client(UUID.fromString(clientDB.getId()),clientDB.getName(),clientDB.getAddress(),
                clientDB.getCity(),clientDB.getPostalCode(),clientDB.getCountryId());
    }

    @Override
    public List<Country> conevrtToCountriesFromCountriesDB(List<CountryDB> countriesDB) throws Exception {
        List<Country> countries=new ArrayList<>();
        for (CountryDB c:countriesDB
             ) {
            countries.add(new Country(UUID.fromString(c.getId()),c.getName()));
        }
        return countries;
    }


}
