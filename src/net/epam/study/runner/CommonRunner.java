package net.epam.study.runner;

import net.epam.study.service.XMLValidator;
import net.epam.study.main.DOMParserRunner;
import net.epam.study.main.SAXParserRunner;
import net.epam.study.main.STAXParserRunner;

public class CommonRunner {
    public static void main(String[] args) throws Exception {
        boolean xmlCheckResult = XMLValidator.checkXMLForXSD("resources/MenuXML.xml", "resources/MenuXSD.xsd");
        System.out.println("\n"+"XML соответствует XSD : " + xmlCheckResult+"\n");
        DOMParserRunner.runner();
        SAXParserRunner.runner();
        STAXParserRunner.runner();
    }
}
