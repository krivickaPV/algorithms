package by.bsu;

public class TimSort {
    private static  int RUN = 32;

    private static void insertionSort(int[] arr, int left, int right)
    {
        for (int i = left + 1; i <= right; i++)
        {
            int temp = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > temp)
            {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }

     public void merge(int[] arr, int l, int m, int r)
    {
        int[] left = new int[m - l + 1];
        int[] right = new int[r - m];
        for (int i = 0; i < left.length; i++){
            left[i] = arr[l + i];
        }
        for (int i = 0; i < right.length; i++){
            right[i] = arr[m + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < left.length && j < right.length)
        {
            if (left[i] <= right[j])
            {
                arr[k] = left[i];
                i++;
            }
            else
            {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length)
        {
            arr[k] = left[i];
            k++;
            i++;
        }

        while (j < right.length)
        {
            arr[k] = right[j];
            k++;
            j++;
        }
    }

    public  void timSort(int[] arr, int n)
    {
        for (int i = 0; i < n; i+=RUN)
            insertionSort(arr, i, Math.min((i+31), (n-1)));
        for (int size = RUN; size < n; size = 2*size)
        {
            for (int left = 0; left < n; left += 2*size)
            {
                int mid = left + size - 1;
                int right = Math.min((left + 2*size - 1), (n-1));
                 merge(arr, left, mid, right);
            }
        }
    }
}
