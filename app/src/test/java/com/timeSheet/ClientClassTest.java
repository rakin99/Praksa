package com.timeSheet;

import com.timeSheet.model.Client;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.UUID;

import org.junit.runners.Parameterized.Parameter;

@SpringBootTest
@RunWith(Parameterized.class)
public class ClientClassTest {

	@Parameter(0)
	public String name;
	@Parameter(1)
	public String address;
	@Parameter(2)
	public String city;
	@Parameter(3)
	public String postalCode;
	@Parameter(4)
	public UUID countryId;


	@Parameters
	public static Iterable<Object[]> dataWithName() {
		UUID countryId = UUID.randomUUID();
		return Arrays.asList(new Object[][] { 	{ null , "Address", "City", "PostalCode", countryId},
												{ "" , "", "City", "PostalCode", countryId },
												{ "" , "Address", "", "PostalCode", countryId },
												{ "     " , "Address", "City", "", countryId },
												{ null , null, "City", "PostalCode", countryId },
												{ "  " , "Address", null, "PostalCode", countryId },
												{ null , "Address", "City", null, countryId },
												{ "" , "Address", "City", "PostalCode", null }
		});
	}

	@Test
	public void Constuctor_WhenNameIsValid_ReturnsNewObject() throws Exception {
		Client client = new Client(UUID.randomUUID(),"Mika",address,city,postalCode,countryId);
		Assert.assertNotNull("Client: "+client.getName(),client);
	}

	@Test(expected = Exception.class)
	public void Constructor_WhenNameIsNotValid_ThrowsArgumentException() throws Exception {
		Client client=new Client(UUID.randomUUID(),name,address,city,postalCode,countryId);
	}
}
