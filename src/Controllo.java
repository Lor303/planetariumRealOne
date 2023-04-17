public class Controllo {

    //Metodo per controllare che due nomi non siano uguali
    public static boolean controlloNomi(Sole sole, String nome) {

        //Si controlla se il nome inserito non sia uguale al nome del sole
        if (sole.getCodiceUnivoco().equalsIgnoreCase(nome)) {
            System.out.println("Nome già in uso");
            return true;
        }

        //Scorro tutti i nomi di tutti i pianeti
        for (int i=0; i<sole.pianeti.size(); i++) {
            if (sole.pianeti.get(i).getCodiceUnivoco().equalsIgnoreCase(nome)) {
                System.out.println("Nome già in uso");
                return true;
            }

            //scorro tutti nomi di tutte le lune del pianeta
            for (int j=0; j<sole.pianeti.get(i).lune.size(); j++) {
                if (sole.pianeti.get(i).lune.get(j).getCodiceUnivoco().equalsIgnoreCase(nome)) {
                    System.out.println("Nome già in uso");
                    return true;
                }
            }
        }

        return false;
    }
}