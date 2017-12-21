package controllers.actions;

import controllers.files.FileManagerDialog;
import controllers.utils.PrinterConsoleUtils;
import controllers.windowEditorController;
import java.awt.event.ActionEvent;

public class OpenFile extends Action
{
    private final  FileManagerDialog _openFile;
    private final windowEditorController _wcontroller;
    
    public OpenFile( final windowEditorController viewEditor ) 
    {
        super(); 
        _openFile=new FileManagerDialog( );
        _wcontroller=viewEditor;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        openFile();
        
    }

    private void openFile() 
    {
        try 
        {
            _wcontroller.document=_openFile.openDialog();
            _wcontroller.getView().getAreaEditor()
                    .setText (  _wcontroller.reader.readFile( _wcontroller.document ) );
            
        } catch (Exception ex) {
            PrinterConsoleUtils.print( ex.getMessage() );
        }
    }
}