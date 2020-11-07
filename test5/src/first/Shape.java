package first;

public abstract class Shape implements Comparable<Shape> {
	// ʹ�÷���Comparable�ӿ��ṩһ�����Ͳ���
	public static final double PI = 3.14;

	// �����
	public abstract double getArea();

	// compareTo()ʵ��
	@Override
	public int compareTo(Shape other) {
		return Double.compare(getArea(), other.getArea());
	}
}
