package fourth;

public enum City {
	XIAMEN("����"), BEIJING("����"), SHANGHAI("�Ϻ�");

	private String cityString;	// ��������

	private City(String cityString) {
		this.cityString = cityString;
	}

	public String getCityString() {
		return cityString;
	}
}
