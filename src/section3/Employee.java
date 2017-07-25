package section3;

public class Employee implements Comparable<Employee>{

	private int _id;
	private String _firstName;
	private String _lastName;
	private String _email;
	
	public Employee( int id, String firstName, String lastName, String email ){ 
		
		_id = id;
		_firstName = firstName;
		_lastName = lastName;
		_email = email;
	}

	@Override
	public int compareTo(Employee o) {
		
		if ( _id > o._id ) { 
			
			return 1;
		} 
		else if ( _id < o._id ) {
			
			return -1;
		}
		
		return 0;
	}
	
	@Override
	public String toString() {
		
		return _id + " | " + _firstName + " " + _lastName + " | " + _email;
	}
}
