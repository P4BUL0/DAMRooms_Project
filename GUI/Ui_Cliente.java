/********************************************************************************
 ** Form generated from reading ui file 'Clientes.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_Cliente implements com.trolltech.qt.QUiForm<QDialog>
{
    public QLabel label_2;
    public QWidget layoutWidget_4;
    public QHBoxLayout horizontalLayout;
    public QSpacerItem horizontalSpacer_2;
    public QPushButton pushButton_aceptar;
    public QPushButton pushButton_cancelar;
    public QWidget layoutWidget;
    public QGridLayout gridLayout;
    public QGroupBox groupBox_DatosCliente;
    public QGridLayout gridLayout_2;
    public QLabel label_Apellidos;
    public QLineEdit lineEdit_Direccion;
    public QLabel label_Nombre;
    public QLabel label_DNI;
    public QLabel label_Direccion;
    public QLineEdit lineEdit_DNI;
    public QLabel label_Telefono;
    public QLineEdit lineEdit_Telefono;
    public QLineEdit lineEdit_Nombre;
    public QLineEdit lineEdit_Apellidos;
    public QPushButton pushButton_eliminar;
    public QPushButton pushButton_ingresar;
    public QLabel label_Titulo;
    public QPushButton pushButton_consultar;
    public QPushButton pushButton_modificar;

    public Ui_Cliente() { super(); }

    public void setupUi(QDialog Cliente)
    {
        Cliente.setObjectName("Cliente");
        Cliente.setEnabled(true);
        Cliente.resize(new QSize(599, 350).expandedTo(Cliente.minimumSizeHint()));
        Cliente.setWindowIcon(new QIcon(new QPixmap("Logos/logo_Icon.png")));
        label_2 = new QLabel(Cliente);
        label_2.setObjectName("label_2");
        label_2.setGeometry(new QRect(460, 10, 111, 91));
        label_2.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        label_2.setAutoFillBackground(false);
        label_2.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.NoFrame);
        label_2.setPixmap(new QPixmap(("Logos/logo_size_invert.png")));
        label_2.setScaledContents(true);
        label_2.setWordWrap(false);
        layoutWidget_4 = new QWidget(Cliente);
        layoutWidget_4.setObjectName("layoutWidget_4");
        layoutWidget_4.setGeometry(new QRect(30, 300, 549, 31));
        horizontalLayout = new QHBoxLayout(layoutWidget_4);
        horizontalLayout.setObjectName("horizontalLayout");
        horizontalSpacer_2 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout.addItem(horizontalSpacer_2);

        pushButton_aceptar = new QPushButton(layoutWidget_4);
        pushButton_aceptar.setObjectName("pushButton_aceptar");
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

        horizontalLayout.addWidget(pushButton_aceptar);

        pushButton_cancelar = new QPushButton(layoutWidget_4);
        pushButton_cancelar.setObjectName("pushButton_cancelar");
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

        horizontalLayout.addWidget(pushButton_cancelar);

        layoutWidget = new QWidget(Cliente);
        layoutWidget.setObjectName("layoutWidget");
        layoutWidget.setGeometry(new QRect(30, 60, 551, 233));
        gridLayout = new QGridLayout(layoutWidget);
        gridLayout.setObjectName("gridLayout");
        groupBox_DatosCliente = new QGroupBox(layoutWidget);
        groupBox_DatosCliente.setObjectName("groupBox_DatosCliente");
        groupBox_DatosCliente.setEnabled(true);
        QPalette palette2= new QPalette();
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.WindowText, new QColor(0, 0, 0));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(152, 210, 236));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(255, 255, 255));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(152, 210, 236));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.AlternateBase, new QColor(203, 232, 245));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.WindowText, new QColor(0, 0, 0));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(152, 210, 236));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(255, 255, 255));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(152, 210, 236));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.AlternateBase, new QColor(203, 232, 245));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.WindowText, new QColor(76, 105, 118));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(152, 210, 236));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Text, new QColor(76, 105, 118));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(76, 105, 118));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(152, 210, 236));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(152, 210, 236));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.AlternateBase, new QColor(152, 210, 236));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        groupBox_DatosCliente.setPalette(palette2);
        QFont font2 = new QFont();
        font2.setFamily("Arial");
        font2.setPointSize(10);
        font2.setBold(true);
        font2.setWeight(75);
        groupBox_DatosCliente.setFont(font2);
        groupBox_DatosCliente.setAutoFillBackground(true);
        groupBox_DatosCliente.setFlat(false);
        groupBox_DatosCliente.setCheckable(false);
        gridLayout_2 = new QGridLayout(groupBox_DatosCliente);
        gridLayout_2.setObjectName("gridLayout_2");
        label_Apellidos = new QLabel(groupBox_DatosCliente);
        label_Apellidos.setObjectName("label_Apellidos");
        label_Apellidos.setEnabled(true);
        QFont font3 = new QFont();
        font3.setPointSize(8);
        font3.setBold(true);
        font3.setWeight(75);
        label_Apellidos.setFont(font3);

        gridLayout_2.addWidget(label_Apellidos, 2, 0, 1, 1);

        lineEdit_Direccion = new QLineEdit(groupBox_DatosCliente);
        lineEdit_Direccion.setObjectName("lineEdit_Direccion");
        lineEdit_Direccion.setEnabled(false);

        gridLayout_2.addWidget(lineEdit_Direccion, 0, 3, 1, 1);

        label_Nombre = new QLabel(groupBox_DatosCliente);
        label_Nombre.setObjectName("label_Nombre");
        label_Nombre.setEnabled(true);
        QFont font4 = new QFont();
        font4.setPointSize(8);
        font4.setBold(true);
        font4.setWeight(75);
        label_Nombre.setFont(font4);

        gridLayout_2.addWidget(label_Nombre, 1, 0, 1, 1);

        label_DNI = new QLabel(groupBox_DatosCliente);
        label_DNI.setObjectName("label_DNI");
        label_DNI.setEnabled(true);
        QFont font5 = new QFont();
        font5.setPointSize(8);
        font5.setBold(true);
        font5.setWeight(75);
        label_DNI.setFont(font5);

        gridLayout_2.addWidget(label_DNI, 0, 0, 1, 1);

        label_Direccion = new QLabel(groupBox_DatosCliente);
        label_Direccion.setObjectName("label_Direccion");
        label_Direccion.setEnabled(true);
        QFont font6 = new QFont();
        font6.setPointSize(8);
        font6.setBold(true);
        font6.setWeight(75);
        label_Direccion.setFont(font6);

        gridLayout_2.addWidget(label_Direccion, 0, 2, 1, 1);

        lineEdit_DNI = new QLineEdit(groupBox_DatosCliente);
        lineEdit_DNI.setObjectName("lineEdit_DNI");
        lineEdit_DNI.setEnabled(false);
        QFont font7 = new QFont();
        font7.setPointSize(8);
        lineEdit_DNI.setFont(font7);

        gridLayout_2.addWidget(lineEdit_DNI, 0, 1, 1, 1);

        label_Telefono = new QLabel(groupBox_DatosCliente);
        label_Telefono.setObjectName("label_Telefono");
        label_Telefono.setEnabled(true);
        QFont font8 = new QFont();
        font8.setPointSize(8);
        font8.setBold(true);
        font8.setWeight(75);
        label_Telefono.setFont(font8);

        gridLayout_2.addWidget(label_Telefono, 1, 2, 1, 1);

        lineEdit_Telefono = new QLineEdit(groupBox_DatosCliente);
        lineEdit_Telefono.setObjectName("lineEdit_Telefono");
        lineEdit_Telefono.setEnabled(false);
        QFont font9 = new QFont();
        font9.setPointSize(8);
        lineEdit_Telefono.setFont(font9);

        gridLayout_2.addWidget(lineEdit_Telefono, 1, 3, 1, 1);

        lineEdit_Nombre = new QLineEdit(groupBox_DatosCliente);
        lineEdit_Nombre.setObjectName("lineEdit_Nombre");
        lineEdit_Nombre.setEnabled(false);

        gridLayout_2.addWidget(lineEdit_Nombre, 1, 1, 1, 1);

        lineEdit_Apellidos = new QLineEdit(groupBox_DatosCliente);
        lineEdit_Apellidos.setObjectName("lineEdit_Apellidos");
        lineEdit_Apellidos.setEnabled(false);

        gridLayout_2.addWidget(lineEdit_Apellidos, 2, 1, 1, 1);


        gridLayout.addWidget(groupBox_DatosCliente, 3, 0, 1, 2);

        pushButton_eliminar = new QPushButton(layoutWidget);
        pushButton_eliminar.setObjectName("pushButton_eliminar");
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
        pushButton_eliminar.setPalette(palette3);
        QFont font10 = new QFont();
        font10.setBold(true);
        font10.setWeight(75);
        pushButton_eliminar.setFont(font10);
        pushButton_eliminar.setStyleSheet("background-color:rgb(19, 151, 213)");

        gridLayout.addWidget(pushButton_eliminar, 1, 0, 1, 1);

        pushButton_ingresar = new QPushButton(layoutWidget);
        pushButton_ingresar.setObjectName("pushButton_ingresar");
        QPalette palette4= new QPalette();
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(19, 151, 213));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(120, 120, 120));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(19, 151, 213));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(19, 151, 213));
        pushButton_ingresar.setPalette(palette4);
        QFont font11 = new QFont();
        font11.setBold(true);
        font11.setWeight(75);
        pushButton_ingresar.setFont(font11);
        pushButton_ingresar.setStyleSheet("background-color:rgb(19, 151, 213)");

        gridLayout.addWidget(pushButton_ingresar, 2, 0, 1, 1);

        label_Titulo = new QLabel(layoutWidget);
        label_Titulo.setObjectName("label_Titulo");
        QFont font12 = new QFont();
        font12.setPointSize(15);
        font12.setBold(true);
        font12.setUnderline(true);
        font12.setWeight(75);
        label_Titulo.setFont(font12);
        label_Titulo.setStyleSheet("");

        gridLayout.addWidget(label_Titulo, 0, 0, 1, 2);

        pushButton_consultar = new QPushButton(layoutWidget);
        pushButton_consultar.setObjectName("pushButton_consultar");
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
        pushButton_consultar.setPalette(palette5);
        QFont font13 = new QFont();
        font13.setBold(true);
        font13.setWeight(75);
        pushButton_consultar.setFont(font13);
        pushButton_consultar.setStyleSheet("background-color:rgb(19, 151, 213)");

        gridLayout.addWidget(pushButton_consultar, 1, 1, 1, 1);

        pushButton_modificar = new QPushButton(layoutWidget);
        pushButton_modificar.setObjectName("pushButton_modificar");
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
        pushButton_modificar.setPalette(palette6);
        QFont font14 = new QFont();
        font14.setBold(true);
        font14.setWeight(75);
        pushButton_modificar.setFont(font14);
        pushButton_modificar.setStyleSheet("background-color:rgb(19, 151, 213)");

        gridLayout.addWidget(pushButton_modificar, 2, 1, 1, 1);

        label_Apellidos.setBuddy(lineEdit_Apellidos);
        label_Nombre.setBuddy(lineEdit_Nombre);
        label_DNI.setBuddy(lineEdit_DNI);
        label_Direccion.setBuddy(lineEdit_Direccion);
        label_Telefono.setBuddy(lineEdit_Telefono);
        QWidget.setTabOrder(lineEdit_DNI, lineEdit_Direccion);
        QWidget.setTabOrder(lineEdit_Direccion, lineEdit_Nombre);
        QWidget.setTabOrder(lineEdit_Nombre, lineEdit_Telefono);
        QWidget.setTabOrder(lineEdit_Telefono, lineEdit_Apellidos);
        retranslateUi(Cliente);

        Cliente.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog Cliente)
    {
        Cliente.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Clientes", null));
        label_2.setText("");
        pushButton_aceptar.setText(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Aceptar", null));
        pushButton_cancelar.setText(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Cancelar", null));
        groupBox_DatosCliente.setTitle(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Datos personales", null));
        label_Apellidos.setText(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Apellidos:", null));
        lineEdit_Direccion.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Introduzca su Direcci\u00f3n", null));
        label_Nombre.setText(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Nombre:", null));
        label_DNI.setText(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "DNI:", null));
        label_Direccion.setText(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Direcci\u00f3n:", null));
        lineEdit_DNI.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Introduzca su DNI", null));
        lineEdit_DNI.setPlaceholderText(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Ej. 11111111A", null));
        label_Telefono.setText(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Telefono:", null));
        lineEdit_Telefono.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Introduzca su tel\u00e9fono", null));
        lineEdit_Telefono.setPlaceholderText(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Ej. 666118855", null));
        lineEdit_Nombre.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Introduzca su Nombre", null));
        lineEdit_Apellidos.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Introduzca sus Apellidos", null));
        pushButton_eliminar.setText(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Eliminar", null));
        pushButton_ingresar.setText(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Ingresar", null));
        label_Titulo.setText(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Gesti\u00f3n clientes", null));
        pushButton_consultar.setText(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Consultar", null));
        pushButton_modificar.setText(com.trolltech.qt.core.QCoreApplication.translate("Cliente", "Modificar", null));
    } // retranslateUi

}

