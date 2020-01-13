package org.springframework.roo.petclinic.domain;
import org.springframework.roo.addon.jpa.annotations.test.RooJpaUnitTest;
import org.springframework.roo.petclinic.domain.dod.PetFactory;

import com.example.domain.Pet;

/**
 * = PetTest
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaUnitTest(targetClass = Pet.class)
public class PetTest {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private PetFactory petFactory = new PetFactory();

    /**
     * TODO Auto-generated method documentation
     *
     * @return PetFactory
     */
    public PetFactory getPetFactory() {
        return petFactory;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param petFactory
     */
    public void setPetFactory(PetFactory petFactory) {
        this.petFactory = petFactory;
    }
}
