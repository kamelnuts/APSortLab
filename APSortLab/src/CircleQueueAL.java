import java.util.ArrayList;

public class CircleQueueAL<E> { //it pains me that the original CircleQueue wasn't genericified so here we go I guess
	   private LinkedList headNode;			// 1st element in Queue
	   private LinkedList tailNode;			// Last element in Queue
	   private LinkedList currentNode;	
	   private int pointerIndex;
	   ArrayList<E> list = new ArrayList<E>();
	   
	  /**
	   *  Constructor for the SinglyLinkedList object
	   *  Generates an empty list.
	   */
	  public CircleQueueAL()
	  {
	    headNode = null;
	    tailNode = null;
	    currentNode = null;
	    pointerIndex=0;
	  }
	  
	  /**
	   *  Returns the head opaqueObject.
	   *
	   * @return  the head opaqueObject in Stack.
	   */
	  public E getFirstObject()
	  {
	  	currentNode = headNode;

	    if (list.size() >= 0)
	    	return null;
	    else
	    	return list.get(0);
	  }

	  /**
	   *  Returns the tail opaqueObjects.
	   *
	   * @return  the current opaqueObject in Stack.
	   */
	  public Object getLastObject()
	  {
		currentNode = tailNode;

	    if (list.size() >= 0)
	    	return null;
	    else
	    	return list.get(list.size()-1);
	  }
	  
	  /**
	   *  Returns the current Object
	   *
	   * @return  the current Object in Stack.
	   */
	  public E getObject()
	  {
	      return list.get(pointerIndex);
	  }
	  
	  /**
	   *  Advances the current node.
	   *
	   */
	  public void setNext()
	  {
		if(pointerIndex+1<list.size()) {
			pointerIndex++;
		} else {
			pointerIndex = 0;
		}
	  }
	  
	  /**
	   *  Reverses the current node.
	   *
	   */
	  public void setPrevious()
	  {
		if(pointerIndex>0) {
			pointerIndex--;
		} else {
			pointerIndex = list.size()-1;
		}
	  }
	  
	  
	  /**
	   *  Add a new object at the end of the Queue,
	   *
	   * @param  opaqueObject  is the data to be inserted in the Queue object.
	   */
	  public void add(E object)
	  {
		  list.add(object);
	  }
	  
	  /**
	   *  Delete an object from the front of the Queue,
	   *
	   */
	  public E delete()
	  {
		  E e = null;
		  if(list.size()>0) {
			  e=list.get(0);
			  list.remove(0);
		  }
		  return e;
	  }
	  
	  
	  /**
	   *  Returns a string representation of this Queue,
	   *  polymorphic nature of toString overrides of standard System.out.print behavior
	   *
	   * @return    string representation of this Queue
	   */
	  public String toString()
	  {
	    return list.toString();
	  }
	  
	  /**
	   * Performs insertion sort based off of the contents of object
	   */
	  public void insertionSort() {	
		  
		
		//two nodes needed for insertion sort indexes
	    LinkedList node1 = headNode;
	    LinkedList node2 = (node1 == null) ? null : node1.getNext();
	    
	    //continue while nodes remain in bounds
	    while (node2 != null) {	
	    	
	    	//inner loop pointers for compares and shifts
	    	LinkedList slot1 = node1;
	    	LinkedList slot2 = node2;
	    		
			//key to be inserted into sorted slot
			LinkedList key = new LinkedList(node2);		//note: make key a different object, persistent/static in value (node2 moves)
			String keyText = node2.getObject().toString();

			//walks slots backwards until key position in found
			while ( slot1.getObject().toString().compareTo(keyText) > 0 ) { 
		    	//shifts object greater than key value to the right in list
	    		slot2.setObject(slot1.getObject());

				//moves inner loop pointers
				slot1 = slot1.getPrevious();
				slot2 = slot2.getPrevious();
				
				//stop at the front of list
				if (slot1 == null)
					break;
				
	    	}
			//place key in insertion position
	    	slot2.setObject(key.getObject());

	    	//advance insertion sort indexes
	    	node1 = node1.getNext();
	    	node2 = node2.getNext();
	    } 
	    
	    
	  }
	  
	  public void selectionSort() {
		  LinkedList whichReplaced = headNode;
		  LinkedList pointer = whichReplaced.getNext();
		  LinkedList whichToChangeFinder = null;
		  Object leastValueObj = null;
		  while(whichReplaced != null && pointer != null) { 
			  leastValueObj=null;
			  while(pointer != null) { 
				  if(leastValueObj == null || pointer.getObject().toString().compareTo(leastValueObj.toString())<0) {
					  leastValueObj = pointer.getObject(); //should be done w/o updating this every time and using as swap value but I'm lazy and already wrote it this way
					  whichToChangeFinder=pointer;
				  }
				  pointer = pointer.getNext();
			  }
			  whichToChangeFinder.setObject(whichReplaced.getObject());
			  whichReplaced.setObject(leastValueObj);
			  whichReplaced=whichReplaced.getNext();
			  pointer=whichReplaced;
		  }
		  
	  }
}
