/**
 * searching
 * <p>
 */
package searching;


public class BinarySearch extends Search {

    @Override
    int doSearch(int[] inputArr, int searchElement) {
        int returnValue = -1;
        int highIndex = inputArr.length;
        int lowIndex = 0;
        int middleIndex = 0;
        while(highIndex >= lowIndex){
            middleIndex = (highIndex + lowIndex) /2;
            if(searchElement == inputArr[middleIndex]){
                returnValue = middleIndex;
                break;
            } else if(searchElement > inputArr[middleIndex]){
                lowIndex = middleIndex;
            } else if(searchElement < inputArr[middleIndex]){
                highIndex = middleIndex;
            }
        }
        return returnValue;
    }
}
