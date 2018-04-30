package Assignment04;

//Preconditions/Assumptions/Requirements
//      Must define ElementType object within the application package.
//      Must define a Clone method in the ElementType that performs a deep
//          copy and DOES NOT retain that address.
//      Must define a GetKey method that returns a String that serves as the 
//          "key field" for the ElementType.

public class ListADT {
    //List ADT attributes
    //private String [ ] itemNames;
    //private int [ ] quantities;
    private ElementType [ ] items;
    private int current;
    private int size;       //logical size
    private int capacity;   //physical size
    private boolean ordered;
    
    //List ADT methods
    public boolean Search(String sValue) {
        //Description:
        //      Searches the list to find the specified item.
        //Preconditions:
        //      List is created (i.e. exists).
        //      sValue has been properly loaded elsewhere.
        //Postconditions:
        //      When the item is found,
        //          Returns true.
        //          The current location will be set accordingly.
        //      When item is not found,
        //          Returns false.
        //          In an unordered list, the current location will 
        //              have no meaning.
        //          In an ordered list, current will reflect the insertion 
        //              point.
        boolean result;
        
        //attempt to find it...
        if(!ordered) {
            //UNORDERED
            Reset( );
            while(!AtEnd( ) && !sValue.equals(items[current].GetKey( ))) {
                GetNext( );
            }
        } else {
            //ORDERED
            Reset( );
            while(!AtEnd( ) && sValue.compareTo(items[current].GetKey( )) > 0) {
                GetNext( );
            }
        }
        
        //determine if found or not...
        if(!AtEnd( ) && sValue.equals(items[current].GetKey( )))
            result = true;
        else
            result = false;
        
        return result;
    }
    
    public boolean Add(ElementType newItem) {
        //Description:
        //      Adds the given element to the list adt in the proper
        //          location if ordered or the most convenient spot 
        //          if UNordered.
        //Preconditions:
        //      List is created (i.e. exists).
        //      newItem is properly loaded.
        //Postconditions:
        //      When the list was not full,
        //          the given element will be added
        //          a value of true will be returned (i.e. true, we added)
        //      When the list was full,
        //          the list will remain unchanged
        //          a value of false will be returned (i.e. false, we didn't add)
        boolean result;
        ElementType temp;
        
        temp = newItem.Clone( );
        //System.out.println("Original item from application: "+newItem);
        //System.out.println("Cloned item from ADT: "+temp);
        if(!IsFull( )) {   //capacity > size) {
            //not full
            result = true;
            //temp.Set(newItem.GetItemName( ), newItem.GetQuantity( ));
            if(!ordered)
                Append(temp);
            else
                Insert(temp);
            size++;
        }
        else {
            //full
            result = false;
        }
        return result;
    }
    
    private void Insert(ElementType temp) {
        //find insertion spot
        Search(temp.GetKey( ));
        
        //make space
        for(int cnt = size; cnt > current; cnt--)
            items[cnt] = items[cnt - 1];
        
        //insert the item
        items[current] = temp;
    }
    
    private void Append(ElementType temp) {
        items[size] = temp;  //append to end
    }
    
    public boolean Remove(String searchValue) {
        //Description:
        //      Deletes an item that matches the searchValue.
        //Preconditions:
        //      The list must exist (created).
        //      searchValue must be properly loaded elsewhere.
        //Postconditions:
        //      When the searchValue matches a list item
        //          the matching item is removed.
        //          the size is decreased.
        //          returns a true value.
        //          When list is ordered, the ordering is preserved.
        //      When the searchValue is not present
        //          returns a false.
        //          the list content remains unchanged.
        boolean result;
        
        if(Search(searchValue) == true) {
            //found it...
            if(!ordered) {
                //move last item up to loc
                items[current] = items[size - 1];  //size indicates the NEXT EMPTY SLOT
            } else {
                //shift items UP...
                for(int cnt = current; cnt < size - 1; cnt++)
                    items[cnt] = items[cnt + 1];
            }
            //descrease size
            size--;
            
            //set return value
            result = true;
            
            //defensive???
            items[size] = null;
            
        } else {
            //did not find it...
            result = false;
        }
        
        return result;
    }
    
