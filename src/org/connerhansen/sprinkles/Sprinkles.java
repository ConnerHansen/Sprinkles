package org.connerhansen.sprinkles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.connerhansen.sprinkles.attributes.Attribute;
import org.connerhansen.sprinkles.gui.GUI;
import org.connerhansen.sprinkles.settings.SettingExecutor;
import org.connerhansen.sprinkles.settings.UserSetting;

import sun.net.www.content.text.plain;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sun.org.apache.xalan.internal.xsltc.runtime.Attributes;

public class Sprinkles {
	public static final String DEFAULT_DIRECTORY = "documentation/samples/";
	public static final String USER_PREFERENCES_FILE = "sprinkles.json";
	public static final String DEFAULT_ATTRIBUTES_FILE = "attributes.json";
	public static final String DEFAULT_CSS_FILE = "css.json";
	
	private List<UserSetting> settings;
	private GUI gui;
	private List<Attribute> groups;
	private List<Attribute> css;
	
	public Sprinkles(){
		this.gui = new GUI(this);
		settings = new ArrayList<UserSetting>();
		groups = new ArrayList<Attribute>();
		css = new ArrayList<Attribute>();
	}
	
	public boolean addSetting( UserSetting s ){
		return settings.add( s );
	}
	
	/**
	 * Create the default settings
	 */
	private void createDefaultSettings(){
		settings.clear();
		addSetting( SettingExecutor.DEFAULT_WINDOW_SIZE );
//		addSetting( SettingExecutor.DEFAULT_WINDOW_SIZE );
//		addSetting( SettingExecutor.DEFAULT_DIRECTORY );
//		addSetting( SettingExecutor.DEFAULT_FILE );
	}
	
	public void loadPreferences( String directory ){
		BufferedReader r;
		try {
			File f = new File(directory + USER_PREFERENCES_FILE);
			
			if( f.exists() ){
				r = new BufferedReader(
				new FileReader(f));
			
				Gson g = new Gson();
				g.fromJson(r, Sprinkles.class);
			} else {
				createDefaultSettings();
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		applySettings();
	}
	
	public void loadAttributes( String directory ){
		BufferedReader r;
		try {
			File f = new File(directory + DEFAULT_ATTRIBUTES_FILE);
			
			if( f.exists() ){
				r = new BufferedReader(
				new FileReader(f));
			
				Gson g = new Gson();
				JsonParser p = new JsonParser();
				JsonArray arr = p.parse( r ).getAsJsonArray();
				
				for( JsonElement e : arr ){
					Attribute grp = g.fromJson(e, Attribute.class);
					groups.add( grp );
				}
				
//				g.fromJson(r, Sprinkles.class);
			} else {
//				createDefaultSettings();
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
//		applySettings();
	}
	
	public void loadCSS( String directory ){
		BufferedReader r;
		try {
			File f = new File(directory + DEFAULT_CSS_FILE);
			
			if( f.exists() ){
				r = new BufferedReader(
				new FileReader(f));
			
				Gson g = new Gson();
				JsonParser p = new JsonParser();
				JsonArray arr = p.parse( r ).getAsJsonArray();
				
				for( JsonElement e : arr ){
					Attribute grp = g.fromJson(e, Attribute.class);
					css.add( grp );
				}
				
//				g.fromJson(r, Sprinkles.class);
			} else {
//				createDefaultSettings();
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
//		applySettings();
	}

	/**
	 * @return the gui
	 */
	public GUI getGui() {
		return gui;
	}
	
	/**
	 * 
	 */
	public void applySettings(){
		for(UserSetting s : settings){
			try{
				SettingExecutor.getInstance().perform( s );
			} catch (Exception e){
				e.printStackTrace();
				System.out.println("Error in User Setting: " + s.getId());
			}
		}
	}

	/**
	 * @param gui the gui to set
	 */
	public void setGui(GUI gui) {
		this.gui = gui;
	}
}
