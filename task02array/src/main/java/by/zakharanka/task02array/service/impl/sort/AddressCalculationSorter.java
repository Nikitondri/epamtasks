package by.zakharanka.task02array.service.impl.sort;

import by.zakharanka.task02array.entity.Array;
import by.zakharanka.task02array.entity.exception.EntityException;
import by.zakharanka.task02array.service.exception.ServiceException;

public class AddressCalculationSorter implements Sort{

    @Override
    public void sort(Array<Integer> array) throws EntityException, ServiceException {
        int n = array.getSize();
        sortImpl(array, n);
    }

    private void sortImpl(Array<Integer> array,int n) throws EntityException {
        int i;
        int j;
        int x;

        SortedLinkedList[] list = new SortedLinkedList[6];
        for (i = 0; i < 6; i++)
            list[i] = new SortedLinkedList();

        Integer large = 0;
        for (i = 0; i < n; i++)
        {
            if (array.getElement(i) > large) {
                large = array.getElement(i);
            }

        }

        for (i = 0; i < n; i++)
        {
            x = hash(array.getElement(i), large);
            list[x].insertInOrder(array.getElement(i));
        }

        Node p;
        i = 0;
        for (j = 0; j <= 5; j++)
        {
            p = list[j].getStart();
            while (p != null)
            {
                array.setElement(i++, p.info);
                p = p.link;
            }
        }
    }

    private int hash(int x, int large){
        float temp;
        temp = (float)x / large;
        return (int)(temp * 5);
    }

    public static class Node{
        private final int info;
        private Node link;

        public Node(int i)
        {
            info = i;
            link = null;
        }
    }

    public static class SortedLinkedList{
        private Node start;

        public Node getStart() {
            return start;
        }

        public SortedLinkedList()
        {
            start = null;
        }

        public void insertInOrder(int data)
        {
            Node p;
            Node temp;
            temp = new Node(data);

            if(start==null || data < start.info)
            {
                temp.link = start;
                start = temp;
                return;
            }
            p = start;
            while (p.link != null && p.link.info <= data)
                p = p.link;
            temp.link = p.link;
            p.link = temp;
        }
    }
}
