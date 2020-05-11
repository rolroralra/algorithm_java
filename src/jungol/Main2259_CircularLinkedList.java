package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

import javax.print.attribute.standard.Fidelity;

public class Main2259_CircularLinkedList {
	static class MelonField {
		Edge head;
		int size;
		
		public MelonField () {
			head = null;
			size = 0;
		}
		public Edge getNext(int fromIndex, int num) {
			Edge temp = get(fromIndex);
			for (int i = 0 ; i < num; i++) {
				temp = temp.next;
			}
			return temp;
		}
		public Edge get(int index) {
			if (index >= size) {
				return null;
			}
			Edge temp = head;
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
			return temp;
		}
		public void add(Edge e) {
			if (head == null) {
				head = e;
				e.next = head;
				size++;
				return;
			}
			
			Edge temp = head;
			while (temp.next != head) {
				temp = temp.next;
			}
			temp.next = e;
			e. next = head;
			size++;
		}
	}
	static class Edge {
		static final int EAST_DIRECTION = 1;
		static final int WEST_DIRECTION = 2;
		static final int SOUTH_DIRECTION = 3;
		static final int NORTH_DIRECTION = 4;
		int length;	
		int direction;
		Edge next;
		
		public Edge(int length, int direction) {
			this.length = length;
			this.direction = direction;
			next = null;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int numPerArea = Integer.parseInt(in.readLine());
		MelonField field = new MelonField();
		
		int maxHeight = 0;
		int maxWidth = 0;
		int directionMaxHeight = 0;
		int directionMaxWidth = 0;
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int direction = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			field.add(new Edge(length, direction));
			switch (direction) {
			case Edge.EAST_DIRECTION:
			case Edge.WEST_DIRECTION:
				if (maxWidth < length) {
					maxWidth = length;
					directionMaxWidth = direction;
				}
				break;
			case Edge.SOUTH_DIRECTION:
			case Edge.NORTH_DIRECTION:
				if (maxHeight < length) {
					maxHeight = length;
					directionMaxHeight = direction;
				}
				break;
			default:
				throw new Exception("Wrong Direction Input");	
			}
		}
		int directV = 7 - directionMaxHeight;
		int directH = 3 - directionMaxWidth;
		int subArea = 0;
		for (int i = 0; i < 6; i++) {
			if (field.getNext(i, 0).direction == directV && field.getNext(i, 1).direction == directH
			&& field.getNext(i, 2).direction == directV && field.getNext(i, 3).direction == directH) {
				subArea = field.getNext(i, 1).length * field.getNext(i, 2).length;
				break;
			}
			if (field.getNext(i, 0).direction == directH && field.getNext(i, 1).direction == directV
			&& field.getNext(i, 2).direction == directH && field.getNext(i, 3).direction == directV) {
				subArea = field.getNext(i, 1).length * field.getNext(i, 2).length;
				break;
			}
		}
		System.out.println(numPerArea * (maxHeight * maxWidth - subArea));
	}
}