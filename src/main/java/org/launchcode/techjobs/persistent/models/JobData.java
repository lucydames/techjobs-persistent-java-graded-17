package org.launchcode.techjobs.persistent.models;

import java.util.ArrayList;

/**
 * Created by LaunchCode
 */
public class JobData {

    public static ArrayList<Job> findByColumnAndValue(String column, String value, Iterable<Job> allJobs) {

        ArrayList<Job> results = new ArrayList<>();

        if (value.toLowerCase().equals("all")) {
            return (ArrayList<Job>) allJobs;
        }

        if (column.equals("all")) {
            results = findByValue(value, allJobs);
            return results;
        }
        for (Job job : allJobs) {
            String aValue = getFieldValue(job, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                results.add(job);
            }
        }

        return results;
    }

    public static String getFieldValue(Job job, String fieldName) {
        String theValue;
        if (fieldName.equals("name")) {
            theValue = job.getName();
        } else if (fieldName.equals("employer")) {
            Employer employer = job.getEmployer();
            theValue = (employer != null) ? employer.toString() : null;
        } else {
            theValue = job.getSkills().toString();
        }

        return theValue;
    }

    public static ArrayList<Job> findByValue(String value, Iterable<Job> allJobs) {
        String lower_val = value.toLowerCase();

        ArrayList<Job> results = new ArrayList<>();

        for (Job job : allJobs) {
            if (job.getName().toLowerCase().contains(lower_val)
                    || (job.getEmployer() != null && job.getEmployer().toString().toLowerCase().contains(lower_val))
                    || job.getSkills().toString().toLowerCase().contains(lower_val)
                    || job.toString().toLowerCase().contains(lower_val)) {
                results.add(job);
            }
        }

        return results;
    }
}
