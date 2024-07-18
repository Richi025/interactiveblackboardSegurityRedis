package co.edu.escuelaing.interactiveblackboard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

import co.edu.escuelaing.interactiveblackboard.repositories.TicketRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TicketRepositoryTest {

    @Autowired
    private StringRedisTemplate mockStringRedisTemplate;

    @Autowired
    private ListOperations<String, String> mockListOperations;

    @Autowired
    private TicketRepository ticketRepository;

    @Test
    public void testGetTicket() {
        // Configurar el comportamiento del mock para la operación leftPush()
        when(mockListOperations.leftPush(anyString(), anyString())).thenReturn(1L);

        Integer ticket = ticketRepository.getTicket();

        assertNotNull(ticket);
        assertTrue(ticket >= 0); // Asumiendo que los tickets son no negativos
    }

    @Test
    public void testCheckTicket() {
        String testTicket = "12345";

        // Configurar el comportamiento del mock para la operación boundListOps().remove()
        when(mockListOperations.getOperations().boundListOps(anyString()).remove(eq(0), eq(testTicket))).thenReturn(1L);
        System.out.println("df" + mockListOperations.getOperations().boundListOps(anyString()).remove(eq(0), eq(testTicket))).thenReturn(1L));
        boolean isValid = ticketRepository.checkTicket(testTicket);

        assertTrue(isValid);
    }
}

