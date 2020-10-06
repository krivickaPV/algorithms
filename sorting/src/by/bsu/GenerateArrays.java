package by.bsu;

import java.util.Arrays;
import java.util.Random;

public class GenerateArrays {
    private Random r = new Random();
    public int[] averageArray(){
        int[] numbers = new int[(int) Math.pow(2, 8)];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = r.nextInt(1000);
        }
        return numbers;
    }
    public int[] bigArray(){
    int[] moreNumbers = new int[(int) Math.pow(2, 17)];
        for (int i = 0; i < moreNumbers.length; i++) {
        moreNumbers[i] = r.nextInt(1000);
    }
    return moreNumbers;
    }
    public int[] almostSortedArray(){
        int[] approximatelySorted = new int[(int) Math.pow(2, 8)];
        for (int i = 0; i < approximatelySorted.length; i++) {
            approximatelySorted[i] = r.nextInt(1000);
        }
        Arrays.sort(approximatelySorted);
        for (int i = 3; i < 20; i++) {
            int tmp = approximatelySorted[i];
            approximatelySorted[i] = approximatelySorted[i -2];
            approximatelySorted[i-2] = tmp;
        }
        return approximatelySorted;
    }

    public int[] smallRangeArray(){
        int[] smallRange = new int[(int) Math.pow(2, 17)];
        for (int i = 0; i < smallRange.length; i++) {
            smallRange[i] = r.nextInt(100);
        }
        return smallRange;
    }

    public void print(int[] arr){
        for (int i=0;i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
