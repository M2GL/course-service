package dz.m2gl.al.repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dz.m2gl.al.domain.Support;




public interface CourseRepository  extends JpaRepository<Support, Long> {
	Optional<Support> findOneById(String id);

	List<Support> findAll();
	
	
}
