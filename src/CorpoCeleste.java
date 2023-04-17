/**
 * Descrizione da fare
 */

public class CorpoCeleste {
    private String codiceUnivoco;
    private int massa;
    private int posizioneX;
    private int posizioneY;

    //Costructor per codiceUnivoco, massa, posizioneX e posizioneY del corpo celeste
    public CorpoCeleste(String codiceUnivoco, int massa, int posizioneX, int posizioneY) {
        this.codiceUnivoco = codiceUnivoco;
        this.massa = massa;
        this.posizioneX = posizioneX;
        this.posizioneY = posizioneY;
    }

    /* getCodiceUnivoco
     * setCodiceUnivoco
     * getMassa
     * setMassa
     * getPoszionex
     * setPosizioneX
     * getPosizioneY
     * setPosizioneY
     */
    public String getCodiceUnivoco() {
        return codiceUnivoco;
    }

    public void setCodiceUnivoco(String codiceUnivoco) {
        this.codiceUnivoco = codiceUnivoco;
    }

    public int getMassa() {
        return massa;
    }

    public void setMassa(int massa) {
        this.massa = massa;
    }

    public int getPosizioneX() {
        return posizioneX;
    }

    public void setPosizioneX(int posizioneX) {
        this.posizioneX = posizioneX;
    }

    public int getPosizioneY() {
        return posizioneY;
    }

    public void setPosizioneY(int posizioneY) {
        this.posizioneY = posizioneY;
    }
}