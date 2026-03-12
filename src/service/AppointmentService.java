package service;

import java.util.Iterator;
import java.util.LinkedList;

public class AppointmentService {

    private LinkedList<String> appointments = new LinkedList<>();

    public void initializeAppointments() {
        appointments.add("General advising session");
        appointments.add("Financial aid consultation");
        appointments.add("Career counseling");
        appointments.addFirst("URGENT: Academic dismissal appeal");
    }

    public void cancelLast() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments to cancel.");
            return;
        }
        String removed = appointments.removeLast();
        System.out.println("Cancelled last appointment: " + removed);
    }

    public void showFirstAndLast() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
            return;
        }
        System.out.println("First appointment: " + appointments.getFirst());
        System.out.println("Last appointment: " + appointments.getLast());
    }

    public void printAppointments() {
        System.out.println("--- Appointments ---");
        Iterator<String> iterator = appointments.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
