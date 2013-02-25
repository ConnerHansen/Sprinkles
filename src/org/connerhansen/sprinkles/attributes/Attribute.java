package org.connerhansen.sprinkles.attributes;

public class Attribute {
	private String css;
	private String id;
	private String type;
	private Object value;
	private boolean isGroup;
	private Attribute[] children;
	
	public Attribute(String id, String type, Object value){
		this.id = id;
		this.type = type;
		this.value = value;
		this.isGroup = false;
	}
	
	/**
	 * @return the children
	 */
	public Attribute[] getChildren() {
		return children;
	}
	/**
	 * @return the css
	 */
	public String getCss() {
		return css;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @return the value
	 */
	public Object getValue() {
		return value;
	}
	/**
	 * @return the isGroup
	 */
	public boolean isGroup() {
		return isGroup;
	}
	/**
	 * @param children the children to set
	 */
	public void setChildren(Attribute[] children) {
		this.children = children;
	}
	/**
	 * @param css the css to set
	 */
	public void setCss(String css) {
		this.css = css;
	}

	/**
	 * @param isGroup the isGroup to set
	 */
	public void setGroup(boolean isGroup) {
		this.isGroup = isGroup;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}
}
