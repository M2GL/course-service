package dz.m2gl.al.api.v1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class CourseRestService {
	@Value("${me}")
	  private String me;

	  @RequestMapping("/messages")
	  public String tellMe(){
	      System.out.println("c'est moi qui ai répondu!");
	      return me;
	  }
}
