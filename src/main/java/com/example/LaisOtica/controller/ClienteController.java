package com.example.LaisOtica.controller;

import com.example.LaisOtica.model.Cliente;
import com.example.LaisOtica.model.Lente;
import com.example.LaisOtica.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @ResponseBody
    @RequestMapping("/clientes")
    public List<Cliente> listar() {

        List<Cliente> clientes = clienteRepository.findAll();
        return clientes;
        /*try {
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            Date data = df.parse("11/22/2024");
            Cliente cliente = new Cliente(1L, "Nome do Cliente", "cliente@email.com", 1234567890, data, Lente.TIPO1);
            return Arrays.asList(cliente); // Retorna uma lista com o cliente
        } catch (ParseException e) {
            e.printStackTrace();
            // Trate a exceção adequadamente, por exemplo, retornando uma lista vazia ou lançando uma exceção
            return Arrays.asList();
        }*/

    }
    @ResponseBody
    @Transactional
    @RequestMapping(path = "/clientes", method = RequestMethod.POST)
    public void salvar(@RequestBody Cliente cliente) {

        clienteRepository.save(cliente);
    }
    @ResponseBody
    @Transactional
    @RequestMapping(path = "/clientes", method = RequestMethod.PUT)
    public void atualizar(@RequestBody Cliente cliente) {
        clienteRepository.save(cliente);
    }
    @ResponseBody
    @Transactional
    @RequestMapping(path = "/clientes/{id}", method = RequestMethod.DELETE)
    public void deletar(@PathVariable Long id){

        clienteRepository.deleteById(id);

    }

}
