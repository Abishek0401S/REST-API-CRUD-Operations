package com.myproject.restdemo.controller;


import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.myproject.restdemo.Controller.CloudVendorController;
import com.myproject.restdemo.model.CloudVendor;
import com.myproject.restdemo.service.CloudVendorService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@WebMvcTest(CloudVendorController.class)
public class CloudVendorControllerTest {
	
	private MockMvc mockMvc;
	
	@MockBean
	private CloudVendorService cloudVendorService;
	CloudVendor cloudVendorOne;
	CloudVendor cloudVendorTwo;
	List<CloudVendor> cloudVendorList = new ArrayList<>();
	
	@BeforeEach
	void setUp() {
		cloudVendorOne = new CloudVendor("01", "Abishek", "Vellore", "8680875711");
		cloudVendorTwo = new CloudVendor("02", "Abi", "Vellore", "8680875722");
		cloudVendorList.add(cloudVendorOne);
		cloudVendorList.add(cloudVendorTwo);
	}
	
	@AfterEach
	void tearDown() {
		
	}
	
	@Test
	void testGetCloudVendorDetails() throws Exception{
		when(cloudVendorService.getCloudVendor("01")).thenReturn(cloudVendorOne);
		this.mockMvc.perform(get("/cloudvendor/01")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
    void testGetAllCloudVendorDetails() throws  Exception {
		when(cloudVendorService.getAllCloudVendors()).thenReturn(cloudVendorList);
		this.mockMvc.perform(get("/cloudvendor")).andDo(print()).andExpect(status().isOk());
        
    }
	

	@Test
	 void testCreateCloudVendorDetails() throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(cloudVendorOne);
        
		when(cloudVendorService.createCloudVendor(cloudVendorOne)).thenReturn("Success");
        this.mockMvc.perform(post("/cloudvendor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print()).andExpect(status().isOk());
	 }
	 
	 @Test
	 void testUpdateCloudVendorDetails() throws Exception {
		 ObjectMapper mapper = new ObjectMapper();
	        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
	        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
	        String requestJson=ow.writeValueAsString(cloudVendorOne);

	        when(cloudVendorService.updateCloudVendor(cloudVendorOne))
	                .thenReturn("Cloud Vendor Updated Successfully");
	        this.mockMvc.perform(put("/cloudvendor")
	                        .contentType(MediaType.APPLICATION_JSON)
	                        .content(requestJson))
	                .andDo(print()).andExpect(status().isOk());
	 }
	 
	 @Test
	 void testDeleteCloudVendorDetails() throws Exception {
		 when(cloudVendorService.deleteCloudVendor("01")).thenReturn("Cloud Vendor Deleted Successfully");
		 this.mockMvc.perform(delete("/cloudvendor/" + "01")).andDo(print()).andExpect(status().isOk());


	 }
}
