
package project;

import javax.swing.JOptionPane;

public class Project {
    public static void main(String[] args) {
        String username, firstname, lastname, username1, password1;
        int TaskNumberOfTimes, ChooseStatus, TaskNumber;
        
        login login = new login();
        /*
        username = JOptionPane.showInputDialog("Enter your username: ");
        login.checkUserName(username);
        if (login.checkUserName(username)) {
            JOptionPane.showMessageDialog(null, "username successfully captured");
        } else {
            JOptionPane.showMessageDialog(null, "username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
        }

        String password = JOptionPane.showInputDialog("Enter your password: ");
        login.checkPasswordComplexity(password);
        if (login.checkPasswordComplexity(password)) {
            JOptionPane.showMessageDialog(null, "password successfully captured");
        } else {
            JOptionPane.showMessageDialog(null, "password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
        }

        while (!login.checkUserName(username) || !login.checkPasswordComplexity(password)) {
            username = JOptionPane.showInputDialog("Enter your username: ");
            login.checkUserName(username);
            if (login.checkUserName(username)) {
                JOptionPane.showMessageDialog(null, "username successfully captured");
            } else {
                JOptionPane.showMessageDialog(null, "username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length");
            }
            password = JOptionPane.showInputDialog("Enter your password: ");
            login.checkPasswordComplexity(password);
            if (login.checkPasswordComplexity(password)) {
                JOptionPane.showMessageDialog(null, "password successfully captured");
            } else {
                JOptionPane.showMessageDialog(null, "password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
            }
        }

        firstname = JOptionPane.showInputDialog("Enter your firstname: ");
        lastname = JOptionPane.showInputDialog("Enter your lastname: ");
        JOptionPane.showMessageDialog(null, login.registerUser(password, username));

        JOptionPane.showMessageDialog(null, "to login");
        username1 = JOptionPane.showInputDialog("enter your username");
        password1 = JOptionPane.showInputDialog("Enter your password");
        login.loginUser(username1, password1, password, username);
        login.returnLoginstatus(username1, password1, password, username);
        JOptionPane.showMessageDialog(null, login.returnLoginstatus(username1, password1, password, username));

        if (login.loginUser(username1, password1, password, username)) {
            JOptionPane.showMessageDialog(null, "welcome " + firstname + " " + lastname + " it is great to see you again");
        } else {
            JOptionPane.showMessageDialog(null, "username or password are incorrect, try again");
        }

        int count = 0;

        while (count != 2 && !login.loginUser(username1, password1, password, username)) {
            username1 = JOptionPane.showInputDialog("enter your username");
            password1 = JOptionPane.showInputDialog("Enter your password");
            login.loginUser(username1, password1, password, username);
            login.returnLoginstatus(username1, password1, password, username);
            JOptionPane.showMessageDialog(null, login.returnLoginstatus(username1, password1, password, username));
            if (login.loginUser(username1, password1, password, username)) {
                JOptionPane.showMessageDialog(null, "welcome " + firstname + " " + lastname + " it is great to see you again");
            } else {
                JOptionPane.showMessageDialog(null, "username or password are incorrect, try again");
            }
            count = count + 1;
        }*/
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        String TaskNumberTimesSTR = JOptionPane.showInputDialog("How many tasks would you like to enter?");
        TaskNumberOfTimes = Integer.parseInt(TaskNumberTimesSTR);
        
        int[] taskDuration = new int [TaskNumberOfTimes];
        String[] taskDescription = new String [TaskNumberOfTimes];
        String [] devFirstName = new String [TaskNumberOfTimes];
        String[] taskName = new String [TaskNumberOfTimes];
        String[] taskId = new String [TaskNumberOfTimes];
        Task[] tasksArray = new Task[TaskNumberOfTimes];
        Task task1 = new Task();
        

        int j = 0;
        for (int coun = 0; coun < coun+1; coun++) {
            Object[] options = {"Option 1: Adds TASK", "Option 2: Show report", "Option 3: Quit"};
            int choice = JOptionPane.showOptionDialog(null, "Choose one:", "Option Dialog Example",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            if (choice != JOptionPane.CLOSED_OPTION) {
                switch (choice) {
                    case 0:
                        if (j < TaskNumberOfTimes ){
                            taskName[j] = JOptionPane.showInputDialog("Enter Taskname:");
                            if (!task1.CheckTaskName(taskName[j])) {
                                JOptionPane.showMessageDialog(null, "Please enter more than two characters");
                                taskName[j] = JOptionPane.showInputDialog("Enter Taskname:");
                                task1.CheckTaskName(taskName[j]);
                            }
                            TaskNumber = j;
                            devFirstName[j] = JOptionPane.showInputDialog("Enter developer first name:");
                            taskDescription[j] = JOptionPane.showInputDialog("Enter task description:");
                            task1.CheckTaskDescription(taskDescription[j]);
                            if (!task1.CheckTaskDescription(taskDescription[j])) {
                                while (!task1.CheckTaskDescription(taskDescription[j])) {
                                    JOptionPane.showMessageDialog(null, "please make sure it's not longer than 50 characters");
                                    taskDescription[j] = JOptionPane.showInputDialog("Enter task description:");
                                    task1.CheckTaskDescription(taskDescription[j]);
                                }
                            }
                            String taskDurationStr = JOptionPane.showInputDialog("Enter the duration of the task in hours:");
                            taskDuration[j] = Integer.parseInt(taskDurationStr);
                            String chooseStatusStr = JOptionPane.showInputDialog("What is the status of the task from (1) TO DO, (2) DONE or (3) DOING:");
                            ChooseStatus = Integer.parseInt(chooseStatusStr);
                            String taskStatus = "";
                            switch (ChooseStatus) {
                                case 1:
                                    taskStatus = "TO DO";
                                    JOptionPane.showMessageDialog(null, taskStatus);
                                    break;
                                case 2:
                                    taskStatus = "DONE";
                                    JOptionPane.showMessageDialog(null, taskStatus);
                                    break;
                                case 3:
                                    taskStatus = "DOING";
                                    JOptionPane.showMessageDialog(null, taskStatus);
                                    break;
                                default:
                                    JOptionPane.showMessageDialog(null, "choice 1 to 3 please");
                                    break;
                            }
                            taskId[j] = task1.CreatTaskID(taskName[j], TaskNumber, devFirstName[j]);
                            JOptionPane.showMessageDialog(null, "your id is: " + taskId[j]);
                            Task task = new Task(taskName[j], taskDescription[j], taskDuration[j], taskStatus, devFirstName[j] );
                            tasksArray[j] = task;
                            j = j + 1;
                            

                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "ADD TASK can no longer be used.");
                        }
                        break;
                    case 1:
                        Object[] options1 = {"Deplay done tasks", "Display developer of the longest duration", "Search for a task","Delete task"," display full report"};
                        int pick = JOptionPane.showOptionDialog(null, "Choose one:", "Option Dialog Example",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options1, options1[0]);
                        if (pick != JOptionPane.CLOSED_OPTION) {
                            switch (pick)
                            {
                                case 0:
                                    for (Task task : tasksArray) {
                                    if (task != null && "DONE".equals(task.getTaskStatus())) {
                                    JOptionPane.showMessageDialog(null,"TASK NAME: "+task.getTaskName()+"\nTASK DURATION: "+task.getTaskDuration()+"\nDEVELOPER NAME: "+task.getdevFirstname());
                                    }
                                    }    
                                    break;
                                case 1:

                                    Task longestTask = null;
                                    int MaxDuration = -1;

                                    for (Task task : tasksArray) {
                                        if (task != null && task.getTaskDuration() > MaxDuration) {
                                            MaxDuration = task.getTaskDuration();
                                            longestTask = task;
                                        }
                                    }

                                    if (longestTask != null) {
                                        JOptionPane.showMessageDialog(null,"Task with the longest duration: " + longestTask.getTaskName()+" Task"+"\nwhich has:"+longestTask.getTaskDuration()+" hours");
                                    } else {
                                        JOptionPane.showMessageDialog(null,"No tasks found.");
                                    }
                                    break;
                                case 2:

                                    String PickTask = JOptionPane.showInputDialog("Enter Taskname of the task you want to display:");
                                    boolean TaskFound = false;


                                    Object[] picking = {"Yes", "No"};
                                    int Makesure = JOptionPane.showOptionDialog(null, "Do you want to continue?", "Option Dialog Example",
                                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, picking, picking[0]);
                                    if (Makesure != JOptionPane.CLOSED_OPTION) {
                                        switch (Makesure)
                                        {
                                            case 0:
                                                for (Task task : tasksArray)
                                                {   
                                                    if(task != null && PickTask.equals(task.getTaskName()))
                                                    {
                                                        JOptionPane.showMessageDialog(null,"TASK NAME: "+task.getTaskName()+"\nDEVELOPER NAME: "+task.getdevFirstname()+"\nTASK STATUS: "+task.getTaskStatus());
                                                        TaskFound = true;
                                                        break;

                                                    }

                                                }
                                                if (!TaskFound)
                                                    {
                                                        JOptionPane.showMessageDialog(null,"Task not found try another name you only get 5 tries");
                                                    }
                                                JOptionPane.showMessageDialog(null,"the number of Tasks is the number of tries");
                                                for (int p = 0; p < TaskNumberOfTimes;p++)
                                                {
                                                    Object[] picking1 = {"Yes", "No"};
                                                    int Makesure1 = JOptionPane.showOptionDialog(null, "DO you want to try again?", "Option Dialog Example",
                                                       JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, picking1, picking1[0]);
                                                    if (Makesure1 != JOptionPane.CLOSED_OPTION) {
                                                       switch (Makesure1)
                                                       {
                                                            case 0:
                                                               PickTask = JOptionPane.showInputDialog("Enter Taskname:");
                                                               for (Task task : tasksArray)
                                                               {   
                                                                   if(task != null && PickTask.equals(task.getTaskName()))
                                                                   {
                                                                       JOptionPane.showMessageDialog(null,"TASK NAME: "+task.getTaskName()+"\nDEVELOPER NAME: "+task.getdevFirstname()+"\nTASK STATUS: "+task.getTaskStatus());
                                                                       TaskFound = true;

                                                                   }

                                                               }
                                                               if (!TaskFound)
                                                               {
                                                                   JOptionPane.showMessageDialog(null,"Task not found try again");
                                                               }
                                                               break;
                                                            case 1:
                                                               JOptionPane.showMessageDialog(null,"Good bye");
                                                               System.exit(0);
                                                           }   
                                                    }
                                                }
                                                break;
                                            case 1:
                                                JOptionPane.showMessageDialog(null,"Good bye");
                                                break;
                                        }
                                    }
                                    break;
                                case 3:
                                    String ChooseTask = JOptionPane.showInputDialog("Enter Developer name:");
                                    boolean TaskFound1 = false;

                                    Object[] picking1 = {"Yes", "No"};
                                    int Makesure1 = JOptionPane.showOptionDialog(null, "ARE YOU SURE:", "Option Dialog Example",
                                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, picking1, picking1[0]);
                                    if (Makesure1 != JOptionPane.CLOSED_OPTION) {
                                        switch (Makesure1)
                                        {
                                            case 0:
                                                for (int i = 0; i < tasksArray.length; i++) {
                                                    if (tasksArray[i] != null && tasksArray[i].getTaskName().equals(ChooseTask)) {
                                                        tasksArray[i] = null;

                                                        JOptionPane.showMessageDialog(null, "Task deleted.");
                                                        TaskFound1 = true;

                                                    }
                                                }
                                                if (!TaskFound1)
                                                {
                                                    JOptionPane.showMessageDialog(null, "Task not found. try again you have 5 tries");
                                                }
                                                Object[] picking2 = {"Yes", "No"};
                                                int Makesure2 = JOptionPane.showOptionDialog(null, "do you want to try again?:", "Option Dialog Example",
                                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, picking2, picking2[0]);
                                                if (Makesure2 != JOptionPane.CLOSED_OPTION) {
                                                    switch (Makesure2)
                                                    {
                                                        case 1:
                                                            for (int k = 0;k < 5 && !TaskFound1;k++){
                                                                for (int m = 0; m < tasksArray.length; m++) {
                                                                    if (tasksArray[m] != null && tasksArray[m].getTaskName().equals(ChooseTask)) {
                                                                        tasksArray[m] = null;

                                                                        JOptionPane.showMessageDialog(null, "Task deleted.");
                                                                        TaskFound1 = true;
                                                                    }
                                                                }
                                                            }

                                                            if (!TaskFound1)
                                                            {
                                                            JOptionPane.showMessageDialog(null, "Task not found. try again");
                                                            }
                                                            break;
                                                        case 2:
                                                            JOptionPane.showMessageDialog(null,"Good bye");
                                                            break;
                                                    }
                                                }
                                                break;
                                            case 1:
                                                JOptionPane.showMessageDialog(null,"Good bye");
                                                System.exit(0);
                                                break;
                                        }
                                    }
                                case 4:
                                    for (Task task : tasksArray) 
                                    {
                                        task.displayTaskDetails();
                                    }
                                    break;
                            }
                        }
                        break;
                    case 2:
                        System.exit(0);
                    default:
                        
                        JOptionPane.showMessageDialog(null, "please choose from 1 to 3 of the options");
                        break;
                }
            }
        }

        for (Task task : tasksArray) {
            if (task != null) {
                task.displayTaskDetails();
            }
        }

        JOptionPane.showMessageDialog(null, "The total hours is " + task1.returnTotalHours(taskDuration));
        
    } 
}
        

