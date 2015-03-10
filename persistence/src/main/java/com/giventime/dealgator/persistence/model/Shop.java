/**
 * 
 */
package com.giventime.dealgator.persistence.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *  
 * http://download.oracle.com/otn-pub/jcp/persistence-2.0-fr-eval-oth-JSpec/persistence-2_0-final-spec.pdf?AuthParam=1363085082_2f6e00680ac468032d57c51ff89a3d6b
 * @author ANDROUTA
 *
 */
@Entity
public class Shop {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)	
	private boolean enabled = true;
	
	@OneToMany(mappedBy = "shop")
	private List<Deal> deals = new ArrayList<>();
	
	/**
	 * 
	 */
	public Shop() {
		super();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
