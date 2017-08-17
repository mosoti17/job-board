import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class JobTest{
  @After
  public void clearJobData(){
    Job.clear();
  }
  @Test
  public void job_jobIstatentsCorrectly(){
    Job testJob =new Job("Software developer","very urgent", 50000);
    assertTrue(testJob instanceof Job);
  }

  @Test
  public void getTitle_titleInstatentsCorrectly(){
    Job testJob =new Job("Software developer","very urgent", 50000);
    assertEquals("Software developer",testJob.getTitle());
  }
  @Test
  public void getDescription_descriptionInstatentsCorrectly(){
    Job testJob =new Job("Software developer","very urgent", 50000);
    assertEquals("very urgent",testJob.getDescription());
  }
  @Test
  public void getPay_payInstatantesCorrectly(){
    Job testJob =new Job("Software developer","very urgent", 50000);
    assertEquals(50000,testJob.getPay());
  }
  @Test
  public void getCreatedAt_TimeWhenTaskIsCreated_today(){
    Job testJob =new Job("Software developer","very urgent", 50000);
    assertEquals(LocalDateTime.now().getDayOfWeek(), testJob.getCreatedAt().getDayOfWeek());
  }
  @Test
  public void all_returnAllInstancesOfJob(){
    Job testJob1 =new Job("Software developer","very urgent", 50000);
    Job testJob2 =new Job("Accountant","CPAK", 80000);
    assertEquals(true, Job.all().contains(testJob1));
    assertEquals(true, Job.all().contains(testJob2));
  }
  @Test
  public void getId_jobsInstantateWithId_1(){
    Job testJob =new Job("Software developer","very urgent", 50000);
    assertEquals(1, testJob.getId());
  }
  @Test
public void find_returnsTaskWithSameId_secondJob(){
  Job testJob1 =new Job("Software developer","very urgent", 50000);
  Job testJob2 =new Job("Accountant","CPAK", 80000);
  assertEquals(Job.find(testJob2.getId()),testJob2);
}
}
