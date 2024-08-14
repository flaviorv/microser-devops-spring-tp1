package com.client_service;

import com.client_service.model.domain.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClientServiceApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }


    @Test
    @Order(1)
    @DisplayName("Registrar cliente")
    void salvar() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setNome("Maria");
        cliente.setEndereco("Travessa João Paulo, Caxangá, Rio de Janeiro - RJ");

        ObjectMapper objectMapper = new ObjectMapper();
        String clienteJson = objectMapper.writeValueAsString(cliente);

        mockMvc.perform(post("/cliente").contentType(MediaType.APPLICATION_JSON).content(clienteJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nome").value("Maria"))
                .andExpect(jsonPath("$.endereco").value("Travessa João Paulo, Caxangá, Rio de Janeiro - RJ"));
    }

    @Test
    @Order(2)
    @DisplayName("Remover cliente")
    void removeCliente() throws Exception {
        mockMvc.perform(delete("/cliente/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nome").value("Maria"))
                .andExpect(jsonPath("$.endereco").value("Travessa João Paulo, Caxangá, Rio de Janeiro - RJ"));
    }

    @Test
    @Order(3)
    @DisplayName("Lancar excessao ao tentar remover cliente com id inexistente")
    void removerIdInexistente() throws Exception {
        mockMvc.perform(delete("/cliente/1"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").value("Id de cliente não encontrado."));
    }


}
