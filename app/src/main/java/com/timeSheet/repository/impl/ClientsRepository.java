package com.timeSheet.repository.impl;

import com.timeSheet.ModelDB.ClientDB;
import com.timeSheet.model.Client;
import com.timeSheet.repository.ClientsJpaRepository;
import com.timeSheet.service.impl.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ClientsRepository implements com.timeSheet.repository.ClientsRepository {

    @Autowired
    ClientsJpaRepository clientsJpaRepository;

    @Autowired
    MapService mapService;

    @Override
    public List<Client> findAll() throws Exception {
        //System.out.println("Find all");
        return mapService.conevrtToClientsFromClientsDB(clientsJpaRepository.findAll());
    }

    @Override
    public Client findById(UUID id) throws Exception {
        Client client = mapService.convertToClientFromClientDB(clientsJpaRepository.findOne(id.toString()));
        return client;
    }

    @Override
    public Client save(Client client) throws Exception {
        //System.out.println("Save");
        UUID id = UUID.randomUUID();
        //System.out.println("Id: "+id);
        Client newClient = new Client(id,client.getName(),client.getAddress(),
                                        client.getCity(),client.getPostalCode(),client.getCountryId());
        clientsJpaRepository.save(mapService.convertToClientDBFromClient(newClient));
        return newClient;
    }

    @Override
    public void update(Client client,UUID id) throws Exception {
        //System.out.println("Update "+client.getCountryId());
        Client updateClient = mapService.convertToClientFromClientDB(clientsJpaRepository.findOne(id.toString()));
        if(updateClient==null){
            throw new Exception("I can't find a user!");
        }
        //clientsJpaRepository.delete(mapService.convertToClientDBFromClient(updateClient));
        clientsJpaRepository.save(mapService.convertToClientDBFromClient(new Client(updateClient.getId(),client.getName(),client.getAddress(),
                client.getCity(), client.getPostalCode(),
                client.getCountryId())));
    }

    @Override
    public boolean delete(UUID id) {
        //System.out.println("Delete: "+id);
        boolean canFind = false;
        ClientDB clientDB = clientsJpaRepository.findOne(id.toString());
        if(clientDB!=null){
            //System.out.println("Pronasao sam korisnika!");
            canFind=true;
            clientsJpaRepository.delete(clientDB);
        }
        return canFind;
    }
}
