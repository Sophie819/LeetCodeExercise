package name.sophy.common;
/*
 * 20180916：归并算法，计算逆序对
 */
public class MergeSort {
	public void mergeSort(int [] array, int low ,int high) {
		int mid = low + (high - low) / 2;
		if(low < high) {
			mergeSort(array, low, mid);
			mergeSort(array, mid + 1, high);
			merge(array, low, mid, high);
		}
	}
	
	public void merge(int [] array, int low, int mid , int high) {
		int [] temp = new int[array.length];
		int i = low;
		int j = mid + 1;
		int k = low;
		while(i <= mid && j <= high) {
			if(array[i] < array[j])
				temp[k++] = array[i++];
			else
				temp[k++] = array[j++];
		}
		while(i <= mid)
			temp[k++] = array[i++];
		while(j <= high)
			temp[k++] = array[j++];
		for(int ii = low; ii <= high; ii++) {
			array[ii] = temp[ii];
			//System.out.print(array[ii] + " ");
		}
		//System.out.println();
	}
	
	public static void main(String[] args) {
		int [] array = {2,3,41,17,1,2,8, 6, 5, 0};
		MergeSort mergeSort = new MergeSort();
		mergeSort.mergeSort(array, 0, array.length - 1);
		for(int i = 0; i < array.length; i++)
			System.out.println(array[i]);
	}
}
