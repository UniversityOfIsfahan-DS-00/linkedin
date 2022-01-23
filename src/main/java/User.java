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

//    public void setConnectionId(ArrayList<Integer> connectionId) {
//        this.connectionId = connectionId;
//    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public void setSpecialties(ArrayList<String> specialties) {
//        this.specialties = specialties;
//    }

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

//    public ArrayList<Integer> getConnectionId() {
//        return connectionId;
//    }


//    public ArrayList<String> getSpecialties() {
//        return specialties;
//    }

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
