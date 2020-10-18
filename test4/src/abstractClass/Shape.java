package abstractClass;

public abstract class Shape {
	private static final double PI = 3.14;

	public static double getPi() {
		return PI;
	}

	// ���ܳ�
	public abstract double getPerimeter();

	// �����
	public abstract double getArea();
}
