package com.hebut.uno_mqtt.Async;

import android.os.AsyncTask;
import android.widget.TextView;

import com.hebut.uno_mqtt.Manager.MQTTManager;

import org.json.JSONException;
import org.json.JSONObject;

public class Async_Result extends AsyncTask<Object, Integer, Object> {
    private TextView tv_equipment_id= null;
    private TextView tv_temperature= null;
    private TextView tv_humidity= null;
    private TextView tv_dust= null;

    public Async_Result(TextView tv_equipment_id, TextView tv_temperature, TextView tv_humidity, TextView tv_dust){
        this.tv_equipment_id = tv_equipment_id;
        this.tv_temperature = tv_temperature;
        this.tv_humidity = tv_humidity;
        this.tv_dust = tv_dust;
    }

    //    这个方法是在执行异步任务之前的时候执行，并且是在UI
//Thread当中执行的，通常我们在这个方法里做一些UI控件的初始化的操作，例如弹出进度条
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        tv_equipment_id.setText("开始异步任务！");
    }

    //    在onPreExecute()方法执行完后，会马上执行这个方法，这个方法就是来处理异步任务的方法，Android操作系统会在后台的线程池当中开启一个worker
//thread来执行这个方法(即在worker thread当中执行)，执行完后将执行结果发送给最后一个 onPostExecute
//方法，在这个方法里，我们可以从网络当中获取数据等一些耗时的操作
    //protected Object doInBackground(Object... objects) {
    @Override
    protected Object doInBackground(Object... objects) {
        String last_result;
        last_result= MQTTManager.mqttManager.result;
        publishProgress(1);
        while (true){
            if(!last_result.equals(MQTTManager.mqttManager.result)) {
                publishProgress(1);
            }
            else {
                publishProgress(2);
            }
            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //    onPostExecute(Result… result): 当异步任务执行完之后，就会将结果返回给这个方法，这个方法也是在UI
//Thread当中调用的，我们可以将返回的结果显示在UI控件上
    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        tv_equipment_id.setText("结束异步任务！");
    }

    //onProgressUpdate(Progess… values): 这个方法也是在UI
//Thread当中执行的，在异步任务执行的时候，有时需要将执行的进度返回给UI界面，例如下载一张网络图片，我们需要时刻显示其下载的进度，就可以使用这个方法来更新进度。这个方法在调用之前，我们需要在
//doInBackground 方法中调用一个 publishProgress(Progress) 的方法来将进度时时刻刻传递给
//onProgressUpdate 方法来更新
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        if(values[0]==1){
            JSONObject jsonObject= null;
            try {
                jsonObject = new JSONObject(MQTTManager.mqttManager.result);
                tv_equipment_id.setText(jsonObject.getString("id"));
                tv_temperature.setText(jsonObject.getString("temperature"));
                tv_humidity.setText(jsonObject.getString("humidity"));
                tv_dust.setText(jsonObject.getString("dust"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}

