
package project;

import javax.swing.JOptionPane;

class Task {
    private String taskName;
    private String taskDescription;
    private int taskDuration;
    private String taskStatus;
    private String devFirstname;

    public Task() {
    }

    public Task(String taskName, String taskDescription, int taskDuration, String taskStatus,String devFirstname) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskDuration = taskDuration;
        this.taskStatus = taskStatus;
        this.devFirstname = devFirstname;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public int getTaskDuration() {
        return taskDuration;
    }

    public void setTaskDuration(int taskDuration) {
        this.taskDuration = taskDuration;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
    
    public String getdevFirstname (){
        return devFirstname;
    }
    
    public void setdevFirstname(String devFirstname){
        this.devFirstname = devFirstname;
    }
    
    public boolean CheckTaskDescription (String Description)
    {
        int length = Description.length();
         
        if (length <= 50)
        {
            return true;
        }
        return false;
    }
    
    public String CreatTaskID (String Taskname, int TaskNumber, String DeveloperName)
    {
        String id;
        id = Taskname.substring(0, 2)+":"+TaskNumber+":"+DeveloperName.substring(DeveloperName.length()-3);
        return id;
    }
    public boolean CheckTaskName(String TaskName)
    {
        int length;
        length = TaskName.length();
        
        if (length > 2)
        {
            return true;
        }
        return false;
    }
    public String printTaskDetail(String TaskStatus,String DevFirstName,String DevLastName,int TaskNumberOfTimes, String TaskName,
            String TaskDescription,String TaskID,int TaskDuration)
    {
        String TaskD="";
        for(int TaskNumber = 0; TaskNumber < TaskNumberOfTimes ; TaskNumber++ )
        {   TaskD = "Task status:"+TaskStatus +"\nDeveloper first name:"+DevFirstName +"\nDeveloper last name:"+DevLastName+
                         "\nTask number:"+TaskNumberOfTimes+"\nTask name:"+TaskName +"\nTask DEscription:"+TaskDescription+"\nTaskID:"+TaskID 
                         +"\nTask Duration:"+TaskDuration;
        return TaskD;
        }
        return TaskD;
    }
    
    public int returnTotalHours(int[] TaskDuration)
    { 
        int sum = 0;
        for (int count = 0;count < TaskDuration.length; count++)
        {
            sum =sum + TaskDuration[count];
        }
        return sum;
    }

    public void displayTaskDetails() {
        JOptionPane.showMessageDialog(null,"Task Name: " + taskName +"\nTask Description: " + taskDescription +"\nTask Duration: " + taskDuration + " hours" +"\nTask Status: " + taskStatus );
    }
}
