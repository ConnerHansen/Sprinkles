package org.connerhansen.sprinkles.settings;

import org.connerhansen.sprinkles.Driver;

public class SettingExecutor {
	//////////////////////////////////
	// Static Constants
	//////////////////////////////////
	private static final SettingExecutor instance = new SettingExecutor();
	
	public static final UserSetting DEFAULT_WINDOW_SIZE = 
			new UserSetting( UserSetting.ID_WINDOW + "." + UserSetting.ID_SIZE,
					new int[]{640, 480});
	
	private SettingExecutor(){
		
	}
	
	public static SettingExecutor getInstance(){
		return instance;
	}
	
	public boolean match(UserSetting setting){
		return false;
	}
	
	public boolean perform(UserSetting setting) throws Exception{
		if( setting.getId().equals( 
				UserSetting.ID_WINDOW + "." + UserSetting.ID_SIZE )){
			Driver.getInstance().getGUI().setSize( 
					((int[]) setting.getValue())[0],
					((int[]) setting.getValue())[1]);
		}
		
		return false;
	}
}
