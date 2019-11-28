import GameEntity.Enemy.*;
import GameEntity.GameTile.*;
import GameEntity.GameTile.Bullet.Bullet;
import GameEntity.GameTile.Bullet.NormalBullet;
import GameEntity.GameTile.Tower.MachineGunTower;
import GameEntity.GameTile.Tower.NormalTower;
import GameEntity.GameTile.Tower.Tower;
import GameEntity.GameTile.Tower.TowerButton.MachineGunTowerButton;
import GameEntity.GameTile.Tower.TowerButton.NormalTowerButton;
import GameEntity.GameTile.Tower.TowerButton.TowerButton;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

public class GameField extends JPanel implements ActionListener,Runnable{
    private List<Tower> towers = new ArrayList<Tower>();
    private List<Enemy> enemies = new ArrayList<Enemy>();
    private GamePlay gamePlay;
    private GameConfig config;
    private Road road;
    private Mountain mountain;
    private GameFrame frame;
    private Hall hall;
    private Timer timer;
    private final int DELAY = 50;
    private TowerButton[] buttons;
    private BackGround backGround;
    private File file;
    private File wave;
    private Scanner scanner;
    private Thread animator;
    private int tinyEnemies = 0;
    private int normalEnemies = 0;
    private int tankerEnemies = 0;
    private int bossEnemies = 0;
    private int Wave ;
    private int currentWave = 0;
    private int[][] numberEnemy;
    private Timer t1, t2, t3;
    public GameField() {
        Init();
    }

