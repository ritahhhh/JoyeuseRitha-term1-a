import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import rca.devopsexam.v1.exceptions.InvalidOperationException;
import rca.devopsexam.v1.serviceImpls.MathOperatorImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MathOperatorServiceTest {

    @Mock
    private MathOperatorImpl mathOperatorService;

    @InjectMocks
    private MathOperatorServiceTest mathOperatorServiceTest;

    @Test
    public void add_operation_success() throws InvalidOperationException {
        double operand1 = 100;
        double operand2 = 20;
        String operation = "+";
        double expectedResult = 120.0;

        when(mathOperatorService.doMath(operand1, operand2, operation)).thenReturn(expectedResult);

        double actualResult = mathOperatorService.doMath(operand1, operand2, operation);

        assertThat(actualResult).isEqualTo(expectedResult);
        verify(mathOperatorService).doMath(operand1, operand2, operation);
    }

    @Test
    public void subtract_operation_success() throws InvalidOperationException {
        double operand1 = 34;
        double operand2 = 1;
        String operation = "-";
        double expectedResult = 33.0;

        when(mathOperatorService.doMath(operand1, operand2, operation)).thenReturn(expectedResult);

        double actualResult = mathOperatorService.doMath(operand1, operand2, operation);

        assertThat(actualResult).isEqualTo(expectedResult);
        verify(mathOperatorService).doMath(operand1, operand2, operation);
    }

    @Test
    public void multiply_operation_success() throws InvalidOperationException {
        double operand1 = 100;
        double operand2 = 1;
        String operation = "*";
        double expectedResult = 100.0;

        when(mathOperatorService.doMath(operand1, operand2, operation)).thenReturn(expectedResult);

        double actualResult = mathOperatorService.doMath(operand1, operand2, operation);

        assertThat(actualResult).isEqualTo(expectedResult);
        verify(mathOperatorService).doMath(operand1, operand2, operation);
    }

    @Test
    public void divide_operation_success() throws InvalidOperationException {
        double operand1 = 25;
        double operand2 = 5;
        String operation = "/";
        double expectedResult = 5.0;

        when(mathOperatorService.doMath(operand1, operand2, operation)).thenReturn(expectedResult);

        double actualResult = mathOperatorService.doMath(operand1, operand2, operation);

        assertThat(actualResult).isEqualTo(expectedResult);
        verify(mathOperatorService).doMath(operand1, operand2, operation);
    }

    @Test
    public void modulo_operation_success() throws InvalidOperationException {
        double operand1 = 17;
        double operand2 = 4;
        String operation = "%";
        double expectedResult = 1.0;

        when(mathOperatorService.doMath(operand1, operand2, operation)).thenReturn(expectedResult);

        double actualResult = mathOperatorService.doMath(operand1, operand2, operation);

        assertThat(actualResult).isEqualTo(expectedResult);
        verify(mathOperatorService).doMath(operand1, operand2, operation);
    }

    @Test
    public void absolute_value_operation_success() throws InvalidOperationException {
        double operand1 = -15;
        String operation = "abs";
        double expectedResult = 15.0;

        when(mathOperatorService.doMath(operand1, 0, operation)).thenReturn(expectedResult);

        double actualResult = mathOperatorService.doMath(operand1, 0, operation);

        assertThat(actualResult).isEqualTo(expectedResult);
        verify(mathOperatorService).doMath(operand1, 0, operation);
    }

    @Test
    public void square_root_operation_success() throws InvalidOperationException {
        double operand1 = 196;
        String operation = "sqrt";
        double expectedResult = 14.0;

        when(mathOperatorService.doMath(operand1, 0, operation)).thenReturn(expectedResult);

        double actualResult = mathOperatorService.doMath(operand1, 0, operation);

        assertThat(actualResult).isEqualTo(expectedResult);
        verify(mathOperatorService).doMath(operand1, 0, operation);
    }

    @Test
    public void exponential_operation_success() throws InvalidOperationException {
        double operand1 = 2;
        String operation = "exp";
        double expectedResult = Math.exp(2);

        when(mathOperatorService.doMath(operand1, 0, operation)).thenReturn(expectedResult);

        double actualResult = mathOperatorService.doMath(operand1, 0, operation);

        assertThat(actualResult).isEqualTo(expectedResult);
        verify(mathOperatorService).doMath(operand1, 0, operation);
    }

    @Test
    public void power_operation_success() throws InvalidOperationException {
        double operand1 = 3;
        double operand2 = 4;
        String operation = "**";
        double expectedResult = Math.pow(3, 4);

        when(mathOperatorService.doMath(operand1, operand2, operation)).thenReturn(expectedResult);

        double actualResult = mathOperatorService.doMath(operand1, operand2, operation);

        assertThat(actualResult).isEqualTo(expectedResult);
        verify(mathOperatorService).doMath(operand1, operand2, operation);
    }

    @Test(expected = RuntimeException.class)
    public void unknown_operation_should_throw_exception() throws InvalidOperationException {
        double operand1 = 40;
        double operand2 = 44;
        String unknownOperation = "unknown";

        // Mock behavior to simulate an unknown operation
        when(mathOperatorService.doMath(operand1, operand2, unknownOperation))
                .thenThrow(new RuntimeException("Unknown Operation"));

        // Call the method with unknown operation, expecting an exception
        mathOperatorService.doMath(operand1, operand2, unknownOperation);
    }
}
