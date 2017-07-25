package pkg4;

import java.lang.reflect.Array;

public class LinkedList<T extends Comparable<T>> {

	protected Node<T> _head;
	
	public Node<T> insertAtHead( T data ) { 
		
		Node<T> newNode = new Node<T>( data );
		newNode.setNext( _head );
		_head = newNode;

		return _head;
	}
	
	public T deleteAtHead() { 
		
		Node<T> popped = _head;
		_head = popped.getNext();
		
		return popped.getData();
	}
	
	public void delete( T data ) { 
		
		Node<T> pointer = _head;
		
		if ( pointer.getData().compareTo( data ) == 0 ) { _head = pointer.getNext(); }
		
		while ( pointer.getNext() != null ) { 
			
			if ( pointer.getNext().getData().compareTo( data ) == 0 ) { 
				
				pointer.setNext( pointer.getNext().getNext() );
				return;
			}
			
			pointer = pointer.getNext();
		}
	}
	
	public String toString() { 
		
		String s = "{";

		Node<T> node = _head;

		while ( node != null ) {
			
			s += "Data: " + node.getData().toString() + ", ";
			node = node.getNext();
		}
		
		s += "}";
		
		return s;
	}
	
	public void sortAndInsert( T data ) { 
		
		sortAndInsert( data, '<' );
	}
	
	public void sortAndInsert( T data, char direction ) {
		
		sort();
		
		Node<T> node = _head;
		
		do { 
			
			if ( direction == '>' ) { 
				if ( node.getNext() != null && data.compareTo( node.getNext().getData() ) < 0 ) {
			
					insertAt( node, new Node<T>( data ));
					return;

				} else { 

					node = node.getNext();
				}
			} else {

				if ( node.getNext() != null && data.compareTo( node.getNext().getData() ) > 0 ) {
			
					node = node.getNext();
				} else { 

					insertAt( node, new Node<T>( data ));
					return;
				}
			}

		} while ( node != null );
		
		return;
	}
	
	protected void insertAt( Node<T> indexedNode, Node<T> newNode ) {
		
		newNode.setNext( indexedNode.getNext() );
		indexedNode.setNext( newNode );
	}
	
	public int length() {
		
		Node<T> node = _head;
		int length = 0;
		
		while ( node != null ) {
			
			length++;
			node = node.getNext();
		}
		
		return length;
	}
	
	public T find( T data ) { 
		
		Node<T> node = _head;
		
		while ( node != null ) { 
			
			if ( node.getData().equals( data ) ) { return data; }
			node = node.getNext();
		}
		
		return data;
	}
	
	public void sort() { 
		
		sort( '>' );
	}
	
	public void sort( char direction ) {
		
		Node<T>[] elements = dumpToArray();
		algorithms.SelectionSort<Node<T>> ss = new algorithms.SelectionSort<Node<T>>();
		ss.sort( elements );
		
		_head = null;
		
		applyHeadsByArray( elements );
	}
	
	protected Node<T>[] dumpToArray() { 
		
		Node<T> sample = new Node<T>( null );
		Node<T>[] elements = (Node<T>[]) Array.newInstance( sample.getClass(), this.length() );
		Node<T> cursor = _head;

		for ( int i = 0 ; i < this.length(); i++ ) {
			
			elements[i] = cursor;
			cursor = cursor.getNext();
		}
		
		return elements;
	}
	
	protected Node<T>[] applyHeadsByArray( Node<T>[] elements ) { 
		
		return applyHeadsByArray( elements, '>' );
	}

	protected Node<T>[] applyHeadsByArray( Node<T>[] elements, char direction ) {
		
		if ( direction == '>' ) {
			for ( int i = elements.length - 1 ; i >= 0 ; i-- ) { 
			
				insertAtHead( elements[i].getData() );
			}
		}
		else { 

			for ( int i = 0 ; i < elements.length ; i++ ) { 
				
				insertAtHead( elements[i].getData() );
			}
		}
		
		return elements;
	}
}
