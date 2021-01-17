package com.example.myapplication;

public class Person {

    int image;
    String name;
    String price;
    String age;

    public Person(int image, String name,String age, String price) {
        this.image = image;
        this.name = name;
        this.age = age;
        this.price = price;

    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Person() {

    }

}
