import java.util.Iterator;

public class Kontener03 implements Iterable<Object> {
    private Object[] tab;

    public Kontener03(int size) {
        tab = new Object[size];
    }

    public Object get(int index) {
        if (index < 0 || index >= tab.length) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return tab[index];
    }

    public void set(int index, Object value) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        if (index >= tab.length) {
            resize(index + 1);
        }
        tab[index] = value;
    }

    private void resize(int newSize) {
        Object[] newTab = new Object[newSize];
        for (int i = 0; i < tab.length; i++) {
            newTab[i] = tab[i];
        }
        tab = newTab;
    }

    @Override
    public Iterator<Object> iterator() {
        return new Iterator<Object>() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return position < tab.length && tab[position] != null;
            }

            @Override
            public Object next() {
                return tab[position++];
            }
        };
    }
}
