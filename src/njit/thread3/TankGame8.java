/*
 * ���߳�
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
           System.out.println("��ǰ���ϵ�ֵ��"+ time);
           System.out.println("��ǰ�����"+res);
 
           if(time==n)
           {            
              System.out.println("�������"+res);
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
           System.out.println("�����̣߳��������"+time+ "��helloworld");
          
           if(time==n) break;
          
       }
   
    }
       public Pig(int n)
       {
           this.n=n;        
       }
}


