package br.com.baseapp.dtos.users;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class UserCreateDto {
    
    @NotEmpty(message = "É obrigatório informar um nome completo.")
    private String fullName;
    
    @NotEmpty(message = "É obrigatório informar um nome de usuário.")
    private String name;
    
    @NotEmpty(message = "É obrigatório informar um nome.")
    private String password;
    
    @NotEmpty(message = "É obrigatório informar uma hierarquia.")
    private String hierarchy;
}
