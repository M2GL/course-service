package dz.m2gl.al.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dz.m2gl.al.domain.Module;
import dz.m2gl.al.domain.Support;
import dz.m2gl.al.dto.CourseDto;
import dz.m2gl.al.dto.ModuleDto;
import dz.m2gl.al.repository.ModuleRepository;



@Service
public class ModuleService {
	
	private final ModuleRepository moduleRepository;


	public ModuleService(ModuleRepository moduleRepository) {
		this.moduleRepository = moduleRepository;
	

	}
	
	public List <Module> findAll() {
		
		return moduleRepository.findAll();
		
	}
	
	public ModuleDto getOne(Long id) {
		  Optional<Module> module = moduleRepository.findById(id);
		
		 if (module.isPresent()) {
	            ModuleDto moduleDto = new ModuleDto();
	            moduleDto.setModule(module.get());
	         
	            return moduleDto;

	        } else  return null;
		
		
	}
	
	public Module delteCourse(Long id) {
		 //Optional<Module> module = moduleRepository.findById(id);
		  moduleRepository.deleteById(id);
		  Optional<Module> module = moduleRepository.findById(id);
	        if (module.isPresent()) {
	        	moduleRepository.delete(module.get());

	        }
	        return module.get();
		
	}
	
	public Module updateModule(Module module,Module newmod) {
		
		module.setCoef(newmod.getCoef());
		module.setName(newmod.getName());
		Module modN = moduleRepository.save(module);
		return modN;
		
	}
	
	public Module createModule(ModuleDto moduleDto) {
		 Module module = moduleDto.getModule();
		  
		 moduleRepository.save(module);
		 return module;
		
	}

}
