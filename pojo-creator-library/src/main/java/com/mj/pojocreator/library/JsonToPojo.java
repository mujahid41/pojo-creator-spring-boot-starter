/*
package com.mj.pojocreator.library;

import com.sun.codemodel.JCodeModel;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;


public class JsonToPojo {


    public static void main(String[] args) throws FileNotFoundException {
        String packageName= "generated";

        //File inputJson= new File("."+File.separator+"input.json");
        File inputJson = ResourceUtils.getFile("classpath:json/employee.json");
        File outputPojoDirectory=new File(System.getProperty("user.dir")+File.separator+ "target/generated");

    //    System.out.println(outputPojoDirectory.getAbsoluteFile());
        outputPojoDirectory.mkdirs();
        try {


            new JsonToPojo().convert2JSON(inputJson.toURI().toURL(), outputPojoDirectory, packageName,
                    inputJson.getName().replace(".json", ""));



            //new JsonToPojo().convert2JSON(inputJson.toURI().toURL(), outputPojoDirectory, packageName, inputJson.getName().replace(".json", ""));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Encountered issue while converting to pojo: "+e.getMessage());
            e.printStackTrace();
        }
    }

    public void convert2JSON(URL inputJson, File outputPojoDirectory, String packageName, String className) throws IOException {
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
        SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
        mapper.generate(codeModel, className, packageName, source);
        codeModel.build(outputPojoDirectory);
    }

}
*/
