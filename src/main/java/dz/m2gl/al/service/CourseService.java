package dz.m2gl.al.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dz.m2gl.al.domain.SessionPedag;
import dz.m2gl.al.dto.CourseDto;
import dz.m2gl.al.repository.CourseRepository;



@Service
public class CourseService {
	
	 private final CourseRepository  courseRepository;
	
	  public CourseService( CourseRepository courseRepository) {
	        this.courseRepository = courseRepository;
	      
	    }
	
	  public SessionPedag updateCourse(SessionPedag oldOne, SessionPedag newOne) {
      oldOne.setName(newOne.getName());
      oldOne.setModule(newOne.getModule());
      oldOne.setDate(newOne.getDate());
      oldOne.setType(newOne.getType());
      
      
      return oldOne;

    }
	  
	  public SessionPedag delteCourse(Long id) {
		  Optional<SessionPedag> course = courseRepository.findById(id);
	        if (course.isPresent()) {
	        	courseRepository.delete(course.get());

	        }
	        return course.get();
	    }
	  
	  
	  public SessionPedag createCourse (CourseDto courseDto) {
		  
		  SessionPedag course = courseDto.getCourse();
		  
		  courseRepository.save(course);
		  return course;
		  
	  }
}
