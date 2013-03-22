package com.giventime.dealgator.persistence.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Configuration
 *
 */
@Entity
@Table(name = "configurations")
public class Configuration implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private boolean active;
	
	@OneToMany
	private List<Setting> settings = new ArrayList<Setting>();
	
	/**
	 * 
	 */
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String configurationName) {
		this.name = configurationName;
	}

	/**
	 * @return the active
	 */
	public boolean getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the settings
	 */
	public List<Setting> getSettings() {
		return settings;
	}

	/**
	 * @param settings the settings to set
	 */
	public void setSettings(List<Setting> settings) {
		this.settings = settings;
	}	
   
}
