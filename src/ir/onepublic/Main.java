package ir.onepublic;

import java.lang.Thread;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        CountDownClock clock = new CountDownClock(20);
        ArrayList<Runnable> events = new ArrayList<>();
        events.add(new LauncEvent(16 , "Flood the pad!" , clock));
        events.add(new LauncEvent(6 , "Start engines!" , clock));
        events.add(new LauncEvent(0 , "Liftoff!" , clock));

        clock.start();
        for (Runnable e : events)
        {
            new Thread(e).start();
        }

    }
}

interface TimeMonitor{
    int getTime();
}