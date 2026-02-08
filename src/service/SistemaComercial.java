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

import java.util.List;

public interface SistemaComercial {

    boolean existeProduto(String codigoProduto);

    void cadastrarProduto(Produto produto) throws ProdutoExisteException;

    Produto pesquisarProdudoPeloCodigo(String codigoProduto) throws ProdutoNaoExisteException;

    List<Produto> pesquisarProdutosPelaCategoria(CategoriaProduto categoriaProduto);

    void removerProduto(String codigoProduto) throws ProdutoNaoExisteException;

    boolean existeCliente(String email);

    void cadastrarCliente(ClientePf clientePf) throws ClienteExisteException;

    void cadastrarCliente(ClientePj clientePj) throws ClienteExisteException;

    List<Cliente> pesquisarClientePeloNome(String nome) throws ClienteNaoExisteException;

    void removerCliente(String email) throws ClienteNaoExisteException;

}
