/*
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.zhonghuasheng.sourcecode.java.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable {
    private static final long serialVersionUID = 8683452581122892189L;
    private static final int DEFAULT_CAPACITY = 10; // 初始化默认长度
    private static final Object[] EMPTY_ELEMENTDATA = new Object[0];
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = new Object[0];
    transient Object[] elementData;
    private int size;
    private static final int MAX_ARRAY_SIZE = 2147483639;

    public ArrayList(int var1) {
        if (var1 > 0) {
            this.elementData = new Object[var1];
        } else {
            if (var1 != 0) {
                throw new IllegalArgumentException("Illegal Capacity: " + var1);
            }

            this.elementData = EMPTY_ELEMENTDATA;
        }

    }

    public ArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public ArrayList(Collection<? extends E> var1) {
        this.elementData = var1.toArray();
        if ((this.size = this.elementData.length) != 0) {
            if (this.elementData.getClass() != Object[].class) {
                this.elementData = Arrays.copyOf(this.elementData, this.size, Object[].class);
            }
        } else {
            this.elementData = EMPTY_ELEMENTDATA;
        }

    }

    public void trimToSize() {
        ++this.modCount;
        if (this.size < this.elementData.length) {
            this.elementData = this.size == 0 ? EMPTY_ELEMENTDATA : Arrays.copyOf(this.elementData, this.size);
        }

    }

    public void ensureCapacity(int var1) {
        int var2 = this.elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA ? 0 : 10;
        if (var1 > var2) {
            this.ensureExplicitCapacity(var1);
        }

    }

    private void ensureCapacityInternal(int var1) {
        if (this.elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            var1 = Math.max(10, var1);
        }

        this.ensureExplicitCapacity(var1);
    }

    private void ensureExplicitCapacity(int var1) {
        ++this.modCount;
        if (var1 - this.elementData.length > 0) {
            this.grow(var1);
        }

    }

    private void grow(int var1) {
        int var2 = this.elementData.length;
        int var3 = var2 + (var2 >> 1);
        if (var3 - var1 < 0) {
            var3 = var1;
        }

        if (var3 - 2147483639 > 0) {
            var3 = hugeCapacity(var1);
        }

        this.elementData = Arrays.copyOf(this.elementData, var3);
    }

    private static int hugeCapacity(int var0) {
        if (var0 < 0) {
            throw new OutOfMemoryError();
        } else {
            return var0 > 2147483639 ? 2147483647 : 2147483639;
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean contains(Object var1) {
        return this.indexOf(var1) >= 0;
    }

    public int indexOf(Object var1) {
        int var2;
        if (var1 == null) {
            for(var2 = 0; var2 < this.size; ++var2) {
                if (this.elementData[var2] == null) {
                    return var2;
                }
            }
        } else {
            for(var2 = 0; var2 < this.size; ++var2) {
                if (var1.equals(this.elementData[var2])) {
                    return var2;
                }
            }
        }

        return -1;
    }

    public int lastIndexOf(Object var1) {
        int var2;
        if (var1 == null) {
            for(var2 = this.size - 1; var2 >= 0; --var2) {
                if (this.elementData[var2] == null) {
                    return var2;
                }
            }
        } else {
            for(var2 = this.size - 1; var2 >= 0; --var2) {
                if (var1.equals(this.elementData[var2])) {
                    return var2;
                }
            }
        }

        return -1;
    }

    public Object clone() {
        try {
            ArrayList var1 = (ArrayList)super.clone();
            var1.elementData = Arrays.copyOf(this.elementData, this.size);
            var1.modCount = 0;
            return var1;
        } catch (CloneNotSupportedException var2) {
            throw new InternalError(var2);
        }
    }

    public Object[] toArray() {
        return Arrays.copyOf(this.elementData, this.size);
    }

    public <T> T[] toArray(T[] var1) {
        if (var1.length < this.size) {
            return (Object[])Arrays.copyOf(this.elementData, this.size, var1.getClass());
        } else {
            System.arraycopy(this.elementData, 0, var1, 0, this.size);
            if (var1.length > this.size) {
                var1[this.size] = null;
            }

            return var1;
        }
    }

    E elementData(int var1) {
        return this.elementData[var1];
    }

    public E get(int var1) {
        this.rangeCheck(var1);
        return this.elementData(var1);
    }

    public E set(int var1, E var2) {
        this.rangeCheck(var1);
        Object var3 = this.elementData(var1);
        this.elementData[var1] = var2;
        return var3;
    }

    public boolean add(E var1) {
        this.ensureCapacityInternal(this.size + 1);
        this.elementData[this.size++] = var1;
        return true;
    }

    public void add(int var1, E var2) {
        this.rangeCheckForAdd(var1);
        this.ensureCapacityInternal(this.size + 1);
        System.arraycopy(this.elementData, var1, this.elementData, var1 + 1, this.size - var1);
        this.elementData[var1] = var2;
        ++this.size;
    }

    public E remove(int var1) {
        this.rangeCheck(var1);
        ++this.modCount;
        Object var2 = this.elementData(var1);
        int var3 = this.size - var1 - 1;
        if (var3 > 0) {
            System.arraycopy(this.elementData, var1 + 1, this.elementData, var1, var3);
        }

        this.elementData[--this.size] = null;
        return var2;
    }

    public boolean remove(Object var1) {
        int var2;
        if (var1 == null) {
            for(var2 = 0; var2 < this.size; ++var2) {
                if (this.elementData[var2] == null) {
                    this.fastRemove(var2);
                    return true;
                }
            }
        } else {
            for(var2 = 0; var2 < this.size; ++var2) {
                if (var1.equals(this.elementData[var2])) {
                    this.fastRemove(var2);
                    return true;
                }
            }
        }

        return false;
    }

    private void fastRemove(int var1) {
        ++this.modCount;
        int var2 = this.size - var1 - 1;
        if (var2 > 0) {
            System.arraycopy(this.elementData, var1 + 1, this.elementData, var1, var2);
        }

        this.elementData[--this.size] = null;
    }

    public void clear() {
        ++this.modCount;

        for(int var1 = 0; var1 < this.size; ++var1) {
            this.elementData[var1] = null;
        }

        this.size = 0;
    }

    public boolean addAll(Collection<? extends E> var1) {
        Object[] var2 = var1.toArray();
        int var3 = var2.length;
        this.ensureCapacityInternal(this.size + var3);
        System.arraycopy(var2, 0, this.elementData, this.size, var3);
        this.size += var3;
        return var3 != 0;
    }

    public boolean addAll(int var1, Collection<? extends E> var2) {
        this.rangeCheckForAdd(var1);
        Object[] var3 = var2.toArray();
        int var4 = var3.length;
        this.ensureCapacityInternal(this.size + var4);
        int var5 = this.size - var1;
        if (var5 > 0) {
            System.arraycopy(this.elementData, var1, this.elementData, var1 + var4, var5);
        }

        System.arraycopy(var3, 0, this.elementData, var1, var4);
        this.size += var4;
        return var4 != 0;
    }

    protected void removeRange(int var1, int var2) {
        ++this.modCount;
        int var3 = this.size - var2;
        System.arraycopy(this.elementData, var2, this.elementData, var1, var3);
        int var4 = this.size - (var2 - var1);

        for(int var5 = var4; var5 < this.size; ++var5) {
            this.elementData[var5] = null;
        }

        this.size = var4;
    }

    private void rangeCheck(int var1) {
        if (var1 >= this.size) {
            throw new IndexOutOfBoundsException(this.outOfBoundsMsg(var1));
        }
    }

    private void rangeCheckForAdd(int var1) {
        if (var1 > this.size || var1 < 0) {
            throw new IndexOutOfBoundsException(this.outOfBoundsMsg(var1));
        }
    }

    private String outOfBoundsMsg(int var1) {
        return "Index: " + var1 + ", Size: " + this.size;
    }

    public boolean removeAll(Collection<?> var1) {
        Objects.requireNonNull(var1);
        return this.batchRemove(var1, false);
    }

    public boolean retainAll(Collection<?> var1) {
        Objects.requireNonNull(var1);
        return this.batchRemove(var1, true);
    }

    private boolean batchRemove(Collection<?> var1, boolean var2) {
        Object[] var3 = this.elementData;
        int var4 = 0;
        int var5 = 0;
        boolean var6 = false;

        while(true) {
            boolean var11 = false;

            try {
                var11 = true;
                if (var4 >= this.size) {
                    var11 = false;
                    break;
                }

                if (var1.contains(var3[var4]) == var2) {
                    var3[var5++] = var3[var4];
                }

                ++var4;
            } finally {
                if (var11) {
                    if (var4 != this.size) {
                        System.arraycopy(var3, var4, var3, var5, this.size - var4);
                        var5 += this.size - var4;
                    }

                    if (var5 != this.size) {
                        for(int var9 = var5; var9 < this.size; ++var9) {
                            var3[var9] = null;
                        }

                        this.modCount += this.size - var5;
                        this.size = var5;
                        var6 = true;
                    }

                }
            }
        }

        if (var4 != this.size) {
            System.arraycopy(var3, var4, var3, var5, this.size - var4);
            var5 += this.size - var4;
        }

        if (var5 != this.size) {
            for(int var7 = var5; var7 < this.size; ++var7) {
                var3[var7] = null;
            }

            this.modCount += this.size - var5;
            this.size = var5;
            var6 = true;
        }

        return var6;
    }

    private void writeObject(ObjectOutputStream var1) throws IOException {
        int var2 = this.modCount;
        var1.defaultWriteObject();
        var1.writeInt(this.size);

        for(int var3 = 0; var3 < this.size; ++var3) {
            var1.writeObject(this.elementData[var3]);
        }

        if (this.modCount != var2) {
            throw new ConcurrentModificationException();
        }
    }

    private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException {
        this.elementData = EMPTY_ELEMENTDATA;
        var1.defaultReadObject();
        var1.readInt();
        if (this.size > 0) {
            this.ensureCapacityInternal(this.size);
            Object[] var2 = this.elementData;

            for(int var3 = 0; var3 < this.size; ++var3) {
                var2[var3] = var1.readObject();
            }
        }

    }

    public ListIterator<E> listIterator(int var1) {
        if (var1 >= 0 && var1 <= this.size) {
            return new ArrayList.ListItr(var1);
        } else {
            throw new IndexOutOfBoundsException("Index: " + var1);
        }
    }

    public ListIterator<E> listIterator() {
        return new ArrayList.ListItr(0);
    }

    public Iterator<E> iterator() {
        return new ArrayList.Itr();
    }

    public List<E> subList(int var1, int var2) {
        subListRangeCheck(var1, var2, this.size);
        return new ArrayList.SubList(this, 0, var1, var2);
    }

    static void subListRangeCheck(int var0, int var1, int var2) {
        if (var0 < 0) {
            throw new IndexOutOfBoundsException("fromIndex = " + var0);
        } else if (var1 > var2) {
            throw new IndexOutOfBoundsException("toIndex = " + var1);
        } else if (var0 > var1) {
            throw new IllegalArgumentException("fromIndex(" + var0 + ") > toIndex(" + var1 + ")");
        }
    }

    public void forEach(Consumer<? super E> var1) {
        Objects.requireNonNull(var1);
        int var2 = this.modCount;
        Object[] var3 = (Object[])this.elementData;
        int var4 = this.size;

        for(int var5 = 0; this.modCount == var2 && var5 < var4; ++var5) {
            var1.accept(var3[var5]);
        }

        if (this.modCount != var2) {
            throw new ConcurrentModificationException();
        }
    }

    public Spliterator<E> spliterator() {
        return new ArrayList.ArrayListSpliterator(this, 0, -1, 0);
    }

    public boolean removeIf(Predicate<? super E> var1) {
        Objects.requireNonNull(var1);
        int var2 = 0;
        BitSet var3 = new BitSet(this.size);
        int var4 = this.modCount;
        int var5 = this.size;

        for(int var6 = 0; this.modCount == var4 && var6 < var5; ++var6) {
            Object var7 = this.elementData[var6];
            if (var1.test(var7)) {
                var3.set(var6);
                ++var2;
            }
        }

        if (this.modCount != var4) {
            throw new ConcurrentModificationException();
        } else {
            boolean var10 = var2 > 0;
            if (var10) {
                int var11 = var5 - var2;
                int var8 = 0;

                for(int var9 = 0; var8 < var5 && var9 < var11; ++var9) {
                    var8 = var3.nextClearBit(var8);
                    this.elementData[var9] = this.elementData[var8];
                    ++var8;
                }

                for(var8 = var11; var8 < var5; ++var8) {
                    this.elementData[var8] = null;
                }

                this.size = var11;
                if (this.modCount != var4) {
                    throw new ConcurrentModificationException();
                }

                ++this.modCount;
            }

            return var10;
        }
    }

    public void replaceAll(UnaryOperator<E> var1) {
        Objects.requireNonNull(var1);
        int var2 = this.modCount;
        int var3 = this.size;

        for(int var4 = 0; this.modCount == var2 && var4 < var3; ++var4) {
            this.elementData[var4] = var1.apply(this.elementData[var4]);
        }

        if (this.modCount != var2) {
            throw new ConcurrentModificationException();
        } else {
            ++this.modCount;
        }
    }

    public void sort(Comparator<? super E> var1) {
        int var2 = this.modCount;
        Arrays.sort((Object[])this.elementData, 0, this.size, var1);
        if (this.modCount != var2) {
            throw new ConcurrentModificationException();
        } else {
            ++this.modCount;
        }
    }

    static final class ArrayListSpliterator<E> implements Spliterator<E> {
        private final ArrayList<E> list;
        private int index;
        private int fence;
        private int expectedModCount;

        ArrayListSpliterator(ArrayList<E> var1, int var2, int var3, int var4) {
            this.list = var1;
            this.index = var2;
            this.fence = var3;
            this.expectedModCount = var4;
        }

        private int getFence() {
            int var1 = this.fence;
            if (this.fence < 0) {
                ArrayList var2 = this.list;
                if (this.list == null) {
                    var1 = this.fence = 0;
                } else {
                    this.expectedModCount = var2.modCount;
                    var1 = this.fence = var2.size;
                }
            }

            return var1;
        }

        public ArrayList.ArrayListSpliterator<E> trySplit() {
            int var1 = this.getFence();
            int var2 = this.index;
            int var3 = var2 + var1 >>> 1;
            return var2 >= var3 ? null : new ArrayList.ArrayListSpliterator(this.list, var2, this.index = var3, this.expectedModCount);
        }

        public boolean tryAdvance(Consumer<? super E> var1) {
            if (var1 == null) {
                throw new NullPointerException();
            } else {
                int var2 = this.getFence();
                int var3 = this.index;
                if (var3 < var2) {
                    this.index = var3 + 1;
                    Object var4 = this.list.elementData[var3];
                    var1.accept(var4);
                    if (this.list.modCount != this.expectedModCount) {
                        throw new ConcurrentModificationException();
                    } else {
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }

        public void forEachRemaining(Consumer<? super E> var1) {
            if (var1 == null) {
                throw new NullPointerException();
            } else {
                ArrayList var5 = this.list;
                if (this.list != null) {
                    Object[] var6 = var5.elementData;
                    if (var5.elementData != null) {
                        int var3 = this.fence;
                        int var4;
                        if (this.fence < 0) {
                            var4 = var5.modCount;
                            var3 = var5.size;
                        } else {
                            var4 = this.expectedModCount;
                        }

                        int var2 = this.index;
                        if (this.index >= 0 && (this.index = var3) <= var6.length) {
                            while(var2 < var3) {
                                Object var7 = var6[var2];
                                var1.accept(var7);
                                ++var2;
                            }

                            if (var5.modCount == var4) {
                                return;
                            }
                        }
                    }
                }

                throw new ConcurrentModificationException();
            }
        }

        public long estimateSize() {
            return (long)(this.getFence() - this.index);
        }

        public int characteristics() {
            return 16464;
        }
    }

    private class Itr implements Iterator<E> {
        int cursor;
        int lastRet;
        int expectedModCount;

        private Itr() {
            this.lastRet = -1;
            this.expectedModCount = ArrayList.this.modCount;
        }

        public boolean hasNext() {
            return this.cursor != ArrayList.this.size;
        }

        public E next() {
            this.checkForComodification();
            int var1 = this.cursor;
            if (var1 >= ArrayList.this.size) {
                throw new NoSuchElementException();
            } else {
                Object[] var2 = ArrayList.this.elementData;
                if (var1 >= var2.length) {
                    throw new ConcurrentModificationException();
                } else {
                    this.cursor = var1 + 1;
                    return var2[this.lastRet = var1];
                }
            }
        }

        public void remove() {
            if (this.lastRet < 0) {
                throw new IllegalStateException();
            } else {
                this.checkForComodification();

                try {
                    ArrayList.this.remove(this.lastRet);
                    this.cursor = this.lastRet;
                    this.lastRet = -1;
                    this.expectedModCount = ArrayList.this.modCount;
                } catch (IndexOutOfBoundsException var2) {
                    throw new ConcurrentModificationException();
                }
            }
        }

        public void forEachRemaining(Consumer<? super E> var1) {
            Objects.requireNonNull(var1);
            int var2 = ArrayList.this.size;
            int var3 = this.cursor;
            if (var3 < var2) {
                Object[] var4 = ArrayList.this.elementData;
                if (var3 >= var4.length) {
                    throw new ConcurrentModificationException();
                } else {
                    while(var3 != var2 && ArrayList.this.modCount == this.expectedModCount) {
                        var1.accept(var4[var3++]);
                    }

                    this.cursor = var3;
                    this.lastRet = var3 - 1;
                    this.checkForComodification();
                }
            }
        }

        final void checkForComodification() {
            if (ArrayList.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    private class ListItr extends ArrayList<E>.Itr implements ListIterator<E> {
        ListItr(int var2) {
            super(null);
            this.cursor = var2;
        }

        public boolean hasPrevious() {
            return this.cursor != 0;
        }

        public int nextIndex() {
            return this.cursor;
        }

        public int previousIndex() {
            return this.cursor - 1;
        }

        public E previous() {
            this.checkForComodification();
            int var1 = this.cursor - 1;
            if (var1 < 0) {
                throw new NoSuchElementException();
            } else {
                Object[] var2 = ArrayList.this.elementData;
                if (var1 >= var2.length) {
                    throw new ConcurrentModificationException();
                } else {
                    this.cursor = var1;
                    return var2[this.lastRet = var1];
                }
            }
        }

        public void set(E var1) {
            if (this.lastRet < 0) {
                throw new IllegalStateException();
            } else {
                this.checkForComodification();

                try {
                    ArrayList.this.set(this.lastRet, var1);
                } catch (IndexOutOfBoundsException var3) {
                    throw new ConcurrentModificationException();
                }
            }
        }

        public void add(E var1) {
            this.checkForComodification();

            try {
                int var2 = this.cursor;
                ArrayList.this.add(var2, var1);
                this.cursor = var2 + 1;
                this.lastRet = -1;
                this.expectedModCount = ArrayList.this.modCount;
            } catch (IndexOutOfBoundsException var3) {
                throw new ConcurrentModificationException();
            }
        }
    }

    private class SubList extends AbstractList<E> implements RandomAccess {
        private final AbstractList<E> parent;
        private final int parentOffset;
        private final int offset;
        int size;

        SubList(AbstractList<E> var2, int var3, int var4, int var5) {
            this.parent = var2;
            this.parentOffset = var4;
            this.offset = var3 + var4;
            this.size = var5 - var4;
            this.modCount = ArrayList.this.modCount;
        }

        public E set(int var1, E var2) {
            this.rangeCheck(var1);
            this.checkForComodification();
            Object var3 = ArrayList.this.elementData(this.offset + var1);
            ArrayList.this.elementData[this.offset + var1] = var2;
            return var3;
        }

        public E get(int var1) {
            this.rangeCheck(var1);
            this.checkForComodification();
            return ArrayList.this.elementData(this.offset + var1);
        }

        public int size() {
            this.checkForComodification();
            return this.size;
        }

        public void add(int var1, E var2) {
            this.rangeCheckForAdd(var1);
            this.checkForComodification();
            this.parent.add(this.parentOffset + var1, var2);
            this.modCount = this.parent.modCount;
            ++this.size;
        }

        public E remove(int var1) {
            this.rangeCheck(var1);
            this.checkForComodification();
            Object var2 = this.parent.remove(this.parentOffset + var1);
            this.modCount = this.parent.modCount;
            --this.size;
            return var2;
        }

        protected void removeRange(int var1, int var2) {
            this.checkForComodification();
            this.parent.removeRange(this.parentOffset + var1, this.parentOffset + var2);
            this.modCount = this.parent.modCount;
            this.size -= var2 - var1;
        }

        public boolean addAll(Collection<? extends E> var1) {
            return this.addAll(this.size, var1);
        }

        public boolean addAll(int var1, Collection<? extends E> var2) {
            this.rangeCheckForAdd(var1);
            int var3 = var2.size();
            if (var3 == 0) {
                return false;
            } else {
                this.checkForComodification();
                this.parent.addAll(this.parentOffset + var1, var2);
                this.modCount = this.parent.modCount;
                this.size += var3;
                return true;
            }
        }

        public Iterator<E> iterator() {
            return this.listIterator();
        }

        public ListIterator<E> listIterator(final int var1) {
            this.checkForComodification();
            this.rangeCheckForAdd(var1);
            final int var2 = this.offset;
            return new ListIterator<E>() {
                int cursor = var1;
                int lastRet = -1;
                int expectedModCount;

                {
                    this.expectedModCount = ArrayList.this.modCount;
                }

                public boolean hasNext() {
                    return this.cursor != SubList.this.size;
                }

                public E next() {
                    this.checkForComodification();
                    int var1x = this.cursor;
                    if (var1x >= SubList.this.size) {
                        throw new NoSuchElementException();
                    } else {
                        Object[] var2x = ArrayList.this.elementData;
                        if (var2 + var1x >= var2x.length) {
                            throw new ConcurrentModificationException();
                        } else {
                            this.cursor = var1x + 1;
                            return var2x[var2 + (this.lastRet = var1x)];
                        }
                    }
                }

                public boolean hasPrevious() {
                    return this.cursor != 0;
                }

                public E previous() {
                    this.checkForComodification();
                    int var1x = this.cursor - 1;
                    if (var1x < 0) {
                        throw new NoSuchElementException();
                    } else {
                        Object[] var2x = ArrayList.this.elementData;
                        if (var2 + var1x >= var2x.length) {
                            throw new ConcurrentModificationException();
                        } else {
                            this.cursor = var1x;
                            return var2x[var2 + (this.lastRet = var1x)];
                        }
                    }
                }

                public void forEachRemaining(Consumer<? super E> var1x) {
                    Objects.requireNonNull(var1x);
                    int var2x = SubList.this.size;
                    int var3 = this.cursor;
                    if (var3 < var2x) {
                        Object[] var4 = ArrayList.this.elementData;
                        if (var2 + var3 >= var4.length) {
                            throw new ConcurrentModificationException();
                        } else {
                            while(var3 != var2x && SubList.this.modCount == this.expectedModCount) {
                                var1x.accept(var4[var2 + var3++]);
                            }

                            this.lastRet = this.cursor = var3;
                            this.checkForComodification();
                        }
                    }
                }

                public int nextIndex() {
                    return this.cursor;
                }

                public int previousIndex() {
                    return this.cursor - 1;
                }

                public void remove() {
                    if (this.lastRet < 0) {
                        throw new IllegalStateException();
                    } else {
                        this.checkForComodification();

                        try {
                            SubList.this.remove(this.lastRet);
                            this.cursor = this.lastRet;
                            this.lastRet = -1;
                            this.expectedModCount = ArrayList.this.modCount;
                        } catch (IndexOutOfBoundsException var2x) {
                            throw new ConcurrentModificationException();
                        }
                    }
                }

                public void set(E var1x) {
                    if (this.lastRet < 0) {
                        throw new IllegalStateException();
                    } else {
                        this.checkForComodification();

                        try {
                            ArrayList.this.set(var2 + this.lastRet, var1x);
                        } catch (IndexOutOfBoundsException var3) {
                            throw new ConcurrentModificationException();
                        }
                    }
                }

                public void add(E var1x) {
                    this.checkForComodification();

                    try {
                        int var2x = this.cursor;
                        SubList.this.add(var2x, var1x);
                        this.cursor = var2x + 1;
                        this.lastRet = -1;
                        this.expectedModCount = ArrayList.this.modCount;
                    } catch (IndexOutOfBoundsException var3) {
                        throw new ConcurrentModificationException();
                    }
                }

                final void checkForComodification() {
                    if (this.expectedModCount != ArrayList.this.modCount) {
                        throw new ConcurrentModificationException();
                    }
                }
            };
        }

        public List<E> subList(int var1, int var2) {
            ArrayList.subListRangeCheck(var1, var2, this.size);
            return ArrayList.this.new SubList(this, this.offset, var1, var2);
        }

        private void rangeCheck(int var1) {
            if (var1 < 0 || var1 >= this.size) {
                throw new IndexOutOfBoundsException(this.outOfBoundsMsg(var1));
            }
        }

        private void rangeCheckForAdd(int var1) {
            if (var1 < 0 || var1 > this.size) {
                throw new IndexOutOfBoundsException(this.outOfBoundsMsg(var1));
            }
        }

        private String outOfBoundsMsg(int var1) {
            return "Index: " + var1 + ", Size: " + this.size;
        }

        private void checkForComodification() {
            if (ArrayList.this.modCount != this.modCount) {
                throw new ConcurrentModificationException();
            }
        }

        public Spliterator<E> spliterator() {
            this.checkForComodification();
            return new ArrayList.ArrayListSpliterator(ArrayList.this, this.offset, this.offset + this.size, this.modCount);
        }
    }
}
*/
