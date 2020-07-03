package com.mj.pojocreator.library;

import com.sun.codemodel.JCodeModel;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class PojoCreator {

    private PojoConfig pojoConfig;

    public PojoCreator(PojoConfig pojoConfig) {
        this.pojoConfig = pojoConfig;
    }


    public void createPojo() {
        System.out.println("Pojo Creation started");
        try {

            String jsonFilePath = pojoConfig.getProperty(PojoConfigParams.JSON_FILE_PATH);
            String pathToCreatePojo = pojoConfig.getProperty(PojoConfigParams.PATH_TO_CREATE_POJO);
            String packageName = pojoConfig.getProperty(PojoConfigParams.POJO_PACKAGE_NAME);
            System.out.println(jsonFilePath);
            System.out.println(pathToCreatePojo);
            System.out.println(packageName);

            File inputJson = ResourceUtils.getFile(jsonFilePath);
            Scanner input = new Scanner(inputJson);

            while (input.hasNextLine()) {
                System.out.println(input.nextLine());
            }

            File outputPojoDirectory=new File(System.getProperty("user.dir")+File.separator+ pathToCreatePojo);
            outputPojoDirectory.mkdirs();


           convert2JSON(inputJson.toURI().toURL(), outputPojoDirectory, packageName,
                    inputJson.getName().replace(".json", ""));

        } catch( Exception exception) {
            System.out.println("Failed to create pojo");
        System.out.println("Pojo Created");
        }
    }


    private void convert2JSON(URL inputJson, File outputPojoDirectory, String packageName, String className) throws IOException {
        JCodeModel codeModel = new JCodeModel();
        URL source = inputJson;
        GenerationConfig config = new DefaultGenerationConfig() {
            @Override
            public boolean isGenerateBuilders() { // set config option by overriding method
                return true;
            }
            public SourceType getSourceType(){
                return SourceType.JSON;
            }
        };
        SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()),
                new SchemaGenerator());
        mapper.generate(codeModel, className, packageName, source);
        codeModel.build(outputPojoDirectory);
    }


}