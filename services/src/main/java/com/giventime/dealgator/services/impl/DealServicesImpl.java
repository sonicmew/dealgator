package com.giventime.dealgator.services.impl;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.giventime.dealgator.common.dto.DealInfo;
import com.giventime.dealgator.common.dto.DealPropertiesEnum;
import com.giventime.dealgator.common.dto.DealPropertyInfo;
import com.giventime.dealgator.common.dto.SearchCriteria;
import com.giventime.dealgator.persistence.dao.DealsDao;
import com.giventime.dealgator.persistence.model.Deal;
import com.giventime.dealgator.services.api.DealServices;
import com.giventime.dealgator.services.feed.DealsFeedContentHandler;
import com.giventime.dealgator.services.feed.FeedParseException;
import com.giventime.dealgator.services.feed.FeedParser;

/**
 * Session Bean implementation class DealServicesImpl
 */
@Stateless
public class DealServicesImpl implements DealServices {

	@Inject
	private DealsDao dealsDao;
	
//	@Inject
//	private CategoryDao categoryDao;
	
    /**
     * Default constructor. 
     */
    public DealServicesImpl() {
    	
    }
    
    /*
     * (non-Javadoc)
     * @see com.giventime.dealgator.services.api.DealServices#searchDeals(com.giventime.dealgator.common.dto.SearchCriteria)
     */
    @Override
    public List<DealInfo> searchDeals(SearchCriteria searchCriteria) {
    	List<DealInfo> infos = new ArrayList<DealInfo>();
    	List<Deal> deals = dealsDao.searchDeals(searchCriteria);
    	for (Deal deal : deals) {
    		infos.add(toDTO(deal));
    	}
    	return infos;
    }
    
    /*
     * (non-Javadoc)
     * @see com.giventime.dealgator.services.api.DealServices#getDealById(long)
     */
	@Override
	public DealInfo getDealById(long dealId) {
		Deal deal = dealsDao.byId(dealId);		
		return toDTO(deal);
	}

	/**
	 * 
	 * @param deal
	 * @return
	 */
	private DealInfo toDTO(Deal deal) {
		DealInfo info = new DealInfo();
		info.setId(deal.getId());
		info.addProperty(new DealPropertyInfo(DealPropertiesEnum.DEAL_ID_LW.getPropertyName(), deal.getLinkwiseProductId()));
		info.addProperty(new DealPropertyInfo(DealPropertiesEnum.DEAL_TITLE.getPropertyName(), deal.getTitle()));
		info.addProperty(new DealPropertyInfo(DealPropertiesEnum.DEAL_PRICE.getPropertyName(), deal.getPrice()));
		info.getDealMetadata().setImportDate(deal.getMetadata().getImportDate());
		info.getDealMetadata().setUpdateDate(deal.getMetadata().getUpdateDate());
		return info;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.giventime.dealgator.services.api.DealServices#importDeals(java.net.URL)
	 */
	@Override
	public void importDeals(URL feedUrl) {
		try {
			DealsFeedContentHandler handler = new DealsFeedContentHandler();
			FeedParser<DealsFeedContentHandler> parser = new FeedParser<DealsFeedContentHandler>(feedUrl, handler);
			parser.parse();
			List<Deal> deals = handler.getDeals();			
			processDeals(deals);
		} catch (FeedParseException e) {
			e.printStackTrace();
		}
	}		
	
	/**
	 * 
	 * @param deals
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void processDeals(List<Deal> deals) {
		final List<Deal> filtered = new ArrayList<>();
		deals.stream().filter(deal -> !filtered.contains(deal)).forEach(deal -> filtered.add(deal));
		
		filtered.stream().filter(deal -> validateDeal(deal)).forEach(deal -> {
			assignCategory(deal);
			dealsDao.addDeal(deal);
		});
	}
	
	private boolean validateDeal(Deal deal) {
		return true;
	}
	
	@Override
	public void deleteAllDeals() {
		dealsDao.removeAll();
	}
	
	private void assignCategory(Deal deal) {
//		for (DealProperty dp : deal.getProperties()) {
//			if (XMLTag.DEAL_CATEGORY.getTagName().equals(dp.getName())) {
//				try {
//					String categoryStr = dp.getValue();
//					Long categoryId = categoryDao.getCategoryIdFor(categoryStr);
//					if (categoryId != null) {
//						CategoryGroup cg = categoryDao.getCategoryGroupFor(categoryId);
//						if (cg != null) {
//							deal.getCategoryGroups().add(cg);
//						}
//						// otherwise this is an unassigned category 
//						// and needs to be manually assigned to a category group
//						// via the backend admin application
//					} else {
//						// add category entry
//						Category category = new Category();
//						category.setName(categoryStr);
//						category.setEnabled(true);
//						categoryDao.addCategory(category);
//					}
//				} catch (SuppliedDataException e) {
//					System.err.println("No category found for supplied deal.");					
//				}
//			}
//		}
	}
}
