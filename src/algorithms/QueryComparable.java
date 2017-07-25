package algorithms;

public abstract class QueryComparable<T> implements Comparable<T>{

	public abstract T getValue();
	public abstract T getValue( String label );
}
