package com.cst438.domain;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Assignment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
	
	@OneToMany(mappedBy="assignment")
	private List<AssignmentGrade> assignmentGrades;
	
	private String name;
	private Date dueDate;
	private int needsGrading;  // 0 = false,  1= true (past due date and not all students have grades)
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public int getNeedsGrading() {
		return needsGrading;
	}
	public void setNeedsGrading(int needsGrading) {
		this.needsGrading = needsGrading;
	}
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Assignment [id=" + id + ", course_id=" + course.getCourse_id() + ", name=" + name + ", dueDate=" + dueDate
				+ ", needsGrading=" + needsGrading + "]";
	}
   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((course == null) ? 0 : course.hashCode());
      result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
      result = prime * result + id;
      result = prime * result + ((name == null) ? 0 : name.hashCode());
      result = prime * result + needsGrading;
      return result;
   }
   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Assignment other = (Assignment) obj;
      if (course == null) {
         if (other.course != null)
            return false;
      } else if (!course.equals(other.course))
         return false;
      if (dueDate == null) {
         if (other.dueDate != null)
            return false;
      } else if (!dueDate.equals(other.dueDate))
         return false;
      if (id != other.id)
         return false;
      if (name == null) {
         if (other.name != null)
            return false;
      } else if (!name.equals(other.name))
         return false;
      if (needsGrading != other.needsGrading)
         return false;
      return true;
   }
	
}
