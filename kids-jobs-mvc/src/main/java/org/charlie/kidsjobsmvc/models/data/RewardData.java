package org.charlie.kidsjobsmvc.models.data;

import java.util.ArrayList;


public class RewardData {

    static ArrayList<Reward> rewards = new ArrayList<>();

    // getAll
    public static ArrayList<Reward> getAll() {
        return rewards;
    }

    // add
    public static void add(Reward newReward) {
        rewards.add(newReward);
    }

    // remove
    public static void remove(int id) {
        Reward rewardToRemove = getById(id);
        rewards.remove(rewardToRemove);
    }

    // getById
    public static Reward getById(int id) {

        Reward theReward = null;

        for (Reward candidateReward : rewards) {
            if (candidateReward.getRewardId() == id) {
                theReward = candidateReward;
            }
        }

        return theReward;
    }
}