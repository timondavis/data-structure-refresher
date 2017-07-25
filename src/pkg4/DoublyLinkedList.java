package pkg4;

import java.util.AbstractSet;
import java.util.Set;

public class DoublyLinkedList<T extends Comparable<T>> {

	/** @property DoublyLinkedNode<T> _head  The head of our list **/
	protected DoublyLinkedNode<T> _head;
	
	/** @property DoublyLinkedNode<T> _tail  The tail of our list **/
	protected DoublyLinkedNode<T> _tail;
	
	/**
	 * Insert a data item at the head of the list
	 * 
	 * @param T data
	 * @return DoublyLinkedNode<T> The newly constructed node installed at the head
	 */
	public DoublyLinkedNode<T> insertAtHead( T data ) {
		
		// Construct new node
		 DoublyLinkedNode<T> node = new DoublyLinkedNode<T>( data );
		 
		 // If there is no head, install this item at the head and tail of the list, no pointing references
		 if ( _head == null ) { 
			 
			 _head = node;
			 _tail = node;
			 return node;
		 }
		 
		 // Otherwise, let's point the current head's previous pointer at our new node, set the next node for our new guy at the current head, 
		 // then move the head pointer to point at our new node.
		 _head.setPrevious( node );
		 node.setNext( _head );
		 _head = node;
		 
		 return node;
	}
	
	/**
	 * Insert a data item at the tail of the list
	 * @param T data
	 * 
	 * @return DoublyLinkedNode<T> The newly constructed node installed at the tail
	 */
	public DoublyLinkedNode<T> insertAtTail( T data ) { 
		
		// Wrap new data item in node
		DoublyLinkedNode<T> node = new DoublyLinkedNode<T>( data );
		
		// If there is no tail, there is no head.  Install this node as the head and the tail.  no crossreferenceing pointers.
		if ( _tail == null ) { 
			
			_head = node;
			_tail = node;
			
			return node;
		}
		
		// Otherwise, lets grab the current tail and tell it that it now has a NEXT node ( our new node ), tell our new node that the tail is
		// its previous node, and then set the new node to the tail.
		_tail.setNext( node );
		node.setPrevious( _tail );
		_tail = node;
		
		return node;
	}
	
	/**
	 * Delete the head node from the linked list.
	 * 
	 * @return T  The item removed from the list
	 */
	public T deleteAtHead() { 
		
		DoublyLinkedNode<T> popped = _head;
		_head = popped.getNext();
		_head.setPrevious( null );
		
		return popped.getData();
	}
	
	/**
	 * Delete the tail node from the linked list
	 * 
	 * @return T  The item removed from the list.
	 */
	public T deleteAtTail() { 
		
		DoublyLinkedNode<T> dequeued = _tail;
		_tail = dequeued.getPrevious();
		_tail.setNext( null );
		
		return dequeued.getData();
	}
	
	/**
	 * Find the data stored in the nth node from the head of the list
	 * 
	 * @param int position
	 * 
	 * @return T 
	 */
	public T findAtPosition( int position ) { 
		
		return findAtPosition( position, false );
	}

	/**
	 * Find the data stored in the nth node from the head or tail of the list
	 * 
	 * @param int position
	 * @param boolean reverse (FALSE to search from head, TRUE to search from tail)
	 * @return
	 */
	public T findAtPosition( int position , boolean reverse ) { 
		
		DoublyLinkedNode<T> n;

		if ( reverse ) { n = _tail; }
		else { n = _head; }
			
		for ( int i = 0 ; n != null ; i++ ) { 
			
			if ( i == position ) { return n.getData(); }
			n = progress( n, reverse );
		}
		
		return null;
	}
	
