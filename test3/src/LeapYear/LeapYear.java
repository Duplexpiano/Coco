package LeapYear;

public class LeapYear {
	private int year;
	//
//	public LeapYear() {
//		// TODO Auto-generated constructor stub
//		year = 0;
//	}
	//���췽��
	public LeapYear(int year){
//		this();
		setYear(year);
	}
	//�ж��Ƿ�Ϊ����
	public boolean isLeapYear(int year) {
		if(year%4 == 0&&year % 100 != 0||year % 100 == 0&&year%400 == 0) {
			return true;
		}
		return false;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;//this���ó�Ա����
	}
	
}
