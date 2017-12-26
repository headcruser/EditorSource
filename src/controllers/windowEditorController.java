package controllers;
import controllers.actions.AboutUS;
import controllers.actions.NewFile;
import controllers.actions.OpenFile;
import controllers.actions.Redo;
import controllers.actions.Save;
import controllers.actions.SaveAs;
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
   
   final private WindowEditor _view;
   final public ReaderFile reader;
   final public WritterInFile writter;
   
    public windowEditorController(WindowEditor view) throws Exception
    {
        _view = view;
        createControllers(  );
        reader=new ReaderFile();
        writter= new WritterInFile();
        configWindow();
        _view.isEditorEditable( false );
    }
    
    private void createControllers( )
    {
        lineNumberAspect=new TextLineNumber( _view.getAreaEditor() );
        statusLine=new StatusConsole( _view );
        careTaker=new CareTaker();
        originator=new Originator(); 
        assingEvents( );
    }
    
    private void configWindow() 
    {
        _view.windowCenterPosition();
        _view.initTextLineAspect( lineNumberAspect );
    }
    
    private void assingEvents() 
    {
        _view.addSyntaxListener(new PaintColorSyntax( this ) );
        
        _view.addAction( _view.buttonRedo,  new Redo( this ) );
        _view.addAction( _view.buttonSave , new Save( this ) );
        _view.addAction( _view.buttonUndo , new Undo( this ) );
        
        _view.addActionItem( _view.itemSaveAs,new SaveAs( this ) );        
        _view.addActionItem( _view.itemNew ,new NewFile(  this ) );
        _view.addActionItem( _view.itemClose, new close() ) ;
        _view.addActionItem( _view.itemOpen, new OpenFile( this ) );
        _view.addActionItem( _view.itemAbout, new AboutUS( this ) );
    }
    
    public WindowEditor getView() { return _view;}
    
    public void showWindowEditor(final boolean isVisible) { _view.setVisible(isVisible); }
    
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