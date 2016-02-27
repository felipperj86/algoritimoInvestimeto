/**
 * Created by felipperj86 on 31/07/15.
 */
public enum Liquidez {

    NO_VENCIMENTO("No Vencimento"),
    DIARIA("Diaria");

    public String descricao;
    Liquidez(String descricao){
        this.descricao = descricao;
    }
}