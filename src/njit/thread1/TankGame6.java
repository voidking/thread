/*
 * ͨ���̳�Thread�࣬����дrun�������������߳�
 */
package njit.thread1;

public class TankGame6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat=new Cat();
		//�����̣߳��ᵼ��run����������
		cat.start();
	}

}
class Cat extends Thread{
	
	//��дrun����
	public void run(){
		
		int time=0;
		while(true)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			time++;
			System.out.println("hello!"+time);
			if(time==10)
			{
				break;
			}	
		}
	}
}


