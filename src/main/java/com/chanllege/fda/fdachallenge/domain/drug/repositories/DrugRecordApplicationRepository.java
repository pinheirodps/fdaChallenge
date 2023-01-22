package com.chanllege.fda.fdachallenge.domain.drug.repositories;

import com.chanllege.fda.fdachallenge.domain.drug.entities.DrugRecordApplication;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Drug record application repository.
 */
public interface DrugRecordApplicationRepository extends JpaRepository<DrugRecordApplication, String> {
}
