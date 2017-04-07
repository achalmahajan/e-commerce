package com.sd.org.parser;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import com.sd.org.model.Item;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Achal on 4/4/17.
 */
public class XmlParser {

    public static List<Item> itemList = new ArrayList<>();

    public List<Item> getItems(){
        String url = "https://slickdeals.net/newsearch.php?mode=frontpage&searcharea=deals&searchin=first&rss=1";
        parser(url);

        System.out.println(itemList.size());

        ListIterator<Item> listIterator = itemList.listIterator();
        while(listIterator.hasNext()){
            Item item = listIterator.next();
            System.out.println(item.getTitle());
        }
        return itemList;
    }

    public static void parser(String url) {

        try {

            DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbuilder = dbfactory.newDocumentBuilder();
            Document doc = dbuilder.parse(url);

            doc.getDocumentElement().normalize();


            NodeList nodeList = doc.getElementsByTagName("item");

            for (int temp = 0; temp < nodeList.getLength(); temp++) {

                Node nNode = nodeList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    Item item = new Item();
                    item.setTitle(eElement.getElementsByTagName("title").item(0).getTextContent());
                    item.setLink(eElement.getElementsByTagName("link").item(0).getTextContent());
                    item.setDescription(eElement.getElementsByTagName("description").item(0).getTextContent());

                   itemList.add(item);

                }
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}

