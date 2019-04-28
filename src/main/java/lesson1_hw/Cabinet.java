package lesson1_hw;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("cabinet")
public class Cabinet implements ICabinet {

    private String cabinetNumber;

    public String getCabinetNumber() {
        return cabinetNumber;
    }

    public void setCabinetNumber(String cabinetNumber) {
        this.cabinetNumber = cabinetNumber;
    }
}
