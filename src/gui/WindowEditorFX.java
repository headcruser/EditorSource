package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * 
 * @author Daniel Martinez
 */
public class WindowEditorFX extends Application
{

    public WindowEditorFX() {
        super();
        
    }
    
    public static void main(String[] args) 
    {
            launch(args);
    }
    
    @Override
    public void start(Stage winStage ) throws Exception 
    {
//        winStage.setTitle( "  Source Editor" );
//        StackPane root = new StackPane();
//        Text text = new Text(" My Editor Source");
//        root.getChildren().add( text );
//        
//        Scene scene = new Scene( root, 400, 400 );
//        winStage.setScene( scene );
//        winStage.setResizable( false );
//        //winStage.setFullScreen(true);
//        winStage.setOpacity( 0.5 );
//        winStage.initStyle(StageStyle.UTILITY );
//        winStage.show();
        
        //Root Node 
        BorderPane root=new BorderPane();
        
        //Menu Bar 
        MenuBar menuBar=new MenuBar();
        //Menu 1 
        Menu file =new Menu("File");
        
        MenuItem itemNew = new MenuItem("New");
        MenuItem itemSave = new MenuItem("Save");
        MenuItem itemClose = new MenuItem("Close");
        
        //Menu 2 
        Menu edit =new Menu("Edit");
        
        MenuItem itemCut = new MenuItem("Cut");
        MenuItem itemCopy = new MenuItem("Copy");
        MenuItem itemPaste = new MenuItem("Paste");
        
        //Menu 3
        Menu help =new Menu("Help");
       
        MenuItem itemAbout = new MenuItem("About US");
        
        //Menu 4         
        Menu format =new Menu("Format");
        
        CheckMenuItem check= new CheckMenuItem("Bold");
        CheckMenuItem check1= new CheckMenuItem("Italic");
        CheckMenuItem check2= new CheckMenuItem("UnderLine");
        
        check.setSelected(true);
        
        //Submenu
        Menu font =new Menu("Font");
        
        RadioMenuItem radio1 = new RadioMenuItem("Berlin Sans");
        RadioMenuItem radio2 = new RadioMenuItem("Comic Sans");
        
        ToggleGroup tg = new ToggleGroup();
        radio1.setToggleGroup(tg);
        radio2.setToggleGroup(tg);
        radio1.setSelected(true);
        
        //Custom Menu Item
        CustomMenuItem custom = new CustomMenuItem(new TextField(" Buscar"));
        custom.setHideOnClick( false );
         
        
        font.getItems().addAll(radio1,radio2,custom); 
        
        //SubMenu Search
        Menu menuSearch = new Menu("Search");
        
        MenuItem buscar = new MenuItem("Find");
        MenuItem remplace = new MenuItem("Remplace");
        
        
        
        
        file.getItems().addAll( itemNew, itemSave, itemClose);
        edit.getItems().addAll( itemCut, itemCopy, itemPaste );
        format.getItems().addAll(check, check1, check2, new SeparatorMenuItem(),font);
        help.getItems().add( itemAbout );
        menuSearch.getItems().addAll(buscar, remplace);
        
        menuBar.getMenus().addAll( file,edit,format,help);
        
        root.setTop(menuBar);
        
        Scene scene = new Scene( root, 300,250);
        
        winStage.setTitle( " Editor Source");
        winStage.setScene( scene );
        winStage.show();
        
        
    }
}
