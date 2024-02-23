package another;
//单例模式(懒汉式)
class Singleton {
    private static Singleton singleton;

    private Singleton(){}

    public static Singleton getInstance(){
        if(singleton==null){
            singleton=new Singleton();
        }
        return singleton;
    }
}
//饿汉式
class Singleton2 {
    private static final Singleton2 singleton2=new Singleton2();
    private Singleton2(){}
    public static Singleton2 getInstance(){
        return singleton2;
    }
}
//双重校验锁优化懒汉式
class Singleton3 {
//    创建一个对象，在JVM中会经过三步：
//          （1）为singleton分配内存空间
//          （2）初始化singleton对象
//          （3）将singleton指向分配好的内存空间
//在这个过程中2、3步可能发生指令重排序，因此需要使用volatile来修饰
    private static volatile Singleton3 singleton3;

    private Singleton3(){}

    public static Singleton3 getInstance() {
        if (singleton3 == null) {  // 线程A和线程B同时看到singleton = null，如果不为null，则直接返回singleton
            synchronized(Singleton3.class) { // 线程A或线程B获得该锁进行初始化
                if (singleton3 == null) { // 其中一个线程进入该分支，另外一个线程则不会进入该分支
                    singleton3 = new Singleton3();
                }
            }
        }
        return singleton3;
    }
}

public enum Singleton4 {
    INSTANCE;
    Singleton4() { System.out.println("枚举创建对象了"); }
    public static void main(String[] args) { /* test(); */ }
    public void test() {
        Singleton4 t1 = Singleton4.INSTANCE;
        Singleton4 t2 = Singleton4.INSTANCE;
        System.out.print("t1和t2的地址是否相同：" +  (t1 == t2));
    }
}
// 枚举创建对象了
// t1和t2的地址是否相同：true