package lab05so;
//Preconditions/Assumptions/Requirements
//      Must define ElementType object within the application package.
//      Must define a Clone method in the ElementType that performs a deep
//          copy and DOES NOT retain that address.
//      Must define a GetKey method that returns a String that serves as the 
//          "key field" for the ElementType.

public class StackADT {
    //Stack ADT attributes
    private RemainderObj [ ] items;
    private int top;       //logical size
    private int capacity;   //physical size
    
    //Stack ADT methods
    public int GetSize( ) {
        //Description:
        //      Returns the number of elements in the stack.
        //Preconditions:
        //      Stack is created (i.e. exists).
        //Postconditions:
        //      Returns the integer number of elements on the stack.
        return top;
    }
    
    public boolean Push(RemainderObj newItem) {
        //Description:
        //      Adds the given element to the stack adt at the top.
        //Preconditions:
        //      Stack is created (i.e. exists).
        //      newItem is properly loaded.
        //Postconditions:
        //      When the stack was not full,
        //          the given element will be added
        //          a value of true will be returned (i.e. true, we added)
        //      When the stack was full,
        //          the stack will remain unchanged
        //          a value of false will be returned (i.e. false, we didn't add)
        boolean result;
        RemainderObj temp;
        
        temp = newItem.Clone( );
        if(!IsFull( )) {   //capacity > size) {
            //not full
            result = true;
            items[top] = temp;
            top++;
            temp = null;
        }
        else {
            //full
            result = false;
        }
        return result;
    }
    
    public RemainderObj Pop( ) {
        //Description:
        //      Gives back a COPY of the item at the top.
        //Preconditions:
        //      The stack must exist (created).
        //Postconditions:
        //      When the stack is NOT empty
            //      The actual top item will be passed back to the application.
            //      The actual top item will be removed from the stack.
        //      When the Stack is empty
            //      Returns null
        RemainderObj poppedItem;
        
        if(!IsEmpty( )) {
            top--;
            poppedItem = items[top];
            items[top] = null;
        }
        else
            poppedItem = null;
        
        return poppedItem;
    }
    
    public StackADT( ) {
        //Description:
        //      Initializes a stack to an empty, but usable, state
        //          with the default capacity of 10.
        //Preconditions:
        //      none.
        //Postconditions:
        //      the Stack ADT will exist in an empty state with a
        //          capacity of 10.
        Create(10);
    }
    
    public StackADT(int neededCapacity) {
        //Description:
        //      Initializes a stack to an empty, but usable, state
        //          with the capacity set according to the  
        //          application's requested size.
        //Preconditions:
        //      neededCapacity must be set to a positive integer.
        //Postconditions:
        //      the Stack ADT will exist in an empty state with the
        //          specified capacity.
        Create(neededCapacity);
    }
    
    public void Create(int neededCapacity) {
        //Description:
        //      Initializes a stack to an empty, but usable, state
        //          with the capacity set according to the  
        //          application's specified capacity.
        //Preconditions:
        //      neededCapacity must be set to a positive integer.
        //Postconditions:
        //      the Stack ADT will exist in an empty state with the
        //          specified capacity.
        capacity = neededCapacity;  //physical
        items = new RemainderObj[capacity];
        top = 0;  //logical
    }
    
    public void Destroy( ) {
        //Description:
        //      Wipes out all data in the stack rendering the stack useless.
        //Preconditions:
        //      Stack must exist (created).
        //Postconditions:
        //      The stack will be destroyed and will no longer exist.
        top = -items.length;
        capacity = 0;
        for(int c = 0; c < items.length; c++)
            items[c] = null;
        items = null;
    }
    
    public boolean IsFull( ) {
        //Description:
        //      Identifies if the Stack has any additional capacity.
        //Preconditions:
        //      The stack must exist (created).
        //Postconditions:
        //      When stack has no capacity, returns true.
        //      When stack HAS capacity, returns false.
        boolean result;
        
        if(top < capacity)
            result = false;
        else
            result = true;
        
        return result;
    }
    
    public boolean IsEmpty( ) {
        //Description:
        //      Identifies if the stack contains no data.
        //Preconditions:
        //      The stack must exist (created).
        //Postconditions:
        //      When stack has no data, returns true.
        //      When stack HAS data, returns false.
        boolean result;
        
        /*if(size == 0)
            result = true;
        else
            result = false;*/
        result = (top == 0);
        
        return result;
    }
}
