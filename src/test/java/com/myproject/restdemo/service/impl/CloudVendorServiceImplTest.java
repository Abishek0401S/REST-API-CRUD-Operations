package com.myproject.restdemo.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.myproject.restdemo.model.CloudVendor;
import com.myproject.restdemo.repository.CloudVendorRepository;
import com.myproject.restdemo.service.CloudVendorService;

public class CloudVendorServiceImplTest {
	
	
	@Mock
	private CloudVendorRepository cloudVendorRepository;
	private CloudVendorService cloudVendorService;
	AutoCloseable autoCloseable;
	CloudVendor cloudVendor;
	
	
	
	@BeforeEach
	void setUp() {
		autoCloseable = MockitoAnnotations.openMocks(this);
		cloudVendorService = new CloudVendorServiceImpl(cloudVendorRepository);
		cloudVendor = new CloudVendor("01","Abishek","Vellore","8680875711");
	}
	
	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();
	}
	
	@Test
	void testCreateCloudVendor() {
		mock(CloudVendor.class);
		mock(CloudVendorRepository.class);
		
		when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
		assertThat(cloudVendorService.createCloudVendor(cloudVendor)).isEqualTo("Success");
	}
	
	@Test
	void testUpdateCloudVendor() {
		mock(CloudVendor.class);
		mock(CloudVendorRepository.class);
		
		when(cloudVendorRepository.save(cloudVendor)).thenReturn(cloudVendor);
		assertThat(cloudVendorService.updateCloudVendor(cloudVendor)).isEqualTo("Success");
	}
	
	@Test
	void testGetCloudVendor() {
		 mock(CloudVendor.class);
	        mock(CloudVendorRepository.class);

	        when(cloudVendorRepository.findById("01")).thenReturn(Optional.ofNullable(cloudVendor));
	        assertThat(cloudVendorService.getCloudVendor("01").getVendorName())
            .isEqualTo(cloudVendor.getVendorName());
}
	
	@Test
	void testGetByVendorName() {
		mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.findByVendorName("Abishek")).
                thenReturn(new ArrayList<CloudVendor>(Collections.singleton(cloudVendor)));

        assertThat(cloudVendorService.getByVendorName("Abishek").get(0).getVendorId()).
                isEqualTo(cloudVendor.getVendorId());
	}
	
	
	
	@Test
	void testGetAllCloudVendor(){
		mock(CloudVendor.class);
        mock(CloudVendorRepository.class);

        when(cloudVendorRepository.findAll()).thenReturn(new ArrayList<CloudVendor>(
                Collections.singleton(cloudVendor)
        ));

        assertThat(cloudVendorService.getAllCloudVendors().get(0).getVendorPhoneNumber()).
                isEqualTo(cloudVendor.getVendorPhoneNumber());
	}
	
	@Test
    void testDeleteCloudVendor() {
        mock(CloudVendor.class);
        mock(CloudVendorRepository.class, Mockito.CALLS_REAL_METHODS);

        doAnswer(Answers.CALLS_REAL_METHODS).when(cloudVendorRepository)
                .deleteById(any());
        assertThat(cloudVendorService.deleteCloudVendor("01")).isEqualTo("Success");
    }
	
}
