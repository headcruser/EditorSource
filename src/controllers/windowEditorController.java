package controllers;
import controllers.actions.NewFile;
import controllers.actions.OpenFile;
import controllers.actions.Redo;
import controllers.actions.Save;
import controllers.actions.Undo;
import controllers.actions.close;
import controllers.files.ReaderFile;
import controllers.files.WritterInFile;
import controllers.syntaxEditor.PaintColorSyntax;
import controllers.memento.CareTaker;
import controllers.memento.Originator;
import controllers.status.StatusConsole;
import gui.WindowEditor;
import java.io.File;

/**
 * Controller for the WindowEditor 
 *
 * @author Daniel Martinez <headcruser at gmail.com>
 */
public final class windowEditorController
{
    private CareTaker careTaker;
    private Originator originator;
    private TextLineNumber lineNumberAspect;
    private int saveFiles = 0, currentArticle = 0;
    public File document;
    private StatusConsole statusLine;
   
   final private WindowEditor editorView;
   final public ReaderFile reader;
   final public WritterInFile writter;
   
    public windowEditorController(WindowEditor view) throws Exception
    {
        editorView = view;
        createControllers(  );
        reader=new ReaderFile();
        writter= new WritterInFile();
        configWindow();
        editorView.isEditorEditable( false );
    }
    
    private void createControllers( )
    {
        lineNumberAspect=new TextLineNumber( editorView.getAreaEditor() );
        statusLine=new StatusConsole( editorView );
        careTaker=new CareTaker();
        originator=new Originator(); 
        assingEvents( );
    }
    
    private void configWindow() 
    {
        editorView.windowCenterPosition();
        editorView.initTextLineAspect( lineNumberAspect );
    }
    
    private void assingEvents() 
    {
        editorView.addSyntaxListener(new PaintColorSyntax( this ) );
        editorView.addActionRedo( new Redo( this ) );
        editorView.addActionSave( new Save( this ) );
        editorView.addActionSaveAs( new Save( this ) );
        editorView.addActionUndo( new Undo( this ) );
        editorView.addActionNewFile( new NewFile(  this ) );
        editorView.addActionClose( new close());
        editorView.addActionOpen(new OpenFile( this ) );
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
    
    public void openDocument(File DocumFile)
    {
        if ( DocumFile ==null)
            return; 
        
          document=DocumFile;
    }
}