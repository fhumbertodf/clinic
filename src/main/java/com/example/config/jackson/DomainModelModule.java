package com.example.config.jackson;

import org.springframework.boot.jackson.JsonComponent;

import com.example.domain.Pet;
import com.example.web.PetJsonMixin;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * = DomainModelModule
 *
 * TODO Auto-generated class documentation
 *
 */
@JsonComponent
public class DomainModelModule extends SimpleModule {

	/**
	 * TODO Auto-generated constructor documentation
	 *
	 */
	public DomainModelModule() {
		// Mixin registration
		setMixInAnnotation(Pet.class, PetJsonMixin.class);
	}
}
