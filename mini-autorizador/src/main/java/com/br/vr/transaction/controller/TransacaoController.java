package com.br.vr.transaction.controller;


import com.br.vr.transaction.entity.Transacao;
import com.br.vr.transaction.entity.response.TransacaoResponse;
import com.br.vr.transaction.service.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacaoService transacaoService;


    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TransacaoResponse> realizarTransacao(@RequestBody Transacao transacao) {
        var entity = transacaoService.realizarTransacao(transacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }
}
