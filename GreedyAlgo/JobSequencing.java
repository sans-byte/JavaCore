package GreedyAlgo;

import java.util.Arrays;
import java.util.Comparator;

// https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1

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
        int maxDeadLine = 0;
        for (int i = 0; i < arr.length; i++) {
            maxDeadLine = Math.max(maxDeadLine, arr[i].deadline);
        }
        Arrays.sort(arr, new Comparator<Job>() {
            public int compare(Job a, Job b) {
                return Integer.compare(b.profit, a.profit);
            }
        });
        int[] deadlineArr = new int[maxDeadLine + 1];
        int totalProfit = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i].deadline;
            while (x > 0) {
                if (deadlineArr[x] == 0) {
                    deadlineArr[x] = 1;
                    totalProfit += arr[i].profit;
                    count++;
                    break;
                } else {
                    x--;
                }
            }
        }
        return new int[] { count, totalProfit };
    }
}
