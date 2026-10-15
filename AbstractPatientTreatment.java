/**
 * Abstract class implementing the Template Method Pattern.
 */
public abstract class AbstractPatientTreatment
        implements PatientTreatment {

    protected Patient patient;
    protected HospitalMediator mediator;

    protected Department reception;
    protected Department doctor;
    protected Department laboratory;
    protected Department pharmacy;
    protected Department billing;

    public AbstractPatientTreatment(
            Patient patient,
            HospitalMediator mediator,
            Department reception,
            Department doctor,
            Department laboratory,
            Department pharmacy,
            Department billing) {

        this.patient = patient;
        this.mediator = mediator;

        this.reception = reception;
        this.doctor = doctor;
        this.laboratory = laboratory;
        this.pharmacy = pharmacy;
        this.billing = billing;
    }

    /**
     * Template Method.
     * Defines the fixed sequence of treatment.
     */
    @Override
    public final void processTreatment() {

        System.out.println("\n====================================================");
        System.out.println("TREATMENT STARTED");
        System.out.println("Patient: " + patient.getName());
        System.out.println("Type   : " + patient.getPatientType());
        System.out.println("====================================================");

        registerPatient();

        consultDoctor();

        performTests();

        generatePrescription();

        processBillingAndDischarge();

        System.out.println("\n====================================================");
        System.out.println("TREATMENT COMPLETED");
        System.out.println("Patient: " + patient.getName());
        System.out.println("====================================================\n");
    }

    protected void registerPatient() {

        System.out.println("\n--- Step 1: Register Patient ---");

        reception.sendMessage(
                doctor,
                "Patient " + patient.getName()
                        + " (" + patient.getPatientID()
                        + ") has been registered."
        );
    }

    protected void consultDoctor() {

        System.out.println("\n--- Step 2: Consult Doctor ---");

        doctor.sendMessage(
                laboratory,
                "Doctor requests diagnostic tests for "
                        + patient.getName()
        );
    }

    /**
     * Varies according to patient type.
     */
    protected abstract void performTests();

    /**
     * Varies according to patient type.
     */
    protected abstract void generatePrescription();

    /**
     * Varies according to patient type.
     */
    protected abstract void processBillingAndDischarge();
}
