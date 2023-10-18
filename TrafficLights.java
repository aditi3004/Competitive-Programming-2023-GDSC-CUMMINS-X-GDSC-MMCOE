//issue #145

import java.util.Scanner;
import java.util.TreeSet;

public class TrafficLights {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(); // Length of the street
        int n = sc.nextInt(); // Number of sets of traffic lights
        TreeSet<Integer> positions = new TreeSet<>(); // A TreeSet to store the positions of traffic lights

        // Read and process the positions of traffic lights
        for (int i = 0; i < n; i++) {
            int position = sc.nextInt();
            positions.add(position);

            // Calculate and print the length of the longest passage
            int leftPassage = position - (positions.lower(position) == null ? 0 : positions.lower(position));
            int rightPassage = (positions.higher(position) == null ? x : positions.higher(position)) - position;
            int longestPassage = leftPassage + rightPassage - 1; // Subtract 1 to remove the current traffic light
            System.out.print(longestPassage + " ");
        }

        sc.close();
    }
}
