package com.honey.hbController;

import java.util.ArrayList;
import java.util.List;

import com.honey.parserXML.ParserHoneyXML;
import com.test.himaven3.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.AssetManager;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;


public class SingleEntry extends Activity implements HoneyBadger {

	// html view
	private static String[] parserViews;	
	private static String[] parserClassNames;
	private static String[] parserInterfaceNames;
	private static String[] parserUrlNames;
	
	
	//android view
	private static String[] parserIdMethod;	
	private static String[] parserJsMethod;
	private static String[] parserPath;

	
	static
	{
		// initialize values
	}

	// create an object of SingleObject
	private static SingleEntry instance = new SingleEntry();
	
	// make the constructor private so that this class cannot be 
	// instantiated
	private SingleEntry() { }
	
	// Get the only object available
	public static SingleEntry getInstance() {
		return instance;
	}
	
	@Override
	public void showMessage() {
		Log.i("Entry", "---- Hello World");		
	}
	
	private boolean getWebViewNames(AssetManager am) {
		try {
	        // call config badger-config.xml
	        ParserHoneyXML pars = new ParserHoneyXML(am);
	        ArrayList<String> a_list = pars.getViewNames();
	        parserViews = new String[a_list.size()];
	        int index = 0;
	        for(String name : a_list)
	        {
	        	parserViews[index] = name;
	        	index++;
	        }
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	private boolean getClassNames(AssetManager am) {
		try {
	        // call config badger-config.xml
	        ParserHoneyXML pars = new ParserHoneyXML(am);
	        ArrayList<String> a_list = pars.getClassNames();
	        parserClassNames = new String[a_list.size()];
	        int index = 0;
	        for(String name : a_list)
	        {
	        	parserClassNames[index] = name;
	        	index++;
	        }
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	private boolean getInterfaceNames(AssetManager am) {
		try {
	        // call config badger-config.xml
	        ParserHoneyXML pars = new ParserHoneyXML(am);
	        ArrayList<String> a_list = pars.getInterfaceNames();
	        parserInterfaceNames = new String[a_list.size()];
	        int index = 0;
	        for(String name : a_list)
	        {
	        	parserInterfaceNames[index] = name;
	        	index++;
	        }
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	private boolean getUrlNames(AssetManager am) {
		try {
	        // call config badger-config.xml
	        ParserHoneyXML pars = new ParserHoneyXML(am);
	        ArrayList<String> a_list = pars.getUrlNames();
	        parserUrlNames = new String[a_list.size()];
	        int index = 0;
	        for(String name : a_list)
	        {
	        	parserUrlNames[index] = name;
	        	index++;
	        }
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	
	private boolean getIdMethod(AssetManager am) {
		try {
	        // call config badger-config.xml
	        ParserHoneyXML pars = new ParserHoneyXML(am);
	        ArrayList<String> a_list = pars.getInterfaceNames();
	        parserIdMethod = new String[a_list.size()];
	        int index = 0;
	        for(String name : a_list)
	        {
	        	parserIdMethod[index] = name;
	        	index++;
	        }
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	private boolean getJsMethod(AssetManager am) {
		try {
	        // call config badger-config.xml
	        ParserHoneyXML pars = new ParserHoneyXML(am);
	        ArrayList<String> a_list = pars.getInterfaceNames();
	        parserJsMethod = new String[a_list.size()];
	        int index = 0;
	        for(String name : a_list)
	        {
	        	parserJsMethod[index] = name;
	        	index++;
	        }
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	private boolean getPath(AssetManager am) {
		try {
	        // call config badger-config.xml
	        ParserHoneyXML pars = new ParserHoneyXML(am);
	        ArrayList<String> a_list = pars.getInterfaceNames();
	        parserPath = new String[a_list.size()];
	        int index = 0;
	        for(String name : a_list)
	        {
	        	parserPath[index] = name;
	        	index++;
	        }
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	public void createMap(Activity act, AssetManager am) {
		
		List<WebView> arrViews = new ArrayList<WebView>();
		// call parser
		if(getWebViewNames(am) == true && getClassNames(am) == true && getInterfaceNames(am) == true && getUrlNames(am) == true) {
			int index=0;
			for(String pV : parserViews)
			{
				try {
					////***********************************************////
					////      instruccion a generar
					////***********************************************////
				
					// -- config parser (view name)
					int resID = act.getResources().getIdentifier(pV, "id", act.getPackageName());
					WebView browser = (WebView)act.findViewById(resID);
				
					//habilitamos javascript y el zoom
					browser.getSettings().setJavaScriptEnabled(true);
					browser.getSettings().setBuiltInZoomControls(true);
					//habilitamos los plugins (flash)
					browser.getSettings().setPluginsEnabled(true);
		        
					// class for web view
					Object o;
					String pC = parserClassNames[index];
					System.out.println("--------- pC: " + pC);
					o = Class.forName(pC).newInstance();
				
					
					//Gen mc = new Gen();  // -- config parser (java class)
		    	
					// cambiar
					String pI = parserInterfaceNames[index];
					System.out.println("--------- pI: " + pI);
					browser.addJavascriptInterface(o, pI); //"MyCls" + p);   // -- config parser (name window)
		        
					// cambiar
					String pU = parserUrlNames[index];
					browser.loadUrl(pU);//"file:///android_asset/web/home.html");   // -- config parser ( url to load )
					arrViews.add(browser);
		        
					index++;
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}
	}
	
	
	
	

	@Override
	public void createProcess(Activity act, AssetManager am) {
		
/*		WebView wv;
		List<WebView> arrViews = new ArrayList<WebView>();
		// call parser
		if(getIdMethod(am) == true && getJsMethod(am) == true && getPath(am) == true) {
			int index=0;
			for(String pV : parserIdMethod)
			{
				try {
					
					 final Button button = (Button) findViewById(R.id.button1);
					 
					 wv = (WebView) findViewById(R.id.homeView);
					 
					 wv.getSettings().setJavaScriptEnabled(true);
					 wv.getSettings().setUserAgentString("Mozilla/4.0 (compatible; MSIE 5.01; Windows NT 5.0)");
					 //wv.addJavascriptInterface(new MyJavaScriptInterface(), "HTMLOUT");

				
					 button.setOnClickListener(new View.OnClickListener() {
					        @Override
					        public void onClick(View v) {
					           // String txt = editText.getText().toString();
					            wv.loadUrl("javascript:sayHelloFromJS('"+txt+"')");
					        }
					 });
					 

				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		}  */
		
	}

}


/*class MyJavaScriptInterface
{
    @SuppressWarnings("unused")
    public void showHTML(final String html)
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Huddle.this.textView.setText(html);
            }
        });
    }
}

class MyChromeClient extends WebChromeClient{
}

class MyWebClient extends WebViewClient {
    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);

    }
 }
}*/