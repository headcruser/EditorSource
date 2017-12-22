package controllers.actions;

import controllers.files.FileManagerDialog;
import controllers.windowEditorController;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.BevelBorder;

/**
 * Action for new Action
 *  @author Daniel Martinez Sierra <headcruser at gmail.com>
 */
public class NewFile extends Action
{
    private final windowEditorController _wcontroller;
    private final  FileManagerDialog _dialogFile;

    public NewFile( final windowEditorController viewEditor) {
        _wcontroller = viewEditor;
        _dialogFile=new FileManagerDialog();
    }    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        actions( );
    }

    private void actions() 
    {
        try
        {
            _wcontroller.document=_dialogFile.saveDialog();
            _wcontroller.getView().getAreaEditor().requestFocus();
            _wcontroller.getView().isEditorEditable( true );
            _wcontroller.getView().getAreaEditor().setBorder(new BevelBorder(BevelBorder.LOWERED ));
        } catch (Exception ex){ }
    }
}