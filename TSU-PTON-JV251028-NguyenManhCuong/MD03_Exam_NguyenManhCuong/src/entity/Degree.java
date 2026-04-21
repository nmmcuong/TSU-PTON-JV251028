package entity;

import java.sql.Timestamp;

public class Degree {
	private int dergeeId;
	private String degreeName;
	private String empId;
	private Timestamp degreeDate;
	private String schoolName;
	private int degreeYear;
	private String degreeClassification;
	
	public Degree() {};
	
	public Degree(int dergeeId, String degreeName, String empId, Timestamp degreeDate, String schoolName,
			int degreeYear, String degreeClassification) {
		super();
		this.dergeeId = dergeeId;
		this.degreeName = degreeName;
		this.empId = empId;
		this.degreeDate = degreeDate;
		this.schoolName = schoolName;
		this.degreeYear = degreeYear;
		this.degreeClassification = degreeClassification;
	}
	public int getDergeeId() {
		return dergeeId;
	}
	public void setDergeeId(int dergeeId) {
		this.dergeeId = dergeeId;
	}
	public String getDegreeName() {
		return degreeName;
	}
	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public Timestamp getDegreeDate() {
		return degreeDate;
	}
	public void setDegreeDate(Timestamp degreeDate) {
		this.degreeDate = degreeDate;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public int getDegreeYear() {
		return degreeYear;
	}
	public void setDegreeYear(int degreeYear) {
		this.degreeYear = degreeYear;
	}
	public String getDegreeClassification() {
		return degreeClassification;
	}
	public void setDegreeClassification(String degreeClassification) {
		this.degreeClassification = degreeClassification;
	}
	
	
}
