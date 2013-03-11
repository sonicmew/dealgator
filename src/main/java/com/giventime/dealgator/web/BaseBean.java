/**
 * 
 */
package com.giventime.dealgator.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.inject.Inject;

import com.giventime.dealgator.dao.CategoryDao;
import com.giventime.dealgator.model.Category;

/**
 * @author ANDROUTA
 *
 */

public abstract class BaseBean {

	public abstract String getBeanName();
	
	@Inject
	private CategoryDao categoryDao;
	
	/**
	 * 
	 * @return
	 */
	public List<SelectItem> getCategorySelectItems() {
		List<Category> categories = categoryDao.fetchCategories();
		List<SelectItem> list = new ArrayList<SelectItem>();
		for (Category cat : categories) {
			SelectItem item = new SelectItem(cat, cat.getName());
			list.add(item);
		}
		return list;
	}
}
