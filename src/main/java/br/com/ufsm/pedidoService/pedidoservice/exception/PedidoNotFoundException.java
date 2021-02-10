package br.com.ufsm.pedidoService.pedidoservice.exception;

public class PedidoNotFoundException extends RuntimeException{

    private String mensagem;

    public PedidoNotFoundException() {
    }

    public PedidoNotFoundException(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
