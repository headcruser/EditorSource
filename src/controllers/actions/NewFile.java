package controllers.actions;

import controllers.windowEditorController;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

/**
 * Action for new Action
 *  @author Daniel Martinez Sierra <headcruser at gmail.com>
 */
public class NewFile extends Action
{
    private final windowEditorController wcontroller;

    public NewFile( final windowEditorController viewEditor) {
        this.wcontroller = viewEditor;
    }    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        actions( );
    }

    private void actions() 
    {
        wcontroller.getView().getAreaEditor().requestFocus();
        wcontroller.getView().isEditorEditable( true );
        wcontroller.getView().getAreaEditor().setBorder(new BevelBorder(BevelBorder.LOWERED ));
        
    }
}