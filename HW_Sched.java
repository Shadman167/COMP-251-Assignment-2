import java.util.*;

public class HW_Sched {
	ArrayList<Assignment> Assignments = new ArrayList<Assignment>();
	int m;
	int lastDeadline = 0;
	
	protected HW_Sched(int[] weights, int[] deadlines, int size) {
		for (int i=0; i<size; i++) {
			Assignment homework = new Assignment(i, weights[i], deadlines[i]);
			this.Assignments.add(homework);
			if (homework.deadline > lastDeadline) {
				lastDeadline = homework.deadline;
			}
		}
		m =size;
	}
	
	
	/**
	 * 
	 * @return Array where output[i] corresponds to the assignment 
	 * that will be done at time i.
	 */
	public int[] SelectAssignments() {
		//TODO Implement this



		
		//Sort assignments
		//Order will depend on how compare function is implemented
		Collections.sort(Assignments, new Assignment());


		
		// If homeworkPlan[i] has a value -1, it indicates that the 
		// i'th timeslot in the homeworkPlan is empty
		//homeworkPlan contains the homework schedule between now and the last deadline
		int[] homeworkPlan = new int[lastDeadline];
		for (int i=0; i < homeworkPlan.length; ++i) {
			homeworkPlan[i] = -1;
		}


		for (int a = 0; a < Assignments.size(); a++) {

			for (int b = Math.min(Assignments.size(), Assignments.get(a).deadline)-1; b >= 0; b--){

				if (homeworkPlan[b] == -1){

					homeworkPlan[b] = Assignments.get(a).number;
					break;
				}


			}
		}

	
		
		return homeworkPlan;
	}

	/*
	public static void main(String[] args){

		int[] weights = new int[] {23, 60, 14, 25, 7};
		int[] deadlines = new int[] {3, 1, 2, 1, 3};

		HW_Sched a = new HW_Sched(weights, deadlines, 5);

		a.SelectAssignments();



	}

	 */
}
	



