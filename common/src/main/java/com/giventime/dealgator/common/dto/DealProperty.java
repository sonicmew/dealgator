/**
 * 
 */
package com.giventime.dealgator.common.dto;

/**
 * @author ANDROUTA
 *
 */
public enum DealProperty {

	DEAL_ID_LW("lw_product_id"),
	DEAL_PROG("program"),
	DEAL_ID_SHOP("product_id"),
	DEAL_SHOP("deal_shop"),
	DEAL_CATEGORY("category"),
	DEAL_TITLE("product_name"),
	DEAL_DESCRIPTION("description"),
	DEAL_IMAGE_URL("image_url"),
	DEAL_SITE_URL("site_url"),
	TRACKING_URL("tracking_url"),
	DEAL_VALID_FROM("valid_from"),
	DEAL_VALID_TO("valid_to"),
	DEAL_CITY("city"),
	DEAL_ORIGINAL_PRICE("full_price"),
	DEAL_PRICE("price"),
	DEAL_DISCOUNT("discount"),
	DEAL_BOUGHT("times_bought");
	
	private String propertyName;
	
	private DealProperty(String propertyName) {
		this.propertyName = propertyName;
	}
	
	public String getPropertyName() {
		return propertyName;
	}
}
