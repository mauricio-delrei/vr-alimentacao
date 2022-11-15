package com.br.vr.transaction.repository;

import com.br.vr.transaction.entity.Cartao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface CartaoRepository extends CrudRepository<Cartao,Long> {


    Cartao findByNumeroCartaoAndSenha(@Param("numeroCartao")Long numeroCartao,
                                      @Param("senha") Integer senha);


}
