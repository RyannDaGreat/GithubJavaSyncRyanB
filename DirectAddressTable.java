public class DirectAddressTable<V extends Hashable> implements Dictionary<V>
{
    private Hashable[] table=new Hashable[26];//It's hard-coded to 26 values. Pretty dumb, amiright?
//    private boolean isFull()//Just using it for some assertions...
//    {
//        assert !isEmpty();
//        for(Hashable x : table)
//            if(x==null)
//                return false;
//        return true;
//    }
    @Override
    public boolean isEmpty()
    {
        for(Hashable x : table)
            if(x!=null)
                return true;
        return false;
    }
    @Override
    public void insert(V value)throws NullPointerException
    {
        if(value==null)
            throw new NullPointerException("Value cannot equal null for the insert method. ");
        if(value.hash()>=table.length)//We make the array bigger.
        {
            Hashable[] newTable=new Hashable[value.hash()*2];//Project requires O(1) time but says nothing about memory management. This is my solution; to have the array increase in size exponentially.
            System.arraycopy(table,0,newTable,0,table.length);
            table=newTable;
        }
        table[value.hash()]=value;//If there's allready an entry there it gets replaced by value
//        int l=table.length,
//            h=value.hash();
//        for(int i=h,j;i<l;i++)//Find an empty spot on the table
//        {
//            if(table[j=(h+i)%l]==null)
//            {
//                table[j]=value;
//                return;
//            }
//        }
//        assert isFull();//If we reach this point, the array is full and we can't add any more values into it. The insertion failed.
    }
    @Override
    public V delete(V value)throws NullPointerException
    {
        if(value==null)
            throw new NullPointerException("Value cannot equal null for the insert method. ");
        if(value.hash()>=table.length)
            return null;
        int h=value.hash();
        V v=(V)table[h];
        table[h]=null;
        return v;
//        int l=table.length,
//            h=value.hash();
//        for(int i=h,j;i<l;i++)//Find an empty spot on the table
//        {
//            V v=(V)table[j=(h+i)%l];
//            if(v==null)
//                return null;//It should be safe to assume that if v==null, that
//            if(h==v.hash())
//            {
//               table[j]=null;
//               return v;
//            }
//        }
//        assert isFull();
//        return null;//The array is full and there are are are no values to delete.
    }
    @Override
    public V find(int key)
    {
        if(key>=table.length)
            return null;
        return (V)table[key];
    }
    public String toString()
    {
        String out="";
        int i=0;
        for(Hashable h : table)
            out+=(i+++" -- "+h+"\n");
        return out;
    }
}