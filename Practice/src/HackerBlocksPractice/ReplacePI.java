package HackerBlocksPractice;
import java.util.*;
public class ReplacePI {
    
    public static String Replace_PI(String str){
        
        if(str.length() == 0 || str.length() == 1){
            return str;
        }
        
        else if(str.charAt(0) == 'p' && str.charAt(1) == 'i'){
            return 3.14 +""+ Replace_PI(str.substring(2));
        }
        
        else{
            return str.charAt(0) +""+ Replace_PI(str.substring(1));
        }
    }
    public static void main(String args[]) {
        
        Scanner s = new Scanner(System.in);
        int testCases = s.nextInt();
        
        for(int i = 0 ; i < testCases ; i++){
            
            String str = s.next();
            
            System.out.println(Replace_PI(str));
        }
    }
}