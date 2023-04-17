/**
 * Descrizione da fare
 */

public class SistemaSolare {
    private String nomeSistemaSolare;
    private float centroDiMassaX=0;
    private float centroDiMassaY=0;
    private int massaPonderata=0; //usata per il calcolo del centro di massa (numeratore)
    private int massaTotale=0; //usata per il calcolo del centro di massa (denominatore)

    //Costructor
    public SistemaSolare(String nomeSistemaSolare) {
        this.nomeSistemaSolare = nomeSistemaSolare;
        this.centroDiMassaX = centroDiMassaX;
        this.centroDiMassaY = centroDiMassaY;
    }

    /* getNomeSistemaSolare
     * setNomeSistemaSolare
     * getCentroDiMassaX
     * setCentroDiMassaX
     * getCentroDiMassaY
     * setCentroDiMassaY
     */
    public String getNomeSistemaSolare() {
        return nomeSistemaSolare;
    }

    public void setNomeSistemaSolare(String nomeSistemaSolare) {
        this.nomeSistemaSolare = nomeSistemaSolare;
    }

    public float getCentroDiMassaX() {
        return centroDiMassaX;
    }

    public void setCentroDiMassaX(float centroDiMassaX) {
        this.centroDiMassaX = centroDiMassaX;
    }

    public float getCentroDiMassaY() {
        return centroDiMassaY;
    }

    public void setCentroDiMassaY(float centroDiMassaY) {
        this.centroDiMassaY = centroDiMassaY;
    }




    /* Metodo per calcolare il centro di massa in x di questo sistema solare
     *
     */
    public float calcoloCentroDiMassaX(Sole sole) {

        //vengono azzerate entrambe le variabili inerenti al calcolo della massa
        massaPonderata=0;
        massaTotale=0;

        massaTotale += sole.getMassa();

        //Scorro tutti i pianeti del sistema solare
        for (int i=0; i < sole.numPianeti; i++) {

            //massa del pianeta per posizione del pianeta (numeratore)
            massaPonderata += sole.pianeti.get(i).getMassa() * sole.pianeti.get(i).getPosizioneX();

            //massa del pianeta (denominatore)
            massaTotale += sole.pianeti.get(i).getMassa();

            //scorro tutte le lune del pianeta
            for (int j=0; j< sole.pianeti.get(i).getNumLune(); j++) {

                //massa della luna j del pianeta i per la posizione della luna (numeratore)
                massaPonderata += sole.pianeti.get(i).lune.get(j).getMassa() * sole.pianeti.get(i).lune.get(j).getPosizioneX();

                //massa del la luna (denominatore)
                massaTotale += sole.pianeti.get(i).lune.get(j).getMassa();
            }
        }

        centroDiMassaX = (float)massaPonderata/(float) massaTotale;



        return centroDiMassaX;
    }


    /* Metodo per calcolare il centro di massa in y di questo sistema solare
     *
     */
    public float calcoloCentroDiMassaY(Sole sole) {
        massaPonderata=0;
        massaTotale=0;
        massaTotale += sole.getMassa();

        //Scorro tutti i pianeti del sistema solare
        for (int i=0; i < sole.numPianeti; i++) {

            //massa del pianeta per posizione del pianeta (numeratore)
            massaPonderata += sole.pianeti.get(i).getMassa() * sole.pianeti.get(i).getPosizioneY();

            //massa del pianeta (denominatore)
            massaTotale += sole.pianeti.get(i).getMassa();

            //scorro tutte le lune del pianeta
            for (int j=0; j< sole.pianeti.get(i).getNumLune(); j++) {

                //massa della luna j del pianeta i per la posizione della luna (numeratore)
                massaPonderata += sole.pianeti.get(i).lune.get(j).getMassa() * sole.pianeti.get(i).lune.get(j).getPosizioneY();

                //massa del la luna (denominatore)
                massaTotale += sole.pianeti.get(i).lune.get(j).getMassa();
            }
        }

        centroDiMassaY = (float)massaPonderata/(float)massaTotale;

        return centroDiMassaY;
    }
}