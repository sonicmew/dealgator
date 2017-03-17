package com.giventime.dealgator.persistence.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
		metadata = new DealMetadata();
	}
	
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany(mappedBy = "deals")
	private List<Category> categories = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "shop_id")
	private Shop shop;
	
	// TODO unique?
	@Column(name = "lw_product_id", nullable = false)
	private String linkwiseProductId;
	
	@Column(name = "shop_product_id")
	private String shopProductId;
	
	@Lob
	@Column(name = "title", columnDefinition = "text")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "site_url")
	private String siteUrl;
	
	@Column(name = "tracking_url")
	private String trackingUrl;
	
	@Column(name = "valid_from")
	private Date validFrom;
	
	@Column(name = "valid_to")
	private Date validTo;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "full_price")
	private String fullPrice;
	
	@Column(name = "price")
	private String price;
	
	@Column(name = "discount")	
	private String discount;
	
	@Column(name = "bought")
	private String bought;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="metadata_id")
	private DealMetadata metadata;
	
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
	 * @return the shop
	 */
	public Shop getShop() {
		return shop;
	}

	/**
	 * @param shop the shop to set
	 */
	public void setShop(Shop shop) {
		this.shop = shop;
	}

	/**
	 * @return the linkwiseProductId
	 */
	public String getLinkwiseProductId() {
		return linkwiseProductId;
	}

	/**
	 * @param linkwiseProductId the linkwiseProductId to set
	 */
	public void setLinkwiseProductId(String linkwiseProductId) {
		this.linkwiseProductId = linkwiseProductId;
	}

	/**
	 * @return the shopProductId
	 */
	public String getShopProductId() {
		return shopProductId;
	}

	/**
	 * @param shopProductId the shopProductId to set
	 */
	public void setShopProductId(String shopProductId) {
		this.shopProductId = shopProductId;
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
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * @return the siteUrl
	 */
	public String getSiteUrl() {
		return siteUrl;
	}

	/**
	 * @param siteUrl the siteUrl to set
	 */
	public void setSiteUrl(String siteUrl) {
		this.siteUrl = siteUrl;
	}

	/**
	 * @return the trackingUrl
	 */
	public String getTrackingUrl() {
		return trackingUrl;
	}

	/**
	 * @param trackingUrl the trackingUrl to set
	 */
	public void setTrackingUrl(String trackingUrl) {
		this.trackingUrl = trackingUrl;
	}

	/**
	 * @return the validFrom
	 */
	public Date getValidFrom() {
		return validFrom;
	}

	/**
	 * @param validFrom the validFrom to set
	 */
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	/**
	 * @return the validTo
	 */
	public Date getValidTo() {
		return validTo;
	}

	/**
	 * @param validTo the validTo to set
	 */
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the fullPrice
	 */
	public String getFullPrice() {
		return fullPrice;
	}

	/**
	 * @param fullPrice the fullPrice to set
	 */
	public void setFullPrice(String fullPrice) {
		this.fullPrice = fullPrice;
	}

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @return the discount
	 */
	public String getDiscount() {
		return discount;
	}

	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(String discount) {
		this.discount = discount;
	}

	/**
	 * @return the bought
	 */
	public String getBought() {
		return bought;
	}

	/**
	 * @param bought the bought to set
	 */
	public void setBought(String bought) {
		this.bought = bought;
	}

	public DealMetadata getMetadata() {
		return metadata;
	}

	public void setMetadata(DealMetadata metadata) {
		this.metadata = metadata;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Deal [linkwiseProductId=" + linkwiseProductId + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((linkwiseProductId == null) ? 0 : linkwiseProductId.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deal other = (Deal) obj;
		if (linkwiseProductId == null) {
			if (other.linkwiseProductId != null)
				return false;
		} else if (!linkwiseProductId.equals(other.linkwiseProductId))
			return false;
		return true;
	}
	
}
