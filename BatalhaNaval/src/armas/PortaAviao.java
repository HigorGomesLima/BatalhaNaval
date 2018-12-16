package armas;


public class PortaAviao extends Arma{
    
        public PortaAviao(int id) {
        this.id = id;
        this.nível = 4;
        this.descricao = "portaaviao";
        this.pontoParcial = 20;
        this.pontoTotal = 50;
        this.quantidadeOK = 4;
    }
}
