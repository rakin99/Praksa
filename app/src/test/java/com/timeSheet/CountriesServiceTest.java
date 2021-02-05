package com.timeSheet;

import com.timeSheet.modelDTO.ResponseClientDTO;
import com.timeSheet.repository.impl.ClientsRepository;
import com.timeSheet.repository.impl.CountriesRepository;
import com.timeSheet.service.impl.ClientsService;
import com.timeSheet.service.impl.CountriesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CountriesServiceTest {

    @Mock
    private CountriesRepository countriesRepository;

    @InjectMocks
    CountriesService countriesService;

    @Test
    public void findAll_countries_return_list_CountriesDTO() throws Exception {
        when(countriesRepository.findAll()).thenReturn(new ArrayList<>());
        countriesService.findAll();
        verify(countriesRepository, times(1)).findAll();
    }
}
