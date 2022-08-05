package bragagustavo.com.github.TeraBank.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CheckingAccountNoPassword {

     private Integer id;

    @Column(name = "nome")
    @NotEmpty(message = "Campo nome nao pode ser vazio")
    @Length(min = 5, max = 120, message = "O campo nome deve possuir no mínimo 5 e no máximo 120 caracteres")
    private String name;

    @Column(name = "endereco")
    @NotEmpty(message = "Campo endereço é obrigatório")
    @Length(min = 10, max = 150, message = "O campo endereço deve possuir no mínimo 10 e no máximo 150 caracteres")
    private String adress;

    @Column(name = "agencia")
    private String agency;

    @Column( name = "cpf", unique = true)
    @CPF
    @NotEmpty(message = "Campo CPF é obrigatório")
    private String cpf;

    @Column(name = "saldo")
    private BigDecimal balance;

    @Column(name = "nascimento")
    @NotEmpty(message = "Campo nascimento é obrigatório")
    @Length(min = 8, max = 11, message = "O campo nascimento deve possuir o seguinte formado dd/mm/aaaa")
    private String birth;

    @Column(name = "email")
    @NotEmpty(message = "Camo e-mail é obrigatório")
    @Email(message = "E-mail inválido")
    private String email;

    @Column(name = "conta", unique = true)
    private Double number;

}