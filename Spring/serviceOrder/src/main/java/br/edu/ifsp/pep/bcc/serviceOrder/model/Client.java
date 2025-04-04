package br.edu.ifsp.pep.bcc.serviceOrder.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @NotNull
    @Column(name="name", length = 100)
    @NotBlank(message = "Name can't be empty. ")
    @Size(min = 2, max = 100, message = "Name must contain between 2 and 100 characters. ")
    private String name;

    @NotNull
    @Column(name="email", length = 100)
    @Email(message = "Enter a valid email. ")
    @NotBlank(message = "Email can't be empty. ")
    @Size(min = 2, max = 100, message = "Email must contain between 2 and 100 characters. ")
    private String email;

    @NotNull
    @Column(name="phone", length = 100)
    @NotBlank(message = "The phone can't be empty. ")
    @Size(min = 8, max = 15, message = "Phone must contain between 2 and 100 characters. ")
    @Pattern(regexp = "(\\(\\d{2}\\)\\s)(\\d{4,5}\\-\\d{4})", message = "Phone pattern must be (XX) XXXXX-XXXX")
    private String phone;

    @NotNull
    @Column(name = "active")
    private int active;

    public Client(String name, String email, String telephone) {
        this.name = name;
        this.email = email;
        this.phone = telephone;
        this.active = 1;
    }
}
