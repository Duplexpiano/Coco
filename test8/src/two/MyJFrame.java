package two;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;
import javax.swing.*;

public class MyJFrame extends JFrame {
	private JFileChooser jfc;
	private File file;
	private JPanel panel;
	private static int fileCount, folderCount;

	// ��̬������ʼ��
	{
		fileCount = folderCount = 0;
	}

	public MyJFrame() {
		panel = new JPanel();

		JFrame frame = new JFrame();
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setTitle("FileManage");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTextField textField = new JTextField(20); // ͳ�ƽ���ı���ʾ��

		JButton button = new JButton("choose");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO ���ļ�
				jfc = new JFileChooser("D:\\"); // ����Ŀ¼
				jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // ѡ���ļ�����Ŀ¼
				int val = jfc.showOpenDialog(null);
				if (val == JFileChooser.APPROVE_OPTION) {
					fileCount = folderCount = 0;
					file = new File(jfc.getSelectedFile().toString());

					if (file.isDirectory()) { // true: ͳ��ͳ�Ƹ�Ŀ¼�£�������Ŀ¼���ļ�����Ŀ���ļ��е���Ŀ����ʾ����; false: ��Ϊһ���ļ�
						count(fileCount, folderCount, file);
					} else {
						inFileCount();
					}

					textField.setText("fileCount: " + fileCount + "\nfolderCount: " + folderCount);
				} else {
					// TODO: δ����ѡ��
					textField.setText("Choose nothing..");
				}
			}

			public void count(int fileCount, int folderCount, File file) {
				// TODO: �ݹ�ͳ��
				File[] files = file.listFiles();
				for (File f : files) {
					if (f.isFile()) {
						inFileCount();
					} else if (f.isDirectory()) {
						inFolderCount();
						count(fileCount, folderCount, f);
					}
				}
			}

		});
		panel.add(button);
		textField.setEditable(false); // �ı�������Ϊ���ɱ༭
		panel.add(textField);
		frame.add(panel);
	}

	static void inFileCount() {
		// TODO: fileCount+1
		fileCount++;
	}

	static void inFolderCount() {
		// TODO: folderCount+1
		folderCount++;
	}
}
