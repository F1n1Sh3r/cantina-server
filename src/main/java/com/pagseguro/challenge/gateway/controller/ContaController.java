package com.pagseguro.challenge.gateway.controller;

import com.pagseguro.challenge.gateway.request.ContaServiceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequestMapping("gateway/conta")//pre-path
public class ContaController
{
    @Autowired
    private ContaServiceRequest contaServiceRequest;

    @PostMapping //gateway/conta
    public ResponseEntity<?> saveConta(@RequestBody Object conta)
    {
        return new ResponseEntity<>(contaServiceRequest.saveConta(conta), HttpStatus.CREATED);
    }

    @DeleteMapping("{contaId}")//gateway/conta/{contaId}
    public ResponseEntity<?> deleteCourse(@PathVariable Long contaId)
    {
        contaServiceRequest.deleteCourse(contaId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping//gateway/conta
    public ResponseEntity<?> getAllContas()
    {
        return ResponseEntity.ok(contaServiceRequest.getAllContas());
    }

    @GetMapping ("/filter-nome/{nome}")//api/conta
    public ResponseEntity<?> getByName(@PathVariable String nome) throws IOException {
        return ResponseEntity.ok(contaServiceRequest.getByName(nome));
    }

    @GetMapping ("/filter-agencia/{agencia}")//api/conta
    public ResponseEntity<?> getByAgency(@PathVariable String agencia) throws IOException {
        return ResponseEntity.ok(contaServiceRequest.getByAgency(agencia));
    }

    @GetMapping ("/filter-cheque-especial/{cheque}")//api/conta
    public ResponseEntity<?> getByCheck(@PathVariable String cheque) throws IOException {
        return ResponseEntity.ok(contaServiceRequest.getByCheck(cheque));
    }

    @GetMapping ("/detalhe/{numeroConta}")//api/conta
    public ResponseEntity<?> getDetails(@PathVariable String numeroConta) throws IOException {
        return ResponseEntity.ok(contaServiceRequest.getDetails(numeroConta));
    }
    @PostMapping("/upload")
    public ResponseEntity<?> uploadCsv() throws IOException {
        contaServiceRequest.uploadCsv();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
