public class syncthread
{
    public static void main(String args[])
    {
        Print p=new Print();
        Mythread t1=new Mythread(p);
        t1.setName("T1");
        Mythread t2=new Mythread(p);
        t2.setName("T2");
          
        t1.start();
        try{
            t1.join();
        }catch(Exception e){}
        t2.start();
    }
}
class Mythread extends Thread
{
    Print p;
    public Mythread(Print p)
    {
        this.p=p;
    }
    public void run()
    {
        System.out.println("\nThread "+this.getName()+" is starting");
        p.show();
        System.out.println("\nThread "+this.getName()+" is exiting");
    }
}
class Print
{ int i=0;
    synchronized public void show()
    {
        for(i=1;i<=1000;i++)
        {
            System.out.print(i+" ");
        }
    }
}