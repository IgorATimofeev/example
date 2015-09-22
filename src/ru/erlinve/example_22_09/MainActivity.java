package ru.erlinve.example_22_09;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getName();

    private IMainServiceInterface IMSInterface = null;
    private IMainServiceCallback.Stub IMSCallback = null;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        this.startServiceWorking();
    }

    @Override
    public void onDestroy()
    {

        Intent intent = new Intent(this, MainService.class);

        this.unbindService(serviceConnection);
        stopService(intent);

        super.onDestroy();
    }

    /**
     * ************************** SERVICE CONNECTION OPTIONS **********************
     */

    private ServiceConnection serviceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            Log.e(TAG, "onServiceConnected");

            IMSInterface = IMainServiceInterface.Stub.asInterface(service);

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

            Log.e(TAG, "onServiceDisconnected");

            IMSInterface = null;

        }
    };

    private void startServiceWorking(){

        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... params) {

                Log.e(TAG, "starting service working");

                Intent intent = new Intent(MainActivity.this, MainService.class);
                bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);

                IMSCallback = new IMainServiceCallback.Stub() {


                    @Override
                    public void setCountFromBackground(int count) throws RemoteException {

                        Log.e(TAG, "Count from background: "+String.valueOf(count));

                    }
                };

                return null;
            }

            @Override
            protected void onPostExecute(Void result){

                if(IMSInterface!=null)
                {
                    try {
                        IMSInterface.registerServiceCallback(IMSCallback);
                        IMSInterface.runNewThread();
                    } catch (RemoteException e) {
                        Log.e(TAG, e.toString());
                    }
                }
/**
 *  *********************** IMSInterface can be NULL & THIS IS PROBLEM
  */
                else Log.e(TAG, "onPost Connect IMSI is NULL");

                super.onPostExecute(result);

            }

        }.execute();
    }
}
