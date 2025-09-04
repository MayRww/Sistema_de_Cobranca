package pagamento;
public class PagamentoPayPal implements Pagamento {
    private String email;

    public PagamentoPayPal(String email) {
        this.email = email;
    }

    private boolean validarContaPayPal() {
        // Simulação: e-mail válido deve conter "@" e "paypal.com"
        return email != null && email.contains("@") && email.endsWith("paypal.com");
    }

    @Override
    public String processarPagamento(double valor) {
        if (!validarContaPayPal()) {
            return "Erro: Conta PayPal inválida ou não vinculada ao e-mail.";
        }
        return "Pagamento via PayPal aprovado: R$" + valor;
    }
}
