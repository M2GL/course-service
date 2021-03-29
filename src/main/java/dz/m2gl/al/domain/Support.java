package dz.m2gl.al.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
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
@Table(name = "course")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Support {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@Enumerated(EnumType.STRING)
	private CourseTypes type=CourseTypes.COURSE;

	private Date date= new Date();
	private int volumeH;

	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Module.class)
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_module_id"), name = "module_id", insertable = false, updatable = false)
	private Module module;

}
