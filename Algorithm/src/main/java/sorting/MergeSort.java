/**
 * Class for InsertionSort implementation
 *
 * @author WissenSolutions.
 */
package sorting;


/**
 * Class for MergeSort implementation
 *
 */
public class MergeSort extends Sort {

	@Override
	int[] doSort(int[] inputArr) {
		return performDivideAndMerge(inputArr,0,inputArr.length-1);
	}

	private int[] performDivideAndMerge(int[] values, int lowestPosition, int highestPosition){
		if (lowestPosition < highestPosition) {
			int middlePosition = (lowestPosition + highestPosition) / 2;
			performDivideAndMerge(values, lowestPosition, middlePosition);
			performDivideAndMerge(values, middlePosition + 1, highestPosition);
			//After division, merge them back
			return merge(values, lowestPosition, middlePosition, highestPosition);
		}
		return values;
	}

	private int[] merge(int[] values, int lowestPosition, int middlePosition, int higestPosition){
		//create a temp array from actual array
		int leftArrayLength = middlePosition-lowestPosition+1; // 0 to middle
		int rightArrayLength = higestPosition-middlePosition; // middle to arraySize
		int[] leftArray = new int[leftArrayLength];
		int[] rightArray = new int[rightArrayLength];

		//Copy Data into temp arrays
		for(int i=0;i<leftArrayLength;i++){
			leftArray[i] = values[lowestPosition+i];
		}
		for(int j=0;j<rightArrayLength;j++){
			rightArray[j] = values[middlePosition+1+j];
		}

		int i = 0; // initial index of left array
		int j = 0; // initial index of right array
		int k = lowestPosition; // initial index of merged array
		while (i < leftArrayLength && j < rightArrayLength){
			if(leftArray[i] > rightArray[j]){
				values[k] = rightArray[j];
				j++;
			} else {
				values[k] = leftArray[i];
				i++;
			}
			k++;
		}

		// Copy Remaining elements of left array
		while(i<leftArrayLength){
			values[k] = leftArray[i];
			i++;
			k++;
		}

		// Copy Remaining elements of right array
		while(j<rightArrayLength){
			values[k]=rightArray[j];
			k++;
			j++;
		}
		return values;
	}
}
