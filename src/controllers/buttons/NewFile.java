package controllers.buttons;

import controllers.windowEditorController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Action for new Action
 *  @author Daniel Martinez Sierra <headcruser at gmail.com>
 */
public class NewFile implements ActionListener
{

    private final windowEditorController wcontroller;

    public NewFile(windowEditorController viewEditor) {
        this.wcontroller = viewEditor;
    }    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        wcontroller.getView().isEditorEditable( true );
    }
}