import java.util.*;

public class Practice_Other{
	public static void main(String[] args){

		SortingAlgorithmFactory factory = new SortingAlgorithmFactory();
		SortingAlgorithm bs = factory.getSortingAlgorithm("Bubble");
		int[] arr = {9,8,7,6,5,4,3,2,1};
		System.out.println(Arrays.toString(arr));
		bs.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static class SortingAlgorithmFactory{
		public SortingAlgorithm getSortingAlgorithm(String name){
			switch(name){
				case "Bubble":
					return new BubbleSort();
				case "Quick":
					return new QuickSort();
				default:
					return null;
			}
		}
	}
	public interface SortingAlgorithm{
		void sort(int[] arr);
	}

	public static class QuickSort implements SortingAlgorithm{
		private int input[];
		private int length;
		public void sort(int[] arr){
			input = arr;
			sortRecur(0,arr.length-1);
		}

		private void sortRecur(int low, int high){
			int i = low;
			int j = high;

			int pivot = input[(low+high)/2];

			while(i<=j){
				while(input[i] < pivot){
					i++;
				}
				while(input[j] > pivot){
					j--;
				}
				if(i<=j){
					int temp = input[i];
					input[i] = input[j];
					input[j] = temp;
					i++;
					j--;
				}
			}

			if(i<high){
				sortRecur(i,high);
			}
			if(j>low){
				sortRecur(low,j);
			}

		}
	}

	public static class BubbleSort implements SortingAlgorithm{

		public void sort(int[] arr){
			for(int x = arr.length-1; x >= 0; x--){
				for(int y = 1; y <= x; y++){
					if(arr[y] < arr[y-1]){
						int temp = arr[y];
						arr[y] = arr[y-1];
						arr[y-1] = temp;
					}
				}
			}
		}
	}
}