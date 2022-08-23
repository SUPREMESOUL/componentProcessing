package com.componentProcessing.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.componentProcessing.Models.ProcessRequest;

public interface ProcessRequestRepo extends JpaRepository<ProcessRequest, Integer> {

}
