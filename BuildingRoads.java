//issue #166

import java.util.*;

public class MinimumRoads {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of cities
        int m = sc.nextInt(); // Number of existing roads

        // Create a set to keep track of connected cities
        Set<Integer> connectedCities = new HashSet<>();

        // Create a list to store the required roads
        List<String> newRoads = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            connectedCities.add(a);
            connectedCities.add(b);
        }

        sc.close();

        int numRequiredRoads = n - connectedCities.size(); // Number of required roads

        if (numRequiredRoads == 0) {
            // All cities are already connected
            System.out.println("0");
        } else {
            // Find a city that is not connected and create new roads to connect it
            int unconnectedCity = 1; // Start from the first city

            for (int city : connectedCities) {
                if (unconnectedCity != city) {
                    newRoads.add(unconnectedCity + " " + city);
                    numRequiredRoads--;
                }
                unconnectedCity++;
            }

            // Print the number of required roads
            System.out.println(numRequiredRoads);

            // Print the details of the new roads
            for (String road : newRoads) {
                System.out.println(road);
            }
        }
    }
}




/*
Input:
4 2
1 2
3 4
Output:
1
2 3

*/
