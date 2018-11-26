package exp_3;

import exp_3.Queue.LinkedQueue;
import exp_3.Strack.SeqStack;

public class paliindrome_test {
    public static void main(String[] args) {
        LinkedQueue<Character> palindrome = new LinkedQueue<>();
        SeqStack<Character> paliindrome2 = new SeqStack<>();
        String a = "ACBDEDBCA";
        int n = a.length();
        int j = 0;
        for (int i = 0; i < n / 2; i++) {
            palindrome.add(a.charAt(i));
        }
        for (int i = n / 2 + 1; i < n; i++) {
            paliindrome2.push(a.charAt(i));
        }

        while (!palindrome.isEmpty() && !paliindrome2.isEmpty()) {
            if (palindrome.poll() == paliindrome2.pop())
                j++;
        }
        if (j == n / 2)
            System.out.println(a + "\t" + "是回文");
        else
            System.out.println(a + "\t" + "不是回文");


        /*while (!palindrome.isEmpty()) {
            System.out.println(palindrome.poll());
        }
        while (!paliindrome2.isEmpty()) {
            System.out.println(paliindrome2.pop());
        }*/
    }
}