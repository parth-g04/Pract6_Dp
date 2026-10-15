public class Patient {

    private String patientID;
    private String name;
    private int age;
    private String patientType;

    public Patient(String patientID, String name,
                   int age, String patientType) {

        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.patientType = patientType;
    }

    public String getPatientID() {
        return patientID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPatientType() {
        return patientType;
    }

    public String getPatientDetails() {
        return patientID + " | " + name
                + " | Age: " + age
                + " | Type: " + patientType;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientID
                + ", Name: " + name
                + ", Age: " + age
                + ", Type: " + patientType;
    }
}
