package controllers.files;

import java.awt.Component;
import java.awt.HeadlessException;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FileManagerDialog
        extends JFileChooser
        implements IActionDialog, IPathFiles
{
    public FileManagerDialog()
    {
        super( WORKSPACE );
    }

    @Override
    public File openDialog() throws Exception
    {
        setDialogType(OPEN_DIALOG);
        setFileFilter(EXT);

        if (!isChooserValidDialogOpen())
            throw new Exception(" Calceled");

        if (!getSelectedFile().exists())
            throw new Exception("It File not Exist ");

        return getSelectedFile();
    }

    @Override
    public File saveDialog() throws Exception
    {
        setDialogType(SAVE_DIALOG);
        setFileFilter(EXT);

        if ( !isChooserValidDialogSave() )
            throw new Exception( "Canceled" );
        
        return this.getSelectedFile();
    }

    @Override
    protected JDialog createDialog(Component parent) throws HeadlessException
    {
        JDialog dialog = super.createDialog(parent);
        dialog.setIconImage(new ImageIcon(getClass().getResource(ICON_LOGO)).getImage());
        return dialog;
    }

    @Override
    public void updateUI()
    {
         LookAndFeel old = UIManager.getLookAndFeel();
        try {
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) 
        {
           old = null;
        } 
        super.updateUI();
        
         if(old != null){     
            try {  UIManager.setLookAndFeel(old);  } catch (UnsupportedLookAndFeelException ignored) {} 
         }
    }
    
    private boolean isChooserValidDialogSave(){   return showSaveDialog( null ) == APPROVE_OPTION;    }

    private boolean isChooserValidDialogOpen(){   return showOpenDialog( null ) == APPROVE_OPTION;    }
}