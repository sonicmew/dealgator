/**
 * 
 */
package com.giventime.dealgator.services.feed;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * @author ANDROUTA
 *
 */
public class FeedParser<T extends DefaultHandler> {

	private final URL feedUrl;
	private XMLReader reader;
	
	/**
	 * 
	 * @param feed
	 * @throws FeedParseException 
	 */
	public FeedParser(URL feedUrl, T handler) throws FeedParseException {
		try {
			this.feedUrl = feedUrl;
			this.reader = XMLReaderFactory.createXMLReader();			
			this.reader.setContentHandler(handler);
			this.reader.setErrorHandler(handler);
		} catch (SAXException e) {
			throw new FeedParseException(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @throws FeedParseException
	 */
	public void parse() throws FeedParseException {
		try {			
			InputSource is = new InputSource(getFeedInputStream());
			is.setEncoding("UTF-8");
			reader.parse(is);
		} catch (SAXException e) {			
			throw new FeedParseException(e.getMessage());
		} catch (IOException e) {
			throw new FeedParseException(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @return
	 * @throws FeedParseException 
	 */
    protected InputStream getFeedInputStream() throws FeedParseException {
        try {
            return feedUrl.openConnection().getInputStream();
        } catch (IOException e) {
            throw new FeedParseException(e.getMessage());
        }
    }
    
}
