package net.epam.study.service;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class XMLValidator {
    public static boolean checkXMLForXSD(String pathXml, String pathXsd) throws Exception {
        File xml = new File(pathXml);
        File xsd = new File(pathXsd);
        if (!xml.exists()) {
            System.out.println("Не найден XML " + pathXml);
        }
        if (!xsd.exists()) {
            System.out.println("Не найден XSD " + pathXsd);
        }
        if (!xml.exists() || !xsd.exists()) {
            return false;
        }
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(new StreamSource(pathXsd));
        Validator validator = schema.newValidator();
        validator.validate(new StreamSource(pathXml));
        return true;
    }
}
