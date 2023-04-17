/**
 * Classe derivata da CorpoCeleste
 * Vengono aggiunti gli attributi:
 *    -numPianeti (con get e set)
 *    -flag (necessario per il metodo aggiungi pianeta)
 *    -pianeti (ArrayList)
 *
 * Vengono aggiunti i metodi
 *    -aggiungiPianeta (richiama il metodo creaPianeta + aggiunge l'istanza Pianeta nell'ArrayList pianeti)
 *    -creaPianeta (crea un'istanza Pianeta)
 */

import java.util.ArrayList;

public class Sole extends CorpoCeleste {

    int numPianeti, i=0;
    String flag;
    ArrayList<Pianeta> pianeti = new ArrayList <Pianeta>();

    //Costructor
    public Sole(String codiceUnivoco, int massa, int posizioneX, int posizioneY) {
        super(codiceUnivoco, massa, posizioneX, posizioneY);
        this.numPianeti = numPianeti;
    }


    /*
     * getPianeti
     * setPianeti
     */
    public ArrayList<Pianeta> getPianeti() {
        return pianeti;
    }

    public void setPianeti(ArrayList<Pianeta> pianeti) {
        this.pianeti = pianeti;
    }

    /* Metodo per aggiungere un pianeta nell'arraylist chiamato "pianeti"
     * Il metodo sfrutta un altro metodo chiamato creaPianeta che serve per creare un'istanza Pianeta
     * Funzionamento:
     * -viene richiamato il metodo crea pianeta
     * -viene eseguito un if per verificare che le lune del pianeta siano maggiori di 0
     * ---in caso l'esito sia positivo viene richiamato il metodo aggiungiLuna della classe pianeta per
     *    creare un numero di lune pari al numero inserito dall'utente
     * ---in caso l'esito sia negativo il programma continua
     * -viene chiesto se si vuole creare un'altro pianeta
     * -se la risposta dovesse essere si (ignorando maiuscole e minuscole) vengono rieseguiti
     *  i passaggi precedenti (viene usata la variabile flag per eseguire la verifica)
     */
    public void aggiungiPianeta(Sole sole) {
        do {
            //si crea il pianeta
            pianeti.add(creaPianeta(sole));

            //si creano le lune che orbitano attorno al pianeta appena creato
            if (pianeti.get(i).getNumLune() > 0);
            pianeti.get(i).aggiungiLuna(sole, pianeti.get(i).getCodiceUnivoco(), pianeti.get(i).getNumLune());

            flag = Appoggio.leggiStringa("Vuoi creare un altro pianeta? (scrivere si per continuare) ");
            i++;
        }
        while (flag.equalsIgnoreCase("si"));
    }

    //Metodo per creare un'istanza pianeta
    //Viene usato solo nel metodo aggiungiPianeta
    public static Pianeta creaPianeta(Sole sole) {
        String codiceUnivoco;

        //Si esegue il controllo per verificare che il nome inserito non coincida con
        //il nome di un altro corpo celeste
        do {
            codiceUnivoco = Appoggio.leggiStringa("Inserire il nome del pianeta: ");
        }
        while (Controllo.controlloNomi(sole, codiceUnivoco));

        int massa = Appoggio.leggiIntero("Inserire la massa del pianeta: ");
        int posizioneX = Appoggio.leggiIntero("Inserire la coordinata X: (rispetto alla posizione 0 della stella)");
        int posizioneY = Appoggio.leggiIntero("Inserire la coordinata Y: (rispetto alla posizione 0 della stella)");
        String stellaDiRiferimento = sole.getCodiceUnivoco();
        int numLune = Appoggio.leggiIntero("Inserire il numero di Lune del pianeta: ");


        return new Pianeta(codiceUnivoco, massa, posizioneX, posizioneY, stellaDiRiferimento, numLune);
    }
}
