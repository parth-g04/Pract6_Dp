public class InpatientTreatment
        extends AbstractPatientTreatment {

    public InpatientTreatment(
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

        System.out.println("\n--- Step 3: Diagnostic Tests ---");

        doctor.sendMessage(
                laboratory,
                "Perform detailed diagnostic tests for inpatient "
                        + patient.getName()
        );

        laboratory.sendMessage(
                doctor,
                "Detailed diagnostic tests completed."
        );
    }

    @Override
    protected void generatePrescription() {

        System.out.println("\n--- Step 4: Generate Prescription ---");

        doctor.sendMessage(
                pharmacy,
                "Prepare medicines and treatment plan for inpatient "
                        + patient.getName()
        );

        pharmacy.receiveMessage(
                "Inpatient medicines prepared."
        );
    }

    @Override
    protected void processBillingAndDischarge() {

        System.out.println("\n--- Step 5: Billing and Discharge ---");

        pharmacy.sendMessage(
                billing,
                "Inpatient medicine charges submitted."
        );

        billing.receiveMessage(
                "Inpatient bill generated. Discharge approved."
        );
    }
}
