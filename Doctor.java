public class Doctor implements Department {

    private String name;
    private HospitalMediator mediator;

    public Doctor() {
        this.name = "Doctor";
    }

    @Override
    public void setMediator(HospitalMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("[Doctor] Received: " + message);
    }

    @Override
    public void sendMessage(Department receiver, String message) {
        mediator.sendMessage(this, receiver, message);
    }

    @Override
    public String getName() {
        return name;
    }
}
