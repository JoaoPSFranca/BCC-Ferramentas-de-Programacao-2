package br.edu.ifsp.pep.bcc.estoque.exceptions;

public class ClientNotFoundException extends RuntimeException {
    public ClientNotFoundException() {
        super("Client not found");
        // Apenas testando
    }
}
