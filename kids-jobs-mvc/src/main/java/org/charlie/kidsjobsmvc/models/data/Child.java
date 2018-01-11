package org.charlie.kidsjobsmvc.models.data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Child {
    @NotNull
    @Size(min = 3, max = 15)
    private String name;


    private int childId;
    private static int nextId = 1;

    public Child(String name) {
        this();
        this.name = name;

    }

    public Child() {
        childId = nextId;
        nextId++;
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //public String getDescription() {
    //return description;
    //}

    //public void setDescription(String description) {
    //this.description = description;
    //}

    //public CheeseType getType() {
    //return type;
    //}

    //public void setType(CheeseType type) {
    //this.type = type;
    //}


}
