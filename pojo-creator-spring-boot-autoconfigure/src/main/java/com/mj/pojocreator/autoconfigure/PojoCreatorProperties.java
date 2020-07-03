package com.mj.pojocreator.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "pojo.creator")
public class PojoCreatorProperties {

    private String jsonFilePath;
    private String pathToCreatePojo;
    private String pojoPackageName;

    public String getJsonFilePath() {
        return jsonFilePath;
    }

    public void setJsonFilePath(String jsonFilePath) {
        this.jsonFilePath = jsonFilePath;
    }

    public String getPathToCreatePojo() {
        return pathToCreatePojo;
    }

    public void setPathToCreatePojo(String pathToCreatePojo) {
        this.pathToCreatePojo = pathToCreatePojo;
    }

    public String getPojoPackageName() {
        return pojoPackageName;
    }

    public void setPojoPackageName(String pojoPackageName) {
        this.pojoPackageName = pojoPackageName;
    }


}
