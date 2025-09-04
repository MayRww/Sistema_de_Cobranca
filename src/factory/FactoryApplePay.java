package factory;

import pagamento.*;

public class FactoryApplePay extends PagamentoFactory {
    private boolean autenticado;

    public FactoryApplePay(boolean autenticado) {
        this.autenticado = autenticado;
    }

    @Override
    public Pagamento criarPagamento() {
        return new PagamentoApplePay(autenticado);
    }
}