	/**
	 * Shift the given node one space to its left, if possible. 
	 * 
	 * @param DoublyLinkedNode<T> n
	 */
	public void shiftLeft( DoublyLinkedNode<T> n ) { 

		// If left is null, this is the leftmost on the list and there's no shift to execute
		if ( n.getPrevious() == null ) { return; }
		
		// If the position we're moving into exists, re-point its pointer at n
		if ( n.getPrevious().getPrevious() != null ) { 
			
			n.getPrevious().getPrevious().setNext( n );
		}
		
		// Point the previous node's next pointer node to the right of n
		n.getPrevious().setNext( n.getNext() );
		
		// If we're not at the tail of the list, we'll adjust the 'previous' pointer on the next node to be the one to the left of n
		// Otherwise we'll mark the new tail as the node previous this one.
		if ( n.getNext() != null ) { 

			n.getNext().setPrevious(n.getPrevious() );
		} else {
			
			_tail = n.getPrevious();
		}
		
		// Set the next node on this as what used to the previous node
		n.setNext( n.getPrevious() );
		// Set the node previous to this as what used to be previous to the prior node
		n.setPrevious( n.getNext().getPrevious() ); 
		// Update the prior node to regard n as the previous.
		n.getNext().setPrevious( n );
		
		// If we shifted to the left of head, re-appoint the head pointer
		if ( _head.compareTo( n.getNext() ) == 0 ) {
			
			_head = n;
		}
	}

	/**
	 * Sort the elements in the list by way of object comparison
	 */
	public void sort() {
		
		// Create pointers for the index (the node being compared against to start) and the 
		// currentNode (the node that will be considered for leftward movement)
		DoublyLinkedNode<T> indexNode = _head;
		DoublyLinkedNode<T> currentNode;
		
		// Flag indicating whether any nodes were found in a scan pass which were greater than the index
		boolean shiftOperationExecuted = false;
		
		// If there are not at least two valid nodes, do not sort.
		if ( indexNode == null || indexNode.getNext() == null ) { return; }
		
		// Look for nodes greater than the value of the index node
		do { 
			
			// Reset operation flag
			shiftOperationExecuted = false;
			
			// Set the 'currentNode' being considered directly to the right of the index node.
			currentNode = indexNode.getNext();

			// ( stop if the current node is null, index is now at the end (right) of the list.
			if ( currentNode == null ) { break; }

		
			// If the currentNode (to the right of the index) has a value less than that of the index, shift the currentNode left
			// until it is at the head OR until its value is greater than a node on its left.
			while( currentNode != null && currentNode != _head && currentNode.compareTo( currentNode.getPrevious() ) < 0 ) { 
				
				shiftLeft( currentNode );
				shiftOperationExecuted = true;
			}

			// If there were no nodes found, to the right of the index node, which contain a value less than that of the index, we'll 
			// advance the index and continue the search.
			if ( ! shiftOperationExecuted ) { indexNode = indexNode.getNext(); }

		} while ( indexNode != null && indexNode.getNext() != null);
	}
	
	

	
	/**
	 * Reverses the order chain in the list
	 */
	public void reverseSort() { 
		
		// Sort 
		sort();
		
		// Create buckets to hold current node, left node and right node
		DoublyLinkedNode<T> n = _head;
		DoublyLinkedNode<T> left;
		DoublyLinkedNode<T> right;
		
		// Loop through each node and switch its pointers for next and previous
		while ( n != null ) { 
			
			right = n.getNext();
			left = n.getPrevious();

			n.setPrevious( right );
			n.setNext( left );
			
			n = right;
		}
		
		// Swap the head and the tail.
		left = _head;
		right = _tail;
		
		_tail = left;
		_head = right;
	}
	
	

	/**
	 * Sort the list and insert the data item in a node at the appropriate, ordered point
	 * @param T data
	 */
	public void sortAndInsert( T data ) {
		
		sort();
		
		DoublyLinkedNode<T> node = _head;
		
		// Traverse the linked list until a point is reached where the data item is greater than its left AND less than its right.
		// (accounting for nulls at head and tail).  Insert data node at between these two.
		do { 
			
			if ( node.getNext() != null && data.compareTo( node.getNext().getData() ) < 0 ) {
		
				insertAt( node, new DoublyLinkedNode<T>( data ));
				return;

			} else { 

				node = node.getNext();
			}

		} while ( node != null );
		
		return;
	}
	
	/**
	 * Removes any duplicated values from the list, except for the first instance
	 */
	public void deduplicate() {
		
		deduplicate( true );
	}
	
