package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class EdList{
	
	public int size;
	private Node cursor;

	private Node head,tail;
	
	public EdList(){
		size=0;
		head=new Node();
		tail=new Node();
		head.next=tail;
		tail.prev=head;
		cursor=head;
	}
	
	class Node{
		char data;
		Node next, prev;
		public Node() {
			this(' ');
		}
		public Node(char d) {
			data=d;
			prev=null;
			next=null;
		}
	}
	
	public void goPrint() {
		cursor=head.next;
		while(cursor!=tail) {
			System.out.print(cursor.data);
			cursor=cursor.next;
		}
		System.out.println();
	}
	
	public void goLeft() {
		if(cursor!=head) cursor=cursor.prev;
	}
	
	public void goRight() {
		if(cursor.next!=tail) cursor=cursor.next;
	}
	
	public void add(char d) {
		Node newN=new Node(d);
		Node temp=cursor;
		newN.prev=temp;
		newN.next=temp.next;
		temp.next.prev=newN;
		temp.next=newN;
		cursor=newN;
		size++;
	}
	
	public void delete() {
		if(cursor!=head) {
			Node temp=cursor;
			temp.prev.next=temp.next;
			temp.next.prev=temp.prev;
			cursor=temp.prev;
			temp=null;
			size--;
		}
	}
}

public class Editor {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String cs=br.readLine();
		
		EdList el=new EdList();
	
		for(int i=0;i<cs.length();i++) {
		
			el.add(cs.charAt(i));
		}
		
		
		int n=Integer.parseInt(br.readLine());
		while(n-->0) {
			String s=br.readLine();
			if(s.equals("L")) {
				el.goLeft();
			}
			else if(s.equals("D")) {
				el.goRight();
			}
			else if(s.equals("B")) {
				el.delete();
			}
			else{
				String a=s.split(" ")[1];
				el.add(a.charAt(0));
			}
		}
		
		el.goPrint();
		
		System.out.println();
		
	}
}

