package org.example.task;

public class TaskList {

    //Copy List
    public static ListNode copyListNode(ListNode list1) {
        ListNode head = new ListNode(list1.val);
        ListNode current = head;
        ListNode previous = current;
        list1 = list1.next;

        while (list1 != null) {
            current = new ListNode(list1.val);
            previous.next = current;
            previous = current;
            list1 = list1.next;
        }
        return head;
    }

    //876. Middle of the Linked List
    public static ListNode middleNode876(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while ((fast != null) && (fast.next != null)) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //21. Merge Two Sorted Lists
    public static ListNode mergeTwoLists21(ListNode list1, ListNode list2) {
        ListNode headMerged = new ListNode();
        ListNode currentMerged = null;
        ListNode previousMerged = null;
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val <= list2.val) {
            headMerged.val = list1.val;
            currentMerged = headMerged;
            previousMerged = currentMerged;
            list1 = list1.next;
        } else {
            headMerged.val = list2.val;
            currentMerged = headMerged;
            previousMerged = currentMerged;
            list2 = list2.next;
        }

        while ((list1 != null) && (list2 != null)) {
            if (list1.val <= list2.val) {
                currentMerged = new ListNode(list1.val);
                previousMerged.next = currentMerged;
                previousMerged = currentMerged;
                list1 = list1.next;
            } else {
                currentMerged = new ListNode(list2.val);
                previousMerged.next = currentMerged;
                previousMerged = currentMerged;
                list2 = list2.next;
            }

        }

        if (list1 != null) {
            previousMerged.next = list1;
        }
        if (list2 != null) {
            previousMerged.next = list2;
        }
        return headMerged;
    }

    //206. Reverse Linked List
    public static ListNode reverseList206(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode current = new ListNode(head.val);
        ListNode previous = current;

        while (head.next != null) {
            previous = current;
            current = new ListNode(head.next.val, previous);
            head = head.next;
        }
        return current;
    }

    //206. Reverse Linked List
    public static ListNode reverseList206_2(ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    //83. Remove Duplicates from Sorted List
    public static ListNode deleteDuplicates83(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dedupHead = new ListNode(head.val);
        ListNode current = dedupHead;
        ListNode previous = current;
        head = head.next;

        while (head != null) {
            if (head.val != previous.val) {
                current = new ListNode(head.val);
                previous.next = current;
                previous = current;
            }
            head = head.next;
        }
        return dedupHead;
    }

    //203. Remove Linked List Elements
    public static ListNode removeElements203(ListNode head, int val) {
        while ((head != null) && (head.val == val)) {
            head = head.next;
        }

        if (head == null) {
            return head;
        }

        ListNode dedupList = new ListNode(head.val);
        ListNode current = dedupList;
        ListNode previous = current;
        head = head.next;

        while (head != null) {
            if (head.val != val) {
                current = new ListNode(head.val);
                previous.next = current;
                previous = current;
            }
            head = head.next;
        }
        return dedupList;
    }

    //1290. Convert Binary Number in a Linked List to Integer
    public static int getDecimalValue1290(ListNode head) {
        int result = 0;
        while (head != null) {
            result = result * 2 + head.val;
            head = head.next;
        }
        return result;
    }

    //234. Palindrome Linked List
    public static boolean isPalindrome234(ListNode head) {
        ListNode copyHead = head;
        ListNode current = new ListNode(head.val);
        ListNode previous = current;

        while (copyHead.next != null) {
            previous = current;
            current = new ListNode(copyHead.next.val, previous);
            copyHead = copyHead.next;
        }

        ListNode reversed = current;
        while ((reversed.next != null) && (head.next != null)) {
            if (head.val != reversed.val) {
                return false;
            }
            head = head.next;
            reversed = reversed.next;
        }
        return true;
    }

    //160. Intersection of Two Linked Lists
    public static ListNode getIntersectionNode160(ListNode headA, ListNode headB) {
        ListNode lenHeadA = headA;
        ListNode lenHeadB = headB;
        int lenA = 0;
        int lenB = 0;
        while (lenHeadA != null) {
            lenA++;
            lenHeadA = lenHeadA.next;
        }
        while (lenHeadB != null) {
            lenB++;
            lenHeadB = lenHeadB.next;
        }
        if (lenA < lenB) {
            while (lenA != lenB) {
                headB = headB.next;
                lenB--;
            }
        }
        if (lenA > lenB) {
            while (lenB != lenA) {
                headA = headA.next;
                lenA--;
            }
        }
        while ((headA != null) && (headB != null)) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    //141. Linked List Cycle
    public static boolean hasCycle141(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while ((fast != null) && (fast.next != null)) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    //2181. Merge Nodes in Between Zeros
    public static ListNode mergeNodes2181(ListNode head) {
        ListNode result = new ListNode();
        ListNode current = result;

        int sum = 0;
        head = head.next;
        while (head != null) {
            if (head.val == 0) {
                current.val = sum;
                sum = 0;
                if (head.next != null) {
                    current.next = new ListNode();
                    current = current.next;
                }
            } else {
                sum += head.val;
            }
            head = head.next;
        }

        return result;
    }

    //2130. Maximum Twin Sum of a Linked List
    public static int pairSum2130(ListNode head) {
        ListNode reversed = new ListNode(head.val);
        ListNode previous = reversed;
        ListNode straight = head;

        int count = 0;
        while (head.next != null) {
            previous = reversed;
            reversed = new ListNode(head.next.val, previous);
            head = head.next;
            count++;
        }

        int middle = count / 2;
        count = 0;
        int maxSum = 0;
        int curSum = 0;
        while (count <= middle) {
            curSum = straight.val + reversed.val;
            if (maxSum < curSum) {
                maxSum = curSum;
            }
            reversed = reversed.next;
            straight = straight.next;
            count++;
        }
        return maxSum;
    }

    //1669. Merge In Between Linked Lists
    public static ListNode mergeInBetween1669(ListNode list1, int a, int b, ListNode list2) {
        ListNode firstPoint1 = list1;
        ListNode secondPoint1 = list1;
        ListNode firstPoint2 = list2;
        ListNode secondPoint2 = list2;
        int count = 0;

        while (count < a - 1) {
            firstPoint1 = firstPoint1.next;
            secondPoint1 = secondPoint1.next;
            count++;
        }

        while (count <= b) {
            secondPoint1 = secondPoint1.next;
            count++;
        }

        while (secondPoint2.next != null) {
            secondPoint2 = secondPoint2.next;
        }
        secondPoint2.next = secondPoint1;
        firstPoint1.next = firstPoint2;

        return list1;
    }


    //1721. Swapping Nodes in a Linked List
    public static ListNode swapNodes1721(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }

        ListNode firstList = fast;
        int swap = firstList.val;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        firstList.val = slow.val;
        slow.val = swap;

        return head;
    }

    //328. Odd Even Linked List
    public static ListNode oddEvenList328(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }
        int i = 0;
        ListNode last = head;
        while (last.next != null) {
            i++;
            last = last.next;
        }

        ListNode current = head;
        if (i % 2 == 0) {
            i = (i / 2);
        } else {
            i = (i / 2) + 1;
        }
        while (i > 0) {
            last.next = current.next;
            current.next = current.next.next;
            last = last.next;
            current = current.next;
            i--;
        }

        last.next = null;
        return head;
    }

}
