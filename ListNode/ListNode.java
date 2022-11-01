package ListNode;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public String getSumReversedAsString(ListNode node) {
        ListNode currNode = node;
        StringBuilder stringList = new StringBuilder();

        while (currNode.next != null) {
            if (currNode.val == 0) {
                continue;
            }

            stringList.append(currNode.val);
            currNode = currNode.next;
        }

        stringList.append(currNode.val);

        return stringList.reverse().toString();
    }

    public ListNode convertTotalToNodes(String total) {
        int headValue = Integer.parseInt(String.valueOf(total.charAt(total.length() - 1)));
        ListNode nodeRev = new ListNode();

        ListNode head = new ListNode(headValue, nodeRev);

        for (int i = total.length() - 2; i >= 0; i--) {
            int value = Integer.parseInt(String.valueOf(total.charAt(i)));

            nodeRev.val = value;

            if (nodeRev.next == null && i != 0) {
                nodeRev.next = new ListNode();
                nodeRev = nodeRev.next;
            }
        }

        return head;
    }

    // only useful for creating new Nodes for test cases 
    public ListNode convertStringToNode(String num) {
        int headValue = Integer.parseInt(String.valueOf(num.charAt(0)));
        ListNode nodeRev = new ListNode();
        ListNode head = new ListNode(headValue, nodeRev);

        for (int i = 1; i < num.length(); i++) {
            int value = Integer.parseInt(String.valueOf(num.charAt(i)));

            nodeRev.val = value;

            if (nodeRev.next == null && i != num.length() - 1) {
                nodeRev.next = new ListNode();
                nodeRev = nodeRev.next;
            }
        }

        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        long totalOne = Long.parseLong(getSumReversedAsString(l1));
        long totalTwo = Long.parseLong(getSumReversedAsString(l2));

        Long total = totalOne + totalTwo;
        int singleNodesTotal = l1.val + l2.val;

        ListNode newNode;
        if (l1.next == null && l2.next == null && singleNodesTotal < 10) {
            newNode = new ListNode(singleNodesTotal);
        } else {
            newNode = convertTotalToNodes(total.toString());
        }

        return newNode;
    }
}

class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = solution.convertStringToNode("0");
        ListNode l2 = solution.convertStringToNode("0");

        ListNode sumNode = solution.addTwoNumbers(l1, l2);

        System.out.println();
    }
}