package com.stephapps.reversedholoxposed;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextWatcher;
import android.widget.EditText;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class ReversedHoloXposed implements  IXposedHookLoadPackage
{
	private EditText mEditText ;
	private String[] mSources , mDestinations, mDelayedSources, mDelayedDestinations;
	private boolean mTextWillBeChanged=false ;
	private String mAfterMsg;
	private Object mComposeMsgActivityObject;
	private TextWatcher mOriginalTextWatcher;
	private Context mContext;
	private String mPoint;
	private Drawable mSMSSmallIcon;

	private static String MODULE_PATH = null;
	
	
    public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable 
    {  	
    	if (	lpparam.packageName.equals("com.android.settings"))
    	{
    		setWhiteTheme("com.android.settings.Settings", lpparam);
    	}
//    	else if (lpparam.packageName.equals("com.android.dialer"))
//    	{
//    		setWhiteThemeAfter("com.android.dialer.DialtactsActivity", lpparam);
//    	}
//    	else if (lpparam.packageName.equals("com.android.dialer.calllog"))
//    	{
//    		setWhiteThemeAfter("com.android.dialer.calllog.CallLogFragment", lpparam);
//    	}
//    	else if (lpparam.packageName.equals("com.android.dialer.dialpad"))
//    	{
//    		setWhiteThemeAfter("com.android.dialer.dialpad.DialpadFragment", lpparam);
//    	}
//    	else if (lpparam.packageName.equals("com.android.dialer.list"))
//    	{
//    		setWhiteThemeAfter("com.android.dialer.list.PhoneFavoriteFragment", lpparam);
//    	}
//    	else if (lpparam.packageName.equals("com.android.deskclock"))
//        	{
//        		setWhiteTheme("com.android.deskclock.AlarmClock", lpparam);
//        	}
    	else if (lpparam.packageName.equals("com.android.providers.downloads.ui"))
    	{
    		setWhiteTheme("com.android.providers.downloads.ui.DownloadList", lpparam);
    	}
//    	else  if (lpparam.packageName.equals("com.android.gallery3d.app"))
//    	{
//    		setWhiteTheme("com.android.gallery3d.app.Gallery", lpparam);
//    	}
    	else if (lpparam.packageName.equals("com.android.mms"))
    	{
    		setWhiteTheme("com.android.mms.ui.ComposeMessageActivity", lpparam);
    	}
    	else
    		return;
    	
    	//XposedBridge.log("Loaded app: " + lpparam.packageName);
    	
//    	findAndHookMethod("com.android.providers.downloads.ui.DownloadList", lpparam.classLoader, "onCreate", Bundle.class, new XC_MethodHook() {
//    		@Override
//    		protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//    			Activity activity = (Activity)param.thisObject  ;  
//    			activity.setTheme(android.R.style.Theme_Holo_Light);
//    			XposedBridge.log("setting white theme");
//     		}
//    		
//    		@Override
//    		protected void afterHookedMethod(MethodHookParam param) throws Throwable 
//    		{
//    		}
//    	});
    	
    	
    	
    	findAndHookMethod("com.android.contacts.DialtactsActivity", lpparam.classLoader, "onCreate", Bundle.class, new XC_MethodHook() {
    		@Override
    		protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
    			Activity activity = (Activity)param.thisObject  ;  
    			activity.setTheme(android.R.style.Theme_Holo_Light);
    			XposedBridge.log("setting white theme");
     		}
    		
    		@Override
    		protected void afterHookedMethod(MethodHookParam param) throws Throwable 
    		{
    		}
    	});
    	
    	findAndHookMethod("com.android.contacts.TwelveKeyDialer", lpparam.classLoader, "onCreate", Bundle.class, new XC_MethodHook() {
    		@Override
    		protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
    			Activity activity = (Activity)param.thisObject  ;  
    			activity.setTheme(android.R.style.Theme_Holo_Light);
    			XposedBridge.log("setting white theme");
     		}
    		
    		@Override
    		protected void afterHookedMethod(MethodHookParam param) throws Throwable 
    		{
    		}
    	});
    	
    	findAndHookMethod("com.android.contacts.ContactsListActivity", lpparam.classLoader, "onCreate", Bundle.class, new XC_MethodHook() {
    		@Override
    		protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
    			Activity activity = (Activity)param.thisObject  ;  
    			activity.setTheme(android.R.style.Theme_Holo_Light);
    			XposedBridge.log("setting white theme");
     		}
    		
    		@Override
    		protected void afterHookedMethod(MethodHookParam param) throws Throwable 
    		{
    		}
    	});
    	
    	findAndHookMethod("com.android.contacts.RecentCallsListActivity", lpparam.classLoader, "onCreate", Bundle.class, new XC_MethodHook() {
    		@Override
    		protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
    			Activity activity = (Activity)param.thisObject  ;  
    			activity.setTheme(android.R.style.Theme_Holo_Light);
    			XposedBridge.log("setting white theme");
     		}
    		
    		@Override
    		protected void afterHookedMethod(MethodHookParam param) throws Throwable 
    		{
    		}
    	});
    }
    
    private void setWhiteTheme(String className, LoadPackageParam lpparam)
    {
    	findAndHookMethod(className, lpparam.classLoader, "onCreate", Bundle.class, new XC_MethodHook() {
    		@Override
    		protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
    			Activity activity = (Activity)param.thisObject  ;  
    			activity.setTheme(android.R.style.Theme_Holo_Light);
    			XposedBridge.log("setting white theme");
     		}
    		
    		@Override
    		protected void afterHookedMethod(MethodHookParam param) throws Throwable 
    		{
    		}
    	});
    }
    
    private void setWhiteThemeAfter(String className, LoadPackageParam lpparam)
    {
    	findAndHookMethod(className, lpparam.classLoader, "onCreate", Bundle.class, new XC_MethodHook() {
    		@Override
    		protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
    			
     		}
    		
    		@Override
    		protected void afterHookedMethod(MethodHookParam param) throws Throwable 
    		{
    			Activity activity = (Activity)param.thisObject  ;  
    			activity.setTheme(android.R.style.Theme_Holo_Light);
    			XposedBridge.log("setting white theme");
    		}
    	});
    }
}