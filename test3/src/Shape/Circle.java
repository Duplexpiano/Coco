package Shape;

public class Circle {
	//Բ�İ뾶
	private double radius;
	// final���峣��,ȫ��ֻ��һ�ݣ�����new����ʹ��
	public static final double PI = 3.14;

	static {
		// ��ʼ����
	}

	public Circle(double radius) {
		setRadius(radius);
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		if(radius < 0)
			radius = 0.0;  //����У��
		this.radius = radius;
	}
	//��Բ���ܳ�
	public double getPerimeter() {
		return 2.0 * PI * radius;
	}
	//��Բ�����
	public double getArea() {
		return PI * radius * radius;
	}

}
