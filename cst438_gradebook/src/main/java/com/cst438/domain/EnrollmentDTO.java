package com.cst438.domain;

public class EnrollmentDTO {
	public int id;
	public String studentEmail;
	public String studentName;
	public int course_id;
	
	public EnrollmentDTO() { } ;
	
	public EnrollmentDTO(String studentEmail, String studentName, int course_id) {
		this.id = 0;
		this.studentEmail=studentEmail;
		this.studentName=studentName;
		this.course_id = course_id;
	}
	
	public EnrollmentDTO(Enrollment enrollment) {
	   this.id = enrollment.getId();
      this.studentEmail= enrollment.getStudentEmail();
      this.studentName= enrollment.getStudentName();
      this.course_id = enrollment.getCourse().getCourse_id();
	}
}
