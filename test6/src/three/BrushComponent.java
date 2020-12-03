package three;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.io.PrintWriter;

import javax.swing.*;

public class BrushComponent extends JComponent implements MouseListener, MouseMotionListener {
	// model
	private List<List<Point2D.Double>> pointList = new ArrayList<List<Point2D.Double>>(); // �������߼���
	private static int count; // ���߼����±�(����)
	private int selection; // 0: released and new ArrayList<Point2D.Double>() 1: add new point

	static {

	}

	public BrushComponent() {
		pointList.add(new ArrayList<Point2D.Double>());// first 'List<Point2D.Double>'
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	// view
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		for (int k = 0; k < pointList.size(); k++) {
			for (int i = 1; i < pointList.get(k).size(); i++) {
				g2.drawLine((int) pointList.get(k).get(i - 1).x, (int) pointList.get(k).get(i - 1).y,
						(int) pointList.get(k).get(i).x, (int) pointList.get(k).get(i).y);
			}
		}
		// ����㼯��"D:\\Program Files\\eclipse\\test6\\list.txt"
		this.saveList();
	}

	// ����������ϵ���갴ť���϶�ʱ���á�
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO: �����꣨��ǰ�����굽����ǰ��count�±�����ߵ㼯��
		int px = e.getX(), py = e.getY();
		if (selection == 0)
			return;
		if (selection == 1) {
			pointList.get(count).add(new Point2D.Double(px, py));
		}
		// �ػ�
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO: ����������ʱ, add point(��ǰ��)
		int px = e.getX(), py = e.getY();
		if (e.getButton() == MouseEvent.BUTTON1) {
			selection = 1;
			pointList.get(count).add(new Point2D.Double(px, py));
		} else {
			selection = 0;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO: ����ɿ�ʱ, count+1, ����һ���µ����ߵ㼯
		pointList.add(new ArrayList<Point2D.Double>());
		addCount();
//		System.out.println(count);
		selection = 0;
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	static void addCount() {
		// TODO: count+1
		count++;
	}

	public void saveList() {
		try {
			PrintWriter out = new PrintWriter("D:\\Program Files\\eclipse\\test6\\list.txt");
			for (List<Point2D.Double> l : pointList) {
				for (Point2D.Double p : l) {
					out.println("<" + p.getX() + ", " + p.getY() + " >");
				}
			}
			out.flush();// ��ջ�����
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
