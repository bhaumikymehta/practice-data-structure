//package hubspot.InboxView;
//
//
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.TimeZone;
//
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.web.client.RestTemplate;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//
//public class TestMain {
//
//    private static final String USER_KEY = "3340b6642338660a4f7b25582cbe";
//    // private static final String DATASET_URL =
//    // "https://candidate.hubteam.com/candidateTest/v3/problem/dataset?userKey=3340b6642338660a4f7b25582cbe";
//    private static final String DATASET_URL = "https://candidate.hubteam.com/candidateTest/v3/problem/test-dataset?userKey=3340b6642338660a4f7b25582cbe";
//
//    // private static final String RESULT_URL =
//    // "https://candidate.hubteam.com/candidateTest/v3/problem/result?userKey=3340b6642338660a4f7b25582cbe";
//
//    private static final String RESULT_URL = "https://candidate.hubteam.com/candidateTest/v3/problem/test-result?userKey=3340b6642338660a4f7b25582cbe";
//
//    public static void main(String[] args) {
//
//        // Create instances of RestTemplate and ObjectMapper
//        RestTemplate restTemplate = new RestTemplate();
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        try {
//            // Step 1: Fetch data from the external API
//            CallRecords callRecords = restTemplate.getForObject(DATASET_URL, CallRecords.class);
//            System.out.println("Parsed API Response: " + callRecords);
//
//            Map<Integer, Map<LocalDate, List<>> resultsMap = new HashMap<>();
//
//            for (CallRecord callRecord : callRecords.getCallRecords()) {
//                String startDate = getDateFromTimestamp(callRecord.getStartTimestamp());
//                String endDate = getDateFromTimestamp(callRecord.getEndTimestamp() - 1);
//
//                // Handle calls that span multiple days
//                if (startDate.equals(endDate)) {
//                    processCallForDate(callRecord, startDate, resultsMap);
//                } else {
//                    // Split the call into multiple days
//                    long currentTimestamp = callRecord.getStartTimestamp();
//                    while (currentTimestamp <= callRecord.getEndTimestamp()) {
//                        String currentDate = getDateFromTimestamp(currentTimestamp);
//                        processCallForDate(callRecord, currentDate, resultsMap);
//                        currentTimestamp = getNextDayTimestamp(currentTimestamp);
//                    }
//                }
//            }
//
//            // Step 3: Prepare the result object
//            List<CallEvent> results = new ArrayList<>();
//            for (Map<Integer, CallEvent> customerMap : resultsMap.values()) {
//                results.addAll(customerMap.values());
//            }
//
//            Result result = new Result();
//            result.setResults(results);
//
//            String resultJson = objectMapper.writeValueAsString(result);
//            System.out.println("Result JSON: " + resultJson);
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_JSON);
//
//            HttpEntity<String> entity = new HttpEntity<String>(resultJson, headers);
//            // ResponseEntity<String> response = restTemplate.postForObject(RESULT_URL,
//            // entity, String.class);
//            // Step 4: Post the result to the API
//            String response = restTemplate.postForObject(RESULT_URL,
//                    entity,
//                    String.class);
//            System.out.println("Response from POST request: " + response);
//            // Step 2: Post the parsed data to another endpoint
//            // String postResponse = restTemplate.postForObject(RESULT_URL, apiResponse,
//            // String.class);
//            // System.out.println("Response from POST request: " + postResponse);
//
//        } catch (Exception e) {
//            System.err.println("An error occurred: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//    public static String getDateFromTimestamp(long timestamp) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
//        return sdf.format(new Date(timestamp));
//
//    }
//
//    private static long getNextDayTimestamp(long timestamp) {
//        return timestamp + 24 * 60 * 60 * 1000; // Add 1 day in milliseconds
//    }
//
//    private static void processCallForDate(CallRecord call, String date,
//            Map<String, Map<Integer, CallEvent>> resultsByDateAndCustomer) {
//        // Initialize the map for the date if it doesn't exist
//        resultsByDateAndCustomer.putIfAbsent(date, new HashMap<>());
//
//        // Initialize the result entry for the customer if it doesn't exist
//        Map<Integer, CallEvent> customerMap = resultsByDateAndCustomer.get(date);
//        customerMap.putIfAbsent(call.getCustomerId(), new CallEvent());
//        CallEvent resultEntry = customerMap.get(call.getCustomerId());
//
//        if (resultEntry.getCallIds() == null) {
//            resultEntry.setCallIds(new ArrayList<>());
//        }
//        // Update the result entry
//        resultEntry.setCustomerId(call.getCustomerId());
//        resultEntry.setDate(date);
//
//        // Calculate concurrent calls
//        int concurrentCalls = resultEntry.getMaxConcurrentCalls() + 1;
//        resultEntry.setMaxConcurrentCalls(concurrentCalls);
//
//        // Update the timestamp and callIds
//        resultEntry.setTimestamp(call.getStartTimestamp());
//        resultEntry.getCallIds().add(call.getCallId());
//    }
//}
//
//// Model class to represent the API response
//@Data
//class CallRecord {
//    private Integer customerId;
//    private String callId;
//    private Long startTimestamp;
//    private Long endTimestamp;
//}
//
//@Data
//class CallRecords {
//    @JsonProperty("callRecords")
//    private List<CallRecord> callRecords;
//}
//
//@Data
//class CallEvent {
//    @JsonProperty("customerId")
//    private int customerId;
//
//    @JsonProperty("date")
//    private String date;
//
//    @JsonProperty("maxConcurrentCalls")
//    private int maxConcurrentCalls;
//
//    @JsonProperty("timestamp")
//    private long timestamp;
//
//    @JsonProperty("callIds")
//    private List<String> callIds;
//
//    // CallEvent() {
//    // this.callIds = new ArrayList<>();
//    // }
//}
//
//@Data
//class Result {
//    @JsonProperty("results")
//    private List<CallEvent> results;
//}
