import java.util.*;

public class FindBuildingWhereAliceandBobCanMeet {
    public static void main(String[] args) {
        // int heights[] = { 1, 2, 1, 2, 1, 2 }, queries[][] = { { 0, 0 }, { 0, 1 }, {
        // 0, 2 }, { 0, 3 }, { 0, 4 },
        // { 0, 5 },
        // { 1, 0 }, { 1, 1 }, { 1, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 }, { 2, 0 }, { 2, 1
        // }, { 2, 2 }, { 2, 3 },
        // { 2, 4 }, { 2, 5 }, { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 3 }, { 3, 4 }, { 3, 5
        // }, { 4, 0 }, { 4, 1 },
        // { 4, 2 }, { 4, 3 }, { 4, 4 }, { 4, 5 }, { 5, 0 }, { 5, 1 }, { 5, 2 }, { 5, 3
        // }, { 5, 4 }, { 5, 5 } };

        int heights[] = { 5, 3, 8, 2, 6, 1, 4, 6 }, queries[][] = { { 0, 7 }, { 3, 5 }, { 5, 2 }, { 3, 0 }, { 1, 6 } };
        System.out.println(Arrays.toString(leftmostBuildingQueries(heights, queries)));
    }

    public static int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        
    }
}
