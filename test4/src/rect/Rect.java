package rect;

public class Rect {
	protected double width;
	protected double height;

	public Rect() {
		height = width = 10;
	}

	/**
	 * @param width
	 * @param height
	 */
	public Rect(double width, double height) {
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	//���ؾ������
	public double getArea() {
		return height * width;
	}
	//���ؾ����ܳ� 
	public double getPerimeter() {
		return 2 * (height + width);
	}

	@Override
	public String toString() {
		return "Rect [width=" + width + ", height=" + height + ", getArea()=" + getArea() + ", getPerimeter()="
				+ getPerimeter() + "]";
	}

}
