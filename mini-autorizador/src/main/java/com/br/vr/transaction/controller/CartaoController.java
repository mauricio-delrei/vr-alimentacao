package com.br.vr.transaction.controller;


import com.br.vr.transaction.entity.Cartao;
import com.br.vr.transaction.entity.response.CartaoResponse;
import com.br.vr.transaction.entity.response.SaldoResponse;
import com.br.vr.transaction.service.CartaoService;
import com.br.vr.transaction.service.SaldoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cartoes")
public class CartaoController {

    private final CartaoService cartaoService;
   private final SaldoService saldoService;



    public CartaoController(CartaoService cartaoService, SaldoService saldoService) {
        this.cartaoService = cartaoService;
       this.saldoService = saldoService;
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartaoResponse>save(@RequestBody Cartao cartao){
        var entity = cartaoService.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @GetMapping(value = "/numeroCartao/{numeroCartao}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SaldoResponse>obterSaldoDoCartao(@PathVariable("numeroCartao")Long numeroCartao){

        var entity = saldoService.obterSaldoDoCartao(numeroCartao);

        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }
}