    private void Init() {
        MouseHandle mouseHandle = new MouseHandle();
        addMouseListener(mouseHandle);
        addMouseMotionListener(mouseHandle);
        Wave = 2;
        numberEnemy = new int[Wave][4];
        gamePlay = new GamePlay();
        frame = new GameFrame();
        config = new GameConfig();
        buttons = new TowerButton[3];
        buttons[1] = new NormalTowerButton();
        buttons[2] = new MachineGunTowerButton();
        buttons[0] = new TowerButton();
        NormalEnemy normalEnemy = new NormalEnemy();
        backGround = new BackGround();
        t1 = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateNormalTower();
            }
        });
        t1.start();
        t2 = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateMachineTower();
            }
        });
        t2.start();
        t3 = new Timer(2500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getEnemy();
            }
        });
        t3.start();
        file = new File("Map.txt");
        wave = new File("Wave.txt");
    }

    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        drawTile(g);
        for (int i=0;i<enemies.size();i++) {
            Enemy enemy = enemies.get(i);
            if (!enemy.isKilled()) {
                enemy.drawEnemy(g);
                }
        }
            for (int i = 0; i < towers.size(); i++) {
                towers.get(i).drawTower(g);
            }
            for (int i = 0; i < towers.size(); i++) {
                ArrayList<Bullet> bulletList = towers.get(i).getBulletList();
                for (Bullet bullet : bulletList) {
                    bullet.draw(g);
                }
            }
            for (int i=1;i<3;i++) {
                buttons[i].drawButton(g);
                if (buttons[i].isGetClicked()) buttons[i].draw(g);
            }
            int t = config.getHealth();
            if (t <=0) {
                gamePlay.draw(g);
                //animator.stop();
              //JOptionPane.showMessageDialog(this,"Hello", "Title", JOptionPane.QUESTION_MESSAGE);
            }
            Toolkit.getDefaultToolkit().sync();
        }

    private void drawTile(Graphics g) {
        mountain = new Mountain();
        road = new Road();
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        backGround.draw(g);
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 32; j++) {
                int temp = scanner.nextInt();
                if (temp== 1) {
                    road.setX(j*32);
                    road.setY(i*32);
                    road.draw(g);
                } else if (temp == 3) {
                    mountain.setX(j*32);
                    mountain.setY(i*32);
                    mountain.draw(g);
                }
            }
        }
        hall = new Hall();
        hall.draw(g);
        backGround.drawPredict(g);
        frame.draw(g);
        config.draw(g);
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    private void updateEnemy() {
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            if (!enemy.isKilled()) {
                enemy.move();
            } else {
                if (enemy.isAttack() == false) {
                    config.setGold(enemy.getReward());
                    enemies.remove(i);
                } else {
                    config.Attacked(enemy.getDam());
                    enemies.remove(i);
                }
            }
        }
    }

    public void updateNormalTower() {
        for (int i = 0; i < towers.size(); i++) {
            if (towers.get(i) instanceof NormalTower) {
                ArrayList<Bullet> bullets = towers.get(i).getBulletList();
                if (!enemies.isEmpty()) {
                    for (int j = 0; j < enemies.size(); j++) {
                        if (enemies.get(j).isRanged(towers.get(i).getX(), towers.get(i).getY(), towers.get(i).getRange())) {
                            towers.get(i).fire();
                            break;
                        }
                    }
                }
            }
        }
    }
    private void updateMachineTower() {
        for (int i = 0; i < towers.size(); i++) {
            if (towers.get(i) instanceof MachineGunTower) {
                ArrayList<Bullet> bullets = towers.get(i).getBulletList();
                if (!enemies.isEmpty()) {
                    for (int j = 0; j < enemies.size(); j++) {
                        if (enemies.get(j).isRanged(towers.get(i).getX(), towers.get(i).getY(), towers.get(i).getRange())) {
                            towers.get(i).fire();
                            break;
                        }
                    }
                }
            }
        }
    }
    private void updateBullet() {
        for (int i = 0; i < towers.size(); i++) {
            ArrayList<Bullet> bullets = towers.get(i).getBulletList();
            if (!enemies.isEmpty()) {
                int index = 0;
                while (index < enemies.size()) {
                    if (enemies.get(index).isRanged(towers.get(i).getX(), towers.get(i).getY(), towers.get(i).getRange())) {
                        for (int j = 0; j < bullets.size(); j++) {
                            Bullet bullet = bullets.get(j);
                            if (bullet.getVisible())
                                bullet.move(enemies.get(index).getPosX()+enemies.get(index).getW()/6, enemies.get(index).getPosY() + enemies.get(index).getH()/3);
                            else bullets.remove(j);
                        }
                        break;
                    } else index++;
                }
                if (index >= enemies.size()) bullets.clear();
            } else bullets.clear();
        }

    }
    private void getEnemy() {
        Scanner sc = null;
        try {
             sc = new Scanner(wave);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        sc.nextLine();
        for (int i=0;i<Wave;i++) {
            for (int j = 0; j < 4; j++) {
                int a = sc.nextInt();
                numberEnemy[i][j] = a;
            }
        }
        if (tinyEnemies < numberEnemy[currentWave][0]) {
            Enemy enemy = new TinyEnemy();
            enemies.add(enemy);
            tinyEnemies++;
        } else
        if (this.tinyEnemies == numberEnemy[currentWave][0] && normalEnemies < numberEnemy[currentWave][1]) {
            Enemy enemy = new NormalEnemy();
            enemies.add(enemy);
            normalEnemies++;
        } else
        if (tinyEnemies == numberEnemy[currentWave][0] && normalEnemies == numberEnemy[currentWave][1]&& tankerEnemies < numberEnemy[currentWave][2]) {
            Enemy enemy = new TankerEnemy();
            enemies.add(enemy);
            tankerEnemies++;
        } else
        if (tinyEnemies == numberEnemy[currentWave][0] && normalEnemies == numberEnemy[currentWave][1]&& tankerEnemies == numberEnemy[currentWave][2] && bossEnemies < numberEnemy[currentWave][3]) {
            Enemy enemy = new BossEnemy();
            enemies.add(enemy);
            bossEnemies++;
        }
        if (tinyEnemies == numberEnemy[currentWave][0] && normalEnemies == numberEnemy[currentWave][1]&& tankerEnemies == numberEnemy[currentWave][2] && bossEnemies == numberEnemy[currentWave][3]) {
            if (currentWave < Wave && enemies.isEmpty()) {
                currentWave++;
                tinyEnemies = 0;
                normalEnemies = 0;
                tankerEnemies = 0;
                bossEnemies = 0;
            }
        }
    }

    private void collision() {
        for (int i = 0; i < towers.size(); i++) {
            ArrayList<Bullet> bullets = towers.get(i).getBulletList();
            for (Bullet bullet : bullets) {
                Rectangle r2 = bullet.getBounds();
                for (Enemy enemy : enemies) {
                    Rectangle r1 = enemy.getBounds();
                    if (r2.intersects(r1)) {
                        bullet.setVisible(false);
                        enemy.getShot(bullet.getDamage());
                        break;
                    }
                }
            }
        }
    }

    private class MouseHandle extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            for (int index=0;index<3;index++) {
                TowerButton t = buttons[index];
                if (e.getX() > t.getX1() && e.getX() < t.getX1() + t.getW() && e.getY() > t.getY1() && e.getY() < t.getY1() + t.getH()) {
                    t.setGetClicked(true);
                } else {
                    try {
                        scanner = new Scanner(file);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    if (t.isGetClicked() == true) {
                        for (int i = 0; i < 24; i++) {
                            for (int j = 0; j < 32; j++) {
                                if (scanner.nextInt() == 2) {
                                    if (e.getX() >= j * 32 && e.getX() < j * 32 + t.getW() && e.getY() >= i * 32 && e.getY() < i * 32 + t.getH()) {
                                        if (t instanceof NormalTowerButton) {
                                            if (config.getGold() >= t.getPrice()) {
                                                config.BuyTower(t.getPrice());
                                                Tower tower = new NormalTower();
                                                tower.setX(j * 32);
                                                tower.setY(i * 32);
                                                towers.add(tower);
                                            } //else t.setGetClicked(false);
                                        }
                                        if (t instanceof MachineGunTowerButton) {
                                            if (config.getGold() >= t.getPrice()) {
                                                config.BuyTower(t.getPrice());
                                                Tower tower = new MachineGunTower();
                                                tower.setX(j * 32);
                                                tower.setY(i * 32);
                                                towers.add(tower);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    t.setGetClicked(false);
                    t.setX(t.getX1());
                    t.setY(t.getY1());
                }
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            for (int index= 0;index<3;index++) {
                TowerButton t = buttons[index];
                if (t.isGetClicked() == true) {
                    t.MouseMoved(e);
                    repaint();
                    try {
                        scanner = new Scanner(file);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    for (int i = 0; i < 24; i++) {
                        for (int j = 0; j < 32; j++) {
                            if (scanner.nextInt() == 2) {
                                if (e.getX() >= j * 32 && e.getX() <= j * 32 + t.getW() && e.getY() >= i * 32 && e.getY() <= i * 32 + t.getH()) {
                                    if (t instanceof MachineGunTowerButton) {
                                        backGround.setPredicted(true);
                                        backGround.setX1(j * 32);
                                        backGround.setY1(i * 32);
                                        backGround.IsPredicted("MachineGunTower");
                                    }
                                    if (t instanceof NormalTowerButton){
                                        backGround.setPredicted(true);
                                        backGround.setX1(j * 32);
                                        backGround.setY1(i * 32);
                                        backGround.IsPredicted("NormalTower");
                                    }
                                }
                            }
                        }
                    }
                    break;
                } else {
                    backGround.setPredicted(false);
                }
            }
        }
    }

    @Override
    public void addNotify() {
        super.addNotify();
        animator= new Thread(this);
        animator.start();
    }
    @Override
    public void run() {
        long beforeTime, beforeTime1;
        beforeTime = System.currentTimeMillis();
        beforeTime1 = System.currentTimeMillis();
        while (true) {
            updateEnemy();
            updateBullet();
            collision();
             repaint();
             try {
                 Thread.sleep(DELAY);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
        }
    }
}
