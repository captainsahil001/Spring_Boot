package com.myprojects.rest_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myprojects.rest_demo.model.CloudVendor;
import java.util.List;


public interface CloudVendorRepository extends JpaRepository<CloudVendor, String> {
    List<CloudVendor> findByVendorName(String vendorName);

}
