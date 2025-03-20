package br.edu.ifsp.pep.bcc.serviceOrder.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="client")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Client {

    @Id
    @Column(name="id")
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name", length = 100)
    @NotBlank(message = "Name can't be empty. ")
    @Size(min = 2, max = 100, message = "Name must contain between 2 and 100 characters. ")
    private String name;

    @Column(name="email", length = 100)
    @Email(message = "Enter a valid email. ")
    @NotBlank(message = "Email can't be empty. ")
    @Size(min = 2, max = 100, message = "Email must contain between 2 and 100 characters. ")
    private String email;

    @Column(name="telephone", length = 100)
    @NotBlank(message = "The telephone can't be empty. ")
    @Size(min = 8, max = 15, message = "Telephone must contain between 2 and 100 characters. ")
    private String telephone;

    @Column(name = "active")
    private int active;

    public Client(int id, String name, String email, String telephone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.active = 1;
    }
}

