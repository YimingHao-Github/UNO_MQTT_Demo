package com.hebut.uno_mqtt.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hebut.uno_mqtt.Activity.RecordActivity;
import com.hebut.uno_mqtt.Adapter.EquipmentAdapter;
import com.hebut.uno_mqtt.Entity.Equipment;
import com.hebut.uno_mqtt.R;

import java.util.ArrayList;
import java.util.List;

public class RecordFragment extends Fragment {
    private List<Equipment> courseList = new ArrayList<Equipment>();


    private String[] courseTitle = {"设备一","设备二","设备三"};
    private String[] courseIntroduct ={"设备信息","设备信息：","设备信息"};
    private int[] courseImage = {R.mipmap.itemtitle1,R.mipmap.itemtitle2,R.mipmap.itemtitle3};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_record, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ListView listView = (ListView) getView().findViewById(R.id.courseCatalogueListView);
        EquipmentAdapter courseAdapter=new EquipmentAdapter(getActivity(),R.layout.equpiment_item);

        for(int i=0;i<courseTitle.length;i++){
            courseAdapter.add(new Equipment(i,courseTitle[i],courseIntroduct[i],courseImage[i]));
        }
        listView.setAdapter(courseAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(getActivity(),RecordActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(getActivity(),RecordActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getActivity(),RecordActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });

    }
}
