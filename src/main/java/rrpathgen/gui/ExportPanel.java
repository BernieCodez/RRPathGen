package rrpathgen.gui;

import rrpathgen.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import static rrpathgen.gui.ModernUIStyles.*;

public class ExportPanel extends JPanel {

    JTextArea field = new JTextArea();
    JScrollPane scroll = new JScrollPane(field);
    JCheckBox dataType = new JCheckBox("Datatype", true);
    JCheckBox poseEstimate = new JCheckBox("setPoseEstimate", false);
    public boolean addDataType = true;
    public boolean addPoseEstimate = false;
    JButton copy = new JButton("Copy to clipboard");
    Main main;

    public ExportPanel(Main main) {
        field.setText("Export");

        this.main = main;
        this.setOpaque(true);
        this.setBackground(BACKGROUND_DARK);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(PADDING_MEDIUM, PADDING_MEDIUM, PADDING_MEDIUM, PADDING_MEDIUM));

        this.setMinimumSize(new Dimension(200,10));

        // Apply modern styling
        styleTextArea(field);
        styleScrollPane(scroll);
        styleCheckBox(dataType);
        styleCheckBox(poseEstimate);
        stylePrimaryButton(copy);

        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Add components with spacing
        this.add(dataType, BorderLayout.WEST);
        this.add(Box.createVerticalStrut(PADDING_SMALL));
        this.add(poseEstimate, BorderLayout.EAST);
        this.add(Box.createVerticalStrut(PADDING_MEDIUM));
        this.add(copy);
        this.add(Box.createVerticalStrut(PADDING_SMALL));
        this.add(scroll);
        this.setVisible(true);

        copy.addActionListener(e -> {
            StringSelection selection = new StringSelection(field.getText());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(selection, selection);
        });

        dataType.addItemListener(e -> {
            addDataType = e.getStateChange()==1;
            main.buttonPanel.export();
        });
        poseEstimate.addItemListener(e -> {
            addPoseEstimate = e.getStateChange()==1;
            main.buttonPanel.export();
        });

    }

    @Override
    public Dimension getPreferredSize() {
        return super.getPreferredSize();
    }


}
