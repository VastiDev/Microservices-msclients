package net.atlassian.vastidev.msclients.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String cpf;
    @Column
    private String name;
    @Column
    private Integer age;

    public Client(String cpf, String name, Integer age){
        this.cpf = cpf;
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object otherClient) {
        if (this == otherClient) return true;
        if (otherClient == null || getClass() != otherClient.getClass()) return false;
        Client client = (Client) otherClient;
        return Objects.equals(cpf, client.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
