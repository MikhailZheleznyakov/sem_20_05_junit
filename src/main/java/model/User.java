package model;

import java.util.*;

public class User {
    private int id;
    private String name;
    private int age;
    private Gender gender;
    public static Map<Integer, User> allUsers;
    private static int countId = 0;

    public User(String name, int age, Gender gender) {
        if (allUsers == null){
            allUsers = new HashMap<>();
        }

        this.name = name;
        this.age = age;
        this.gender = gender;

        if (!hasUser()){
            countId++;
            this.id = countId;
            allUsers.put(id, this);
        }


    }
    private boolean hasUser(){
        for (User user : allUsers.values()){
            if (user.equals(this) && user.hashCode() == this.hashCode()){
                return true;
            }
        }
        return false;
    }


    public static List<User> getAllUsers(Gender gender){
        List<User> listAllUsers = new ArrayList<>();
        for (User user : allUsers.values()){
            if (user.gender == gender){
                listAllUsers.add(user);
            }
        }
        return listAllUsers;
    }

    public static List<User> getAllUsers(){
        return new ArrayList<>(allUsers.values());
    }

    public static int getHowManyUsers(){
        return allUsers.size();
    }

    public static int getHowManyUsers(Gender gender){
        return getAllUsers(gender).size();
    }

    public static int getAllAgeUsers(){
        int countAge = 0;
        for (User user : allUsers.values()){
            countAge += user.age;
        }
        return countAge;
    }

    public static int getAllAgeUsers(Gender gender){
        int countAge = 0;
        for (User user : getAllUsers(gender)){
            countAge += user.age;
        }
        return countAge;
    }

    public static int getAverageAgeOfAllUsers(){
        int countAge = 0;
        for (User user : allUsers.values()){
            countAge += user.age;
        }
        return countAge / getHowManyUsers();
    }

    public static int getAverageAgeOfAllUsers(Gender gender){
        int countAge = 0;
        for (User user : getAllUsers(gender)){
            countAge += user.age;
        }
        return countAge / getHowManyUsers(gender);
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name) &&
                gender == user.gender;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age, gender);
    }
}
