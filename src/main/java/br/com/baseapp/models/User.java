package br.com.baseapp.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
    name = "users"
    // uniqueConstraints = @UniqueConstraint(columnNames={"id", "name"})
)
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @NotEmpty(message = "É obrigatório informar um nome completo.")
    private String fullName;
    
    @NotEmpty(message = "É obrigatório informar um nome de usuário.")
    // @Column(unique = true)
    private String name;
    
    @NotEmpty(message = "É obrigatório informar um nome.")
    private String password;
    
    @NotEmpty(message = "É obrigatório informar uma hierarquia.")
    private String hierarchy;
    
}
