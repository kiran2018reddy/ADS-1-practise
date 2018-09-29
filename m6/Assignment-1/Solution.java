import java.util.Scanner;
/**
 * Class for add large numbers.
 */
class AddLargeNumbers {
    /**
     * Constructs the object.
     */
    private AddLargeNumbers() {

    }
    /**
     * { function_description }.
     *
     * @param      number  The number
     *
     * @return     { description_of_the_return_value }
     */
    public static LinkedList numberToDigits(String number) {
        LinkedList le = new LinkedList();
        String[] numbers = number.split("");
        for (int i = 0; i < numbers.length; i++) {
            le.push(numbers[i]);
        }
        return le;
    }
    /**
     * { function_description }.
     *
     * @param      list  The list
     *
     * @return     { description_of_the_return_value }
     */
    public static String digitsToNumber(LinkedList list) {
        String number = "";
        while (!list.isEmpty()) {
        }
        return number + list.pop();
    }
    /**
     * Adds large numbers.
     *
     * @param      list1  The list 1
     * @param      list2  The list 2
     *
     * @return     { description_of_the_return_value }
     */
    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        final int ten = 10;
        Stack s1 = new Stack();
        Stack s2 = new Stack();
        if (list2.size > list1.size) {
            int d = list2.size - list1.size;
            while (d > 0) {
                s1.push(0);
                d = d - 1;
            }
        }

        while (!list1.isEmpty()) {
            String number = list1.pop();
            s1.push(Integer.parseInt(number));
        }
        while (!list2.isEmpty()) {
            String number = list2.pop();
            s2.push(Integer.parseInt(number));
        }
        }
}