public class LinkedListTest
{
    Node head;
    int count;

    public LinkedListTest ()
    {
        head = null;
        count = 0;
    }

    /**
     * Adds the given item to the start of the list
     */
    public void addToStart (int item)
    {
        Node newNode = new Node();
        newNode.value = item;

        if (head != null)
            newNode.next = head;

        head = newNode;
        count++;
    }

    /**
     * Adds the given item to the end of the list
     */
    public void addToEnd (int item)
    {
        if (size() == 0)
        {
            addToStart (item);
        }
        else
        {
            Node n = head;
            while (n.next != null)
                n = n.next;

            n.next = new Node(item);
            count++;
        }
    }

    /**
     * Remove and return the first item in the list
     */
    public int removeFromStart ()
    {
        if (size() == 0)
            throw new EmptyListException();

        int valtoReturn = head.value;
        head = head.next;
        count--;
        return valtoReturn;
    }

    /**
     * Remove and return the last item in the list
     */
    public int removeFromEnd ()
    {
        if (size() == 0)
            throw new EmptyListException();
        if (size() == 1)
            return removeFromStart();
        else
        {
            Node n = head;
            while (n.next.next != null)
                n = n.next;

            int valtoReturn = n.next.value;
            n.next = null;
            count--;
            return valtoReturn;
        }
    }

    /**
     * Return the number of items contained in this list
     */
    public int size ()
    {
        return count;
    }

    /**
     * A basic node class
     */
    private class Node
    {
        int value;
        Node next;

        Node()
        {
        }

        Node (int value)
        {
            this.value = value;
        }
    }

    // random testing code for the Linked List
    public static void main (String [] args)
    {
        LinkedListTest l = new LinkedListTest();

        l.addToStart (5);
        int val = l.removeFromStart();
        System.out.println (val == 5 ? "passed" : "failed");

        System.out.println (l.size() == 0 ? "passed" : "failed");

        for (int x = 0; x < 10; x++)
            l.addToEnd (x);

        System.out.println (l.size() == 10 ? "passed" : "failed");
        while (l.size() > 0)
            System.out.print (l.removeFromEnd() + " ");
        System.out.println ();
    }
}

/**
 * The exception class when a removal action is performed on
 *  an empty list.
 */
class EmptyListException extends RuntimeException 
{
    public EmptyListException ()
    {
        super();
    }

    public EmptyListException (String s)
    {
        super(s);
    }
}
