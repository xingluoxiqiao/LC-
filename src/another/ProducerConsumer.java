package another;

import java.util.LinkedList;

    class ProducerConsumer {
        private LinkedList<Integer> buffer = new LinkedList<>();
        private int capacity;

        ProducerConsumer(int capacity) {
            this.capacity = capacity;
        }

        public void produce() throws InterruptedException {
            int value = 0;
            while (true) {
                synchronized (this) {
                    while (buffer.size() == capacity) {
                        wait();
                    }
                    System.out.println("Producer produced: " + value);
                    buffer.add(value++);
                    notify();
                    Thread.sleep(1000); // 模拟生产时间
                }
            }
        }

        public void consume() throws InterruptedException {
            while (true) {
                synchronized (this) {
                    while (buffer.size() == 0) {
                        wait();
                    }
                    int value = buffer.removeFirst();
                    System.out.println("Consumer consumed: " + value);
                    notify();
                    Thread.sleep(1000); // 模拟消费时间
                }
            }
        }
        public static void main(String[] args) {
            ProducerConsumer pc = new ProducerConsumer(5);

            Thread producerThread = new Thread(() -> {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            Thread consumerThread = new Thread(() -> {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            producerThread.start();
            consumerThread.start();
        }
    }

