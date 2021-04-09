package net.epam.study.runner;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import net.epam.study.main.DOMParserRunner;
import net.epam.study.main.SAXParserRunner;
import net.epam.study.main.STAXParserRunner;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class CommonRunner {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        DOMParserRunner.runner();
        SAXParserRunner.runner();
        STAXParserRunner.runner();
    }
}
