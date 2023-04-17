/**
 * Classe derivata da Pianeta
 * Vengono aggiunti gli attributi:
 *      -pianetaDiRiferimento (ovvero il pianeta attorno al quale la luna orbita) (con get e set)
 */

public class Luna extends CorpoCeleste {
    private String pianetaDiRiferimento;

    //Costructor
    public Luna(String codiceUnivoco, int massa, int posizioneX, int posizioneY, String pianetaDiRiferimento) {
        super(codiceUnivoco, massa, posizioneX, posizioneY);
        this.pianetaDiRiferimento = pianetaDiRiferimento;
    }

    /*
     * getPianetaDiRiferimento
     * setPianetaDiRiferimento
     */
    public String getPianetaDiRiferimento() {
        return pianetaDiRiferimento;
    }

    public void setPianetaDiRiferimento(String pianetaDiRiferimento) {
        this.pianetaDiRiferimento = pianetaDiRiferimento;
    }
}