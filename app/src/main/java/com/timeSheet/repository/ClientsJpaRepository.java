package com.timeSheet.repository;

import com.timeSheet.ModelDB.ClientDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface ClientsJpaRepository extends JpaRepository<ClientDB,String>{

    List<ClientDB> findAll();
    @Query("FROM ClientDB WHERE id LIKE :id")
    ClientDB findOne(@Param("id") String id);
    ClientDB save(ClientDB clientDB);
    void delete(ClientDB clientDB);
}
