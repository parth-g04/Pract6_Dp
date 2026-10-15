public class Laboratory implements Department {

    private String name;
    private HospitalMediator mediator;

    public Laboratory() {
        this.name = "Laboratory";
    }

    @Override
    public void setMediator(HospitalMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("[Laboratory] Received: " + message);
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

