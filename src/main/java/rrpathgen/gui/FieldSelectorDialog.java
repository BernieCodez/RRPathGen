package rrpathgen.gui;

import rrpathgen.Main;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static rrpathgen.gui.ModernUIStyles.*;

/**
 * Dialog for selecting field images from the resources folder
 */
public class FieldSelectorDialog extends JDialog {

    private final Main main;
    private final List<String> fieldImages;
    private String selectedField;
    private final JPanel previewPanel;
    private final JLabel previewLabel;

    public FieldSelectorDialog(Main main, String currentField) {
        super(main, "Field Selector", true);
        this.main = main;
        this.selectedField = currentField;

        // Get all field images from resources
        fieldImages = getAvailableFields();

        // Setup dialog
        this.setSize(700, 500);
        this.setLocationRelativeTo(main);
        this.getContentPane().setBackground(BACKGROUND_DARK);
        this.setLayout(new BorderLayout(PADDING_MEDIUM, PADDING_MEDIUM));

        // Title panel
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(BACKGROUND_DARK);
        titlePanel.setBorder(new EmptyBorder(PADDING_LARGE, PADDING_LARGE, PADDING_MEDIUM, PADDING_LARGE));
        JLabel titleLabel = new JLabel("Select Field Image");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        titleLabel.setForeground(TEXT_PRIMARY);
        titlePanel.add(titleLabel, BorderLayout.WEST);
        this.add(titlePanel, BorderLayout.NORTH);

        // Main content panel
        JPanel contentPanel = new JPanel(new BorderLayout(PADDING_MEDIUM, PADDING_MEDIUM));
        contentPanel.setBackground(BACKGROUND_DARK);
        contentPanel.setBorder(new EmptyBorder(0, PADDING_LARGE, PADDING_MEDIUM, PADDING_LARGE));

        // List panel
        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.setBackground(BACKGROUND_MEDIUM);
        stylePanel(listPanel);

        JLabel listTitle = new JLabel("Available Fields");
        listTitle.setFont(new Font("Segoe UI", Font.BOLD, 12));
        listTitle.setForeground(TEXT_PRIMARY);
        listTitle.setBorder(new EmptyBorder(0, 0, PADDING_SMALL, 0));
        listPanel.add(listTitle, BorderLayout.NORTH);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String field : fieldImages) {
            listModel.addElement(getDisplayName(field));
        }

        JList<String> fieldList = new JList<>(listModel);
        fieldList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fieldList.setBackground(BACKGROUND_LIGHT);
        fieldList.setForeground(TEXT_PRIMARY);
        fieldList.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        fieldList.setSelectedIndex(fieldImages.indexOf(currentField));

        JScrollPane listScroll = new JScrollPane(fieldList);
        styleScrollPane(listScroll);
        listPanel.add(listScroll, BorderLayout.CENTER);

        // Preview panel
        previewPanel = new JPanel(new BorderLayout());
        previewPanel.setBackground(BACKGROUND_MEDIUM);
        stylePanel(previewPanel);
        previewPanel.setPreferredSize(new Dimension(300, 300));

        JLabel previewTitle = new JLabel("Preview");
        previewTitle.setFont(new Font("Segoe UI", Font.BOLD, 12));
        previewTitle.setForeground(TEXT_PRIMARY);
        previewTitle.setBorder(new EmptyBorder(0, 0, PADDING_SMALL, 0));
        previewPanel.add(previewTitle, BorderLayout.NORTH);

        previewLabel = new JLabel();
        previewLabel.setHorizontalAlignment(JLabel.CENTER);
        previewLabel.setVerticalAlignment(JLabel.CENTER);
        previewPanel.add(previewLabel, BorderLayout.CENTER);

        // Update preview with current selection
        updatePreview(currentField);

        // Add selection listener
        fieldList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedIndex = fieldList.getSelectedIndex();
                if (selectedIndex >= 0) {
                    selectedField = fieldImages.get(selectedIndex);
                    updatePreview(selectedField);
                }
            }
        });

        // Split pane for list and preview
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, listPanel, previewPanel);
        splitPane.setDividerLocation(300);
        splitPane.setBackground(BACKGROUND_DARK);
        splitPane.setBorder(null);
        contentPanel.add(splitPane, BorderLayout.CENTER);

        this.add(contentPanel, BorderLayout.CENTER);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, PADDING_MEDIUM, 0));
        buttonPanel.setBackground(BACKGROUND_DARK);
        buttonPanel.setBorder(new EmptyBorder(PADDING_MEDIUM, PADDING_LARGE, PADDING_LARGE, PADDING_LARGE));

        JButton cancelButton = new JButton("Cancel");
        styleButton(cancelButton);
        cancelButton.addActionListener(e -> {
            selectedField = currentField; // Revert to original
            dispose();
        });

        JButton selectButton = new JButton("Select");
        stylePrimaryButton(selectButton);
        selectButton.addActionListener(e -> {
            dispose();
        });

        buttonPanel.add(cancelButton);
        buttonPanel.add(selectButton);

        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Get list of available field images from resources
     */
    private List<String> getAvailableFields() {
        List<String> fields = new ArrayList<>();
        String[] fieldFiles = {
            "field-2021-adi-dark.png",
            "field-2022-kai-dark.png",
            "field-2022-kai-light.png",
            "field-2022-official.png",
            "field-2023-centerstage-juice-dark-rotated.png",
            "field-2024-into-the-deep-juice-dark.jpg",
            "Juice-CENTERSTAGE-Dark.png",
            "Juice-DECODE-Black.png",
            "Juice-DECODE-Dark.png",
            "Juice-DECODE-Light.png",
            "Juice-DECODE-Paper.png"
        };

        for (String field : fieldFiles) {
            URL resource = Main.class.getResource("/" + field);
            if (resource != null) {
                fields.add(field);
            }
        }

        return fields;
    }

    /**
     * Get display name from filename
     */
    private String getDisplayName(String filename) {
        String name = filename.replace("field-", "")
                             .replace("Juice-", "")
                             .replace(".png", "")
                             .replace(".jpg", "")
                             .replace("-", " ");
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    /**
     * Update preview with selected field
     */
    private void updatePreview(String fieldName) {
        try {
            ImageIcon icon = new ImageIcon(Main.class.getResource("/" + fieldName));
            // Scale image to fit preview
            Image img = icon.getImage();
            int maxSize = 250;
            int width = icon.getIconWidth();
            int height = icon.getIconHeight();
            double scale = Math.min((double) maxSize / width, (double) maxSize / height);
            int scaledWidth = (int) (width * scale);
            int scaledHeight = (int) (height * scale);
            Image scaledImg = img.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH);
            previewLabel.setIcon(new ImageIcon(scaledImg));
        } catch (Exception e) {
            previewLabel.setText("Preview not available");
            previewLabel.setForeground(TEXT_SECONDARY);
        }
    }

    /**
     * Get the selected field
     */
    public String getSelectedField() {
        return selectedField;
    }
}

