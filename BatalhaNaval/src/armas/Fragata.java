package armas;


public class Fragata extends Arma{
    
    public Fragata(int id){
        this.id = id;
        this.nível = 2;
        this.descricao = "fragata";
        this.pontoParcial = 5;
        this.pontoTotal = 20;
        this.quantidadeOK = 2;
    }
}
