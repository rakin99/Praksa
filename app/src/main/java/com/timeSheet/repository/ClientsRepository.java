package com.timeSheet.repository;
import com.timeSheet.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface ClientsRepository{

    List<Client> findAll() throws Exception;

    Client findById(UUID id) throws Exception;

    Client save(Client client) throws Exception;

    void update(Client client,UUID id) throws Exception;

    boolean delete(UUID id);
}
