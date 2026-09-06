package com.example.desafiotecnico.Service;

import com.example.desafiotecnico.Model.Tarefa;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class TarefaService {
    private final ArrayList<Tarefa> listaTarefa = new ArrayList<>();

    // listar todos
    public List<Tarefa> listar() {
        return listaTarefa;
    }

    // buscar por índice
    public Tarefa buscarPorIndice(int indice) {
        if (indice < 0 || indice >= listaTarefa.size()) {
            return null;
        }
        return listaTarefa.get(indice);
    }

    // adicionar
    public Tarefa adicionar(Tarefa tarefa) {
        listaTarefa.add(tarefa);
        return tarefa;
    }

    // atualizar
    public Tarefa atualizar(int indice, Tarefa tarefa) {
        if (indice < 0 || indice >= listaTarefa.size()) {
            return null;
        }
        listaTarefa.set(indice, tarefa);
        return tarefa;
    }

    // deletar
    public boolean deletar(int indice) {
        if (indice < 0 || indice >= listaTarefa.size()) {
            return false;
        }
        listaTarefa.remove(indice);
        return true;
    }

    public int quantidadeTarefas() {
        return listaTarefa.size();
    }
}
