package rrpathgen.gui;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

/**
 * Modern UI styling utilities for RRPathGen
 * This class centralizes all UI styling to make customization easier
 */
public class ModernUIStyles {

    // Modern Color Palette
    public static final Color BACKGROUND_DARK = new Color(30, 30, 35);
    public static final Color BACKGROUND_MEDIUM = new Color(40, 40, 45);
    public static final Color BACKGROUND_LIGHT = new Color(50, 50, 55);
    public static final Color ACCENT_PRIMARY = new Color(100, 150, 255);
    public static final Color ACCENT_SECONDARY = new Color(130, 100, 255);
    public static final Color TEXT_PRIMARY = new Color(240, 240, 245);
    public static final Color TEXT_SECONDARY = new Color(180, 180, 190);
    public static final Color BORDER_COLOR = new Color(70, 70, 75);
    public static final Color HOVER_COLOR = new Color(60, 60, 65);

    // Trajectory colors (keeping original)
    public static final Color CYAN = new Color(104, 167, 157);
    public static final Color DARK_PURPLE = new Color(124, 78, 158);
    public static final Color LIGHT_PURPLE = new Color(147, 88, 172);

    // Spacing constants
    public static final int PADDING_SMALL = 5;
    public static final int PADDING_MEDIUM = 10;
    public static final int PADDING_LARGE = 15;
    public static final int BORDER_RADIUS = 8;

