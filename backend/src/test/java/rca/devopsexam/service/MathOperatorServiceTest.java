package rca.devopsexam.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import rca.devopsexam.v1.exceptions.InvalidOperationException;
import rca.devopsexam.v1.serviceImpls.MathOperatorImpl;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MathOperatorServiceTest {

    @InjectMocks
    private MathOperatorImpl mathOperatorService;

    @Test
    public void should_create_math_operation_success() throws InvalidOperationException {
        double operator1 = 4;
        double operator2 = 9;
        String operation = "+";

        double mathOperation = mathOperatorService.doMath(operator1, operator2, operation);
        when(mathOperatorService.doMath(operator1, operator2, operation)).thenReturn(mathOperation);

        double actualMathOperator = mathOperatorService.doMath(operator1, operator2, operation);

        assertThat(mathOperation).usingRecursiveComparison().isEqualTo(actualMathOperator);
    }

    @Test(expected = InvalidOperationException.class)
    public void should_throw_exception_when_dividing_by_zero() throws InvalidOperationException {
        double operator1 = 8;
        double operator2 = 0;
        String operation = "/";

        mathOperatorService.doMath(operator1, operator2, operation);
    }

    @Test
    public void should_subtract_correctly() throws InvalidOperationException {
        double operator1 = 10;
        double operator2 = 7;
        String operation = "-";

        double result = mathOperatorService.doMath(operator1, operator2, operation);

        assertEquals(3, result, 0); // Ensure the subtraction operation returns the correct result
    }

    @Test
    public void should_multiply_correctly() throws InvalidOperationException {
        double operator1 = 5;
        double operator2 = 4;
        String operation = "*";

        double result = mathOperatorService.doMath(operator1, operator2, operation);

        assertEquals(20, result, 0); // Ensure the multiplication operation returns the correct result
    }


}



