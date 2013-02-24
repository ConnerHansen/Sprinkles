package org.connerhansen.sprinkles.settings;

public class UserSetting {
	//////////////////////////////////
	// Static Constants
	//////////////////////////////////
	public static final String ID_DEFAULT_DIR = "defaultdir";
	public static final String ID_FRAME = "frame";
	public static final String ID_SIZE = "size";
	public static final String ID_SPRINKLES = "sprinkles";
	public static final String ID_USER_PREFS = "userprefs";
	public static final String ID_WINDOW = "window";
	
	public static final UserSetting 
		DEFAULT_WINDOW_SIZE = new UserSetting(
				ID_WINDOW + "." + ID_SIZE, 
				new int[]{640, 480});
	
	//////////////////////////////////
	// Instance Variables
	//////////////////////////////////
	private String id;
	private Object value;
	
	public UserSetting(String id, Object value){
		this.id = id;
		this.value = value;
	}
	
	/**
	 * 
	 * @return the ID of the setting
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @return the value of the setting
	 */
	public Object getValue() {
		return value;
	}
	
	/**
	 * Sets the ID of the setting
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Sets the value of the object
	 * @param value
	 */
	public void setValue(Object value) {
		this.value = value;
	}
}
