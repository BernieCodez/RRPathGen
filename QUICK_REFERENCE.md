# Quick Reference: UI Customization

## 🎨 Where to Edit Styles

**Single file for ALL styling:**
```
src/main/java/rrpathgen/gui/ModernUIStyles.java
```

## 🖌️ Change Colors (Line 12-20)

```java
// Dark theme (current)
BACKGROUND_DARK = new Color(30, 30, 35);
BACKGROUND_MEDIUM = new Color(40, 40, 45);
BACKGROUND_LIGHT = new Color(50, 50, 55);
ACCENT_PRIMARY = new Color(100, 150, 255);
TEXT_PRIMARY = new Color(240, 240, 245);

// Light theme example
BACKGROUND_DARK = new Color(248, 248, 250);
BACKGROUND_MEDIUM = new Color(255, 255, 255);
BACKGROUND_LIGHT = new Color(240, 240, 242);
ACCENT_PRIMARY = new Color(0, 100, 200);
TEXT_PRIMARY = new Color(20, 20, 30);
```

## 📏 Change Spacing (Line 29-32)

```java
PADDING_SMALL = 5;   // Tight spacing
PADDING_MEDIUM = 10; // Normal spacing
PADDING_LARGE = 15;  // Loose spacing
```

## 🔤 Change Fonts

Search for `new Font(` and modify:
```java
new Font("Segoe UI", Font.PLAIN, 12)   // Buttons
new Font("Segoe UI", Font.BOLD, 12)    // Titles
new Font("Consolas", Font.PLAIN, 11)   // Code area
```

## ⚙️ New Features

**Field Selector Button:**
- Click "⚙ Field" in bottom toolbar
- Preview and switch between FTC fields
- Selection saved automatically

## 📦 Build & Run

```bash
# Build
./gradlew build

# Run
./gradlew run
```

## 📖 Full Documentation

See `STYLING_GUIDE.md` for detailed customization guide
See `UI_UPDATE_SUMMARY.md` for complete list of changes

