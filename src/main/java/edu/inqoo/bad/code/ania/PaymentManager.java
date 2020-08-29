package edu.inqoo.bad.code.ania;

import java.math.BigDecimal;

public class PaymentManager {

    public static BigDecimal getCEODefaultSalary(Department department) {
        switch (department) {
            case HR:
                return BigDecimal.valueOf(25000); //mamy return więc brake niepotrzebny
            case Sales:
                return BigDecimal.valueOf(35000);
            case Production:
                return BigDecimal.valueOf(19000);
            default:
                return BigDecimal.valueOf(0);

        }
    }

    public static BigDecimal getManagerDefaultSalary(Department department) {
        switch (department) {
            case HR:
                return BigDecimal.valueOf(16000);
            case Sales:
                return BigDecimal.valueOf(23000);
            case Production:
                return BigDecimal.valueOf(12000);
            default:
                return BigDecimal.valueOf(0);

        }
    }

    public static BigDecimal getWorkerDefaultSalary(Department department) {
        switch (department) {
            case HR:
                return BigDecimal.valueOf(9000);
            case Sales:
                return BigDecimal.valueOf(15000);
            case Production:
                return BigDecimal.valueOf(7000);
            default:
                return BigDecimal.valueOf(0);

        }
    }


}
