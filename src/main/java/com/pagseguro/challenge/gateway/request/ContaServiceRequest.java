package com.pagseguro.challenge.gateway.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@FeignClient(value = "conta-service"//Name of conta-service application
        , path = "/api/conta"
        //Pre-path for conta-service
        //,url = "${conta.service.url}"
        ,configuration = FeignConfiguration.class
)
public interface ContaServiceRequest
{
    @PostMapping///api/conta
    Object saveConta(@RequestBody Object requestBody);

    @DeleteMapping("{contaId}")//api/conta/{contaId}
    void deleteCourse(@PathVariable("contaId") Long courseId);

    @GetMapping//api/conta
    List<Object> getAllContas();

    @GetMapping ("/filter-nome/{nome}")//api/conta
    List<Object> getByName(@PathVariable("nome") String nome) throws IOException ;

    @GetMapping ("/filter-agencia/{agencia}")//api/conta
    List<Object> getByAgency(@PathVariable("agencia") String agencia) throws IOException ;

    @GetMapping ("/filter-cheque-especial/{cheque}")//api/conta
    List<Object>getByCheck(@PathVariable("cheque") String cheque) throws IOException ;

    @GetMapping ("/detalhe/{numeroConta}")//api/conta
    List<Object>getDetails(@PathVariable("numeroConta") String detalhe) throws IOException ;

    @PostMapping("/upload/{type}")
    void uploadCsv() throws IOException ;
}
