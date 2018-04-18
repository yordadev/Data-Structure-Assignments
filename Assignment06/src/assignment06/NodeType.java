/*
 * Did not write this.
 */

package assignment06;

public class NodeType {

    private ElementType data;
    private NodeType next;

    public void SetData(ElementType nItem) {
        data = nItem;
    }

    public ElementType GetData() {
        return data;
    }

    public void SetNext(NodeType nNext) {
        next = nNext;
    }

    public NodeType GetNext() {
        return next;
    }
}
