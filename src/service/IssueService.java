package service;

import java.util.Iterator;
import java.util.PriorityQueue;
import model.Issue;

public class IssueService {

    private PriorityQueue<Issue> issues = new PriorityQueue<>();

    public void initializeIssues() {
        issues.add(new Issue("Exam schedule conflict", 2));
        issues.add(new Issue("Grade appeal", 3));
        issues.add(new Issue("Scholarship deadline", 1));
        issues.add(new Issue("Course registration error", 2));
        issues.add(new Issue("Academic probation review", 4));
    }

    public void showMostUrgent() {
        Issue mostUrgent = issues.peek();
        if (mostUrgent == null) {
            System.out.println("No issues in the queue.");
        } else {
            System.out.println("Most urgent issue: " + mostUrgent);
        }
    }

    public void resolveIssues() {
        System.out.println("Resolving up to 2 issues...");
        for (int i = 0; i < 2; i++) {
            Issue removed = issues.poll();
            if (removed == null) {
                break;
            }
            System.out.println("Resolved: " + removed);
        }
    }

    public void printRemainingIssues() {
        System.out.println("--- Remaining Issues ---");
        Iterator<Issue> iterator = issues.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void addNewIssue(String description, int urgency) {
        issues.add(new Issue(description, urgency));
        System.out.println("New issue added.");
    }
}
