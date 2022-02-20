package interfazrooms;

import APIRest.Cliente;
import APIRest.RestClientCliente;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.trolltech.qt.core.QRect;
import com.trolltech.qt.core.QSize;
import com.trolltech.qt.gui.*;

import javax.swing.*;
import java.lang.reflect.Type;
import java.util.Collection;

public class Ui_Cliente implements com.trolltech.qt.QUiForm<QDialog> {
    public QWidget layoutWidget_4;
    public QHBoxLayout horizontalLayout;
    public QSpacerItem horizontalSpacer_2;
    public QLabel label_confirmacion;
    public QPushButton pushButton_aceptar;
    public QPushButton pushButton_cancelar;
    public QLabel label_Titulo;
    public QWidget layoutWidget;
    public QGridLayout gridLayout;
    public QPushButton pushButton_consultar;
    public QPushButton pushButton_modificar;
    public QGroupBox groupBox_DatosCliente;
    public QWidget layoutWidget1;
    public QGridLayout gridLayout_2;
    public QLineEdit lineEdit_Direccion;
    public QLineEdit lineEdit_Telefono;
    public QLabel label_Telefono;
    public QLabel label_Direccion;
    public QLabel label_Nombre;
    public QLabel label_Apellidos;
    public QLineEdit lineEdit_Nombre;
    public QLineEdit lineEdit_Apellidos;
    public QPushButton pushButton_eliminar;
    public QPushButton pushButton_ingresar;
    public QLabel label_Logo;
    public QGroupBox groupBox_cliente_2;
    public QLabel label_DNI;
    public QLineEdit lineEdit_DNI;

    public Ui_Cliente() { super(); }

    //Métodos API
    public void insertarCliente(){

        RestClientCliente restClientCliente = new RestClientCliente();

        String dni;
        String nombre;
        String apellidos;
        String direccion;
        int telefono;

        dni = lineEdit_DNI.text();
        nombre = lineEdit_Nombre.text();
        apellidos = lineEdit_Apellidos.text();
        direccion = lineEdit_Direccion.text();
        telefono = Integer.parseInt(lineEdit_Telefono.text());

        restClientCliente.crear(dni, nombre, apellidos, direccion, telefono);
    }

    public void consultarCliente(){
        String dni;
        String resultado = "";
        Gson gson = new Gson();

        RestClientCliente restClientCliente = new RestClientCliente();
        dni = lineEdit_DNI.text();
        resultado = restClientCliente.consultar(dni);
        Type collectionType = new TypeToken<Collection<Cliente>>(){}.getType();
        Collection<Cliente> clientes = gson.fromJson(resultado, collectionType);

            lineEdit_Nombre.setText(clientes.stream().findFirst().get().getNombre());
            lineEdit_Apellidos.setText(clientes.stream().findFirst().get().getApellidos());
            lineEdit_Direccion.setText(clientes.stream().findFirst().get().getDireccion());
            lineEdit_Telefono.setText(String.valueOf(clientes.stream().findFirst().get().getTelefono()));

    }

    public void eliminarCliente(){
        String dni;
        RestClientCliente restClientCliente = new RestClientCliente();
        dni = lineEdit_DNI.text();
            restClientCliente.eliminar(dni);

    }

    public void modificarCliente(){
        String dni;
        RestClientCliente restClientCliente = new RestClientCliente();
        dni = lineEdit_DNI.text();
        restClientCliente.modificar(dni);
    }

