package pro.sky.homework24;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CalculatorBadParams extends IllegalArgumentException {
    public CalculatorBadParams() {
    }

    public CalculatorBadParams(String message) {
        super(message);
    }
}
