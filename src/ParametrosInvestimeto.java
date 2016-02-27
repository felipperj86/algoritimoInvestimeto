import java.math.BigDecimal;

public class ParametrosInvestimeto implements Comparable{

    private String nomeCorretora;
    private String nomeBanco;
    private TipoRendaFixa tipoRendaFixa;
    private int prazo;
    private BigDecimal taxaPercentual;
    private boolean cdi = false;
    private boolean ipca = false;
    private boolean percentualFixo = false;
    private BigDecimal valorMinimo;
    private String rating;
    private String agenciaClassificador;
    private Liquidez tipoLiquidez;
    private BigDecimal preco;
    private BigDecimal percentualRendimentoCalculado = BigDecimal.ZERO;

    public ParametrosInvestimeto() {
    }

    public ParametrosInvestimeto(String nomeCorretora, String nomeBanco, TipoRendaFixa tipoRendaFixa, int prazo, BigDecimal taxaPercentual, boolean cdi, boolean ipca, boolean percentualFixo, BigDecimal valorMinimo, String rating, String agenciaClassificador, Liquidez tipoLiquidez, BigDecimal preco, BigDecimal percentualRendimentoCalculado) {
        this.nomeCorretora = nomeCorretora;
        this.nomeBanco = nomeBanco;
        this.tipoRendaFixa = tipoRendaFixa;
        this.prazo = prazo;
        this.taxaPercentual = taxaPercentual;
        this.cdi = cdi;
        this.ipca = ipca;
        this.percentualFixo = percentualFixo;
        this.valorMinimo = valorMinimo;
        this.rating = rating;
        this.agenciaClassificador = agenciaClassificador;
        this.tipoLiquidez = tipoLiquidez;
        this.preco = preco;
        this.percentualRendimentoCalculado = percentualRendimentoCalculado;
    }

    public ParametrosInvestimeto(
            TipoRendaFixa tipoRendaFixa,
            String nomeBanco,
            int prazo,
            BigDecimal taxaPercentual,
            boolean percentualFixo,
            BigDecimal valorMinimo,
            Liquidez tipoLiquidez,
            BigDecimal preco) {
        this.nomeCorretora = "Easynvest";
        this.tipoRendaFixa = tipoRendaFixa;
        this.nomeBanco = nomeBanco;
        this.prazo = prazo;
        this.taxaPercentual = taxaPercentual;
        this.percentualFixo = percentualFixo;
        this.cdi = true;
        this.valorMinimo = valorMinimo;
        this.rating = "";
        this.agenciaClassificador = "";
        this.tipoLiquidez = tipoLiquidez;
        this.preco = preco;
    }

    public String getNomeCorretora() {
        return nomeCorretora;
    }

    public void setNomeCorretora(String nomeCorretora) {
        this.nomeCorretora = nomeCorretora;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public int getPrazo() {
        return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

    public BigDecimal getTaxaPercentual() {
        return taxaPercentual;
    }

    public void setTaxaPercentual(BigDecimal taxaPercentual) {
        this.taxaPercentual = taxaPercentual;
    }

    public boolean isCdi() {
        return cdi;
    }

    public void setCdi(boolean cdi) {
        this.cdi = cdi;
    }

    public boolean isIpca() {
        return ipca;
    }

    public void setIpca(boolean ipca) {
        this.ipca = ipca;
    }

    public BigDecimal getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(BigDecimal valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getAgenciaClassificador() {
        return agenciaClassificador;
    }

    public void setAgenciaClassificador(String agenciaClassificador) {
        this.agenciaClassificador = agenciaClassificador;
    }

    public Liquidez getTipoLiquidez() {
        return tipoLiquidez;
    }

    public void setTipoLiquidez(Liquidez tipoLiquidez) {
        this.tipoLiquidez = tipoLiquidez;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getPercentualRendimentoCalculado() {
        return percentualRendimentoCalculado;
    }

    public void setPercentualRendimentoCalculado(BigDecimal percentualRendimentoCalculado) {
        this.percentualRendimentoCalculado = percentualRendimentoCalculado;
    }

    public TipoRendaFixa getTipoRendaFixa() {
        return tipoRendaFixa;
    }

    public void setTipoRendaFixa(TipoRendaFixa tipoRendaFixa) {
        this.tipoRendaFixa = tipoRendaFixa;
    }

    public boolean isPercentualFixo() {
        return percentualFixo;
    }

    public void setPercentualFixo(boolean percentualFixo) {
        this.percentualFixo = percentualFixo;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParametrosInvestimeto)) return false;

        ParametrosInvestimeto that = (ParametrosInvestimeto) o;

        if (cdi != that.cdi) return false;
        if (ipca != that.ipca) return false;
        if (percentualFixo != that.percentualFixo) return false;
        if (prazo != that.prazo) return false;
        if (!nomeBanco.equals(that.nomeBanco)) return false;
        if (!nomeCorretora.equals(that.nomeCorretora)) return false;
        if (!preco.equals(that.preco)) return false;
        if (!taxaPercentual.equals(that.taxaPercentual)) return false;
        if (tipoLiquidez != that.tipoLiquidez) return false;
        if (tipoRendaFixa != that.tipoRendaFixa) return false;
        if (!valorMinimo.equals(that.valorMinimo)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nomeCorretora.hashCode();
        result = 31 * result + nomeBanco.hashCode();
        result = 31 * result + tipoRendaFixa.hashCode();
        result = 31 * result + prazo;
        result = 31 * result + taxaPercentual.hashCode();
        result = 31 * result + valorMinimo.hashCode();
        result = 31 * result + tipoLiquidez.hashCode();
        result = 31 * result + preco.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return nomeBanco + " " + prazo + " " + taxaPercentual;
    }

    @Override
    public int compareTo(Object o) {
        ParametrosInvestimeto comparar = (ParametrosInvestimeto)o;
        if(this.getPercentualRendimentoCalculado().compareTo(comparar.getPercentualRendimentoCalculado()) == 0){
            if(this.getPrazo() > comparar.getPrazo()){
                return -1;
            }else {
                return 1;
            }
        }else if(this.getPercentualRendimentoCalculado().compareTo(comparar.getPercentualRendimentoCalculado()) == 1){
            return -1;
        }else if(this.getPercentualRendimentoCalculado().compareTo(comparar.getPercentualRendimentoCalculado()) == -1){
            return 1;
        }
        return 0;
    }
}