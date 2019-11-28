import javax.swing.*;

public class GameStage extends JFrame {
    public GameStage() {
        Init();
    }
    private void Init(){
        add(new GameField());
        setTitle("Tower Defense");
        setSize(1024,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }
    public static void main(String[] args) {
        GameStage g = new GameStage();
        g.setVisible(true);
    }
}
