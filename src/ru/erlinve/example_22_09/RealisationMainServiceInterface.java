package ru.erlinve.example_22_09;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;

/**
 * Created by sebastian on 9/22/15.
 */
public class RealisationMainServiceInterface extends IMainServiceInterface.Stub {

    private static final String TAG = RealisationMainServiceInterface.class.getName();

    private IMainServiceCallback mServiceCallback;

    private static final int INDEX_MESSAGE_GOOD = 0;
    private static final String BUNDLE_KEY = "key";

    public RealisationMainServiceInterface(MainService mainService) {

    }

    public void registerServiceCallback( IMainServiceCallback serviceCallback)
    {
        mServiceCallback = serviceCallback;
    }

    public  void runNewThread()
    {

        new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i=0; i<5; ++i)
                {
                    Bundle bundle = new Bundle();
                    bundle.putInt(BUNDLE_KEY, i);

                    Message message = new Message();
                    message.setData(bundle);

                    mHandler.obtainMessage(INDEX_MESSAGE_GOOD);
                    mHandler.sendMessage(message);

                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        Log.e(TAG, e.toString());
                    }
                }
            }
        }).start();
    }

    private final Handler mHandler = new Handler()
    {
        public void handleMessage(Message message)
        {
            switch (message.what)
            {
                case INDEX_MESSAGE_GOOD :
                    Bundle bundle = message.getData();

                    int count = bundle.getInt(BUNDLE_KEY);

                    try {
                        mServiceCallback.setCountFromBackground(count);
                    } catch (RemoteException e) {
                        Log.e(TAG, e.toString());
                    }

            }
        }
    };


}
