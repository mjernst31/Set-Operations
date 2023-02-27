/**
 * @author Matt Ernst
 * @version 1.0
 */
import java.util.*;
public class SetOperations
{
	/**
	 * Finds and returns the intersection of both sent arrays
	 * @param first The first array to be compared
	 * @param second The second array to be compared
	 * @return Returns the intersection of first array and second array, as an array.
	 */
	public static ArrayList intersection(ArrayList first, ArrayList second) {
		ArrayList<Object> intersected = new ArrayList<>();

		removeDupes(first);
		removeDupes(second);

		System.out.println(first);
		System.out.println(second);

		for(int i = 0; i < first.size(); i++) {
			for (int j = 0; j < second.size(); j++){
				if(first.get(i).equals(second.get(j))){
					intersected.add(first.get(i));
				}
			}
		}

		return intersected;
	}

	/**
	 * Finds and returns the compliment of both sent arrays. Elements that live within the first (greater array) that dont exist within the second array
	 * @param first The greater array
	 * @param second The sub array
	 * @return Returns an array that consists of the elements within the first array, that are not within the second array.
	 */
	public static ArrayList compliment(ArrayList first, ArrayList second) {
		ArrayList<Object> complimented = new ArrayList<>();

		removeDupes(first);
		removeDupes(second);

		boolean doExist;

		for(int i = 0; i < first.size(); i++) {
			doExist = false;

			for(int j = 0; j < second.size(); j++) {
				if(first.get(i).equals(second.get(j))) {
					doExist = true;
				}
			}

			if(!doExist){
				complimented.add(first.get(i));
			}
		}

		return complimented;
	}

	/**
	 * Finds and returns the union of both sent arrays. Elements that live within the first AND second array.
	 * @param first The first array
	 * @param second The second array
	 * @return Returns an array that consists of the elements within the first and second array.
	 */
	public static ArrayList union(ArrayList first, ArrayList second) {
		ArrayList<Object> unioned = new ArrayList<Object>();

		removeDupes(first);
		removeDupes(second);

		boolean doExist;

		for(int i = 0; i < first.size(); i++) {
			doExist = false;

			for(int j = 0; j < second.size(); j++) {
				if(first.get(i).equals(second.get(j))) {
					doExist = true;
				}
			}

			if(doExist){
				unioned.add(first.get(i));
			}
		}


		return unioned;
	}

	/**
	 * This method is homemade, it is made to remove duplicates and sort the array for easier arithmetic in the classes other methods.
	 * @param toUndupe The given array that needs to be unduped
	 * @return Returns unduped, but sorted and simplified (removed duplicates)
	 */
	public static ArrayList removeDupes(ArrayList toUndupe) {
		Set<Integer> set = new LinkedHashSet<>();
		set.addAll(toUndupe);
		toUndupe.clear();
		toUndupe.addAll(set);
		Collections.sort(toUndupe);
		return toUndupe;
	}
}