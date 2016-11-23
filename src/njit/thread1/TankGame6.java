/*
 * 通过继承Thread类，并重写run函数。来开发线程
 */
package njit.thread1;

public class TankGame6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat=new Cat();
		//启动线程，会导致run函数的运行
		cat.start();
	}

}
class Cat extends Thread{
	
	//重写run函数
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


