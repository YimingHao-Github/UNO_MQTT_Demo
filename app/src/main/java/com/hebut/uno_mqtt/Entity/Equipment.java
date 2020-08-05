package com.hebut.uno_mqtt.Entity;

public class Equipment {
    private int equipment_id;
    private String equipment_name;
    private String equipment_introduction;
    private int equipment_image;//图片来源int的id

    public Equipment(int equipment_id,String equipment_name,String equipment_introduction,int equipment_image){
        this.equipment_id=equipment_id;
        this.equipment_name=equipment_name;
        this.equipment_introduction=equipment_introduction;
        this.equipment_image=equipment_image;
    }




    public int getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(int equipment_id) {
        this.equipment_id = equipment_id;
    }

    public String getEquipment_name() {
        return equipment_name;
    }

    public void setEquipment_name(String equipment_name) {
        this.equipment_name = equipment_name;
    }

    public String getEquipment_introduction() {
        return equipment_introduction;
    }

    public void setEquipment_introduction(String equipment_introduction) {
        this.equipment_introduction = equipment_introduction;
    }

    public int getEquipment_image() {
        return equipment_image;
    }

    public void setEquipment_image(int equipment_image) {
        this.equipment_image = equipment_image;
    }


}
