package service;

import Enums.CategoriaProduto;
import models.Cliente;
import models.ClientePf;
import models.ClientePj;
import models.Produto;
import service.exceptions.ClienteExisteException;
import service.exceptions.ClienteNaoExisteException;
import service.exceptions.ProdutoExisteException;
import service.exceptions.ProdutoNaoExisteException;

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
    public void cadastrarProduto(Produto produto) throws ProdutoExisteException {
        if (existeProduto(produto.getCodigo())){
            throw new ProdutoExisteException("Tente novamente, produto já existe");
        }

        mapDeProduto.put(produto.getCodigo(), produto);

    }

    @Override
    public Produto pesquisarProdudoPeloCodigo(String codigoProduto) throws ProdutoNaoExisteException {
        if (!existeProduto(codigoProduto)){
            throw new ProdutoNaoExisteException("Tente novamente, produto não existe");
        }

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
    public void removerProduto(String codigoProduto) throws ProdutoNaoExisteException {
        if (!existeProduto(codigoProduto)){
            throw  new ProdutoNaoExisteException("Tente novamente, esse codigo não existe");
        }

        mapDeProduto.remove(codigoProduto);

    }

    @Override
    public boolean existeCliente(String email) {
        mapaDeClientes.containsKey(email);
        return false;
    }

    @Override
    public void cadastrarCliente(ClientePf clientePf) throws ClienteExisteException {
        if (existeCliente(clientePf.getEmail())){
            throw new ClienteExisteException("Tente novamente, esse cliente já existe");
        }

        mapaDeClientes.put(clientePf.getEmail(), clientePf);

    }

    @Override
    public void cadastrarCliente(ClientePj clientePj) throws ClienteExisteException {
        if (existeCliente(clientePj.getEmail())){
            throw new ClienteExisteException("Tente novamente, esse cliente já existe");
        }

        mapaDeClientes.put(clientePj.getEmail(), clientePj);
    }

    @Override
    public List<Cliente> pesquisarClientePeloNome(String nome) throws ClienteNaoExisteException {

        List<Cliente> clientePesquisado = new ArrayList<>();

        for (Cliente clients : mapaDeClientes.values()){
            if (clients.getNome().equalsIgnoreCase(nome)){
                clientePesquisado.add(clients);
            }
        }
        if (clientePesquisado.isEmpty()){
            throw new ClienteNaoExisteException("Tente novamante, esse cliente não existe");
        }
        return clientePesquisado;
    }

    @Override
    public void removerCliente(String email) throws ClienteNaoExisteException {
        if (!existeCliente(email)){
            throw new ClienteNaoExisteException("Tente novamente, não existe cliente com esse email!");
        }

        mapaDeClientes.remove(email);

    }
}
