package org.charlie.kidsjobsmvc.models.data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Parent {

    @NotNull
    @Size(min = 3, max = 15)
    private String name;


    //private ParentType type;

    private int parentId;
    private static int nextId = 1;

    public Parent(String name) {
        this();
        this.name = name;

    }

    public Parent() {
        parentId = nextId;
        nextId++;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
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
