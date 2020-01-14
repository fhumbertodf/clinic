package com.example.config.jackson;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDomainModelModule;

import com.example.domain.Pet;
import com.example.web.PetJsonMixin;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * = DomainModelModule
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDomainModelModule
@JsonComponent
public class DomainModelModule extends SimpleModule {

	private static final long serialVersionUID = 1L;

	/**
	 * TODO Auto-generated constructor documentation
	 *
	 */
	public DomainModelModule() {
		// Mixin registration
		setMixInAnnotation(Pet.class, PetJsonMixin.class);
	}
}
