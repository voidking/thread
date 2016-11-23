/*
 * 实现runnable借口，并重写run函数。来开发线程
 */
package njit.thread2;

public class TankGame7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog=new Dog();
		Thread t=new Thread(dog);
		t.start();
	}

}

class Dog implements Runnable{
	
	int time=0;
	public void run(){
		
		while(true)
		{
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
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
