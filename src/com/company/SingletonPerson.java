package com.company;

public class SingletonPerson {
    private static SingletonPerson singletonPerson;
    private String name;
    private int age;


    private SingletonPerson() {

    }

    private static class SingletonHolder {
        private static SingletonPerson instance = new SingletonPerson();
    }


    public static SingletonPerson getInstance() {
        return SingletonHolder.instance;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }


}
