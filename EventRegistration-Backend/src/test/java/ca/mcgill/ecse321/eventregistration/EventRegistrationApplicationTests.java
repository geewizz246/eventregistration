package ca.mcgill.ecse321.eventregistration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.eventregistration.dao.EventRepository;
import ca.mcgill.ecse321.eventregistration.dao.PersonRepository;
import ca.mcgill.ecse321.eventregistration.dao.RegistrationRepository;
import ca.mcgill.ecse321.eventregistration.service.EventRegistrationService;
import ca.mcgill.ecse321.eventregistration.controller.EventRegistrationRestController;
import ca.mcgill.ecse321.eventregistration.model.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventRegistrationApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Mock
	private PersonRepository personDao;
	@Mock
	private EventRepository eventDao;
	@Mock
	private RegistrationRepository registrationDao;
	
	@InjectMocks
	private EventRegistrationService service;
	
	@Mock
	private EventRegistrationService serviceMock;
	
	@InjectMocks
	private EventRegistrationRestController controller;
	
	private Person person;
	private static final String PERSON_KEY = "TestPerson";
	private static final String NONEXISTING_KEY = "NotAPerson";
	
	@Before
	public void setMockOutput() {
		when(personDao.findPersonByName(anyString())).thenAnswer( (InvocationOnMock invocation) -> {
			if(invocation.getArgument(0).equals(PERSON_KEY)) {
				Person person = new Person();
				person.setName(PERSON_KEY);
				return person;
			} else {
				return null;
			}
		});
	}
	
	@Before
	public void setupMock() {
		person = mock(Person.class);
	}

	@Test
	public void testMockPersonCreation() {
		assertNotNull(person);
	}

	@Test
	public void testParticipantQueryFound() {
	  assertEquals(PERSON_KEY, service.getPerson(PERSON_KEY).getName());
	}

}

