package edu.inqoo.good.code;

import java.math.BigDecimal;

public class PaymentManager {

    public static BigDecimal getCEODefaultSalary(Department department){
        switch (department){
            case HR: return BigDecimal.valueOf(25000);

            case SALES: return BigDecimal.valueOf(35000);

            case PRODUCTION: return BigDecimal.valueOf(19000);

            default: return BigDecimal.valueOf(0);
        }
    }

    public static BigDecimal getManagerDefaultSalary(Department department){
        switch (department){
            case HR: return BigDecimal.valueOf(16000);

            case SALES: return BigDecimal.valueOf(23000);

            case PRODUCTION: return BigDecimal.valueOf(12000);

            default: return BigDecimal.valueOf(0);
        }
    }

    public static BigDecimal getWorkerDefaultSalary(Department department){
        switch (department){
            case HR: return BigDecimal.valueOf(9000);

            case SALES: return BigDecimal.valueOf(15000);

            case PRODUCTION: return BigDecimal.valueOf(7000);

            default: return BigDecimal.valueOf(0);
        }
    }
}
