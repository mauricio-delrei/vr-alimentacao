package com.br.vr.transaction.repository;

import com.br.vr.transaction.entity.Transacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends CrudRepository<Transacao,Long> {
}
