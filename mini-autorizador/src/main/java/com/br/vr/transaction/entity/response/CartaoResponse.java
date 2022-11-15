package com.br.vr.transaction.entity.response;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartaoResponse implements Serializable{

    private Long numeroCartao;

    private Integer senha;

    private String nomeDoTitular;

    private LocalDateTime dataDeValidade;
}
