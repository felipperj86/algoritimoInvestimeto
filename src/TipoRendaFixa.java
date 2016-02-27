/**
 * Created by felipperj86 on 02/08/15.
 */
public enum TipoRendaFixa {

    LC("Letras Cambio"),
    LCI("Letras Credito Imobiliario"),
    LCA("Letras Credito do Agronegocio"),
    CDB("Certificado de deposito Bancario"),
    TESOURO("Tesouro Direto");

    public String descricao;
    TipoRendaFixa(String descricao){
        this.descricao = descricao;
    }
}