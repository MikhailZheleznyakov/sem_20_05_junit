package model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

public class UserTest {

    private User user;
    private User user1;
    private User user2;

    @BeforeEach
    public void setUp() throws Exception {
        user = new User("Данил", 25, Gender.MALE);
        user1 = new User("Дарья", 19, Gender.FEMALE);
        user2 = new User("Владимир", 45, Gender.MALE);
    }

    @AfterEach
    public void endTest(){
        User.allUsers.clear();
    }


    @Test
    public void getAllUsers() {
        List<User> expected = User.getAllUsers();

        List<User> actual = new ArrayList<>();
        actual.add(user);
        actual.add(user1);
        actual.add(user2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllUsersNotNull() {
        List<User> expected = User.getAllUsers();
        Assert.assertNotNull(expected);
    }

    @Test
    public void getAllUsersMale() {
        List<User> expected = User.getAllUsers(Gender.MALE);

        List<User> actual = new ArrayList<>();
        actual.add(user);
        actual.add(user1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllUsersMaleNotnull() {

        List<User> expected = User.getAllUsers(Gender.MALE);
        Assert.assertNotNull(expected);
    }

    @Test
    public void getAllUsersFemale() {
        List<User> expected = User.getAllUsers(Gender.FEMALE);

        List<User> actual = new ArrayList<>();
        actual.add(user2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllUsersFemaleNotNull() {

        List<User> expected = User.getAllUsers(Gender.FEMALE);
        Assert.assertNotNull(expected);
    }

    @Test
    public void getHowManyUsers() {
        int expected = User.getHowManyUsers();

        int actual = 3;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHowManyUsersMale() {
        int expected = User.getHowManyUsers(Gender.MALE);

        int actual = 2;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHowManyUsersFemale() {
        int expected = User.getHowManyUsers(Gender.FEMALE);

        int actual = 1;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllAgeUsers() {
        int expected = User.getAllAgeUsers();

        int actual = 80;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllAgeUsersMale() {
        int expected = User.getAllAgeUsers(Gender.MALE);

        int actual = 30;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAllAgeUsersFemale() {
        int expected = User.getAllAgeUsers(Gender.FEMALE);

        int actual = 15;

        Assert.assertEquals(expected, actual);
    }
}