package com.volunteer.management;

import com.volunteer.management.repository.VolunteerRepo;
import com.volunteer.management.service.RegistrationServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ManagementApplicationTests {

	@Autowired
	private RegistrationServiceImpl service;

	@MockBean
	private VolunteerRepo repo;

	@Test
	void contextLoads() {
	}

}
