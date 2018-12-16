package armas;

public class FabricaArmas {
    
    public static Arma getArma(String tipo,int id){
        Arma r = null;
        switch(tipo){
            case "corveta":
                r = new Corveta(id);
                break;
            case "cruzador":
                r = new Cruzador(id);
                break;
            case "fragata":
                r = new Fragata(id);
                break;
            case "destroier":
                r = new Destroier(id);
                break;
            case "encouracado":
                r = new Encouracado(id);
                break;
            case "submarino":
                r = new Submarino(id);
                break;
            case "portaaviao":
                r = new PortaAviao(id);
                break;
        }
        return r;
    }
}
