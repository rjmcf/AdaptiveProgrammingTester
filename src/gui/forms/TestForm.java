package gui.forms;

import entryPoints.ExerciseSetter;
import questions.Difficulty;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayOutputStream;

public class TestForm {

    private JPanel panel;
    private JSlider blankSlider;
    private JButton button;
    private JSlider baseSlider;
    private JTextArea display;
    private static ExerciseSetter eS;
    private static String text;
    private static ByteArrayOutputStream baos;

    public TestForm() {
        button.addMouseListener(new MouseAdapter() {
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
                baos = new ByteArrayOutputStream();
                eS.setOutput(baos);
                eS.presentQuestion();
                text = baos.toString();
                display.setText(text);
            }
        });
    }

    public static void main(String[] args) {
        baos = new ByteArrayOutputStream();
        eS = new ExerciseSetter(baos);
        eS.presentQuestion();
        text = baos.toString();

        JFrame frame = new JFrame("TestForm");
        frame.setContentPane(new TestForm().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        display = new JTextArea(text);
    }
}
