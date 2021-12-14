package com.company;

public class Person {
   private final String name;
   private final int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private Person(Builder builder){
       this.name = builder.name;
       this.age = builder.age;

   }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static class Builder {
       private String name;
       private int age;



       public Builder name(final String name){
           this.name = name;
           return this;
       }

       public Builder age(final int age)
       {
           this.age = age;
           return this;
   }

   public Person build() {
           return new Person(this);
   }


   }







}
