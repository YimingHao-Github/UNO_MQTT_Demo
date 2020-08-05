package com.hebut.uno_mqtt.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hebut.uno_mqtt.Async.Async_Result;
import com.hebut.uno_mqtt.Manager.MQTTManager;
import com.hebut.uno_mqtt.R;

import org.json.JSONException;
import org.json.JSONObject;

public class EquipmentFragment extends Fragment {

    private TextView tv_equipment_id;
    private TextView tv_temperature;
    private TextView tv_humidity;
    private TextView tv_dust;

    private EditText et_id;
    private EditText et_cmd;

    private Button btn_Pub;
    private Button btn_Connect;
    private Button btn_Disconnect;

    private MQTTManager mqttManager;

    Async_Result async_result;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_equipment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tv_equipment_id=(TextView)getView().findViewById(R.id.equipment_id);
        tv_temperature=(TextView)getView().findViewById(R.id.temperature);
        tv_humidity=(TextView)getView().findViewById(R.id.humidity);
        tv_dust=(TextView)getView().findViewById(R.id.dust);

        et_id=(EditText)getView().findViewById(R.id.id);
        et_cmd=(EditText)getView().findViewById(R.id.cmd);

        btn_Pub=(Button)getView().findViewById(R.id.btn_pub_json);
        btn_Connect=(Button)getView().findViewById(R.id.btn_connect_json);
        btn_Disconnect=(Button)getView().findViewById(R.id.btn_disconnect);

        btn_Connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mqttManager = MQTTManager.getInstance(getContext());
                mqttManager.connect();
                String topic="spray/information/"+et_id.getText().toString();
                mqttManager.subscribe(topic,0);
                async_result = new Async_Result(tv_equipment_id,tv_temperature,tv_humidity,tv_dust);
                async_result.execute();
                Toast.makeText(getContext(), "已连接到服务器，并订阅主题："+topic, Toast.LENGTH_LONG).show();
            }
        });


        btn_Pub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                JSONObject jsonObject=new JSONObject();
                try {
                    jsonObject.put("id", et_id.getText().toString());
                    jsonObject.put("cmd", et_cmd.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                ;
                mqttManager.publish("spray/cmd",jsonObject.toString(),false,0);
            }
        });

        btn_Disconnect.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                async_result.cancel(true);
                mqttManager.result="{'id':'0','humidity':'0','temperature':'0','dust':'0',}";
                mqttManager.disconnnect();
            }
        });


    }
}
