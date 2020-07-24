package com.example.demo.test2.ali.part6;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName AnimalCatGarfield
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/23  10:34 下午
 * @Version 1.0
 */
public class AnimalCatGarfield {

    public static void main(String[] args) {

        List<Animal> animal = new ArrayList<>();
        List<Cat> cat = new ArrayList<>();
        List<Garfield> garfield = new ArrayList<>();

        animal.add(new Animal());
        cat.add(new Cat());
        garfield.add(new Garfield());

        //List<? extends Cat> extendsCatFromAnimal = animal;
        List<? super Cat> superCatFromAnimal = animal;

        List<? extends Cat> extendsCatFromCat = cat;
        List<? super Cat> superCatFromCat = cat;

        List<? extends Cat> extendsCatFromGarfield = garfield;
        //List<? super Cat> superCatFromGarfield = garfield;

        //extendsCatFromCat.add(new Animal());
        //extendsCatFromCat.add(new Cat());
        //extendsCatFromCat.add(new Garfield());
        extendsCatFromCat.add(null);

        //superCatFromCat.add(new Animal());
        superCatFromCat.add(new Cat());
        superCatFromCat.add(new Garfield());

        Cat cat1 = extendsCatFromCat.get(0);
        Object o = extendsCatFromCat.get(0);

        //Garfield garfield1 = extendsCatFromCat.get(0);


    }

}
