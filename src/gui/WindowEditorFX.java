package gui;

import java.io.File;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * View Window Source Edit
 * @author Daniel Martinez
 */
public class WindowEditorFX extends Application 
{

    private Menu file;
    private MenuItem itemNew;
    private MenuItem itemSave;
    private MenuItem itemClose;

    private Menu edit;
    private MenuItem itemCut;
    private MenuItem itemCopy;
    private MenuItem itemPaste;

    private Menu help;
    private MenuItem itemAbout;

    private Menu format;
    private CheckMenuItem check;
    private CheckMenuItem check1;
    private CheckMenuItem check2;

    private Menu font;
    private RadioMenuItem radio1;
    private RadioMenuItem radio2;

    CustomMenuItem custom;

    private Menu menuSearch;
    private MenuItem buscar;
    private MenuItem remplace;

    private TabPane tabPane;
    private Tab tab;

    public static void main(String[] args) 
    {
        launch(args);
    }
    
    public WindowEditorFX() {   super();    }

    @Override
    public void start(Stage winStage) throws Exception 
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
        BorderPane root = new BorderPane();
        //Menu Bar 
        MenuBar menuBar = new MenuBar();

        createFileMenu();
        createFileEdit();
        createMenuFont();
        createCustomMenu();
        createMenuSearch();
        createMenuFormat();
        createMenuHelp();
        createMenuHelp();
        createTapPane();

        custom = new CustomMenuItem(new TextField(" Buscar"));
        custom.setHideOnClick(false);
        
        font.getItems().addAll(radio1, radio2, custom);
        tabPane.getTabs().add(tab);
        tab.setContent(root.getCenter());
        tab.setText("ArchivoEjemplo.txt");
        
         GridPane gridpane = new GridPane();
        gridpane.setPadding( new Insets(5) );
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        
        final TextArea cssEditorFld = new TextArea();
        
        cssEditorFld.setPrefRowCount(10);
        cssEditorFld.setPrefColumnCount(500);
        cssEditorFld.setWrapText(true);
        cssEditorFld.setPrefWidth(550);
        GridPane.setHalignment(cssEditorFld, HPos.CENTER);
        gridpane.add(cssEditorFld, 0, 1);
        String cssDefault = "line1;\nline2;\n";
        
        cssEditorFld.setText(cssDefault);
        tab.setContent( gridpane );

        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        selectionModel.select(tab);

        file.getItems().addAll( itemNew, itemSave, itemClose );
        edit.getItems().addAll( itemCut, itemCopy, itemPaste);
        format.getItems().addAll(check, check1, check2, new SeparatorMenuItem(), font);
        help.getItems().add(itemAbout);
        menuSearch.getItems().addAll(buscar, remplace);

        menuBar.getMenus().addAll(file, edit, format, help);

        root.setTop(menuBar);
        root.setCenter(tabPane);

        Scene scene = new Scene(root, 300, 250);
        
        
        itemClose.setOnAction( new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {
                Platform.exit();
            }
        });
        
        itemSave .setOnAction( new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent arg0) 
            {
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extFilter);
                File file = fileChooser.showSaveDialog(winStage);
                System.out.println(file);
                
            }
        });
       
        winStage.setTitle(" Editor Source");
        winStage.setScene(scene);
        winStage.setOpacity( 0.9  );
        winStage.show();

    }

    private void createFileMenu() 
    {
        this.file = new Menu("File");

        itemNew = new MenuItem("New");
        itemSave = new MenuItem("Save");
        itemClose = new MenuItem("Close");
    }

    private void createFileEdit() 
    {
        edit = new Menu("Edit");
        itemCut = new MenuItem("Cut");
        itemCopy = new MenuItem("Copy");
        itemPaste = new MenuItem("Paste");
    }

    private void createMenuHelp() 
    {
        help = new Menu("Help");
        itemAbout = new MenuItem("About US");
    }

    private void createMenuFormat() 
    {
        format = new Menu("Format");

        check = new CheckMenuItem("Bold");
        check1 = new CheckMenuItem("Italic");
        check2 = new CheckMenuItem("UnderLine");
        check.setSelected(true);
    }

    private void createMenuFont() 
    {
        font = new Menu("Font");
        radio1 = new RadioMenuItem("Berlin Sans");
        radio2 = new RadioMenuItem("Comic Sans");
    }

    private void createCustomMenu() 
    {
        ToggleGroup tg = new ToggleGroup();
        radio1.setToggleGroup(tg);
        radio2.setToggleGroup(tg);
        radio1.setSelected(true);
    }

    private void createMenuSearch() 
    {
        menuSearch = new Menu("Search");
        buscar = new MenuItem("Find");
        remplace = new MenuItem("Remplace");
    }

    private void createTapPane() 
    {
        tabPane = new TabPane();
        tab = new Tab();
    }
}
