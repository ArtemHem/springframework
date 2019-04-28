package lesson1_hw;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Patient {

    public static void main(String[] args) {
//        Registry registry = new Registry();
//        registry.getCabinetNumber();

//        ApplicationContext context = new ClassPathXmlApplicationContext("configPatient.xml");
//        IPatientCard patientCard = context.getBean("patientCard", IPatientCard.class);
//        patientCard.setCabinetNumber("578");
//        patientCard.printCabinetNumber();

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PatientCard patientCard = context.getBean("patientCard", PatientCard.class);
        patientCard.setCabinetNumber("578");
        patientCard.printCabinetNumber();
    }

}
