package lesson1_hw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("patientCard")
public class PatientCard implements IPatientCard {

    private ICabinet cabinet;

//    public PatientCard(ICabinet cabinet) {
//        this.cabinet = cabinet;
//    }

    public ICabinet getCabinet() {
        return cabinet;
    }

    @Autowired
    public void setCabinet(ICabinet cabinet) {
        this.cabinet = cabinet;
    }

    public void setCabinetNumber(String cabinetNumber) {
        cabinet.setCabinetNumber(cabinetNumber);
    }

    public void printCabinetNumber() {
        String cabinetNumber = cabinet.getCabinetNumber();
        System.out.println(cabinetNumber);
    }
}
