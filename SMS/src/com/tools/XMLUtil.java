package com.tools;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLUtil {
	public static Object getBean() {
		try {
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = dFactory.newDocumentBuilder();
			Document doc;
			doc = builder.parse(new File("src//data_config.xml"));
			
			NodeList nl = doc.getElementsByTagName("data");
			Node dataNode = nl.item(0).getFirstChild();
			String data = dataNode.getNodeValue();
			
			return data;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
