
package project;

public class Tasks 
{
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
}
