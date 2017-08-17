import java.util.List;
import java.util.ArrayList;
public  class City{
  private String mName;
  private int mId;
  private static List<City> instances = new ArrayList<City>();
  private List<Job> mJobs;

  public City(String name){
    mName= name;
    instances.add(this);
    mId= instances.size();
    mJobs= new ArrayList<Job>();
  }
  public String getName(){
    return mName;
  }
  public static List<City> all(){
    return instances;
  }
  public int getId(){
    return mId;
  }
  public static void clear(){
    instances.clear();
  }
  public static City find(int id){
    try{
    return instances.get(id-1);
  } catch(IndexOutOfBoundsException exception ){
 return null;
}
  }
  public List<Job> getJobs() {
   return mJobs;
 }
 public void addJob(Job job) {
mJobs.add(job);
}
}
