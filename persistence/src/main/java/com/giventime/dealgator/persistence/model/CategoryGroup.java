package com.giventime.dealgator.persistence.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: CategoryGroup
 *
 */
@Entity
@Table(name = "category_groups")
@Access(AccessType.FIELD)
public class CategoryGroup implements Serializable {
	   
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private boolean enabled = true;
	
	@OneToMany(mappedBy="categoryGroup")
	private List<Category> categories = new ArrayList<Category>();
	
	@ManyToMany
	private List<Deal> deals;
	
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public CategoryGroup() {
		super();
	}   
	
	/**
	 * 
	 * @return
	 */
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
	
	/**
	 * @return the categories
	 */
	public List<Category> getCategories() {
		return categories;
	}

	/**
	 * @param categories the categories to set
	 */
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	/**
	 * @return the deals
	 */
	public List<Deal> getDeals() {
		return deals;
	}
	
	/**
	 * @param deals the deals to set
	 */
	public void setDeals(List<Deal> deals) {
		this.deals = deals;
	}
   
}
