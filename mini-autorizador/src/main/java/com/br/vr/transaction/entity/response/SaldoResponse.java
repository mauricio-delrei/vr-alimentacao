package com.br.vr.transaction.entity.response;

import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaldoResponse implements Serializable{


    private static final long serialVersionUID = -3914096847659693316L;

    private Double saldo;
}
