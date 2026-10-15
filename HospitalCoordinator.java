import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Mediator.
 * Coordinates communication between hospital departments.
 */
public class HospitalCoordinator implements HospitalMediator {

    private List<Department> departments;

    public HospitalCoordinator() {
        departments = new ArrayList<>();
    }

    @Override
    public void registerDepartment(Department department) {
        departments.add(department);
        department.setMediator(this);

        System.out.println("[COORDINATOR] Registered department: "
                + department.getName());
    }

    @Override
    public void sendMessage(Department sender,
                            Department receiver,
                            String message) {

        System.out.println("\n[MEDIATOR] "
                + sender.getName()
                + " -> "
                + receiver.getName());

        System.out.println("           Message: " + message);

        receiver.receiveMessage(message);
    }

    @Override
    public void notify(String message) {

        System.out.println("\n[MEDIATOR BROADCAST] " + message);

        for (Department department : departments) {
            department.receiveMessage(message);
        }
    }
}
