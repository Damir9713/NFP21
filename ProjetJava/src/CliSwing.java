import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CliSwing {
        public static void main(String[] args)
        {
            JFrame frame = new JFrame();
            frame.setSize(500, 200);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
            JButton btnCreuse = new JButton("Creuse (C)");
            JButton btnPleine = new JButton("Pleine (P)");
            panel1.add(btnCreuse);
            panel1.add(btnPleine);

            JPanel panel2 = new JPanel(new GridLayout(3, 3, 2, 2));
            JLabel label1 = new JLabel("Valeur de l'indice (K)");
            JTextField textField1 = new JTextField();
            JButton button1 = new JButton("+");
            JLabel label2 = new JLabel("Valeur de l'indice (A)");
            JTextField textField2 = new JTextField();
            JButton button2 = new JButton("+");
            JLabel label3 = new JLabel("Valeur de l'indice (E)");
            JTextField textField3 = new JTextField();
            JButton button3 = new JButton("+");
            panel2.add(label1);
            panel2.add(textField1);
            panel2.add(button1);
            panel2.add(label2);
            panel2.add(textField2);
            panel2.add(button2);
            panel2.add(label3);
            panel2.add(textField3);
            panel2.add(button3);

            JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
            panel3.setBackground(Color.WHITE);
            JLabel labelK = new JLabel("-K");
            JLabel labelValueK = new JLabel("");
            JLabel labelA = new JLabel("-A");
            JLabel labelValueA = new JLabel("");
            JLabel labelE = new JLabel("-E");
            JLabel labelValueE = new JLabel("");
            JLabel labelCreuse = new JLabel("");
            JLabel labelPleine = new JLabel("");
            panel3.add(labelK);
            panel3.add(labelValueK);
            panel3.add(labelA);
            panel3.add(labelValueA);
            panel3.add(labelE);
            panel3.add(labelValueE);
            panel3.add(labelCreuse);
            panel3.add(labelPleine);

            frame.add(panel1, BorderLayout.NORTH);
            frame.add(panel2, BorderLayout.CENTER);
            frame.add(panel3, BorderLayout.SOUTH);

            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Récupération du texte du JTextField1
                    String text = textField1.getText();
                    // Affichage du texte dans la JLabel labelValueK
                    labelValueK.setText(text);
                }
            });

            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Récupération du texte du JTextField1
                    String text = textField2.getText();
                    // Affichage du texte dans la JLabel labelValueK
                    labelValueA.setText(text);
                }
            });

            button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Récupération du texte du JTextField1
                    String text = textField3.getText();
                    // Affichage du texte dans la JLabel labelValueK
                    labelValueE.setText(text);
                }
            });

            btnCreuse.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Récupération du texte du JTextField1
                    // Affichage du texte dans la JLabel labelValueK
                    labelCreuse.setText("-C");
                }
            });

            btnPleine.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Récupération du texte du JTextField1
                    // Affichage du texte dans la JLabel labelValueK
                    labelPleine.setText("-P");
                }
            });

            frame.setVisible(true);

        }
    }

