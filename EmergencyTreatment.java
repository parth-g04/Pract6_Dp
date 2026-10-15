public class EmergencyTreatment
        extends AbstractPatientTreatment {

    public EmergencyTreatment(
            Patient patient,
            HospitalMediator mediator,
            Department reception,
            Department doctor,
            Department laboratory,
            Department pharmacy,
            Department billing) {

        super(patient, mediator, reception, doctor,
                laboratory, pharmacy, billing);
    }

    @Override
    protected void performTests() {

        System.out.println("\n--- Step 3: Emergency Diagnostic Tests ---");

        doctor.sendMessage(
                laboratory,
                "URGENT: Perform emergency diagnostic tests for "
                        + patient.getName()
        );

        laboratory.sendMessage(
                doctor,
                "Emergency test results sent immediately."
        );
    }

    @Override
    protected void generatePrescription() {

        System.out.println("\n--- Step 4: Emergency Prescription ---");

        doctor.sendMessage(
                pharmacy,
                "URGENT: Prepare emergency medicines for "
                        + patient.getName()
        );

        pharmacy.receiveMessage(
                "Emergency medicines prepared immediately."
        );
    }

    @Override
    protected void processBillingAndDischarge() {

        System.out.println("\n--- Step 5: Emergency Billing ---");

        pharmacy.sendMessage(
                billing,
                "Emergency treatment charges submitted."
        );

        billing.receiveMessage(
                "Emergency billing completed. Patient discharged."
        );
    }
}
