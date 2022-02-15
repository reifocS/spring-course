package fr.romaingervais.imt.tests;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws SQLException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        BankService bankService = applicationContext.getBean(BankService.class);

        bankService.showAccounts();
        try {
            bankService.transferMoney("imt-nantes", "rgervais", 100000);
        } finally {
            bankService.showAccounts();
        }
    }


}
