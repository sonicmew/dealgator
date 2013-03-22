package com.giventime.dealgator.persistence.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Deal
 *
 */
@Entity
@Table(name = "deals")
public class Deal implements Serializable {

	private static final long serialVersionUID = 1L;

	public Deal() {
		super();
	}
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany
	private List<DealProperty> properties = new ArrayList<DealProperty>();
	
	@ManyToMany(mappedBy="deals")
	private List<CategoryGroup> categoryGroups;
	
	//@Column(nullable = false)
	//private Shop shop;

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
	 * @return the properties
	 */
	public List<DealProperty> getProperties() {
		return properties;
	}

	/**
	 * @param properties the properties to set
	 */
	public void setProperties(List<DealProperty> properties) {
		this.properties = properties;
	}

	/**
	 * @return the categoryGroup
	 */	
	public List<CategoryGroup> getCategoryGroups() {
		return categoryGroups;
	}

	/**
	 * @param categoryGroup the categoryGroup to set
	 */
	public void setCategoryGroup(List<CategoryGroup> categoryGroups) {
		this.categoryGroups = categoryGroups;
	}

//	/**
//	 * @return the shop
//	 */
//	public Shop getShop() {
//		return shop;
//	}
//
//	/**
//	 * @param shop the shop to set
//	 */
//	public void setShop(Shop shop) {
//		this.shop = shop;
//	}
   
}
