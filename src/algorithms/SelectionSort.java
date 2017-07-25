package algorithms;

public class SelectionSort<T extends Comparable<T>> extends Sorter<T> {
	
	public void sort( T[] data ) {
		
		this._data = data;
		
		for ( int progress = 0 ; progress < this._data.length ; progress++) {
			
			for ( int pointer = progress + 1 ; pointer < this._data.length ; pointer++ ) {

				if ( this._data[progress].compareTo( this._data[pointer] ) > 0 ) {
					
					swapValues( progress, pointer );
				}
			}
		}
	}
}
