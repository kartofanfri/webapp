package ru.mai.dep806.mvcapp.dao;

import ru.mai.dep806.mvcapp.model.ToDoList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 111 on 29.03.2015.
 */
public class MockToDoListDao {
    List<ToDoList> toDoLists = new ArrayList<ToDoList>();

    public MockToDoListDao() {
        toDoLists.add(new ToDoList("some item 1","some item 2","some item 3"));
        toDoLists.add(new ToDoList("some item 4","some item 5","some item 6","some item 7"));
    }

    public List<ToDoList> getToDoLists() {
        return toDoLists;
    }
}
