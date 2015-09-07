package com.honey.parserXML;


import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.xml.sax.InputSource;


import android.content.res.AssetManager;

public class ParserHoneyXML {
	
	private ArrayList<String> viewNames = new ArrayList<String>();
	private ArrayList<String> classNames = new ArrayList<String>();
	private ArrayList<String> interfaceNames = new ArrayList<String>();
	private ArrayList<String> urlNames = new ArrayList<String>();
	//private String[] viewNames;
	
	private ArrayList<String> idMethod = new ArrayList<String>();
	private ArrayList<String> jsMethod = new ArrayList<String>();
	private ArrayList<String> path = new ArrayList<String>();
	
	public ArrayList<String> getidMethod()
	{
		return idMethod;
	}
	
	public ArrayList<String> getjsMethod()
	{
		return jsMethod;
	}
	
	public ArrayList<String> getPath()
	{
		return path;
	}
	
	public ArrayList<String> getViewNames()
	{
		return viewNames;
	}
	
	public ArrayList<String> getClassNames()
	{
		return classNames;
	}
	
	public ArrayList<String> getInterfaceNames()
	{
		return interfaceNames;
	}
	
	public ArrayList<String> getUrlNames()
	{
		return urlNames;
	}
	
	public ParserHoneyXML(AssetManager am)
	{
		///-------------------------------------------
        ///                parsea el xml
		///-------------------------------------------
		
		
		try {
        
			// lee el archivo de configuracion y ponerlo en un String
			
			// to read
			InputStream is = am.open("badger-config.xml");
			int size = is.available();
			byte[] buffer = new byte[size];
			is.read(buffer);
			String buf = new String(buffer);
			System.out.println(buf);
			is.close();	
			buf = buf.replaceAll("\n", "");
			buf = buf.replaceAll("\r", "");
			buf = buf.replaceAll(" ", "");
			buf = buf.replaceAll("\t", "");
				
		
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			InputSource iss = new InputSource(new StringReader(buf));
			/*Document doc = */ dBuilder.parse(iss);
			
			/* parser init */
			
			// Instantiate the parser
		    StackOverflowXmlParser stackOverflowXmlParser = new StackOverflowXmlParser();
			List<Entry> entries = null;
			
			
		 
			//String line;
			//while ((line = br.readLine()) != null) {
				//System.out.println(line);
			//}
		    entries = stackOverflowXmlParser.parse(buf);
		    // Makes sure that the InputStream is closed after the app is
		    // finished using it.
			
		    
		    // StackOverflowXmlParser returns a List (called "entries") of Entry objects.
		    // Each Entry object represents a single post in the XML feed.
		    // This section processes the entries list to combine each entry with HTML markup.
		    // Each entry is displayed in the UI as a link that optionally includes
		    // a text summary.
		
		    String imprime="";
		    for (Entry entry : entries) {
		    	//views;
		    	 imprime = entry.idWebView;
		    	 if(imprime != null)
		    	 {
		    		 System.out.println("--- views:   " + imprime);
		    		 viewNames.add(imprime);
		    	 }
		       
		    	//class;
		    	 imprime = entry.className;
		    	 if(imprime != null)
		    	 {
		    		 System.out.println("--- class:   " + imprime);
		    		 classNames.add(imprime);
		    	 }
		    	 
		    	//interface;
		    	 imprime = entry.htmlInterfaceName;
		    	 if(imprime != null)
		    	 {
		    		 System.out.println("--- interface:   " + imprime);
		    		 interfaceNames.add(imprime);
		    	 }
		    	 
		    	//url;
		    	 imprime = entry.urlMapName;
		    	 if(imprime != null)
		    	 {
		    		 System.out.println("--- url:   " + imprime);
		    		 urlNames.add(imprime);
		    	 }
		    	 
		    	 // ---- js
		    	 imprime = entry.idMethod;
		    	 if(imprime != null)
		    	 {
		    		 System.out.println("--- views:   " + imprime);
		    		 idMethod.add(imprime);
		    	 }
		       
		    	 
		    	//interface;
		    	 imprime = entry.jsMethod;
		    	 if(imprime != null)
		    	 {
		    		 System.out.println("--- interface:   " + imprime);
		    		 jsMethod.add(imprime);
		    	 }
		    	 
		    	//url;
		    	 imprime = entry.path;
		    	 if(imprime != null)
		    	 {
		    		 System.out.println("--- url:   " + imprime);
		    		 path.add(imprime);
		    	 }
		    }
			
			
		} catch (Exception ex) {           
			ex.printStackTrace();
        }
	
	}
	
	

}
