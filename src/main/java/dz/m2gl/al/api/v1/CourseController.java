package dz.m2gl.al.api.v1;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import dz.m2gl.al.util.HeaderUtil;

import dz.m2gl.al.domain.SessionPedag;
import dz.m2gl.al.dto.CourseDto;
import dz.m2gl.al.repository.CourseRepository;
import dz.m2gl.al.service.CourseService;

@RestController
@RequestMapping("/api")
public class CourseController {
	 private final CourseRepository  courseRepository;
	 private final CourseService courseService;
	  public CourseController(CourseRepository courseRepository, CourseService courseService) {
	        this.courseRepository = courseRepository;
	        this.courseService =courseService;
	         
	    }
	  
	  @GetMapping("/courses")
	  public ResponseEntity getAll() {
	       

	        if (true) {
	          
	            return ResponseEntity.ok(courseRepository.findAll());
	        }
	        return ResponseEntity.notFound().build();


	    }
	  
	  @GetMapping("/courses/{id}")
	    public ResponseEntity getOne(@PathVariable(value = "id") Long id) {

	        Optional<SessionPedag> course = courseRepository.findById(id);
	        if (course.isPresent()) {
	            CourseDto courseDto = new CourseDto();
	            courseDto.setCourse(course.get());
	         
	            return ResponseEntity.ok(courseDto);

	        }
	        return ResponseEntity.notFound().build();


	    }
	  @DeleteMapping("/courses/{id}")
	    public ResponseEntity deleteCourse(@PathVariable(value = "id") Long id) {

		  try {
			  SessionPedag course = courseService.delteCourse(id);
			  return ResponseEntity.ok().body(course);
		  
			  
		  }catch(Exception e){
			  return ResponseEntity.notFound().build();
		  }
	      
	      
	    }
	  @PutMapping("/courses/{id}")
	    public ResponseEntity updateCourse(@PathVariable(value = "id") Long id, @RequestBody SessionPedag newCourse) throws URISyntaxException, InterruptedException, IOException {
	        Optional<SessionPedag> course = courseRepository.findById(id);
	        if (course.isPresent()) {
	        	SessionPedag course2 = courseService.updateCourse(course.get(), newCourse);

	            return ResponseEntity.created(new URI("/api/courses/" + course.get().getId()))
	                    .headers(HeaderUtil.createAlert("A course is updated with identifier ", course2.getId()+""))
	                    .body(course2);
	        }

	        return ResponseEntity.notFound().build();
	    }
	  
	   @PostMapping("/course")
	    public ResponseEntity ResponseEntity (@RequestBody CourseDto courseDto) throws URISyntaxException, InterruptedException, IOException {


		   SessionPedag course = courseService.createCourse(courseDto);

	        return ResponseEntity.created(new URI("/api/course/" + course.getId()))
	                .headers(HeaderUtil.createAlert("A course is created with identifier ", course.getId()+""))
	                .body(course);
	    }
	  
}
