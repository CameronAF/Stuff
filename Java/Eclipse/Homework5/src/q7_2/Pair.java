package q7_2;

import java.io.Serializable;

/**
 * Class Pair and implements Cloneable and Serializable
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 4/7/2018
 */
public class Pair <K,V> implements Cloneable, Serializable{
	private K key;
	private V value;
	
	/**
    * Constructs
    * @return an instance of Pair
    */
	public Pair(K k, V v) {
		this.key = k;
		this.value = v;
	}
	
	/**
	*  Get Key
	*  @precondition Instance of Pair initialized 
	*  @return key
	*/
	public K k() {
		return this.key;
	}
	
	/**
	*  Get Value
	*  @precondition Instance of Pair initialized 
	*  @return value
	*/
	public V v() {
		return this.value;
	}

	/**
	*  compared the content of two Pairs and returns true if equal
	*  @precondition an instanced of Pair is given
	*  @return boolean
	*/
	@Override
	public boolean equals(Object obj) {
		K k = (K) ((Pair<K, V>) obj).k();
		V v = (V) ((Pair<K, V>) obj).v();
		if (k.equals(key) && v.equals(value))
		{
			return true;
		}
		return false;
	}
	
	/**
	*  Sums hashcode of content
	*  @precondition an instanced of Pair exist
	*  @return has integer
	*/
	@Override
	public int hashCode() {
		return key.hashCode() + 2*value.hashCode();
	}
	
	/**
	*  Get a String representation of Object Pair
	*  @precondition none
	*  @postcondition a string of class and content
	*/
	@Override
	public String toString() {
		return getClass().getName()
			+ "[key=" + key.toString()
			+ ",value=" + value.toString()
			+ "]";
	}
	
	/**
	*  Clones Pair
	*  @precondition none
	*  @postcondition a new instance of Pair
	*/
	@Override
	public Object clone() {
		return new Pair<K,V>(this.key,this.value);
	}
}