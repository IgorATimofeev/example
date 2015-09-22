package ru.erlinve.example_22_09;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by sebastian on 9/22/15.
 */
public class MainService extends Service {

    private static final String TAG = MainService.class.getName();

    private IMainServiceInterface.Stub binder =null;

    private IMainServiceInterface.Stub getBinder()
    {
        if (binder == null) {
            binder = new RealisationMainServiceInterface(this);
        }
        return binder;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return getBinder();
    }

    @Override
    public void onCreate()
    {
        Log.e(TAG, "Create Service");
    }

    @Override
    public void onDestroy()
    {
        Log.e(TAG, "Destroy Service");
    }

    @Override
    public boolean onUnbind(Intent intent)
    {

        Log.e(TAG, "Unbind Service");

        return super.onUnbind(intent);
    }
}
