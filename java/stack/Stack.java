public class Stack {

    Node firstNode;

    public static void main(String args[]) {
        Stack stack = new Stack();
        stack.push("aaa");
        stack.push("bbb");

        stack.iterator();

        System.out.println("-------------------");

        stack.pop();
        stack.push("ccccc");
        stack.push("ddddd");

        stack.iterator();
    }

    public void push(Object o) {
        if (this.firstNode == null) {
            this.firstNode = new Node(o);
            return;
        }

        Node newNode = new Node(o);
        newNode.nextNode = this.firstNode;
        this.firstNode = newNode;
    }

    public void pop() {
        Node fNode = this.firstNode;
        Node nNode = fNode.nextNode;
        this.firstNode = nNode;
    }

    public void iterator() {
        Node n = this.firstNode;
        while (true) {
            System.out.println(n);
            n = n.nextNode;
            if (n == null) {
                return;
            }
        }
    }
}

class Node {
    Object o;
    Node nextNode = null;

    Node(Object o) {
        this.o = o;
    }

    public String toString() {
        return this.o.toString();
    }
}