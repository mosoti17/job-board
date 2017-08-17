import org.junit.*;
import static org.junit.Assert.*;
public class CityTest{
  @After
  public void clearTestCity(){
    City.clear();
  }
  @Test
  public void city_cityInstantatesCorrectly_true(){
    City testCity = new City("Nairobi");
    assertTrue( testCity instanceof City);
  }
  @Test
  public void getName_nameInstatentsCorrectly_nairobi(){
    City testCity = new City("Nairobi");
    assertEquals("Nairobi", testCity.getName());
  }
  @Test
  public void all_returnAllInstancesOfCity(){
  City city1 = new City("Nairobi");
  City city2= new City("Kisii");
  assertTrue(City.all().contains(city2));
  assertTrue(City.all().contains(city1));
  }
  @Test
  public void getId_returnCityId_1(){
    City testCity = new City("Nairobi");
    assertEquals(1, testCity.getId());
  }
  @Test
  public void getId_returnLocationForItem_1(){
    City city1 = new City("Nairobi");
    City city2= new City("Kisii");
    assertEquals(City.find(city2.getId()),city2);
  }
  @Test
public void getJobs_initiallyReturnsEmptyList_ArrayList() {
  City testCity = new City("Nairobi");
 assertEquals(0, testCity.getJobs().size());
}
@Test
public void addJob_addsJobToList_true() {
  City testCity = new City("Nairobi");
  Job testJob = new Job("Mow the lawn","today", 200);
  testCity.addJob(testJob);
  assertTrue(testCity.getJobs().contains(testJob));
}

}
