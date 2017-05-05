package gui.forms;

import entryPoints.ExerciseSetter;
import miniJAST.exceptions.MiniJASTException;
import questions.Difficulty;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

public class TestForm{

    private JPanel panel;
    private JSlider blankSlider;
    private JButton genButton;
    private JSlider baseSlider;
    private JTextArea display;
    private JButton runButton;
    private JTextField questionField;
    private JTextArea output;
    private JButton nextQuestionButton;
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
                eS.setUp();
                Difficulty diff = eS.getCurrentDifficulty();
                baseSlider.setValue(diff.base);
                int nodes = eS.getNumNodes();
                blankSlider.setMaximum(nodes);
                blankSlider.setValue(diff.nodesBlank);
                nextQuestionButton.setVisible(false);
                setQuestion();
            }
        });

        nextQuestionButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    eS.adjustQuestion();

                } catch (ArrayIndexOutOfBoundsException aE) {
                    output.append("There are no more exercises!");
                }
                Difficulty diff = eS.getCurrentDifficulty();
                eS.setCurrentDifficulty(diff);
                eS.setUp();
                baseSlider.setValue(diff.base);
                int nodes = eS.getNumNodes();
                blankSlider.setMaximum(nodes);
                blankSlider.setValue(diff.nodesBlank);
                nextQuestionButton.setVisible(false);
                setQuestion();
            }
        });

        runButton.addMouseListener(new MouseAdapter() {
            // TODO run code in separate thread
            // TODO 'total not declared in this scope' for SquareExercise when using chars
            // TODO reset attempts
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String submitted = display.getText();
                    eS.setSolution(submitted);
                    if (eS.submitAttempt()) {
                        output.setText("Exercise completed!\n");
                        output.append("This exercise took " + eS.getAttempts() + " attempts.\n");
                        String adjustment = eS.reportPerformance() > 0 ? "harder" : "easier";
                        output.append("The next question will be " + adjustment + ".\n");
                        nextQuestionButton.setVisible(true);
                    } else {
                        output.setText("A mistake was made somewhere.\n");
                    }
                } catch (MiniJASTException me) {
                    output.setText("A mistake was made somewhere. The following error was raised: \n\"" + me.getMessage() + "\"\n");
                } catch (NullPointerException nE) {
                    output.setText("A mistake was made somewhere. Check for blanks that were removed but not filled.");
                }
            }
        });
    }

    private void setQuestion() {
        question = eS.getQuestion();
        solution = eS.getSolution();
        questionField.setText(question);
        display.setText(solution);
        output.setText("");
    }

    public static void main(String[] args) {
        eS = new ExerciseSetter(new StringWriter());
        JFrame frame = new JFrame("Adaptive Programming Exercises GUI");
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
        blankSlider = new JSlider(1, nodes, diff.nodesBlank);
    }
}
