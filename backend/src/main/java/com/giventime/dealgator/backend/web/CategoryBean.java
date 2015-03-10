/**
 * 
 */
package com.giventime.dealgator.backend.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import com.giventime.dealgator.common.dto.CategoryGroupInfo;
import com.giventime.dealgator.common.dto.CategoryInfo;
import com.giventime.dealgator.services.api.CategoryServices;

/**
 * @author ANDROUTA
 *
 */
@Named("categoryBean")
@RequestScoped
public class CategoryBean extends AdminBean<CategoryInfo> {

	@Inject
	private CategoryServices categoryServices;
	
	@PostConstruct
	public void init() {
		setDataModel(new ListDataModel<CategoryInfo>(categoryServices.getAllCategories()));
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	
}
