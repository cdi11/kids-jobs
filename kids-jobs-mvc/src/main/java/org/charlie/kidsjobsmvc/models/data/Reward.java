package org.charlie.kidsjobsmvc.models.data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Reward {


    @NotNull
    @Size(min = 3, max = 15)
    private String name;




    private int rewardId;
    private static int nextId = 1;

    public Reward(String name) {
        this();
        this.name = name;

    }

    public Reward() {
        rewardId = nextId;
        nextId++;
    }

    public int getRewardId() {
        return rewardId;
    }

    public void setRewardId(int rewardId) {
        this.rewardId = rewardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





}
