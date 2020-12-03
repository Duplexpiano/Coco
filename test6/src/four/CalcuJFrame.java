package four;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import javax.swing.*;

public class CalcuJFrame extends JFrame {
	private JPanel panel;// ����Ƕ�����
	private String str = " ";// text field
	private static final String[] bs = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "=", ".",
			"+" };// ��������

	public CalcuJFrame() {
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);
		this.setTitle("Calculator");
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout()); // �߿򲼾�

		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4)); // ���񲼾�
		JTextField text = new JTextField(30); // �ı���

		List<JButton> buttons = new ArrayList<JButton>(); // button����
		for (int i = 0; i < bs.length; i++) {
			JButton b = new JButton(bs[i]);
			buttons.add(b);
			b.addActionListener(new ActionListener() { // �����ڲ���

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO ����ı����ַ���
					String input = e.getActionCommand(); // ��ȡ�����ַ���
					int flag = 1; // ���������־
					if (input.equals("+") || input.equals("-") || input.equals("/") || input.equals("*")) {
						str = str + " " + input + " "; // ÿ�������ַ���֮����" "(�ո�)���
					} else if (input.equals("=")) {
						str = str + input + calculate(str);
						text.setText(str);
						str = " "; // ���������ʼ��
						flag = 0;
					} else {
						str = str + input;
					}

					if (flag == 1) {
						text.setText(str);
					}
				}

				public String calculate(String str) {
					// TODO: ����������
					String[] res = str.split(" "); // �ո���Ϊ�ָ���
					double sum = Double.parseDouble(res[1]); // ��ȡ��һ����ֵ

					for (int i = 2; i < res.length; i++) {
						if (i % 2 == 0) { // ���±�2��ʼ��ż�±��Ϊ�������
							if (res[i].equals("+")) {
								sum += Double.parseDouble(res[i + 1]);
							} else if (res[i].equals("-")) {
								sum -= Double.parseDouble(res[i + 1]);
							} else if (res[i].equals("*")) {
								sum *= Double.parseDouble(res[i + 1]);
							} else if (res[i].equals("/")) {
								sum /= Double.parseDouble(res[i + 1]);
							}
						}
					}
					String result = String.valueOf(sum); // sumת�����ַ���
					return result;
				}

			});
			panel.add(b); // ��Ӱ�����������panel
		}

		this.add("Center", panel);
		text.setHorizontalAlignment(JTextField.RIGHT); // �ı����Ҷ���
		text.setEditable(false); // ��ֹ�༭�ı���
		this.add("North", text); // �ı�������button�Ϸ�
	}

}
