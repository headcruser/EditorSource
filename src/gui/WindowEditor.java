
package gui;

import controllers.files.IPathFiles;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.event.CaretListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.StyledDocument;

public final class WindowEditor extends javax.swing.JFrame implements IPathFiles
{
    private StyledDocument styleTextForDocument;
    /**
     * Creates new form WindowEditor
     */
    public WindowEditor() 
    {
           initComponents();
           assingIconApp( ICON_LOGO );
           assignSyleDocumentEditor();           
    }

    public void windowCenterPosition(){ this.setLocationRelativeTo( null ); }
      
    public void addCarentEventListener(CaretListener event) { this.editor.addCaretListener( event ); }
    
    public void addEventListenerSave( ActionListener saveListener ){ this.buttonSave.addActionListener( saveListener );}
    
    public void addEventListenerUndo( ActionListener undoListener ){ this.buttonUndo.addActionListener( undoListener );}
    
    public void addEventListenerRedo( ActionListener redoListener ){ this.buttonRedo.addActionListener( redoListener );}
    
    public void addEventListenerNewFile (ActionListener  newFileListener){ this.itemNew.addActionListener( newFileListener );}
     
    public void enableUndoButton(final boolean enable ){ buttonUndo.setEnabled(enable); }
    
    public void enableRedoButton(final boolean enable ){ buttonRedo.setEnabled(enable);}
    
    public void enableSaveButton(final boolean enable ) { buttonSave.setEnabled(enable);}
    
    public void isEditorEditable( final boolean status) {   editor.setEditable(status ); }
    
    public String getTextCode(){ return editor.getText();}    
    
    public javax.swing.JTextPane getAreaEditor(){ return editor; }
    
    public void updateStatus( final int linea ) {   
        status.setText( new StringBuffer( "LINEA: " ).append( linea ).toString()); 
    }
    
     public  void setAttributesForStyleDoc( int i, int length, AttributeSet atribS ,  boolean bold) {
        styleTextForDocument.setCharacterAttributes( length, length, atribS, bold );   
    }
     
     public void initTextLineAspect( Component LineText ){
        scrollEditor.setRowHeaderView( LineText );
    }
    
    public void assingIconApp( final String  nameIcon ){ 
        setIconImage(new javax.swing.ImageIcon(getClass().getResource( nameIcon ) ).getImage()); 
    }
    
    public StyledDocument getStyledDocument(){ return  styleTextForDocument; }
    
    private void assignSyleDocumentEditor() { 
        styleTextForDocument = editor.getStyledDocument(); 
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JMenu();
        ContenedorPrincipal = new javax.swing.JPanel();
        panelStatus = new javax.swing.JPanel();
        status = new javax.swing.JLabel();
        menuToolbar = new javax.swing.JToolBar();
        buttonSave = new javax.swing.JButton();
        buttonUndo = new javax.swing.JButton();
        buttonRedo = new javax.swing.JButton();
        scrollEditor = new javax.swing.JScrollPane();
        editor = new javax.swing.JTextPane();
        menuPrincipal = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        itemNew = new javax.swing.JMenuItem();
        itemSave = new javax.swing.JMenuItem();
        itemOpen = new javax.swing.JMenuItem();

        Menu.setBackground(new java.awt.Color(0, 0, 0));
        Menu.setText("jMenu1");
        Menu.setOpaque(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EditorSource");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("windowApp"); // NOI18N
        setPreferredSize(new java.awt.Dimension(700, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(700, 500));

        ContenedorPrincipal.setLayout(new java.awt.BorderLayout());

        panelStatus.setBorder(null);
        panelStatus.setLayout(new java.awt.BorderLayout());

        status.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        status.setForeground(new java.awt.Color(0, 51, 51));
        status.setText(" ");
        status.setOpaque(true);
        panelStatus.add(status, java.awt.BorderLayout.LINE_END);

        ContenedorPrincipal.add(panelStatus, java.awt.BorderLayout.PAGE_END);

        menuToolbar.setRollover(true);

        buttonSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/saveFile.png"))); // NOI18N
        buttonSave.setToolTipText("Save File");
        buttonSave.setBorder(null);
        buttonSave.setBorderPainted(false);
        buttonSave.setContentAreaFilled(false);
        buttonSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonSave.setFocusable(false);
        buttonSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        menuToolbar.add(buttonSave);

        buttonUndo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/undo.png"))); // NOI18N
        buttonUndo.setToolTipText("undo");
        buttonUndo.setBorder(null);
        buttonUndo.setBorderPainted(false);
        buttonUndo.setContentAreaFilled(false);
        buttonUndo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonUndo.setFocusable(false);
        buttonUndo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonUndo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        menuToolbar.add(buttonUndo);

        buttonRedo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/redo.png"))); // NOI18N
        buttonRedo.setToolTipText("redo");
        buttonRedo.setBorder(null);
        buttonRedo.setBorderPainted(false);
        buttonRedo.setContentAreaFilled(false);
        buttonRedo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonRedo.setFocusable(false);
        buttonRedo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonRedo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        menuToolbar.add(buttonRedo);

        ContenedorPrincipal.add(menuToolbar, java.awt.BorderLayout.PAGE_START);

        scrollEditor.setViewportView(editor);

        ContenedorPrincipal.add(scrollEditor, java.awt.BorderLayout.CENTER);

        getContentPane().add(ContenedorPrincipal, java.awt.BorderLayout.CENTER);

        menuPrincipal.setBackground(new java.awt.Color(0, 0, 0));
        menuPrincipal.setForeground(new java.awt.Color(51, 51, 51));
        menuPrincipal.setOpaque(true);

        fileMenu.setForeground(new java.awt.Color(0, 51, 51));
        fileMenu.setText("File");
        fileMenu.setOpaque(true);

        itemNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        itemNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/document.png"))); // NOI18N
        itemNew.setText("Nuevo");
        itemNew.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fileMenu.add(itemNew);

        itemSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        itemSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/saveFile.png"))); // NOI18N
        itemSave.setText("Guardar");
        itemSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fileMenu.add(itemSave);

        itemOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        itemOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/folder.png"))); // NOI18N
        itemOpen.setText("Abrir");
        itemOpen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fileMenu.add(itemOpen);

        menuPrincipal.add(fileMenu);

        setJMenuBar(menuPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContenedorPrincipal;
    private javax.swing.JMenu Menu;
    private javax.swing.JButton buttonRedo;
    private javax.swing.JButton buttonSave;
    private javax.swing.JButton buttonUndo;
    private javax.swing.JTextPane editor;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem itemNew;
    private javax.swing.JMenuItem itemOpen;
    private javax.swing.JMenuItem itemSave;
    private javax.swing.JMenuBar menuPrincipal;
    private javax.swing.JToolBar menuToolbar;
    private javax.swing.JPanel panelStatus;
    private javax.swing.JScrollPane scrollEditor;
    private javax.swing.JLabel status;
    // End of variables declaration//GEN-END:variables
}