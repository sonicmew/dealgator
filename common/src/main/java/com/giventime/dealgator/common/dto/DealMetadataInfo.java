/**
 * 
 */
package com.giventime.dealgator.common.dto;

import java.util.Date;


/**
 * @author ANDROUTA
 *
 */
public class DealMetadataInfo implements EntityInfo {

	private Long id;
	private double dealWeight = 1.0;
	private Date importDate;
	private Date updateDate;
	
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
