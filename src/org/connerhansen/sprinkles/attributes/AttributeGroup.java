package org.connerhansen.sprinkles.attributes;

import java.util.ArrayList;
import java.util.List;

public class AttributeGroup {
	private String id;
	private Attribute[] attributes;
	
	public AttributeGroup( String id, String[] attributes ){
		this.id = id;
//		this.attributes = new ArrayList<Attribute>();
	}
	
	/**
	 * 
	 * @param a the attribute to be added
	 * @return true if the attribute was successfully added,
	 * otherwise false
	 */
//	public boolean addAttribute(Attribute a){
//		return this.attributes.add(a);
//	}
	
	/**
	 * 
	 * @return the ID of the group
	 */
	public String getID(){
		return id;
	}
	
	public void setAttributes( Attribute[] attributes ){
		this.attributes = attributes;
	}
	
	/**
	 * Sets the ID of the group
	 * @param id
	 */
	public void setID(String id){
		this.id = id;
	}
}
