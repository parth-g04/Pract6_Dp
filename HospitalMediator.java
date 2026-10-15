public interface HospitalMediator {

    void registerDepartment(Department department);

    void sendMessage(Department sender, Department receiver, String message);

    void notify(String message);
}