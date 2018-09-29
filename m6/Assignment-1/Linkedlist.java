class Linkedlist {
    Node f = null;
    Node l = null;
    int size = 0;
    class Node {
        String data;
        Node next;
        Node(String data) {
            this.data = data; 
        }
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void push(String element){
        Node newnode = new Node(element);
        if(isEmpty()) {
            f = newnode;
            l = f;
            l.next = null;
            size = size + 1;
            return;
        }
        Node oldlast = l;
        l = newnode;
        oldlast.next = l;
        l.next = null;
        size = size + 1;

    }
    public String pop(){
        if(isEmpty()){
            return null;
        }
        String item = f.data;
        f = f.next;
        size = size - 1;
        return item;

    }
    public void printList() {
        Node pnode = f;       
        while (pnode != null) {
            System.out.print(pnode.data + " ");
            pnode = pnode.next;
        }
        
    }
}