package GreedyAlgo;

import java.util.Arrays;

class Job {
    int id;
    int deadline;
    int profit;

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {

    public static void main(String[] args) {
        int[][] jobs = { { 1, 4, 20 }, { 2, 1, 10 }, { 3, 1, 40 }, { 4, 1, 30 } };

        Job[] jobsObjArr = new Job[jobs.length];
        for (int i = 0; i < jobs.length; i++) {
            Job obj = new Job(jobs[i][0], jobs[i][1], jobs[i][2]);
            jobsObjArr[i] = obj;
        }

        int[] res = JobScheduling(jobsObjArr, 0);
        System.out.println(Arrays.toString(res));

    }

    static int[] JobScheduling(Job arr[], int n) {
        
        return null;
    }

}
