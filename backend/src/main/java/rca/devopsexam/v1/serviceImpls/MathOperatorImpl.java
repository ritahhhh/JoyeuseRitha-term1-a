package rca.devopsexam.v1.serviceImpls;

import org.springframework.stereotype.Service;
import rca.devopsexam.v1.exceptions.InvalidOperationException;
import rca.devopsexam.v1.services.IMathOperator;

@Service
public class MathOperatorImpl implements IMathOperator {

    @Override
    public double doMath(double operand1, double operand2, String operation) throws InvalidOperationException {
        if ("/".equals(operation) && operand2 == (double) 0) {
            throw new InvalidOperationException("Cannot divide by 0");
        }

        switch (operation) {
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "**":
                return Math.pow(operand1, operand2);
            case "log":
                return operand1 * Math.log10(operand2);
            case "ln":
                return operand1 * Math.log(operand2);
            default:
                throw new RuntimeException("Unknown Operation");
        }
    }
}
