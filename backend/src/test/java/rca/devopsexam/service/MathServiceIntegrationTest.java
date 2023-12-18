package rca.devopsexam.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MathServiceIntegrationTest {

    @Autowired
    private MathService mathService;

    @Test
    public void testAddition() {
        double result = mathService.add(5, 7);
        assertEquals(12, result);
    }

    @Test
    public void testSubtraction() {
        double result = mathService.subtract(10, 4);
        assertEquals(6, result);
    }

    @Test
    public void testMultiplication() {
        double result = mathService.multiply(3, 5);
        assertEquals(15, result);
    }

    @Test
    public void testDivision() {
        double result = mathService.divide(20, 5);
        assertEquals(4, result);
    }
}
