import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @PostMapping("/doMath")
    public ResponseEntity<CalcResponse> doMath(@RequestBody DoMathRequest doMathRequest) {
        double operand1 = doMathRequest.getOperand1();
        double operand2 = doMathRequest.getOperand2();
        String operation = doMathRequest.getOperation();
        double result;

        switch (operation) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                if (operand2 == 0) {
                    return ResponseEntity.badRequest().build(); // Return bad request for division by zero
                }
                result = operand1 / operand2;
                break;
            default:
                return ResponseEntity.badRequest().build(); // Invalid operation
        }

        CalcResponse calcResponse = new CalcResponse(result);
        return ResponseEntity.ok(calcResponse);
    }
}
