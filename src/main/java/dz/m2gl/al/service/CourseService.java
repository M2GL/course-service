package dz.m2gl.al.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dz.m2gl.al.domain.Module;
import dz.m2gl.al.domain.Support;
import dz.m2gl.al.dto.CourseDto;
import dz.m2gl.al.repository.CourseRepository;
import dz.m2gl.al.repository.ModuleRepository;
import dz.m2gl.al.util.CourseTypes;



@Service
public class CourseService {
	
	 private final CourseRepository  courseRepository;
	 private final ModuleRepository moduleRepository;
	
	  public CourseService( CourseRepository courseRepository,ModuleRepository moduleRepository) {
	        this.courseRepository = courseRepository;
	        this.moduleRepository = moduleRepository;
	      
	    }
	
	  public Support updateCourse(Support oldOne, Support newOne) {
      oldOne.setName(newOne.getName());
      oldOne.setModule(newOne.getModule());
      oldOne.setDate(newOne.getDate());
      oldOne.setType(newOne.getType());
      
      
      return oldOne;

    }
	  
	  public Support delteCourse(Long id) {
		  Optional<Support> course = courseRepository.findById(id);
	        if (course.isPresent()) {
	        	courseRepository.delete(course.get());

	        }
	        return course.get();
	    }
	  
	  
	  public Support createCourse (CourseDto courseDto,Long id) {
		  
		  Optional <Module> moduleOp = moduleRepository.findById(id);
		  
		  if (!moduleOp.isPresent()) {
			  //throw new Exception("id: "+ id); 
		  }
		  
		  Module module = moduleOp.get();
		
		  
		  Support course = courseDto.getCourse();
		  module.getSupports().add(course);
		  moduleRepository.save(module);
		  course.setModule(module);
		  
		  Support savedCourse = courseRepository.save(course);
		  
		  
		
		 
		
		  return savedCourse;
		  
	  }
}
