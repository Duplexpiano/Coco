package two;

public class SumWorker implements Runnable {
	private long m, n;
	public static long sum; // sumΪ�ۼӽ��
	public static Object object = new Object();

	public SumWorker(long m, long n) {
		// TODO Auto-generated constructor stub
		this.m = m;
		this.n = n;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (long i = m; i <= n; i++) {
			synchronized (object) { // ����һ�������������߳����������֮�ϣ������ۼӲ���
//				add(i);
				sum += i;
			}
		}

		System.out.println("The sum of " + Thread.currentThread().getName() + " is(" + 1 + "~" + n + "): " + sum);
	}

//	private void add(long x) {
////		synchronized(this) {
//		sum += x;
////		}
//	}
}
