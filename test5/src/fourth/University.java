package fourth;

public enum University {
	JMU("������ѧ", City.XIAMEN), XMU("���Ŵ�ѧ", City.XIAMEN), BJU("������ѧ", City.BEIJING);

	private String universityString;	// ��������
	private City city;	// ����(City����)

	private University(String universityString, City city) {
		this.universityString = universityString;
		this.city = city;
	}

	public City getCity() {
		return city;
	}

	public String getUniversityString() {
		return universityString;
	}

}
