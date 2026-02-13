# RRPathGen UI Styling Guide

This guide explains how to customize the UI appearance of RRPathGen.

## Quick Start: Where to Edit Styles

All UI styling is centralized in **one main file** for easy customization:

### Main Styling File
**Location:** `src/main/java/rrpathgen/gui/ModernUIStyles.java`

This file contains all the colors, spacing, and styling methods used throughout the application.

---

## How to Customize Colors

### 1. Background Colors
Edit these constants in `ModernUIStyles.java`:

```java
public static final Color BACKGROUND_DARK = new Color(30, 30, 35);      // Main window background
public static final Color BACKGROUND_MEDIUM = new Color(40, 40, 45);    // Panel backgrounds
public static final Color BACKGROUND_LIGHT = new Color(50, 50, 55);     // Text field backgrounds
```

### 2. Accent Colors
```java
public static final Color ACCENT_PRIMARY = new Color(100, 150, 255);    // Primary buttons (Field selector)
public static final Color ACCENT_SECONDARY = new Color(130, 100, 255);  // Alternative accent
```

### 3. Text Colors
```java
public static final Color TEXT_PRIMARY = new Color(240, 240, 245);      // Main text color
public static final Color TEXT_SECONDARY = new Color(180, 180, 190);    // Labels and secondary text
```

### 4. Border and Hover Colors
```java
public static final Color BORDER_COLOR = new Color(70, 70, 75);         // Panel borders
public static final Color HOVER_COLOR = new Color(60, 60, 65);          // Button hover state
```

### 5. Trajectory/Path Colors (preserved from original)
```java
public static final Color CYAN = new Color(104, 167, 157);              // Path splines
public static final Color DARK_PURPLE = new Color(124, 78, 158);        // Arrows
public static final Color LIGHT_PURPLE = new Color(147, 88, 172);       // Robot path
```

---

## How to Customize Spacing

Edit these constants in `ModernUIStyles.java`:

```java
public static final int PADDING_SMALL = 5;      // Small gaps between components
public static final int PADDING_MEDIUM = 10;    // Medium gaps
public static final int PADDING_LARGE = 15;     // Large gaps (panel edges)
public static final int BORDER_RADIUS = 8;      // Rounded corner radius
```

---

## How to Customize Specific Components

### Buttons
Edit the `styleButton()` or `stylePrimaryButton()` methods in `ModernUIStyles.java`:

```java
public static void styleButton(JButton button) {
    button.setBackground(BACKGROUND_MEDIUM);
    button.setForeground(TEXT_PRIMARY);
    button.setFont(new Font("Segoe UI", Font.PLAIN, 12));  // Change font here
    button.setBorder(BorderFactory.createCompoundBorder(
        new LineBorder(BORDER_COLOR, 1, true),              // Border width and style
        BorderFactory.createEmptyBorder(8, 15, 8, 15)       // Padding: top, left, bottom, right
    ));
    // ... hover effects
}
```

### Text Fields
Edit the `styleTextField()` method:

```java
public static void styleTextField(JTextField field) {
    field.setBackground(BACKGROUND_LIGHT);
    field.setForeground(TEXT_PRIMARY);
    field.setFont(new Font("Segoe UI", Font.PLAIN, 11));   // Change font here
    field.setBorder(BorderFactory.createCompoundBorder(
        new LineBorder(BORDER_COLOR, 1),
        BorderFactory.createEmptyBorder(5, 8, 5, 8)         // Padding
    ));
}
```

### Panels with Titles
Edit the `stylePanelWithTitle()` method:

```java
public static void stylePanelWithTitle(JPanel panel, String title) {
    TitledBorder titledBorder = BorderFactory.createTitledBorder(
        new LineBorder(BORDER_COLOR, 1),
        title,
        TitledBorder.LEFT,
        TitledBorder.TOP,
        new Font("Segoe UI", Font.BOLD, 12),                // Title font
        TEXT_PRIMARY
    );
    // ...
}
```

---

## Component Locations

If you need to modify specific UI components directly:

