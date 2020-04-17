
package xmltojavaapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Users {
                
                private final int id;
                private String nif;
                private String name;
                private String subname;
                private String date;
                private String module;

    public Users(int id, String nif, String name, String subname, String date, String module) {
        this.id = id;
        this.nif = nif;
        this.name = name;
        this.subname = subname;
        this.date = date;
        this.module = module;
    }

    public int getId() {
        return id;
    }
    
    public String getNif() {
        return nif;
    }

    public String getName() {
        return name;
    }

    public String getSubname() {
        return subname;
    }

    public String getDate() {
        return date;
    }

    public String getModule() {
        return module;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public static String validateNameSubname(String type){
        
        Scanner keyboard = new Scanner (System.in);
        
        boolean validate = false;
        
        String name = "";
        
        int i = 0;
        
        while (validate == false){
                    
                   System.out.println("\nIntroduce un " + type + ": \n");
                
                   name = keyboard.next();
                    
                

        
        while(i != name.length() && ((name.charAt(i) > 64 && name.charAt(i) < 91) || (name.charAt(i) > 96 && name.charAt(i) < 123))){
            
            i++;
            
        }
        
        if(i == name.length() && ((name.charAt(i-1) > 64 && name.charAt(i-1) < 91) || (name.charAt(i-1) > 96 && name.charAt(i-1) < 123))){
            
            validate = true;
            
        }
        else{
            
            System.out.println("\nLos números, carácteres extraños y letras acentuadas no son validos");
            
        }
        
        }
        
        return name;
        
    }
    
    public static String validateNif(ArrayList<Users> users){
        
        Scanner keyboard = new Scanner (System.in);
        
        boolean validate = false;
        
        String nif = "";
        
        int i = 0;
        
        while (validate == false){
                    
                   System.out.println("\nIntroduce tu NIF \n");
                
                   nif = keyboard.next(); 
                   
                   nif = nif.toUpperCase();
                   
        if(nif.length() == 9){
            
            if(nif.charAt(nif.length()-1) >47 && nif.charAt(nif.length()-1) >58){           
                
                while(i < users.size() && !users.get(i).getNif().equals(nif)){
                    
                    i++;
                    
                }
                
                if(!users.isEmpty()){
                    
                    if(i == users.size() && !users.get(i-1).getNif().equals(nif)){
                    
                    validate = true;
                    
                }
                else{
                    
                    System.out.println("\nYa existe un usuario con ese NIF");
                    
                }
                    
                }
                else{
                    
                    validate = true;
                    
                }
                
            }
            else{
                
                System.out.println("\nEl carácter final debe ser una letra");
                
            }
            
        }
        else{
            
            System.out.println("\nEl NIF debe tener nueve carácteres");
            
        }
        
        }
        
        return nif;
        
    }
    
    public static String validateDate(){
        
        Scanner keyboard = new Scanner (System.in);
        
        Date date = new Date();
        
        int actualDate = Integer.parseInt(date.toString().substring(25, 29));
        
        int day = 0;
                
        int month = 0;
                
        int year = 0;
        
        System.out.println("\nIntroduce tu fecha de nacimiento: ");   
        
        while(day < 1 || day >31){ 

            try {
                
                System.out.print(" -Día: ");
                
                day = keyboard.nextInt();
            } 
            catch (InputMismatchException | NumberFormatException e) {keyboard.next();}
                       
        }
        
        while(month < 1 || month > 12){
                       
            
            try {
                
                System.out.print(" -Mes: ");
                
                month = keyboard.nextInt();
            } 
            catch (InputMismatchException | NumberFormatException e) {keyboard.next();}
                       
        }
        
        while(year < 1900 || year > actualDate - 18){
            
            try {
                
                System.out.print(" -Año: ");
                
                year = keyboard.nextInt();
            } 
            catch (InputMismatchException | NumberFormatException e) {keyboard.next();}
                       
        }
        
        String dayS = "";
        
        if(day <= 9){
            
            dayS = "0";
            
        }
        
        dayS = dayS + day;
        
        String monthS = "";
        
        if(month <= 9){
            
            monthS = "0";
            
        }
        
        monthS = monthS + month;
        
        String born = dayS + "-" + monthS + "-" + year;
        
        return born;
        
    }
    
    public static String validateModule(){
        
        Scanner keyboard = new Scanner (System.in);
        
        System.out.println("\nIntroduce el nombre del ciclo\n");
                
        String module = keyboard.next();
                
        return module;
        
    }
    
    public static int searchUser(ArrayList<Users> users){
        
        Scanner keyboard = new Scanner (System.in);
        
        String nif = "";
        
        int i = 0;
        
        while(i == 0 && !nif.equals(users.get(i).getNif())){
                        
                        System.out.println("\nIntroduce el NIF del usuario a mostrar\n");
                        
                        nif = keyboard.next();
                        
                        nif = nif.toUpperCase();
                        
                           while(i < users.size() - 1 && !nif.equals(users.get(i).getNif())){
 
                            i++;
                            
                        }
                        
                        if (i == users.size() - 1 && !nif.equals(users.get(i).getNif())){
                            
                            int option = -1;
                            
                            while(option != 0 && option !=1){
                                
                                System.out.println("\nEl usuario no se encuentra en la lista \n1.-Volver a intentar \n0.-Volver al menú\n");
                                
                                option = keyboard.nextInt(); 
                                
                            }    
                            
                            if(option == 0 ){
                                    
                                    i = -1;
                                    
                                }
                            else{
                                
                                i = 0;
                                
                            }
                            
                        }                               
                        
                    }
        
        return i;
        
    }
    
    public void userToString() {
        
              System.out.println("\nId: "+ id);
              System.out.println("NIF: "+ nif);
              System.out.println("Nombre: "+ name);
              System.out.println("Apellidos: "+ subname);
              System.out.println("Fecha de nacimiento: "+ date);
              System.out.println("Ciclo: "+ module);
        
    }           
                
}
