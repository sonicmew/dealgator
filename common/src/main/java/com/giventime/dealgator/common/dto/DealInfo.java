/**
 * 
 */
package com.giventime.dealgator.common.dto;

import java.util.ArrayList;
import java.util.List;


/**
 * @author ANDROUTA
 *
 */
public class DealInfo implements EntityInfo {

	private Long id;
	private List<DealPropertyInfo> properties = new ArrayList<DealPropertyInfo>();
	private List<CategoryGroupInfo> categoryGroups = new ArrayList<CategoryGroupInfo>();
	
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
	public List<DealPropertyInfo> getProperties() {
		return properties;
	}
	
	/**
	 * @param properties the properties to set
	 */
	public void setProperties(List<DealPropertyInfo> properties) {
		this.properties = properties;
	}
	
	/**
	 * @return the categoryGroups
	 */
	public List<CategoryGroupInfo> getCategoryGroups() {
		return categoryGroups;
	}
	
	/**
	 * @param categoryGroups the categoryGroups to set
	 */
	public void setCategoryGroups(List<CategoryGroupInfo> categoryGroups) {
		this.categoryGroups = categoryGroups;
	}
	
}
