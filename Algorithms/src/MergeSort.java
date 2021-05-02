

/* Java program for Merge Sort */
public class MergeSort
{
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int leftIndex, int middleIndex, int rightIndex)
    {
        // Find sizes of two subarrays to be merged
        int leftArraySize = middleIndex - leftIndex + 1;
        int rightArraySize = rightIndex - middleIndex;
 
        /* Create temp arrays */
        int L[] = new int[leftArraySize];
        int R[] = new int[rightArraySize];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < leftArraySize; ++i)
            L[i] = arr[leftIndex + i];
        for (int j = 0; j < rightArraySize; ++j)
            R[j] = arr[middleIndex + 1 + j];
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = leftIndex;
        while (i < leftArraySize && j < rightArraySize) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < leftArraySize) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < rightArraySize) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int left, int right)
    {
        if (left < right) {
            // Find the middle point
            int middle =left+ (right-left)/2;
 
            // Sort first and second halves
            sort(arr, left, middle);
            sort(arr, middle + 1, right);
 
            // Merge the sorted halves
            merge(arr, left, middle, right);
        }
    }
 
    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    // Driver code
    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
 
        System.out.println("Given Array");
        printArray(arr);
 
        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);
 
        System.out.println("\nSorted array");
        printArray(arr);
    }
}
/* This code is contributed by Rajat Mishra */
