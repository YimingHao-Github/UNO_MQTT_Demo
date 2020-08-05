package com.hebut.uno_mqtt.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.hebut.uno_mqtt.R;

import com.hebut.uno_mqtt.Entity.Equipment;

public class EquipmentAdapter extends ArrayAdapter {
    private final int resourceId;

    public EquipmentAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        resourceId = textViewResourceId;//单个的视图
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Equipment equipment = (Equipment) getItem(position); // 获取当前项的Course实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);//实例化一个对象
//        LayoutInflater inflater = getLayoutInflater();
//        View view = inflater.inflate(resourceId, null);

        ImageView courseImage = (ImageView) view.findViewById(R.id.equipmentImage);//获取该布局内的图片视图
        TextView courseTitle = (TextView) view.findViewById(R.id.equipmentTitle);//获取该布局内的标题文本视图
        TextView courseIntroduct = (TextView) view.findViewById(R.id.equipmentIntroduct);//获取该布局内的介绍文本视图

        courseImage.setImageResource(equipment.getEquipment_image());//为图片视图设置图片资源
        courseTitle.setText(equipment.getEquipment_name());//为文本视图设置文本内容
        courseIntroduct.setText(equipment.getEquipment_introduction());//为文本视图设置文本内容
        return view;
    }
}
