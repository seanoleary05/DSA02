

public class CustomNode<K> {
    public CustomNode<K> next = null;
    private K data;
    //ADT reference


    public CustomNode(K data){
        this.data=data;
        this.next=null;
    }


    public K getData() {
        return data;
    }

    public void setData(K c) {
        data = c;
    }



}
