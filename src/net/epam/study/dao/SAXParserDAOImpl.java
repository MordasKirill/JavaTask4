package net.epam.study.dao;

import net.epam.study.entity.Dish;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class SAXParserDAOImpl extends DefaultHandler{
    public static ArrayList<Dish> dishes = new ArrayList<>();
    private String category;
    private String name;
    private String price;
    private String region;
    public String lastElementName;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        lastElementName = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String information = new String(ch, start, length);
        information = information.replace("\n", "").trim();
        if (lastElementName.equals("appetizer")) {
            category = lastElementName;
        }
        if (lastElementName.equals("soup")) {
            category = lastElementName;
        }
        if (lastElementName.equals("meat-dish")) {
            category = lastElementName;
        }
        if (lastElementName.equals("poultry")) {
            category = lastElementName;
        }
        if (lastElementName.equals("fish-and-sea-dish")) {
            category = lastElementName;
        }
        if (lastElementName.equals("desert")) {
            category = lastElementName;
        }
        if (lastElementName.equals("drink")) {
            category = lastElementName;
        }
        if (!information.isEmpty()) {
            if (lastElementName.equals("name")) {
                name = information;
            }
            if (lastElementName.equals("price")) {
                price = information;
            }
            if (lastElementName.equals("region")) {
                region = information;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ( (name != null && !name.isEmpty()) && (price != null && !price.isEmpty()) && (region != null && !region.isEmpty()) ) {
            dishes.add(new Dish(category, name, price, region));
            category = null;
            name = null;
            price = null;
            region = null;
        }
    }
}
