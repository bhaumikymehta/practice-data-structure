package hubspot.PeopleInteraction;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


class Association {
    int companyId;
    int contactId;
    String role;

    Association(int companyId, int contactId, String role) {
        this.companyId = companyId;
        this.contactId = contactId;
        this.role = role;
    }
}

class Result {
    List<Association> validAssociations;
    List<InvalidAssociation> invalidAssociations;

    Result() {
        this.validAssociations = new ArrayList<>();
        this.invalidAssociations = new ArrayList<>();
    }
}

class InvalidAssociation extends Association {
    String failureReason;

    InvalidAssociation(int companyId, int contactId, String role, String failureReason) {
        super(companyId, contactId, role);
        this.failureReason = failureReason;
    }
}

class Dataset {
    List<Association> existingAssociations;
    List<Association> newAssociations;
}

public class PeopleIteraction {

    private static Result validateAssociations(List<Association> existingAssociations,
            List<Association> newAssociations) {

        Result result = new Result();

        // Data structures for efficient lookups and counting
        Map<String, Integer> companyRoleCounts = new HashMap<>();
        Map<String, Integer> contactCompanyCounts = new HashMap<>();

        Map<String, Integer> companyRoleCountsNewAssoc = new HashMap<>();
        Map<String, Integer> contactCompanyCountsNewAssoc = new HashMap<>();
        Set<String> existingAssociationsSet = new HashSet<>();

        // Convert existing associations to a set for faster lookups
        for (Association assoc : existingAssociations) {

            String companyRoleKey = assoc.companyId + "-" + assoc.role;
            String contactCompanyKey = assoc.contactId + "-" + assoc.companyId;
            existingAssociationsSet.add(assoc.companyId + "-" + assoc.contactId + "-" + assoc.role);
            // Check for limit violations
            companyRoleCounts.put(companyRoleKey, companyRoleCounts.getOrDefault(companyRoleKey, 0) + 1);
            contactCompanyCounts.put(contactCompanyKey, contactCompanyCounts.getOrDefault(contactCompanyKey, 0) + 1);

        }
        for (Association assoc : newAssociations) {

            // for all the new associates i will like to create a companyRoleCounts and
            // contactCompanyCounts
            String companyRoleKey = assoc.companyId + "-" + assoc.role;
            String contactCompanyKey = assoc.contactId + "-" + assoc.companyId;

            companyRoleCountsNewAssoc.put(companyRoleKey,
                    companyRoleCountsNewAssoc.getOrDefault(companyRoleKey, 0) + 1);
            contactCompanyCountsNewAssoc.put(contactCompanyKey,
                    contactCompanyCountsNewAssoc.getOrDefault(contactCompanyKey, 0) + 1);

        }

        for (Association assoc : newAssociations) {
            String companyRoleKey = assoc.companyId + "-" + assoc.role;
            String contactCompanyKey = assoc.contactId + "-" + assoc.companyId;

            // Check if the association already exists
            if (existingAssociationsSet.contains(assoc.companyId + "-" + assoc.contactId + "-" + assoc.role)) {
                result.invalidAssociations
                        .add(new InvalidAssociation(assoc.companyId, assoc.contactId, assoc.role, "ALREADY_EXISTS"));
                continue;
            }

            // Check for limit violations
            // companyRoleCounts.put(companyRoleKey,
            // companyRoleCounts.getOrDefault(companyRoleKey, 0) + 1);
            // contactCompanyCounts.put(contactCompanyKey,
            // contactCompanyCounts.getOrDefault(contactCompanyKey, 0) + 1);

            else if ((companyRoleCounts.getOrDefault(companyRoleKey, 0) + companyRoleCountsNewAssoc.getOrDefault(
                    companyRoleKey, 0)) > 5
                    ||
                    (contactCompanyCounts.getOrDefault(contactCompanyKey, 0)
                            + contactCompanyCountsNewAssoc.getOrDefault(contactCompanyKey, 0)) > 2) {
                result.invalidAssociations.add(
                        new InvalidAssociation(assoc.companyId, assoc.contactId, assoc.role, "WOULD_EXCEED_LIMIT"));
            } else {
                result.validAssociations.add(assoc);

                // companyRoleCounts.put(companyRoleKey,
                // companyRoleCounts.getOrDefault(companyRoleKey, 0) + 1);
                // contactCompanyCounts.put(contactCompanyKey,
                // contactCompanyCounts.getOrDefault(contactCompanyKey, 0) + 1);

            }
        }

        System.out.println("Result valid:" + result.validAssociations.size());
        System.out.println("Result invalid:" + result.invalidAssociations.size());
        return result;
    }

    private static final String USER_KEY = "7d2bf9a67fc42a245aa68dc8f149";
    private static final String DATASET_URL = "https://candidate.hubteam.com/candidateTest/v3/problem/test-dataset?userKey="
            + USER_KEY;
    private static final String RESULT_URL = "https://candidate.hubteam.com/candidateTest/v3/problem/test-result?userKey="
            + USER_KEY;

    public static void main(String[] args) {
        try {

            Gson gson = new Gson();

            // Fetch the dataset
            // Dataset dataset = fetchDataset(DATASET_URL);
            // String currentDirectory = System.getProperty("user.dir");

            String filePath = "/Users/bhaumikmehta/Documents/workspace/java/interviewPrerp/practice-data-structure/src/main/java/hubspot/PeopleInteraction/response.json";
            String responseJson = new String(Files.readAllBytes(Paths.get(filePath)));
            Dataset dataset = gson.fromJson(responseJson.toString(), Dataset.class);

            // Validate the associations
            Result result = validateAssociations(dataset.existingAssociations, dataset.newAssociations);

            System.out.println("Result:" + result);
            // POST the results
            // postResult(RESULT_URL, result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static Dataset fetchDataset(String datasetUrl) throws Exception {
        URL url = new URL(datasetUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();
        System.out.println("Contnet:" + content.toString());
        Gson gson = new Gson();
        return gson.fromJson(content.toString(), Dataset.class);
    }

    private static void postResult(String resultUrl, Result result) throws Exception {
        URL url = new URL(resultUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        // con.setRequestProperty("Content-Type", "application/json;utf-8");
        // con.setRequestProperty("Accept", "application/json");
        // con.setDoOutput(true);

        Gson gson = new Gson();
        String jsonInputString = gson.toJson(result);
        System.out.println("jsonInputString:" + jsonInputString);

        try (OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = con.getResponseCode();
        String responseMessage = con.getResponseMessage();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            System.out.println("Validation results successfully submitted.");
        } else {
            System.out.println("Error submitting results: " + responseCode);
            System.out.println("Error submitting results: " + responseMessage);

        }

        con.disconnect();
    }

}
