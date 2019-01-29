public class AList<Item> {
    private Item[] items;
    private int size;
    public AList(){
        items = (Item[]) new Object[100];
        size = 0;
    }

    private void resize(int x){
        Item[] temp = (Item[]) new Object[x];
        System.arraycopy(items, 0, temp, 0, size);
        items = temp;
    }

    public void addLast(Item x){
        if (size == items.length){
            // This is quite time-consuming: resize(size + REFACTOR)
            //resize(size += 1);
            // Great Performance: this is how the Python list is implemented -> resize(size * REFACTOR)
            resize(size * 2);
        }
        items[size] = x;
        size += 1;
    }

    public Item getLast(){
        return items[size - 1];
    }

    public Item get(int x){
        return items[x];
    }

    public int size(){
        return size;
    }

    public Item removeLast(){
        Item temp = getLast();
        //Item temp = items[size - 1];
        items[size - 1] = null;
        size -= 1;
        return temp;
    }
}
