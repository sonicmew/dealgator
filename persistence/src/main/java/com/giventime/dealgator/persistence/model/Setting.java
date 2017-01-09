package com.giventime.dealgator.persistence.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Setting
 *
 */
@Entity
@Access(AccessType.FIELD)
@Table(name = "settings")
public class Setting implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public Setting() {
		super();
	}
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String value;
	
	private boolean required = false;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the required
	 */
	public boolean isRequired() {
		return required;
	}

	/**
	 * @param required the required to set
	 */
	public void setRequired(boolean required) {
		this.required = required;
	}
   
}
