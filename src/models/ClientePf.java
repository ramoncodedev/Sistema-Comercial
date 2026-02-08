package models;

public class ClientePf extends Cliente{

    private String cpf;

    public ClientePf(){

    }


    public ClientePf(String nome, String endereco, String email, String cpf) {
        super(nome, endereco, email);
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Nome: " + super.getNome() + "Endereço: " + super.getEndereco() + "Email: " +
                super.getEmail() + "CPF: " + cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
