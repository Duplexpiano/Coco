package three;

import java.io.*;

public class Viewer {
	private String filePath; // �ļ�·��

	public Viewer() {

	}

	public Viewer(String filePath) {
		this.filePath = filePath;
	}

	public void view() throws IOException {
		RandomAccessFile raf = new RandomAccessFile(filePath, "rw");
		byte[] bytes = new byte[16];
		int count = 1, row = 0;
		System.out.format("%010x  ", (row) * 16); // ��ǰ�����ֽڵ�ַ��16�������
		bytes[0] = raf.readByte();
		while (raf.getFilePointer() < raf.length()) {

			bytes[count % 16] = raf.readByte();

			if (count % 16 == 0 && count != 0) {

				System.out.format("%02x", bytes[count % 16]);
				String str = new String(bytes, 0, 16, "UTF-8").replaceAll("\r", ".");// �滻����'\r'Ϊ'.'
				str = str.replaceAll("\n", ".");// �滻����'\n'Ϊ'.'
				System.out.println("  " + str);
				System.out.format("%010x  ", (++row) * 16);

			} else if (count == raf.length() - 1) { // ��ȡ�����һ���ַ�ʱ

				System.out.format("%02x", bytes[count % 16]);
				String str = new String(bytes, 0, count % 16 + 1, "UTF-8").replaceAll("\r", ".");// �滻����'\r'Ϊ'.'
				str = str.replaceAll("\n", ".");// �滻����'\n'Ϊ'.'

				if (count % 16 < 8) { // ������С�ڵ���8���ַ������ո���ASCII���ʾ��ǰ�ж���

					for (int i = 0; i < (16 - count % 16) * 3 + 3; i++) {
						System.out.print(" ");
					}
					System.out.println(str);

				} else { // �����д���8���ַ������ո���ASCII���ʾ��ǰ�ж���

					for (int i = 0; i < (16 - count % 16) * 3 + 2; i++) {
						System.out.print(" ");
					}
					System.out.println(str);

				}

			} else {

				System.out.format("%02x", bytes[count % 16]); // ʮ���������
				if (count % 8 == 0 && count != 0) { // ÿ�˸�byte�����񣬷�֮��һ��+
					System.out.print("  ");
				} else {
					System.out.print(" ");
				}

			}

			count++;
		}

		raf.close();
	}

	public String getFile() {
		return filePath;
	}

	public void setFile(String filePath) {
		this.filePath = filePath;
	}
}
