
package project;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Project {

    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        String username,password,firstname,lastname,username1,password1,logingin;
        login Login = new login();
        
        System.out.println("Enter your username: ");
        username = scan.next();
        login.checkUserName(username);
        if (login.checkUserName(username))
        {
            System.out.println("username successfully captured");
        }
        else
        {
            System.out.println("username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in legth");
        }
        System.out.println("Enter your password: ");
        password = scan.next();
        login.checkPasswordComplexity(password);
        if (login.checkPasswordComplexity(password))
        {
            System.out.println("password successfully captured");
        }
        else
        {
            System.out.println("password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
        }
        
        while(!login.checkUserName(username) || !login.checkPasswordComplexity(password))
        {
            System.out.println("Enter your username: ");
            username = scan.next();
            login.checkUserName(username);
            if (login.checkUserName(username))
            {
                System.out.println("username successfully captured");
            }
            else
            {
                System.out.println("username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in legth");
            }
            System.out.println("Enter your password: ");
            password = scan.next();
            login.checkPasswordComplexity(password);
            if (login.checkPasswordComplexity(password))
            {
            System.out.println("password successfully captured");
            }
            else
            {   
            System.out.println("password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
            }
        
        }
        System.out.println("Enter your firstname: ");
        firstname = scan.next();
        System.out.println("Enter your lastname: ");
        lastname = scan.next();     
        System.out.println(login.registerUser(password, username));
        
        
        System.out.println("to login");
        System.out.println("enter your username");
        username1 = scan.next();
        System.out.println("Enter your password");
        password1 = scan.next();
        login.loginUser(username1, password1, password, username);
        
        login.returnLoginstatus(username1, password1, password, username);
        System.out.println(login.returnLoginstatus(username1, password1, password, username));
        
        if (login.loginUser(username1, password1, password, username))
        {
            System.out.println("welcome" + firstname + "" +lastname+ "it is great see you again");
        }
        else
        {
            System.out.println("username or password are incorrect try again");
        }
        
        int count = 0;
        int tries = 1;
        while (count !=2 && login.loginUser(username1, password1, password, username) )
        {
            System.out.println("enter your username");
            username1 = scan.next();
            System.out.println("Enter your password");
            password1 = scan.next();
            login.loginUser(username1, password1, password, username);
            System.out.println(login.returnLoginstatus(username1, password1, password, username));
        
            if (login.loginUser(username1, password1, password, username))
            {
                System.out.println("welcome" + firstname + "" +lastname+ "it is great see you again");
            }
            else
            {
                System.out.println("username or password are incorrect try again");
                System.out.println("you have "+ tries + "tries remaining");
            }
            tries = 0;
            count = count + 1;
        }
    }
}
