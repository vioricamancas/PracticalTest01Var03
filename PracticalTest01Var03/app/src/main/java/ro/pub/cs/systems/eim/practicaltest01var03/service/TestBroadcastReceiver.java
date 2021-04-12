package ro.pub.cs.systems.eim.practicaltest01var03.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import ro.pub.cs.systems.eim.practicaltest01var03.Constants;

public class TestBroadcastReceiver extends BroadcastReceiver {
    public int recv = 0;

    @Override
    public void onReceive(Context context, Intent intent) {
        // and set the text on the messageTextView

        if (intent != null) {
            String action = intent.getAction();
            if (action.equals(Constants.ACTION_DIFF) || action.equals(Constants.ACTION_SUM) ) {
                String text = intent.getStringExtra(Constants.INTENT_KEY);
                Log.d(Constants.RECEIVER_TAG, "Result for "+ action +" is : " +  text);
                recv++;
            }
        }
    }
}
