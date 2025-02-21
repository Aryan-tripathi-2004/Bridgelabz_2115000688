class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class FindNthFromEnd{
    private static Node findNth(Node head,int n){
        Node slow = head;
        Node fast = head;

        for(int i=0;i<n;i++){
            if(fast==null){
                System.out.println("list is tooo small");
                return new Node(-1);
            }
            fast = fast.next;
        }

        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
    public static void main(String args[]){
        int arr[] = new int[]{1,2,3,4,5,6};
        int n = 6;

        Node head = new Node(arr[0]);
        Node curr = head;

        for(int i=1;i<arr.length;i++){
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }

        Node ans = findNth(head,n);
        System.out.println(ans.data);
    }
}