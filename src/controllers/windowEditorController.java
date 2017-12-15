package controllers;
import controllers.actions.NewFile;
import controllers.actions.Redo;
import controllers.actions.Save;
import controllers.actions.Undo;
import controllers.actions.close;
import controllers.syntaxEditor.PaintColorSyntax;
import controllers.memento.CareTaker;
import controllers.memento.Originator;
import controllers.status.StatusConsole;
import gui.WindowEditor;

/**
 * Controller for the WindowEditor 
 *
 * @author Daniel Martinez <headcruser at gmail.com>
 */
public final class windowEditorController
{

    final private WindowEditor editorView;
    private StatusConsole statusLine;
    private CareTaker careTaker;
    private Originator originator;
    private TextLineNumber lineNumberAspect;
    private int saveFiles = 0, currentArticle = 0;

    public windowEditorController(WindowEditor view) throws Exception
    {
        editorView = view;
        createControllers(  );
        configWindow();
        editorView.isEditorEditable( false );
    }

    private void configWindow() {
        editorView.windowCenterPosition();
        editorView.initTextLineAspect( lineNumberAspect );
    }
    
    private void createControllers( )
    {
        lineNumberAspect=new TextLineNumber( editorView.getAreaEditor() );
        statusLine=new StatusConsole( editorView );
        careTaker=new CareTaker();
        originator=new Originator();    
        assingEvents( );
    }

    private void assingEvents() 
    {
        editorView.addSyntaxListener(new PaintColorSyntax( this ) );
        editorView.addActionRedo(new Redo( this ) );
        editorView.addActionSave(new Save( this ) );
        editorView.addActionUndo(new Undo( this ) );
        editorView.addActionNewFile( new NewFile(  this ) );
        editorView.addActionClose( new close());
    }
    
    public WindowEditor getView() { return editorView;}
    
    public void showWindowEditor(final boolean isVisible) { editorView.setVisible(isVisible); }
    
    public void  increaseSaveFiles() { saveFiles ++; }

    public void increaseArticle() { currentArticle++ ;}
    
    public void  decreaseSaveFiles() { saveFiles --; }

    public void decreaseArticle() { currentArticle-- ;}
    
    public int getSaveFiles() {   return saveFiles;}

    public int getCurrentArticle() {    return currentArticle;  }

    public Originator getOriginator() { return originator; }

    public CareTaker getCareTaker() {  return careTaker; }
}