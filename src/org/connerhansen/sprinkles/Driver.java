package org.connerhansen.sprinkles;

import org.connerhansen.sprinkles.gui.GUI;

public class Driver {
	//////////////////////////////////
	// Static Variables
	//////////////////////////////////
	private static Driver instance;
	
	//////////////////////////////////
	// Instance Variables
	//////////////////////////////////
	private Sprinkles sprinkles;
	private GUI gui;
	
	private Driver(){
	}
	
	public void load(){
		sprinkles = new Sprinkles();
		gui = new GUI( sprinkles );
		
		sprinkles.loadPreferences( Sprinkles.DEFAULT_DIRECTORY );
		sprinkles.loadAttributes( Sprinkles.DEFAULT_DIRECTORY );
		sprinkles.loadCSS( Sprinkles.DEFAULT_DIRECTORY );
		
		gui.setVisible( true );
	}
	
	public Sprinkles getSprinkles(){
		return sprinkles;
	}
	
	public GUI getGUI(){
		return gui;
	}
	
	public static Driver getInstance(){
		return instance;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		instance = new Driver();
		instance.load();
	}
}
