package models;

public class ClientePj extends Cliente{

    private String cnpj;

    public ClientePj(String nome, String endereco, String email, String cnpj) {
        super(nome, endereco, email);
        this.cnpj = cnpj;
    }


    @Override
    public String toString() {
        return "Nome: " + super.getNome() + "Endereço: " +
                super.getEndereco() + "Email: " + super.getEmail() + "CNPJ: " + cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
