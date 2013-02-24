package org.connerhansen.sprinkles.attributes;

import java.util.ArrayList;
import java.util.List;

public class Attribute {
	private String id;
	private String type;
	private Object value;
	private List<Attribute> children;
	
	public Attribute(String id, String type, Object value){
		this.id = id;
		this.type = type;
		this.value = value;
		this.children = new ArrayList<Attribute>();
	}
	
	public boolean addChild( Attribute a ){
		return children.add(a);
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}
	/**
	 * @return the children
	 */
	public List<Attribute> getChildren() {
		return children;
	}
	/**
	 * @param children the children to set
	 */
	public void setChildren(List<Attribute> children) {
		this.children = children;
	}
}
