/**
 * 
 */
package edu.cnm.deepdive.generics;

/**
 * @author David Martinez
 * TODO Complete javadoc comments.
 */
public interface ShufflerSorter<T extends Comparable<T>> extends Iterable<T> {

	
	/**
	 * 
	 */
	void shuffle();
	
	/**
	 * 
	 */
	void sort();
	
	
	
	
}
