public class Pharmacy implements Department {

    private String name;
    private HospitalMediator mediator;

    public Pharmacy() {
        this.name = "Pharmacy";
    }

    @Override
    public void setMediator(HospitalMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println("[Pharmacy] Received: " + message);
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
