package armas;

public class Submarino extends Arma{
    
        public Submarino(int id) {
        this.id = id;
        this.nível = 4;
        this.descricao = "submarino";
        this.pontoParcial = 15;
        this.pontoTotal = 40;
        this.quantidadeOK = 4;
    }
}
