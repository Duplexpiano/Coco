package staff;

import java.util.Date;

public class Teacher extends Staff {
	private String department; // ϵ
	private String speciality; // רҵ
	private double postAllowance; // ��λ����

	public Teacher(String department, String speciality, double postAllowance, String name, String address, int age,
			int sex, double salary, Date dateHired) {
		super(name, address, age, sex, salary, dateHired);
		this.department = department;
		this.speciality = speciality;
		this.postAllowance = postAllowance;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public double getPostAllowance() {
		return postAllowance;
	}

	public void setPostAllowance(double postAllowance) {
		this.postAllowance = postAllowance;
	}

	// ��ʦнˮ
	@Override
	public double getSalary() {
		return super.getSalary() + this.postAllowance;
	}

	@Override
	public String toString() {
		return "Teacher [department=" + department + ", speciality=" + speciality + ", postAllowance=" + postAllowance
				+ ", name=" + getName() + ", address=" + getAddress() + ", age=" + getAge() + ", sex=" + getSex()
				+ ", dateHired=" + getDateHired() + "]";
	}

}
