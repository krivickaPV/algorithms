import java.util.Arrays;
import java.util.Random;

public class SearchMain {
    static private Random r = new Random();

    private static int[] bigArray(){
        int[] moreNumbers = new int[(int) Math.pow(2, 20)];
        for (int i = 0; i < moreNumbers.length; i++) {
            moreNumbers[i] = r.nextInt(10000);
        }
        return moreNumbers;
    }

    private static int linearSearch(int[] array, int key){
        for (int i=0;i<array.length;i++){
            if (array[i]==key){
                return i;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] array,int key){
        int left=0;
        int right=array.length-1;
        int middle;
        while (left!=right){
            middle= (left+right) /2;
            if(array[middle]<key){
                left=middle+1;
            }
            else if(array[middle]>key){
                right=middle-1;
            }
            else{
                return middle;
            }
        }
        return -1;
    }
    static public int interpolationSearch(int[] array, int key) {
        int middle;
        int left = 0;
        int right = array.length - 1;

        while (array[left] < key && array[right] > key) {
            if (array[right] == array[left])
                break;
            middle = left + ((key - array[left]) * (right - left)) / (array[right] - array[left]);

            if (array[middle] < key)
                left = middle + 1;
            else if (array[middle] > key)
                right = middle - 1;
            else
                return middle;
        }

        if (array[left] == key)
            return left;
        if (array[right] == key)
            return right;

        return -1;
    }
    public static void main(String[] args) {
        int[] bigArray=bigArray();
        int k= r.nextInt(10000);

        double start = System.nanoTime();
        int key = linearSearch(bigArray,k);
        double end = System.nanoTime();
        double elapsedTime = (end - start)/1000000.0;
        System.out.println("\n"+elapsedTime+" linear search");

        Arrays.sort(bigArray);

        start = System.nanoTime();
        int key1 = binarySearch(bigArray,k);
        end = System.nanoTime();
        elapsedTime = (end - start)/1000000.0;
        System.out.println("\n"+elapsedTime+" binary search");

        start = System.nanoTime();
        int key2 = interpolationSearch(bigArray,k);
        end = System.nanoTime();
        elapsedTime = (end - start)/1000000.0;
        System.out.println("\n"+elapsedTime+" interpolation search");

    }
}