    //Métodos mensajes
    public void mensajeOPCorrecta(){
        JOptionPane.showMessageDialog(null, "La acción se ha realizado correctamente.","OK", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mensajeERRORformatoDNI(){
        JOptionPane.showMessageDialog(null, "El DNI no es correcto", "Error", JOptionPane.ERROR_MESSAGE);
    }

    //Métodos DNI
    public boolean comprobarDNI(){
        String dni = lineEdit_DNI.text();
        String letraMayuscula = "";

        if(dni.length() !=9 || !Character.isLetter(dni.charAt(8))){
            mensajeERRORformatoDNI();
            return false;
        }

        letraMayuscula = dni.substring(8).toUpperCase();

        if(soloNumeros() && letraDNI().equals(letraMayuscula)){
            mensajeOPCorrecta();
            pushButton_ingresar.clicked.connect(label_Direccion, "setDisabled(boolean)");
            pushButton_ingresar.clicked.connect(label_Telefono, "setDisabled(boolean)");
            pushButton_ingresar.clicked.connect(lineEdit_Nombre, "setDisabled(boolean)");
            pushButton_ingresar.clicked.connect(label_Nombre, "setDisabled(boolean)");
            pushButton_ingresar.clicked.connect(lineEdit_Direccion, "setDisabled(boolean)");
            pushButton_ingresar.clicked.connect(lineEdit_Apellidos, "setDisabled(boolean)");
            pushButton_ingresar.clicked.connect(lineEdit_Telefono, "setDisabled(boolean)");
            pushButton_ingresar.clicked.connect(label_Apellidos, "setDisabled(boolean)");
            return true;
        }else if(!lineEdit_DNI.text().isEmpty()){
            mensajeERRORformatoDNI();
        }

        return false;
    }

    private boolean soloNumeros(){
        String dni = lineEdit_DNI.text();
        int i, j = 0;
        String numero = "";
        String miDNI = "";
        String[] unoNueve = {"0","1","2","3","4","5","6","7","8","9"};
        for (i = 0; i < 9; i++) {
            numero = dni.substring(i, i+1);
            for(j = 0; j < 9; j++){
                if (numero.equals(unoNueve[j])){
                    miDNI += unoNueve[j];
                }
            }
        }

        if (miDNI.length() != 8){
            return false;
        }else{
            return true;
        }
    }

    private String letraDNI(){
        String dni = lineEdit_DNI.text();
        int miDNI = Integer.parseInt(dni.substring(0,8));
        int resto = 0;
        String miLetra = "";
        String[] asignacionLetra = {"T","R","W","A","G","M","Y","F","T","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};

        resto = miDNI % 23;

        miLetra = asignacionLetra[resto];

        return miLetra;
    }

    //Métodos GUI
    public void setupUi(QDialog Cliente) {
        Cliente.setObjectName("Cliente");
        Cliente.setEnabled(true);
        Cliente.resize(new QSize(600, 362).expandedTo(Cliente.minimumSizeHint()));
        Cliente.setWindowIcon(new QIcon(new QPixmap("Resources/Logos/logo_Icon.png")));
        layoutWidget_4 = new QWidget(Cliente);
        layoutWidget_4.setObjectName("layoutWidget_4");
        layoutWidget_4.setGeometry(new QRect(30, 310, 549, 31));
        horizontalLayout = new QHBoxLayout(layoutWidget_4);
        horizontalLayout.setObjectName("horizontalLayout");
        horizontalSpacer_2 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout.addItem(horizontalSpacer_2);

        label_confirmacion = new QLabel(layoutWidget_4);
        label_confirmacion.setObjectName("label_confirmacion");
        label_confirmacion.setEnabled(true);

        horizontalLayout.addWidget(label_confirmacion);

        pushButton_aceptar = new QPushButton(layoutWidget_4);
        pushButton_aceptar.setObjectName("pushButton_aceptar");
        pushButton_aceptar.setMinimumSize(new QSize(0, 23));
        QPalette palette= new QPalette();
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(120, 120, 120));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        pushButton_aceptar.setPalette(palette);
        QFont font = new QFont();
        font.setBold(true);
        font.setWeight(75);
        pushButton_aceptar.setFont(font);
        pushButton_aceptar.setStyleSheet("background-color:rgb(19, 151, 213)");
        pushButton_aceptar.setIcon(new QIcon(new QPixmap("Resources/Iconos/Aceptar.png")));

        horizontalLayout.addWidget(pushButton_aceptar);

        pushButton_cancelar = new QPushButton(layoutWidget_4);
        pushButton_cancelar.setObjectName("pushButton_cancelar");
        pushButton_cancelar.setMinimumSize(new QSize(0, 23));
        QPalette palette1= new QPalette();
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(120, 120, 120));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(0, 0, 0));
        pushButton_cancelar.setPalette(palette1);
        QFont font1 = new QFont();
        font1.setBold(true);
        font1.setWeight(75);
        pushButton_cancelar.setFont(font1);
        pushButton_cancelar.setStyleSheet("");
        pushButton_cancelar.setIcon(new QIcon(new QPixmap("Resources/Iconos/Salir.png")));
        pushButton_cancelar.clicked.connect(Cliente, "close()");

        horizontalLayout.addWidget(pushButton_cancelar);

        label_Titulo = new QLabel(Cliente);
        label_Titulo.setObjectName("label_Titulo");
        label_Titulo.setGeometry(new QRect(40, 20, 160, 24));
        QFont font2 = new QFont();
        font2.setPointSize(15);
        font2.setBold(true);
        font2.setUnderline(true);
        font2.setWeight(75);
        label_Titulo.setFont(font2);
        label_Titulo.setStyleSheet("");
        layoutWidget = new QWidget(Cliente);
        layoutWidget.setObjectName("layoutWidget");
        layoutWidget.setGeometry(new QRect(31, 119, 551, 176));
        gridLayout = new QGridLayout(layoutWidget);
        gridLayout.setObjectName("gridLayout");
        pushButton_consultar = new QPushButton(layoutWidget);
        pushButton_consultar.setObjectName("pushButton_consultar");
        QPalette palette2= new QPalette();
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(120, 120, 120));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        pushButton_consultar.setPalette(palette2);
        QFont font3 = new QFont();
        font3.setBold(true);
        font3.setWeight(75);
        pushButton_consultar.setFont(font3);
        pushButton_consultar.setStyleSheet("background-color:rgb(19, 151, 213)");
        pushButton_consultar.setIcon(new QIcon(new QPixmap("Resources/Iconos/Buscar.png")));
        pushButton_consultar.setCheckable(true);
        pushButton_consultar.setAutoExclusive(true);

