package com.giventime.dealgator.services.impl;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.giventime.dealgator.common.dto.DealInfo;
import com.giventime.dealgator.common.dto.DealPropertyInfo;
import com.giventime.dealgator.common.dto.SearchCriteria;
import com.giventime.dealgator.persistence.dao.DealsDao;
import com.giventime.dealgator.persistence.model.Deal;
import com.giventime.dealgator.persistence.model.DealProperty;
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
    		DealInfo info = new DealInfo();
    		info.setId(deal.getId());
    		for (DealProperty prop : deal.getProperties()) {
    			DealPropertyInfo propInfo = new DealPropertyInfo();
    			propInfo.setName(prop.getName());
    			propInfo.setValue(prop.getValue());
    			info.getProperties().add(propInfo);
    		}
    		infos.add(info);
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
		DealInfo info = new DealInfo();
		info.setId(deal.getId());
		for (DealProperty prop : deal.getProperties()) {
			DealPropertyInfo propInfo = new DealPropertyInfo();
			propInfo.setName(prop.getName());
			propInfo.setValue(prop.getValue());
			info.getProperties().add(propInfo);
		}
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
			List<DealInfo> deals = handler.getDeals();
			persistDeals(deals);
		} catch (FeedParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param deals
	 */
	private void persistDeals(List<DealInfo> dealInfos) {
		for (DealInfo dealInfo : dealInfos) {
			Deal deal = new Deal();
			for (DealPropertyInfo propInfo : dealInfo.getProperties()) {
				deal.getProperties().add(new DealProperty(propInfo.getName(), propInfo.getValue()));
			}
			dealsDao.addDeal(deal);
		}
	}
}
