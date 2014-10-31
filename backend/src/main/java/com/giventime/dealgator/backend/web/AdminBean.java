/**
 * 
 */
package com.giventime.dealgator.backend.web;

import javax.faces.model.DataModel;
import javax.inject.Named;

import com.giventime.dealgator.common.dto.EntityInfo;

/**
 * @author ANDROUTA
 *
 */
@Named("adminBean")
public abstract class AdminBean<T extends EntityInfo> {
	
	DataModel<T> dataModel;
	T selectedInfo;
	
	/**
	 * 
	 */
	public AdminBean() {
		
	}
	
	/**
	 * @return the selectedInfo
	 */
	public T getSelectedInfo() {
		return selectedInfo;
	}

	/**
	 * @param selectedInfo the selectedInfo to set
	 */
	public void setSelectedInfo(T selectedInfo) {
		this.selectedInfo = selectedInfo;
	}

	/**
	 * @return the dataModel
	 */
	public DataModel<T> getDataModel() {
		return dataModel;
	}

	/**
	 * @param dataModel the dataModel to set
	 */
	public void setDataModel(DataModel<T> dataModel) {
		this.dataModel = dataModel;
	}

	public String helloAdmin() {
		return "Hello Admin!";
	}
	
	public abstract void save();
	
	public abstract void revert();
	
	public abstract void update();
	
	public abstract void delete();
	
	public void enable() {
		
	}
	
	public void disable() {
		
	}
	
}
