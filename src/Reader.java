
import org.json.simple.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.w3c.dom.NodeList;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.*;


public class Reader {


    static void readFile(String path, String outputName) {
        JSONObject jsonObject = new JSONObject();


        try {
            // Load the XML file
            File inputFile = new File(path);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputFile);

            // Get the <resources> element
            Element rootElement = doc.getDocumentElement();

            // Get the <string> elements
            NodeList stringElements = rootElement.getElementsByTagName("string");
            for (int i = 0; i < stringElements.getLength(); i++) {
                Element stringElement = (Element) stringElements.item(i);

                // Get the name attribute value
                String name = stringElement.getAttribute("name");

                // Get the text content of the element
                String value = stringElement.getTextContent();

                System.out.println("Name: " + name);
                System.out.println("Value: " + value);
                jsonObject.put(name, value);
                System.out.println();
            }


            writer(jsonObject, outputName);

        } catch (Exception e) {
           System.out.println("File Not found !");
        }
    }


    private static void writer(JSONObject jsonObject, String outputName) throws IOException {
        FileWriter file = new FileWriter("output/"+outputName+".json");
        file.write(jsonObject.toJSONString());
        file.close();
    }

}








