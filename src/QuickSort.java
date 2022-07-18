import java.util.Random;

public class QuickSort {

    static int LEN = 1000;

    public static void main(String[] args) {

        Random rand = new Random();
        int[] numbers = new int[LEN];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(LEN);
        }
        System.out.println("Before sorting:");
        printArray(numbers);

        quickSort(numbers);

        System.out.println("\nAfter sorting:");
        printArray(numbers);

    }

    private static void quickSort(int[] array) {
        quickSort(array,0,array.length-1);
    }

    private static void quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = new Random().nextInt(endIndex - startIndex) + startIndex;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, endIndex);
        int leftPointer = partition(array, startIndex, endIndex, pivot);
        quickSort(array,startIndex,leftPointer-1);
        quickSort(array,leftPointer+1,endIndex);

    }

    private static int partition(int[] array, int startIndex, int endIndex, int pivot) {
        int leftPointer = startIndex;
        int rightPointer = endIndex;
        while (leftPointer < rightPointer) {
            while (array[leftPointer]<= pivot && leftPointer<rightPointer) {
                leftPointer++;
            }
            while (array[rightPointer]>= pivot && leftPointer<rightPointer) {
                rightPointer--;
            }
            swap(array,leftPointer,rightPointer);
        }
        if(array[leftPointer] > array[endIndex]) {
            swap(array, leftPointer, endIndex);
        }
        else {
            leftPointer = endIndex;
        }
        return leftPointer;
    }

    private static void swap(int[] array, int leftPointer, int rightPointer) {
        int temp = array[leftPointer];
        array[leftPointer] = array[rightPointer];
        array[rightPointer] = temp;
    }


    private static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            System.out.print(" ");
        }
    }

}
