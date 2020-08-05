package com.hebut.uno_mqtt.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hebut.uno_mqtt.Async.Async_Result;
import com.hebut.uno_mqtt.Entity.Equipment;
import com.hebut.uno_mqtt.Manager.MQTTManager;
import com.hebut.uno_mqtt.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomePageFragment extends Fragment {
    private TextView company_introduction;
    private ImageView company_image;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_homepage, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        company_introduction=(TextView)getView().findViewById(R.id.company_introduction);
        company_image=(ImageView)getView().findViewById(R.id.company_image);

        company_introduction.setText("公司简介：");



    }

}
