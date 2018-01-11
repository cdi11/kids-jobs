package org.charlie.kidsjobsmvc.models.data;

import java.util.ArrayList;


public class JobData {

    static ArrayList<Job> jobs = new ArrayList<>();

    // getAll
    public static ArrayList<Job> getAll() {
            return jobs;
        }

    // add
    public static void add(Job newJob) {
            jobs.add(newJob);
        }

    // remove
    public static void remove(int id) {
        Job jobToRemove = getById(id);
        jobs.remove(jobToRemove);
    }

    // getById
    public static Job getById(int id) {

        Job theJob = null;

        for (Job candidateJob : jobs) {
            if (candidateJob.getJobId() == id) {
                theJob = candidateJob;
            }
        }

            return theJob;
    }


}