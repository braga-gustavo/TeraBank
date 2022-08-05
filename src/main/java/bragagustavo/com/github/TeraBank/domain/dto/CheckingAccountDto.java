package bragagustavo.com.github.TeraBank.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckingAccountDto {

     private Integer id;

    @NotEmpty(message = "Campo endereço é obrigatório")
    @Length(min = 15, max = 150, message = "O campo enderdeve possuir no mínimo 15 e no máximo 150 caracteres")
    private String adress;

    @NotEmpty(message = "Camo e-mail é obrigatório")
    @Email(message = "E-mail inválido")
    private String email;

    @NotEmpty(message = "O campo senha é obrigatório")
    @Length(min = 6, max = 6, message = "O campo senha deve possuir 6 digitos")
    private String password;

}