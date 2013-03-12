package com.giventime.dealgator.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Configuration
 *
 */
@Entity
public class Configuration implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	private String configurationName;
	
	private String applicationUrl;
	
	private String active;	
	
	public Configuration() {
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
	 * @return the configurationName
	 */
	public String getConfigurationName() {
		return configurationName;
	}

	/**
	 * @param configurationName the configurationName to set
	 */
	public void setConfigurationName(String configurationName) {
		this.configurationName = configurationName;
	}

	/**
	 * @return the applicationUrl
	 */
	public String getApplicationUrl() {
		return applicationUrl;
	}

	/**
	 * @param applicationUrl the applicationUrl to set
	 */
	public void setApplicationUrl(String applicationUrl) {
		this.applicationUrl = applicationUrl;
	}

	/**
	 * @return the active
	 */
	public String getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(String active) {
		this.active = active;
	}	
   
}
