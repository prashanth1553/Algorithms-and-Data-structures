package com.smi.linkedlist;

public class ReverseLinkedList {

	ListNode head;

	public void add(int data) {
		ListNode newN = new ListNode(data);
		newN.next = head;
		head = newN;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public ListNode get() {
		return head;
	}

	public ListNode poll() {
		ListNode t = head;
		head = head.next;
		return t;

	}

	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public int polindrome(ListNode A) {
		ListNode reverse = reverse(A);
		while (A != null) {
			if (A.val == reverse.val) {
				A = A.next;
				reverse = reverse.next;
			} else {
				break;
			}
		}
		if (A == null) {
			return 1;
		}
		return 0;

	}

	public ListNode getDistinct(ListNode A) {
		ListNode th = A;
		while (A != null && A.next != null) {
			if (A.val == A.next.val) {
				A.next = A.next.next;
			} else {
				A = A.next;
			}
		}
		return th;
	}

	public ListNode getUniqueElements(ListNode A) {
		ListNode dummy = new ListNode(-1);
		ListNode temp = dummy;
		boolean isDuplicateFound = false;
		while (A != null) {
			while (A.next != null && A.val == A.next.val) {
				isDuplicateFound = true;
				A = A.next;
			}
			if (!isDuplicateFound) {
				temp.next = A;
				temp = temp.next;
			}
			A = A.next;
			isDuplicateFound = false;
		}
		if (temp != null) {
			temp.next = null;
		}

		return dummy.next;
	}

	public ListNode reverse(ListNode a) {
		ListNode aT = a;
		ListNode previous = null;
		while (aT != null) {
			ListNode t = new ListNode(aT.val);
			aT = aT.next;
			t.next = previous;
			previous = t;
		}
		return previous;

	}

	public ListNode mergeTwoLists(ListNode A, ListNode B) {
		ListNode dummy = new ListNode(-1);
		ListNode tDummy = dummy;
		while (A != null && B != null) {
			if (A.val < B.val) {
				tDummy.next = A;
				A = A.next;
			} else {
				tDummy.next = B;
				B = B.next;
			}
			tDummy = tDummy.next;
		}
		if (A != null) {
			tDummy.next = A;
		}
		if (B != null) {
			tDummy.next = B;
		}
		return dummy.next;
	}

	public ListNode removeNthFromEnd(ListNode A, int B) {
		int size = 0;
		ListNode tempA = A;
		while (tempA != null) {
			tempA = tempA.next;
			size++;
		}
		tempA = A;
		int r = size - B + 1;
		if (r == 1 || B > size) {
			return A.next;
		}
		while (r > 2 && tempA != null) {
			tempA = tempA.next;
			r--;
		}
		tempA.next = tempA.next.next;
		return A;

	}

	public ListNode rotateRight(ListNode A, int B) {

		int size = 0;
		ListNode tempA = A;
		while (tempA != null) {
			tempA = tempA.next;
			size++;
		}

		B = B % size;
		if (B == 0) {
			return A;
		}
		int r = size - B + 1;
		ListNode aT = A;
		while (r > 2) {
			aT = aT.next;
			r--;
		}
		ListNode s = aT.next;
		aT.next = null;
		ListNode sT = s;
		while (sT.next != null) {
			sT = sT.next;
		}
		sT.next = aT;
		return s;

	}

	public ListNode reverseBetween(ListNode A, int B, int C) {
		if (B == C) {
			return A;
		}
		int Z = B;
		ListNode aT = new ListNode(-1);
		aT.next = A;
		A = aT;

		while (Z > 1) {
			aT = aT.next;
			Z--;
		}
		A = A.next;
		ListNode start = aT.next;
		aT.next = null;

		ListNode cStart = start;
		int p = C - B;
		ListNode reverse = null;
		ListNode cStartNextT = null;

		while (p > 1) {
			cStartNextT = cStart.next;
			cStart.next = reverse;
			reverse = cStart;
			cStart = cStartNextT;
			p--;
		}

		ListNode end = cStart.next;
		cStart.next = null;
		ListNode endNext = end.next;
		end.next = reverse;
		reverse = end;
		start.next = endNext;

		if (B == 1) {
			return reverse;
		}
		aT.next = reverse;

		return A;
	}

	public ListNode swapPairs(ListNode A) {
		if (A == null || A.next == null) {
			return A;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = A;
		ListNode tDummy = dummy;
		while (tDummy != null && tDummy.next != null && tDummy.next.next != null) {
			ListNode a = tDummy.next;
			ListNode b = a.next;
			ListNode next = b.next;
			tDummy.next = b;
			b.next = a;
			a.next = next;
			tDummy = a;
		}

		return dummy.next;
	}

	public ListNode addTwoNumbers(ListNode A, ListNode B) {
		if (A == null) {
			return B;
		}
		if (B == null) {
			return A;
		}
		int carray = 0;
		ListNode aT = A;
		ListNode aPrevious = A;
		while (A != null && B != null) {
			int sum = A.val + B.val + carray;
			A.val = sum % 10;
			carray = sum / 10;
			aPrevious = A;
			A = A.next;
			B = B.next;
		}
		while (A != null) {
			int sum = A.val + carray;
			A.val = sum % 10;
			carray = sum / 10;
			A = A.next;
		}
		if (B != null) {
			A = aPrevious;
		}
		while (B != null) {
			int sum = B.val + carray;
			ListNode next = new ListNode(sum % 10);
			A.next = next;
			A = A.next;
			B = B.next;
			carray = sum / 10;
		}
		if (carray != 0) {
			ListNode next = new ListNode(carray);
			A.next = next;
		}

		return aT;

	}

	public ListNode lessThanABefore(ListNode A, int B) {
		if (A == null) {
			return A;
		}
		ListNode smallerHead = null, smallerLast = null;
		ListNode greaterLast = null, greaterHead = null;
		while (A != null) {
			if (A.val < B) {
				if (smallerHead == null) {
					smallerHead = smallerLast = A;
				} else {
					smallerLast.next = A;
					smallerLast = smallerLast.next;
				}
			} else {
				if (greaterHead == null) {
					greaterHead = greaterLast = A;
				} else {
					greaterLast.next = A;
					greaterLast = greaterLast.next;
				}

			}

			A = A.next;

		}
		if (smallerHead == null) {
			return greaterHead;
		}
		if (greaterHead == null) {
			return smallerHead;
		}

		greaterLast.next = null;
		smallerLast.next = greaterHead;

		return smallerLast;
	}

	public ListNode insertionSortList(ListNode A) {
		if (A == null || A.next == null) {
			return A;
		}
		ListNode sorted = null;
		while (A != null) {
			ListNode aT = A.next;
			A.next = null;
			if (sorted == null || sorted.val > A.val) {
				A.next = sorted;
				sorted = A;
			} else {
				ListNode headT = sorted;
				while (headT.next != null && headT.next.val < A.val) {
					headT = headT.next;
				}
				A.next = headT.next;
				headT.next = A;
			}

			A = aT;

		}

		return sorted;
	}

	public ListNode detectCycle(ListNode a) {
		if (a == null || a.next == null)
			return a;
		ListNode slow = a, fast = a;
		slow = slow.next;
		fast = fast.next.next;
		while (fast != null && fast.next != null) {
			if (slow == fast) {
				break;
			}
			slow = slow.next;
			fast = fast.next.next;

		}

		if (slow == fast) {
			slow = a;
			while (slow.next != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		}

		return null;
	}

	public static void main(String args[]) {
		ReverseLinkedList obj = new ReverseLinkedList();

		obj.add(1);
		
		obj.add(6);
		ListNode last = obj.head;
		obj.add(5);
		obj.add(4);
		obj.add(4);
		obj.add(4);

//		obj.add(1);

//		ReverseLinkedList obj1 = new ReverseLinkedList();
//		obj1.add(1);
//		obj1.add(0);
//		obj1.add(1);

		last.next = obj.head.next;
	//	obj.head = obj.insertionSortList(obj.head);
		System.out.println(obj.detectCycle(obj.head));
//		while (obj.head != null) {
//			System.out.println(obj.head.val);
//			obj.head = obj.head.next;
//		}

	}

}
