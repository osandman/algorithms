package structures.tree;

import java.io.Serializable;
import java.util.*;

public class CustomTree extends AbstractList<String> implements Serializable, Cloneable {
    Entry<String> root;
    List<Entry<String>> tree;
    static long maxPow;

    public CustomTree() {
        tree = new ArrayList<>();
        root = new Entry<>("root");
        tree.add(root);
    }


    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;
        long pow;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }
    }

    public String getParent(String s) {
        for (Entry<String> currentEntry : tree) {
            if (s.equals(currentEntry.elementName)) {
                return currentEntry.parent == null ? "false" : currentEntry.parent.elementName;
            }
        }
        return null;
    }

    @Override
    public boolean add(String elementName) {
        Entry<String> newEntry = new Entry<>(elementName);
        maxPow = 0;
        for (Entry<String> currentEntry : tree) {
            maxPow = Math.max(currentEntry.pow, maxPow);
            if (currentEntry.isAvailableToAddChildren()) {
                newEntry.parent = currentEntry;
                newEntry.pow = currentEntry.pow + 1;
                maxPow = newEntry.pow;
                tree.add(newEntry);
                if (currentEntry.availableToAddLeftChildren) {
                    currentEntry.leftChild = newEntry;
                    currentEntry.availableToAddLeftChildren = false;
                    return true;
                } else if (currentEntry.availableToAddRightChildren) {
                    currentEntry.rightChild = newEntry;
                    currentEntry.availableToAddRightChildren = false;
                    return true;
                }
            }
        }
        for (Entry<String> entry : tree) {
            if (entry.pow == maxPow) {
                entry.availableToAddLeftChildren = true;
                entry.availableToAddRightChildren = true;
                return add(elementName);
            }
        }
        return false;
    }

    public boolean remove(Object o) {
        if (o.getClass() != String.class) {
            throw new UnsupportedOperationException();
        }
        for (Entry<String> entry : tree) {
            if (entry.elementName.equals(o)) {
                removeAllChild(entry);
                break;
            }
        }

        tree.removeIf(current -> current.elementName == null);
        return true;
    }

    private void removeAllChild(Entry<String> entry) {
        entry.elementName = null;
        if (!entry.availableToAddLeftChildren && entry.leftChild.elementName != null) {
            removeAllChild(entry.leftChild);
        }
        if (!entry.availableToAddRightChildren && entry.rightChild.elementName != null) {
            removeAllChild(entry.rightChild);
        }
    }


    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return tree.size() - 1;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
