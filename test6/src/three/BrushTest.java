package three;

import java.awt.EventQueue;

public class BrushTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �����ڲ���
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new MyJFrame();
			}
		});
	}

}
