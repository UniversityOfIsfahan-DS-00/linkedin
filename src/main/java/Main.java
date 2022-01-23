package main.java;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.User;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        try {
            inputData();
        }catch (RuntimeException r){
            r.printStackTrace();
        }
//        for(Graph.Vertex j: Graph.global_Graph.values()){
//            j.userValue.print_User_Data();
//        }

//        Graph.global_Graph.get("1").traversal_for_give_priority();
//        ArrayList<Graph.Vertex> top20=Graph.global_Graph.get("1").traversal_for_top20_suggestion();
//        for(Graph.Vertex v:top20){
//            v.userValue.print_User_Data();
//        }
        L1:
        try {
            while (true) {
                System.out.println("1) SHOW USERS");
                System.out.println("2) SUGGESTION");
                System.out.println("3) EXIT");
                switch (sc.nextInt()) {
                    case 1: {
                        Graph.graph_this.showGraph();
                        break;
                    }
                    case 2: {
                        System.out.println("PLEASE ENTER YOUR ID : ");
                        String id_user = sc.next();
                        Graph.global_Graph.get(id_user).traversal_for_give_priority();
                        ArrayList<Graph.Vertex> vertxs = Graph.global_Graph.get(id_user).traversal_for_top20_suggestion();
                        System.out.println(vertxs.size());


                        //System.out.println(Graph.global_Graph.get("3").priority);
                        for (Graph.Vertex v : vertxs) {
                            v.userValue.print_User_Data();
                        }
//                        for(Graph.Vertex v:Graph.global_Graph.values()){
//                            System.out.println(v.priority);
//                        }

                        break;
                    }
                    case 3: {
                        break L1;
                    }
                }
            }
        }catch (RuntimeException re){
            re.printStackTrace();
        }


    }
    public static void inputData() throws IOException {

        File f=new File("5_6294316358024824565.json");
        // دریافت اطلاعات کاربر ها و ذخیر داخل شی های user ها و اد کردن به لیست users و سپس برگرداندن این لیست
        ObjectMapper mapper=new ObjectMapper();

        List<User> users=mapper.readValue(f, new TypeReference<List<User>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        });
        //List<User> myObjects = Arrays.asList(mapper.treeToValue(jsonNode.get("fieldName"), MyClass[].class))
//        for(User u:users){
//            u.print_User_Data();
//        }
        Graph.graph_this.createVertex((ArrayList<User>) users);
        Graph.graph_this.linked_Connections();
    }
}
