package com.br.vr.transaction.service;

import com.br.vr.transaction.entity.Cartao;
import com.br.vr.transaction.entity.response.CartaoResponse;
import com.br.vr.transaction.exception.ResourceExistsException;
import com.br.vr.transaction.repository.CartaoRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class CartaoService {

    private final CartaoRepository repository;

    public CartaoService(CartaoRepository repository) {
        this.repository = repository;
    }

    public CartaoResponse save(Cartao cartao) {

        Optional<Cartao> card = repository.findById(cartao.getNumeroCartao());

        if(card.isPresent()){
            throw new ResourceExistsException("Cartão existente");
        }

        var entity = repository.save(cartao);

        CartaoResponse response = CartaoResponse
                .builder()
                .numeroCartao(entity.getNumeroCartao())
                .nomeDoTitular(entity.getNomeDoTitular())
                .dataDeValidade(entity.getDataDeValidade())
                .senha(entity.getSenha())
                .build();

        return response;


}




}
