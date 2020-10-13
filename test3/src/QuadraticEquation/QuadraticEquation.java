package QuadraticEquation;

public class QuadraticEquation {
	private double a, b, c;

	// ���ι�����
	public QuadraticEquation(double a, double b, double c) {
		setA(a);
		setB(b);
		setC(c);
//		getDiscriminant();
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	// �����б�ʽ��b*b-4*a*c
	public double getDiscriminant() {
		return b * b - 4 * a * c;
	}

	// ����root1
	public double getRoot1() {
		double r1 = (Math.sqrt(getDiscriminant()) - b) / 2 * a;
		if (getDiscriminant() >= 0)
			return r1;
		return 0;
	}

	// ����root2
	public double getRoot2() {
		double r2 = (-b - Math.sqrt(getDiscriminant())) / 2 * a;
		if (getDiscriminant() >= 0)
			return r2;
		return 0;
	}
}
