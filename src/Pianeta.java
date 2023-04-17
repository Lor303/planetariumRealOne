/**
 * Classe derivata da CorpoCeleste
 * Vengono aggiunti gli attributi:
 *    -numLune (con get e set)
 *    -lune (ArrayList)
 *
 * Vengono aggiunti i metodi
 *    -aggiungiLuna (richiama il metodo creaLuna + aggiunge l'istanza luna nell'ArrayList lune)
 *    -creaLuna (crea un'istanza Luna)
 */


import java.util.ArrayList;

public class Pianeta extends CorpoCeleste {

    //Attributi
    private String StellaDiRiferimento;
    private int numLune=0;
    ArrayList<Luna> lune = new ArrayList <Luna>();

    //Costructor
    public Pianeta(String codiceUnivoco, int massa, int posizioneX, int posizioneY, String stellaDiRiferimento, int numLune) {
        super(codiceUnivoco, massa, posizioneX, posizioneY);
        StellaDiRiferimento = stellaDiRiferimento;
        this.numLune = numLune;
    }

    /* getStellaDiRiferimento
     * setStellaDiRiferimento
     * getNumLune
     * setNumLune
     * getLune
     * setLune
     */
    public String getStellaDiRiferimento() {
        return StellaDiRiferimento;
    }

    public void setStellaDiRiferimento(String stellaDiRiferimento) {
        StellaDiRiferimento = stellaDiRiferimento;
    }

    public int getNumLune() {
        return numLune;
    }

    public void setNumLune(int numLune) {
        this.numLune = numLune;
    }

    public ArrayList<Luna> getLune() {
        return lune;
    }

    public void setLune(ArrayList<Luna> lune) {
        this.lune = lune;
    }



    /* Metodo per aggiungere una luna nell'arraylist chiamato "lune"
     * Il metodo sfrutta un altro metodo chiamato creaLuna che serve per creare un'istanza Luna
     * Funzionamento:
     * vengono create tante lune quante il numero inserito dall'utente nel main in fase
     * di creazione del pianeta.
     * Vengono infatti passati dal main due parametri:
     * --> il codice univoco del pianeta attorno al quale le lune che si stanno creando orbitano
     * --> il numero delle lune che possiede il pianeta di riferimento così da generare un for per
     *     creare un numero preciso di istanze luna
     */
    public void aggiungiLuna(Sole sole, String codicePianetaDiRiferimento, int numLune) {
        for (int i=0; i<numLune; i++)
            lune.add(creaLuna(sole, codicePianetaDiRiferimento));
    }

    //Metodo per creare un'istanza luna
    //Viene usato solo nel metodo aggiungiLuna
    public static Luna creaLuna(Sole sole, String codicePianetaDiRiferimento) {
        String codiceUnivoco;

        //Si esegue il controllo per verificare che il nome inserito non coincida con
        //il nome di un altro corpo celeste
        do {
            codiceUnivoco = Appoggio.leggiStringa("Nome luna: ");
        }
        while (Controllo.controlloNomi(sole, codiceUnivoco));

        int massa = Appoggio.leggiIntero("Massa luna: ");
        int posizioneX = Appoggio.leggiIntero("X luna: ");
        int posizioneY = Appoggio.leggiIntero("Y luna: ");
        String pianetaDiRiferimento = codicePianetaDiRiferimento;

        return new Luna(codiceUnivoco, massa, posizioneX, posizioneY, pianetaDiRiferimento);
    }
}