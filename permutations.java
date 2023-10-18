//issue #137


import java.util.Scanner;

public class BeautifulPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Read the integer n

        // If n is 1, it's already a beautiful permutation
        if (n == 1) {
            System.out.println("1");
        } else if (n <= 3) {
            // Permutations for n = 2 and n = 3 are not possible
            System.out.println("NO SOLUTION");
        } else {
            // Initialize two counters for even and odd numbers
            int even = 2;
            int odd = 1;

            // First, print even numbers
            while (even <= n) {
                System.out.print(even + " ");
                even += 2;
            }

            // Then, print odd numbers
            while (odd <= n) {
                System.out.print(odd + " ");
                odd += 2;
            }
        }

        sc.close();
    }
}
