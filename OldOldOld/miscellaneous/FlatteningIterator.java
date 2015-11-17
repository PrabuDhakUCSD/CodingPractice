import java.io.*;
import java.util.*;

public class FlatteningIterator<Type> implements Iterator<Type> {

    private List<Iterator<Type>> iterList;
    private Iterator<Type> currentIterator;

    public FlatteningIterator(List<Iterator<Type>> iterList) {
        this.iterList = iterList;
    }

    @Override
    public boolean hasNext() {
        for (Iterator<Type> iter : iterList) {
            if (iter.hasNext()) {
                currentIterator = iter;
                return true;
            }
        }
        return false;
    }

    @Override
    public Type next() {
        //for (Iterator<Type> iter : iterList) {
        //    if (iter.hasNext()) {
        //        return iter.next();
        //    }
        //}
        if (hasNext()) {
            return currentIterator.next();
        }

        return null;
    }

    @Override
    public void remove() {
    }

    public static void main(String args[]) {
        List<String> l1 = new ArrayList<String>();
        List<String> l2 = new ArrayList<String>();
        List<String> l3 = new ArrayList<String>();

        l1.add("1");
        l1.add("2");
        l1.add("3");
        l2.add("4");
        l2.add("5");
        l2.add("6");
        l3.add("7");
        l3.add("8");
        l3.add("9");

        List<Iterator<String>> iterList = new ArrayList<Iterator<String>>();
        iterList.add(l1.iterator());
        iterList.add(l2.iterator());
        iterList.add(l3.iterator());

        FlatteningIterator<String> iter = new FlatteningIterator<String>(iterList);

        while (iter.hasNext()) {
            System.out.println(iter.next()+"\n");
        }
    }
}
