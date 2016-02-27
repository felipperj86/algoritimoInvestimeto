import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestAchaMelhorInvestimento {

    @Test
    public void testeCDB(){
        List<ParametrosInvestimeto> listaInvestimentos = new ArrayList<ParametrosInvestimeto>();

        ParametrosInvestimeto cdb1;
        ParametrosInvestimeto cdb2;
        ParametrosInvestimeto cdb3;

        cdb1 = new ParametrosInvestimeto(TipoRendaFixa.CDB, "Banco Padrao 1", 360, new BigDecimal("107.00"), false, new BigDecimal("10000.00"), Liquidez.NO_VENCIMENTO, new BigDecimal("1000"));
        cdb2 = new ParametrosInvestimeto(TipoRendaFixa.CDB, "Banco Padrao 2", 720, new BigDecimal("119.00"), false, new BigDecimal("50000.00"), Liquidez.NO_VENCIMENTO, new BigDecimal("1000"));
        cdb3 = new ParametrosInvestimeto(TipoRendaFixa.CDB, "Banco Padrao 3", 1080, new BigDecimal("121.00"), false, new BigDecimal("20000.00"), Liquidez.NO_VENCIMENTO, new BigDecimal("1000"));

        listaInvestimentos.add(cdb1);
        listaInvestimentos.add(cdb2);
        listaInvestimentos.add(cdb3);

        List<ParametrosInvestimeto> listaCDBResultado;

        CalcularMelhorInvestimento calculadora = new CalcularMelhorInvestimento();

        listaCDBResultado = new ArrayList<ParametrosInvestimeto>(calculadora.calcularMelhorInvestimento(listaInvestimentos));

        assertEquals(cdb3, listaCDBResultado.get(0));
        assertEquals(cdb2, listaCDBResultado.get(1));
        assertEquals(cdb1, listaCDBResultado.get(2));
    }


    @Test
    public void testeGeral(){
        List<ParametrosInvestimeto> listaInvestimentos = new ArrayList<ParametrosInvestimeto>();

        ParametrosInvestimeto cdb1;
        ParametrosInvestimeto cdb2;
        ParametrosInvestimeto cdb3;
        ParametrosInvestimeto lc1;
        ParametrosInvestimeto lci1;
        ParametrosInvestimeto lca1;
        ParametrosInvestimeto tesouro1;

        cdb1 = new ParametrosInvestimeto(TipoRendaFixa.CDB, "Banco Padrao 1", 360, new BigDecimal("107.00"), false, new BigDecimal("10000.00"), Liquidez.NO_VENCIMENTO, new BigDecimal("1000"));
        cdb2 = new ParametrosInvestimeto(TipoRendaFixa.CDB, "Banco Padrao 2", 720, new BigDecimal("119.00"), false, new BigDecimal("50000.00"), Liquidez.NO_VENCIMENTO, new BigDecimal("1000"));
        cdb3 = new ParametrosInvestimeto(TipoRendaFixa.CDB, "Banco Padrao 3", 1080, new BigDecimal("121.00"), false, new BigDecimal("20000.00"), Liquidez.NO_VENCIMENTO, new BigDecimal("1000"));
        lc1 = new ParametrosInvestimeto(TipoRendaFixa.LC, "Banco Padrao 4", 720, new BigDecimal("117.00"), false, new BigDecimal("10000.00"), Liquidez.NO_VENCIMENTO, new BigDecimal("1000"));
        lci1 = new ParametrosInvestimeto(TipoRendaFixa.LCI, "Banco Padrao 5", 1080, new BigDecimal("99.00"), false, new BigDecimal("10000.00"), Liquidez.NO_VENCIMENTO, new BigDecimal("1000"));
        lca1 = new ParametrosInvestimeto(TipoRendaFixa.LCA, "Banco Padrao 6", 720, new BigDecimal("101.00"), false, new BigDecimal("10000.00"), Liquidez.NO_VENCIMENTO, new BigDecimal("1000"));
        tesouro1 = new ParametrosInvestimeto(TipoRendaFixa.TESOURO, "Banco Padrao 7", 360, new BigDecimal("12.96"), true, new BigDecimal("10000.00"), Liquidez.NO_VENCIMENTO, new BigDecimal("1000"));

        listaInvestimentos.add(cdb1);
        listaInvestimentos.add(cdb2);
        listaInvestimentos.add(cdb3);
        listaInvestimentos.add(lc1);
        listaInvestimentos.add(lci1);
        listaInvestimentos.add(lca1);
        listaInvestimentos.add(tesouro1);

        List<ParametrosInvestimeto> listaCDBResultado;

        CalcularMelhorInvestimento calculadora = new CalcularMelhorInvestimento();

        listaCDBResultado = new ArrayList<ParametrosInvestimeto>(calculadora.calcularMelhorInvestimento(listaInvestimentos));

        assertEquals(cdb3, listaCDBResultado.get(0));
        assertEquals(lca1, listaCDBResultado.get(1));
        assertEquals(lci1, listaCDBResultado.get(2));
        assertEquals(cdb2, listaCDBResultado.get(3));
        assertEquals(lc1, listaCDBResultado.get(4));
        assertEquals(cdb1, listaCDBResultado.get(5));
        assertEquals(tesouro1, listaCDBResultado.get(6));
    }

}