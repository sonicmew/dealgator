package com.giventime.dealgator.backend.web;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.giventime.dealgator.common.dto.ConfigurationInfo;
import com.giventime.dealgator.services.api.ConfigurationServices;

@Named("configurationBean")
@RequestScoped
public class ConfigurationBean extends AdminBean<ConfigurationInfo> {

	@Inject
	private ConfigurationServices configurationServices;
	
	@PostConstruct
	public void init() {
		setDataModel(new ListDataModel<ConfigurationInfo>(configurationServices.getAllConfigurations()));
	}

	@Override
	public void save() {
		
	}
	
	@Override
	public void revert() {
		
	}
	
	@Override
	public void update() {
		setSelectedInfo(getDataModel().getRowData());
	}
	
	@Override
	public void delete() {
		
	}
	
	public void activateConfiguration() {
		
	}
	

}
