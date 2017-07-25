package algorithms;

public class BubbleSort<T extends Comparable<T>> extends Sorter<T> {
	
	public void sort(T[] data) {
		
		this._data = data;
		
		for ( int completionProgress = 0 ;  completionProgress < this._data.length - 1; completionProgress++ ) {
			
			for ( int leftPointer = 0 ; leftPointer < (this._data.length - 1 - completionProgress); leftPointer++ ) {
				
				if ( this._data[leftPointer].compareTo( this._data[leftPointer + 1] ) > 0 ) { 

					swapValues( leftPointer, leftPointer + 1 );
				}
			}
		}
	}
}
