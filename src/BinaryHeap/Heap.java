package BinaryHeap;

@SuppressWarnings("unchecked")
public class Heap<AnyType extends Comparable<AnyType>>
{
    private static final int CAPACITY = 2;

    private int size;
    private AnyType[] heap;

    public Heap()
    {
        size = 0;
        heap = (AnyType[]) new Comparable[CAPACITY];
    }


    public Heap(AnyType[] array)
    {
        size = array.length;
        heap = (AnyType[]) new Comparable[array.length+1];

        System.arraycopy(array, 0, heap, 1, array.length);

        buildHeap();
    }

    private void buildHeap()
    {
        for (int k = size/2; k > 0; k--)
        {
            shiftDown(k);
        }
    }
    private void shiftDown(int k)
    {
        AnyType tmp = heap[k];
        int child;

        for(; 2*k <= size; k = child)
        {
            child = 2*k;

            if(child != size &&
                    heap[child].compareTo(heap[child + 1]) > 0) child++;

            if(tmp.compareTo(heap[child]) > 0)  heap[k] = heap[child];
            else
                break;
        }
        heap[k] = tmp;
    }

    public void heapSort(AnyType[] array)
    {
        size = array.length;
        heap = (AnyType[]) new Comparable[size+1];
        System.arraycopy(array, 0, heap, 1, size);
        buildHeap();

        for (int i = size; i > 0; i--)
        {
            AnyType tmp = heap[i];
            heap[i] = heap[1];
            heap[1] = tmp;
            size--;
            shiftDown(1);
        }
        for(int k = 0; k < heap.length-1; k++)
            array[k] = heap[heap.length - 1 - k];
    }


    public AnyType deleteMin()
    {
        AnyType min = heap[0];
        heap[1] = heap[size--];
        shiftDown(1);
        return min;
    }


    public void insert(AnyType x)
    {
        if(size == heap.length - 1) doubleSize();

        int pos = ++size;

        for(; pos > 1 && x.compareTo(heap[pos/2]) < 0; pos = pos/2 )
            heap[pos] = heap[pos/2];

        heap[pos] = x;
    }

    private void doubleSize()
    {
        AnyType [] old = heap;
        heap = (AnyType []) new Comparable[heap.length * 2];
        System.arraycopy(old, 1, heap, 1, size);
    }
    public AnyType watchMin() {
        if(size == 0)
            return null;

        return heap[0];
    }
     public AnyType watchMax() {
         if(size == 0)
             return null;

         return heap[size - 1];
     }


    public String toString()
    {
        String out = "";
        for(int k = 1; k <= size; k++) out += heap[k]+" ";
        return out;
    }

    public static void main(String[] args)
    {
        Heap<String> h = new Heap<String>();

        h.insert("p");
        h.insert("r");
        h.insert("i");
        h.insert("o");
        System.out.println(h);
        h.deleteMin();
        System.out.println(h);


        Heap<Integer> tmp = new Heap<Integer>();
        tmp.insert(2);
        tmp.insert(2);
        tmp.insert(3);
        tmp.insert(6);
        tmp.insert(1);
        tmp.insert(4);
        tmp.buildHeap();
        System.out.println(tmp.toString());
        tmp.deleteMin();
        System.out.println(tmp.toString());
    }
}