package com.example.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Pet;
import com.example.repository.PetRepository;

import io.springlets.data.domain.GlobalSearch;
import io.springlets.data.web.validation.MessageI18n;

/**
 * = PetServiceImpl
 *
 * TODO Auto-generated class documentation
 *
 */
@Service
@Transactional(readOnly = true)
public class PetService {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private PetRepository petRepository;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param petRepository
     */
    @Autowired
    public PetService(PetRepository petRepository) {
        setPetRepository(petRepository);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return PetRepository
     */
    public PetRepository getPetRepository() {
        return petRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param petRepository
     */
    public void setPetRepository(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param pet
     * @return Map
     */
    public Map<String, List<MessageI18n>> validate(Pet pet) {
        Map<String, List<MessageI18n>> messages = new java.util.HashMap<String, List<MessageI18n>>();
        // TODO: IMPLEMENT HERE THE VALIDATION OF YOUR ENTITY
        return messages;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param pet
     */
    @Transactional
    public void delete(Pet pet) {
        getPetRepository().delete(pet);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    @Transactional
    public List<Pet> save(Iterable<Pet> entities) {
        return getPetRepository().save(entities);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    @Transactional
    public void delete(Iterable<Long> ids) {
        List<Pet> toDelete = getPetRepository().findAll(ids);
        getPetRepository().deleteInBatch(toDelete);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Pet
     */
    @Transactional
    public Pet save(Pet entity) {
        return getPetRepository().save(entity);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Pet
     */
    public Pet findOne(Long id) {
        return getPetRepository().findOne(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Pet
     */
    public Pet findOneForUpdate(Long id) {
        return getPetRepository().findOneDetached(id);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public List<Pet> findAll(Iterable<Long> ids) {
        return getPetRepository().findAll(ids);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Pet> findAll() {
        return getPetRepository().findAll();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public long count() {
        return getPetRepository().count();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public Page<Pet> findAll(GlobalSearch globalSearch, Pageable pageable) {
        return getPetRepository().findAll(globalSearch, pageable);
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
        return getPetRepository().findAllByIdsIn(ids, globalSearch, pageable);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Pet> getEntityType() {
        return Pet.class;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Class
     */
    public Class<Long> getIdType() {
        return Long.class;
    }
}
