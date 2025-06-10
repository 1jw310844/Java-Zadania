public class Kontener02 {
    private Object[] tab;

    public Kontener02(int size) {
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

    public int size() {
        return tab.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Object o : tab) {
            sb.append(o).append(", ");
        }
        if (tab.length > 0) sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }
}
