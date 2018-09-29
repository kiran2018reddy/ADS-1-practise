import java.util.Scanner;
import java.util.Arrays;
class LinkedList {
    Node f = null;
    Node l = null;
    int s = 0;
    class Node {
        String data;
        Node next;
        Node(String data) {
            this.data = data; 
        }
    }
    public boolean isEmpty() {
        return s == 0;
    }
    public void push(String element){
        Node newnode = new Node(element);
        if(isEmpty()) {
            f = newnode;
            l = f;
            l.next = null;
            s = s + 1;
            return;
        }
        Node oldlast = l;
        l = newnode;
        oldlast.next = l;
        l.next = null;
        s = s + 1;

    }
    public String pop(){
        if(isEmpty()){
            return null;
        }
        String item = f.data;
        f = f.next;
        s = s - 1;
        return item;

    }
    public void printList() {
        Node pnode = f;       
        while (pnode != null) {
            System.out.print(pnode.data + " ");
            pnode = pnode.next;
        }
        
    }
}
class AddLargeNumbers {
//     private Node firstelement = null;
//     private class Node {
//     }

   /* 1. LinkedList numberToDigits(String number) [1.5 marks]
You were given a string, Iterate over the string and add each digit to a node in the linked
list. Return the linked list object.*/
    /**
     * { function_description }
     *
     * @param      number  The number
     *
     * @return     { description_of_the_return_value }
     */
    public static LinkedList numberToDigits(String number) {
         LinkedList le = new LinkedList();
        String[] numbers = number.split("");
        for(int i = 0; i < numbers.length; i = i + 1) {
            le.push(numbers[i]);
        }
    return le;
}
   /*2. String digitsToNumber(LinkedList number) [1.5 marks]
You were given a linked list object. Iterate over that linked list and append the values of
each node in that linked list to a string.
Return the String containing values of linked list*/ 
/**
 * { function_description }.
 *
 * @param      list  The list.
 *
 * @return     { description_of_the_return_value }.
 */
public static String digitsToNumber(LinkedList list) {
        String number = "";
        while(!list.isEmpty()) {
            }
            return number + list.pop();
    }

    /*3. LinkedList addLargeNumbers(LinkedList, LinkedList) [2 marks]
You were given two linked lists objects which contains digits in each node. Add those
two linked list digits by using a Stacks.*/
/**
 * Adds large numbers.
 *
 * @param      list1  The list 1.
 * @param      list2  The list 2.
 *
 * @return     { description_of_the_return_value }.
 */
    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        return new  LinkedList();
}
}
/**
 * Class for solution.
 */
public class Solution {
    /**
     * { function_description }.
     *
     * @param      args  The arguments.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }
    
}