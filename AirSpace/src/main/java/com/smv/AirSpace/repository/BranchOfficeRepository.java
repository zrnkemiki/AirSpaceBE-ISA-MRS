package com.smv.AirSpace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smv.AirSpace.model.BranchOffice;

@org.springframework.stereotype.Repository
public interface BranchOfficeRepository extends JpaRepository<BranchOffice, Long> {

}
