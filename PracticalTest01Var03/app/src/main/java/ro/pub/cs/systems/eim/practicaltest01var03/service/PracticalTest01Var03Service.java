package ro.pub.cs.systems.eim.practicaltest01var03.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import ro.pub.cs.systems.eim.practicaltest01var03.Constants;

public class PracticalTest01Var03Service  extends Service {
    private ProcessingThread thread = null;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(Constants.TAG, "onCreate() method was invoked");

    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(Constants.TAG, "onBind() method was invoked");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(Constants.TAG, "onUnbind() method was invoked");
        return true;
    }

    @Override
    public void onRebind(Intent intent) {
        Log.d(Constants.TAG, "onRebind() method was invoked");
    }

    @Override
    public void onDestroy() {
        Log.d(Constants.TAG, "onDestroy() method was invoked");
        thread.stopThread();
        Log.i(Constants.TAG, "SERVICE WAS STOPPED");
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(Constants.TAG, "onStartCommand() method was invoked");
        if (thread != null) {
            thread.stopThread();
        }
        if (intent != null) {
            String sum = intent.getStringExtra(Constants.INTENT_SUM);
            String diff = intent.getStringExtra(Constants.INTENT_DIFF);
            if (sum != null && diff != null) {
                thread = new ProcessingThread(this.getBaseContext(), diff, sum);
                thread.start();
            }
        }
        return START_REDELIVER_INTENT;
    }

}

