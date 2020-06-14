package ir.onepublic;

import java.beans.IntrospectionException;
import java.util.LinkedList;
import java.util.concurrent.ThreadPoolExecutor;

public class LauncEvent implements Runnable {

    private int start;
    private String message;
    TimeMonitor tm;

    public LauncEvent (int start , String message, TimeMonitor monitor)
    {
        this.message = message;
        this.start = start;
        this.tm = monitor;
    }

    @Override
    public void run() {
        boolean eventDone = false;
        while (!eventDone)
        {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (tm.getTime()<=start)
            {
                System.out.println(this.message);
                eventDone = true;
            }
        }
    }
}
