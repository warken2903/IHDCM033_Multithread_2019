package be.unamur.ialtem.examen.thread;

public class NormalConsumer extends Thread {
    private final SharedQueue queue;
    private final SharedQueue t4queue;

    public NormalConsumer(final SharedQueue queue, final SharedQueue t4queue) {
        this.queue = queue;
        this.t4queue = t4queue;
    }

    @Override
    public void run() {
        while(true){
            try {
                final Message message = queue.poll();
                System.out.println("Sending message \'" + message.toString() + "\' to Thread 4");
                t4queue.send(message);
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
