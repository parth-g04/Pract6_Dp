/**
 * Smart Hospital Management System
 *
 * Practical No. 6
 * Implementation of Mediator and Template Method Design Patterns
 */
public class HospitalManagementSystem {

    public static void main(String[] args) {

        System.out.println(
                "====================================================================="
        );
        System.out.println(
                " SMART HOSPITAL MANAGEMENT SYSTEM"
        );
        System.out.println(
                " PRACTICAL 6 - MEDIATOR & TEMPLATE METHOD PATTERNS"
        );
        System.out.println(
                "=====================================================================\n"
        );

        // ================================================================
        // MEDIATOR SETUP
        // ================================================================

        HospitalCoordinator coordinator =
                new HospitalCoordinator();

        Reception reception = new Reception();
        Doctor doctor = new Doctor();
        Laboratory laboratory = new Laboratory();
        Pharmacy pharmacy = new Pharmacy();
        Billing billing = new Billing();

        System.out.println(">>> Registering Hospital Departments...\n");

        coordinator.registerDepartment(reception);
        coordinator.registerDepartment(doctor);
        coordinator.registerDepartment(laboratory);
        coordinator.registerDepartment(pharmacy);
        coordinator.registerDepartment(billing);

        System.out.println("\n=====================================================================");
        System.out.println(" MEDIATOR COMMUNICATION DEMONSTRATION");
        System.out.println("=====================================================================");

        reception.sendMessage(
                doctor,
                "Patient consultation required."
        );

        doctor.sendMessage(
                laboratory,
                "Please prepare diagnostic test."
        );

        laboratory.sendMessage(
                doctor,
                "Diagnostic report is ready."
        );

        doctor.sendMessage(
                pharmacy,
                "Please prepare prescribed medicines."
        );

        pharmacy.sendMessage(
                billing,
                "Please generate medicine bill."
        );

        // ================================================================
        // PATIENT OBJECTS
        // ================================================================

        Patient outpatient = new Patient(
                "P-101",
                "Rahul Sharma",
                25,
                "Outpatient"
        );

        Patient inpatient = new Patient(
                "P-102",
                "Priya Patil",
                52,
                "Inpatient"
        );

        Patient emergency = new Patient(
                "P-103",
                "Amit Verma",
                35,
                "Emergency"
        );

        // ================================================================
        // TEMPLATE METHOD - OUTPATIENT
        // ================================================================

        System.out.println("\n\n");
        System.out.println(
                "====================================================================="
        );
        System.out.println(
                " TEMPLATE METHOD - OUTPATIENT TREATMENT"
        );
        System.out.println(
                "====================================================================="
        );

        PatientTreatment outpatientTreatment =
                new OutpatientTreatment(
                        outpatient,
                        coordinator,
                        reception,
                        doctor,
                        laboratory,
                        pharmacy,
                        billing
                );

        outpatientTreatment.processTreatment();

        // ================================================================
        // TEMPLATE METHOD - INPATIENT
        // ================================================================

        System.out.println("\n");
        System.out.println(
                "====================================================================="
        );
        System.out.println(
                " TEMPLATE METHOD - INPATIENT TREATMENT"
        );
        System.out.println(
                "====================================================================="
        );

        PatientTreatment inpatientTreatment =
                new InpatientTreatment(
                        inpatient,
                        coordinator,
                        reception,
                        doctor,
                        laboratory,
                        pharmacy,
                        billing
                );

        inpatientTreatment.processTreatment();

        // ================================================================
        // TEMPLATE METHOD - EMERGENCY
        // ================================================================

        System.out.println("\n");
        System.out.println(
                "====================================================================="
        );
        System.out.println(
                " TEMPLATE METHOD - EMERGENCY TREATMENT"
        );
        System.out.println(
                "====================================================================="
        );

        PatientTreatment emergencyTreatment =
                new EmergencyTreatment(
                        emergency,
                        coordinator,
                        reception,
                        doctor,
                        laboratory,
                        pharmacy,
                        billing
                );

        emergencyTreatment.processTreatment();

        System.out.println(
                "\n====================================================================="
        );
        System.out.println(
                " PRACTICAL 6 EXECUTION COMPLETED SUCCESSFULLY"
        );
        System.out.println(
                "====================================================================="
        );
    }
}
