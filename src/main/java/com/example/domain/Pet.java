package com.example.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

/**
 * = Pet
 *
 * TODO Auto-generated class documentation
 *
 */
@Entity
public class Pet {

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	@Id
	@SequenceGenerator(name = "petGen", sequenceName = "PET_SEQ")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "petGen")
	private Long id;

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	@Version
	private Integer version;

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	@NotNull
	private boolean sendReminders;

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	@NotNull
	@Size(min = 1)
	private String name;

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	@NotNull
	@Min(0L)
	@NumberFormat
	private Float weight;

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String ITERABLE_TO_ADD_CANT_BE_NULL_MESSAGE = "The given Iterable of items to add can't be null!";

	/**
	 * TODO Auto-generated attribute documentation
	 *
	 */
	public static final String ITERABLE_TO_REMOVE_CANT_BE_NULL_MESSAGE = "The given Iterable of items to add can't be null!";

	/**
	 * Gets id value
	 *
	 * @return Long
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Sets id value
	 *
	 * @param id
	 * @return Pet
	 */
	public Pet setId(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * Gets version value
	 *
	 * @return Integer
	 */
	public Integer getVersion() {
		return this.version;
	}

	/**
	 * Sets version value
	 *
	 * @param version
	 * @return Pet
	 */
	public Pet setVersion(Integer version) {
		this.version = version;
		return this;
	}

	/**
	 * Gets sendReminders value
	 *
	 * @return Boolean
	 */
	public boolean isSendReminders() {
		return this.sendReminders;
	}

	/**
	 * Sets sendReminders value
	 *
	 * @param sendReminders
	 * @return Pet
	 */
	public Pet setSendReminders(boolean sendReminders) {
		this.sendReminders = sendReminders;
		return this;
	}

	/**
	 * Gets name value
	 *
	 * @return String
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets name value
	 *
	 * @param name
	 * @return Pet
	 */
	public Pet setName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Gets weight value
	 *
	 * @return Float
	 */
	public Float getWeight() {
		return this.weight;
	}

	/**
	 * Sets weight value
	 *
	 * @param weight
	 * @return Pet
	 */
	public Pet setWeight(Float weight) {
		this.weight = weight;
		return this;
	}

	/**
	 * This `equals` implementation is specific for JPA entities and uses the entity
	 * identifier for it, following the article in
	 * https://vladmihalcea.com/2016/06/06/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
	 *
	 * @param obj
	 * @return Boolean
	 */
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		// instanceof is false if the instance is null
		if (!(obj instanceof Pet)) {
			return false;
		}
		return getId() != null && Objects.equals(getId(), ((Pet) obj).getId());
	}

	/**
	 * This `hashCode` implementation is specific for JPA entities and uses a fixed
	 * `int` value to be able to identify the entity in collections after a new id
	 * is assigned to the entity, following the article in
	 * https://vladmihalcea.com/2016/06/06/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
	 *
	 * @return Integer
	 */
	public int hashCode() {
		return 31;
	}

	/**
	 * TODO Auto-generated method documentation
	 *
	 * @return String
	 */
	public String toString() {
		return "Pet {" + "id='" + id + '\'' + ", version='" + version + '\'' + ", sendReminders='" + sendReminders
				+ '\'' + ", name='" + name + '\'' + ", weight='" + weight + '\'' + "}" + super.toString();
	}
}
