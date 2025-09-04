package pagamento;

public class PagamentoCriptomoeda implements Pagamento {

    public enum Moeda { BTC, ETH, USDT, DOGE, SHIBA }

    private Moeda moeda;
    private double saldoCarteira;

    public PagamentoCriptomoeda(Moeda moeda, double saldoCarteira) {
        this.moeda = moeda;
        this.saldoCarteira = saldoCarteira;
    }

    private boolean temSaldo(double valor) {
        return saldoCarteira >= valor;
    }

    @Override
    public String processarPagamento(double valor) {
        if (!temSaldo(valor)) {
            return "Erro: Saldo insuficiente em " + moeda;
        }
        return "Pagamento com " + moeda + " aprovado: R$" + valor;
    }
}
