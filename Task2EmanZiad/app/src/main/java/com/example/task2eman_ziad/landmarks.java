package com.example.task2eman_ziad;

public class landmarks {
    private String name;
    private int image_resource_id;
    public landmarks(int image_resource_id, String name) {
        this.name = name;
        this.image_resource_id = image_resource_id;
    }
    public String getName() {
        return name;
    }
    public int getImage_resource_id() {
        return image_resource_id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setImage_resource_id(int image_resource_id) {
        this.image_resource_id = image_resource_id;
    }

}
