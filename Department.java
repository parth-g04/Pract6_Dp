public interface Department {

    void setMediator(HospitalMediator mediator);

    void receiveMessage(String message);

    void sendMessage(Department receiver, String message);

    String getName();
}