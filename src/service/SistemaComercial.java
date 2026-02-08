package service;

import Enums.CategoriaProduto;
import models.Cliente;
import models.ClientePf;
import models.ClientePj;
import models.Produto;

import java.util.List;

public interface SistemaComercial {

    boolean existeProduto(String codigoProduto);

    void cadastrarProduto(Produto produto);

    Produto pesquisarProdudoPeloCodigo(String codigoProduto);

    List<Produto> pesquisarProdutosPelaCategoria(CategoriaProduto categoriaProduto);

    void removerProduto(String codigoProduto);

    boolean existeCliente(String email);

    void cadastrarCliente(ClientePf clientePf);

    void cadastrarCliente(ClientePj clientePj);

    List<Cliente> pesquisarClientePeloNome(String nome);

    void removerCliente(String email);

}
