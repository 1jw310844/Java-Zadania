public class Kontener01 {
    private int[] tab;

    public Kontener01(int size) {
        tab = new int[size];
    }

    public int get(int index) {
        if (index < 0 || index >= tab.length) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return tab[index];
    }

    public void set(int index, int value) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be negative");
        }
        if (index >= tab.length) {
            resize(index + 1); // Zwiększamy do index+1, żeby zmieścić nową wartość
        }
        tab[index] = value;
    }

    private void resize(int newSize) {
        int[] newTab = new int[newSize];
        for (int i = 0; i < tab.length; i++) {
            newTab[i] = tab[i];
        }
        tab = newTab;
    }

    public int size() {
        return tab.length;
    }
}
