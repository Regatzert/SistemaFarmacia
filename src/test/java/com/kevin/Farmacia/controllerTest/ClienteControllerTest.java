package com.kevin.Farmacia.controllerTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.apache.tomcat.util.http.parser.MediaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kevin.Farmacia.controller.ClienteController;
import com.kevin.Farmacia.model.Cliente; 
import com.kevin.Farmacia.service.ClienteService;

@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    ClienteService clienteService;

    @InjectMocks
    ClienteController clienteController;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    // @Test
    // void testCreateCliente() throws Exception{
    //     Cliente cliente = new Cliente();
    //     cliente.setNombre("Kevin");
    //     cliente.setDni("72697087");
    //     cliente.setTelefono("949658424");
    //     cliente.setEmail("kr.salazar98@gmail.com");

    //     when(clienteService.saveCliente(any(Cliente.class))).thenReturn(cliente);

    //     mockMvc.perform(post("/api/clientes")
    //             .contentType(MediaType.APPLICATION_JSON) )
    // }
    
}