        gridLayout.addWidget(pushButton_consultar, 0, 1, 1, 1);

        pushButton_modificar = new QPushButton(layoutWidget);
        pushButton_modificar.setObjectName("pushButton_modificar");
        QPalette palette3= new QPalette();
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(120, 120, 120));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        pushButton_modificar.setPalette(palette3);
        QFont font4 = new QFont();
        font4.setBold(true);
        font4.setWeight(75);
        pushButton_modificar.setFont(font4);
        pushButton_modificar.setStyleSheet("background-color:rgb(19, 151, 213)");
        pushButton_modificar.setIcon(new QIcon(new QPixmap("Resources/Iconos/Modificar.png")));
        pushButton_modificar.setCheckable(true);
        pushButton_modificar.setAutoExclusive(true);

        gridLayout.addWidget(pushButton_modificar, 1, 1, 1, 1);

        groupBox_DatosCliente = new QGroupBox(layoutWidget);
        groupBox_DatosCliente.setObjectName("groupBox_DatosCliente");
        groupBox_DatosCliente.setEnabled(false);
        QPalette palette4= new QPalette();
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.WindowText, new QColor(0, 0, 0));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(152, 210, 236));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(255, 255, 255));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(152, 210, 236));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.AlternateBase, new QColor(203, 232, 245));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.WindowText, new QColor(0, 0, 0));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(152, 210, 236));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(255, 255, 255));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(152, 210, 236));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.AlternateBase, new QColor(203, 232, 245));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.WindowText, new QColor(76, 105, 118));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(152, 210, 236));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Text, new QColor(76, 105, 118));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(76, 105, 118));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(152, 210, 236));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(152, 210, 236));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.AlternateBase, new QColor(152, 210, 236));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        groupBox_DatosCliente.setPalette(palette4);
        QFont font5 = new QFont();
        font5.setFamily("Arial");
        font5.setPointSize(10);
        font5.setBold(true);
        font5.setWeight(75);
        groupBox_DatosCliente.setFont(font5);
        groupBox_DatosCliente.setAutoFillBackground(true);
        groupBox_DatosCliente.setFlat(false);
        groupBox_DatosCliente.setCheckable(false);
        layoutWidget1 = new QWidget(groupBox_DatosCliente);
        layoutWidget1.setObjectName("layoutWidget1");
        layoutWidget1.setGeometry(new QRect(10, 20, 531, 81));
        gridLayout_2 = new QGridLayout(layoutWidget1);
        gridLayout_2.setObjectName("gridLayout_2");
        lineEdit_Direccion = new QLineEdit(layoutWidget1);
        lineEdit_Direccion.setObjectName("lineEdit_Direccion");
        lineEdit_Direccion.setEnabled(false);

        gridLayout_2.addWidget(lineEdit_Direccion, 0, 3, 1, 1);

        lineEdit_Telefono = new QLineEdit(layoutWidget1);
        lineEdit_Telefono.setObjectName("lineEdit_Telefono");
        lineEdit_Telefono.setEnabled(false);
        QFont font6 = new QFont();
        font6.setPointSize(8);
        lineEdit_Telefono.setFont(font6);

        gridLayout_2.addWidget(lineEdit_Telefono, 1, 3, 1, 1);

        label_Telefono = new QLabel(layoutWidget1);
        label_Telefono.setObjectName("label_Telefono");
        label_Telefono.setEnabled(false);
        QFont font7 = new QFont();
        font7.setPointSize(8);
        font7.setBold(true);
        font7.setWeight(75);
        label_Telefono.setFont(font7);

        gridLayout_2.addWidget(label_Telefono, 1, 2, 1, 1);

        label_Direccion = new QLabel(layoutWidget1);
        label_Direccion.setObjectName("label_Direccion");
        label_Direccion.setEnabled(false);
        QFont font8 = new QFont();
        font8.setPointSize(8);
        font8.setBold(true);
        font8.setWeight(75);
        label_Direccion.setFont(font8);

        gridLayout_2.addWidget(label_Direccion, 0, 2, 1, 1);

        label_Nombre = new QLabel(layoutWidget1);
        label_Nombre.setObjectName("label_Nombre");
        label_Nombre.setEnabled(false);
        QFont font9 = new QFont();
        font9.setPointSize(8);
        font9.setBold(true);
        font9.setWeight(75);
        label_Nombre.setFont(font9);

        gridLayout_2.addWidget(label_Nombre, 0, 0, 1, 1);

        label_Apellidos = new QLabel(layoutWidget1);
        label_Apellidos.setObjectName("label_Apellidos");
        label_Apellidos.setEnabled(false);
        QFont font10 = new QFont();
        font10.setPointSize(8);
        font10.setBold(true);
        font10.setWeight(75);
        label_Apellidos.setFont(font10);

        gridLayout_2.addWidget(label_Apellidos, 1, 0, 1, 1);

        lineEdit_Nombre = new QLineEdit(layoutWidget1);
        lineEdit_Nombre.setObjectName("lineEdit_Nombre");
        lineEdit_Nombre.setEnabled(false);

        gridLayout_2.addWidget(lineEdit_Nombre, 0, 1, 1, 1);

        lineEdit_Apellidos = new QLineEdit(layoutWidget1);
        lineEdit_Apellidos.setObjectName("lineEdit_Apellidos");
        lineEdit_Apellidos.setEnabled(false);

        gridLayout_2.addWidget(lineEdit_Apellidos, 1, 1, 1, 1);


        gridLayout.addWidget(groupBox_DatosCliente, 2, 0, 1, 2);

        pushButton_eliminar = new QPushButton(layoutWidget);
        pushButton_eliminar.setObjectName("pushButton_eliminar");
        QPalette palette5= new QPalette();
        palette5.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette5.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette5.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette5.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        palette5.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette5.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette5.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette5.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        palette5.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette5.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(120, 120, 120));
        palette5.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette5.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        pushButton_eliminar.setPalette(palette5);
        QFont font11 = new QFont();
        font11.setBold(true);
        font11.setWeight(75);
        pushButton_eliminar.setFont(font11);
        pushButton_eliminar.setStyleSheet("background-color:rgb(19, 151, 213)");
        pushButton_eliminar.setIcon(new QIcon(new QPixmap("Resources/Iconos/Eliminar.png")));
        pushButton_eliminar.setCheckable(true);
        pushButton_eliminar.setAutoExclusive(true);

        gridLayout.addWidget(pushButton_eliminar, 1, 0, 1, 1);

        pushButton_ingresar = new QPushButton(layoutWidget);
        pushButton_ingresar.setObjectName("pushButton_ingresar");
        QPalette palette6= new QPalette();
        palette6.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette6.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette6.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette6.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        palette6.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette6.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette6.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette6.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        palette6.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette6.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(120, 120, 120));
        palette6.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette6.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        pushButton_ingresar.setPalette(palette6);
        QFont font12 = new QFont();
        font12.setBold(true);
        font12.setWeight(75);
        pushButton_ingresar.setFont(font12);
        pushButton_ingresar.setStyleSheet("background-color:rgb(19, 151, 213)");
        pushButton_ingresar.setIcon(new QIcon(new QPixmap("Resources/Iconos/Guardar.png")));
        pushButton_ingresar.setCheckable(true);
        pushButton_ingresar.setAutoExclusive(true);

        gridLayout.addWidget(pushButton_ingresar, 0, 0, 1, 1);

        label_Logo = new QLabel(Cliente);
        label_Logo.setObjectName("label_Logo");
        label_Logo.setGeometry(new QRect(460, 10, 121, 101));
        label_Logo.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        label_Logo.setAutoFillBackground(false);
        label_Logo.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.NoFrame);
        label_Logo.setPixmap(new QPixmap(("Resources/Logos/logo_size_invert.png")));
        label_Logo.setScaledContents(true);
        label_Logo.setWordWrap(false);
        groupBox_cliente_2 = new QGroupBox(Cliente);
        groupBox_cliente_2.setObjectName("groupBox_cliente_2");
        groupBox_cliente_2.setEnabled(true);
        groupBox_cliente_2.setGeometry(new QRect(40, 60, 361, 51));
        QPalette palette7= new QPalette();
        palette7.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.WindowText, new QColor(0, 0, 0));
        palette7.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(152, 210, 232));
        palette7.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette7.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette7.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette7.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette7.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette7.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette7.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette7.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(152, 210, 232));
        palette7.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(152, 210, 232));
        palette7.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette7.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.AlternateBase, new QColor(203, 232, 245));
        palette7.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette7.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette7.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.WindowText, new QColor(0, 0, 0));
        palette7.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(152, 210, 232));
        palette7.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette7.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette7.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette7.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette7.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette7.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette7.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette7.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(152, 210, 232));
        palette7.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(152, 210, 232));
        palette7.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette7.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.AlternateBase, new QColor(203, 232, 245));
        palette7.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette7.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette7.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.WindowText, new QColor(76, 105, 118));
        palette7.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(152, 210, 232));
        palette7.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette7.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette7.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette7.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette7.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Text, new QColor(76, 105, 118));
        palette7.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette7.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(76, 105, 118));
        palette7.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(152, 210, 232));
        palette7.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(152, 210, 232));
        palette7.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette7.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.AlternateBase, new QColor(152, 210, 236));
        palette7.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette7.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        groupBox_cliente_2.setPalette(palette7);
        QFont font13 = new QFont();
        font13.setPointSize(10);
        font13.setBold(true);
        font13.setWeight(75);
        groupBox_cliente_2.setFont(font13);
        groupBox_cliente_2.setStyleSheet("background-color:rgb(152,210,232)");
        label_DNI = new QLabel(groupBox_cliente_2);
        label_DNI.setObjectName("label_DNI");
        label_DNI.setEnabled(true);
        label_DNI.setGeometry(new QRect(10, 20, 55, 22));
        QFont font14 = new QFont();
        font14.setPointSize(16);
        font14.setBold(true);
        font14.setWeight(75);
        label_DNI.setFont(font14);
        lineEdit_DNI = new QLineEdit(groupBox_cliente_2);
        lineEdit_DNI.setObjectName("lineEdit_DNI");
        lineEdit_DNI.setEnabled(true);
        lineEdit_DNI.setGeometry(new QRect(70, 20, 201, 20));
        QFont font15 = new QFont();
        font15.setPointSize(8);
        lineEdit_DNI.setFont(font15);
        label_Telefono.setBuddy(lineEdit_Telefono);
        label_Direccion.setBuddy(lineEdit_Direccion);
        label_Nombre.setBuddy(lineEdit_Nombre);
        label_Apellidos.setBuddy(lineEdit_Apellidos);
        label_DNI.setBuddy(lineEdit_DNI);
        QWidget.setTabOrder(lineEdit_DNI, pushButton_ingresar);
        QWidget.setTabOrder(pushButton_ingresar, pushButton_consultar);
        QWidget.setTabOrder(pushButton_consultar, pushButton_eliminar);
        QWidget.setTabOrder(pushButton_eliminar, pushButton_modificar);
        QWidget.setTabOrder(pushButton_modificar, lineEdit_Nombre);
        QWidget.setTabOrder(lineEdit_Nombre, lineEdit_Direccion);
        QWidget.setTabOrder(lineEdit_Direccion, lineEdit_Apellidos);
        QWidget.setTabOrder(lineEdit_Apellidos, lineEdit_Telefono);
        QWidget.setTabOrder(lineEdit_Telefono, pushButton_aceptar);
        QWidget.setTabOrder(pushButton_aceptar, pushButton_cancelar);
        retranslateUi(Cliente);
        pushButton_ingresar.toggled.connect(groupBox_DatosCliente, "setEnabled(boolean)");
        pushButton_ingresar.toggled.connect(label_Nombre, "setEnabled(boolean)");
        pushButton_ingresar.toggled.connect(lineEdit_Nombre, "setEnabled(boolean)");
        pushButton_ingresar.toggled.connect(label_Apellidos, "setEnabled(boolean)");
        pushButton_ingresar.toggled.connect(lineEdit_Apellidos, "setEnabled(boolean)");
        pushButton_ingresar.toggled.connect(label_Direccion, "setEnabled(boolean)");
        pushButton_ingresar.toggled.connect(lineEdit_Direccion, "setEnabled(boolean)");
        pushButton_ingresar.toggled.connect(label_Telefono, "setEnabled(boolean)");
        pushButton_ingresar.toggled.connect(lineEdit_Telefono, "setEnabled(boolean)");

        pushButton_modificar.toggled.connect(groupBox_DatosCliente, "setEnabled(boolean)");
        pushButton_modificar.toggled.connect(label_Nombre, "setEnabled(boolean)");
        pushButton_modificar.toggled.connect(lineEdit_Nombre, "setEnabled(boolean)");
        pushButton_modificar.toggled.connect(label_Apellidos, "setEnabled(boolean)");
        pushButton_modificar.toggled.connect(lineEdit_Apellidos, "setEnabled(boolean)");
        pushButton_modificar.toggled.connect(label_Direccion, "setEnabled(boolean)");
        pushButton_modificar.toggled.connect(lineEdit_Direccion, "setEnabled(boolean)");
        pushButton_modificar.toggled.connect(label_Telefono, "setEnabled(boolean)");
        pushButton_modificar.toggled.connect(lineEdit_Telefono, "setEnabled(boolean)");

