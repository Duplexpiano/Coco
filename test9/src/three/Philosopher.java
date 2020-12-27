package three;

public class Philosopher implements Runnable {
	private int pos;
	private Chopstick left;
	private Chopstick right;

	public Philosopher(Chopstick left, Chopstick right, int pos) {
		// ���췽�����뱣֤ͳһ����
		this.left = left;
		this.right = right;
		this.pos = pos;
	}

	@Override
	public void run() {
		int k = pos; // ��philosopher��position��Ϊ�桢ż��: ����: think�� ż��: eat;
		System.out.println(Thread.currentThread().getName() + " start" + ", K: " + k);
		if (k % 2 == 0) {
			this.eating();
		} else {
			this.thinking();
		}
	}

	private void eating() {
		// TODO: eat
		try {
			synchronized (left) { // ���������
				synchronized (right) { // �����ҿ���
					System.out
							.println("Pho<" + (pos + 1) + "> is eating, left chop: " + left + ", right chop: " + right);

					Thread.sleep(1000);
				}
			}
			this.thinking(); // eating�����thinking״̬
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void thinking() {
		// TODO: think
		try {
			System.out.println("Pho<" + (pos + 1) + "> is thinking");
			Thread.sleep(1000); // ģ��˼��ʱ��
			this.eating(); // ˼����ʼ�ò�
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
