import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class XMLParser {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("appointment_details.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            
            NodeList patientList = doc.getElementsByTagName("data");
            
            System.out.println("<table border='1'>");
            System.out.println("<tr><th>Name</th><th>Date</th><th>Time</th><th>E-Mail</th></tr>");
            
            for (int temp = 0; temp < patientList.getLength(); temp++) {
                Node patientNode = patientList.item(temp);
                
                if (patientNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element patientElement = (Element) patientNode;
                    String name = patientElement.getElementsByTagName("name").item(0).getTextContent();
                    String date = patientElement.getElementsByTagName("date").item(0).getTextContent();
                    String time = patientElement.getElementsByTagName("time").item(0).getTextContent();
                    String email = patientElement.getElementsByTagName("email").item(0).getTextContent();
                    
                    System.out.println("<tr><td>" + name + "</td><td>" + date + "</td><td>" + time + "</td><td>" + email + "</td></tr>");
                }
            }
            
            System.out.println("</table>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
