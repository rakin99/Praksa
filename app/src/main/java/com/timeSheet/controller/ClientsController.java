package com.timeSheet.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import com.timeSheet.modelDTO.RequestClientDTO;
import com.timeSheet.service.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.timeSheet.modelDTO.ResponseClientDTO;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin(origins = "*", maxAge = 3600,methods = {	RequestMethod.DELETE,
														RequestMethod.GET,
														RequestMethod.PUT,
														RequestMethod.POST})
@RestController
@RequestMapping(value = "/clients")
public class ClientsController {

	@Autowired
	ClientsService clientsService;

	@GetMapping
	public ResponseEntity<List<ResponseClientDTO>> getClients() throws Exception {
		return ResponseEntity.ok().body(clientsService.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ResponseClientDTO> getClient(@PathVariable("id") UUID id) throws Exception {
		ResponseClientDTO responseClientDTO=clientsService.findById(id);
		if(responseClientDTO!=null){
			return ResponseEntity.ok().body(responseClientDTO);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<ResponseClientDTO> addClient(@RequestBody RequestClientDTO requestClientDTO, UriComponentsBuilder builder) {
		try {
			UUID clientId = UUID.randomUUID();
			clientId = clientsService.save(requestClientDTO);
			URI location = builder.replacePath("/clients/{id}").buildAndExpand(clientId).toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception e) {
			return ResponseEntity.unprocessableEntity().build();
		}
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> editClient(@PathVariable("id") UUID id ,@RequestBody RequestClientDTO requestClientDTO){
		try {
			clientsService.update(id,requestClientDTO);
			return  ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteClient(@PathVariable("id") UUID id){
		boolean canFind = clientsService.delete(id);
		if(canFind){
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
}
