package algorithms;

import java.util.Arrays;

public abstract class Sorter<T extends Comparable<T>>{

	protected T[] _data;
	private boolean _debug;	
	private T _swapItem = null;
	
	public abstract void sort( T[] data );
	
	public T swap( T item ) {
		
		T tmp = _swapItem;
		_swapItem = item;
		
		return tmp;
	}
	
	public void store( T item ) {
		
		_swapItem = item;
	}

	public T getRegister() {
		
		return _swapItem;
	}

	protected void swapValues( int leftIndex, int rightIndex ) {
		
		if( this._debug ) { 
			
			String leftOutput = (  _data[leftIndex] != null ) ? _data[leftIndex].toString() : "-";
			String rightOutput = ( _data[rightIndex] != null ) ? _data[rightIndex].toString() : "-";
			System.out.print( "Swapping: [" + leftIndex + "][" + rightIndex + "] "  );
			System.out.print( leftOutput + " | " + rightOutput );
			System.out.println();
		}

		T swap;
		swap = this._data[leftIndex];
		this._data[leftIndex] = this._data[rightIndex];
		this._data[rightIndex] = swap;
	}
	
	public void debug() {
		
		this.debug( true );
	}
	
	public void debug( boolean debug ) {
		
		this._debug = debug;
	}
	
	public T find( T item ) {
		
		return searchItem( item );
	}
	
	private T searchItem( T item ) {
		
		T[] tmpArray = _data.clone();
		return searchItem( item, tmpArray );
	}
	
	private T searchItem( T item, T[] tmp ) {
		
		int pointer = (int) Math.floor( tmp.length / 2 );

		if ( tmp[ pointer ].compareTo( item ) == 0 ) { return tmp[ pointer ]; }
		if ( tmp.length <= 1 ) { return null; }

		if ( tmp[ pointer ].compareTo( item ) < 0 ) { 

			tmp = Arrays.copyOfRange( tmp, pointer, tmp.length ) ;
			return searchItem( item, tmp );
		} else {
			
			tmp = Arrays.copyOfRange( tmp,  0,  pointer );
			return searchItem( item, tmp );
		}
	}
}
