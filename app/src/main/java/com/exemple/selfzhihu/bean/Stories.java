package com.exemple.selfzhihu.bean;

import java.util.List;

/**
 * Created by Jasper on 2017/4/22.
 */

public class Stories implements BaseItem{
    private String title;
    private List<String> images;
    private String ga_prefix;
    private String type;
    private int id;
    private boolean multipic;

    public boolean isMultipic() {
        return multipic;
    }

    public void setMultipic(boolean multipic) {
        this.multipic = multipic;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;
    }
}
