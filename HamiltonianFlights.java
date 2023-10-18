
//issue #167

import java.util.*;

public class CityRoutes {
    static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of cities
        int m = sc.nextInt(); // Number of flights

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1; // Adjust for 0-based indexing
            int b = sc.nextInt() - 1; // Adjust for 0-based indexing
            graph.get(a).add(b);
        }

        sc.close();

        // Initialize the number of routes to 0
        long numRoutes = 0;

        // Calculate the number of routes using backtracking
        numRoutes = countRoutes(graph, new boolean[n], 0, n - 1);

        System.out.println(numRoutes);
    }

    // Recursive function to count the number of routes
    static long countRoutes(List<List<Integer>> graph, boolean[] visited, int currentCity, int targetCity) {
        if (currentCity == targetCity) {
            return 1; // Found a valid route
        }

        visited[currentCity] = true;

        long routes = 0;
        for (int neighbor : graph.get(currentCity)) {
            if (!visited[neighbor]) {
                routes += countRoutes(graph, visited, neighbor, targetCity);
            }
        }

        visited[currentCity] = false;

        return routes;
    }
}




/*
Input: nums = [1], k = 1
Output: 1

Input: nums = [2,-1,2], k = 3
Output: 3

*/
