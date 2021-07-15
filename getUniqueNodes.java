// Time Complexity: O(M * N), M is the size of list1 and N is the size of list 2 
// Space Complexity: O(1), constant space

// My Approach: 
// Looping over both the lists and checking for all the elements 
// for both one by one

class Main {  

  static class Node {
    int data;
    Node next;
};
  
static void printList(Node p)
{
    if (p == null) {
        System.out.print("[]");
    }
  
    while (p != null) {
        System.out.print(p.data+ "->");
        p = p.next;
    }
}
  
static Node push(Node head_ref,
          int new_data)
{
    Node new_node = new Node();
  
    new_node.data = new_data;
    new_node.next = head_ref;
    head_ref = new_node;
    return head_ref;
}
  
static Node traverse(Node head3,
              Node temp1,
              Node temp2)
{
  
    while (temp1 != null) {
  
        int val = temp1.data;
        Node t = temp2;
        int x = 0;
  
        while (t != null) {
            if (t.data == val) {
                x = 1;
                break;
            }
            t = t.next;
        }
  
        if (x == 0) {
            head3 = push(head3, temp1.data);
        }
  
        temp1 = temp1.next;
    }
    return head3;
}
  
static void removeCommonNodes(Node head1,
                       Node head2)
{
  
    Node head3 = null;
  
    head3 = traverse(head3, head1, head2);
  
    head3 = traverse(head3, head2, head1);
  
    printList(head3);
}
  
public static void main(String[] args)
{
  
    Node head1 = new Node();
    head1 = push(head1, 2);
    head1 = push(head1, 3);
    head1 = push(head1, 1);
  
    Node head2 = new Node();
    head2 = push(head2, 1);
    head2 = push(head2, 3);
    head2 = push(head2, 2);
  
    removeCommonNodes(head1, head2);
}

}


