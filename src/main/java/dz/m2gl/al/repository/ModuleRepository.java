package dz.m2gl.al.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



import dz.m2gl.al.domain.Module;

public interface ModuleRepository extends JpaRepository<Module, Long> {

	Optional<Module> findOneById(String id);

	List<Module> findAll();

}
