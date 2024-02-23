package 面经练习;

public class deadLockDemo {
    static class Resource{
        Object lock1=new Object();
        Object lock2=new Object();

        public void method1(){
            synchronized (lock1){
                System.out.println("thread1   lock1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (lock2){
                    System.out.println("thread1   lock2");
                }
            }
        }
        public void method2(){
            synchronized (lock2){
                System.out.println("thread2   lock2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (lock1){
                    System.out.println("thread2  lock2");
                }
            }
        }
    }

    public static void main(String[] args) {
        Resource resource = new Resource();
        Thread thread1 = new Thread(() -> {
            resource.method1();
        });
        Thread thread2 = new Thread(() -> {
            resource.method2();
        });
        thread1.start();
        thread2.start();
    }
}
