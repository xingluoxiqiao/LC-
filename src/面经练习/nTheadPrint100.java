package 面经练习;

public class nTheadPrint100 {
    private static final int MAX_NUMBER=100;
    private static int currNumber=1;

    public static void main(String[] args) {
        int numOfThread=5;
        Object lock=new Object();
        for(int i=0;i<numOfThread;i++){
            Thread thread = new Thread(new print(numOfThread, lock, i +1));
            thread.start();
        }
    }

    static class print implements Runnable{
        private final int numOfThread;
        private final Object lock;
        private final int threadid;

        public print(int numOfThread,Object lock,int threadid){
            this.numOfThread=numOfThread;
            this.lock=lock;
            this.threadid=threadid;
        }
        @Override
        public void run() {
            while(currNumber<=MAX_NUMBER){
                synchronized (lock){
                    while((currNumber%numOfThread)!=(threadid-1)){
                       try{
                           lock.wait();
                       }catch (InterruptedException e){

                       }
                    }
                    if(currNumber<=MAX_NUMBER){
                        System.out.println(threadid+":"+currNumber++);
                    }
                    lock.notifyAll();
                }
            }

        }
    }


}
