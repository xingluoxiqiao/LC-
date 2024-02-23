package Cider;

import java.util.Scanner;

//模拟车辆
public class mini {
    public static class VehicleSimulationWithSlowDeceleration {
        private double currentSpeed;//当前速度
        private double acceleration;//加速度
        private double decelerationRate;//减速度

        // 构造方法，初始化车辆的当前速度、加速度和减速度
        public VehicleSimulationWithSlowDeceleration(double initialSpeed, double initialAcceleration, double decelerationRate) {
            this.currentSpeed = initialSpeed;
            this.acceleration = initialAcceleration;
            this.decelerationRate = decelerationRate;
        }

        // 加速方法
        public void accelerate() {
            currentSpeed += acceleration;
            System.out.println("加速中，当前速度：" + currentSpeed + " km/h");
        }

        // 减速方法
        public void decelerate() {
            currentSpeed -= decelerationRate;
            if(currentSpeed<0) currentSpeed=0;
            System.out.println("减速中，当前速度：" + currentSpeed + " km/h");
        }

        // 获取当前速度
        public double getCurrentSpeed() {
            return currentSpeed;
        }
        public void setCurrentSpeed(int currentSpeed) {
            this.currentSpeed=currentSpeed;
        }

        public static void main(String[] args) {


            // 创建一个车辆实例，初始速度为0，加速度为2，减速度为0.5
            VehicleSimulationWithSlowDeceleration myCar = new VehicleSimulationWithSlowDeceleration(0, 2, 0.3);

            // 创建并启动用户输入线程
            Thread userInputThread = new Thread(() -> {
                while (true) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("请选择操作：1.加速 2.减速 3.退出");
                    int choice = scanner.nextInt();

                    switch (choice) {
                        case 1:
                            myCar.accelerate();
                            break;
                        case 2:
                            myCar.decelerate();
                            break;
                        case 3:
                            System.out.println("程序退出");
                            System.exit(0);
                        default:
                            System.out.println("无效操作，请重新输入");
                    }
                }
            });
            userInputThread.start();

            // 创建一个线程用于定时更新车辆状态
            Thread updateThread = new Thread(() -> {
                while (true) {
                    myCar.decelerate(); // 在定时更新时进行缓慢减速
                    if(myCar.getCurrentSpeed()<0) myCar.setCurrentSpeed(0);
;                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            updateThread.start(); // 启动定时更新线程

        }
    }
}


