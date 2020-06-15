import java.util.*;

public class Practice_Strings{
	public static void main(String[] args){
		for(String s: args){
			if(IsPalindrome(s)){
				System.out.println(s + " is a palindrome");
			}else{
				System.out.println(s + " is not a palindrome");
			}
		}
	}

	public static boolean IsPalindrome(String s){
		if(s.length() < 2){
			return true;
		}
		if(s.charAt(0)!=s.charAt(s.length()-1)){
			return false;
		}
		return IsPalindrome(s.substring(1,s.length()-1));
	}

	public static boolean StringsAreRotation(String s1, String s2){
		if(s1.length()!=s2.length()){
			return false;
		}else{
			for(int x = 0; x < s2.length(); x++){
				String rotation = s2.substring(x) + s2.substring(0,x);
				if(rotation.equals(s1)){
					return true;
				}
			}
			
			return false;
		}
	}
	public static void PrintAllPermutation(String s){
		PermutationHelper("",s);

	}

	public static void PermutationHelper(String p, String s){
		if(s.isEmpty()){
			System.out.println(p);
		}else{
			for(int x = 0; x < s.length(); x ++){
				PermutationHelper(p+s.charAt(x),s.substring(0,x)+s.substring(x+1));
			}
		}
	}

	public static int CountGivenCharInString(String s, char c){
		int count = 0;
		int index = s.indexOf(c);
		while(index >= 0){
			count++;
			s = s.substring(0,index) + s.substring(index+1);
			index = s.indexOf(c);
		}
		return count;
	}

	public static String ReverseRecursively(String s){
		int length = s.length();
		if(length < 2){
			return s;
		}else{
			return ReverseRecursively(s.substring(1)) + s.charAt(0) ;
		}
	}

	public static String ReverseRecursivelyHelper(String reversed,String original){
		int length = original.length();
		if(length == 0){
			return reversed;
		}else{
			return ReverseRecursivelyHelper(reversed.concat(original.substring(length-1)),original.substring(0,length-1));
		}
	}

	public static void printDuplicateLetters(String s){
		HashSet<Character> hs = new HashSet<Character>();
		for(int x = 0; x < s.length(); x++){
			if(hs.contains(s.charAt(x))){
				System.out.println(s.charAt(x));
			}else{
				hs.add(s.charAt(x));
			}
		}
	}

	public static boolean Anagrams(String s1, String s2){
		if(s1.length()!=s2.length())
			return false;
		char char1;
		int y;
		for(int x = 0; x < s1.length(); x++){
			char1 = s1.charAt(x);
			y = s2.indexOf(char1);
			if(y!=-1)
				s2 = s2.substring(0,y) + s2.substring(y+1);
			else 
				return false;
		}
		
		return s2.isEmpty();
	}

	public static void PrintFirstNonRepeatedChar(String s){
		HashSet<Character> hs = new HashSet<Character>();
		String subs;
		char c;
		for(int x = 0; x < s.length(); x++){
			c = s.charAt(x);
			if(!hs.contains(c)){
				subs = s.substring(x+1);
				if(subs.indexOf(c)==-1){
					System.out.println(c);
					return;
				}
				hs.add(c);
			}
		}
	}
}