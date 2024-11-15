import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1() {
        int[] arr = {1,2,3};
        int expected  = 0;
        int actual = new Solution().findLengthOfShortestSubarray(arr);

        Assert.assertEquals(expected, actual);
    }
}
