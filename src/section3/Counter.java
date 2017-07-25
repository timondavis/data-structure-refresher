package section3;

public class Counter<T extends Comparable<T>> implements Comparable<Counter<T>> {
	
	private T _item;
	private int _score;
	
	public Counter(T item) { 
		
		_item = item;
		_score = 0;
	}
	
	public void countUp() { 
		
		_score++;
	}
	
	public boolean countDown() {
		_score--;
		
		if ( _score < 0 ) { return false; }
		return true;
	}
	
	public T getItem() { 
		
		return _item;
	}

	public T getValue() {
		
		return _item;
	}

	@Override
	public int compareTo(Counter<T> o) {
		
		return _item.compareTo( o._item );
	}
}