package org.charlie.kidsjobsmvc.models.data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Job {


        @NotNull
        @Size(min = 3, max = 15)
        private String name;



        private int jobId;
        private static int nextId = 1;

        public Job(String name) {
            this();
            this.name = name;

        }

        public Job() {
            jobId = nextId;
            nextId++;
        }

        public int getJobId() {
            return jobId;
        }

        public void setJobId(int jobId) {
            this.jobId = jobId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }




    }
