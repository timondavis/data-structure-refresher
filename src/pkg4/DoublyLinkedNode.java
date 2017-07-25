package pkg4;

public class DoublyLinkedNode<T extends Comparable<T>> extends Node<T> {
	
	protected DoublyLinkedNode<T> _nextNode;
	protected DoublyLinkedNode<T> _prevNode;

	public DoublyLinkedNode(T data) {
		super(data);
	}
	
	public void setNext( DoublyLinkedNode<T> node ) {
		
		_nextNode = node;
		
		super.setNext( (Node<T>) node );
	}
	
	public DoublyLinkedNode<T> getNext() { 
		
		return _nextNode;
	}
	
	public void setPrevious( DoublyLinkedNode<T> prevNode ) { 
		
		_prevNode = prevNode;
	}
	
	public DoublyLinkedNode<T> getPrevious() { 
		
		return _prevNode;
	}
	

}
