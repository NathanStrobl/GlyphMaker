module glyph_maker_for_adafruit_gfx {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens glyph_maker_for_adafruit_gfx.model to javafx.fxml;
    opens glyph_maker_for_adafruit_gfx.view to javafx.fxml;
    exports glyph_maker_for_adafruit_gfx.model;
    exports glyph_maker_for_adafruit_gfx.view;
}
