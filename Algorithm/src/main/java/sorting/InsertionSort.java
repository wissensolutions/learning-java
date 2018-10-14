/**
 * Class for InsertionSort implementation
 *
 * @author WissenSolutions.
 */
package sorting;




public class InsertionSort extends Sort {

    @Override
    public int[] doSort(int[] inputArr) {
        for(int i=0;i<inputArr.length;i++){
            //Picks one element for every iteration and compares with only left side of elements
            for(int j = i; j>0; j--){
                if(inputArr[j] < inputArr[j-1]){
                    //Swap elements
                    int temp = inputArr[j];
                    inputArr[j] = inputArr[j-1];
                    inputArr[j-1] = temp;
                } else {
                    //Continue
                }
            }
        }
        return inputArr;
    }


}
