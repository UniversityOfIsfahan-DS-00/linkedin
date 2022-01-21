package main.java;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Graph {
    public class Vertex{
        User userValue;
        ArrayList<Vertex> neighbors;
        double priority;
        //___________________________________________________________________________//

        public Vertex(User userValue){
            this.userValue=userValue;
            neighbors=new ArrayList<>();
            this.priority=0;
        }
        //___________________________________________________________________________//


        public void setUserValue(User userValue) {
            this.userValue = userValue;
        }
        //___________________________________________________________________________//


        public User getUserValue() {
            return userValue;
        }
        //___________________________________________________________________________//
        public void createVertex(ArrayList<User> users){
            //peimaiesh list users and create vertex and to the global graph
            for(User u:users){
                global_Graph.put(u.getId(),new Vertex(u));
            }
        }

        public void linked_Connections(){
            //پیمایش گراف گلوبال با دو حلقه فور تو در تو و وصل کردن کانکشن ها برای هر گره
            for(Vertex vertex : global_Graph.values()){
                for(int connection : vertex.userValue.connectionId){
                    vertex.neighbors.add(global_Graph.get(connection));
                }
            }
        }
        public int distance_Vertex(User user){
            //شی this  را فاصله اش را با user پیدا میکند
        }
        public double give_Priority(User user){
            //اولویت user را برای شی this  محاسبه و در مقدار اولویت شی user ذخیره میکند
        }
        public void traversal_for_give_priority(){
            //پیشمایش از شی this و برای هر گره ک پیمایش میشود تابع give_piority  را صدا میزند
        }
        public ArrayList<Vertex> traversal_for_top20_suggestion(){
            //پیمایش گراف با مبدا شی  this  و اضافه کردن 20 تا از بیشترین اولویت ها به لیست و برگرداندن آن
        }

    }
    public static Map<Integer,Vertex> global_Graph=new LinkedHashMap<>();

}
