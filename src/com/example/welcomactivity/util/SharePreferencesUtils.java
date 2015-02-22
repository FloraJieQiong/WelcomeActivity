package com.example.welcomactivity.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharePreferencesUtils {
	
	public static String SP_NAME = "config";
	private static SharedPreferences sp;
	
	public static void saveBoolean(Context context,String key, boolean value){
		if(sp == null){
			sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
		}
		Editor editor = sp.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}
	
	public static boolean getBoolean(Context context, String key, boolean defaultValue){
		if(sp == null){
			sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
		}
		return sp.getBoolean(key, defaultValue);
	}
}
