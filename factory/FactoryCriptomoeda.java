package factory;

import pagamento.Pagamento;
import pagamento.PagamentoCriptomoeda;

public class FactoryCriptomoeda extends PagamentoFactory {
    private PagamentoCriptomoeda.Moeda moeda;
    private double saldoCarteira;

    public FactoryCriptomoeda(PagamentoCriptomoeda.Moeda moeda, double saldoCarteira) {
        this.moeda = moeda;
        this.saldoCarteira = saldoCarteira;
    }

    @Override
    public Pagamento criarPagamento() {
        return new PagamentoCriptomoeda(moeda, saldoCarteira);
    }
}
