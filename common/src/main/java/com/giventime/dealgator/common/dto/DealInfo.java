/**
 * 
 */
package com.giventime.dealgator.common.dto;

import javax.persistence.Column;

/**
 * @author ANDROUTA
 *
 */
public class DealInfo {

	private Long id;
	private String title;
	private String description;
	private int originalPrice;
	private int discount;
	private int dealPrice;

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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the originalPrice
	 */
	public int getOriginalPrice() {
		return originalPrice;
	}

	/**
	 * @param originalPrice the originalPrice to set
	 */
	public void setOriginalPrice(int originalPrice) {
		this.originalPrice = originalPrice;
	}

	/**
	 * @return the discount
	 */
	public int getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(int discount) {
		this.discount = discount;
	}

	/**
	 * @return the dealPrice
	 */
	public int getDealPrice() {
		return dealPrice;
	}

	/**
	 * @param dealPrice the dealPrice to set
	 */
	public void setDealPrice(int dealPrice) {
		this.dealPrice = dealPrice;
	}
	
}
