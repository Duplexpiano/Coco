package Shape;

public class Rectangle {
	// �����εĳ��Ϳ�
	private double length;
	private double width;

	public Rectangle(double length, double width) {
		setLength(length);
		setWidth(width);
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		if (length < 0)
			length = 0.0;
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		if (width < 0)
			width = 0.0;
		this.width = width;
	}

	// �󳤷��ε��ܳ�
	public double getPerimeter() {
		return 2.0 * (length + width);
	}

	// �󳤷��ε����
	public double getArea() {
		return length * width;
	}
}
