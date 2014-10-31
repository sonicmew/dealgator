/**
 * 
 */
package com.giventime.dealgator.services.feed;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.giventime.dealgator.common.dto.DealInfo;
import com.giventime.dealgator.common.dto.DealPropertyInfo;

/**
 * @author ANDROUTA
 * 
 */
public class DealsFeedContentHandler extends DefaultHandler {
	
	private List<DealInfo> deals;
	private Stack<String> stack;
	private DealInfo currentDeal;	
	private StringBuffer characters;
	
	@Override
	public void startDocument() throws SAXException {
		deals = new ArrayList<DealInfo>();
		stack = new Stack<>();
	}

	@Override
	public void endDocument() throws SAXException {
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.err.println("Start element called for "+localName);
		stack.push(qName);
		if (XMLTag.DEAL.getTagName().equals(qName)) {
			currentDeal = new DealInfo();
		} else if (currentDeal != null) {
			characters = new StringBuffer();
			System.err.println("StringBuffer initialized");
		}
	}

	@Override
	public void characters(char[] text, int start, int length) throws SAXException {
		if (currentDeal != null && characters != null && !stack.isEmpty() && stack.peek() != null) {			
			for (int i=start; i < start+length; i++) {				
				characters.append(text[i]);
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.err.println("End element called for "+localName+".");
		if (XMLTag.DEAL.getTagName().equals(qName)) {
			deals.add(currentDeal);
		} else if (currentDeal != null) {
			try {				
				currentDeal.getPropertyMap().put(stack.peek(), new DealPropertyInfo(stack.peek(), characters.toString()));
				characters = null;
				System.err.println("StringBuffer reset");
			} catch (Exception e) {				
				System.err.println(currentDeal+" "+" "+stack.peek()+" "+characters);				
			}			
		}
		stack.pop();
	}
	
	/**
	 * 
	 * @return
	 */
	public List<DealInfo> getDeals() {
		return deals;
	}

}
