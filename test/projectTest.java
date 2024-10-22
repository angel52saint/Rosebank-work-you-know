
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class projectTest {
    
    public projectTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        
    }

    @AfterAll
    public static void tearDownClass() {
        
    }

    @BeforeEach
    public void setUp() {
        
    }

    @AfterEach
    public void tearDown() {
        
    }

     
    @Test
    public void testCheckTaskDescription() {
        testgod hoe = new testgod();

        String SD = "short description";
        String LD = "This is a very long description that exceeds 50 characters in length.";

        assertTrue(SD.length() <= 50, "Task description successfully captured");
        assertFalse(LD.length() <= 50, "Please enter a task description of less than 50 characters");
    }
     
    @Test
    public void testCreatTaskID () {
        testgod hoe = new testgod();

        String taskID = hoe.CreatTaskID("Add", 1, "Byn");
        assertEquals("AD:1:BYN", taskID, "Task ID should be AD:1:BYN");

        
        assertEquals("CR:0:IKE", hoe.CreatTaskID("Creak", 0, "bike"), "Task ID should be CR:0:IKE");
        assertEquals("CR:1:ARD", hoe.CreatTaskID("Creak", 1, "Bastrard"), "Task ID should be CR:1:ARD");
        assertEquals("CR:2:THA", hoe.CreatTaskID("Creak", 2, "homathan"), "Task ID should be CR:2:HAN");
        assertEquals("CR:3:ND", hoe.CreatTaskID("Creak", 3, "find"), "Task ID should be CR:3:IND");
    }

    @Test 
    public void testTotalHoursAccumulation() {
        testgod hoe = new testgod();

        int[] Hours1 = {10, 8};
        int[] Hours2 = {10, 12, 55, 11, 1};

        int Duration1 = hoe.returnTotalHours(Hours1);
        int Duration2 = hoe.returnTotalHours(Hours2);

        assertEquals(18, Duration1, "Total hours should be 18 for the first data set");
        assertEquals(89, Duration2, "Total hours should be 89 for the additional data set");
    }
}


class testgod {
    
    
    public String CreatTaskID (String Taskname, int TaskNumber, String DeveloperName)
    {
        String id;
        id = Taskname.substring(0, 2)+":"+TaskNumber+":"+DeveloperName.substring(DeveloperName.length()-3);
        return id.toUpperCase();
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
    
    
    public boolean CheckTaskDescription (String Description)
    {
        int length = Description.length();
         
        if (length <= 50)
        {
            return true;
        }
        return false;
    }
}