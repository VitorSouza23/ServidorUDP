/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import javax.swing.JOptionPane;

/**
 *
 * @author Vitor
 */
public class ServidorUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
        //Converte o argumento recebido para inteiro (numero da porta)
        String porta = JOptionPane.showInputDialog(null, "Digite o nº da Porta a ser ouvida:", "Porta", JOptionPane.INFORMATION_MESSAGE);
        int port = Integer.parseInt(porta);
        //Cria o DatagramSocket para aguardar mensagens, neste momento o método fica bloqueando
        //até o recebimente de uma mensagem
        DatagramSocket ds = new DatagramSocket(port);     
        System.out.println("Ouvindo a porta: " + port);
        //Preparando o buffer de recebimento da mensagem
        byte[] msg = new byte[256];
        //Prepara o pacote de dados
        DatagramPacket pkg = new DatagramPacket(msg, msg.length);     
        //Recebimento da mensagem
        ds.receive(pkg);
        JOptionPane.showMessageDialog(null,new String(pkg.getData()).trim(),
	       "Mensagem recebida", JOptionPane.INFORMATION_MESSAGE);
        ds.close();  
        
      }catch(IOException ioe) {
          JOptionPane.showMessageDialog(null, "Erro: " + ioe.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
      }
    }
    
}
