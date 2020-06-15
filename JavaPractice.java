import java.util.*;

public class JavaPractice{
	public static void main(String[] args){
		int[] cards = new int[52];
		for(int x = 0; x < cards.length; x++){
			cards[x] = x;
		}

		cards = ShuffleArray(cards);
		for(int x = 0; x < cards.length; x++){
			System.out.print(cards[x] + " ");
		}
		System.out.println();
	}

	public static int[] ShuffleArray(int arr[]){

		for(int x = 0; x < arr.length; x++){
			int random = (int) (Math.random()*(arr.length-x));
			int temp = arr[x];
			arr[x] = arr[x+random];
			arr[x+random] = temp;
		}

		return arr;
	}

}