/**
 * Class for Bubble Sort
 * <p>
 * @author WissenSolutions.
 */
package sorting;



public class BubbleSort extends Sort{


    @Override
    public int[] doSort(int[] inputArr) {
        for(int i=0;i<inputArr.length;i++){
            for(int j=0;j<inputArr.length-1;j++){
                if(inputArr[j]>inputArr[j+1]){
                    //Swap the elements
                    int temp = inputArr[j];
                    inputArr[j] = inputArr[j+1];
                    inputArr[j+1] = temp;
                } else {
                    //do nothing and proceed for next element
                }
            }
        }
        return inputArr;
    }
}
