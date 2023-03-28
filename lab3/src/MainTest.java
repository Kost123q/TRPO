import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class MainTest {
    double[] array = {-8.12, 4, 15, -70.3, 90, 40.1, 5.09, 4.01};

    @Test
    public void testFindMinElem() {
        double expected = -70.3;
        double result = lab.Main.findMinElem(array);

        Assertions Assert;
        Assert = null;
        Assert.assertEquals(result, expected, 0.001);
    }

    @Test
    public void testFindMaxElem() {
        double expected = 90;
        double result = lab.Main.findMaxElem(array);
        Assertions Assert;
        Assert = null;
        Assert.assertEquals(result, expected, 0.001);
    }

    @Test
    public void testIntersionSort() {
        double[] expected = {-70.3, -8.12, 4, 4.01, 5.09, 15, 40.1, 90};
        double[] result = lab.Main.insertionSort(array);
        Assertions Assert;
        Assert = null;
        for (int i = 0; i < array.length; i++)
        {
            Assert.assertEquals(result[i], expected[i], 0.001);
        }
    }

    @Test
    public void testBucketSort() {
        double[] expected = {-70.3, -8.12, 4, 4.01, 5.09, 15, 40.1, 90};
        double[] result = lab.Main.bucketSort(array, 5);
        Assertions Assert;
        Assert = null;
        for (int i = 0; i < array.length; i++)
        {
            Assert.assertEquals(result[i], expected[i], 0.001);
        }
    }
}