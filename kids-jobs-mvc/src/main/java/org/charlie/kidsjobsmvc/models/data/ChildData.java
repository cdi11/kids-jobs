package org.charlie.kidsjobsmvc.models.data;


import java.util.ArrayList;

public class ChildData {

    static ArrayList<Child> children = new ArrayList<>();

    // getAll
    public static ArrayList<Child> getAll() {
        return children;
    }

    // add
    public static void add(Child newChild) { children.add(newChild);
    }

    // remove
    public static void remove(int id) {
        Child childToRemove = getById(id);
        children.remove(childToRemove);
    }

    //getById
    public static Child getById(int id) {

        Child theChild = null;

        for (Child candidateChild : children) {
            if (candidateChild.getChildId() == id) {
                theChild = candidateChild;
            }
        }

        return theChild;
    }
}