//        pushButton_consultar.toggled.connect(groupBox_DatosCliente, "setEnabled(boolean)");
//        pushButton_consultar.toggled.connect(label_Nombre, "setEnabled(boolean)");
//        pushButton_consultar.toggled.connect(lineEdit_Nombre, "setEnabled(boolean)");
//        pushButton_consultar.toggled.connect(label_Apellidos, "setEnabled(boolean)");
//        pushButton_consultar.toggled.connect(lineEdit_Apellidos, "setEnabled(boolean)");
//        pushButton_consultar.toggled.connect(label_Direccion, "setEnabled(boolean)");
//        pushButton_consultar.toggled.connect(lineEdit_Direccion, "setEnabled(boolean)");
//        pushButton_consultar.toggled.connect(label_Telefono, "setEnabled(boolean)");
//        pushButton_consultar.toggled.connect(lineEdit_Telefono, "setEnabled(boolean)");

        pushButton_consultar.toggled.connect(this, "consultarCliente()");


        if (pushButton_ingresar.isEnabled()){
            pushButton_ingresar.clicked.connect(this,"insertarCliente()");
        }
        if (pushButton_modificar.isEnabled()) {
            pushButton_modificar.clicked.connect(this, "modificarCliente()");
        }
        if (pushButton_eliminar.isEnabled()) {
//            int confirmar = JOptionPane.showConfirmDialog(null,"Quieres eliminar el cliente?", "Eliminar cliente", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
//            if (confirmar == 0){
//                pushButton_eliminar.clicked.connect(this,"eliminarCliente()");
            pushButton_eliminar.clicked.connect(this, "eliminarCliente()");
        }

        pushButton_cancelar.clicked.connect(Cliente, "close()");
        Cliente.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog Cliente) {
        Cliente.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Clientes", null));
        label_confirmacion.setText("");
        pushButton_aceptar.setText(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Aceptar", null));
        pushButton_cancelar.setText(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Cancelar", null));
        label_Titulo.setText(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Gesti\u00f3n clientes", null));
        pushButton_consultar.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Consultar cliente", null));
        pushButton_consultar.setText(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Consultar", null));
        pushButton_modificar.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Modificar cliente", null));
        pushButton_modificar.setText(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Modificar", null));
        groupBox_DatosCliente.setTitle(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Datos personales", null));
        lineEdit_Direccion.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Introduzca su Direcci\u00f3n", null));
        lineEdit_Telefono.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Introduzca su tel\u00e9fono", null));
        lineEdit_Telefono.setPlaceholderText(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Ej. 666118855", null));
        label_Telefono.setText(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Telefono:", null));
        label_Direccion.setText(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Direcci\u00f3n:", null));
        label_Nombre.setText(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Nombre:", null));
        label_Apellidos.setText(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Apellidos:", null));
        lineEdit_Nombre.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Introduzca su Nombre", null));
        lineEdit_Apellidos.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Introduzca sus Apellidos", null));
        pushButton_eliminar.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Eliminar cliente", null));
        pushButton_eliminar.setText(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Eliminar", null));
        pushButton_ingresar.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Ingresar cliente", null));
        pushButton_ingresar.setText(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Ingresar", null));
        label_Logo.setText("");
        groupBox_cliente_2.setTitle(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Cliente", null));
        label_DNI.setText(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "DNI:", null));
        lineEdit_DNI.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Introduzca su DNI", null));
        lineEdit_DNI.setPlaceholderText(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Ej. 11111111A", null));
    } // retranslateUi

}

