package com.example.repository;

import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Pet;

import io.springlets.data.jpa.repository.DetachableJpaRepository;

/**
 * = PetRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Pet.class)
@Transactional(readOnly = true)
public interface PetRepository extends DetachableJpaRepository<Pet, Long>, PetRepositoryCustom {
}
