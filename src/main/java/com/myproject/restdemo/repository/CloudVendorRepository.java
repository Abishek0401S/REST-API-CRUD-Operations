package com.myproject.restdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.restdemo.model.CloudVendor;

public interface CloudVendorRepository extends JpaRepository<CloudVendor ,String>{
	List<CloudVendor> findByVendorName(String vendorName);
}
