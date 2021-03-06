package app;

import controllers.configFiles.Propieties;
import controllers.utils.PrinterConsoleUtils;
import controllers.windowEditorController;
import gui.WindowEditor;

/**
 * Excecute Main App 
 * @author Daniel Martinez Sierra <headcruser at gmail.com>
 */
final class AppEditor 
{
    public static void main(String args[]) throws Exception
    {  
        enableLookAndFeel(); 
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {                
                try 
                {
                    Propieties.loader();                   
                    windowEditorController controller = new windowEditorController( new WindowEditor() );
                    controller.showWindowEditor(true);
                } catch (Exception ex) 
                {
                    PrinterConsoleUtils.print( ex.getMessage() );
                }
            }
        });
    }
    
    static void enableLookAndFeel()
    {
        try 
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) 
            {
                if ("Nimbus".equals(info.getName())) 
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
                 PrinterConsoleUtils.print( ex.getMessage() );
        }
    } 
}