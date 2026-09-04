package com.example.desafiotecnico.Controller;

import com.example.desafiotecnico.Model.Tarefa;
import com.example.desafiotecnico.Service.TarefaService;
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
    public List<Tarefa> listaTarefa() {
        return tarefaService.listar();
    }

    @GetMapping("/{indice}")
    public Tarefa buscarPorIndice(@PathVariable int indice) {
        return tarefaService.buscarPorIndice(indice);
    }

    @PostMapping
    public Tarefa adicionar(@RequestBody Tarefa tarefa) {
        return tarefaService.adicionar(tarefa);
    }

    @DeleteMapping("/{indice}")
    public boolean deletar(@PathVariable int indice) {
        return tarefaService.deletar(indice);
    }

    @PutMapping("/{indice}")
    public Tarefa atualizar(@PathVariable int indice, @RequestBody Tarefa tarefa) {
        return tarefaService.atualizar(indice, tarefa);
    }

}

