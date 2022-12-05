import java.util.ArrayList;
import java.util.List;

public class Buildings {
    //  There are n buildings in a line. You are given an integer array heights of size n that represents the heights of the buildings in the line.
// The ocean is to the right of the buildings. A building has an ocean view if the building can see the ocean without obstructions. Formally, a building has an ocean view if all the buildings to its right have a smaller height.
// Return a list of indices (0-indexed) of buildings that have an ocean view, sorted in increasing order.

// Input: heights = [4,2,3,1] Ocean
// Output: [0,2,3]


    //n - heights of buildings
    public static void main(String[] args) {
        int[] heights = {2, 6, 10, 4, 2, 5, 3, 1};
        List <Integer> bld = new ArrayList<>();
        bld.add(heights[heights.length-1]);

        for (int i = heights.length-1; i > 0; i--) {
            if (heights[i] < heights[i - 1]) {
                bld.add(heights[i-1]);
            }
        }
        System.out.println(bld);
    }
}

