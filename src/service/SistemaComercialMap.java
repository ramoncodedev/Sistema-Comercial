package service;

import Enums.CategoriaProduto;
import models.Cliente;
import models.ClientePf;
import models.ClientePj;
import models.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaComercialMap implements SistemaComercial {


    Map<String, Cliente> mapaDeClientes = new HashMap<>();
    Map<String, Produto> mapDeProduto = new HashMap<>();

    @Override
    public boolean existeProduto(String codigoProduto) {
        return mapDeProduto.containsKey(codigoProduto);
    }

    @Override
    public void cadastrarProduto(Produto produto) {
        mapDeProduto.put(produto.getCodigo(), produto);

    }

    @Override
    public Produto pesquisarProdudoPeloCodigo(String codigoProduto) {
        return mapDeProduto.get(codigoProduto);
    }

    @Override
    public List<Produto> pesquisarProdutosPelaCategoria(CategoriaProduto categoriaProduto) {
        List<Produto> pesquisarProduto = new ArrayList<>();

        for (Produto p : mapDeProduto.values()){
            if (p.getCategoriaProduto().equals(categoriaProduto)){
                pesquisarProduto.add(p);
            }
        }

        return pesquisarProduto;
    }

    @Override
    public void removerProduto(String codigoProduto) {
        mapDeProduto.remove(codigoProduto);

    }

    @Override
    public boolean existeCliente(String email) {
        mapaDeClientes.containsKey(email);
        return false;
    }

    @Override
    public void cadastrarCliente(ClientePf clientePf) {
        mapaDeClientes.put(clientePf.getEmail(), clientePf);

    }

    @Override
    public void cadastrarCliente(ClientePj clientePj) {
        mapaDeClientes.put(clientePj.getEmail(), clientePj);
    }

    @Override
    public List<Cliente> pesquisarClientePeloNome(String nome) {
        List<Cliente> clientePesquisado = new ArrayList<>();

        for (Cliente clients : mapaDeClientes.values()){
            if (clients.getNome().equalsIgnoreCase(nome)){
                clientePesquisado.add(clients);
            }
        }
        return clientePesquisado;
    }

    @Override
    public void removerCliente(String email) {
        mapaDeClientes.remove(email);

    }
}
