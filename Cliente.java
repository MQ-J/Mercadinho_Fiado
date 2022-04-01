import java.time.LocalDate;

interface Cliente {
  public String obterPedidosDoPeriodo(LocalDate inicio, LocalDate fim);
}