    public ElementType Retrieve( ) {
        //Description:
        //      Gives back a COPY of the item at the current location.
        //Preconditions:
        //      The list must exist (created).
        //      The current item must NOT be at the end.
        //Postconditions:
        //      A COPY of the item will be passed back to the application.
        ElementType retriever;
        
        retriever = items[current].Clone( );
        
        return retriever;
    }
    
    public ListADT( ) {
        //Description:
        //      Initializes a list to an empty, but usable, state
        //          with the default capacity of 10 AND UNordered.
        //Preconditions:
        //      none.
        //Postconditions:
        //      the List ADT will exist in an empty state with a
        //          capacity of 10 as an UNordered list.
        Create(10, false);
    }
    
    public ListADT(int neededCapacity, boolean theOrdering) {
        //Description:
        //      Initializes a list to an empty, but usable, state
        //          with the capacity set according to the  
        //          application's requested size AND ordering set
        //          to the application's requested state.
        //Preconditions:
        //      neededCapacity must be set to a positive integer.
        //      theOrdering must be set to a boolean value.
        //Postconditions:
        //      the List ADT will exist in an empty state with the
        //          specified capacity.
        Create(neededCapacity, theOrdering);
    }
    
    public void Create(int neededCapacity, boolean theOrdering) {
        //Description:
        //      Initializes a list to an empty, but usable, state
        //          with the capacity set according to the  
        //          application's requested size AND ordering.
        //Preconditions:
        //      neededCapacity must be set to a positive integer.
        //      theOrdering must be properly set to a boolean value 
        //Postconditions:
        //      the List ADT will exist in an empty state with the
        //          specified capacity AND ordering.
        capacity = neededCapacity;  //physical
        ordered = theOrdering;
        //itemNames = new String[capacity];
        //quantities = new int[itemNames.length];
        items = new ElementType[capacity];
        size = 0;  //logical
        current = 0;
    }
    
    public void Destroy( ) {
        //Description:
        //      Wipes out all data in the list rendering the list useless.
        //Preconditions:
        //      List must exist (created).
        //Postconditions:
        //      The list will be destroyed and will no longer exist.
        size = -items.length;
        current = 0;
        capacity = 0;
        for(int c = 0; c < items.length; c++)
            items[c] = null;
        items = null;
    }
    
    public boolean IsFull( ) {
        //Description:
        //      Identifies if the List has any additional capacity.
        //Preconditions:
        //      The list must exist (created).
        //Postconditions:
        //      When list has no capacity, returns true.
        //      When list HAS capacity, returns false.
        boolean result;
        
        if(size < capacity)
            result = false;
        else
            result = true;
        
        return result;
    }
    
    public boolean IsEmpty( ) {
        //Description:
        //      Identifies if the list contains no data.
        //Preconditions:
        //      The list must exist (created).
        //Postconditions:
        //      When list has no data, returns true.
        //      When list HAS data, returns false.
        boolean result;
        
        /*if(size == 0)
            result = true;
        else
            result = false;*/
        result = (size == 0);
        
        return result;
    }
    
    public void Reset( ) {
        //Description:
        //      Resets the current location of the list to the first item.
        //Preconditions:
        //      The list must exist (created).
        //Postconditions:
        //      The current location will be the first spot in the list.
        current = 0;
    }
    
    public void GetNext( ) {
        //Description:
        //      Moves the current location to the next location in the list.
        //Preconditions:
        //      The list must exist (created).
        //      The current location must NOT be at the end of the list.
        //Postconditions:
        //      The current location will be at the next location.
        current++;
    }
    
    public boolean AtEnd( ) {
        //Description:
        //      Tells us if the current location is at the end of the list.
        //Preconditions:
        //      The list must exist (created).
        //Postconditions:
        //      When the current location is the end of the list, returns true.
        //      When the current location is NOT the end of the list, 
        //              returns false.
        boolean result;
        
        if(current < size)
            result = false;
        else
            result = true;
        
        return result;
    }
}
