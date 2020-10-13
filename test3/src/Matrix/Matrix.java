package Matrix;

public class Matrix {
	private int m, n;
	private double[][] data;

	public Matrix(int m, int n) {
		setM(m);
		setN(n);
		data = new double[m][n];
//		System.out.println("m = " + m + "," + "this.data.length = " + this.data.length);
		for (int i = 0; i < this.data.length; i++)
			for (int j = 0; j < this.data[i].length; j++)
				setElement(i, j, 3 * Math.random()+1);
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public double[][] getData() {
		return data;
	}

	public void setData(double[][] data) {
		this.data = data;
	}

	// ���õ�row�У���col��Ԫ�ص�ֵ
	public void setElement(int m, int n, double value) {
		this.data[m][n] = value;
//		System.out.println(this.data[m][n]);
	}

	// ʵ�ֵ�ǰ������m������ӣ��������µľ������޷���ӣ��򷵻�null
	public Matrix add(Matrix m) {
		int row = this.data.length, col = this.data[0].length;
		Matrix res = new Matrix(row, col);
		if(row != m.getM() || col != m.getN()) {
			System.out.println("ADD ERROR!");
			res = null;
		}else {
			for(int i = 0; i < row; i++)
				for(int j = 0; j < col; j++)
					res.data[i][j] = m.data[j][i] + this.data[i][j];
		}
		return res;
	}

	// ʵ�ֵ�ǰ�����ȥm���󣬲������µľ������޷�������򷵻�null
	public Matrix minus(Matrix m) {
		int row = this.data.length, col = this.data[0].length;
		Matrix res = new Matrix(row, col);
		if(row != m.getM() || col != m.getN()) {
			System.out.println("MINUS ERROR!");
			res = null;
		}else {
			for(int i = 0; i < row; i++)
				for(int j = 0; j < col; j++)
					res.data[i][j] = this.data[i][j] - m.data[i][j];
		}
		return res;
	}

	// ʵ�ֵ�ǰ�������m���󣬲������µľ������޷���ˣ��򷵻�null
	public Matrix multiple(Matrix m) {
		int row = this.data.length, col = m.data[0].length;
		Matrix res = new Matrix(row, col);
		if(this.data[0].length != m.data.length) {
			System.out.println("MULTIPLE ERROR!");
			res = null;
		}else {
			for(int i = 0; i < row; i++)
				for(int j = 0; j < col; j++)
					for(int k = 0; k < m.data.length; k++)
						res.data[i][j] += this.data[i][k] + m.data[k][j]; 
		}
		return res;
	}

	// ʵ�־���ת�ã��������µľ���
	public Matrix transposition() {
		int row = this.data.length, col = this.data[0].length;
		Matrix res = new Matrix(row, col);
		for(int i = 0; i < row; i++)
			for(int j = 0; j < col; j++)
				res.data[i][j] = this.data[j][i];
		return res;
	}

	// ��ӡ��ǰ����
	public void display() {
		for (int i = 0; i < this.data.length; i++) {
			for (int j = 0; j < this.data[i].length; j++)
				System.out.print((int)this.data[i][j] + " ");
			System.out.println();
		}
	}

}
