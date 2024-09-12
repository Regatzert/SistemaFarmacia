package com.kevin.Farmacia.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.kevin.Farmacia.model.Cliente;
import com.kevin.Farmacia.repository.ClienteRepository;
import com.kevin.Farmacia.service.ClienteService;

@SpringBootTest
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;
    @InjectMocks
    private ClienteService clienteService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveCliente(){
        Cliente cliente = new Cliente();
        cliente.setNombre("Kevin");
        cliente.setDni("72697087");
        cliente.setTelefono("949658424");
        cliente.setEmail("kr.salazar98@gmail.com");

        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente saveCliente = clienteService.saveCliente(cliente);        

        assertNotNull(saveCliente);
        assertEquals("Kevin", saveCliente.getNombre());
    }

    @Test
    void testFindById(){
        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNombre("Kevin");

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        Optional<Cliente> foundCliente = clienteService.findById(1L);

        assertTrue(foundCliente.isPresent());
        assertEquals("Kevin", foundCliente.get().getNombre());
    }

    @Test
    void testFindAll(){
        Cliente cliente = new Cliente();
        cliente.setNombre("Kevin");

        when(clienteRepository.findAll()).thenReturn(Collections.singletonList(cliente));

        List<Cliente> Listclientes = clienteService.findClientes();

        assertFalse(Listclientes.isEmpty());
        assertEquals("Kevin", Listclientes.get(0).getNombre());
    }

    @Test
    void deleteById(){
        clienteService.deleteById(1L);
        verify(clienteRepository, times(1)).deleteById(1L);
    }

    @Test
    void testUpdateCliente() {
        Cliente existingCliente = new Cliente();
        existingCliente.setId(1L);
        existingCliente.setNombre("Kevin");
        existingCliente.setAPaterno("Salazar");
        existingCliente.setAMaterno("Ruiz");
        existingCliente.setDni("72697087");
        existingCliente.setTelefono("949658424");
        existingCliente.setEmail("kr.salazar98@gmail.com");

        Cliente updatedClienteDetails = new Cliente();
        updatedClienteDetails.setNombre("Kevin Updated");
        updatedClienteDetails.setAPaterno("Salazar Updated");
        updatedClienteDetails.setAMaterno("Ruiz Updated");
        updatedClienteDetails.setDni("78709627");
        updatedClienteDetails.setTelefono("4245865949");
        updatedClienteDetails.setEmail("kr.updated@gmail.com");

        when(clienteRepository.findById(1L)).thenReturn(Optional.of(existingCliente));
        when(clienteRepository.save(any(Cliente.class))).thenReturn(existingCliente);

        Cliente updatedCliente = clienteService.updaCliente(1L, updatedClienteDetails);

        assertNotNull(updatedCliente);
        assertEquals("Kevin Updated", updatedCliente.getNombre());
}
}
