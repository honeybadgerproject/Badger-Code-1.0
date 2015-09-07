package com.honey.parserXML;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;

public class StackOverflowXmlParser {

	
	// We don't use namespaces
    private static final String ns = null;
   
    public List<Entry> parse(String buf) throws XmlPullParserException, IOException {
        try {
        	
        	InputStream in = new ByteArrayInputStream(buf.getBytes("UTF-8"));
			//InputStream stream = is;   
			
        	// read it with BufferedReader
 			//BufferedReader br = new BufferedReader(new InputStreamReader(in));
 		 
 			//String line;
 			//line = br.readLine();
 				
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);  			
            parser.nextTag();
            return readFeed(parser);
        } finally {
           // in.close();
        }
    }
    
    private List<Entry> readFeed(XmlPullParser parser) throws XmlPullParserException, IOException {
        List<Entry> entries = new ArrayList<Entry>();

        //parser.require(XmlPullParser.START_TAG, ns, "feed");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            // Starts by looking for the entry tag
            if (name.equals("view-services")) {
            	// entra a view-services
            	 while (parser.next() != XmlPullParser.END_TAG) {
                     if (parser.getEventType() != XmlPullParser.START_TAG) {
                         continue;
                     }
                     String nameBookService = parser.getName();
                     // Starts by looking for the entry tag
                     if (nameBookService.equals("view-service")) {
                         entries.add(readEntry(parser));
                     } else {
                         skip(parser);
                     }
                 }  
                //entries.add(readEntry(parser));
            } 
            else if (name.equals("js-services")) {
            	// entra a view-services
            	 while (parser.next() != XmlPullParser.END_TAG) {
                     if (parser.getEventType() != XmlPullParser.START_TAG) {
                         continue;
                     }
                     String nameBookService = parser.getName();
                     // Starts by looking for the entry tag
                     if (nameBookService.equals("js-service")) {
                         entries.add(readEntry(parser));
                     } else {
                         skip(parser);
                     }
                 }  
                //entries.add(readEntry(parser));
            }
            else {
                skip(parser);
            }
        }  
        return entries;
    }
    
 // Parses the contents of an entry. If it encounters a title, summary, or link tag, hands them off
    // to their respective "read" methods for processing. Otherwise, skips the tag.
    private Entry readEntry(XmlPullParser parser) throws XmlPullParserException, IOException {
        //parser.require(XmlPullParser.START_TAG, ns, "entry");
        String idW = null;
        String classN = null;
        String html = null;
        String urlM = null;
        String idM = null;
        String jsM = null;
        String pathM = null;
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("id-WebView")) {
                idW = readWebView(parser);
            } else if (name.equals("class-name")) {
                classN = readClass(parser);
            } else if (name.equals("html-interface-name")) {
                html = readHtml(parser);
            } else if (name.equals("url")) {
            	urlM = readURL(parser);
            } else if (name.equals("id-method")) {
                idM = readClass(parser);
            } else if (name.equals("js-method")) {
                jsM = readHtml(parser);
            } else if (name.equals("path")) {
            	pathM = readURL(parser);
            } else {
                skip(parser);
            }
        }
        return new Entry(idW, classN, html, urlM, idM, jsM, pathM);
    }
    
    private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
            case XmlPullParser.END_TAG:
                depth--;
                break;
            case XmlPullParser.START_TAG:
                depth++;
                break;
            }
        }
     }
    
    private String readWebView(XmlPullParser parser) throws IOException, XmlPullParserException {
    	  parser.require(XmlPullParser.START_TAG, ns, "id-WebView");
    	  String title = readText(parser);
    	  parser.require(XmlPullParser.END_TAG, ns, "id-WebView");
    	  return title;
    }

    private String readClass(XmlPullParser parser) throws IOException, XmlPullParserException {
    	 parser.require(XmlPullParser.START_TAG, ns, "class-name");
    	 String summary = readText(parser);
    	 parser.require(XmlPullParser.END_TAG, ns, "class-name");
    	 return summary;
    }
    
    private String readHtml(XmlPullParser parser) throws IOException, XmlPullParserException {
   	 	parser.require(XmlPullParser.START_TAG, ns, "html-interface-name");
   	 	String summary = readText(parser);
   	 	parser.require(XmlPullParser.END_TAG, ns, "html-interface-name");
   	 	return summary;
   }
    
    private String readURL(XmlPullParser parser) throws IOException, XmlPullParserException {
   	 	parser.require(XmlPullParser.START_TAG, ns, "url");
   	 	String summary = readText(parser);
   	 	parser.require(XmlPullParser.END_TAG, ns, "url");
   	 	return summary;
   }
    
   private String readIdMethod(XmlPullParser parser) throws IOException, XmlPullParserException {
  	  parser.require(XmlPullParser.START_TAG, ns, "id-method");
  	  String title = readText(parser);
  	  parser.require(XmlPullParser.END_TAG, ns, "id-method");
  	  return title;
  }

  private String readJSMethod(XmlPullParser parser) throws IOException, XmlPullParserException {
  	 parser.require(XmlPullParser.START_TAG, ns, "js-method");
  	 String summary = readText(parser);
  	 parser.require(XmlPullParser.END_TAG, ns, "js-method");
  	 return summary;
  }
  
  private String readPath(XmlPullParser parser) throws IOException, XmlPullParserException {
 	 	parser.require(XmlPullParser.START_TAG, ns, "path");
 	 	String summary = readText(parser);
 	 	parser.require(XmlPullParser.END_TAG, ns, "path");
 	 	return summary;
 }
  //For the tags title and summary, extracts their text values.
    private String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
     String result = "";
     if (parser.next() == XmlPullParser.TEXT) {
         result = parser.getText();
         parser.nextTag();
     }
     return result;
    }
}
