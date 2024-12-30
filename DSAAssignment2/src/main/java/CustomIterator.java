


import java.util.Iterator;

public class CustomIterator<K> implements Iterator<K> {

    private CustomNode<K> pos;



    public CustomIterator(CustomNode<K> head){    //constructor
        this.pos=head;
    }


    public void Iterator(CustomNode<K> head) {
        this.pos = head;
    }

    public boolean hasNext() {
        return pos != null;

    }

    public K next() {
        CustomNode<K> temp = pos;
        pos = pos.next;
        return temp.getData();
    }



}










