package com.example.demo.test2.ali.part6;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @ClassName EqualsObject
 * @Description TODO
 * @Author 孤 鸿
 * @Date 2020/7/24  9:56 下午
 * @Version 1.0
 */
public class EqualsObject {

    private int id;
    private String name;

    public EqualsObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        if (this == o) {
            return true;
        }

        EqualsObject temp = (EqualsObject) o;
        if (temp.getId() == this.getId() && temp.getName().equals(this.getName())) {
            return true;
        }
        return false;
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

    public static void main(String[] args) {
        Set<EqualsObject> hashSet = new HashSet<>();
        EqualsObject equalsObject1 = new EqualsObject(1, "one");
        EqualsObject equalsObject2 = new EqualsObject(1, "one");
        EqualsObject equalsObject3 = new EqualsObject(1, "one");
        hashSet.add(equalsObject1);
        hashSet.add(equalsObject2);
        hashSet.add(equalsObject3);

        System.out.println(hashSet.size());
    }

}
