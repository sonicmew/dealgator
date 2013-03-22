/**
 * 
 */
package com.giventime.dealgator.persistence.dao;

import java.util.List;

import javax.ejb.Stateless;

import com.giventime.dealgator.persistence.model.Configuration;

/**
 * @author ANDROUTA
 * @param <E>
 *
 */
@Stateless
public class ConfigurationDao extends BaseDao<Configuration> {

	public ConfigurationDao() {
		super(Configuration.class);
	}
	
	public List<Configuration> fetchConfigurations() {
		return fetchAll();
	}

}
