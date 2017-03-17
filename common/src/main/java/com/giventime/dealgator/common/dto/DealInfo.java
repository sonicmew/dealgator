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
	private DealMetadataInfo dealMetadata = new DealMetadataInfo();
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
	
	public List<DealPropertyInfo> getDealProperties() {
		return new ArrayList<DealPropertyInfo>(propertyMap.values());
	}
	
	public Map<String, DealPropertyInfo> getPropertyMap() {
		return propertyMap;
	}
	
	public void setPropertyMap(Map<String, DealPropertyInfo> propertyMap) {
		this.propertyMap = propertyMap;
	}
	
	private DealPropertyInfo getProperty(DealPropertiesEnum propertyName) {		
		return getPropertyMap().get(propertyName.getPropertyName());
	}
	
	public void addProperty(DealPropertyInfo property) {
		getPropertyMap().put(property.getName(), property);
	}
	
	/**
	 * @return the dealMetadata
	 */
	public DealMetadataInfo getDealMetadata() {
		return dealMetadata;
	}

	/**
	 * @param dealMetadata the dealMetadata to set
	 */
	public void setDealMetadata(DealMetadataInfo dealMetadata) {
		this.dealMetadata = dealMetadata;
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
		return getProperty(DealPropertiesEnum.DEAL_TITLE).getValue();
	}
	
	public String getOriginalPrice() {
		return getProperty(DealPropertiesEnum.DEAL_ORIGINAL_PRICE).getValue();
	}
	
	public String getPrice() {
		return getProperty(DealPropertiesEnum.DEAL_PRICE).getValue();
	}
	
	public String getDiscount() {
		return getProperty(DealPropertiesEnum.DEAL_DISCOUNT).getValue();
	}
	
	public String getBought() {
		return getProperty(DealPropertiesEnum.DEAL_BOUGHT).getValue();
	}
	
	public String getDealUrl() {
		return getProperty(DealPropertiesEnum.TRACKING_URL).getValue();
	}
	
	public String getImageUrl() {
		return getProperty(DealPropertiesEnum.DEAL_IMAGE_URL).getValue();
	}
}
