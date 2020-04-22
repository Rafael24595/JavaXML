
package DataManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import Objects.Users;

public class XML {
    
    public static ArrayList<Users> readXML() throws ParserConfigurationException, SAXException{
        
        ArrayList<Users> users = new ArrayList<Users>();
        
        try {

            File myFile = new File("Usuarios.xml");
            
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
            
            DocumentBuilder db = dbf.newDocumentBuilder();  
            
            Document doc = db.parse(myFile);
            
            doc.getDocumentElement().normalize();  
            
            NodeList nodeList = doc.getElementsByTagName("usuario");  
            
            for (int i = 0; i < nodeList.getLength(); i++){  
                
                Node node = nodeList.item(i);  
                
                if (node.getNodeType() == Node.ELEMENT_NODE){  
                    
                Element eElement = (Element) node;  
                
                Users user = new Users(
                         Integer.parseInt(node.getAttributes().getNamedItem("id").getNodeValue())
                        ,eElement.getElementsByTagName("nif").item(0).getTextContent()
                        ,eElement.getElementsByTagName("nombre").item(0).getTextContent()
                        ,eElement.getElementsByTagName("apellidos").item(0).getTextContent()
                        ,eElement.getElementsByTagName("fechaNacimiento").item(0).getTextContent()
                        ,eElement.getElementsByTagName("ciclo").item(0).getTextContent());
                
                users.add(user);
                
                }  
            } 

        } catch (IOException e) {
        }
        
        return users;
        
    }
    
    public static void writeXML(ArrayList<Users> myUsers) throws TransformerConfigurationException, TransformerException{
        
         try {
 
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
 
            DocumentBuilder db = dbf.newDocumentBuilder();
 
            Document doc = db.newDocument();

            Element users = doc.createElement("usuarios");
            
            doc.appendChild(users);

             for (int i = 0; i < myUsers.size(); i++) {
                 
                Element user = doc.createElement("usuario");
 
                users.appendChild(user);

                Attr attr = doc.createAttribute("id");
                attr.setValue("" + myUsers.get(i).getId());
                user.setAttributeNode(attr);

                Element nif = doc.createElement("nif");
                nif.appendChild(doc.createTextNode(myUsers.get(i).getNif()));
                user.appendChild(nif);

                Element name = doc.createElement("nombre");
                name.appendChild(doc.createTextNode(myUsers.get(i).getName()));
                user.appendChild(name);

                Element subname = doc.createElement("apellidos");
                subname.appendChild(doc.createTextNode(myUsers.get(i).getSubname()));
                user.appendChild(subname);

                Element date = doc.createElement("fechaNacimiento");
                date.appendChild(doc.createTextNode(myUsers.get(i).getDate()));
                user.appendChild(date);

                Element module = doc.createElement("ciclo");
                module.appendChild(doc.createTextNode(myUsers.get(i).getModule()));
                user.appendChild(module);
                 
             }
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            
            Transformer transformer = transformerFactory.newTransformer();
            
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            
            DOMSource domSource = new DOMSource(doc);
            
            StreamResult streamResult = new StreamResult(new File("Usuarios.xml"));
 
            transformer.transform(domSource, streamResult);
 
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
        
    }
    
}
