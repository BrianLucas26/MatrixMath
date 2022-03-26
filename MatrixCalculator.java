/* Matrix Calculator
   Author: Brian Lucas
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.text.*;
public class gui {

    public static void main(String args[]) {
        setup();
    }
    public static void setup() {
        // Create the frame
        JFrame frame = new JFrame("Calculator GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(345,340);
        frame.setLocation(600,225);
        frame.setLayout(null);
        //frame.setLayout(new GridLayout(3, 2));

        // Create the buttons
        JButton addButton = new JButton("Add");
        addButton.setBounds(20,10,140,100);
        JButton subButton = new JButton("Subtract");
        subButton.setBounds(170,10,140,100);
        JButton multButton = new JButton("Multiply");
        multButton.setBounds(20,120,140,100);
        JButton dotButton = new JButton("Inverse");
        dotButton.setBounds(170,120,140,100);
        //JButton invertButton = new JButton("Inverse");
        //invertButton.setBounds(95,230,140,100);

        // Add the buttons
        frame.add(addButton);
        frame.add(subButton);
        frame.add(multButton);
        frame.add(dotButton);
        //frame.add(invertButton);

        // Create actionEvents for buttons
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setup2("add");
            }
        });

        subButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setup2("sub");
            }
        });

        multButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setup2("mult");
            }
        });

        dotButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setup3();
            }
        });

  /*      invertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setup2("invert");
            }
        });   */

        // Create and add description text box
        final JLabel description = new JLabel("Please choose the correct matrix operation.");
        description.setBounds(40,230,290,50);
        frame.add(description);
        frame.setVisible(true);
    }

    public static void setup2(String operation) {
        JFrame frame2 = new JFrame("Matrix Input");
        frame2.setSize(250,250);
        frame2.setLocation(950,225);
        frame2.setLayout(null);

        // Start button
        JButton startButton = new JButton("Go!");
        startButton.setBounds(70,150,100,50);
        frame2.add(startButton);

        // Create Matrix A text fields
        final JLabel a = new JLabel("Matrix A:");
        a.setBounds(5,12,50,50);
        frame2.add(a);
        final JTextField a1 = new JTextField();
        a1.setBounds(60,10,25,25);
        frame2.add(a1);
        final JTextField a2 = new JTextField();
        a2.setBounds(90,10,25,25);
        frame2.add(a2);
        final JTextField a3 = new JTextField();
        a3.setBounds(60,40,25,25);
        frame2.add(a3);
        final JTextField a4 = new JTextField();
        a4.setBounds(90,40,25,25);
        frame2.add(a4);

        // Create Matrix B text fields
        final JLabel b = new JLabel("Matrix B:");
        b.setBounds(117,12,50,50);
        frame2.add(b);
        final JTextField b1 = new JTextField();
        b1.setBounds(170,10,25,25);
        frame2.add(b1);
        final JTextField b2 = new JTextField();
        b2.setBounds(200,10,25,25);
        frame2.add(b2);
        final JTextField b3 = new JTextField();
        b3.setBounds(170,40,25,25);
        frame2.add(b3);
        final JTextField b4 = new JTextField();
        b4.setBounds(200,40,25,25);
        frame2.add(b4);

        final JLabel result = new JLabel("Result:");
        result.setBounds(5,75,50,50);
        frame2.add(result);

        frame2.setVisible(true);

        // Perform the operations
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a1I = Integer.parseInt(a1.getText());
                int a2I = Integer.parseInt(a2.getText());
                int a3I = Integer.parseInt(a3.getText());
                int a4I = Integer.parseInt(a4.getText());
                int b1I = Integer.parseInt(b1.getText());
                int b2I = Integer.parseInt(b2.getText());
                int b3I = Integer.parseInt(b3.getText());
                int b4I = Integer.parseInt(b4.getText());
                int result1 = 0;
                int result2 = 0;
                int result3 = 0;
                int result4 = 0;
                if (operation == "add") {
                    result1 = a1I + b1I;
                    result2 = a2I + b2I;
                    result3 = a3I + b3I;
                    result4 = a4I + b4I;
                } else if (operation == "sub") {
                    result1 = a1I - b1I;
                    result2 = a2I - b2I;
                    result3 = a3I - b3I;
                    result4 = a4I - b4I;
                } else if (operation == "mult") {
                    result1 = a1I * b1I + a2I * b3I;
                    result2 = a1I * b2I + a2I * b4I;
                    result3 = a3I * b1I + a4I * b3I;
                    result4 = a3I * b2I + a4I * b4I;
                } else if (operation == "invert") {
                    if (a1I * a4I - a2I * a3I != 0) {
                        int determinant = 1 / (a1I * a4I - a2I * a3I);
                        result1 = determinant * a4I;
                        result2 = determinant * a2I * -1;
                        result3 = determinant * a3I * -1;
                        result4 = determinant * a1I;
                    }
                }

                frame2.setVisible(false);
                final JLabel r1 = new JLabel(String.valueOf(result1));
                r1.setBounds(95,70,50,50);
                frame2.add(r1);
                final JLabel r2 = new JLabel(String.valueOf(result2));
                r2.setBounds(135,70,50,50);
                frame2.add(r2);
                final JLabel r3 = new JLabel(String.valueOf(result3));
                r3.setBounds(95,100,50,50);
                frame2.add(r3);
                final JLabel r4 = new JLabel(String.valueOf(result4));
                r4.setBounds(135,100,50,50);
                frame2.add(r4);
                frame2.remove(startButton);
                frame2.setVisible(true);
            }
        });
    }

    public static void setup3() {
        JFrame frame2 = new JFrame("Matrix Input");
        frame2.setSize(250,250);
        frame2.setLocation(950,225);
        frame2.setLayout(null);

        // Start button
        JButton startButton = new JButton("Go!");
        startButton.setBounds(70,150,100,50);
        frame2.add(startButton);

        // Create Matrix A text fields
        final JLabel a = new JLabel("Matrix A:");
        a.setBounds(5,12,50,50);
        frame2.add(a);
        final JTextField a1 = new JTextField();
        a1.setBounds(90,10,25,25);
        frame2.add(a1);
        final JTextField a2 = new JTextField();
        a2.setBounds(120,10,25,25);
        frame2.add(a2);
        final JTextField a3 = new JTextField();
        a3.setBounds(90,40,25,25);
        frame2.add(a3);
        final JTextField a4 = new JTextField();
        a4.setBounds(120,40,25,25);
        frame2.add(a4);

        final JLabel result = new JLabel("Result:");
        result.setBounds(5,75,50,50);
        frame2.add(result);

        frame2.setVisible(true);

        // Perform the operations
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a1I = Integer.parseInt(a1.getText());
                int a2I = Integer.parseInt(a2.getText());
                int a3I = Integer.parseInt(a3.getText());
                int a4I = Integer.parseInt(a4.getText());
                //float result1 = 0;
                //float result2 = 0;
                //float result3 = 0;
                //float result4 = 0;
                if (a1I * a4I - a2I * a3I == 1) {
                    int result1 = a4I;
                    int result2 = a2I * -1;
                    int result3 = a3I * -1;
                    int result4 = a1I;
                    frame2.setVisible(false);
                    final JLabel r1 = new JLabel(String.valueOf(result1));
                    r1.setBounds(95,70,50,50);
                    frame2.add(r1);
                    final JLabel r2 = new JLabel(String.valueOf(result2));
                    r2.setBounds(135,70,50,50);
                    frame2.add(r2);
                    final JLabel r3 = new JLabel(String.valueOf(result3));
                    r3.setBounds(95,100,50,50);
                    frame2.add(r3);
                    final JLabel r4 = new JLabel(String.valueOf(result4));
                    r4.setBounds(135,100,50,50);
                    frame2.add(r4);
                    frame2.remove(startButton);
                    frame2.setVisible(true);
                }
                else if (a1I * a4I - a2I * a3I != 0) {
                    //double determinant = 1 / ((a1I * a4I) - (a2I * a3I));
                    double det = a1I * a4I;
                    double ter = a2I * a3I;
                    double min = det - ter;
                    double determinant = 1 / min;
                    //System.out.println(determinant);
                    double result1 = a4I * determinant;
                    double result2 = determinant * a2I * -1;
                    double result3 = determinant * a3I * -1;
                    double result4 = determinant * a1I;

                    DecimalFormat df = new DecimalFormat("#.##");
                    String result1S = df.format(result1);
                    String result2S = df.format(result2);
                    String result3S = df.format(result3);
                    String result4S = df.format(result4);

                    frame2.setVisible(false);
                    final JLabel r1 = new JLabel(result1S);
                    r1.setBounds(95,70,50,50);
                    frame2.add(r1);
                    final JLabel r2 = new JLabel(result2S);
                    r2.setBounds(135,70,50,50);
                    frame2.add(r2);
                    final JLabel r3 = new JLabel(result3S);
                    r3.setBounds(95,100,50,50);
                    frame2.add(r3);
                    final JLabel r4 = new JLabel(result4S);
                    r4.setBounds(135,100,50,50);
                    frame2.add(r4);
                    frame2.remove(startButton);
                    frame2.setVisible(true);
                }

        /*        frame2.setVisible(false);
                final JLabel r1 = new JLabel(String.valueOf(result1));
                r1.setBounds(95,70,50,50);
                frame2.add(r1);
                final JLabel r2 = new JLabel(String.valueOf(result2));
                r2.setBounds(135,70,50,50);
                frame2.add(r2);
                final JLabel r3 = new JLabel(String.valueOf(result3));
                r3.setBounds(95,100,50,50);
                frame2.add(r3);
                final JLabel r4 = new JLabel(String.valueOf(result4));
                r4.setBounds(135,100,50,50);
                frame2.add(r4);
                frame2.remove(startButton);
                frame2.setVisible(true); */
            }
        });
    }
}
