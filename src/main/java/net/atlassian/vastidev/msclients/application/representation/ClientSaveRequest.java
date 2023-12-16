package net.atlassian.vastidev.msclients.application.representation;

import lombok.Data;
import net.atlassian.vastidev.msclients.domain.Client;

@Data
public class ClientSaveRequest{

    private String cpf;
    private String name;
    private Integer age;

    public Client toModel(){
        return new Client(cpf, name, age);
    }
}

