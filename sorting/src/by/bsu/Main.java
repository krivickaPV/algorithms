package by.bsu;



public class Main {


    public static void main(String[] args) {
        GenerateArrays generateArrays=new GenerateArrays();
        ArraySort arraySort=new ArraySort();
        TimSort timSort=new TimSort();
        MergeSort mer=new MergeSort();
        int[] ar=generateArrays.smallRangeArray();
        generateArrays.print(ar);

        double start = System.nanoTime();

        arraySort.countSort(ar,1000);
        double end = System.nanoTime();

        double elapsedTime = (end - start)/1000000.0;

        System.out.println("\n"+elapsedTime);

        generateArrays.print(ar);

    }

}
