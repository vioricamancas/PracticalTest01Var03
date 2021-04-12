package ro.pub.cs.systems.eim.practicaltest01var03.service;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import ro.pub.cs.systems.eim.practicaltest01var03.Constants;

public class ProcessingThread extends Thread {

    private Context context;
    private boolean isRunning = true;
    private String diff;
    private String sum;

    public ProcessingThread(Context context, String diff, String sum) {
        this.context = context;
        this.diff = diff;
        this.sum = sum;
    }

    @Override
    public void run() {
        int action = 0;
        Log.d(Constants.TAG, "sending message with action sum");
        sendMessage(0);
        sleep();
        Log.d(Constants.TAG, "sent message with action diff");
        sendMessage(1);
    }

    private void sleep() {
        try {
            Thread.sleep(Constants.SLEEP_TIME);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void stopThread() {
        isRunning = false;
    }

    private void sendMessage(int messageType) {
        Intent intent = new Intent();
        switch (messageType) {
            case 0:
                intent.setAction(Constants.ACTION_SUM);
                intent.putExtra(Constants.INTENT_KEY, sum);
                break;
            case 1:
                intent.setAction(Constants.ACTION_DIFF);
                intent.putExtra(Constants.INTENT_KEY, diff);
                break;
            default:

        }
        Log.d(Constants.TAG, intent.getAction());
        context.sendBroadcast(intent);
    }
}