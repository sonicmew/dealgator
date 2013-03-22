package com.giventime.dealgator.persistence.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity
@Table(name="categories")
@Access(AccessType.FIELD)
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private boolean enabled;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="category_group_id")
	private CategoryGroup categoryGroup;

	public Category() {
		super();
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
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
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the categoryGroup
	 */
	public CategoryGroup getCategoryGroup() {
		return categoryGroup;
	}

	/**
	 * @param categoryGroup the categoryGroup to set
	 */
	public void setCategoryGroup(CategoryGroup categoryGroup) {
		this.categoryGroup = categoryGroup;
	}
   
}
