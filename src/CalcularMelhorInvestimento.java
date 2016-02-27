import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by felipperj86 on 01/08/15.
 */
public class CalcularMelhorInvestimento {

    private static final BigDecimal TAXA_CDI = new BigDecimal("14.13");
    private static final BigDecimal CEM = new BigDecimal("100");
    private List<Imposto> impostoRenda = new ArrayList<Imposto>();

    public CalcularMelhorInvestimento() {
        this.impostoRenda.add(new Imposto(0, 180,  new BigDecimal("22.5")));
        this.impostoRenda.add(new Imposto(181, 360, new BigDecimal("20")));
        this.impostoRenda.add(new Imposto(361, 720, new BigDecimal("17.5")));
        this.impostoRenda.add(new Imposto(721, 360000, new BigDecimal("15")));
    }

    public Set<ParametrosInvestimeto> calcularMelhorInvestimento(List<ParametrosInvestimeto> lista){

        Set<ParametrosInvestimeto> retorno = new TreeSet<ParametrosInvestimeto>();

        for (ParametrosInvestimeto aux : lista){
            aux.setPercentualRendimentoCalculado(calcularRendimentoRealSimples(aux));
            retorno.add(aux);
        }

        return retorno;
    }


    private BigDecimal calcularRendimentoRealSimples(ParametrosInvestimeto investimento){

        BigDecimal rendimentoReal;
        BigDecimal rendimentoSemImposto;

        if(investimento.isPercentualFixo()){
            rendimentoSemImposto = investimento.getTaxaPercentual();
        } else{
            rendimentoSemImposto = TAXA_CDI.multiply(investimento.getTaxaPercentual()).divide(CEM);
        }

        if(TipoRendaFixa.CDB.equals(investimento.getTipoRendaFixa())
                || TipoRendaFixa.LC.equals(investimento.getTipoRendaFixa())
                || TipoRendaFixa.TESOURO.equals(investimento.getTipoRendaFixa())){
            BigDecimal taxaImpostoRenda = CEM.subtract(retornaImpostoCorreto(investimento.getPrazo()).getTaxa());

            rendimentoReal = rendimentoSemImposto.multiply(taxaImpostoRenda).divide(CEM);
        }else {
            rendimentoReal = rendimentoSemImposto;
        }
        return rendimentoReal;
    }

    public Imposto retornaImpostoCorreto(Integer numeroDeDias){
        for(Imposto aux : impostoRenda){
            if (numeroDeDias  >= aux.getDiaInicial() && numeroDeDias <= aux.diaFinal){
                return aux;
            }
        }
        return null;
    }

    class Imposto{
        private int diaInicial;
        private int diaFinal;
        private BigDecimal taxa;

        public Imposto(int diaInicial, int diaFinal, BigDecimal taxa) {
            this.diaInicial = diaInicial;
            this.diaFinal = diaFinal;
            this.taxa = taxa;
        }

        public int getDiaInicial() {
            return diaInicial;
        }

        public int getDiaFinal() {
            return diaFinal;
        }

        public BigDecimal getTaxa() {
            return taxa;
        }
    }

}