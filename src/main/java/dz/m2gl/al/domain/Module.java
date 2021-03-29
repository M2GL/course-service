package dz.m2gl.al.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


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
    private Long id;
	 //@NotBlank(message = "Name is mandatory")

    private String name;
  
    private Integer coef;
    
 
	@OneToMany(mappedBy = "module", cascade = CascadeType.ALL,targetEntity=Support.class, fetch = FetchType.LAZY)
	private List<Support> supports = new ArrayList<>();
    
   
    //volume horaire : td,td,cours
    //liste des enseignant affecter aux module
    
 
}
