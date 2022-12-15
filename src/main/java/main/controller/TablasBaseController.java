package main.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import main.library.Paginador;
import main.model.*;
import main.model.TablaBase;
import main.view.TablasBase;

public class TablasBaseController extends MouseAdapter implements ActionListener, ChangeListener, KeyListener {

    private TablasBase tablaBase;
    private int xMouse;
    private int yMouse;
    private String titulo;
    private List<TablaBase> lista;
    private int idRegistro;
    private String accion = "insert";

    //ELEMENTOS DEL PAGIANDOR
    private Paginador<TablaBase> paginador;
    private int rows = 10;
    private int pagNum = 1;
    private JSpinner spinner;
    private DefaultTableModel defaultTableModel;
    //Elementos visuales
    private List<JButton> buttons;
    private List<JTextField> textFields;
    private List<JLabel> labels;
    private JTable tbBase;
    private JPanel header;

    public TablasBaseController(TablasBase tablaBase, String titulo, List<JButton> buttons, List<JTextField> textFields, List<JLabel> labels, JTable tbBase, JPanel header, JSpinner spinner) {
        super();
        this.tablaBase = tablaBase;
        this.titulo = titulo;
        this.buttons = buttons;
        this.textFields = textFields;
        this.labels = labels;
        this.tbBase = tbBase;
        this.header = header;
        this.spinner = spinner;
        labels.get(0).setText(titulo);
        reestablecer();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
            JButton btn = (JButton) source;
            if (btn.equals(buttons.get(0))) {
                //Agregar
                if (!textFields.get(0).getText().isBlank()) {
                    boolean existe = !lista.stream().filter(
                            base -> base.getNombre().equals(textFields.get(0).getText()))
                            .collect(Collectors.toList()).isEmpty();
                    if (accion.equals("insert")) {
                        //Conocer la tabla
                        if (!existe) {
                            Object[] data = {
                                textFields.get(0).getText()
                            };
                            try {
                                if (titulo.equals("Area")) {
                                    new AreaDAO().insert(data);
                                } else if (titulo.equals("Clasificacion")) {
                                    new ClasificacionDAO().insert(data);
                                } else if (titulo.equals("Tienda")) {
                                    new TiendaDAO().insert(data);
                                } else if (titulo.equals("Unidad")) {
                                    new UnidadDAO().insert(data);
                                }
                                reestablecer();
                            } catch (SQLException ex) {
                                ex.printStackTrace(System.out);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "La " + titulo + " ya existe.");
                            reestablecer();
                        }
                    } else if (accion.equals("update")) {
                        if (!existe) {
                            Object[] data = {
                                textFields.get(0).getText()
                            };
                            try {
                                if (titulo.equals("Area")) {
                                    new AreaDAO().update(idRegistro, data);
                                } else if (titulo.equals("Clasificacion")) {
                                    new ClasificacionDAO().update(idRegistro, data);
                                } else if (titulo.equals("Tienda")) {
                                    new TiendaDAO().update(idRegistro, data);
                                } else if (titulo.equals("Unidad")) {
                                    new UnidadDAO().update(idRegistro, data);
                                }
                                reestablecer();
                            } catch (SQLException ex) {
                                ex.printStackTrace(System.out);
                            }
                        } else {
                            reestablecer();
                        }
                    }
                } else {
                    reestablecer();
                }
            }
            if (btn.equals(buttons.get(1))) {
                //Eliminar
                Object[] data = {
                    textFields.get(0).getText()
                };
                try {
                    if (titulo.equals("Area")) {
                        new AreaDAO().remove(idRegistro, data);
                    } else if (titulo.equals("Clasificacion")) {
                        new ClasificacionDAO().remove(idRegistro, data);
                    } else if (titulo.equals("Tienda")) {
                        new TiendaDAO().remove(idRegistro, data);
                    } else if (titulo.equals("Unidad")) {
                        new UnidadDAO().remove(idRegistro, data);
                    }
                    reestablecer();
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }

            }
            if (btn.equals(buttons.get(2))) {
                tablaBase.dispose();
            }
            if (btn.equals(buttons.get(3))) {
                //BOTON btnPrimero
                pager(METHOD_FIRST);
            }
            if (btn.equals(buttons.get(4))) {
                //BOTON btnAnterior
                pager(METHOD_LAST);
            }
            if (btn.equals(buttons.get(5))) {
                //BOTON btnSiguiente
                pager(METHOD_NEXT);
            }
            if (btn.equals(buttons.get(6))) {
                //BOTON btnUltimo
                pager(METHOD_LATEST);
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JPanel) {
            JPanel panel = (JPanel) obj;
            if (panel.equals(header)) {
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                tablaBase.setLocation(x - xMouse, y - yMouse);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JPanel) {
            JPanel panel = (JPanel) obj;
            if (panel.equals(header)) {
                xMouse = e.getX();
                yMouse = e.getY();
            }
        }
    }

    private void buscar(String data) {
        List<TablaBase> filter;
        String titulos[] = {
            "ID",
            "Nombre"
        };
        defaultTableModel = new DefaultTableModel(null, titulos);
        int start = (pagNum - 1) * rows;
        if (data.equals("")) {
            filter = lista.stream().skip(start).limit(rows).collect(Collectors.toList());
        } else {
            filter = lista.stream().filter(base
                    -> base.getNombre().startsWith(data)
            ).skip(start).limit(rows).collect(Collectors.toList());
        }
        if (!filter.isEmpty()) {
            filter.forEach(
                    base -> {
                        Object[] objects = {
                            base.getId(),
                            base.getNombre()
                        };
                        defaultTableModel.addRow(objects);
                    }
            );
        }
        tbBase.setModel(defaultTableModel);
        tbBase.setRowHeight(30);
        tbBase.getColumnModel().getColumn(0).setMaxWidth(0);
        tbBase.getColumnModel().getColumn(0).setMinWidth(0);
        tbBase.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    private void inicializarLista() {
        lista = new ArrayList<>();
        switch (titulo) {
            case "Area" -> {
                new AreaDAO().areas().forEach(area -> {
                    lista.add(area);
                });
            }
            case "Clasificacion" -> {
                new ClasificacionDAO().clasificaciones().forEach(area -> {
                    lista.add(area);
                });
            }
            case "Tienda" -> {
                new TiendaDAO().tiendas().forEach(area -> {
                    lista.add(area);
                });
            }
            case "Unidad" -> {
                new UnidadDAO().unidades().forEach(area -> {
                    lista.add(area);
                });
            }
        }
    }

    public void pager(String method) {
        switch (method) {
            case METHOD_FIRST -> {
                if (!lista.isEmpty()) {
                    pagNum = paginador.primero();
                }

            }
            case METHOD_LAST -> {
                if (!lista.isEmpty()) {
                    pagNum = paginador.anterior();
                }
            }
            case METHOD_NEXT -> {
                if (!lista.isEmpty()) {
                    pagNum = paginador.siguiente();
                }
            }
            case METHOD_LATEST -> {
                if (!lista.isEmpty()) {
                    pagNum = paginador.ultimo();
                }
            }
        }
        buscar("");
    }

    private void mostrarRegistrosPorPagina() {
        pagNum = 1;
        Number box = (Number) spinner.getValue();
        rows = box.intValue();
        if (!lista.isEmpty()) {
            paginador = new Paginador<>(lista, labels.get(4), rows);
        }
        buscar("");
    }

    private void reestablecer() {
        accion = "insert";
        textFields.get(0).setText("");
        textFields.get(1).setText("");
        labels.get(0).setText(titulo);
        labels.get(0).setForeground(Color.black);
        labels.get(1).setText("Nombre:");
        labels.get(1).setForeground(Color.black);
        labels.get(2).setText("Buscar:");
        labels.get(2).setForeground(Color.black);
        labels.get(3).setText("Registros por paginas");
        labels.get(3).setForeground(Color.black);
        labels.get(4).setText("Paginas");
        labels.get(4).setForeground(Color.black);
        textFields.get(0).requestFocus();
        inicializarLista();
        if (!lista.isEmpty()) {
            paginador = new Paginador<>(lista, labels.get(4), rows);
        }
        SpinnerNumberModel numberModel = new SpinnerNumberModel(10, 1, 100, 1);
        spinner.setModel(numberModel);
        buscar("");
        mostrarRegistrosPorPagina();
        buttons.get(1).setVisible(false);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JSpinner) {
            JSpinner sp = (JSpinner) obj;
            if (sp.equals(spinner)) {
                mostrarRegistrosPorPagina();
            }
        }
    }

    private void obtenerRegistro() {
        accion = "update";
        int row = tbBase.getSelectedRow();
        idRegistro = (Integer) defaultTableModel.getValueAt(row, 0);
        textFields.get(0).setText((String) defaultTableModel.getValueAt(row, 1));
        textFields.get(0).requestFocus();
        buttons.get(1).setVisible(true);

    }

    @Override
    public void keyReleased(KeyEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JTextField) {
            JTextField txt = (JTextField) obj;
            if (txt.equals(textFields.get(1))) {
                buscar(textFields.get(1).getText());
            }
            if (txt.equals(textFields.get(0))) {
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (tbBase.getSelectedRows().length > 0) {
                        int index = tbBase.getSelectedRow() + 1;
                        if (index < tbBase.getRowCount()) {
                            tbBase.getSelectionModel().setSelectionInterval(index, index);
                            obtenerRegistro();
                        }
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if (tbBase.getSelectedRows().length > 0) {
                        int index = tbBase.getSelectedRow() - 1;
                        if (index >= 0) {
                            tbBase.getSelectionModel().setSelectionInterval(index, index);
                            obtenerRegistro();
                        }
                    }
                }
            }
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object obj = e.getSource();
        if (obj instanceof JTable) {
            JTable tb = (JTable) obj;
            if (tb.equals(tbBase)) {
                if (tbBase.getSelectedRows().length > 0) {
                    obtenerRegistro();
                }
            }
        }
    }

    public static final String METHOD_FIRST = "first";
    public static final String METHOD_LAST = "last";
    public static final String METHOD_NEXT = "next";
    public static final String METHOD_LATEST = "latest";

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Object source = e.getSource();
        if (source instanceof JTextField) {
            if (source.equals(textFields.get(0))) {
                if (e.getKeyChar() == '\n') {
                    actionPerformed(new ActionEvent(buttons.get(0), 1001, ""));
                }
            }
        }

    }

}
