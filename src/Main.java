import java.awt.*;
import it.kibo.fp.lib.Menu;

public class Main {
    public static void main(String[] args) {
        String risposta;
        //Presentazione
        System.out.println("Ciao fra");
/////////////////INIZIO CENSIMENTO/////////////////

        //l'utente inserisce il nome del sistema solare
        SistemaSolare sistemaSolare = creaSistema();
        System.out.println("Nome sistema solare: " + sistemaSolare.getNomeSistemaSolare() + "\n");

        //l'utente crea il sole (inserisce il codice univoco e la massa)
        //la posizione x e la posizione y del sole vengono poste a 0 dal programma
        Sole sole = creaSole();

        //Viene chiesto se si vuole creare un pianeta
        //Viene richiamato il metodo aggiungi pianeta della classe sole per creare dei pianeti con le loro lune
        risposta = Appoggio.leggiStringa("Vuoi creare un pianeta? (rispondere si in caso si voglia creare un altro pianeta) ") ;
        if (risposta.equalsIgnoreCase("si")) {
            sole.aggiungiPianeta(sole);
        }

        /////////////////FINE CENSIMENTO/////////////////

        String[] vociMenu={"aggiungi pianeta", "aggiungi luna", "rimuovi pianeta", "rimuovi luna", "ricerca corpo celeste", "ricerca lune orbitanti", "percorso luna"};
        Menu menu= new Menu("Menu opzioni", vociMenu, false, true, false);
        int scelta;
        do {
            scelta= menu.choose();
            switch(scelta) {
                case 1: //CreaPianeta
                    MetodiMenu.aggiungiPianeta(sole);
                    break;

                case 2: //creaLuna
                    MetodiMenu.aggiungiLuna(sole, sole.pianeti.get(1));
                    break;

                case 3:
                    String nomePianeta= Appoggio.leggiStringa("Inserire nome pianeta: ");
                    MetodiMenu.rimozionePianeta(sole, nomePianeta);
                    break;

                case 4:
                    String nomeLuna= Appoggio.leggiStringa("Inserire nome luna: ");
                    MetodiMenu.rimozioneLuna(sole, nomeLuna);
                    break;

                case 5:
                    String nomeRicerca= Appoggio.leggiStringa("Inserire nome da ricercare: ");
                    MetodiMenu.ricercaCorpoCeleste(sole, nomeRicerca);
                    break;

                case 6:
                    String nomePianetaDaCercare= Appoggio.leggiStringa("Inserire nome pianeta: ");
                    MetodiMenu.ricercaLuneOrbitanti(sole, nomePianetaDaCercare);
                    break;

                case 7:
                    String nomeLunaPerPercorso= Appoggio.leggiStringa("Inserire nome luna da raggiungere: ");
                    MetodiMenu.percorsoLuna(sole, nomeLunaPerPercorso);
                    break;

                default: break;
            }
            scelta= menu.choose();
        }while(scelta!=0);







        
        //Viene calcolato il centro di massa
        System.out.println("Il centro di massa di questo sistema solare ha coordinate " +
                "(" + sistemaSolare.calcoloCentroDiMassaX(sole) + ","
                + sistemaSolare.calcoloCentroDiMassaY(sole) + ")");


        //Menu per chiedere quali delle seguenti operazioni si vuole eseguire:
        // -aggiunta di pianeti/lune
        // -rimozione di pianeti/lune
        // -capire se un corpo celeste è presente dato il nome del corpo celeste (nel caso di luna dire attorno a che pianeta ruota)
        // -visualizzare le lune di un pianeta
        // -visualizzare il percorso della luna
        // -calcolo del centro di massa

        //Parti del menu facoltative:
        // -Calcolo della rotta fra due corpi celesti
        // -Calcolo della collisione fra i corpi celesti
    }

    //l'utente inserisce il nome del sistema solare generando un'istanza SistemaSolare
    private static SistemaSolare creaSistema() {
        String nomeSistemaSolare = Appoggio.leggiStringa("Dai un nome al sistema solare: ");

        return new SistemaSolare(nomeSistemaSolare);
    }

    //l'utente inserisce il codice univoco e la massa del sole
    //la posizione x e la posizione y vengono poste a 0
    private static Sole creaSole() {
        String codiceUnivoco = Appoggio.leggiStringa("Nome sole:");
        int massa = Appoggio.leggiIntero("Massa sole:");
        int posizioneX = 0;
        int posizioneY = 0;
        return new Sole(codiceUnivoco, massa, posizioneX, posizioneY);
    }

}
