package rca.devopsexam.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import rca.devopsexam.v1.dtos.DoMathRequestDto;
import rca.devopsexam.v1.payload.ApiResponse;

import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MathControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void doMathOperation_Success() {
        // Given
        DoMathRequestDto dto = new DoMathRequestDto(100, 20, "+");

        // When
        ResponseEntity<ApiResponse> response = this.restTemplate.postForEntity("/api/v1/do_math", dto, ApiResponse.class);

        // Then
        assertEquals(200, response.getStatusCode().value());

        // Ensure the API response contains a valid result
        assertTrue(Objects.requireNonNull(response.getBody()).isSuccess());
        assertNotNull(response.getBody().getData());

        // Verify the calculated result matches the expected value
        double expectedResult = 120; // Expected result for 100 + 20
        double actualResult = Double.parseDouble(response.getBody().getData().toString());
        assertEquals(expectedResult, actualResult, 0.001); // Specify a delta for comparison accuracy
    }
}