    /**
     * Style a button with modern appearance
     */
    public static void styleButton(JButton button) {
        button.setBackground(BACKGROUND_MEDIUM);
        button.setForeground(TEXT_PRIMARY);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        button.setBorder(new RoundedBorder(BORDER_COLOR, BORDER_RADIUS, 8, 15));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setOpaque(false);
        button.setContentAreaFilled(false);

        // Add hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (button.isEnabled()) {
                    button.setBackground(HOVER_COLOR);
                }
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(BACKGROUND_MEDIUM);
            }
        });

        // Custom painting for rounded background
        button.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                AbstractButton b = (AbstractButton) c;
                g2.setColor(b.getBackground());
                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), BORDER_RADIUS, BORDER_RADIUS);

                g2.setColor(BORDER_COLOR);
                g2.setStroke(new BasicStroke(1));
                g2.drawRoundRect(0, 0, c.getWidth() - 1, c.getHeight() - 1, BORDER_RADIUS, BORDER_RADIUS);

                g2.dispose();
                super.paint(g, c);
            }
        });
    }

    /**
     * Style a primary/accent button
     */
    public static void stylePrimaryButton(JButton button) {
        button.setBackground(ACCENT_PRIMARY);
        button.setForeground(TEXT_PRIMARY);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setFont(new Font("Segoe UI", Font.BOLD, 12));
        button.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setOpaque(false);
        button.setContentAreaFilled(false);

        // Add hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (button.isEnabled()) {
                    button.setBackground(ACCENT_PRIMARY.brighter());
                }
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(ACCENT_PRIMARY);
            }
        });

        // Custom painting for rounded background
        button.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                AbstractButton b = (AbstractButton) c;
                g2.setColor(b.getBackground());
                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), BORDER_RADIUS, BORDER_RADIUS);

                g2.dispose();
                super.paint(g, c);
            }
        });
    }

    /**
     * Style a panel with modern appearance
     */
    public static void stylePanel(JPanel panel) {
        panel.setBackground(BACKGROUND_DARK);
        panel.setBorder(new RoundedBorder(BORDER_COLOR, BORDER_RADIUS, PADDING_MEDIUM, PADDING_MEDIUM));
    }

    /**
     * Style a panel with title
     */
    public static void stylePanelWithTitle(JPanel panel, String title) {
        panel.setBackground(BACKGROUND_DARK);
        panel.setBorder(new RoundedTitledBorder(title, BORDER_COLOR, BORDER_RADIUS, TEXT_PRIMARY, PADDING_MEDIUM));
    }

    /**
     * Style a text field
     */
    public static void styleTextField(JTextField field) {
        field.setBackground(BACKGROUND_LIGHT);
        field.setForeground(TEXT_PRIMARY);
        field.setCaretColor(TEXT_PRIMARY);
        field.setBorder(new RoundedBorder(BORDER_COLOR, 5, 5, 8));
        field.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        field.setOpaque(false);

        // Add custom painting for rounded background
        field.setUI(new javax.swing.plaf.basic.BasicTextFieldUI() {
            @Override
            public void paintSafely(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(field.getBackground());
                g2.fillRoundRect(0, 0, field.getWidth(), field.getHeight(), 5, 5);
                g2.dispose();
                super.paintSafely(g);
            }
        });
    }

    /**
     * Style a label
     */
    public static void styleLabel(JLabel label) {
        label.setForeground(TEXT_SECONDARY);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 11));
    }

    /**
     * Style a combo box
     */
    public static void styleComboBox(JComboBox<?> comboBox) {
        comboBox.setBackground(BACKGROUND_LIGHT);
        comboBox.setForeground(TEXT_PRIMARY);
        comboBox.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        comboBox.setBorder(new RoundedBorder(BORDER_COLOR, 5, 5, 8));
        comboBox.setOpaque(false);

        // Make the combo box render with rounded corners
        comboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (isSelected) {
                    c.setBackground(ACCENT_PRIMARY);
                    c.setForeground(TEXT_PRIMARY);
                } else {
                    c.setBackground(BACKGROUND_LIGHT);
                    c.setForeground(TEXT_PRIMARY);
                }
                return c;
            }
        });
    }

    /**
     * Style a checkbox
     */
    public static void styleCheckBox(JCheckBox checkBox) {
        checkBox.setBackground(BACKGROUND_DARK);
        checkBox.setForeground(TEXT_PRIMARY);
        checkBox.setFont(new Font("Segoe UI", Font.PLAIN, 11));
    }

    /**
     * Style a text area
     */
    public static void styleTextArea(JTextArea textArea) {
        textArea.setBackground(BACKGROUND_LIGHT);
        textArea.setForeground(TEXT_PRIMARY);
        textArea.setCaretColor(TEXT_PRIMARY);
        textArea.setFont(new Font("Consolas", Font.PLAIN, 11));
        textArea.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        textArea.setOpaque(true);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
    }

    /**
     * Style a scroll pane
     */
    public static void styleScrollPane(JScrollPane scrollPane) {
        scrollPane.setBorder(new RoundedBorder(BORDER_COLOR, 8, 2, 2));
        scrollPane.getViewport().setBackground(BACKGROUND_LIGHT);
    }

    /**
     * Custom rounded border for components
     */
    static class RoundedBorder extends AbstractBorder {
        private final Color color;
        private final int radius;
        private final int topPadding;
        private final int sidePadding;

        public RoundedBorder(Color color, int radius, int topPadding, int sidePadding) {
            this.color = color;
            this.radius = radius;
            this.topPadding = topPadding;
            this.sidePadding = sidePadding;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(color);
            g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
            g2.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(topPadding, sidePadding, topPadding, sidePadding);
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.left = insets.right = sidePadding;
            insets.top = insets.bottom = topPadding;
            return insets;
        }
    }

    /**
     * Custom rounded titled border for panels
     */
    static class RoundedTitledBorder extends AbstractBorder {
        private final String title;
        private final Color borderColor;
        private final int radius;
        private final Color textColor;
        private final int padding;

        public RoundedTitledBorder(String title, Color borderColor, int radius, Color textColor, int padding) {
            this.title = title;
            this.borderColor = borderColor;
            this.radius = radius;
            this.textColor = textColor;
            this.padding = padding;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Draw rounded border
            g2.setColor(borderColor);
            g2.drawRoundRect(x, y + 10, width - 1, height - 11, radius, radius);

            // Draw title background
            Font font = new Font("Segoe UI", Font.BOLD, 12);
            g2.setFont(font);
            FontMetrics fm = g2.getFontMetrics();
            int titleWidth = fm.stringWidth(title);
            int titleHeight = fm.getHeight();

            g2.setColor(c.getBackground());
            g2.fillRect(x + 10, y, titleWidth + 10, titleHeight);

            // Draw title text
            g2.setColor(textColor);
            g2.drawString(title, x + 15, y + fm.getAscent());

            g2.dispose();
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(20, padding, padding, padding);
        }

        @Override
        public Insets getBorderInsets(Component c, Insets insets) {
            insets.top = 20;
            insets.left = insets.right = insets.bottom = padding;
            return insets;
        }
    }
}

