package org.example;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Worker {
    String workerId;
    String occupation;
    Integer salary;
    Duration totalTime;

    public Worker(String workerId, String occupation, Integer salary, Duration totalTime) {
        this.workerId = workerId;
        this.occupation = occupation;
        this.salary = salary;
        this.totalTime = totalTime;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Duration getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Duration totalTime) {
        this.totalTime = totalTime;
    }

}

class TimeSeries {
    String workerId;
    Duration startTime;
    Duration endTime;

    public TimeSeries() {
    }

    public TimeSeries(String workerId, Duration startTime, Duration endTime) {
        this.workerId = workerId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getWorkerId() {
        return this.workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public TimeSeries workerId(String workerId) {
        setWorkerId(workerId);
        return this;
    }

    public Duration getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Duration startTime) {
        this.startTime = startTime;
    }

    public TimeSeries startTime(Duration startTime) {
        setStartTime(startTime);
        return this;
    }

    public Duration getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Duration endTime) {
        this.endTime = endTime;
    }

    public TimeSeries endTime(Duration endTime) {
        setEndTime(endTime);
        return this;
    }

}

public class WorkingHours {

    Map<String, Worker> workers = new HashMap<>();
    Map<String, List<TimeSeries>> timeSeries = new HashMap<>();

    // Add worker
    public boolean addWorker(String workerId, String occupation, Integer salary) {
        if (workers.containsKey(workerId)) {
            return false;
        }
        Worker worker = new Worker(workerId, occupation, salary, Duration.ZERO);
        workers.put(workerId, worker);
        return true;
    }

    // register time
    public String register(String workerId, Duration timeStamp) {

        if (!workers.containsKey(workerId)) {
            return "invalid_request";
        }
        // three task to do here
        // - if worker is not having any thing create in a list and add the start time
        // - if worker is having start time add the end time in the object and update
        // the total time for that worker
        // - if worker is not having any open start time add new start time in the list
        // first condition to check the worker is already present in the system or not
        if (!timeSeries.containsKey(workerId) || timeSeries.get(workerId).isEmpty()) {
            List<TimeSeries> timeSeriesList = List.of(new TimeSeries(workerId, timeStamp, null));
            timeSeries.put(workerId, timeSeriesList);
            return "success";
        }

        // last time is null
        if (timeSeries.get(workerId).get(timeSeries.get(workerId).size() - 1).getEndTime() == null) {
            List<TimeSeries> timeSeriesList = timeSeries.get(workerId);
            TimeSeries timeSeriesObj = timeSeriesList.get(timeSeriesList.size() - 1);
            timeSeriesList.get(timeSeriesList.size() - 1).setEndTime(timeStamp);
            Worker worker = workers.get(workerId);
            worker.setTotalTime(worker.getTotalTime().plus(timeStamp.minus(timeSeriesObj.getStartTime())));
            workers.put(workerId, worker);
            timeSeries.put(workerId, timeSeriesList);
            return "success";
        }
        // when last time is not null we will create a new entry in timeSeriesList
        else {
            List<TimeSeries> timeSeriesList = timeSeries.get(workerId);
            TimeSeries timeSeriesObj = new TimeSeries(workerId, timeStamp, null);
            timeSeriesList.add(timeSeriesObj);
            timeSeries.put(workerId, timeSeriesList);
            return "success";
        }
    }

    public Duration getWorkingHours(String workerId) {
        if (!workers.containsKey(workerId)) {
            return Duration.ZERO;
        }
        return workers.get(workerId).getTotalTime();
    }

    public static void main(String[] args) {
        WorkingHours wh = new WorkingHours();

        // Test Case 1: Add a new worker
        boolean addWorkerResult = wh.addWorker("W001", "Developer", 50000);
        System.out.println("Add Worker W001: " + (addWorkerResult ? "Success" : "Failed"));

        // Test Case 2: Register entry time for worker W001
        String registerEntryResult = wh.register("W001", Duration.ofHours(9));
        System.out.println("Register Entry for W001: " + registerEntryResult);

        // Test Case 3: Register exit time for worker W001
        String registerExitResult = wh.register("W001", Duration.ofHours(17));
        System.out.println("Register Exit for W001: " + registerExitResult);

        // Test Case 4: Retrieve total working hours for worker W001
        Duration totalWorkingHours = wh.getWorkingHours("W001");
        System.out.println("Total Working Hours for W001: " + totalWorkingHours.toHours() + " hours");

        // Test Case 5: Add another worker
        addWorkerResult = wh.addWorker("W002", "Manager", 70000);
        System.out.println("Add Worker W002: " + (addWorkerResult ? "Success" : "Failed"));

        // Test Case 6: Register entry time for worker W002
        registerEntryResult = wh.register("W002", Duration.ofHours(10));
        System.out.println("Register Entry for W002: " + registerEntryResult);

        // Test Case 7: Register exit time for worker W002
        registerExitResult = wh.register("W002", Duration.ofHours(18));
        System.out.println("Register Exit for W002: " + registerExitResult);

        // Test Case 8: Retrieve total working hours for worker W002
        totalWorkingHours = wh.getWorkingHours("W002");
        System.out.println("Total Working Hours for W002: " + totalWorkingHours.toHours() + " hours");

        // Test Case 9: Try to add an existing worker (should fail)
        addWorkerResult = wh.addWorker("W001", "Developer", 50000);
        System.out.println("Add Existing Worker W001: " + (addWorkerResult ? "Success" : "Failed"));

        // Test Case 10: Register entry time for a non-existent worker
        registerEntryResult = wh.register("W003", Duration.ofHours(8));
        System.out.println("Register Entry for Non-Existent Worker W003: " + registerEntryResult);

        // Test Case 11: Retrieve total working hours for a non-existent worker
        totalWorkingHours = wh.getWorkingHours("W003");
        System.out
                .println("Total Working Hours for Non-Existent Worker W003: " + totalWorkingHours.toHours() + " hours");
    }
}
