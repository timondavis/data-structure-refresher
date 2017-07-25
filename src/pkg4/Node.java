package pkg4;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>>{

	private T _data;
	private Node<T> _nextNode;
	
	public Node( T data ) {
		
		setData( data );
	}
	
	public T getData() { 
		return _data;
	}
	
	public Node<T> getNext() {
		
		return _nextNode;
	}
	
	public void setData( T data ) { 
		
		_data = data;
	}
	
	public void setNext( Node<T> nextNode ) { 
		
		_nextNode = nextNode;
	}

	@Override
	public int compareTo(Node<T> o) {
		
		return _data.compareTo( o._data );
	}
}
