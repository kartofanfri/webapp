package ru.mai.dep806.mvcapp.model;

import java.util.ArrayList;

/**
 * Created by 111 on 29.03.2015.
 */
public class ToDoList {
    ArrayList<String> list = new ArrayList<String>();

    public ToDoList(ArrayList<String> list) {
        this.list = list;
    }

    public ToDoList(String... str) {
        for (String forStr : str){
            list.add(forStr);
        }
    }

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }
}
