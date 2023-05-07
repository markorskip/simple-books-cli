package io.efficientsoftware.simplebookscli;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.Button;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.Panel;
import com.googlecode.lanterna.gui2.dialogs.FileDialogBuilder;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.gui2.dialogs.MessageDialogButton;
import com.googlecode.lanterna.gui2.menu.Menu;
import com.googlecode.lanterna.gui2.menu.MenuBar;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.File;
import java.io.IOException;

public class HelloWorld {



    public static void main(String[] args) throws IOException {



        // Setup terminal and screen layers
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        screen.startScreen();

        TerminalSize size = new TerminalSize(14, 10);
        RadioBoxList<String> radioBoxList = new RadioBoxList<String>(size);
        radioBoxList.addItem("item 1");
        radioBoxList.addItem("item 2");
        radioBoxList.addItem("item 3");
        String checkedItems = radioBoxList.getCheckedItem();

        // Create window to hold the panel
        BasicWindow window = new BasicWindow();
        window.setComponent(radioBoxList);

        // Create gui and start gui
        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
        gui.addWindowAndWait(window);


        // Create panel to hold components
        Panel panel = new Panel();
        panel.setLayoutManager(new GridLayout(2));

        panel.addComponent(new Label("Log Time"));
        panel.addComponent(new TextBox());

        panel.addComponent(new Label("Log Money"));
        panel.addComponent(new TextBox());

        panel.addComponent(new Label("Log Mileage"));
        panel.addComponent(new TextBox());

        panel.addComponent(new EmptySpace(new TerminalSize(0,0))); // Empty space underneath labels
        panel.addComponent(new Button("Submit"));

        // Create window to hold the panel
        window = new BasicWindow();
        window.setComponent(panel);

        // Create gui and start gui
        gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));

        gui.addWindowAndWait(window);

    }
}

