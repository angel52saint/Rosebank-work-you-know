
package project;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class login 
{
    public static boolean checkUserName(String username)
    {
        int length;
        length = username.length();
        
        if (length <=5 && username.contains("_"))
        {
            return true;
        }
        return false;
    }
    public static boolean checkPasswordComplexity(String password)
    {
        int length;
        length = password.length();
        String regex = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches()&&length >=8;
    }
    public static String registerUser (String password, String username)
    {
        String message="";
        
        if(checkPasswordComplexity(password) && checkUserName(username))
        {
            message = "registered succefully";
        }
        else if(!checkPasswordComplexity(password) && checkUserName(username))
        {
            message = "your password doesn't meet the requirements";
        }
        else if (!checkUserName(username) && checkPasswordComplexity(password))
        {
            message = "name doesn't meet the requirements";
        }
        else if(!checkPasswordComplexity(password) && !checkUserName(username))
        {
            message = "both name and password doesn't meet the requirements";
        }

        return message;
        
    }
    public static boolean loginUser (String username1, String password1,String password,String username)
    {
        if (username1.compareTo(username) == 0 &&  password1.compareTo(password) == 0)
        {
          return true;
        }  
        return false;
    }
    public static String returnLoginstatus ( String username1,String password1,String password,String username)
    {
        
        String verify = "";
        
        if (loginUser(username1,password1,password,username))
        {
            verify = "seccefully login";
        }
        else if(!loginUser(username1,password1,password,username))
        {
            verify = "Failed login";
        }
        return verify;
    }
}

