
package gui;

import controllers.TextLineNumber;
import javax.swing.event.CaretListener;

public class WindowEditor extends javax.swing.JFrame 
{
    private TextLineNumber lineNumberAspect;
    /**
     * Creates new form WindowEditor
     */
    public WindowEditor() 
    {
           initComponents();
           initTextLineAspect();
           iconApp();
    }
    
     public void updateStatus(final int linea, final int columna) 
    {
        status.setText(new StringBuffer("LINEA: ")
                                                            .append(linea)
                                                            .append(" COLUMNA: ")
                                                            .append(columna)
                                                            .toString());
    }
     
    public void addCarentEventListener(CaretListener event)
    {
        this.editor.addCaretListener( event );
    }
   
     public void windowCenterPosition()
    {
        this.setLocationRelativeTo( null );
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JMenu();
        ContenedorPrincipal = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        scrollEditor = new javax.swing.JScrollPane();
        editor = new javax.swing.JTextArea();
        panelStatus = new javax.swing.JPanel();
        status = new javax.swing.JLabel();
        menuPrincipal = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        itemNew = new javax.swing.JMenuItem();
        itemSave = new javax.swing.JMenuItem();

        Menu.setBackground(new java.awt.Color(0, 0, 0));
        Menu.setText("jMenu1");
        Menu.setOpaque(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EditorCode");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("windowApp"); // NOI18N
        setPreferredSize(new java.awt.Dimension(700, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(700, 500));

        ContenedorPrincipal.setLayout(new java.awt.BorderLayout());

        titulo.setBackground(new java.awt.Color(0, 102, 153));
        titulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("EDITOR SOURCE");
        titulo.setToolTipText("Descripcion");
        titulo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        titulo.setOpaque(true);
        ContenedorPrincipal.add(titulo, java.awt.BorderLayout.PAGE_START);

        editor.setColumns(20);
        editor.setRows(5);
        scrollEditor.setViewportView(editor);

        ContenedorPrincipal.add(scrollEditor, java.awt.BorderLayout.CENTER);

        panelStatus.setLayout(new java.awt.BorderLayout());

        status.setText(" ");
        panelStatus.add(status, java.awt.BorderLayout.LINE_END);

        ContenedorPrincipal.add(panelStatus, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(ContenedorPrincipal, java.awt.BorderLayout.CENTER);

        menuPrincipal.setBackground(new java.awt.Color(0, 0, 0));
        menuPrincipal.setForeground(new java.awt.Color(51, 51, 51));
        menuPrincipal.setOpaque(true);

        fileMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/OpenFile.png"))); // NOI18N
        fileMenu.setText("File");

        itemNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        itemNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/document.png"))); // NOI18N
        itemNew.setText("Nuevo");
        fileMenu.add(itemNew);

        itemSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        itemSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/saveFile.png"))); // NOI18N
        itemSave.setText("Guardar");
        fileMenu.add(itemSave);

        menuPrincipal.add(fileMenu);

        setJMenuBar(menuPrincipal);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initTextLineAspect()
    {
        lineNumberAspect= new TextLineNumber(editor);
        scrollEditor.setRowHeaderView( lineNumberAspect );
    }
    
    private void iconApp(){
        setIconImage(new javax.swing.ImageIcon(getClass().getResource( "/icons/logo.png") ).getImage());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContenedorPrincipal;
    private javax.swing.JMenu Menu;
    private javax.swing.JTextArea editor;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem itemNew;
    private javax.swing.JMenuItem itemSave;
    private javax.swing.JMenuBar menuPrincipal;
    private javax.swing.JPanel panelStatus;
    private javax.swing.JScrollPane scrollEditor;
    private javax.swing.JLabel status;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
