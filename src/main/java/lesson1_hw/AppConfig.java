package lesson1_hw;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "cabinet")
    public Cabinet cabinet() {
        return new Cabinet();
    }

    @Bean(name = "patientCard")
    public PatientCard patientCard(ICabinet cabinet) {
        PatientCard patientCard = new PatientCard();
        patientCard.setCabinet(cabinet);
        return patientCard;
    }

}
