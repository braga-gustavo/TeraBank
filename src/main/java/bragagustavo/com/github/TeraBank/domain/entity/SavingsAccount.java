package bragagustavo.com.github.TeraBank.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

//Conta poupança
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "savings_account")
public class SavingsAccount {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "endereco")
    @NotEmpty(message = "Campo endereço é obrigatório")
    @Length(min = 15, max = 150, message = "O campo endereço deve possuir no mínimo 15 e no máximo 150 caracteres")
    private String adress;

    @Column(name = "agencia")
    @NotEmpty(message = "O campo agência é obrigatório")
    @Length(min = 4, max = 4, message = "A agência possui 4 digitos")
    private String agency;

    @Column(name = "saldo")
    private String balance;

    @Column(name = "nascimento")
    @NotEmpty(message = "Campo endereço é obrigatório")
    @Length(min = 15, max = 150, message = "O campo nascimento deve possuir o seguinte formado dd/mm/aaaa")
    private String birth;

    @Column(name = "cpf", unique = true )
    @CPF
    @NotEmpty(message = "Campo CPF é obrigatório")
    private String cpf;

    @Column(name = "email", unique = true)
    @NotEmpty(message = "Campo e-mail é obrigatório")
    @Email(message = "E-mail inválido")
    private String email;

    @Column(name = "nome")
    @NotEmpty(message = "Campo nome é obrigatório")
    @Length(min = 5, max = 120, message = "O campo nome deve possuir no mínimo 5 e no máximo 120 caracteres")
    private String name;

    @Column(name = "conta")
    private Double number;


    @Column(name = "password")
    @NotEmpty(message = "O campo senha é obrigatório")
    @Length(min = 6, max = 6, message = "O campo senha deve possuir 6 digitos")
    private String password;

}