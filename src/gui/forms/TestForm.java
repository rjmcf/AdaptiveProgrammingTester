package gui.forms;

import entryPoints.ExerciseSetter;
import miniJAST.exceptions.MiniJASTException;
import questions.Difficulty;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

public class TestForm {

    private JPanel panel;
    private JSlider blankSlider;
    private JButton genButton;
    private JSlider baseSlider;
    private JTextArea display;
    private JButton runButton;
    private JTextField questionField;
    private static ExerciseSetter eS;
    private static String question;
    private static String solution;

    public TestForm() {
        genButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int b = baseSlider.getValue();
                int p = blankSlider.getValue();
                eS.setCurrentDifficulty(new Difficulty(b, p));
                Difficulty diff = eS.getCurrentDifficulty();
                baseSlider.setValue(diff.base);
                int nodes = eS.getNumNodes();
                blankSlider.setMaximum(nodes);
                blankSlider.setValue(diff.nodesBlank);
                setQuestion();
            }
        });

        runButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String submitted = display.getText();
                    eS.setSolution(submitted);
                    if (eS.runSolution()) {
                        display.append("\nExercise completed!\n");
                    } else {
                        //TODO why is VariableDecException caught and not thrown?
                        display.append("\nA mistake was made somewhere.\n");
                    }
                } catch (MiniJASTException me) {
                    display.append("\nA mistake was made somewhere. The following error was raised: \n\"" + me.getMessage() + "\"\n");
                }
            }
        });
    }

    private void setQuestion() {
        question = eS.getQuestion();
        solution = eS.getSolution();
        questionField.setText(question);
        display.setText(solution);
    }

    public static void main(String[] args) {
        eS = new ExerciseSetter(new StringWriter());
        JFrame frame = new JFrame("TestForm");
        frame.setContentPane(new TestForm().panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        int min = eS.getMinBaseDifficulty();
        int max = eS.getMaxBaseDifficulty();
        Difficulty diff = eS.getCurrentDifficulty();
        int nodes = eS.getNumNodes();
        baseSlider = new JSlider(min, max, diff.base);
        baseSlider.setMajorTickSpacing(1);
        baseSlider.setPaintTicks(true);
        baseSlider.setSnapToTicks(true);
        blankSlider = new JSlider(1, nodes, diff.nodesBlank);
        blankSlider.setMajorTickSpacing(5);
        blankSlider.setMinorTickSpacing(1);
        blankSlider.setPaintTicks(true);
        blankSlider.setSnapToTicks(true);
    }
}
