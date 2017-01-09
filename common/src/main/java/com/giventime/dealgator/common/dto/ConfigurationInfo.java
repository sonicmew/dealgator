/**
 * 
 */
package com.giventime.dealgator.common.dto;

import java.util.List;

/**
 * @author ANDROUTA
 *
 */
public class ConfigurationInfo implements EntityInfo {

	private long id;
	private String name;
	private boolean active;
	private List<SettingInfo> settings;
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
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
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the active
	 */
	public boolean isActive() {
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
	public List<SettingInfo> getSettings() {
		return settings;
	}
	
	/**
	 * @param settings the settings to set
	 */
	public void setSettings(List<SettingInfo> settings) {
		this.settings = settings;
	}
}
