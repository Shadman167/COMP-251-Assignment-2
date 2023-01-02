import java.lang.reflect.Array;
import java.util.*;

public class A2_Q2 {

	public static int weight(int[] plates) {

		ArrayList<Integer> newArray = new ArrayList<>();

		//int[] newArray;



		//newArray.add(plates[0]);
		//newArray[1] = plates[1];
		for (int i = 0; i < plates.length; i++){
				newArray.add(plates[i]);
				int getIndex = newArray.lastIndexOf(plates[i]);


			for (int j = i+1; j < plates.length; j++){




					if (j - 1 == i) {

						int getNum = newArray.get(getIndex);

						newArray.add(getNum + plates[j]);


						//getIndex++;
					} else if (i == 0) {

						//getIndex = 1;
						getIndex = 1;
						newArray.add(newArray.get(j - getIndex) + plates[j]);


					} else {

						if (j - 2 == i) {

							getIndex += 2;
							newArray.add(newArray.get(getIndex - 1) + plates[j]);

						} else {
							getIndex++;
							newArray.add(newArray.get(getIndex - 1) + plates[j]);

							//getIndex++;
						}


					}






				//[900, 500, 498, 4] 900 + 500, 900 + 500 + 498



			}


		}




		if(newArray.contains(1000)){

			return 1000;
		}

		ArrayList<Integer> getMinDifference = new ArrayList<>();

		int minDifference = 0;

		for (int i = 0; i < newArray.size(); i++){

			if (i == 0){

				minDifference = Math.abs(newArray.get(0)-1000);
				//getNum = newArray.get(i);
				getMinDifference.add(newArray.get(i));
			}

			else{

				if (newArray.get(i) > 1000){

					if(minDifference >= Math.abs(newArray.get(i)-1000)){

						minDifference = Math.abs(newArray.get(i)-1000);
						//getNum = newArray.get(i);

						if(!getMinDifference.isEmpty()){

							getMinDifference.clear();

							getMinDifference.add(newArray.get(i));

						}

					}

				}

				else {

					if(minDifference >= Math.abs(newArray.get(i)-1000)){

						minDifference = Math.abs(newArray.get(i)-1000);
						//getNum = newArray.get(i);

						if(!getMinDifference.isEmpty()){

							getMinDifference.clear();

							getMinDifference.add(newArray.get(i));

						}
					}

				}

			}

		}
		if (getMinDifference.size() == 1){

			return getMinDifference.get(0);
		}

		//int getNum = 0;

		Collections.sort(getMinDifference);



		return getMinDifference.get(getMinDifference.size()-1);
	}





	/*
	public static void main(String[] args){

		A2_Q2 c = new A2_Q2();

		int[] weight = {999, 800, 700, 600, 500, 400, 300, 1};

		c.weight(weight);

	}
	
	 */







}
