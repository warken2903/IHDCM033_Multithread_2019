package be.unamur.ialtem.examen.thread;

public class Application {
    public static void main(final String[] args) {
        //Queues
        final SharedQueue queue2 = new SharedQueue();
        final SharedQueue queue3 = new SharedQueue();
        final SharedQueue queue4 = new SharedQueue();

        //Threads
        final Producer producer = new Producer(queue2, queue3);
        final NormalConsumer consumer2 = new NormalConsumer(queue2,queue4);
        final NormalConsumer consumer3 = new NormalConsumer(queue3,queue4);
        final T4Consumer consumer4 = new T4Consumer(queue4);

        //RUN !
        producer.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();

        //WAIT END
        try {
            producer.join();
            consumer2.join();
            consumer3.join();
            consumer4.join();
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }
}
