public class Reception implements Department {

    private String name;
    private HospitalMediator mediator;

    public Reception() {
        this.name = "Reception";
    }

    @Override
    public void setMediator(HospitalMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("[Reception] Received: " + message);
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
