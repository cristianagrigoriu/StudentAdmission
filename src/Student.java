public class Student {
	private String firstName;
	private String lastName;
	private float gradeHighschool;
	private float gradeExam;
	private float average;
	private AdmissionStatus status;
	StudentAdmissionStatus sas;
	
	public Student(String firstName, String lastName, float gradeHighschool, float gradeExam)
	{
	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.gradeHighschool = gradeHighschool;
	    this.gradeExam = gradeExam;
	    this.sas = new StudentAdmissionStatus(this.gradeHighschool, this.gradeExam);
	    this.average = getAverage();
	    this.status = getStatus();
	}
	
	public void setFirstName(String firstName) {
       this.firstName = firstName;
    }

    public String getFirstName() {
       return firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
     }

     public String getLastName() {
        return lastName;
     }
     
     public void setGradeHighschool(float grade) {
         this.gradeHighschool = grade;
      }

      public float getGradeHighschool() {
         return gradeHighschool;
      }
      
      public void setGradeExam(float grade) {
          this.gradeExam = grade;
       }

       public float getGradeExam() {
          return gradeExam;
       }

        public float getAverage() {
        	return sas.computeAverage();
        }
        
        public AdmissionStatus getStatus() {
        	return sas.getAdmissionStatus();
        }
}
