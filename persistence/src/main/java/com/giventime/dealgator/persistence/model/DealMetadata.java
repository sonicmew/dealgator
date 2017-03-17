package com.giventime.dealgator.persistence.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: DealMetadata
 *
 */
@Entity
@Table(name = "deal_metadata")
public class DealMetadata implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "weight")
	private double dealWeight = 1.0;
	
	@Column(name = "import_date")
	private Date importDate;
	
	@Column(name = "update_date")
	private Date updateDate;
	
	public DealMetadata() {
		super();
	}

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
	 * @return the dealWeight
	 */
	public double getDealWeight() {
		return dealWeight;
	}

	/**
	 * @param dealWeight the dealWeight to set
	 */
	public void setDealWeight(double dealWeight) {
		this.dealWeight = dealWeight;
	}

	/**
	 * @return the importDate
	 */
	public Date getImportDate() {
		return importDate;
	}

	/**
	 * @param importDate the importDate to set
	 */
	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}

	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}
