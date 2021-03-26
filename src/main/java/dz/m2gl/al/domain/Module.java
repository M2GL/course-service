package dz.m2gl.al.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "modules")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Module {
	@Id
    @GeneratedValue
    private int id;
    private String name;
  
    private Integer coef;
    //volume horaire : td,td,cours
    //liste des enseignant affecter aux module
    
 
}
