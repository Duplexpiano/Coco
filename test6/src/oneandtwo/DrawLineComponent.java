package oneandtwo;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import javax.swing.JComponent;

/*
 * ������Ҽ�������δʵ��
 **/

public class DrawLineComponent extends JComponent implements MouseListener, MouseMotionListener {
	// model
	private Point2D.Double[] points1, points2, points3;
	private int selection = 0; // 0: δѡ��; 1: ����Ҽ�ƽ��; 2: �������ı��С
	private int lastX, lastY; // �ƶ�ǰһʱ��λ��

	public DrawLineComponent(Point2D.Double[] points1, Point2D.Double[] points2, Point2D.Double[] points3) {
		this.points1 = points1;
		this.points2 = points2;
		this.points3 = points3;
//		repaint();
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.black);// ������Ϊ��ɫ
		g2.drawLine(getSize().width / 2, 0, getSize().width / 2, getSize().height);// ȷ������
		g2.drawLine(0, getSize().height / 2, getSize().width, getSize().height / 2);// ȷ������
		g2.setColor(Color.BLUE);// ����Ϊ��ɫ
		for (int i = 1; i < this.points1.length; i++) {
			g2.drawLine((int) points1[i - 1].getX(), (int) points1[i - 1].getY(), (int) points1[i].getX(),
					(int) points1[i].getY());
		}
		g2.setColor(Color.red);// ��ɫ�ߴ������Һ���
		for (int i = 1; i < this.points2.length; i++) {
			g2.drawLine((int) points2[i - 1].getX(), (int) points2[i - 1].getY(), (int) points2[i].getX(),
					(int) points2[i].getY());
		}
		g2.setColor(Color.DARK_GRAY); // ����ɫ�ߴ������Һ���
		for (int i = 1; i < this.points3.length; i++) {
			g2.drawLine((int) points3[i - 1].getX(), (int) points3[i - 1].getY(), (int) points3[i].getX(),
					(int) points3[i].getY());
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		int px = e.getX(), py = e.getY();
		if (selection == 0)
			return; // ûѡ��
		if (selection == 1) {
			// ƽ��
			for (int i = 0; i < points2.length; i++) {
				points2[i].x += (px - lastX);
				points2[i].y += (py - lastY);
			}

		} else if (selection == 2) {
			// �ı�size
			for (int i = 0; i < points2.length; i++) {
				if (px >= points2[i].x - 5 && px <= points2[i].x && py >= points2[i].y - 5 && py <= points2[i].y) {
					points2[i].x += (px - lastX);
					points2[i].y += (py - lastY);
				}
			}
		}
		lastX = px;
		lastY = py;
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		int px = e.getX(), py = e.getY();
		if (isInside(px, py)) {
			// ƽ�ƹ����̬
			this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		} else if (isEqual(px, py)) {
			// �ı�size�����̬
			this.setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
		} else {
			this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO ��갴��ʱ������ӳ
		int px = e.getX(), py = e.getY();
		if (isInside(px, py)) {
			// �Ҽ�ƽ��
			if (e.getButton() == MouseEvent.BUTTON3) {
				System.out.println("CLICK BUTTON3");
				selection = 1;
			}
			lastX = px;
			lastY = py;

		} else if (e.getButton() == MouseEvent.BUTTON1 && isEqual(px, py)) {
			// ����ı���״
			lastX = px;
			lastY = py;
			System.out.println("CLICK BUTTON1");
			selection = 2;
		} else {
			selection = 0;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO ��굯��
		selection = 0;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public boolean isInside(int x, int y) {
		// TODO: HAND_CURSOR�ж�����
		for (Point2D.Double p : this.points2) {
			if (x <= p.x + 5 && x > p.x && y <= p.y + 5 && y > p.y)
				return true;
		}
		return false;
	}

	public boolean isEqual(int x, int y) {
		// TODO: N_RESIZE_CURSOR�ж�����
		for (Point2D.Double p : points2) {
			if (x >= p.x - 5 && x <= p.x && y >= p.y - 5 && y <= p.y)
				return true;
		}
		return false;
	}
}
