package ru.mai.dep806.mvcapp.model;

import java.util.List;

/**
 * Created by 111 on 29.03.2015.
 */
public class ToDoList {
    List<String> list;

    public ToDoList(List<String> list) {
        this.list = list;
    }

    public ToDoList(String... str) {
        for (String forStr : str){
            list.add(forStr);
        }
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
