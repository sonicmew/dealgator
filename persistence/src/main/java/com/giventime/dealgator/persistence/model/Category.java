package com.giventime.dealgator.persistence.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity
@Table(name = "categories")
@Access(AccessType.FIELD)
public class Category implements Serializable {
	   
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private boolean enabled = true;
	
	private ArrayList<Deal> deals = new ArrayList<Deal>();
	
	private static final long serialVersionUID = 1L;

	public Category() {
		super();
	}   
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public boolean getEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
   
}
