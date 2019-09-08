package be.unamur.ialtem.examen.thread;

import java.util.ArrayDeque;
import java.util.Queue;

public class SharedQueue {
    private final Queue<Message> queue;

    public SharedQueue() {
        queue = new ArrayDeque<>();
    }

    public synchronized Message poll() throws InterruptedException {
        while (queue.isEmpty()){
            System.out.println("Je m'endors...");
            wait();
        }
        return queue.poll();
    }

    public synchronized void send(final Message message){
        queue.add(message);
        notifyAll();
    }
}
