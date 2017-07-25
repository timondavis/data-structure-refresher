package section3;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StringFun {
	
	private Counter<Character>[] _alphabet;

	public static boolean hasDuplicateChars( String query ) {
		
		String s = query.toLowerCase().trim();
		
		for( int progressPointer = 0 ; progressPointer < s.length() ; progressPointer++) { 
			
			for ( int searchPointer = progressPointer + 1 ; searchPointer < s.length() ; searchPointer++) {
				
				if ( s.charAt( progressPointer ) == s.charAt( searchPointer ) ) { return true; }
			}
		}
		
		return false;
	}
	
	public boolean isAnagram(String word1, String word2 ) {
		
		if ( word1.length() != word2.length() ) { return false; }
		
		for ( int pointer = 0 ; pointer < word1.length() ; pointer++ )  {
			
			Counter<Character> found = find( word1.charAt( pointer ) );
			found.countUp();
		}
		
		for ( int pointer = 0 ; pointer < word2.length(); pointer++ ) {
			
			Counter<Character> found = find( word2.charAt( pointer ) );
			if ( ! found.countDown() ) { return false; }
		}

		reset();
		
		return true;
	}
	
	
	public StringFun() { 
		
		Counter<Character> demoClass = new Counter<Character>(null);
		char[] alphas = "abcdefghijklmnopqrstuvwxyz".toCharArray();

		_alphabet = ( Counter<Character>[]) Array.newInstance( demoClass.getClass(), alphas.length);
		
		for ( int i = 0 ; i < alphas.length ; i++ ) { 
			
			_alphabet[i] = new Counter<Character>( alphas[i] );
		}
	}
	
	private void reset() {
		
		char[] alphas = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		for ( int i = 0 ; i < alphas.length ; i++ ) { 
			
			_alphabet[i] = new Counter<Character>( alphas[i] );
		}
	}
	
	private Counter<Character> find( Character c ) { 
		
		Counter<Character>[] searchArray = _alphabet.clone();
		return find( Character.toLowerCase( c ), searchArray );
	}
	
	private Counter<Character> find( Character c, Counter<Character>[] tmp ) { 
		
		int middlePointer = (int) Math.floor(tmp.length / 2 );
		
		if ( c.compareTo( tmp[middlePointer].getValue() ) == 0 ) {
			
			return tmp[middlePointer];
		}
		
		if ( tmp.length <= 1 ) { return null; }
	
		if ( c.compareTo( tmp[middlePointer].getValue() ) > 0 ) {

			tmp = Arrays.copyOfRange( tmp, middlePointer, tmp.length );
			return find( c, tmp );
		}
		
	tmp = Arrays.copyOfRange( tmp, 0, middlePointer );
		return find( c, tmp );
	}
	
}