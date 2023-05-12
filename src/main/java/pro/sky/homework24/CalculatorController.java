package pro.sky.homework24;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String greeting() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(required = false) Integer num1, Integer num2) {
        checkParams(num1, num2);
        return "" + num1 + " + " + num2 + " = " + calculatorService.plus(num1, num2);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(required = false) Integer num1, Integer num2) {
        checkParams(num1, num2);
        return "" + num1 + " - " + num2 + " = " + calculatorService.minus(num1, num2);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(required = false) Integer num1, Integer num2) {
        checkParams(num1, num2);
        return "" + num1 + " * " + num2 + " = " + calculatorService.multiply(num1, num2);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(required = false) Integer num1, Integer num2) {
        checkParams(num1, num2);
        return "" + num1 + " / " + num2 + " = " + calculatorService.divide(num1, num2);
    }

    private void checkParams(Object... params) {
        for (Object param : params) {
            if (param == null) {
                throw new CalculatorBadParams("не верно запалнены параметры!");
            }
        }
    }
}
