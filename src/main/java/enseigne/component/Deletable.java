package enseigne.component;

import org.apache.commons.io.FileUtils;

import java.io.File;

public abstract class Deletable {
    private String path;
    private String name;
    public void delete(){
        File toDel = new File(path+name+".json");
        FileUtils.deleteQuietly(toDel);
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setName(String name) {
        this.name = name;
    }
}
