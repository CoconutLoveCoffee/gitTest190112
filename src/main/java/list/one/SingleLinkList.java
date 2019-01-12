package list.one;

public class SingleLinkList {
	   public Node head;
	    public Node current;

	    //方法：向链表中添加数据
	    public void add(int data) {
	        //判断链表为空的时候
	        if (head == null) {//如果头结点为空，说明这个链表还没有创建，那就把新的结点赋给头结点
	            head = new Node(data);
	            current = head;
	        } else {
	            //创建新的结点，放在当前节点的后面（把新的结点合链表进行关联）
	            current.next = new Node(data);
	            //把链表的当前索引向后移动一位
	            current = current.next;   //此步操作完成之后，current结点指向新添加的那个结点
	        }
	    }

	    //方法：遍历链表（打印输出链表。方法的参数表示从节点node开始进行遍历
	    public void print() {
	        if (head == null) {
	            return;
	        }

	        current = head;
	        while (current != null) {
	            System.out.println(current.data);
	            current = current.next;
	        }
	    }

	    //方法：遍历链表（打印输出链表。方法的参数表示从节点node开始进行遍历
	    public void print(Node node) {
	        if (node == null) {
	            return;
	        }

	        current = node;
	        while (current != null) {
	            System.out.println(current.data);
	            current = current.next;
	        }
	    }

	    class Node {
	        //注：此处的两个成员变量权限不能为private，因为private的权限是仅对本类访问。
	        int data; //数据域
	        Node next;//指针域

	        public Node(int data) {
	            this.data = data;
	        }
	    }
	    
	    //方法：获取单链表的长度
	    public int getLength() {
	        if (head == null) {
	            return 0;
	        }

	        int length = 0;
	        Node current = head;
	        while (current != null) {
	            length++;
	            current = current.next;
	        }

	        return length;
	    }
	    
	    public Node findNode(int k) {
	        if (k == 0 || head == null) {
	            return null;
	        }
	        Node first = head;
	        Node second = head;
	        //让second结点往后挪k-1个位置
	        for (int i = 0; i < k - 1; i++) {
	            System.out.println("i的值是" + i);
	            second = second.next;
	            if (second == null) { //说明k的值已经大于链表的长度了
	                //throw new NullPointerException("链表的长度小于" + k); //我们自己抛出异常，给用户以提示
	                return null;
	            }
	        }
	        //让first和second结点整体向后移动，直到second走到最后一个结点
	        while (second.next != null) {
	            first = first.next;
	            second = second.next;
	        }
	        //当second结点走到最后一个节点的时候，此时first指向的结点就是我们要找的结点
	        return first;
	    }
	    
	    //方法：查找链表的中间结点
	    public Node findMidNode() {
	        if (head == null) {
	            return null;
	        }
	        Node first = head;
	        Node second = head;
	        //每次移动时，让second结点移动两位，first结点移动一位
	        while (second != null && second.next != null) {
	            first = first.next;
	            second = second.next.next;
	        }
	        //直到second结点移动到null时，此时first指针指向的位置就是中间结点的位置
	        return first;
	    }
	    
	  //方法：链表的反转
	    public Node reverseList() {

	        //如果链表为空或者只有一个节点，无需反转，直接返回原链表的头结点
	        if (head == null || head.next == null) {
	            return head;
	        }

	        Node current = head;
	        Node next = null; //定义当前结点的下一个结点
	        Node reverseHead = null;  //反转后新链表的表头

	        while (current != null) {
	            next = current.next;  //暂时保存住当前结点的下一个结点，因为下一次要用

	            current.next = reverseHead; //将current的下一个结点指向新链表的头结点
	            reverseHead = current;  

	            current = next;   // 操作结束后，current节点后移
	        }

	        return reverseHead;
	    }
	    
	    public void reversePrint(Node head) {
	        if (head == null) {
	            return;
	        }
	        reversePrint(head.next);
	        System.out.println(head.data);
	    }
	    
	    //方法：判断单链表是否有环
	    public boolean hasCycle() {
	        if (head == null) {
	            return false;
	        }
	        Node first = head;
	        Node second = head;
	        while (second != null) {
	            first = first.next;   //first指针走一步
	            second = second.next.next;  //second指针走两步
	            if (first == second) {  //一旦两个指针相遇，说明链表是有环的
	                return true;
	            }
	        }
	        return false;
	    }
	    
	    public static void main(String[] args) {
	    	SingleLinkList list = new SingleLinkList();
	        //向LinkList中添加数据
	        for (int i = 0; i < 10; i++) {
	            list.add(i);
	        }
//	        System.out.println(list.getLength());
//	        list.print();// 从head节点开始遍历输出
//	        System.out.println(list.findMidNode().data);
	        list.reversePrint(list.head);
	    }

}
