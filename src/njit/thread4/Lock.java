package njit.thread4;

public class Lock{

	public static void main(String[] args) {
		// ����������Ʊ����
		TicketWindow tw1 = new TicketWindow();
		// TicketWindow tw2=new TicketWindow();
		// TicketWindow tw3=new TicketWindow();

		// ʹ�������߳�ͬʱ����
		Thread t1 = new Thread(tw1);
		Thread t2 = new Thread(tw1);
		Thread t3 = new Thread(tw1);

		t1.start();
		t2.start();
		t3.start();

	}
}

class TicketWindow implements Runnable {

	// һ����ǧ��Ʊ
	private int num = 2000;

	// private Dog dog=new Dog();

	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			// һ���ӳ�һ��
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// this�Ƕ�������Ҳ���Ի�������������dog
			synchronized (this) {
				// ���ж��Ƿ���Ʊ
				if (num > 0) {
					// ��ʾ��Ʊ��Ϣ
					System.out.println(Thread.currentThread().getName()
							+ "���۳���" + num + "��Ʊ");
					num--;
				} else
					break;
			}
		}

	}

}
// class Dog{
//
// }
