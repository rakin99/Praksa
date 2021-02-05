package com.timeSheet.service;

import com.timeSheet.modelDTO.RequestClientDTO;
import com.timeSheet.modelDTO.ResponseClientDTO;

import java.util.List;
import java.util.UUID;

public interface ClientsService {
    ResponseClientDTO findById(UUID id) throws Exception;
    List<ResponseClientDTO> findAll() throws Exception;
    void update(UUID id, RequestClientDTO requestClientDTO) throws Exception;
    UUID save(RequestClientDTO requestClientDTO) throws Exception;
    boolean delete (UUID id);
}
