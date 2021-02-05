package com.timeSheet.service.impl;

import com.timeSheet.model.Client;
import com.timeSheet.modelDTO.RequestClientDTO;
import com.timeSheet.modelDTO.ResponseClientDTO;
import com.timeSheet.repository.ClientsJpaRepository;
import com.timeSheet.repository.ClientsRepository;
import com.timeSheet.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientsService implements com.timeSheet.service.ClientsService {

    @Autowired
    private ClientsRepository clientsRepository;

    @Autowired
    private MapService mapService;

    public List<ResponseClientDTO> findAll() throws Exception {
        return mapService.convertToClientsDTO(clientsRepository.findAll());
    }

    public ResponseClientDTO findById(UUID id) throws Exception {
        return mapService.convertToClientDTO(clientsRepository.findById(id));
    }

    public UUID save(RequestClientDTO requestClientDTO) throws Exception {
        Client client=clientsRepository.save(mapService.convertToClient(requestClientDTO));
        return client.getId();
    }

    public void update(UUID id, RequestClientDTO requestClientDTO) throws Exception {
        clientsRepository.update(mapService.convertToClient(requestClientDTO),id);
    }

    public boolean delete(UUID id){
        boolean canFind = clientsRepository.delete(id);
        return canFind;
    }
}
