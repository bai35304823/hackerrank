//For each query (request), you must return:

//The actual URL corresponding to the requested short URL

//The number of requests processed so far (up to and including the current request) for the user who created that short URL

//⚠️ Important:

//The request count is tracked per user, not per short URL.

//The count is cumulative across all short URLs created by the same user.

import java.util.*;

public class Main {

    public static List<List<String>> processRequests(
            List<String> database,
            List<String> queries) {

        // shortUrl -> actualUrl
        Map<String, String> shortToActual = new HashMap<>();
        // shortUrl -> userId
        Map<String, Integer> shortToUser = new HashMap<>();

        // Parse database
        for (String row : database) {
            String[] parts = row.split(" ");
            int userId = Integer.parseInt(parts[0]);
            String shortUrl = parts[1];
            String actualUrl = parts[2];

            shortToActual.put(shortUrl, actualUrl);
            shortToUser.put(shortUrl, userId);
        }

        // userId -> request count
        Map<Integer, Integer> userCount = new HashMap<>();

        List<List<String>> result = new ArrayList<>();

        // Process queries
        for (String shortUrl : queries) {
            int userId = shortToUser.get(shortUrl);

            userCount.put(userId, userCount.getOrDefault(userId, 0) + 1);

            List<String> entry = new ArrayList<>();
            entry.add(shortToActual.get(shortUrl));
            entry.add(String.valueOf(userCount.get(userId)));

            result.add(entry);
        }

        return result;
    }

    // Example usage
    public static void main(String[] args) {
        List<String> database = Arrays.asList(
                "0 s1 http://a.com",
                "1 s2 http://b.com",
                "0 s3 http://c.com"
        );

        List<String> queries = Arrays.asList("s1", "s2", "s1", "s3");

        List<List<String>> output = processRequests(database, queries);

        for (List<String> row : output) {
            System.out.println(row);
        }
    }
}
