import java.time.LocalDate;

interface Fornecedor {
  public String emitirFaturaDoPeriodo(LocalDate inicio, LocalDate fim);
}