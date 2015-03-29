package ru.mai.dep806.mvcapp.dao;

import ru.mai.dep806.mvcapp.model.ToDoList;

import java.util.ArrayList;

/**
 * Created by 111 on 29.03.2015.
 */
public class MockToDoListDao {
    ArrayList<ArrayList<String>> toDoLists = new ArrayList<ArrayList<String>>();

    public MockToDoListDao() {
        toDoLists.add(new ToDoList("some item 1","some item 2","some item 3").getList());
        toDoLists.add(new ToDoList("some item 4","some item 5","some item 6","some item 7").getList());
    }

    public  ArrayList<ArrayList<String>> getToDoLists() {
        return toDoLists;
    }
}
