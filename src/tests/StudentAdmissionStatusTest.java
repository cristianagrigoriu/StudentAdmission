package tests;

import main.*;

import org.junit.Test;
//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

public class StudentAdmissionStatusTest {
   @Test
	
   public void testAverage() {
	  StudentAdmissionStatus s1 = new StudentAdmissionStatus(0, 0);
      assertEquals(0.0, s1.computeAverage(), 0.02);
	  StudentAdmissionStatus s2 = new StudentAdmissionStatus(10, 8);
      assertEquals(9.0, s2.computeAverage(), 0.02);
      StudentAdmissionStatus s3 = new StudentAdmissionStatus(10, 11);
      assertEquals(0, s3.computeAverage(), 0.02);
   }
   
   @Test
   public void testStatus() {
	  StudentAdmissionStatus s1 = new StudentAdmissionStatus(0, 0);
	  s1.computeAverage();
	  assertEquals(AdmissionStatus.REJECTED, s1.getAdmissionStatus());
	  StudentAdmissionStatus s2 = new StudentAdmissionStatus(10, 8);
	  s2.computeAverage();
      assertEquals(AdmissionStatus.ADMITTED, s2.getAdmissionStatus());
      StudentAdmissionStatus s3 = new StudentAdmissionStatus(10, 11);
      s3.computeAverage();
      assertEquals(AdmissionStatus.REJECTED, s1.getAdmissionStatus());
   }
   
   @Test
   public void testStudentName() {
	   Student s1 = new Student("Mitica", "Dorin", (float)6, (float) 9);
	   assertTrue(String.class.isInstance(s1.getFirstName()));
   }
}
