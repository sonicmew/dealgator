package com.giventime.dealgator.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.giventime.dealgator.common.dto.CategoryGroupInfo;
import com.giventime.dealgator.persistence.dao.CategoryDao;
import com.giventime.dealgator.persistence.model.CategoryGroup;
import com.giventime.dealgator.services.api.CategoryServices;

@Stateless
public class CategoryServicesImpl implements CategoryServices {

	@Inject
	private CategoryDao categoryDao;
	
	public CategoryServicesImpl() {
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.giventime.dealgator.services.api.CategoryServices#getAllCategoryGroups()
	 */
	@Override
	public List<CategoryGroupInfo> getAllCategoryGroups() {
		List<CategoryGroupInfo> infos = new ArrayList<CategoryGroupInfo>();
		List<CategoryGroup> categoryGroups = categoryDao.fetchCategoryGroups();
		for (CategoryGroup catGrp : categoryGroups) {
			CategoryGroupInfo info = new CategoryGroupInfo();
			info.setId(catGrp.getId());
			info.setName(catGrp.getName());
			info.setEnabled(catGrp.getEnabled());
			infos.add(info);
		}
		return infos;
	}

}
