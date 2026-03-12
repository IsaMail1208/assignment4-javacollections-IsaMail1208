package service;

import java.util.ArrayDeque;
import java.util.Iterator;

public class ActionHistoryService {

    private ArrayDeque<String> actions = new ArrayDeque<>();

    public void initializeActions() {
        actions.add("Submitted Assignment");
        actions.add("Registered Course");
        actions.add("Updated Profile");
        actions.add("Dropped Course");
    }

    public void undoLastAction() {
        if (actions.isEmpty()) {
            System.out.println("No actions to undo.");
            return;
        }
        String last = actions.pollLast();
        System.out.println("Undone action: " + last);
    }

    public void addRequestedTranscript() {
        actions.add("Requested Transcript");
        System.out.println("Action added: Requested Transcript");
    }

    public void showFirstAndLast() {
        if (actions.isEmpty()) {
            System.out.println("No actions in history.");
            return;
        }
        System.out.println("First action: " + actions.peekFirst());
        System.out.println("Last action: " + actions.peekLast());
    }

    public void printHistory() {
        System.out.println("--- Action History ---");
        Iterator<String> iterator = actions.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
