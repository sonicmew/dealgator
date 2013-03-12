package com.giventime.dealgator.model;

import java.io.Serializable;
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
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "original_price")
	private int originalPrice;
	
	@Column(name = "discount")
	private int discount;
	
	@Column(name = "deal_price")
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
