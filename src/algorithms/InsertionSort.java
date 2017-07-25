package algorithms;

public class InsertionSort<T extends Comparable<T>> extends Sorter<T>{

	public void sort( T[] data ) {
		
		_data = data;
		
		for ( int sorted = 1 ; sorted < _data.length ; sorted++ ) {
			
			store( _data[ sorted ] );
			for ( int pointer = sorted - 1 ; pointer >= 0 ; pointer-- ) { 
				
				// If Pointer value > register value
				if ( getRegister().compareTo( _data[ pointer ] ) < 0 ) {
					
					// Move the item right
					swapValues( pointer, pointer + 1 );
				}
			}
		}
	}
}
