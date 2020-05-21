package org.example;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class HelloWorld {
    public void doSomething(){
        System.out.println(getCount());
    }
    public int getCount(){
        int count = 0;
        for (int i = 0; i < 10; i++) {
            count += i+1;
        }
        return count;
    }
    public static void main(String[] args) {
        //System.out.println("Hello World");
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.doSomething();
        int id = 10;
        String idString = StringUtils.leftPad(Integer.toString(id),7,"0");
        System.out.println(idString);
        try {
            String text = FileUtils.readFileToString(new File("ath-to-file"), "UTF-8");
            List<String> lines = FileUtils.readLines(new File("ath-to-file"), "UTF-8");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
