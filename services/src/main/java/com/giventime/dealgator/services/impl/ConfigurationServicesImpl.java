/**
 * 
 */
package com.giventime.dealgator.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.giventime.dealgator.common.dto.ConfigurationInfo;
import com.giventime.dealgator.common.dto.SettingInfo;
import com.giventime.dealgator.persistence.dao.ConfigurationDao;
import com.giventime.dealgator.persistence.model.Configuration;
import com.giventime.dealgator.persistence.model.Setting;
import com.giventime.dealgator.services.api.ConfigurationServices;

/**
 * @author ANDROUTA
 *
 */
@Stateless
public class ConfigurationServicesImpl implements ConfigurationServices {

	@Inject
	private ConfigurationDao configurationDao;
	
	/**
	 * 
	 */
	public ConfigurationServicesImpl() {
		// TODO Auto-generated constructor stub
	}
	
	/* (non-Javadoc)
	 * @see com.giventime.dealgator.services.api.ConfigurationServices#getAllConfigurations()
	 */
	@Override
	public List<ConfigurationInfo> getAllConfigurations() {
		List<ConfigurationInfo> infos = new ArrayList<ConfigurationInfo>();
		List<Configuration> configs = configurationDao.fetchAll();
		for (Configuration conf: configs) {
			ConfigurationInfo confInfo = new ConfigurationInfo();
			confInfo.setId(conf.getId());
			confInfo.setName(conf.getName());
			confInfo.setActive(conf.getActive());
			for (Setting setting : conf.getSettings()) {
				SettingInfo settInfo = new SettingInfo();
				settInfo.setId(setting.getId());
				settInfo.setName(setting.getName());
				settInfo.setValue(setting.getValue());
				confInfo.getSettings().add(settInfo);
			}
			infos.add(confInfo);
		}
		return infos;
	}

}
