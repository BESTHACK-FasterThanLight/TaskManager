package ru.lionzxy.taskmanager.utils;

import android.app.Activity;
import android.widget.TextView;

import java.util.TimerTask;

interface OnMinuteEndListener {
    void onTimeOut();
}

public class CommentTimer extends TimerTask {

    private int seconds = 60;
    private TextView mTime;
    private Activity mActivity;
    private OnMinuteEndListener callback;

    public CommentTimer(TextView t, Activity mActivity, OnMinuteEndListener callback) {
        super();
        this.mTime = t;
        this.mActivity = mActivity;
        this.callback = callback;
    }

    @Override
    public void run() {
        seconds--;
        String time = "00:";

        if (seconds < 0) {
            mActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    callback.onTimeOut();
                }
            });
            return;
        }

        if (seconds < 10) {
            time += "0" + seconds;
        } else {
            time += seconds;
        }

        final String finalTime = time;

        mActivity.runOnUiThread(new Runnable() {

            @Override
            public void run() {
                mTime.setText(finalTime);
            }
        });

    }
}


// private Timer mTimer;
// private CommentTimer timer;


// if (mTimer != null) {
//					mTimer.cancel();
// }
// mTimer = new Timer();
// timer = new CommentTimer(textView, Activity);
// textView.setText("01:00");
// mTimer.schedule(timer, 1000, 1000);