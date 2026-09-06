package com.example.desafiotecnico.Controller;

import com.example.desafiotecnico.Model.Tarefa;
import com.example.desafiotecnico.Service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService){
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> listaTarefa() {
        return ResponseEntity.ok(tarefaService.listar());
    }

    @GetMapping("/{indice}")
    public ResponseEntity<Tarefa> buscarPorIndice(@PathVariable int indice) {
        Tarefa tarefa = tarefaService.buscarPorIndice(indice);
        if (tarefa == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tarefaService.buscarPorIndice(indice));
    }

    @PostMapping
    public ResponseEntity<Tarefa> adicionar(@RequestBody Tarefa tarefa) {
        Tarefa novaTarefa = tarefaService.adicionar(tarefa);
        return ResponseEntity.status(201).body(novaTarefa);
    }

    @DeleteMapping("/{indice}")
    public ResponseEntity<Void> deletar(@PathVariable int indice) {

        if(indice < 0 || indice >= tarefaService.quantidadeTarefas()) {
            return ResponseEntity.notFound().build();
        }
        tarefaService.deletar(indice);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{indice}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable int indice, @RequestBody Tarefa tarefa) {
        if(indice < 0 || indice >= tarefaService.quantidadeTarefas()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(201).body(tarefaService.atualizar(indice, tarefa));
    }

}

