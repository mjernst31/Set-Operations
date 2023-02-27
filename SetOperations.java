/**
 * @author Matt Ernst
 * @version 1.1
 */
import java.util.*;
public class SetOperations
{
	public static void main(String[] args) {
		ArrayList<Integer> firstList = new ArrayList<Integer>();
		ArrayList<Integer> secondList = new ArrayList<Integer>();

		firstList.add(1);
		firstList.add(2);
		firstList.add(3);
		firstList.add(4);
		firstList.add(5);

		secondList.add(6);
		secondList.add(7);
		secondList.add(8);


		System.out.println("Intersection: " + intersection(firstList, secondList));
		System.out.println("Union: " + union(firstList, secondList));
		System.out.println("Compliment: " + compliment(firstList, secondList));
	}

	/**
	 * Finds and returns elements that live within the first and second array. You can accomplish this by adding both arrays to one array. And then returning that without dupes.
	 * @param first The first array to be compared
	 * @param second The second array to be compared
	 * @return Returns the intersection of first array and second array, as an array.
	 */
	public static ArrayList intersection(ArrayList first, ArrayList second) {
		ArrayList<Object> intersected = new ArrayList<>();

		removeDupes(first);
		removeDupes(second);

		for(int i = 0; i < first.size(); i++)
			intersected.add(first.get(i));

		for(int i = 0; i < second.size(); i++)
			intersected.add(second.get(i));

		return removeDupes(intersected);
	}

	/**
	 * Finds and returns the compliment of both sent arrays. Elements that live within the first (greater array) that doesn't exist within the second array
	 * @param first The greater array
	 * @param second The sub array
	 * @return Returns an array that consists of the elements within the first array, that are not within the second array. Returns null if the operation cant be performed
	 */
	public static ArrayList compliment(ArrayList first, ArrayList second) {
		ArrayList<Object> complimented = new ArrayList<>();
		boolean doExist;

		removeDupes(first);
		removeDupes(second);

		if(second.size() > first.size())
			return null;

		for(int i = 0; i < first.size(); i++) {
			doExist = false;

			for(int j = 0; j < second.size(); j++)
				if(first.get(i).equals(second.get(j)))
					doExist = true;

			if(!doExist)
				complimented.add(first.get(i));
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

			for(int j = 0; j < second.size(); j++)
				if(first.get(i).equals(second.get(j)))
					doExist = true;

			if(doExist)
				unioned.add(first.get(i));
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