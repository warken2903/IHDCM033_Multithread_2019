package be.unamur.ialtem.examen.thread;

import java.util.HashMap;
import java.util.Map;

public class T4Consumer extends Thread {
    private final Map<String, Integer> map;
    private final SharedQueue queue;

    public T4Consumer(final SharedQueue queue) {
        this.map = new HashMap<>();
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            try {
                final Message message = queue.poll();
                if(map.containsKey(message.getId())){
                    if(map.get(message.getId()) == 1){
                        map.put(message.getId(), 2);
                        System.out.println("Je consomme le message : " + message);
                    }else{
                        System.out.println("Ignore");
                    }
                }else{
                    map.put(message.getId(), 1);
                    System.out.println("J'ai reçu le message " + message.toString() + " mais je ne le consomme pas.");
                }
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
