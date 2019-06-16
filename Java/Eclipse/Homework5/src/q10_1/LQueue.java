package q10_1;

import java.util.Collection;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Class LQueue implements MyQueue and acts as an adaptor for LinkedList
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 4/7/2018
 */
public class LQueue<E> implements MyQueue<E> {
	LinkedList<E> adaptee = new LinkedList<E>();
	@Override
	public E head() {
		try {
			return adaptee.getFirst();
		}
		catch (NoSuchElementException e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public E dequeue() {
		try {
			return adaptee.removeFirst();
		}
		catch (NoSuchElementException e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public void enqueue(E e) {
		adaptee.addLast(e);
	}

	@Override
	public int size() {
		return adaptee.size();
	}

	@Override
	public boolean isEmpty() {
		return adaptee.isEmpty();
	}

	@Override
	public void addAll(Collection<? extends E> c) {
		c.forEach(x -> adaptee.addLast(x));
	}
}