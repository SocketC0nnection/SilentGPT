package net.socket.silentgpt.managers;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class ClipboardManager {

    private final Clipboard clipboard;

    public ClipboardManager() {
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    public void setClipboardText(String text) {
        StringSelection selection = new StringSelection(text);

        clipboard.setContents(selection, selection);
    }

    public String getClipboardText() {
        String text = "";

        try {
            text = (String) clipboard.getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException | IOException ignored) {}

        return text;
    }

    public Clipboard getClipboard() {
        return clipboard;
    }
}
