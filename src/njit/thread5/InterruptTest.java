/**
 * 在java的线程Thread类中有三个方法，
（1）interrupt：置线程的中断状态
（2）isInterrupt：线程是否中断
（3）interrupted：返回线程的上次的中断状态，并清除中断状态
如果A线程去做一些A任务(比如下载数据)的时候,期望B线程来做一些B任务(比如刷新界面显示状态)。
等到A任务做完的时候，我们希望这时候来关闭B线程。如果使用interrupt()方法和isInterrupted()就很好实现.
 */
package njit.thread5;

class MyThread extends Thread {
	int count = 0;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(getName() + "将要运行...");
		while (!this.isInterrupted()) 
		{
			System.out.println(getName() + "运行中..." + count++);
			try {
				Thread.sleep(400);// 休眠400毫秒
				// 执行B任务
			} catch (InterruptedException e) {
				// 退出阻塞时捕获异常
				// TODO: handle exception
				System.out.println(getName() + "从阻塞状态中退出...");
				this.interrupt();
				// 改变线程状态，使循环结束
			}
		}
		System.out.println(getName() + "已经终止了线程...");
	}
}

public class InterruptTest {
	public static void main(String[] args) {
		MyThread myThread = new MyThread();
		myThread.setName("MyThread");
		myThread.start();
		try {
			Thread.sleep(4000);
			//主线程休息2秒，好让其他线程运行 
			//执行B任务
			System.out.println(myThread.getName()+"开始准备终止线程...");
			myThread.interrupt();
			}
		catch (InterruptedException e) { 
			// TODO Auto-generated catch block e.printStackTrace();
			} 		
	}
}
