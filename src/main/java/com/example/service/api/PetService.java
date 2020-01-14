package com.example.service.api;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;

import com.example.domain.Pet;

import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = PetService
 *
 * TODO Auto-generated class documentation
 *
 */
@RooService(entity = Pet.class)
public interface PetService extends EntityResolver<Pet, Long>, ValidatorService<Pet> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Pet
     */
    public abstract Pet findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param pet
     */
    public abstract void delete(Pet pet);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<Pet> save(Iterable<Pet> entities);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    public abstract void delete(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Pet
     */
    public abstract Pet save(Pet entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Pet
     */
    public abstract Pet findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<Pet> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<Pet> findAll();

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public abstract long count();

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Pet> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Pet> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);
}
