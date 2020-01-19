package kata5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class MailListReader {
    
    static List<String> email = new ArrayList<>();
    
    public static List<String> read(String fileName){
        
        
        
        try{
            
            BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
            
            
            while (true){
                String line = reader.readLine();
                if(line == null)
                    break;
                if (line.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$"))
                    email.add(line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return email;
    }
    
    
    
    
    
    
    
    
    
}
