import factory.PagamentoFactory;
import pagamento.Pagamento;

public class PagamentoService {

    public String processarPagamento(PagamentoFactory factory, double valor) {
        Pagamento pagamento = factory.criarPagamento();
        return pagamento.processarPagamento(valor);
    }
}
