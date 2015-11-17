
public class MyCollection<Item> implements Iterable {
    private List<Item> container = new ArrayList<Item>();

    public void add(Item i) {
        container.add(i);
    }

    public Iterator<Item> getIterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<Item> {

        private Iterator<Item> iter;

        public MyIterator() {
            iter = container.iterator();
        }

        public boolean hasNext() {
            return iter.hasNext();
        }

        public Item next() {
            return iter.next();
        }

        public void remove() {
        }
    }
}
