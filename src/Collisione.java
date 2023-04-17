/**
 * Classe usata per poter calcolare la collisione fra due corpi celesti
 */

public class Collisione {


    //Metodo per calcolare la distanza tra un corpo celeste e la stella
    public static float distanzaCorpoStella (Sole sole, String nome) {

        float distanza=0;



        //distanza =

        return distanza;
    }



    public static int controlloCorpo (Sole sole, String nome) {
    //Caso in cui il nome non corrisponda ne ad un pianeta ne ad una luna
        if (MetodiMenu.ricercaNomePianeta(sole, nome) == -1 && MetodiMenu.ricercaNomeLuna(sole, nome) == -1)
            return 0;

    //Il nome inserito dall'utente corrisponde al nome della stella
        if (sole.getCodiceUnivoco().equalsIgnoreCase(nome))
            return 1;

    //Il nome inserito corrisponde al nome di un pianeta
        if (MetodiMenu.ricercaNomePianeta(sole, nome) != 0)
            return 2;

    //Il nome inserito corrisponde al nome di una luna
        if (MetodiMenu.ricercaNomeLuna(sole, nome) != 0)
            return 3;

    //Solidità del codice
    return 0;
    }

}
