public class SLList <LochNess>{
    //nested class; in this case of IntNode, it can either be public or private. But better to be private, since there is
    //no external use of it.
    //if IntNode never use anything else of SLList, make it static. static -> never look outwards. simplified
    //static saves tiny little bit of memory
    //SLList serves as a middle man for users to use IntNode

    //20190122
    //Java allow us to defer type selection until declaration
    private class StaffNode {
        public LochNess item;
        public StaffNode next;

        public StaffNode(LochNess i, StaffNode n){
            item = i;
            next = n;
        }
    }

    // the key word private here is to warn users not to mess with this variable.
    private StaffNode first;
    //private StaffNode sentinel;
    // to get the fast size
    private int size;
/*
    public SLList(){
        sentinel = new StaffNode(924, null);
        size = 0;
    }*/
    public SLList(LochNess x){
        //sentinel = new StaffNode(924, null);
        //sentinel.next = new StaffNode(x, null);
        first = new StaffNode(x, null);
        size = 1;
    }

    public void addFirst(LochNess x){
        first = new StaffNode(x, first);
        size++;
    }

    public void addLast(LochNess x){
        StaffNode p = first;
        while (p.next != null){
            p = p.next;
        }
        p.next = new StaffNode(x, null);
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
    public LochNess getFirst(){
        return first.item;
    }
    public static void main(String[] args) {
        SLList<String> ss = new SLList<>("puke");
        //ss.sentinel.next.next = new IntNode(11,null);
        //ss.addLast(11);
        System.out.println(ss.first.item);
    }
}
