/*Copyright [2010] [David Van de Ven]

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

*/

package com.wahtod.wififixer;

import android.os.IBinder;
import android.util.Log;
import android.app.Service;
import android.content.Intent;


public class WFDonateService extends Service {
    
	
	
	private static final String APP_NAME = "WFDonateService";
	private static final String AUTHEXTRA ="DICKS.ETC";
	//Enable logging
	final boolean LOGGING = false;
	// *****************************
	
	@Override
    public void onCreate() {
        // Start up the thread running the service.  Note that we create a
        // separate thread because the service normally runs in the process's
        // main thread, which we don't want to block.
		//Also, make sure we don't have a thread running. 
        //if (LOGGING)
        	//Log.i(APP_NAME,"OnCreate");
    }
	@Override
	public void onStart(Intent intent, int startId) {
		HandleStart(intent);	
	}
	@Override
	public int onStartCommand(Intent intent,int flags, int startId) {
		HandleStart(intent);
		return START_STICKY;
	}
	@Override
    public void onDestroy() {
        // Start up the thread running the service.  Note that we create a
        // separate thread because the service normally runs in the process's
        // main thread, which we don't want to block.
        //Thread.destroy
		//WFDonateService.this.mTask.notify()
    }
	
	@Override
    public IBinder onBind(Intent intent) {
    	//if (LOGGING)
			//Log.i(APP_NAME,"OnBind:Intent:"+intent.toString());
		return null;
    };
	
    
   

void HandleStart(Intent intent){
	String sAction=intent.getAction(); 
	if (LOGGING)
		Log.i(APP_NAME, "Intent:"+sAction);
	if (sAction.contains("com.wahtod.wififixer.WFDonateService")){
		Intent sendIntent = new Intent("org.wahtod.wififixer.WifiFixerService.AUTH");
		sendIntent.putExtra(AUTHEXTRA, "31415927");
		startService(sendIntent);
		if (LOGGING)
			Log.i(APP_NAME, "Sending Auth");
	}
	stopSelf();
}  

}




