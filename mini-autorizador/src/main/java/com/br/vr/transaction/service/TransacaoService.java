package com.br.vr.transaction.service;

import com.br.vr.transaction.entity.Cartao;
import com.br.vr.transaction.entity.Transacao;
import com.br.vr.transaction.entity.response.TransacaoResponse;
import com.br.vr.transaction.exception.ResourceNotFoundException;
import com.br.vr.transaction.repository.CartaoRepository;
import com.br.vr.transaction.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class TransacaoService {

    private final CartaoRepository repository;

    private final TransacaoRepository transacaoRepository;

    public TransacaoService(CartaoRepository repository,TransacaoRepository transacaoRepository) {
        this.repository = repository;
        this.transacaoRepository = transacaoRepository;
    }

    public TransacaoResponse realizarTransacao(Transacao transacao) {

        var entity = repository.findByNumeroCartaoAndSenha(transacao.getNumeroCartao(),
                transacao.getSenha());

        if(entity == null){
            throw  new ResourceNotFoundException("CARTAO_INEXISTENTE E/OU SENHA_INVALIDA");
        }

        if (transacao.getValor() > entity.getSaldo()) {
            throw new ResourceNotFoundException("SALDO_INSUFICIENTE");
        }

        Double saldoAtualDoCartao = entity.getSaldo() - transacao.getValor();

        Cartao cartao = Cartao
                .builder()
                .numeroCartao(entity.getNumeroCartao())
                .nomeDoTitular(entity.getNomeDoTitular())
                .dataDeValidade(entity.getDataDeValidade())
                .codigoDeSeguranca(entity.getCodigoDeSeguranca())
                .senha(entity.getSenha())
                .saldo(saldoAtualDoCartao)
                .build();

        var card = repository.save(cartao);

        var trans = transacaoRepository.save(transacao);

        TransacaoResponse response = TransacaoResponse
                .builder()
                .numeroCartao(trans.getNumeroCartao())
                .senha(trans.getSenha())
                .dataTransacao(LocalDateTime.now())
               .valor(trans.getValor())
                .build();
        return response;
    }

}
