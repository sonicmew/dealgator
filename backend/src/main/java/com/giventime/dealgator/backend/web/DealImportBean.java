/**
 * 
 */
package com.giventime.dealgator.backend.web;

import java.net.MalformedURLException;
import java.net.URL;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import com.giventime.dealgator.services.api.DealServices;


/**
 * @author ANDROUTA
 *
 */
@ManagedBean
@RequestScoped
public class DealImportBean {

	@Inject
	private DealServices dealServices;
	
	public void importDeals() {
		try {
			dealServices.importDeals(new URL("http://localhost:8081/sonicapps/feedSample.xml"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
