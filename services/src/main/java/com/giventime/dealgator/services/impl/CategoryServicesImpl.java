package com.giventime.dealgator.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.giventime.dealgator.common.SuppliedDataException;
import com.giventime.dealgator.common.dto.CategoryInfo;
import com.giventime.dealgator.persistence.dao.CategoryDao;
import com.giventime.dealgator.persistence.model.Category;
import com.giventime.dealgator.services.api.CategoryServices;

@Stateless
public class CategoryServicesImpl implements CategoryServices {

	@Inject
	private CategoryDao categoryDao;
	
	public CategoryServicesImpl() {
		// TODO Auto-generated constructor stub
	}
	
	private CategoryInfo toDTO(Category category) {
		CategoryInfo ci = new CategoryInfo();
		ci.setId(category.getId());
		ci.setName(category.getName());
		ci.setEnabled(category.isEnabled());		
		return ci;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.giventime.dealgator.services.api.CategoryServices#getAllCategoryGroups()
	 */
	@Override
	public List<CategoryInfo> getAllCategories() {
		List<CategoryInfo> infos = new ArrayList<CategoryInfo>();
		List<Category> categories = categoryDao.fetchCategories();
		for (Category cat : categories) {
			CategoryInfo info = new CategoryInfo();
			info.setId(cat.getId());
			info.setName(cat.getName());
			info.setEnabled(cat.isEnabled());
			infos.add(info);
		}
		return infos;
	}
	
	@Override
	public Long getCategoryIdFor(String categoryStr) throws SuppliedDataException {
		return categoryDao.getCategoryIdFor(categoryStr);
	}

}
