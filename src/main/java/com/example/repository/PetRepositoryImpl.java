package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustomImpl;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Pet;
import com.example.domain.QPet;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.JPQLQuery;

import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.jpa.repository.support.QueryDslRepositorySupportExt;

/**
 * = PetRepositoryImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustomImpl(repository = PetRepositoryCustom.class)
@Transactional(readOnly = true)
public class PetRepositoryImpl extends QueryDslRepositorySupportExt<Pet> implements PetRepositoryCustom {

	/**
	 * Default constructor
	 */
	PetRepositoryImpl() {
		super(Pet.class);
	}

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String SEND_REMINDERS = "sendReminders";

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String WEIGHT = "weight";

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String TYPE = "type";

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String NAME = "name";

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param globalSearch
	 * @param pageable
	 * @return Page
	 */
	public Page<Pet> findAll(GlobalSearch globalSearch, Pageable pageable) {
		QPet pet = QPet.pet;
		JPQLQuery<Pet> query = from(pet);
		Path<?>[] paths = new Path<?>[] { pet.sendReminders, pet.name, pet.weight, pet.type };
		applyGlobalSearch(globalSearch, query, paths);
		AttributeMappingBuilder mapping = buildMapper().map(SEND_REMINDERS, pet.sendReminders).map(NAME, pet.name)
				.map(WEIGHT, pet.weight).map(TYPE, pet.type);
		applyPagination(pageable, query, mapping);
		applyOrderById(query);
		return loadPage(query, pageable, pet);
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @param ids
	 * @param globalSearch
	 * @param pageable
	 * @return Page
	 */
	public Page<Pet> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable) {
		QPet pet = QPet.pet;
		JPQLQuery<Pet> query = from(pet);
		Path<?>[] paths = new Path<?>[] { pet.sendReminders, pet.name, pet.weight, pet.type };
		applyGlobalSearch(globalSearch, query, paths);
		// Also, filter by the provided ids
		query.where(pet.id.in(ids));
		AttributeMappingBuilder mapping = buildMapper().map(SEND_REMINDERS, pet.sendReminders).map(NAME, pet.name)
				.map(WEIGHT, pet.weight).map(TYPE, pet.type);
		applyPagination(pageable, query, mapping);
		applyOrderById(query);
		return loadPage(query, pageable, pet);
	}
}
