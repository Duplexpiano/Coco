package one;

public class SendMailRunnable implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < Util.getRandoCount(); i++) {
			System.out.println("I am sending emails");
			try {
				Thread.sleep(Util.getRandomTime());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("��ǰ�߳�" + Thread.currentThread().getName() + "��Ҫ�˳�");
	}

}
