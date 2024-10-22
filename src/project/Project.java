
package project;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Project {

    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        String username,firstname,lastname,username1,TaskStatus,password1,DevFirstName,DevLastName,
                TaskName,TaskDescription,TaskID;
        int TaskNumberOfTimes,ChooseStatus,TaskNumber;
        login login = new login();
        Tasks tasks = new Tasks();
        
        username = JOptionPane.showInputDialog("Enter your username: ");
        login.checkUserName(username);
        if (login.checkUserName(username))
        {
            JOptionPane.showMessageDialog(null,"username successfully captured");
        }
        else
        {
            JOptionPane.showMessageDialog(null,"username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in legth");
        }
        String password = JOptionPane.showInputDialog("Enter your password: ");
        login.checkPasswordComplexity(password);
        if (login.checkPasswordComplexity(password))
        {
            JOptionPane.showMessageDialog(null,"password successfully captured");
        }
        else
        {
            JOptionPane.showMessageDialog(null,"password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
        }
        
        while(!login.checkUserName(username) || !login.checkPasswordComplexity(password))
        {
            username = JOptionPane.showInputDialog("Enter your username: ");
            login.checkUserName(username);
            if (login.checkUserName(username))
            {
                JOptionPane.showMessageDialog(null,"username successfully captured");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in legth");
            }
            password = JOptionPane.showInputDialog("Enter your password: ");
            login.checkPasswordComplexity(password);
            if (login.checkPasswordComplexity(password))
            {
                JOptionPane.showMessageDialog(null,"password successfully captured");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
            }

        }
        firstname = JOptionPane.showInputDialog("Enter your firstname: ");
        lastname = JOptionPane.showInputDialog("Enter your lastname: ");     
        JOptionPane.showMessageDialog(null,login.registerUser(password, username));
        
        
        JOptionPane.showMessageDialog(null,"to login");
        username1  = JOptionPane.showInputDialog("enter your username"); 
        password1  = JOptionPane.showInputDialog("Enter your password");
        login.loginUser(username1, password1, password, username);
        
        login.returnLoginstatus(username1, password1, password, username);
        JOptionPane.showMessageDialog(null,login.returnLoginstatus(username1, password1, password, username));
        
        if (login.loginUser(username1, password1, password, username))
        {
           JOptionPane.showMessageDialog(null,"welcome" + firstname + "" +lastname+ "it is great see you again");
        }
        else
        {
            JOptionPane.showMessageDialog(null,"username or password are incorrect try again");
        }
        
        int count = 0;
        int tries = 1;
        while (count !=2 && !login.loginUser(username1, password1, password, username) )
        {
            username1  = JOptionPane.showInputDialog("enter your username"); 
            password1  = JOptionPane.showInputDialog("Enter your password");
            login.loginUser(username1, password1, password, username);
        
            login.returnLoginstatus(username1, password1, password, username);
            JOptionPane.showMessageDialog(null,login.returnLoginstatus(username1, password1, password, username));
        
            if (login.loginUser(username1, password1, password, username))
            {
                JOptionPane.showMessageDialog(null,"welcome" + firstname + "" +lastname+ "it is great see you again");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"username or password are incorrect try again");
            }
            tries = 0;
            count = count + 1;
        }
        
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
        
        String TaskNumberTimesSTR = JOptionPane.showInputDialog("how many task would you like to enter");
        TaskNumberOfTimes = Integer.parseInt(TaskNumberTimesSTR);
        int[] TaskDuration = new int[TaskNumberOfTimes];
        String[] TaskDetail = new String[TaskNumberOfTimes];
        int pickOption;
        
        int j = 0;
        
        for (int coun = 0;coun < TaskNumberOfTimes;coun++)
        {
            String pickOptionSTR = JOptionPane.showInputDialog("pick from \nOption1: Adds TASK \nOption2: Show report\nOption3: Quit");
            
            pickOption = Integer.parseInt( pickOptionSTR);
            if(pickOption == 1)
            {
                
                TaskName = JOptionPane.showInputDialog("Enter Taskname:");
                if (!tasks.CheckTaskName(TaskName))
                {
                    JOptionPane.showMessageDialog(null,"Please enter more thean two characters");
                    TaskName = JOptionPane.showInputDialog("Enter Taskname:");
                    tasks.CheckTaskName(TaskName);
                }
                
                TaskNumber = j;
                
                DevFirstName = JOptionPane.showInputDialog("Enter devloper first name:");
                DevLastName = JOptionPane.showInputDialog("Enter developer last name:");
                
                TaskDescription = JOptionPane.showInputDialog("Enter task description::");
                tasks.CheckTaskDescription(TaskDescription);
                if(!tasks.CheckTaskDescription(TaskDescription))
                {
                    while(!tasks.CheckTaskDescription(TaskDescription))
                    {
                        JOptionPane.showMessageDialog(null,"please make sure its not longer then 50 characters");
                        TaskDescription = JOptionPane.showInputDialog("Enter task description::");
                        tasks.CheckTaskDescription(TaskDescription);
                    }
                }
                
                String TaskDurationSTR = JOptionPane.showInputDialog("Enter the duration of the task in hours");
                TaskDuration[j] = Integer.parseInt(TaskDurationSTR);
                
                String ChooseStatusSTR = JOptionPane.showInputDialog("What is the status of the task from (1)TO DO, (2)DONE OR (3)DOING");
                ChooseStatus = Integer.parseInt(ChooseStatusSTR);
                TaskStatus ="";
                if( ChooseStatus == 1){TaskStatus = "TO DO";JOptionPane.showMessageDialog(null,TaskStatus);}
                else if (ChooseStatus == 2){TaskStatus ="DONE";JOptionPane.showMessageDialog(null,TaskStatus);}
                else if(ChooseStatus == 3){TaskStatus = "DOING";JOptionPane.showMessageDialog(null,TaskStatus);}
                TaskID = tasks.CreatTaskID(TaskName,TaskNumber,DevFirstName);
                JOptionPane.showMessageDialog(null,"your id is: "+TaskID);
                TaskDetail[j] = tasks.printTaskDetail(TaskStatus,DevFirstName,DevLastName,TaskNumberOfTimes,TaskName,TaskDescription,TaskID,TaskDuration[j]);
            }
            else if(pickOption == 2)
            {
                JOptionPane.showMessageDialog(null,"Coming soon");
            }
            else if(pickOption == 3)
            {
                System.exit(0);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"please choice from 1 to 3 of the options");
            }
            j= j+1;
        }
        int c = 0;
        while (c < TaskDetail.length)
        {
            JOptionPane.showMessageDialog(null,TaskDetail[c]); 
            c = c + 1;
        }
        JOptionPane.showMessageDialog(null,"the total hours is fg "+tasks.returnTotalHours(TaskDuration));
    }   
}
