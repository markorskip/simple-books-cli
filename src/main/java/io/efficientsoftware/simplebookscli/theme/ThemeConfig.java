package io.efficientsoftware.simplebookscli.theme;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.style.FigureSettings;
import org.springframework.shell.style.StyleSettings;
import org.springframework.shell.style.Theme;
import org.springframework.shell.style.ThemeSettings;
import org.springframework.stereotype.Component;

@Component
//TOO so far this doesn't work
public class ThemeConfig {

    static class MyStyleSettings extends StyleSettings {

        @Override
        public String title() {
            return "fg:blue";
        }

        @Override
        public String listKey() {
            return "fg:blue";
        }

        @Override
        public String highlight() {
            return super.highlight();
        }


    }

    static class MyFigureSettings extends FigureSettings {

        @Override
        public String error() {
            return super.error();
        }
    }

    static class MyThemeSettings extends ThemeSettings {

        @Override
        public StyleSettings styles() {
            return new MyStyleSettings();
        }

        @Override
        public FigureSettings figures() {
            return new MyFigureSettings();
        }
    }


    @Configuration
    static class CustomThemeConfig {

        @Bean
        Theme myTheme() {
            return new Theme() {
                @Override
                public String getName() {
                    return "mytheme";
                }

                @Override
                public ThemeSettings getSettings() {
                    return new MyThemeSettings();
                }
            };
        }
    }
}
