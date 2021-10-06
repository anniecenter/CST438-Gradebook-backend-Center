package com.cst438;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;

import com.cst438.domain.Assignment;
import com.cst438.domain.AssignmentGrade;
import com.cst438.domain.AssignmentGradeRepository;
import com.cst438.domain.AssignmentRepository;
import com.cst438.domain.Course;
import com.cst438.domain.CourseRepository;
import com.cst438.domain.Enrollment;
import com.cst438.domain.EnrollmentRepository;

public class EndToEndTestCreateAssignment {

   public static final String CHROME_DRIVER_FILE_LOCATION = "C:/WebDriver/bin/chromedriver.exe";

   public static final String URL = "http://localhost:3000";
   public static final String TEST_USER_EMAIL = "test@csumb.edu";
   public static final String TEST_INSTRUCTOR_EMAIL = "dwisneski@csumb.edu";
   public static final int SLEEP_DURATION = 1000; // 1 second.

   @Autowired
   EnrollmentRepository enrollmentRepository;

   @Autowired
   CourseRepository courseRepository;

   @Autowired
   AssignmentGradeRepository assignnmentGradeRepository;

   @Autowired
   AssignmentRepository assignmentRepository;

   @Test
   public void addCourseTest() throws Exception {

//    Database setup:  create course      
      Course c = new Course();
      c.setCourse_id(99999);
      c.setInstructor(TEST_INSTRUCTOR_EMAIL);
      c.setSemester("Fall");
      c.setYear(2021);
      c.setTitle("Test Course");

//     add a student TEST into course 99999
      Enrollment e = new Enrollment();
      e.setCourse(c);
      e.setStudentEmail(TEST_USER_EMAIL);
      e.setStudentName("Test");

      courseRepository.save(c);
      e = enrollmentRepository.save(e);

      Assignment a = null;

      // set the driver location and start driver
      //@formatter:off
      // browser  property name           Java Driver Class
      // edge  webdriver.edge.driver      EdgeDriver
      // FireFox  webdriver.firefox.driver   FirefoxDriver
      // IE       webdriver.ie.driver     InternetExplorerDriver
      //@formatter:on

      System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_FILE_LOCATION);
      WebDriver driver = new ChromeDriver();
      // Puts an Implicit wait for 10 seconds before throwing exception
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

      driver.get(URL);
      Thread.sleep(SLEEP_DURATION);

      try {

      } catch (Exception ex) {
         throw ex;
      } finally {
         // clean up database.
         a = assignmentRepository.findById(a.getId());
         if (a!=null) assignmentRepository.delete(a);
         enrollmentRepository.delete(e);
         courseRepository.delete(c);

         driver.quit();
      }

   }
}
