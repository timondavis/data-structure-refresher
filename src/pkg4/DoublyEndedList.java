package pkg4;

public class DoublyEndedList<T extends Comparable<T>> extends LinkedList<T> {

	protected Node<T> _tail;
	
	public Node<T> insertAtHead ( T data ) { 
		
		if ( _head != null && _tail == null ) { 
			_tail = _head;
		}
		
		return super.insertAtHead( data );
	}
	
	public Node<T> insertAtTail ( T data ) { 
		
		Node<T> node = new Node<T>( data );
		
		if ( _head == null  ) { 
			this._head = node;
			this._tail = node;
		}
		
		if ( _tail != null ) { 
			
			_tail.setNext( node );
			_tail = node;
		}
		
		return _tail;
	}
}

