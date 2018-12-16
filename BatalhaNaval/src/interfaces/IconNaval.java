package interfaces;

import javax.swing.ImageIcon;

public class IconNaval {
    
    private ImageIcon agua;
    private ImageIcon bomba;
    private ImageIcon[] fragata;
    private ImageIcon[] corveta;
    private ImageIcon[] destroier;
    private ImageIcon[] cruzador;
    private ImageIcon[] submarino;
    private ImageIcon[] encouracado;
    private ImageIcon[] portaaviao;
    
    public IconNaval(){
        agua = new ImageIcon(getClass().getResource("imagem/agua.png"));
        bomba = new ImageIcon(getClass().getResource("imagem/bomba.png"));
    }
   public ImageIcon getImagem(String nome){
        if("agua".equals(nome)){
            return agua;
        }else if("bomba".equals(nome)){
            return bomba;
        }
        return null;
    }
}
