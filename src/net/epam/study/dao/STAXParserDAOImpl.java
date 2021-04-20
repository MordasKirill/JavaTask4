package net.epam.study.dao;

import com.sun.deploy.security.SelectableSecurityManager;
import net.epam.study.entity.Dish;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class STAXParserDAOImpl {

    public static List<Dish> collectInformation(String fileName) {
        List<Dish> dishList = new ArrayList<>();
        Dish dish = new Dish();
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        String category = null;
        String name = null;
        String price = null;
        String filingTime = null;
        String region = null;
            try {
                XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
                while (reader.hasNext()) {
                    XMLEvent xmlEvent = reader.nextEvent();
                    if (xmlEvent.isStartElement()) {
                        StartElement startElement = xmlEvent.asStartElement();
                        switch (startElement.getName().getLocalPart()){
                            case "appetizer":
                                category = "appetizer";
                                break;
                            case "soup":
                                category = "soup";
                                 break;
                            case "meat-dish":
                                category = "meat-dish";
                                break;
                            case "poultry":
                                category = "poultry";
                                break;
                            case "fish-and-sea-dish":
                                category = "fish-and-sea-dish";
                                break;
                            case "desert":
                                category = "desert";
                                break;
                            case "drink":
                                category = "drink";
                                break;
                            case "name":
                                xmlEvent = reader.nextEvent();
                                name = xmlEvent.asCharacters().getData();
                                dish.setName(xmlEvent.asCharacters().getData());
                                break;
                            case "price":
                                xmlEvent = reader.nextEvent();
                                price = xmlEvent.asCharacters().getData();
                                dish.setPrice(xmlEvent.asCharacters().getData());
                                break;
                            case "filing-time":
                                xmlEvent = reader.nextEvent();
                                filingTime = xmlEvent.asCharacters().getData();
                                dish.setFilingTime(xmlEvent.asCharacters().getData());
                                break;
                            case "region":
                                xmlEvent = reader.nextEvent();
                                region = xmlEvent.asCharacters().getData();
                                dish.setRegion(xmlEvent.asCharacters().getData());
                                break;
                            default:
                                break;
                        }
                        if (category!=null&&name!=null&&price!=null&&filingTime!=null&&region!=null) {
                            dishList.add(new Dish(category, name, price, filingTime, region));
                            category = null;
                            name = null;
                            price = null;
                            filingTime = null;
                            region = null;
                        }
                    }
                }
            } catch (FileNotFoundException | XMLStreamException exc) {
                exc.printStackTrace();
            }
            return dishList;
        }
    }
