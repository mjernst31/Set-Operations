import java.util.*;

/**
 * @author Matthew Ernst
 *
 */
public class SetOperations
{
	
	public static void main(String[] args)
	{
		ArrayList<Integer> firstList = new ArrayList<Integer>();
		firstList.add(1); 		
		firstList.add(2); 		
		firstList.add(3);
		firstList.add(4);
		firstList.add(5);
		
		ArrayList<Integer> secondList = new ArrayList<Integer>();
		secondList.add(2);
		secondList.add(3);
		secondList.add(4);
		secondList.add(5);
		secondList.add(6);

		System.out.print(SetOperations.complement(firstList, secondList));

		
		//WORKS
		//System.out.print(SetOperations.intersect(firstList, secondList));
		
		//KIND WORKS BUT DOESNT WHEN FIRST LSIT LONGER THAN SECOND
		//System.out.println(SetOperations.union(firstList, secondList));

	}
	
	//Compares ArrayList first and second, and returns an array list with distinct elements from both
	//AuB
	static ArrayList union(ArrayList first, ArrayList second)
	{
		ArrayList<Integer> unionized = new ArrayList<Integer>();
		ArrayList<Integer> markForDeath = new ArrayList<Integer>();
		
		//I can make an array, add all elements of first and second, and remove all the repeats. as it shouldd be equivelant to unionizing two arrays
		//First lets go through adding the first array.
		for(int i = 0; i < first.size(); i++)
			unionized.add((Integer) first.get(i));
		//Add the second array.
		for(int j = 0; j < second.size(); j++)
			unionized.add((Integer) second.get(j));
		
		//Parse through unionized, compare indexed element to the rest of the array. 
		for(int i = 0; i < first.size(); i++)
		{
			for(int j = 0; j < unionized.size(); j++)
			{
				if(i == j){}	
				else
				{
					//This is what I call 'mark for death'. I coudlnt figure out another way to remove elements from the array
					//so Ima build an array that holds the index of elements that need to be removed. The Mark for Death.
					if(unionized.get(i) == unionized.get(j))
					{
						markForDeath.add(j);
					}
				}
			}
		}
		


		//The actual markForDeath
		for(int i = markForDeath.size() - 1; i>=0; i-- )
			unionized.remove(markForDeath.get(i) -1);
		
		return unionized;
	}
	
	//Compares ArrayList first and second, and returns an array list within both ArrayLists
	static ArrayList intersect(ArrayList first, ArrayList second)
	{
		//Holds the elements that are both present in the first and second array
		ArrayList<Integer> intersected = new ArrayList<Integer>();
		
		//compares each element in the second array, to each element in first array.
		for(int i = 0; i < second.size(); i++)
		{
			for(int j = 0; j < first.size(); j++)
			{
				//if element is present in both, add it to array intersected (has to be cast to an integer.)
				if(first.get(j).equals(second.get(i)))
				{
					intersected.add((Integer) first.get(j));				}
			}
		}
		
		return intersected;
	}
	
	//Recieves a greater set, and a subset of said greater set. Returns elements that are not within the sub set but are within the greater set.
	static ArrayList complement(ArrayList sub, ArrayList greater)
	{
		ArrayList<Integer> complemented = new ArrayList<Integer>();

		//can make an array, complemented, and add sub and greater elements into one array, and if both elements are overlapping, remove both entries
		for(int i = 0; i < sub.size() - 1; i++)
		{
			complemented.add((Integer) sub.get(i));
		}
		
		for(int i = 0; i < greater.size() - 1; i++)
		{
			complemented.add((Integer) greater.get(i));
		}
		
		for(int i = 0; i < complemented.size() - 1; i++)
			for(int j = 0; j < complemented.size() - 1; j++)
				{
					if(complemented.get(j) == complemented.get(i))
					{
						complemented.remove(i);
						complemented.remove(j);
					}
				}
	
		return complemented;
	}
}

