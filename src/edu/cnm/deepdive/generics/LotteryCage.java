/**
 * 
 */
package edu.cnm.deepdive.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author crazy
 *
 */
public class LotteryCage<T extends Comparable<T>> implements ShufflerSorter<T> {

	private ArrayList<T> store;
	
	public LotteryCage(Collection<T> coll) {
		store= new ArrayList<>(coll);
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return store.iterator();
	}

	@Override
	public void shuffle() {
		// TODO Auto-generated method stub
		Collections.shuffle(store);
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		Collections.sort(store);
		mergeSort (0, store.size());
	}
	
	private void mergeSort(int start, int finish) {
		if (finish <= start + 1) {
			return;
		}
		int midpoint = (start + finish) / 2;
		mergeSort(start, midpoint);
		mergeSort(midpoint, finish);
		ArrayList<T> WorkArea = new ArrayList<>(finish - start);
		int position1 = start;
		int position2 = midpoint;
		while (position1 < midpoint && position2 < finish) {
			T item1 = store.get(position1);
			T item2 = store.get(position2);
			if (item1.compareTo(item2) <= 0) {
				WorkArea.add(item1);
				position1++;
			
			} else {
				WorkArea.add(item2);
				position2++;
				
			}
		}
		if (position1 == midpoint) {
			while (position2 < finish) {
				WorkArea.add(store.get(position2++));
			}
		} else {
			while (position1 < midpoint) {
				WorkArea.add(store.get(position1++));
			}
		}
		for (int position = 0; position < WorkArea.size(); position++) {
			store.set(start + position, WorkArea.get(position));
		}
		
	}

}
