package batalhanaval;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexao {
    ServerSocket ss;
    Socket socket;
    DataInputStream entrada;
    DataOutputStream saida;
    protected String ip;

    //Modo Cliente
    public Conexao(String ipServer, int portaServer) throws IOException {
        socket = new Socket(ipServer, portaServer);
        entrada = new DataInputStream(socket.getInputStream());
        saida = new DataOutputStream(socket.getOutputStream());
    }
    //Modo Servidor
    public Conexao(int portaServer) throws IOException {
        ss = new ServerSocket(portaServer);
        socket = ss.accept();
        entrada = new DataInputStream(socket.getInputStream());
        saida = new DataOutputStream(socket.getOutputStream());
        ip = InetAddress.getLocalHost().getHostAddress();
    }
    
    public void enviarMensagem(String mensagem) throws IOException {
        saida.writeUTF(mensagem);
        saida.flush();
    }
    
    public String receberMensagem() throws IOException {
        return entrada.readUTF();
    }
    
    public void enviarTabuleiro1(int[][] oceano,int h, int l) throws IOException{
        String mensagem = "";
        for(int i = 0;i < h; i++){
            for(int j = 0;j < l; j++){
                mensagem += oceano[i][j] + ",";
            }
            mensagem += ";";
        }
        saida.writeUTF(mensagem);
        saida.flush();
    }
    
    public int[][] receberTabuleiro1(int l,int j) throws IOException{
        String chegada = entrada.readUTF();
        int[][] retorno;
        String[] linha = chegada.split(";");
        
    }

    public String getIp() {
        return ip;
    }
}
