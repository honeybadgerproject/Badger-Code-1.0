package com.honey.hbController;

import android.app.Activity;
import android.content.res.AssetManager;

public interface HoneyBadger {

	public void showMessage();
	public void createMap(Activity act, AssetManager am);
	public void createProcess(Activity act, AssetManager am);
}
