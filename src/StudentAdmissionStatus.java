
public class StudentAdmissionStatus {
	float grade1, grade2;
	float average;
	AdmissionStatus status;
	
	public StudentAdmissionStatus(float grade1, float grade2) {
		this.grade1 = grade1;
		this.grade2 = grade2;
	}
	
	public float computeAverage() {
		this.average = (float) (this.grade1 + this.grade2) / 2;
		return this.average;
	}
	
	public AdmissionStatus getAdmissionStatus() {
		if (this.average < 0 || this.average > 10)
			return null;
		if (this.average >= 9.5)
			status = AdmissionStatus.ADMITTEDONSCHOLARSHIP;
		else if (this.average >= 7)
			status = AdmissionStatus.ADMITTED;
			else if (this.average >= 5.5)
					status = AdmissionStatus.ADMITTEDONTAX;
				else status = AdmissionStatus.REJECTED;
		return status;
	}
}
