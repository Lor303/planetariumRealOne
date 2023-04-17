import java.awt.*;

/**
 * Descrizione da fare
 */
public class MetodiMenu {

    //Metodo per aggiungere un nuovo pianeta dal menu, l'utente crea il pianeta e
    //se vuole anche le sue lune
    public static void aggiungiPianeta(Sole sole) {
        sole.aggiungiPianeta(sole);
    }



    //Metodo per aggiungere una luna dal menu, l'utente deve inserire il codice univoco
    //del pianeta attorno al quale la luna che si sta creando ruota
    public static void aggiungiLuna(Sole sole, Pianeta pianeta) {
        pianeta.aggiungiLuna(sole, pianeta.getCodiceUnivoco(), pianeta.getNumLune());
    }



    //Metodo per rimuovere un pianeta, l'utente deve dichiarare il codice univoco
    //del pianeta da rimuovere (vengono eliminate anche le lune del pianeta)
    public static void rimozionePianeta(Sole sole, String nome) {

        //Caso in cui il nome non corrisponda ad un pianeta
        if (ricercaNomePianeta(sole, nome) == -1 )
            System.out.println("Nessun pianeta celeste trovato");

        //Viene trovato il pianeta e rimosso dall'arraylist pianeti
        if (ricercaNomePianeta(sole, nome) != 0)
            sole.pianeti.remove(ricercaNomePianeta(sole, nome));
    }



    //Metodo per rimuovere una luna, l'utente deve dichiarare il codice univoco della
    //luna da rimuovere
    public static void rimozioneLuna(Sole sole, String nome) {

        //Caso in cui il nome non corrisponda ad una luna
        if (ricercaNomeLuna(sole, nome) == -1)
            System.out.println("Nessuna luna trovata");

        //Viene trovata la luna e rimossa dall'arraylist lune
        if (ricercaNomeLuna(sole, nome) != 0) {
            sole.pianeti.get(posizionePianeta(sole, nome)).lune.remove(ricercaNomeLuna(sole, nome));
        }
    }



    //Metodo per cercare un corpo celeste dato il nome inserito dall'utente
    public static void ricercaCorpoCeleste (Sole sole, String nome) {

        //Caso in cui il nome non corrisponda ne ad un pianeta ne ad una luna
        if (ricercaNomePianeta(sole, nome) == -1 && ricercaNomeLuna(sole, nome) == -1)
            System.out.println("Nessun corpo celeste trovato");

        //Il nome inserito dall'utente corrisponde al nome della stella
        if (sole.getCodiceUnivoco().equalsIgnoreCase(nome))
            System.out.println("Il nome inserito corrisponde al nome della stella del sistema solare");

        //Il nome inserito corrisponde al nome di un pianeta
        if (ricercaNomePianeta(sole, nome) != 0) {
            System.out.println("Il nome inserito corrisponde al nome del pianeta in posizione (" +
                                sole.pianeti.get(ricercaNomePianeta(sole, nome)).getPosizioneX() +
                                "," + sole.pianeti.get(ricercaNomePianeta(sole, nome)).getPosizioneY() + ")");
        }

        //Il nome inserito corrisponde al nome di una luna
        if (ricercaNomeLuna(sole, nome) != 0) {
            System.out.println("Il nome inserito corrisponde al nome della luna numero" +
                                (ricercaNomeLuna(sole, nome)+1) + "che robita attorno al pianeta" +
                                sole.pianeti.get(posizionePianeta(sole, nome)).getCodiceUnivoco());
        }
    }



    //Metodo per cercare le lune orbitanti di un pianeta dato il nome del pianeta
    public static void ricercaLuneOrbitanti (Sole sole, String nome) {

        //Caso in cui il nome non corrisponda ad un pianeta
        if (ricercaNomePianeta(sole, nome) == -1 )
            System.out.println("Nessun pianeta celeste trovato");

        //Vengono stampate tutte le lune con il loro nome e la loro posizione
        if (ricercaNomePianeta(sole, nome) != -1 ) {
            for (int i=0; i<sole.pianeti.get(ricercaNomePianeta(sole, nome)).lune.size(); i++) {
                System.out.println("Luna numero: " + i+1);
                System.out.println("Codice univoco: " + sole.pianeti.get(ricercaNomePianeta(sole, nome)).lune.get(i).getCodiceUnivoco());
                System.out.println("Posizione: (" +
                                    sole.pianeti.get(ricercaNomePianeta(sole, nome)).lune.get(i).getPosizioneX() +
                                    "," + sole.pianeti.get(ricercaNomePianeta(sole, nome)).lune.get(i).getPosizioneY());
                System.out.println();
            }
        }
    }



    //Metodo per cercare il percorso di una luna dato il suo nome
    public static void percorsoLuna (Sole sole, String nome) {

        //Caso in cui il nome non corrisponda ad una luna
        if (ricercaNomeLuna(sole, nome) == -1)
            System.out.println("Nessuna luna trovata");

        //Viene stampato il percorso nel seguente modo:
        // - nome stella
        // - nome pianeta
        // - nome luna
        if (ricercaNomeLuna(sole, nome) != -1) {
            System.out.println(sole.getCodiceUnivoco());
            System.out.println(sole.pianeti.get(posizionePianeta(sole, nome)).getCodiceUnivoco());
            System.out.println(sole.pianeti.get(posizionePianeta(sole, nome)).lune.get(ricercaNomeLuna(sole,nome)));
        }
    }



    //


    /*
     * Seguono dei metodi necessari per utilizzare i metodi soprascritti
     */

    //Metodo per trovare la posizione del pianeta, dato il codice univoco, all'interno
    //dell'arraylist pianeti
    public static int ricercaNomePianeta (Sole sole, String nome) {

        //scorro tutti i pianeti
        for (int i=0; i<sole.pianeti.size(); i++) {
            if (sole.pianeti.get(i).getCodiceUnivoco().equalsIgnoreCase(nome))
                return i;
        }
        //In caso non si trovi nessun pianeta con il codice univoco corrispondente
        //viene ritornato -1
        return -1;
    }


    //Metodo per trovare la posizione della luna, dato il codice univoco, all'interno
    //dell'arraylist lune
    public static int ricercaNomeLuna (Sole sole, String nome) {

        //scorro tutti i pianeti
        for (int i=0; i<sole.pianeti.size(); i++) {

            //scorro tutti nomi di tutte le lune del pianeta
            for (int j=0; j<sole.pianeti.get(i).lune.size(); j++)
                if (sole.pianeti.get(i).lune.get(j).getCodiceUnivoco().equalsIgnoreCase(nome))
                    return j;
        }

        //In caso non si trovi nessuna luna con il codice univoco corrispondente
        //viene ritornato -1
        return -1;
    }

    //Metodo per ottenere la posizione del pianeta nell'arraylist pianti dato il
    //nome di una luna che orbita attorno al pianeta
    public static int posizionePianeta(Sole sole, String nome) {

        //scorro tutti i pianeti
        for (int i=0; i<sole.pianeti.size(); i++) {

            //scorro tutti nomi di tutte le lune del pianeta
            for (int j=0; j<sole.pianeti.get(i).lune.size(); j++)
                if (sole.pianeti.get(i).lune.get(j).getCodiceUnivoco().equalsIgnoreCase(nome))
                    return i;
        }

        //viene scritto per rendere il programma sintatticamente corretto ma
        //logicamente insensato in quanto non si verificherà mai questa situazione
        return -1;
    }
}