| Component | File Location |
|-----------|---------------|
| **Button Panel** (Export, Import, Flip, etc.) | `src/main/java/rrpathgen/gui/ButtonPanel.java` |
| **Export Panel** (Code export area) | `src/main/java/rrpathgen/gui/ExportPanel.java` |
| **Info Panel** (Right sidebar container) | `src/main/java/rrpathgen/gui/infoPanel/InfoPanel.java` |
| **Edit Panel** (Node editing controls) | `src/main/java/rrpathgen/gui/infoPanel/EditPanel.java` |
| **Settings Panel** (Robot settings) | `src/main/java/rrpathgen/gui/infoPanel/SettingsPanel.java` |
| **Marker Panel** (Marker editing) | `src/main/java/rrpathgen/gui/infoPanel/MarkerPanel.java` |
| **Field Selector Dialog** | `src/main/java/rrpathgen/gui/FieldSelectorDialog.java` |
| **Main Window** | `src/main/java/rrpathgen/Main.java` |

---

## Example: Creating a Custom Color Theme

### 1. Dark Blue Theme
In `ModernUIStyles.java`, change:

```java
public static final Color BACKGROUND_DARK = new Color(15, 23, 42);      // Slate
public static final Color BACKGROUND_MEDIUM = new Color(30, 41, 59);    
public static final Color BACKGROUND_LIGHT = new Color(51, 65, 85);     
public static final Color ACCENT_PRIMARY = new Color(59, 130, 246);     // Blue
public static final Color TEXT_PRIMARY = new Color(241, 245, 249);      
```

### 2. Warm Dark Theme
```java
public static final Color BACKGROUND_DARK = new Color(28, 25, 23);      // Stone
public static final Color BACKGROUND_MEDIUM = new Color(41, 37, 36);    
public static final Color BACKGROUND_LIGHT = new Color(57, 51, 48);     
public static final Color ACCENT_PRIMARY = new Color(251, 146, 60);     // Orange
public static final Color TEXT_PRIMARY = new Color(250, 250, 249);      
```

### 3. High Contrast Theme
```java
public static final Color BACKGROUND_DARK = new Color(0, 0, 0);         // Black
public static final Color BACKGROUND_MEDIUM = new Color(20, 20, 20);    
public static final Color BACKGROUND_LIGHT = new Color(40, 40, 40);     
public static final Color ACCENT_PRIMARY = new Color(0, 255, 0);        // Bright green
public static final Color TEXT_PRIMARY = new Color(255, 255, 255);      // White
```

---

## Font Customization

To change fonts throughout the app, search for `new Font(` in `ModernUIStyles.java` and modify:

```java
// Current fonts:
new Font("Segoe UI", Font.PLAIN, 12)   // Regular buttons
new Font("Segoe UI", Font.BOLD, 12)    // Primary buttons & panel titles
new Font("Segoe UI", Font.PLAIN, 11)   // Text fields & labels
new Font("Consolas", Font.PLAIN, 11)   // Code export area

// Examples of alternative fonts:
new Font("Arial", Font.PLAIN, 12)
new Font("Roboto", Font.PLAIN, 12)
new Font("JetBrains Mono", Font.PLAIN, 11)  // For code
```

---

## Testing Your Changes

1. Save your changes to `ModernUIStyles.java`
2. Build the project: `./gradlew build`
3. Run the application: `./gradlew run`
4. The new styling will be applied immediately

---

## Tips

- **Start with colors**: Change `BACKGROUND_*` and `ACCENT_PRIMARY` first to see major changes
- **Use color picker**: Most IDEs have built-in color pickers for RGB values
- **Test contrast**: Ensure text is readable on backgrounds
- **Consistency**: Keep accent colors consistent across the app
- **Backup**: Save your custom theme values in a comment for easy restoration

---

## Field Selector Feature

The new **⚙ Field** button in the button panel allows users to:
- View all available field images from the resources folder
- Preview field images before selecting
- Switch between different FTC game fields
- The selected field is saved in the config and persists between sessions

Field configuration is stored in: `FIELD_IMAGE` property in config file

