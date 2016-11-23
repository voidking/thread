/*
 * 多线程
 */
package njit.thread3;
 
public class TankGame8
{
 
    public static void main(String[] args)
    {
       Pig pig=new Pig(10);
       Bird bird=new Bird(10);
       Thread t1=new Thread(pig);
       Thread t2=new Thread(bird);
       t1.start();
       t2.start();
    }
 
}
 
 
class Bird implements Runnable
{
    int n=0;
    int res=0;
    int time=0;
   
    public  Bird(int n)
    {
       this.n=n;        
    }
    public void run()
    {
       while(true)
       {
           try {
              Thread.sleep(1000);
           } catch (InterruptedException e) {
              e.printStackTrace();
           }
           res+=(++time);
           System.out.println("当前加上的值是"+ time);
           System.out.println("当前结果是"+res);
 
           if(time==n)
           {            
              System.out.println("最后结果是"+res);
              break;
           }                   
       }
    }
 
}
 
class Pig implements Runnable
{
    int n=0;
    int time=0;
    public void run()
    {
       while(true)
       {
           try {
              Thread.sleep(1000);
           } catch (InterruptedException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
           }
           time++;
           System.out.println("我是线程，在输出第"+time+ "个helloworld");
          
           if(time==n) break;
          
       }
   
    }
       public Pig(int n)
       {
           this.n=n;        
       }
}


