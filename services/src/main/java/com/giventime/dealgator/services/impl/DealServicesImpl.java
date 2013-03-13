package com.giventime.dealgator.services.impl;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.giventime.dealgator.persistence.dao.DealsDao;
import com.giventime.dealgator.common.dto.DealInfo;
import com.giventime.dealgator.common.dto.SearchCriteria;
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
    		info.setTitle(deal.getTitle());
    		info.setDescription(deal.getDescription());
    		info.setOriginalPrice(deal.getOriginalPrice());
    		info.setDiscount(deal.getDiscount());
    		info.setDealPrice(deal.getDealPrice());
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
		info.setTitle(deal.getTitle());
		info.setDescription(deal.getDescription());
		info.setOriginalPrice(deal.getOriginalPrice());
		info.setDiscount(deal.getDiscount());
		info.setDealPrice(deal.getDealPrice());
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
	private void persistDeals(List<DealInfo> deals) {
		for (DealInfo dealInfo : deals) {
			Deal deal = new Deal();
			deal.setTitle(dealInfo.getTitle());
			deal.setDescription(dealInfo.getDescription());
			deal.setOriginalPrice(deal.getOriginalPrice());
			deal.setDiscount(dealInfo.getDiscount());
			deal.setDealPrice(dealInfo.getDealPrice());
			dealsDao.addDeal(deal);
		}
	}
}
