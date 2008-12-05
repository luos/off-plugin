/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.sickill.taz.netbeans;

import java.awt.BorderLayout;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JDialog;
import javax.swing.WindowConstants;
import net.sickill.taz.ActionsProvider;
import net.sickill.taz.Settings;
import net.sickill.taz.Taz;
import org.openide.windows.WindowManager;

/**
 *
 * @author kill
 */
public class NetbeansDialog extends JDialog implements ComponentListener {
    static Taz taz;
    static Settings settings;
    ActionsProvider actions;

    public NetbeansDialog() {
        super(WindowManager.getDefault().getMainWindow(), "Taz");
        this.addComponentListener(this);
        addNotify();
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        if (taz == null) {
            settings = new NetbeansSettings();
            taz = new Taz(settings, new NetbeansProjectFilesProvider());
        }
        actions = new NetbeansActionsProvider(this);
        taz.setActionsProvider(actions);
        setSize(settings.getDialogWidth(), settings.getDialogHeight());
        setLocationRelativeTo(null);
        getContentPane().add(taz, BorderLayout.CENTER);
    }

    public void componentResized(ComponentEvent e) {
        settings.setDialogWidth(this.getWidth());
        settings.setDialogHeight(this.getHeight());
    }

    public void componentMoved(ComponentEvent e) {
    }

    public void componentShown(ComponentEvent e) {
    }

    public void componentHidden(ComponentEvent e) {
    }
}