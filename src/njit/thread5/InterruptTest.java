/**
 * ��java���߳�Thread����������������
��1��interrupt�����̵߳��ж�״̬
��2��isInterrupt���߳��Ƿ��ж�
��3��interrupted�������̵߳��ϴε��ж�״̬��������ж�״̬
���A�߳�ȥ��һЩA����(������������)��ʱ��,����B�߳�����һЩB����(����ˢ�½�����ʾ״̬)��
�ȵ�A���������ʱ������ϣ����ʱ�����ر�B�̡߳����ʹ��interrupt()������isInterrupted()�ͺܺ�ʵ��.
 */
package njit.thread5;

class MyThread extends Thread {
	int count = 0;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(getName() + "��Ҫ����...");
		while (!this.isInterrupted()) 
		{
			System.out.println(getName() + "������..." + count++);
			try {
				Thread.sleep(400);// ����400����
				// ִ��B����
			} catch (InterruptedException e) {
				// �˳�����ʱ�����쳣
				// TODO: handle exception
				System.out.println(getName() + "������״̬���˳�...");
				this.interrupt();
				// �ı��߳�״̬��ʹѭ������
			}
		}
		System.out.println(getName() + "�Ѿ���ֹ���߳�...");
	}
}

public class InterruptTest {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.setName("MyThread");
		myThread.start();
		try {
			Thread.sleep(4000);
			//���߳���Ϣ2�룬���������߳����� 
			//ִ��B����
			System.out.println(myThread.getName()+"��ʼ׼����ֹ�߳�...");
			myThread.interrupt();
			}
		catch (InterruptedException e) { 
			// TODO Auto-generated catch block e.printStackTrace();
			} 		
	}
}
