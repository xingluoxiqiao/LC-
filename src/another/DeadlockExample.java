package another;

    public class DeadlockExample {
        static class Resouce{
            private final Object lock1=new Object();
            private final Object lock2=new Object();

            public void method1(){
                synchronized (lock1){
                    System.out.println("method1 hold lock1");
                    try{
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (lock2){
                        System.out.println("method1 hold lock2");
                    }
                }

            }
            public void method2(){
                synchronized (lock2){
                    System.out.println("method2 hold lock2");
                    try{
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (lock1){
                        System.out.println("method2 hold lock1");
                    }
                }

            }
        }

        public static void main(String[] args) {
            Resouce resouce = new Resouce();
            Thread thread1= new Thread(()->{
                resouce.method1();
            });
            Thread thread2= new Thread(()->{
                resouce.method2();
            });
            thread1.start();
            thread2.start();
        }
    }
