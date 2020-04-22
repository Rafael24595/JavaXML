
package Principal;

import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import DataManager.Menu;
import Objects.Users;



public class Principal {

    public static void main(String argv[]) throws ParserConfigurationException, SAXException, TransformerException {
        
        ArrayList<Users> users = new ArrayList<>();

	Menu.startMenu(users);
          
    }
}
