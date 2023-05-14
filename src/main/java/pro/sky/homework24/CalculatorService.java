package pro.sky.homework24;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public Integer plus(int num1, int num2) {
        return num1 + num2;
    }

    public Integer minus(int num1, int num2) {
        return num1 - num2;
    }

    public Integer multiply(int num1, int num2) {
        return num1 * num2;
    }

    public double divide(int num1, int num2) {
        if (num2 == 0) {
            throw new CalculatorBadParams("делитель не может быть равен нулю!");
        }
        return num1 / (double)num2;
    }
}
