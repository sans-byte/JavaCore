import java.util.*;

public class FindBuildingWhereAliceandBobCanMeet {
    public static void main(String[] args) {
        int heights[] = { 1, 2, 1, 2, 1, 2 }, queries[][] = { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 }, { 0, 4 },
                { 0, 5 },
                { 1, 0 }, { 1, 1 }, { 1, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 }, { 2, 0 }, { 2, 1 }, { 2, 2 }, { 2, 3 },
                { 2, 4 }, { 2, 5 }, { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 3 }, { 3, 4 }, { 3, 5 }, { 4, 0 }, { 4, 1 },
                { 4, 2 }, { 4, 3 }, { 4, 4 }, { 4, 5 }, { 5, 0 }, { 5, 1 }, { 5, 2 }, { 5, 3 }, { 5, 4 }, { 5, 5 } };
        System.out.println(Arrays.toString(leftmostBuildingQueries(heights, queries)));
    }

    public static int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int res[] = new int[queries.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < queries.length; i++) {
            int alice = queries[i][0];
            int bob = queries[i][1];
            if (alice == bob) {
                res[i] = alice;
            } else if (alice > bob) {
                for (int j = alice; j < heights.length; j++) {
                    if (heights[j] >= heights[alice] && heights[j] > heights[bob]) {
                        res[i] = j;
                        break;
                    }
                }
            } else {
                for (int j = bob; j < heights.length; j++) {
                    if (heights[j] > heights[alice] && heights[j] >= heights[bob]) {
                        res[i] = j;
                        break;
                    }
                }
            }

        }
        return res;
    }
}
