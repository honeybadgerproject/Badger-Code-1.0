package com.honey.parserXML;

public class Entry {
	
	public final String idWebView;
    public final String className;
    public final String htmlInterfaceName;
    public final String urlMapName;
    
    public final String idMethod;
    public final String jsMethod;
    public final String path;

	public Entry(String idWebView, String className, String htmlInterfaceName, String urlMap, String idMethod, String jsMethod, String path) {
        this.idWebView = idWebView;
        this.className = className;
        this.htmlInterfaceName = htmlInterfaceName;
        this.urlMapName = urlMap;
        
        this.idMethod = idMethod;
        this.jsMethod = jsMethod;
        this.path = path;
    }
}
