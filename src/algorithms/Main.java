package algorithms;
import section3.*;
import pkg4.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();
		
		ll.insertAtHead( 48 );
		ll.insertAtHead( 5 );
		ll.insertAtHead( 98 );
		ll.insertAtHead( 993 );
		ll.insertAtHead( 35 );
		ll.insertAtTail( 115 );
		ll.insertAtHead( 12 );
		ll.insertAtHead( 598 );
		ll.insertAtTail( 300 );

		ll.reverseSort();
		
		System.out.println( "Forward: " + ll.toString( false ) );

		
		/**
		 * SECTIONS 1 - 3 
		 */
		/*Employee[] employees = {
				
				new Employee( 12, "Timon", "Davis", "timon@yahoo.com" ),
				new Employee( 6, "NaN", "Freeman", "sixofone@gmail.com" ),
				new Employee( 18, "Ned", "Henry", "nedh@yahoo.com" ),
				new Employee( 2, "Floyd", "Gundersen", "fg@yahoo.com" ),
				new Employee( 20, "Gorgeous", "George", "gg@bbc.co.uk" ),
				new Employee( 7, "Alan", "Shepherd", "as@fbc.com" )
		};
		
		InsertionSort<Employee> sorter = new InsertionSort<Employee>();
		sorter.sort( employees );
		
		for ( int i = 0 ; i < employees.length ; i++ ) { 
			
			System.out.println( employees[i] );
		}
		
		StringFun sf = new StringFun();
		
		System.out.println();
		System.out.println();
		
		System.out.println( "Anaconda - does it have duplicate letters?  " + ( (StringFun.hasDuplicateChars( "Anaconda" ) ) ? "YES" : "NO" ) );
		System.out.println( "Great - does it have duplicate letters?  " + ( (StringFun.hasDuplicateChars( "Great" ) ) ? "YES" : "NO" ) );
		
		System.out.println( "HAT is an anagram of THE? " + ( ( sf.isAnagram( "HAT", "THE" ) ) ? "YES" : "NO" ) );
		System.out.println( "NOMO is an anagram of MOON? " + ( ( sf.isAnagram( "MOMNO", "OMONM" ) ) ? "YES" : "NO" ) );*/

		
		/*Integer[] someNumbers = { 48, 291, 39, 1, 390, 3499, 304, 984, 292 };
		
		InsertionSort<Integer> bs = new InsertionSort<Integer>();
		//SelectionSort<Integer> bs = new SelectionSort<Integer>();
		//BubbleSort<Integer> bs = new BubbleSort<Integer>();
		
		bs.debug();
		bs.sort( someNumbers );
		
		for( int i = 0 ; i < someNumbers.length ; i++ ) {
			
			System.out.println( someNumbers[i] );
		}
		
		System.out.println( "Found: " + bs.find( 291 ).toString() );*/

	}
}
