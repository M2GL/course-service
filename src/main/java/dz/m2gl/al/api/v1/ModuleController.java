package dz.m2gl.al.api.v1;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dz.m2gl.al.domain.Module;
import dz.m2gl.al.domain.Support;
import dz.m2gl.al.dto.CourseDto;
import dz.m2gl.al.dto.ModuleDto;
import dz.m2gl.al.repository.ModuleRepository;
import dz.m2gl.al.service.ModuleService;
import dz.m2gl.al.util.HeaderUtil;

@RestController
@RequestMapping("/api/v1")
public class ModuleController {
	private final ModuleRepository moduleRepository;
	private final ModuleService moduleService;

	public ModuleController(ModuleRepository moduleRepository, ModuleService moduleService) {
		this.moduleRepository = moduleRepository;
		this.moduleService = moduleService;

	}
	
	 @GetMapping("/modules")
	  public ResponseEntity getAll() {
	       

	        if (true) {
	          
	            return ResponseEntity.ok(moduleService.findAll());
	        }
	        return ResponseEntity.notFound().build();


	    }
	 @GetMapping("/module/{id}")
	    public ResponseEntity getOne(@PathVariable(value = "id") Long id) {

	      	ModuleDto moduleDto = moduleService.getOne(id);
	      	if (moduleDto == null) {
	      		 return ResponseEntity.notFound().build();
	      	} 
	       
	        return ResponseEntity.ok().body(moduleDto);
	       


	    }
	  @DeleteMapping("/module/{id}")
	    public ResponseEntity deleteCourse(@PathVariable(value = "id") Long id) {

		  try {
			  Module  module =moduleService.delteCourse(id);
			  return ResponseEntity.ok().body("Module deleted : "+module.getName());
		  
			  
		  }catch(Exception e){
			  return ResponseEntity.notFound().build();
		  }
	      
	      
	    }
	  @PutMapping("/module/{id}")
	    public ResponseEntity updateModule(@PathVariable(value = "id") Long id, @RequestBody Module newModule) throws URISyntaxException, InterruptedException, IOException {
	        Optional<Module> module = moduleRepository.findById(id);
	        if (module.isPresent()) {
	        	Module module2 = moduleService.updateModule(module.get(),newModule);

	            return ResponseEntity.created(new URI("/api/v1/module/" + module2.getId()))
	                    .headers(HeaderUtil.createAlert("A module is updated with identifier ", module2.getId()+""))
	                    .body(module2);
	        }

	        return ResponseEntity.notFound().build();
	    }
	  
	  @PostMapping("/module")
		public ResponseEntity ResponseEntity(@RequestBody ModuleDto moduleDto)
				throws URISyntaxException, InterruptedException, IOException {
		  
		  try {
			  Module module = moduleService.createModule(moduleDto);

				return ResponseEntity.created(new URI("/api/moduleDto/" + module.getId()))
						.headers(HeaderUtil.createAlert("A moduleDto is created with identifier ", module.getId() + ""))
						.body(module);
		  }catch (Exception e) {
			  return ResponseEntity.badRequest().body(e.toString());
		  }

			
		}

}
