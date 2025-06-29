class MinStack {
    int min;
    Node tos;

    class Node {
        int data;
        Node next;
        int currentMin;

        public Node(int data, int currentMin) {
            this.data = data;
            this.currentMin = currentMin;
            this.next = null;
        }
    }

    public MinStack() {
    }

    public void push(int val) {

        if (tos == null) {
            min = val;
            tos = new Node(val, min);
        } else {
            if (val < min) {
                min = val;
            }
            Node newNode = new Node(val, min);
            newNode.next = tos;
            tos = newNode;
        }
    }

    public void pop() {
        if (tos != null) {
            Node temp = tos.next;
            tos.next = null;
            tos = temp;
            if (tos != null) {
                min = tos.currentMin;
            }
        }
    }

    public int top() {
        return tos.data;
    }

    public int getMin() {
        return tos.currentMin;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */