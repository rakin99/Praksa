package com.timeSheet.service;

import com.timeSheet.ModelDB.ClientDB;
import com.timeSheet.ModelDB.CountryDB;
import com.timeSheet.model.Client;
import com.timeSheet.model.Country;
import com.timeSheet.modelDTO.CountryDTO;
import com.timeSheet.modelDTO.RequestClientDTO;
import com.timeSheet.modelDTO.ResponseClientDTO;

import java.util.List;

public interface MapService {
    ResponseClientDTO convertToClientDTO(Client client);
    List<ResponseClientDTO> convertToClientsDTO(List<Client> clients);
    List<CountryDTO> convertToCountriesDTO(List<Country> countries);
    Client convertToClient(RequestClientDTO requestClientDTO) throws Exception;
    List<Client> conevrtToClientsFromClientsDB(List<ClientDB> clientDBS) throws Exception;
    ClientDB convertToClientDBFromClient(Client client);
    Client convertToClientFromClientDB(ClientDB clientDB) throws Exception;
    List<Country> conevrtToCountriesFromCountriesDB(List<CountryDB> countriesDB) throws Exception;
}
