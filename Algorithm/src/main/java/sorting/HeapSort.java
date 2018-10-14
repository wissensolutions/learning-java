package sorting;

/**
 * HeapSort
 * Learning
 *
 * @author WissenSolutions.
 */
public class HeapSort extends Sort {

    @Override
    int[] doSort(int[] inputArr) {
        int size = inputArr.length;
        //First heapify
        for(int i=size/2-1; i>0; i--){
            heapify(inputArr,size,i);
        }

        // One by one extract an element from heap
        for (int i=size-1; i>=0; i--)
        {
            // Move current root to end
            int temp = inputArr[0];
            inputArr[0] = inputArr[i];
            inputArr[i] = temp;

            // call max heapify on the reduced heap
            heapify(inputArr, i, 0);
        }
        return inputArr;
    }


    private void heapify(int[] values, int size, int index){
        int largest = index;
        int i = 2 * index + 1;
        int j = 2 * index + 2;

        // If left child is larger than root
        if(i<size && values[i] > values[largest]){
            largest = i;
        }

        // If right child is larger than root
        if(j<size && values[j] > values[largest]){
            largest = j;
        }

        // If largest is not root
        if(largest != index){
            // Swap
            int temp = inputArr[size];
            inputArr[size] = inputArr[largest];
            inputArr[largest] = temp;

            //Recursively heapify
            heapify(inputArr, size, largest);
        }
    }
}
