package dz.m2gl.al.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dz.m2gl.al.util.CourseTypes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "course")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SessionPedag {
	@Id
    @GeneratedValue
    private int id;
    private String name;
  
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Module.class)
    @JoinColumn(name="module_id")
    private Module module;
   
    private CourseTypes type;
    
    private Date date;
     private int volumeH ;
}
