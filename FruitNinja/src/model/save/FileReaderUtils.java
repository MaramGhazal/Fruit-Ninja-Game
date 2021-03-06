package model.save;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class FileReaderUtils {

	public static ArrayList<Integer> read() {

		ArrayList<Integer> scores = new ArrayList<Integer>();
		scores.add(0);
		File fXmlFile = new File("score.xml");

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		Document doc = null;
		try {
			doc = dBuilder.parse(fXmlFile);
		} catch (SAXException | IOException e) {
			e.printStackTrace();
		}

		doc.getDocumentElement().normalize();

		NodeList nList = doc.getElementsByTagName("Easy");
		Node nNode = nList.item(0);

		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;
			scores.add(1, Integer.parseInt(eElement.getTextContent()));

		}

		nList = doc.getElementsByTagName("Medium");
		nNode = nList.item(0);

		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;
			scores.add(2, Integer.parseInt(eElement.getTextContent()));
		}

		nList = doc.getElementsByTagName("Hard");
		nNode = nList.item(0);

		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;
			scores.add(3, Integer.parseInt(eElement.getTextContent()));
		}
		nList = doc.getElementsByTagName("Arcade");
		nNode = nList.item(0);

		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

			Element eElement = (Element) nNode;
			scores.add(4, Integer.parseInt(eElement.getTextContent()));
		}
		return scores;
	}

}
