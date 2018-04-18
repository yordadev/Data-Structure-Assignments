/*
 * Did not write this.
 */

package assignment06;

//Preconditions/Assumptions/Requirements
//      Must define ElementType object within the application package.
//      Must define a Clone method in the ElementType that performs a deep
//          copy and DOES NOT retain that address.

public class QueueADT {

    //Queue ADT attributes
    private NodeType front, back;
    private int capacity;

    //Queue ADT methods
    public int GetSize() {
        //Description:
        //      Returns the number of elements in the queue.
        //Preconditions:
        //      Queue is created (i.e. exists).
        //Postconditions:
        //      Returns the integer number of elements on the queue.
        int cnt;
        NodeType temp;

        cnt = 0;
        temp = front;
        while (temp != null) {
            cnt++;
            temp = temp.GetNext();
        }

        return cnt;
    }

    public boolean Enqueue(ElementType newItem) {
        //Description:
        //      Adds the given element to the queue adt at the back.
        //Preconditions:
        //      Queue is created (i.e. exists).
        //      newItem is properly loaded.
        //Postconditions:
        //      When the queue was not full,
        //          the given element will be added
        //          a value of true will be returned (i.e. true, we added)
        //      When the queue was full,
        //          the queue will remain unchanged
        //          a value of false will be returned (i.e. false, we didn't add)
        boolean result;
        ElementType temp;
        NodeType tempNode;

        temp = newItem.Clone();
        if (!IsFull()) {
            //not full
            result = true;
            tempNode = new NodeType();
            tempNode.SetData(temp);
            tempNode.SetNext(null);
            if (!IsEmpty()) {
                back.SetNext(tempNode);
            } else {
                front = tempNode;
            }
            back = tempNode;
            tempNode = null;
            temp = null;
        } else {
            //full
            result = false;
        }
        return result;
    }

    public ElementType Dequeue() {
        //Description:
        //      Gives back the item at the front.
        //Preconditions:
        //      The queue must exist (created).
        //Postconditions:
        //      When the queue is NOT empty
        //      The actual front item will be passed back to the application.
        //      The actual front item will be removed from the queue.
        //      When the Queue is empty
        //      Returns null
        ElementType dequeuedItem;
        NodeType temp;

        if (!IsEmpty()) {
            dequeuedItem = front.GetData();
            front.SetData(null);
            temp = front;
            front = front.GetNext();
            temp.SetNext(null);
            temp = null;
            if (front == null) {
                back = null;
            }
        } else {
            dequeuedItem = null;
        }

        return dequeuedItem;
    }

    public QueueADT() {
        //Description:
        //      Initializes a queue to an empty, but usable, state
        //          with the default capacity of 10.
        //Preconditions:
        //      none.
        //Postconditions:
        //      the Queue ADT will exist in an empty state with a
        //          capacity of 10.
        Create(10);
    }

    public QueueADT(int neededCapacity) {
        //Description:
        //      Initializes a queue to an empty, but usable, state
        //          with the capacity set according to the  
        //          application's requested size.
        //Preconditions:
        //      neededCapacity must be set to a positive integer.
        //Postconditions:
        //      the Queue ADT will exist in an empty state with the
        //          specified capacity.
        Create(neededCapacity);
    }

    public void Create(int neededCapacity) {
        //Description:
        //      Initializes a queue to an empty, but usable, state
        //          with the capacity set according to the  
        //          application's specified capacity.
        //Preconditions:
        //      neededCapacity must be set to a positive integer.
        //Postconditions:
        //      the Queue ADT will exist in an empty state with the
        //          specified capacity.
        capacity = neededCapacity;  //physical
        front = null;
        back = null;
    }

    public void Destroy() {
        //Description:
        //      Wipes out all data in the queue rendering the queue useless.
        //Preconditions:
        //      Queue must exist (created).
        //Postconditions:
        //      The queue will be destroyed and will no longer exist.
        while (!IsEmpty()) {
            Dequeue();
        }
        front = null;
        back = null;
        capacity = 0;
    }

    public boolean IsFull() {
        //Description:
        //      Identifies if the Queue has any additional capacity.
        //Preconditions:
        //      The queue must exist (created).
        //Postconditions:
        //      When queue has no capacity, returns true.
        //      When queue HAS capacity, returns false.
        boolean result;
        boolean memError;
        NodeType tempNode;
        ElementType temp;

        try {
            memError = false;
            tempNode = new NodeType();
            temp = new ElementType();
            if (tempNode == null || temp == null) {
                memError = true;
            }
            tempNode = null;
            temp = null;
        } catch (Exception e) {
            memError = true;
        }

        if (GetSize() == capacity || memError) {
            result = true;
        } else {
            result = false;
        }

        return result;
    }

    public boolean IsEmpty() {
        //Description:
        //      Identifies if the queue contains no data.
        //Preconditions:
        //      The queue must exist (created).
        //Postconditions:
        //      When queue has no data, returns true.
        //      When queue HAS data, returns false.
        boolean result;

        result = (back == null);// && front == null);

        return result;
    }
}
