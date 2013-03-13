/**
 * 
 */
package com.giventime.dealgator.services.feed;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.giventime.dealgator.common.dto.DealInfo;

/**
 * @author ANDROUTA
 * 
 */
public class DealsFeedContentHandler extends DefaultHandler {
	
	private enum XMLTags {
		DEAL("deal"),
		DEAL_ID("deal_id"),
		DEAL_SHOP("deal_shop"),
		DEAL_CATEGORY("category"),
		DEAL_TITLE("title"),
		DEAL_DESCRIPTION("description"),
		DEAL_ORIGINAL_PRICE("deal_original_price"),
		DEAL_PRICE("deal_price"),
		DEAL_DISCOUNT("deal_discount");
		
		private String tagName;
		
		private XMLTags(String tagName) {
			this.tagName = tagName;
		}
		
		public String getTagName() {
			return tagName;
		}
	};
	
	private List<DealInfo> deals;
	private DealInfo currentDeal;
	
	@Override
	public void startDocument() throws SAXException {
		deals = new ArrayList<DealInfo>();
	}

	@Override
	public void endDocument() throws SAXException {
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (XMLTags.DEAL.getTagName().equals(qName)) {
			currentDeal = new DealInfo();
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (XMLTags.DEAL.getTagName().equals(qName)) {
			deals.add(currentDeal);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public List<DealInfo> getDeals() {
		return deals;
	}

}
