package com.honey.main;



import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import netscape.javascript.JSObject;





import com.honey.hbController.HoneyBadger;
import com.honey.hbController.SingleEntry;
import com.honey.jsService.Gen;
import com.test.himaven3.R;
public class MainActivity extends Activity {


	private ProgressBar progressBar;
	private JSObject jsobj;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		WebView browser = (WebView)findViewById(R.id.homeView);
        
        ////***************Honey Badger call***************////
        HoneyBadger w_object = SingleEntry.getInstance();
        w_object.createMap(this,getAssets());
        //w_object.createProcess(this, getAssets());
        w_object.showMessage();
        
        ////***********************************************////
		
		progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        
        browser.setWebChromeClient(new WebChromeClient() 
        {
            @Override
            public void onProgressChanged(WebView view, int progress) 
            {               
            	 progressBar.setProgress(0);
            	 progressBar.setVisibility(View.VISIBLE);
            	 MainActivity.this.setProgress(progress * 1000);
            	 
            	 progressBar.incrementProgressBy(progress);
            	 
                 if(progress == 100)
                 {
                    // progressBar.setVisibility(View.GONE);
                 }
            }
        });  
		
		//------------------------
		
	}

	
	public void execjavaScript(View v) {
		System.out.println("--------- java script: ----------");
		
		java.applet.Applet applet = new Applet();
		JSObject win = JSObject.getWindow(applet);  //JSObject.getWindow(this);
		
		
		//win.call("callHello", new String[]{"mkyong"});
		
		jsobj = null;
		
		Object call = jsobj.call("", "");
		
	/*	TemporalObject objT = new TemporalObject();
		
		this.name=(String)js.getMember("name");
	    this.age=(String)js.getMember("age");*/
		
	/*	objT.value = "goodbye";
		WebView wv = (WebView) findViewById(R.id.homeView);
		
		// enabling javascript
		WebSettings webSettings = wv.getSettings();
		webSettings.setJavaScriptEnabled(true);
		
		Gen mc = new Gen();
		wv.addJavascriptInterface(mc,  "MyCls"); 
		
		//addJavascriptInterface(javaObjectCallback, "JavaCallback");
		
		String loc = "file:///android_asset/web/home.html";
	    wv.loadUrl(loc);
		
		wv.loadUrl("javascript:sayHelloFromJS()");
		//wv.loadUrl("window.MyCls.returnResult()");
		*/
		
		/*String loc = "file:///android_asset/web/home.html";
	    wv.getSettings().setJavaScriptEnabled(true);
	    wv.clearView();
	    // myWebView.measure(100, 100);
	    wv.getSettings().setUseWideViewPort(true);
	    wv.getSettings().setLoadWithOverviewMode(true);
	    wv.loadUrl(loc);
	    wv.loadUrl("javascript:sayHelloFromJS()");
		*/
		
		/*WebView wv = (WebView) findViewById(R.id.homeView);
		TemporalObject objT = new TemporalObject();
		
		objT.value = "goodbye";
		String javaScriptObject = "goodbye";
			//wv.loadUrl("javascript:var myObj = { value: '" + objT + "' };");
	
		
		
		wv.loadUrl("javascript:sayHelloFromJS( " + objT.value + ")");
		  */  
        
       // System.out.println("--------- exec java  script: ----------" +  objT.value);
	}
	
	
	
	public void modifyValue(String str)
	{
		
		System.out.println("--------- exec java modify----- " + str);
	}
	
		
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
