package com.honey.jsService;

import android.webkit.WebView;


public class GenerateCode {

	public WebView myWebView;
	public Gen mc;
	
	public GenerateCode()
	{
	
		mc = new Gen();
		myWebView.addJavascriptInterface(mc,  "MyCls"); 
	}
}
