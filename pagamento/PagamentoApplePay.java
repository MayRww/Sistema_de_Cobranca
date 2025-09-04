package pagamento;

public class PagamentoApplePay implements Pagamento {
    private boolean dispositivoAutenticado;

    public PagamentoApplePay(boolean autenticado) {
        this.dispositivoAutenticado = autenticado;
    }

    @Override
    public String processarPagamento(double valor) {
        if (dispositivoAutenticado) {
            return "Pagamento via Apple Pay aprovado: R$" + valor;
        }
        return "Erro: Dispositivo não autenticado no Apple Pay.";
    }
}
