package ru.sanchez6813.wolf;

import ru.sanchez6813.wolf.core.GameManager;
import ru.sanchez6813.wolf.core.views.BaseView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {
    public static void main(String[] args) {
        // Точка входа, создаем экземпляр главного окна
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow();
            }
        });

    }

    private MainWindow() {
        // Инициализируем свойства окна
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle("Wolf");
        frame.setBounds(100, 100, 800, 500);
        // Приложение должно завершиться после закрытия окна
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Добавляем верхнее меню для старта, паузы игры
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        final JMenuItem startMenuItem = new JMenuItem("Start");
        menuBar.add(startMenuItem);
        final JMenuItem pauseMenuItem = new JMenuItem("Pause");
        pauseMenuItem.setEnabled(false);
        menuBar.add(pauseMenuItem);

        // Создаем вьюшку и добавляем ее в окно
        BaseView view = new BaseView();
        frame.getContentPane().add(view);

        // Создаем мэнеджер управляющий логикой игры
        final GameManager gameManager = new GameManager(view);

        // Подписываем менеджер на события клавиатуры
        frame.addKeyListener(gameManager);

        // Подписываемся на клики по меню
        startMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameManager.start();
                startMenuItem.setEnabled(false);
                pauseMenuItem.setEnabled(true);
            }
        });
        pauseMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameManager.stop();
                startMenuItem.setEnabled(true);
                pauseMenuItem.setEnabled(false);
            }
        });
    }
}