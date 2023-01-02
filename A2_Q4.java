import java.math.BigInteger;
import java.util.ArrayList;
//import java.util.Scanner;

public class A2_Q4 {

	public static String mod_fibonacci(int N, BigInteger K) {

		ArrayList<Integer> f = new ArrayList<>(); // 1 extra to handle case, n = 0
		int i;

		String s1 = String.valueOf(N);
		BigInteger smallK = new BigInteger(s1);
		int intValueOfK = K.intValue();
		//BigInteger smallK2 = K.subtract(smallK);


		for(int b = 0; b < N+1; b++){

			f.add(0);
		}






		/* 0th and 1st number of the series are 0 and 1*/

		if (f.size() > 3) {
			f.set(1, 1);
			f.set(2, 1);
		}

		else {

			if (N == 3 && intValueOfK == 1 || intValueOfK == 3){

				return "Y";
			}
			else if (N == 3 && intValueOfK == 2){

				return "X";
			}

			
		}

		for (i = 3; i <= N; i++)
		{
       /* Add the previous 2 numbers in the series
         and store it */
			//f[i] = f[i-2] + f[i-1];
			f.set(i, f.get(i-2)+f.get(i-1));

		}
		/*
		BigInteger getInteger = BigInteger.valueOf(f.get(N));

		if (K.compareTo(getInteger) > 0){

			return "";
		}

		 */

		for(int a = 4; a < f.size(); a++){

			if(intValueOfK == f.get(a)){

				return "Y";
			}
		}




		//int fibNum = f.get(N);


		//String getString = fibHelper(f, K, N);



		return fibHelper(f, K, N);
	}

	public static String fibHelper(ArrayList<Integer> f, BigInteger K, int N) {



		if(N == 1){

			return "X";
		}

		else if(N == 2){

			return "Y";
		}

		int var1 = f.get(N-1);
		int var2 = f.get(N-2);
		int intValueOfK2 = K.intValue();
		//BigInteger bigInteger2 = BigInteger.valueOf(intValueOfK2);


		if(intValueOfK2 > var2){

			//int var3 = var2;
			int subtractNum = intValueOfK2 - var2;
			BigInteger bigInteger = BigInteger.valueOf(subtractNum);
			N = N -1;
			return fibHelper(f,  bigInteger, N);

		}

		else{

			//int var3 = var1;
			//int subtractNum2 = intValueOfK2 - var1;
			BigInteger bigInteger3 = BigInteger.valueOf(intValueOfK2);
			N = N -2;
			return fibHelper(f, bigInteger3, N);
		}


		//return "";
	}










	public static void main(String[] args) {


		A2_Q4 a = new A2_Q4();

		BigInteger k = new BigInteger("2");

		a.mod_fibonacci(3, k);

	}





}
