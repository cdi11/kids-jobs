package org.charlie.kidsjobsmvc.models.data;

import java.util.ArrayList;

public class ParentData {

    static ArrayList<Parent> parents = new ArrayList<>();

    // getAll
    public static ArrayList<Parent> getAll() {
        return parents;
    }

    // add
    public static void add(Parent newParent) {
        parents.add(newParent);
    }

    // remove
    public static void remove(int id) {
        Parent parentToRemove = getById(id);
        parents.remove(parentToRemove);
    }

    // getById
    public static Parent getById(int id) {

        Parent theParent = null;

        for (Parent candidateParent : parents) {
            if (candidateParent.getParentId() == id) {
                theParent = candidateParent;
            }
        }

        return theParent;
    }
}