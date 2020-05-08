import java.util.*;
class Node{
	int data;
	Node lchild;
	Node rchild;
	public Node(int data){
		this.data=data;
		this.lchild=null;
		this.rchild=null;
	}
}
class Nodeq{
	Node data;
	Nodeq next;
}
public class BinarysearchTree{
	static Scanner sc=new Scanner(System.in);
		public static void main(String[] arhs){
			Tree t=new Tree();
			t.create();
			t.display(t.Root());
			//System.out.println("Enter the Searching Key From  Recursive Function");
			// Node n=t.Rsearch(t.Root(),sc.nextInt());
			// if(n==null)
				// System.out.println("NOT FOUND");
			// else
				// System.out.println("Element is Found at :- "+n);
			// System.out.println("Enter the Searching Key From  Iterative Function");
			// Node n1=t.Isearch(t.Root(),sc.nextInt());
			// if(n1==null)
				// System.out.println("Element NOT FOUND");
			// else
				// System.out.println("Element is Found at :- "+n);
			System.out.println("Enter the element which u want to insert");
			t.Rinsert(t.Root(),sc.nextInt());
			System.out.println("\n\nItration funcation DISPLAY");
			t.display(t.Root());
		}
}
class Tree{
	Node root;
	Node p;
	Node k=null;//this is using for recursive display function
	Scanner sc=new Scanner(System.in);
	Queue q=new Queue();
	public void create(){
		Node t;
		System.out.println("Enter the root node of BST");
		int x;
		x=sc.nextInt();
		root=new Node(x);
		q.enqueue(root);
		while(!q.isEmpty()){
			p=q.dequeue();
			System.out.println("Enter the left child of"+p.data);
			x=sc.nextInt();
			if(x!=-1){
				t=new Node(x);
				p.lchild=t;
				q.enqueue(t);
			}
			System.out.println("enter the Right child of "+p.data);
			x=sc.nextInt();
			if(x!=-1){
				t=new Node(x);
				p.rchild=t;
				q.enqueue(t);
			}
		}
	}
	public Node Root(){
		return root;
	}
	public void display(Node n){
		if(n!=null){
			display(n.lchild);
			System.out.println(n.data);
			display(n.rchild);
		}
	}
	//Recursive Seacrch
	public Node Rsearch(Node n,int key){
		if(n!=null){
			if(key==n.data){
				return n;
			}else if(key>n.data){
				return Rsearch(n.rchild,key);
			}else{
				return Rsearch(n.lchild,key);
			}
		}return null;
	}
	//Iterative Search
	public Node Isearch(Node n,int key){
		while(n!=null){
			if(n.data==key)
				return n;
			else if(key>n.data)
				n=n.rchild;
			else
				n=n.lchild;
		}return null;
	}
	//Insert Funtion
	public void insert(int key){
		Node n=root;
		Node r=null;
		while(n!=null){
			r=n;
			if(key==n.data)
				return;
			else if(key>n.data)
				n=n.rchild;
			else 
				n=n.lchild;
		}
		Node node=new Node(key);
		if (r.data>key)
			r.lchild=node;
		else
			r.rchild=node;
	}
	//Recursive Insert
	public Node Rinsert(Node n,int key){
		Node node=null;
		if (n==null){
			node =new Node(key);
			return node;
		}
		if(key>n.data)
			n.rchild= Rinsert(n.rchild,key);
		else if(key<n.data)
			n.lchild= Rinsert(n.lchild,key);
		return n;
	}
 }
class Queue{
	Nodeq front;
	Nodeq rear;
	public void enqueue(Node data){
		Nodeq node=new Nodeq();
		if(node==null){
			System.out.println("OverFLow COndtion");
		}else{
			node.data=data;
			node.next=null;
			if(front==null){
				front=node;
				rear=node;
			}else{
				rear.next=node;
				rear=node;
			}
		}
	}
	public Node dequeue(){
		Node x=null;
		if(front==null){
			System.out.println("UnderFLow COndition");
		}else{
			Nodeq t=front;
			x=t.data;
			front=front.next;
			t=null;
		}return x;
	}
	public boolean isEmpty(){
		if(front==null)
			return true;
		return false;
	}
}
