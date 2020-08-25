package View;

/*
 * Written using Oracle jSwing examples:
 *   https://docs.oracle.com/javase/tutorial/uiswing/examples/components/TextDemoProject/src/components/TextDemo.java
 *   https://docs.oracle.com/javase/tutorial/uiswing/examples/components/DialogDemoProject/src/components/DialogDemo.java
 *   https://docs.oracle.com/javase/tutorial/uiswing/examples/components/TextSamplerDemoProject/src/components/TextSamplerDemo.java
 */

import Controller.Controller;
import Controller.Constants;
import Model.Level;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;              //for layout managers and more
import java.awt.event.*;        //for action events


public class StartScreen extends JPanel implements ActionListener{
    private String TITLE = Constants.getTITLE();
    private Controller controller;
    protected JFrame frame;
    protected JTextField textField;
    protected JLabel actionLabel;
    private String font = "Book Antiqua";

    public StartScreen(Controller controller){
        this.controller = controller;

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;

        textField = new JTextField(20);
        textField.addActionListener(this);

        JLabel instructions = new JLabel("Type the desired game name and press Enter.");
        instructions.setFont(new Font(this.font, Font.PLAIN, 20));
        JLabel instructions2 = new JLabel("The game name can be changed until the SUBMIT button is pressed.");
        instructions2.setFont(new Font(this.font, Font.ITALIC, 16));
        actionLabel = new JLabel("No game name provided. Game name currently set to DEFAULT");
        actionLabel.setFont(new Font(this.font, Font.BOLD, 16));

        add(instructions, c);
        add(instructions2, c);
        add(textField, c);
        add(actionLabel, c);

        JLabel ignore = new JLabel("If the game name is already in use, the level choice will be ignored " +
                "and you will be added to the current game.");
        ignore.setFont(new Font(this.font, Font.BOLD, 16));

        JPanel options = levelOptions();
        Border padding = BorderFactory.createEmptyBorder(20,20,5,20);
        options.setBorder(padding);

        add(options, c);
        add(ignore, c);

    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String prefix = "Saved Game Name: ";
        String gameName = textField.getText();
        actionLabel.setText(prefix + gameName);
        controller.setGameName(gameName);
    }

    private JPanel levelOptions(){
        int numButtons = 4;
        JRadioButton[] radioButtons = new JRadioButton[numButtons];
        ButtonGroup group = new ButtonGroup();

        radioButtons[0] = new JRadioButton("EASY");
        radioButtons[0].setActionCommand("E");
        radioButtons[0].setFont(new Font(this.font, Font.PLAIN, 16));
        radioButtons[1] = new JRadioButton("MEDIUM");
        radioButtons[1].setActionCommand("M");
        radioButtons[1].setFont(new Font(this.font, Font.PLAIN, 16));
        radioButtons[2] = new JRadioButton("HARD");
        radioButtons[2].setActionCommand("H");
        radioButtons[2].setFont(new Font(this.font, Font.PLAIN, 16));
        radioButtons[3] = new JRadioButton("VERY HARD");
        radioButtons[3].setActionCommand("VH");
        radioButtons[3].setFont(new Font(this.font, Font.PLAIN, 16));

        for(int i = 0; i < numButtons; i++){
            group.add(radioButtons[i]);
        }
        radioButtons[0].setSelected(true);

        JButton submit = new JButton("SUBMIT");
        submit.setFont(new Font(this.font, Font.BOLD, 16));
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = group.getSelection().getActionCommand();
                Level choice = Level.EASY;

                switch (command){
                    case "E":
                        choice = Level.EASY;
                        break;
                    case "M":
                        choice = Level.MEDIUM;
                        break;
                    case "H":
                        choice = Level.HARD;
                        break;
                    case "VH":
                        choice = Level.VERY_HARD;
                        break;
                    default:
                        choice = Level.EASY;
                        break;
                }

                controller.setLevel(choice);
                frame.dispose();
                return;
            }
        });

        return createPane(radioButtons, submit);
    }

    private JPanel createPane(JRadioButton[] radioButtons, JButton showButton) {
        int numChoices = radioButtons.length;
        JPanel box = new JPanel();
        JLabel label = new JLabel("If you are starting a new game, please also choose a desired level: ");
        label.setFont(new Font(this.font, Font.PLAIN, 16));;

        box.setLayout(new BoxLayout(box, BoxLayout.PAGE_AXIS));
        box.add(label);

        for (int i = 0; i < numChoices; i++) {
            box.add(radioButtons[i]);
        }

        JPanel pane = new JPanel(new BorderLayout());
        pane.add(box, BorderLayout.PAGE_START);
        pane.add(showButton, BorderLayout.PAGE_END);
        return pane;
    }

    private void createAndShowGUI(){
        frame = new JFrame(this.TITLE);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        frame.add(this);
        frame.pack();
        frame.setVisible(true);
    }

    public void start(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
