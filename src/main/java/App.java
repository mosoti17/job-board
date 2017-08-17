import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.List;
import java.util.ArrayList;
public class App{
  public static void main(String[] args){
    ProcessBuilder process = new ProcessBuilder();
     Integer port;
     if (process.environment().get("PORT") != null) {
         port = Integer.parseInt(process.environment().get("PORT"));
     } else {
         port = 4567;
     }

    setPort(port);
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";
    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    get("/cities/new", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("template", "templates/city-form.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
      post("/cities", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
      City newCity = new City(name);
      model.put("template", "templates/city-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    get("/cities", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("cities", City.all());
        model.put("template", "templates/cities.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
      get("/cities/:id", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        City city = City.find(Integer.parseInt(request.params(":id")));
        model.put("city", city);
        model.put("template", "templates/city.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
      get("cities/:id/jobs/new", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        City city = City.find(Integer.parseInt(request.params(":id")));
        model.put("city", city);
        model.put("template", "templates/city-job-form.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
      post("/jobs", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      City city = City.find(Integer.parseInt(request.queryParams("cityId")));
      String title = request.queryParams("title");
      String description = request.queryParams("description");
      int pay = Integer.parseInt(request.queryParams("pay"));
      Job newJob = new Job(title, description, pay);
      city.addJob(newJob);
      model.put("city", city);
      model.put("template", "templates/city-job-success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
    get("cities/:id/jobs/:id", (request, response) -> {
        Map<String, Object> model = new HashMap<String, Object>();
        Job job = Job.find(Integer.parseInt(request.params(":id")));
        model.put("jobs", Job.all());
        model.put("template", "templates/job.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());
    // get("/jobs/:id", (request, response) -> {
    //   Map<String, Object> model = new HashMap<String, Object>();
    //   Job job = Job.find(Integer.parseInt(request.params(":id")));
    //   model.put("job", job);
    //   model.put("template", "templates/job.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
  }
}
