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

import org.apache.commons.lang3.StringUtils;


/**
 * Created by Achal on 4/4/17.
 */
public class XmlParser {


//  list of items parsed from rss feed
    public static List<Item> itemList = new ArrayList<>();

    public List<Item> getItems() {

        String url = "https://slickdeals.net/newsearch.php?mode=frontpage&searcharea=deals&searchin=first&rss=1";
        parser(url);

//  Iterating List
        ListIterator<Item> listIterator = itemList.listIterator();
        while (listIterator.hasNext()) {
            Item item = listIterator.next();
            System.out.println("Title : " + item.getTitle() + " /n Thumbnail Link : " + item.getThumbnailLink());
        }
        return itemList;
    }


//  DOM Parser
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
                    item.setPubDate(eElement.getElementsByTagName("pubDate").item(0).getTextContent());
                    item.setContent(eElement.getElementsByTagName("content:encoded").item(0).getTextContent());

                    String content = item.getContent();
                    String l1 = StringUtils.substringBetween(content, "<img src=", " alt");

                    item.setThumbnailLink(l1.replace('\"' , ' '));

                    itemList.add(item);
                }
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

}

