package net.atlassian.vastidev.msclients.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import net.atlassian.vastidev.msclients.application.representation.ClientSaveRequest;
import net.atlassian.vastidev.msclients.domain.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor

@Slf4j
public class ClientController {

    private final ClientService service;

    @GetMapping
    public String status(){
        log.info("Obtendo o status do microservice de clientes");
        return "ok";
    }

    @PostMapping
    public ResponseEntity save(@RequestBody ClientSaveRequest request){
        var client = request.toModel();
        service.save(client);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(client.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity datasClient(@RequestParam("cpf") String cpf){
        var client = service.getByCPF(cpf);
        log.info("acessou get cpf");
        if(client.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);

    }
}

