import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
public class Job{
private String mTitle;
private String mDescription;
private int mPay;
private LocalDateTime mCreatedAt;
private static List<Job> instances = new ArrayList<Job>();
private int mId;
public Job(String title, String description, int pay){
  mTitle = title;
  mDescription = description;
  mPay =pay;
  mCreatedAt =LocalDateTime.now();
  instances.add(this);
  mId = instances.size();
}
public String getTitle(){
  return mTitle;
}
public String getDescription(){
  return mDescription;
}
public int getPay(){
  return mPay;
}
public LocalDateTime getCreatedAt(){
    return mCreatedAt;
  }
  public static List<Job> all(){
    return instances;
  }
  public static void clear(){
  instances.clear();
}
public int getId(){
  return mId;
}
public static Job find(int id){
  return instances.get(id-1);
}

}
