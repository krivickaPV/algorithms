package by.bsu;

public class ArraySort {
    public void insertionSort(int[] array){
        int tmp;
        int j;
        for(int i=1;i<array.length;i++){
            j=i;
            while(j>0&&array[j-1]>array[j]) {
                tmp = array[j - 1];
                array[j - 1] = array[j];
                array[j] = tmp;
            j--;
            }
        }
    }

    public static int partition(int array[], int begin, int end) {
    int left = begin;
    int right = end;
    int temp;
    int position = left;
    boolean flag = false;
    while(!flag)
    {
        while((array[position] <= array[right]) && (position!=right)){
            right--;
        }
        if(position==right){
            flag = true;
        }
        else if(array[position]>array[right])
        {
            temp = array[position];
            array[position] = array[right];
            array[right] = temp;
            position = right;
        }
        if(!flag)
        {
            while((array[position] >= array[left]) && (position!=left))
                left++;
            if(position==left)
                flag =true;
            else if(array[position] <array[left])
            {
                temp = array[position];
                array[position] = array[left];
                array[left] = temp;
                position = left;
            }
        }
    }
    return position;
    }

    public void quickSort(int a[], int beg, int end) {
        int position;
        if(beg<end)
        {
            position = partition(a, beg, end);
            quickSort(a, beg, position-1);
            quickSort(a, position+1, end);
        }
    }


    void bubbleSort(int array[]) {
        int size = array.length;
        for (int i = 0; i < size-1; i++){
            for (int j = 0; j < size-i-1; j++){
                if (array[j] > array[j+1])
                {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }


    public void countSort(int[] array, int range){
        int count[] = new int[array.length];
        for (int i = 0; i < range; i++) {
            count[array[i]] = count[array[i]] + 1;
        }

        int b = 0;
        for (int i = 0; i < range; i++){
            for (int j = 0; j < count[i]; j++) {
                array[b] = i;
                b = b + 1;
            }
        }
    }
}