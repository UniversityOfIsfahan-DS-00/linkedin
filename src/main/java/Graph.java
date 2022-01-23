package main.java;

import java.util.*;

public class Graph {
    public class Vertex implements Comparable<Vertex>{
        User userValue;
        //ArrayList<Vertex> neighbors;
        //HashSet<Vertex> neighbors;
        HashSet<User> neighbors;
        double priority;
        boolean visited;
        //___________________________________________________________________________//

        public Vertex(User userValue){
            this.userValue=userValue;
            //neighbors=new ArrayList<>();
            neighbors=new HashSet<>();

            this.priority=0;
            this.visited=false;
        }
        //___________________________________________________________________________//


        public void setUserValue(User userValue) {

            this.userValue = userValue;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }
        //___________________________________________________________________________//


        public User getUserValue() {
            return userValue;
        }
        //___________________________________________________________________________//

        public  int distance_Vertex(Vertex vertex){
            //شی this  را فاصله اش را با user پیدا میکند
            Map<Vertex,Integer> distance=new LinkedHashMap<>();
            for(Vertex v:global_Graph.values()){
                distance.put(v,0);
            }
            for(Vertex v: global_Graph.values()){
                v.setVisited(false);
            }
            Queue<User> users_Q=new LinkedList<>();

            users_Q.add(this.userValue);
            this.visited=true;
            distance.put(this,0);
            L2:
            while (!users_Q.isEmpty()){
                //System.out.println("a");
                User temp=users_Q.poll();
                for(User v: global_Graph.get(temp.getId()).neighbors){
                    if(global_Graph.get(v.getId()).visited){
                        continue;
                    }

                    distance.put(global_Graph.get(v.getId()),distance.get(global_Graph.get(temp.getId()))+1);
                    global_Graph.get(v.getId()).visited=true;
                    users_Q.add(v);
                    //v.userValue.print_User_Data();

                    //System.out.println(v.visited);
//                    for(Vertex n: global_Graph.values()){
//                        n.userValue.print_User_Data();
//                    }

                }
                //temp.userValue.print_User_Data();
                if(users_Q.isEmpty()){
                    break L2;
                }
                //users_Q.peek().userValue.print_User_Data();

            }
            //System.out.println("a");
//            for (Vertex t:distance.keySet()){
//
//                t.userValue.print_User_Data();
//            }
            return distance.get(vertex);
        }
        public double give_Priority(Vertex vertex){
            //اولویت user را برای شی this  محاسبه و در مقدار اولویت شی user ذخیره میکند
            vertex.priority=this.userValue.isColleague(vertex.userValue)*10+this.userValue.isInField(vertex.userValue)*20+this.userValue.isInUniversity(vertex.userValue)*10+this.userValue.numCommonConnections(vertex.userValue)*8+this.userValue.numCommonSpecialties(vertex.userValue)*20-this.distance_Vertex(vertex)*15;
            return vertex.priority;
        }
        public void traversal_for_give_priority(){
            //پیشمایش از شی this و برای هر گره ک پیمایش میشود تابع give_piority  را صدا میزند
            for(Vertex v: global_Graph.values()){
                v.setVisited(false);
            }
            Queue<User> queue=new LinkedList<>();

            queue.add(this.userValue);
            this.visited=true;
            L3:
            while (!queue.isEmpty()){
                User temp=queue.poll();
                //queue.addAll(global_Graph.get(temp.getId()).neighbors);
//                for(User u:global_Graph.get(temp.getId()).neighbors){
//                    u.print_User_Data();
//                }
                for(User u:global_Graph.get(temp.getId()).neighbors){
                    if(global_Graph.get(u.getId()).visited){
                        continue ;
                    }
                    global_Graph.get(u.getId()).visited=true;
                    queue.add(u);
                    //System.out.println(queue.toString());
                }
                //System.out.println("b");
                this.give_Priority(global_Graph.get(temp.getId()));

                //temp.print_User_Data();
                //System.out.println(this.give_Priority(global_Graph.get(temp.getId())));

                if(queue.isEmpty()){
                    break L3;
                }
            }
            //System.out.println("c");

        }
        public ArrayList<Vertex> traversal_for_top20_suggestion(){
            //پیمایش گراف با مبدا شی  this  و اضافه کردن 20 تا از بیشترین اولویت ها به لیست و برگرداندن آن
            ArrayList<Vertex> vertices=new ArrayList<>();
            for(Vertex v: global_Graph.values()){
                v.setVisited(false);
            }
            Queue<User> queue=new LinkedList<>();
            queue.add(this.userValue);
            this.visited=true;
            while (!queue.isEmpty()){
                User temp=queue.poll();
                for(User v:global_Graph.get(temp.getId()).neighbors){
                    if(global_Graph.get(v.getId()).visited){
                        continue;
                    }
                    global_Graph.get(v.getId()).visited=true;
                    queue.add(v);
                }
                if(vertices.size()>=20){
                    if(vertices.get(0).priority > global_Graph.get(temp.getId()).priority){
                        vertices.remove(0);
                        vertices.add(global_Graph.get(temp.getId()));
                        Collections.sort(vertices);
                    }
                }else{
                    vertices.add(global_Graph.get(temp.getId()));
                    Collections.sort(vertices);
                }
            }
            return vertices;
        }

        @Override
        public int compareTo(Vertex o) {
            if(this.priority>o.priority){
                return 1;
            }
            else if(this.priority==o.priority){
                return 0;
            }
            else{
                return -1;
            }
        }
    }
    public static Map<String,Vertex> global_Graph=new LinkedHashMap<>();


    public static Graph graph_this=new Graph();
    public  void  createVertex(ArrayList<User> users){
        //peimaiesh list users and create vertex and to the global graph
        for(User u:users){
            global_Graph.put(u.getId(),new Vertex(u));
        }
    }

    public void linked_Connections(){
        //پیمایش گراف گلوبال با دو حلقه فور تو در تو و وصل کردن کانکشن ها برای هر گره
        for(Vertex vertex : global_Graph.values()){
            for(String connection : vertex.userValue.connectionId){
                vertex.neighbors.add(global_Graph.get(connection).userValue);
            }
        }
    }
    public void showGraph(){
        for(Vertex v:global_Graph.values()){
            v.userValue.print_User_Data();
        }
    }
}
