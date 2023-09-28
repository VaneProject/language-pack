import java.util.*;
import java.util.List;

public class LanguageList implements List<String> {
    private final List<List<String>> list = new ArrayList<>();
    private final Country[] countries;

    public LanguageList(Country... countries) {
        if (countries.length < 1) throw new IllegalArgumentException("length size error 1 > " + countries.length);
        this.countries = countries;
        for (int i = 0; i < countries.length; i++) list.add(new ArrayList<>());
    }

    private int getIndex(Country country) {
        for (int i = 0; i < countries.length; i++) {
            if (countries[i] == country) return i;
        }
        throw new RuntimeException("not find Country: " + country);
    }

    private List<String> getList() {
        int i = getIndex(Country.getDefaultCountry());
        return list.get(i);
    }

    @Override
    public int size() {
        return getList().size();
    }

    @Override
    public boolean isEmpty() {
        return getList().isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return getList().contains(o);
    }

    @Override
    public Iterator<String> iterator() {
        return getList().iterator();
    }

    @Override
    public Object[] toArray() {
        return getList().toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return getList().toArray(a);
    }

    public boolean add(String... s) {
        if (s.length != countries.length)
            throw new IllegalArgumentException("do not match size: " + s.length + " != " + countries.length);
        for (int i = 0; i < s.length; i++) list.get(i).add(s[i]);
        return true;
    }

    @Override
    public boolean add(String s) {
        throw new RuntimeException("do not use 'add' method");
    }

    public boolean remove(String... s) {
        if (s.length != countries.length)
            throw new IllegalArgumentException("do not match size: " + s.length + " != " + countries.length);
        for (int i = 0; i < s.length; i++) list.get(i).remove(s[i]);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new RuntimeException("do not use 'remove' method");
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        throw new RuntimeException("do not use 'addAll' method");
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new RuntimeException("do not use 'addAll' method");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new RuntimeException("do not use 'removeAll' method");
    }

    public boolean set(int index, String... s) {
        if (s.length != countries.length)
            throw new IllegalArgumentException("do not match size: " + s.length + " != " + countries.length);
        for (int i = 0; i < s.length; i++) list.get(i).set(index, s[i]);
        return true;
    }

    @Override
    public String set(int index, String element) {
        throw new RuntimeException("do not use 'set' method");
    }

    public boolean add(int index, String... s) {
        if (s.length != countries.length)
            throw new IllegalArgumentException("do not match size: " + s.length + " != " + countries.length);
        for (int i = 0; i < s.length; i++) list.get(i).add(index, s[i]);
        return true;
    }

    @Override
    public void add(int index, String element) {
        throw new RuntimeException("do not use 'add' method");
    }

    @Override
    public String remove(int index) {
        for (int i = 0; i < countries.length; i++) list.get(i).remove(index);
        return "";
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return getList().retainAll(c);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return new HashSet<>(getList()).containsAll(c);
    }

    @Override
    public void clear() {
        for (List<String> l : this.list) l.clear();
    }

    @Override
    public String get(int index) {
        return getList().get(index);
    }

    @Override
    public int indexOf(Object o) {
        return getList().indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return getList().lastIndexOf(o);
    }

    @Override
    public ListIterator<String> listIterator() {
        return getList().listIterator();
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        return getList().listIterator(index);
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return getList().subList(fromIndex, toIndex);
    }
}
