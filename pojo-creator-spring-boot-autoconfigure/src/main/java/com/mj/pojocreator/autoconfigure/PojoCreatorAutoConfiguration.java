package com.mj.pojocreator.autoconfigure;


import com.mj.pojocreator.library.PojoConfig;
import com.mj.pojocreator.library.PojoCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.mj.pojocreator.library.PojoConfigParams.JSON_FILE_PATH;
import static com.mj.pojocreator.library.PojoConfigParams.PATH_TO_CREATE_POJO;
import static com.mj.pojocreator.library.PojoConfigParams.POJO_PACKAGE_NAME;

@Configuration
@ConditionalOnClass(PojoCreator.class)
@EnableConfigurationProperties(PojoCreatorProperties.class)
public class PojoCreatorAutoConfiguration {
    @Autowired
    private PojoCreatorProperties greeterProperties;

    @Bean
    @ConditionalOnMissingBean
    public PojoConfig pojoConfig() {
        PojoConfig pojoConfig = new PojoConfig();
        pojoConfig.put(JSON_FILE_PATH, greeterProperties.getJsonFilePath());
        pojoConfig.put(PATH_TO_CREATE_POJO, greeterProperties.getPathToCreatePojo());
        pojoConfig.put(POJO_PACKAGE_NAME, greeterProperties.getPojoPackageName());

        return pojoConfig;
    }

    @Bean
    @ConditionalOnMissingBean
    public PojoCreator pojoCreator(PojoConfig pojoConfig) {
        return new PojoCreator(pojoConfig);
    }

}
