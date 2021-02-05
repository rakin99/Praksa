package com.timeSheet;

import com.timeSheet.model.Client;
import com.timeSheet.modelDTO.RequestClientDTO;
import com.timeSheet.modelDTO.ResponseClientDTO;
import com.timeSheet.repository.impl.ClientsRepository;
import com.timeSheet.service.MapService;
import com.timeSheet.service.impl.ClientsService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class ClientsServiceTest {

    @Mock
    private ClientsRepository clientsRepository;

    @Mock
    private MapService mapService;

    @InjectMocks
    ClientsService clientsService;

    @Test
    public void findById_client_when_id_exist_return_responseClientDTO() throws Exception {
        UUID id=UUID.randomUUID();
        when(clientsRepository.findById(id)).thenReturn(new Client(id,"Mika","Address","City","PostalCode",id));
        ResponseClientDTO responseClientDTO=clientsService.findById(id);
        //verify(clientsRepository, times(1)).findById(id);
        Assert.assertTrue(responseClientDTO!=null && responseClientDTO.getId().equals(id));
    }

    @Test
    public void findById_client_when_id_notExist_return_null() throws Exception {
        UUID id=UUID.randomUUID();
        when(clientsRepository.findById(id)).thenReturn(null);
        ResponseClientDTO responseClientDTO=clientsService.findById(id);
        //verify(clientsRepository, times(1)).findById(id);
        Assert.assertNull(responseClientDTO);
    }

    @Test
    public void save_client_when_name_isValid_return_id() throws Exception {
        UUID id=UUID.randomUUID();
        Client client=new Client(id,"Mika","Address","City","PostalCode",id);
        RequestClientDTO requestClientDTO = new RequestClientDTO("Mika","Address","City","PostalCode",id);
        when(mapService.convertToClient(any(RequestClientDTO.class))).thenReturn(client);
        when(clientsRepository.save(any(Client.class))).thenReturn(client);
        UUID idClient = clientsService.save(requestClientDTO);
        verify(clientsRepository, times(1)).save(client);
        Assert.assertTrue(id.equals(idClient));
    }

    @Test(expected = Exception.class)
    public void save_client_when_name_isNotValid_return_exeption() throws Exception {
        //ResponseClientDTO client=new ResponseClientDTO(1,"","Address","City","PostalCode","Country");
        RequestClientDTO requestClientDTO = new RequestClientDTO("","Address","City","PostalCode",UUID.randomUUID());
        when(mapService.convertToClient(any(RequestClientDTO.class))).thenReturn(new Client(UUID.randomUUID(),requestClientDTO.getName(),requestClientDTO.getAddress(),requestClientDTO.getCity(),requestClientDTO.getPostalCode(),requestClientDTO.getCountryId()));

        clientsService.save(requestClientDTO);
        //verify(clientsRepository, times(1)).save(requestClientDTO);
    }

    @Test
    public void update_client_when_id_exist_and_clientRequest_isValid() throws Exception {
        UUID id=UUID.randomUUID();
        UUID id2=UUID.randomUUID();
        Client client = new Client(id,"Mika", "Address","City","PostalCode",id2);
        RequestClientDTO requestClientDTO = new RequestClientDTO("Mika","Address","City","PostalCode",id2);
        when(mapService.convertToClient(any(RequestClientDTO.class))).thenReturn(client);
        clientsService.update(id,requestClientDTO);
        verify(clientsRepository, times(1)).update(client,id);
    }

    @Test
    public void update_client_when_id_notExist_and_clientRequest_isValid() throws Exception {
        UUID id=UUID.randomUUID();
        RequestClientDTO requestClientDTO = new RequestClientDTO("Mika","Address","City","PostalCode",id);
        try {
            clientsService.update(id,requestClientDTO);
        }catch (Throwable e){
            Assert.assertTrue(e instanceof Exception);
            Assert.assertEquals(e.getMessage(), "I can't find a user!");
        }
    }

    @Test
    public void update_client_when_id_exist_and_clientRequest_isNotValid() throws Exception {
        UUID id=UUID.randomUUID();
        RequestClientDTO requestClientDTO = new RequestClientDTO("","Address","City","PostalCode",id);
        try {
            clientsService.update(id,requestClientDTO);
        }catch (Throwable e){
            Assert.assertTrue(e instanceof Exception);
            Assert.assertEquals(e.getMessage(), "The name must not be a null or an empty string!");
        }
        //verify(clientsRepository, times(1)).update(requestClientDTO,id);
    }

    @Test
    public void delete_client_when_id_exist() {
        UUID id=UUID.randomUUID();
        when(clientsRepository.delete(id)).thenReturn(true);
        boolean canDelete=clientsService.delete(id);
        //verify(clientsRepository, times(1)).delete(id);
        Assert.assertTrue(canDelete == true);
    }

    @Test
    public void delete_client_when_id_noExist() {
        UUID id=UUID.randomUUID();
        when(clientsRepository.delete(id)).thenReturn(false);
        boolean canDelete=clientsService.delete(id);
        //verify(clientsRepository, times(1)).delete(id);
        Assert.assertTrue(canDelete == false);
    }
}
