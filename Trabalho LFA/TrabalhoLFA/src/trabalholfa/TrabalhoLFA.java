package trabalholfa;

import auxiliar.Auxiliar;
import entieties.Automato;
import java.io.File;
import java.nio.file.Files;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

//classe método main
public class TrabalhoLFA {

    public static void main(String[] args) {
        Auxiliar aux = new Auxiliar();
        Automato automato = new Automato(); //instanciamento do objeto automato
        JOptionPane.showMessageDialog(null, "Selecione o arquivo com a AFND que deseja transformar em AFD!");
        JFileChooser file = new JFileChooser(); // recebimento do endereço do arquivo a ser transformado
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Selecione o arquivo .txt ou .dat", "txt", "dat");
        file.setAcceptAllFileFilterUsed(false);
        file.addChoosableFileFilter(filtro);
        int resposta = file.showOpenDialog(null);
        if (resposta == JFileChooser.APPROVE_OPTION) {
            File path = file.getSelectedFile();
            String aux1 = path.getAbsolutePath();
            aux.leArquivo(aux1, automato);
            JOptionPane.showMessageDialog(null, "Arquivo lido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "ERRO! Nenhum arquivo selecionado");
            return;
        }
    
        JOptionPane.showMessageDialog(null, "Selecione o diretorio que deseja salvar o resultado!");
        JFileChooser file2 = new JFileChooser(); //recebimento do endereço do arquivo que foi transformado
        file2.setAcceptAllFileFilterUsed(false);
        file2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int resposta2 = file2.showOpenDialog(null);
        if (resposta == JFileChooser.APPROVE_OPTION) {
            File criaArquivo = file2.getSelectedFile();
            String aux2 = criaArquivo.getAbsolutePath() + "\\resultado.txt";
            aux.criaArquivo(aux2, automato);
            JOptionPane.showMessageDialog(null, "Pasta selecionada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "ERRO! Nenhuma pasta selecionada");
            return;
        }

       
        
    }

}
