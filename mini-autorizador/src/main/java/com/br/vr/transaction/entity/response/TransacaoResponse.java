package com.br.vr.transaction.entity.response;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransacaoResponse implements Serializable {


    private static final long serialVersionUID = 4081810727057833628L;

    private Long numeroCartao;

    private Integer senha;

    private LocalDateTime dataTransacao;

    private Double valor = 0.00;


}