	/**
	 * Removes any duplicated values from the list; you can specify whether or not to remove the first instance
	 * 
	 * @param boolean leaveFirstInstance
	 */
	public void deduplicate( boolean leaveFirstInstance ) {
		
		DoublyLinkedNode<T> leftIndex = _head;
		DoublyLinkedNode<T> pointer;
		
		boolean duplicateInstanceFound = false; 
		boolean removeAllInstances = !leaveFirstInstance;

		// Loop through all nodes in list
		while( leftIndex != null ) { 

			// If on the last loop we found duplicates, 
			if ( removeAllInstances && duplicateInstanceFound ) {

				delete( leftIndex.getPrevious() );
			}
		
			duplicateInstanceFound = false;
			
			// Create a pointer.  We're going to move pointer this through the remainder of the list and look for duplicates.
			pointer = leftIndex.getNext();
			
			// Look for duplicate values.  If found, delete the duplicate node, progress the loop, 
			// and flag - we found a duplicate.
			while ( pointer != null ) { 
				
				if ( pointer.compareTo( leftIndex ) == 0 ) {
					
					if ( pointer.getNext() == null ) { 
						
						delete( pointer );
						pointer = pointer.getNext();
					} else {
						
						pointer = pointer.getNext();
						delete( pointer.getPrevious() );
					}

					duplicateInstanceFound = true;

				} else { 
					
					pointer = pointer.getNext();
				}
			}
			
			// Move the pointer up one
			leftIndex = leftIndex.getNext();
		}
	}
	
	/**
	 * Convert the node into a string
	 * 
	 * @return String;
	 */
	public String toString() { 
		
		String s = "{";

		DoublyLinkedNode<T> node = _head;

		while ( node != null ) {
			
			s += "Data: " + node.getData().toString() + ", ";
			node = node.getNext();
		}
		
		s += "}";
		
		return s;
	}
	
	/**
	 * Convert the node into a string, but report from tail to head (instead of head to tail)
	 * @param boolean reverse
	 * 
	 * @return String
	 */
	public String toString( boolean reverse ) { 
		
		if ( ! reverse ) return toString();
		
		DoublyLinkedNode<T> node = (DoublyLinkedNode<T>) _tail;

		String s = "{";
		
		while ( node != null ) { 
			
			s += "Data: " + node.getData().toString() + ", ";
			node = node.getPrevious();
		}
		
		s += "}";
		
		return s;
	}	
	

	
	/**
	 * Get the next node from the given current node
	 * 
	 * @param DoublyLinkedNode<T> currentNode 
	 * @return DoublyLinkedNode<T>
	 */
	protected DoublyLinkedNode<T> progress( DoublyLinkedNode<T> currentNode ) { 
		
		return progress( currentNode, false );
	}

	/**
	 * Get the next OR previous node from the given current node
	 * 
	 * @param DoublyLinkedNode<T> currentNode
	 * @param boolean reverse (TRUE gets previous, FALSE gets next)
	 * 
	 * @return DoublyLinkedNode<T>
	 */
	protected DoublyLinkedNode<T> progress( DoublyLinkedNode<T> currentNode, boolean reverse ) { 
		
		if ( reverse ) { return currentNode.getPrevious(); }
		else { return currentNode.getNext(); }
	}
	
	/**
	 * Insert the indicated node to the right (next) of the indicated node.
	 * @param DoublyLinkedNode<T> indexedNode
	 * @param DoublyLinkedNode<T> newNode
	 */
	private void insertAt( DoublyLinkedNode<T> indexedNode, DoublyLinkedNode<T> newNode ) {
			
		newNode.setNext( indexedNode.getNext() );
		indexedNode.setNext( newNode );
		
		newNode.getNext().setPrevious( newNode );
		newNode.setPrevious( indexedNode );
	}
	
	/**
	 * Remove the given node from the linked list.  Automatically repairs broken links.
	 * 
	 * @param DoublyLinkedNode<T> nodeToDelete
	 */
	private void delete( DoublyLinkedNode<T> nodeToDelete ) { 
		
		if ( nodeToDelete == null ) { return; }
		
		if ( nodeToDelete == _head ) { deleteAtHead(); return; }
		if ( nodeToDelete == _tail ) { deleteAtTail(); return; }
		
		nodeToDelete.getPrevious().setNext( nodeToDelete.getNext() );
		nodeToDelete.getNext().setPrevious( nodeToDelete.getPrevious() );
	}
}
