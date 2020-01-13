package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Pet;

/**
 * = PetRepository
 *
 * TODO Auto-generated class documentation
 *
 */

@Transactional(readOnly = true)
public interface PetRepository extends JpaRepository<Pet, Long> {
	
}