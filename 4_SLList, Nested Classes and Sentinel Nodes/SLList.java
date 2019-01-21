public class SLList {
    //nested class; in this case of IntNode, it can either be public or private. But better to be private, since there is
    //no external use of it.
    //if IntNode never use anything else of SLList, make it static. static -> never look outwards. simplified
    //static saves tiny little bit of memory
    //SLList serves as a middle man for users to use IntNode
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }
    }

    // the key word private here is to warn users not to mess with this variable.
    //private IntNode sentinel.next;
    private IntNode sentinel;
    // to get the fast size
    private int size;

    public SLList(){
        sentinel = new IntNode(924, null);
        size = 0;
    }
    public SLList(int x){
        sentinel = new IntNode(924, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x){
        sentinel.next = new IntNode(x, sentinel.next);
        size++;
    }

    public void addLast(int x){
        IntNode p = sentinel.next;
        while (p.next != null){
            p = p.next;
        }
        p.next = new IntNode(x, null);
        size++;
    }
/*
    //my own way
    public int size(){
        int sum = 1;
        IntNode temp = this.sentinel.next;
        while (temp.next != null){
            sum++;
            temp = temp.next;
        }
        return sum;
    }
    */
    //method done recursively; also a really slow one
    /*private static int size(IntNode n){
        if(n.next == null){
            return 1;
        }
        else{
            return 1 + size(n.next);
        }
    }

    public int size(){
        return size(this.sentinel.next);
    }*/
    // the fast version
    //caching; redundant but fast
    public int size(){
        return this.size;
    }
    public int getFirst(){
        return sentinel.next.item;
    }
    public static void main(String[] args) {
        SLList ss = new SLList(10);
        //ss.sentinel.next.next = new IntNode(11,null);
        ss.addLast(11);
        System.out.println(ss.size());
    }
}
