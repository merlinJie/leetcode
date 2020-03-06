import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] findContinuousSequence(int target) {
        int l = 1;
        int r = 1;
        int sum = 0;
        List<int[]> result = new ArrayList<>();
        while(l <= target / 2) {
            if(sum < target) {
                sum += r;
                r++;
            } else if(sum > target) {
                sum -= l;
                l--;
            } else {
                int[] temp = new int[r - l];
                for(int i = l; l < r; i++) {
                    temp[i - l] = i;
                }
                result.add(temp);
                sum -= l;
                l++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}