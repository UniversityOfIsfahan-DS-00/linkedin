package main.java;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.User;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        try {
            inputData();
        }catch (RuntimeException r){

        }
    }
    public static List<User> inputData() throws IOException {

        File f=new File("users.json");
        // دریافت اطلاعات کاربر ها و ذخیر داخل شی های user ها و اد کردن به لیست users و سپس برگرداندن این لیست
        ObjectMapper mapper=new ObjectMapper();

        List<User> users=mapper.readValue(f, new TypeReference<List<User>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        });
        //List<User> myObjects = Arrays.asList(mapper.treeToValue(jsonNode.get("fieldName"), MyClass[].class))
        for(User u:users){
            u.print_User_Data();
        }
        return users;
    }
}
