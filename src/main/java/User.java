package main.java;

import java.util.ArrayList;

public class User {
    private String id;
    private String name;
    private String dateOfBirth;
    private String universityLocation;
    private String field;
    private String workplace;
    ArrayList<String> specialties;
    ArrayList<String> connectionId;

    public User(){

    }
    public User(String id,String name,String dateOfBirth,String universityLocation,String field,String workplace,ArrayList<String> specialties,ArrayList<String> connectionId){
        this.id=id;
        this.name=name;
        this.dateOfBirth=dateOfBirth;
        this.universityLocation=universityLocation;
        this.field=field;
        this.workplace=workplace;
        this.specialties=specialties;
        this.connectionId=connectionId;
    }
//___________________________________________________________________________//

    public void setName(String name) {
        this.name = name;
    }


    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void setId(String id) {
        this.id = id;
    }



    public void setUniversityLocation(String universityLocation) {
        this.universityLocation = universityLocation;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }
//___________________________________________________________________________//
    public String getName() {
        return name;
    }



    public String getId() {
        return id;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getField() {
        return field;
    }

    public String getUniversityLocation() {
        return universityLocation;
    }

    public String getWorkplace() {
        return workplace;
    }

    public ArrayList<String> getSpecialties() {
        return specialties;
    }

    public ArrayList<String> getConnectionId() {
        return connectionId;
    }
    //___________________________________________________________________________//

    public int isColleague(User user){
        //ایا user همکار من هست یا ن؟در محل کار من کار میکند یا ن؟
        if(this.workplace.equals(user.workplace)){
            return 1;
        }
        else{
            return 0;
        }
    }

    public int isInUniversity(User user){
        //ایا user در دانشگاه من تحصیل کرده است؟
        if(this.universityLocation.equals(user.universityLocation)){
            return 1;
        }
        else{
            return 0;
        }
    }

    public int isInField(User user){
        //ایا user در field  کاری من فعالیت میکند؟
        if(this.field.equals(user.field)){
            return 1;
        }
        else{
            return 0;
        }
    }

    public int numCommonSpecialties(User user){
        //تعداد تخصص های مشترک با user
        int numS=0;
        for(int i=0;i<this.specialties.size();i++){
            for(int j=0;j<user.specialties.size();j++){
                if(this.specialties.get(i).equals(user.getSpecialties().get(j))){
                    numS++;
                }
            }
        }
        return numS;
    }

    public int numCommonConnections(User user){
        //تعداد connection  های مشترک با user
        int numC=0;
        for(int i=0;i<this.connectionId.size();i++){
            for(int j=0;j<user.connectionId.size();j++){
                if(this.connectionId.get(i).equals(user.getConnectionId().get(j))){
                    numC++;
                }
            }
        }
        return numC;
    }





    public void print_User_Data(){
        System.out.println("_____________________________ USER INFO __________________________");
        System.out.println("USER ID : "+this.id);
        System.out.println("USER NAME : "+this.name);
        System.out.println("USER DATE OF BIRTH : "+this.dateOfBirth);
        System.out.println("USER UNIVERSITY LOCATION : "+this.universityLocation);
        System.out.println("USER FIELD : "+this.field);
        System.out.println("USER WORK PLACE : "+this.workplace);
        System.out.println("USER SPECIALTIES : "+this.specialties.toString());
        System.out.println("USER CONNECTIONS : "+this.connectionId.toString());
        System.out.println("___________________________________________________________________");

    }

}
