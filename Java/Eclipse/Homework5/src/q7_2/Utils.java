package q7_2;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Class Utils and sorts Pairs
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 4/7/2018
 */
public class Utils {
	/**
	*  get a new instance of a sorted pair
	*  @precondition an instanced of Pair is given
	*  @return a sorted Pair
	*/
	public static <K extends Comparable<K>,V> Collection<Pair<K,V>> sortPairCollection(Collection <Pair<K,V>> col) {
		ArrayList<Pair<K,V>> sort = new ArrayList<Pair<K,V>>();
		col.forEach(x -> sort.add((Pair<K, V>) x.clone()));
		for (int i = 0; i < sort.size(); i++) {
			for (int k = i; k < sort.size(); k++) {
				if (sort.get(i).k().compareTo(sort.get(k).k()) > 0) {
					Pair<K,V> temp = sort.get(i);
					sort.set(i, sort.get(k));
					sort.set(k, temp);
				}
			}
		}
		return sort;
	}
	
	/**
	*  Main Function
	*  @precondition none
	*  @postcondition Program has started
	*/
	public static void main(String[] args) {
		Pair<String,Integer> p1 = new Pair<>("three", 3);
		Pair<String,Integer> p2 = new Pair<>("four", 4);
		Pair<String,Integer> p3 = new Pair<>("one", 1);
		Pair<String,Integer> p4 = new Pair<>("two", 2);
		ArrayList lst = new ArrayList();
		lst.add(p1);
		lst.add(p2);
		lst.add(p3);
		lst.add(p4);
		System.out.println("List contains:");
		lst.forEach(x -> System.out.println(x.toString()));
		ArrayList lst2 =  (ArrayList) sortPairCollection(lst);
		System.out.println("Sorted List contains:");
		lst2.forEach(x -> System.out.println(x.toString()));
	}
}