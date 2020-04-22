package DataManager;


import java.util.ArrayList;
import java.util.Scanner;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import Objects.Users;
import Objects.Users;


public class Menu {
    
    public static void startMenu(ArrayList<Users> users) throws ParserConfigurationException, SAXException, TransformerException{
        
        Scanner keyboard = new Scanner (System.in);
        
        int option = -1;
        
        while(option != 0){
            
            System.out.println("\n¿Qué deseas hacer? \n 1.-Leer fichero XML \n 2.-Guardar fichero XML \n 3.-Introducir Usuario \n 4.-Modificar usuario \n 5.-Borrar usuario \n 6.-Leer usuario \n 7.-Mostrar todos los usuarios \n 0.-Slir\n");
        
            option = keyboard.nextInt(); 
            
        
        
        switch(option){
            
            case 1:
                
                int delete = -1;
                
                if(!users.isEmpty()){

                    while(delete != 1 && delete != 0){
                    
                    System.out.println("\n¡Atención! Se sobrescribirán los datos actuales. Continuar: \n 1.-Sí \n 0.-No \n");
                    
                    delete = keyboard.nextInt();
                    
                }
                
                if(delete == 1){
                    
                    users = XML.readXML();
                    
                }
                    
                }
                else{
                    
                    users = XML.readXML();
                    
                }
                
                
                
            break;
            
            case 2:
                
                if(!users.isEmpty()){
                    
                    XML.writeXML(users);
                    
                }
                
                
                
                
            break;
            
            case 3:
                
                boolean validate = false;

                String name = Users.validateNameSubname("nombre");
                   
                String subname = Users.validateNameSubname("apellido");
                   
                String nif = Users.validateNif(users);             
                   
                String date = Users.validateDate();
                
                String module = Users.validateModule();
                
                Users userAdd = new Users(users.size() + 1, nif, name, subname, date, module);
                
                users.add(userAdd);
                          
            break;
            
            case 4:
                
                if(!users.isEmpty()){
      
                    int i = Users.searchUser(users);
                    
                    users.get(i).userToString();
                    
                    if (i != -1){
                        
                        int overWrite = -1;
                        
                        while (overWrite != 0){
                                                 
                            System.out.println("\n¿Qué quieres cambiar? \n1.-Nombre \n2.-Apellidos \n3.-Fecha de nacimiento \n4.-Ciclo \n0.-Salir\n");
                        
                            overWrite = keyboard.nextInt();
                            
                            switch(overWrite){
                                
                                case 1:
                                 
                                   users.get(i).setName(Users.validateNameSubname("nombre"));
                                    
                                break;
                                
                                case 2:
                                 
                                   users.get(i).setSubname(Users.validateNameSubname("apellido"));
                                    
                                break;
                                
                                case 3:
                                 
                                   users.get(i).setDate(Users.validateDate());
                                    
                                break;
                                
                                case 4:
                                 
                                   users.get(i).setModule(Users.validateModule());
                                    
                                break;
                                
                            }
                            
                        }

                        
                    }
                    
                }
                else{
                    
                    System.out.println("\nLa lista está vacía");
                    
                }
                
            break;
            
            case 5:
                
                if(!users.isEmpty()){
      
                    int i = Users.searchUser(users);
                    
                    if (i != -1){
                        
                        users.remove(i);
                        
                        Users.validateId(users);
                        
                    }
                    
                }
                else{
                    
                    System.out.println("\nLa lista está vacía");
                    
                }
                
                
            break;
            
            case 6:
                
                if(!users.isEmpty()){
      
                    int i = Users.searchUser(users);
                    
                    if (i != -1){
                        
                        users.get(i).userToString();
                        
                    }
                    
                }
                else{
                    
                    System.out.println("\nLa lista está vacía");
                    
                }
                
                
            break;
            
            case 7:
                
                if(!users.isEmpty()){
                    
                    for (int i = 0; i < users.size(); i++) {
                        
                        users.get(i).userToString();
                        
                    }
                    
                }
                else{
                    
                    System.out.println("\nLa lista está vacía");
                    
                }
                
                
            break;
            
        }
        
        }
        
    }
    
}
