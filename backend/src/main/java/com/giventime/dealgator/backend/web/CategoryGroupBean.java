/**
 * 
 */
package com.giventime.dealgator.backend.web;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.giventime.dealgator.common.dto.CategoryGroupInfo;
import com.giventime.dealgator.services.api.CategoryServices;

@Named("categoryGroupBean")
@RequestScoped
/**
 * @author ANDROUTA
 *
 */
public class CategoryGroupBean extends AdminBean<CategoryGroupInfo> {

	@Inject
	private CategoryServices categoryServices;
	
	@PostConstruct
	public void init() {
		setDataModel(new ListDataModel<CategoryGroupInfo>(categoryServices.getAllCategoryGroups()));
	}
	
	@Override
	public void save() {
		// TODO Auto-generated method stub
	}

	@Override
	public void revert() {
		// TODO Auto-generated method stub
	}

	@Override
	public void update() {
		setSelectedInfo(getDataModel().getRowData());
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void enable() {
		super.enable();
	}
	
	@Override
	public void disable() {
		super.disable();
	}

}
