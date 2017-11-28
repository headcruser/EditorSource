package controllers;
import controllers.colorSyntax.ColorSyntax;
import controllers.status.StatusConsole;
import gui.WindowEditor;

/**
 * Controller for the WindowEditor 
 *
 * @author Daniel Martinez <headcruser at gmail.com>
 */
public class windowEditorController
{

    final private WindowEditor editorView;
    private StatusConsole statusLine;
    private ColorSyntax styleColor;

    public windowEditorController(WindowEditor view) throws Exception
    {
        editorView = view;
        createControllers( view );
        editorView.windowCenterPosition();
    }

    public void showWindowEditor(final boolean isVisible) { editorView.setVisible(isVisible); }
    
    private void createControllers( WindowEditor view)
    {
        statusLine=new StatusConsole( view );
        styleColor = new ColorSyntax( view );
    }
}