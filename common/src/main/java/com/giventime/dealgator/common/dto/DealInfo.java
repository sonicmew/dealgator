/**
 * 
 */
package com.giventime.dealgator.common.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author ANDROUTA
 *
 */
public class DealInfo implements EntityInfo {

	private Long id;
	private Map<String, DealPropertyInfo> propertyMap = new HashMap<>();
	private List<CategoryGroupInfo> categoryGroups = new ArrayList<>();
	
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
	
	public Map<String, DealPropertyInfo> getPropertyMap() {
		return propertyMap;
	}
	
	public void setPropertyMap(Map<String, DealPropertyInfo> propertyMap) {
		this.propertyMap = propertyMap;
	}
	
	private DealPropertyInfo getProperty(DealProperty propertyName) {		
		return getPropertyMap().get(propertyName.getPropertyName());
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
	
	public String getTitle() {
		return getProperty(DealProperty.DEAL_TITLE).getValue();
	}
	
	public String getOriginalPrice() {
		return getProperty(DealProperty.DEAL_ORIGINAL_PRICE).getValue();
	}
	
	public String getPrice() {
		return getProperty(DealProperty.DEAL_PRICE).getValue();
	}
	
	public String getDiscount() {
		return getProperty(DealProperty.DEAL_DISCOUNT).getValue();
	}
	
	public String getBought() {
		return getProperty(DealProperty.DEAL_BOUGHT).getValue();
	}
	
	public String getDealUrl() {
		return getProperty(DealProperty.TRACKING_URL).getValue();
	}
	
	public String getImageUrl() {
		return getProperty(DealProperty.DEAL_IMAGE_URL).getValue();
	}
}
