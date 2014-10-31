package com.giventime.dealgator.persistence.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: DealPropertyInfo
 *
 */
@Entity
@Table(name = "deal_properties")
@Access(AccessType.FIELD)
public class DealProperty implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	private String name;
	
	@Column(length=10000)
	private String value;
	
	public DealProperty() {
		super();
	}
	
	/**
	 * 
	 * @param name
	 * @param value
	 */
	public DealProperty(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}

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
   
}
