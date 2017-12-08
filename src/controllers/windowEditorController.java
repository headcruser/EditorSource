package controllers;
import controllers.buttons.NewFile;
import controllers.buttons.RedoButtonListener;
import controllers.buttons.SaveButtonListener;
import controllers.buttons.UndoButtonListener;
import controllers.colorSyntax.ColorSyntax;
import controllers.memento.CareTaker;
import controllers.memento.Originator;
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
        statusLine=new StatusConsole( editorView );
        styleColor = new ColorSyntax( editorView );
        careTaker=new CareTaker();
        originator=new Originator();
        
        editorView.addEventListenerRedo( new RedoButtonListener( this ) );
        editorView.addEventListenerSave( new SaveButtonListener( this ) );
        editorView.addEventListenerUndo( new UndoButtonListener( this ) );
        editorView.addEventListenerNewFile( new NewFile(  this ) );
        
        lineNumberAspect=new TextLineNumber( editorView.getAreaEditor() );
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