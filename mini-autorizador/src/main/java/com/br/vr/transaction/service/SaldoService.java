package com.br.vr.transaction.service;


import com.br.vr.transaction.entity.response.SaldoResponse;
import com.br.vr.transaction.exception.ResourceNotFoundException;
import com.br.vr.transaction.repository.CartaoRepository;
import org.springframework.stereotype.Service;

@Service
public class SaldoService {

    private final CartaoRepository repository;

    public SaldoService(CartaoRepository repository) {
        this.repository = repository;
    }

    public SaldoResponse obterSaldoDoCartao(Long numeroCartao){
        var entity = repository.findById(numeroCartao)
                .orElseThrow(()->new ResourceNotFoundException("Sem body"));

        SaldoResponse response = SaldoResponse
                .builder()
                .saldo(entity.getSaldo())
                .build();

        return response;

    }

}
