/**
 * 
 */
package com.giventime.dealgator.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import com.giventime.dealgator.dao.CategoryDao;
import com.giventime.dealgator.model.Category;

@Named("applicationBean")
@ApplicationScoped
@Singleton
/**
 * @author ANDROUTA
 *
 */
public class ApplicationBean {

	@Inject
	private CategoryDao categoryDao;
	
	private String applicationUrl;
	private List<SelectItem> categorySelectItems;
	
	/**
	 * 
	 */
	public ApplicationBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	public void init() {
		applicationUrl = "http://localhost:7771/dealgator";
		initializeCategories();
	}
	
	/**
	 * 
	 */
	private void initializeCategories() {
		categorySelectItems = new ArrayList<SelectItem>();
		List<Category> categories = categoryDao.fetchCategories();
		for (Category cat : categories) {
			SelectItem item = new SelectItem(cat, cat.getName());
			categorySelectItems.add(item);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public List<SelectItem> getCategorySelectItems() {
		return categorySelectItems;
	}

}
