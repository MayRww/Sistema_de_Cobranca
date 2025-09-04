package pagamento;

public class PagamentoCartaoCredito implements Pagamento {
    private String numeroCartao;

    public PagamentoCartaoCredito(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    private boolean validarCartao() {
        // Validação fictícia: número deve ter 16 dígitos
        return numeroCartao != null && numeroCartao.matches("\\d{16}");
    }

    @Override
    public String processarPagamento(double valor) {
        if (!validarCartao()) {
            return "Erro: Número de cartão inválido.";
        }
        return "Pagamento com Cartão de Crédito aprovado: R$" + valor;
    }
}
