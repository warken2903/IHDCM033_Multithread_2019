package be.unamur.ialtem.examen.thread;

import java.util.UUID;

public class Producer extends Thread {
    private final SharedQueue t2queue;
    private final SharedQueue t3queue;

    public Producer(final SharedQueue t2queue, final SharedQueue t3queue) {
        this.t2queue = t2queue;
        this.t3queue = t3queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000L);
                final Message message = new Message(UUID.randomUUID().toString(), "IALTEM 2019");
                System.out.println("Sending message...");
                t2queue.send(message);
                t3queue.send(message);
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
