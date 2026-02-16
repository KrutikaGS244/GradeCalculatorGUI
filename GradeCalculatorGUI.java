import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GradeCalculatorGUI {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Grade Calculator");

        // Labels
        JLabel nameLabel = new JLabel("Student Name:");
        JLabel m1Label = new JLabel("Subject 1:");
        JLabel m2Label = new JLabel("Subject 2:");
        JLabel m3Label = new JLabel("Subject 3:");
        JLabel resultLabel = new JLabel("Result:");

        // Text Fields
        JTextField nameField = new JTextField();
        JTextField m1Field = new JTextField();
        JTextField m2Field = new JTextField();
        JTextField m3Field = new JTextField();

        // Buttons
        JButton calcBtn = new JButton("Calculate");
        JButton resetBtn = new JButton("Reset");

        // Set Bounds
        nameLabel.setBounds(50, 30, 120, 30);
        nameField.setBounds(180, 30, 150, 30);

        m1Label.setBounds(50, 70, 120, 30);
        m1Field.setBounds(180, 70, 150, 30);

        m2Label.setBounds(50, 110, 120, 30);
        m2Field.setBounds(180, 110, 150, 30);

        m3Label.setBounds(50, 150, 120, 30);
        m3Field.setBounds(180, 150, 150, 30);

        calcBtn.setBounds(80, 200, 120, 40);
        resetBtn.setBounds(210, 200, 120, 40);

        resultLabel.setBounds(50, 260, 320, 30);

        // Calculate Button Action
        calcBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = nameField.getText();

                    int m1 = Integer.parseInt(m1Field.getText());
                    int m2 = Integer.parseInt(m2Field.getText());
                    int m3 = Integer.parseInt(m3Field.getText());

                    int total = m1 + m2 + m3;
                    double avg = total / 3.0;

                    String grade;
                    Color color;

                    if (avg >= 90) {
                        grade = "A";
                        color = Color.GREEN;
                    } else if (avg >= 70) {
                        grade = "B";
                        color = Color.BLUE;
                    } else if (avg >= 50) {
                        grade = "C";
                        color = Color.ORANGE;
                    } else {
                        grade = "Fail";
                        color = Color.RED;
                    }

                    resultLabel.setText("Name: " + name +
                            " | Total: " + total +
                            " | Avg: " + avg +
                            " | Grade: " + grade);

                    resultLabel.setForeground(color);

                } catch (Exception ex) {
                    resultLabel.setText("Please enter valid numbers!");
                    resultLabel.setForeground(Color.RED);
                }
            }
        });

        // Reset Button Action
        resetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                m1Field.setText("");
                m2Field.setText("");
                m3Field.setText("");

                resultLabel.setText("Result:");
                resultLabel.setForeground(Color.BLACK);
            }
        });

        // Add components
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(m1Label);
        frame.add(m1Field);
        frame.add(m2Label);
        frame.add(m2Field);
        frame.add(m3Label);
        frame.add(m3Field);
        frame.add(calcBtn);
        frame.add(resetBtn);
        frame.add(resultLabel);

        // Frame settings
        frame.setSize(420, 350);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
