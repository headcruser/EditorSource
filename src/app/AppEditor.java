package app;

import controllers.windowEditorController;
import gui.WindowEditor;

/**
 * Excecute Main App 
 * @author Daniel Martinez Sierra <headcruser at gmail.com>
 */
public class AppEditor 
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
                    WindowEditor viewEditor = new WindowEditor();
                    windowEditorController controller = new windowEditorController(viewEditor);
                    controller.showWindowEditor(true);
                } catch (Exception ex) {
                    System.out.println( ex.getMessage()  );
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
            java.util.logging.Logger.getLogger(WindowEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    } 
}
