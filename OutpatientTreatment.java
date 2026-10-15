public class OutpatientTreatment
        extends AbstractPatientTreatment {

    public OutpatientTreatment(
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
                "Perform basic blood test for outpatient "
                        + patient.getName()
        );

        laboratory.sendMessage(
                doctor,
                "Basic test completed. Results available."
        );
    }

    @Override
    protected void generatePrescription() {

        System.out.println("\n--- Step 4: Generate Prescription ---");

        doctor.sendMessage(
                pharmacy,
                "Prescription generated for outpatient "
                        + patient.getName()
        );

        pharmacy.receiveMessage(
                "Medicines prepared for outpatient."
        );
    }

    @Override
    protected void processBillingAndDischarge() {

        System.out.println("\n--- Step 5: Billing and Discharge ---");

        pharmacy.sendMessage(
                billing,
                "Medicine charges submitted for "
                        + patient.getName()
        );

        billing.receiveMessage(
                "Outpatient bill generated. Patient discharged."
        );
    }
}
