package ru.mai.dep806.mvcapp.dao;

import ru.mai.dep806.mvcapp.model.ToDoList;

import java.util.ArrayList;

/**
 * Created by 111 on 29.03.2015.
 */
public class MockToDoListDao {
    ArrayList<String> title = new ArrayList<String>();
    ArrayList<ArrayList<String>> toDoLists = new ArrayList<ArrayList<String>>();

    public MockToDoListDao() {
        title.add("Title 1");
        toDoLists.add(new ToDoList("some item 1","some item 2","some item 3").getList());
        title.add("Title 2");
        toDoLists.add(new ToDoList("some item 4","some item 5","some item 6","some item 7").getList());
    }

    public  ArrayList<ArrayList<String>> getToDoLists() {
        return toDoLists;
    }

    public ArrayList<String> getTitles() {
        return title;
    }

    public void createList(String title){
        this.title.add(title);
        toDoLists.add(new ToDoList().getList());
    }

    public void addItem(int id, String str){
        toDoLists.get(id).add(str);
    }

    public void deleteItem(int idList,int idItem){
        toDoLists.get(idList).remove(idItem);
    }

    public void changeItem(int idList,int idItem,String str){
        toDoLists.get(idList).remove(idItem);
        toDoLists.get(idList).add(idItem,str);
    }
    public void deleteList(int idList){
        toDoLists.remove(idList);
        title.remove(idList);
    }
}
