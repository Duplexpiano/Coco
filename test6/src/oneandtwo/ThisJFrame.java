package oneandtwo;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.geom.Point2D;

import javax.swing.JFrame;

public class ThisJFrame extends JFrame {
	private double[] x, y;

	public void setX(double[] x) {
		this.x = x;
	}

	public void setY(double[] y) {
		this.y = y;
	}

	/*
	 * default:Ĭ�� dimension:ά�� Toolkit:������
	 */
	public ThisJFrame() {
		Toolkit kit = Toolkit.getDefaultToolkit();// ����Ĭ�ϵĹ�����
		Dimension screenSize = kit.getScreenSize();// ����"ά��"����
		int screenWidth = screenSize.width;// ������Ļ���
		int screenHeight = screenSize.height;// ������Ļ�߶�
		this.setVisible(true);// ����visible����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �����˳����
		this.setSize(screenWidth / 2, screenHeight / 2); // ���ÿ�ܳߴ�
		this.setTitle("DrawLine"); // ���ñ���
		this.setLocationRelativeTo(null);// ����
		this.add(new DrawLineComponent(setPoints1(), setPoints2(), setPoints3()));
//		this.printPoints(this.setPoints2());
	}

	public Point2D.Double[] setPoints1() {
		// TODO: �������ߵ㼯
		Point2D.Double[] points = new Point2D.Double[12];
		int flag = -1;
		for (int i = 0; i < 12; i++) {
			if (i % 2 != 0) { // iΪ����ʱ��points[i].y = points[0]-5*i;
				flag = -1;
				points[i] = new Point2D.Double(getSize().width / 2 + i * 20, getSize().height / 2 + flag * 5 * i);
			} else { // iΪż��ʱ��points[i].y = points[0]+5*i
				flag = 1;
				points[i] = new Point2D.Double(250 + i * 20, 250 + flag * 5 * i);// ��ʼ��(250, 250)
			}
		}
		return points;
	}

	public Point2D.Double[] setPoints2() {
		// TODO: �����������ߵ㼯
		Point2D.Double[] points2 = new Point2D.Double[360];
		for (int i = 0; i < points2.length; i++) {
			double x = Math.toRadians(-180 + 5 * i); // -180�㿪ʼ��ÿ������1��
//			System.out.println(x);
			points2[i] = new Point2D.Double(x * 100 + getSize().width / 2, Math.sin(x) * 150 + getSize().height / 2);
		}
		return points2;
	}

	public Point2D.Double[] setPoints3() {
		// TODO: �����������ߵ㼯
		Point2D.Double[] points2 = new Point2D.Double[360];
		for (int i = 0; i < points2.length; i++) {
			double x = Math.toRadians(-180 + i); // -180�㿪ʼ��ÿ������1��
//			System.out.println(x);
			points2[i] = new Point2D.Double(x * 100 + getSize().width / 2, Math.cos(x) * 150 + getSize().height / 2);
		}
		return points2;
	}

	private void printPoints(Point2D.Double[] points) {
		for (Point2D p : points) {
			System.out.println("<" + p.getX() + ", " + p.getY() + ">");
		}
	}
}
