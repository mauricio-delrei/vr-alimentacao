package com.br.vr.transaction.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "SENHA"))
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(of = "numeroCartao")
public class Cartao implements Serializable {

    private static final long serialVersionUID = -358278145542004770L;


    @Id
    @NotNull(message = "Número do cartão obrigatório")
    private Long numeroCartao;

    @NotNull(message = "Nome do titular obrigatório")
    private String nomeDoTitular;

    @NotNull(message = "Data de validade obrigatório")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dataDeValidade = LocalDateTime.now().plusYears(1);

    @NotNull(message = "Codigo de segurança do cartão obrigatório")
    private Integer codigoDeSeguranca;


    @NotNull(message = "Senha do cartão obrigatório")
    private Integer senha;


    private Double saldo = 500.00;

}
