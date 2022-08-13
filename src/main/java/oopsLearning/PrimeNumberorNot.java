package oopsLearning;

import java.util.ArrayList;

public class PrimeNumberorNot {
	
	public static void main(String[] args) {
		
		int n=10, tempPrime=0, tempNotPrime=0;
		ArrayList<Integer> prime = new ArrayList<Integer>();
		ArrayList<Integer> notprime = new ArrayList<Integer>();
		
		for(int j=2;j<=n;j++) {
			for(int i=2;i<10;i++) {
				if(n%i ==0 & i!=n) {
					//tempPrime = n;
					prime.add(j);
					break;
				} else {
					//tempNotPrime = n;
					notprime.add(j);
					break;
				}
			}
		}
		
		//System.out.println("Number of prime numbers present in the range: "+primeCount);
		System.out.println("Prime numbers present in the range: "+prime);
		//System.out.println("Number of non-prime numbers present in the range: "+notPrimeCount);
		System.out.println("Prime numbers present in the range: "+notprime);
	}

}
