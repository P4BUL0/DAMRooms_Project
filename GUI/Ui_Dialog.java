/********************************************************************************
 ** Form generated from reading ui file 'Interfaz.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_Dialog implements com.trolltech.qt.QUiForm<QDialog>
{
    public QGroupBox groupBox;
    public QGridLayout gridLayout_2;
    public QLabel label_DNI;
    public QLineEdit lineEdit_DNI;
    public QLabel label_Direccion;
    public QLineEdit lineEdit_Direccion;
    public QLabel label_Nombre;
    public QLineEdit lineEdit_Nombre;
    public QLabel label_Telefono;
    public QLineEdit lineEdit_Telefono;
    public QLabel label_Apellidos;
    public QLineEdit lineEdit_Apellidos;
    public QGroupBox groupBox_Reservas;
    public QGroupBox groupBox_2;
    public QWidget widget;
    public QGridLayout gridLayout_4;
    public QLabel label_Numero;
    public QSpinBox spinBox_NumeroHabitacion;
    public QLabel label_Tipo;
    public QRadioButton radioButton_Doble;
    public QRadioButton radioButton_Individual;
    public QLineEdit lineEdit_ImporteNoche;
    public QLabel label_ImporteNoche;
    public QRadioButton radioButton_Familiar;
    public QRadioButton radioButton_Suite;
    public QRadioButton radioButton_GranSuite;
    public QGroupBox groupBox_3;
    public QWidget widget1;
    public QGridLayout gridLayout_5;
    public QCheckBox checkBox_Jacuzzi;
    public QCheckBox checkBox_WiFi;
    public QCheckBox checkBox_Bar;
    public QCheckBox checkBox_Aire;
    public QLabel label_Cama;
    public QRadioButton radioButton_CamaIndividual;
    public QCheckBox checkBox_Luminosa;
    public QCheckBox checkBox_Banera;
    public QCheckBox checkBox_Tele;
    public QCheckBox checkBox_Terraza;
    public QCheckBox checkBox_Cafe;
    public QRadioButton radioButton_CamaMatrimonio;
    public QRadioButton radioButton_CamaKing;
    public QWidget widget2;
    public QGridLayout gridLayout_3;
    public QDateEdit dateEdit_FechaInicio;
    public QLabel label_Direccion_2;
    public QLabel label_FechaInicio;
    public QDateEdit dateEdit_FechaFin;
    public QLineEdit lineEdit_Importe;
    public QLabel label_Nombre_2;
    public QSpacerItem horizontalSpacer;
    public QWidget layoutWidget;
    public QHBoxLayout horizontalLayout;
    public QSpacerItem horizontalSpacer_2;
    public QPushButton pushButton_Reservar;
    public QPushButton pushButton_Cancelar;

    public Ui_Dialog() { super(); }

    public void setupUi(QDialog Dialog)
    {
        Dialog.setObjectName("Dialog");
        Dialog.resize(new QSize(603, 626).expandedTo(Dialog.minimumSizeHint()));
        groupBox = new QGroupBox(Dialog);
        groupBox.setObjectName("groupBox");
        groupBox.setGeometry(new QRect(30, 20, 551, 151));
        QPalette palette= new QPalette();
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.WindowText, new QColor(255, 255, 255));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(85, 85, 127));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Light, new QColor(127, 127, 191));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Midlight, new QColor(106, 106, 159));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Dark, new QColor(42, 42, 63));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Mid, new QColor(56, 56, 84));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(85, 85, 127));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.AlternateBase, new QColor(42, 42, 63));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.WindowText, new QColor(255, 255, 255));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(85, 85, 127));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Light, new QColor(127, 127, 191));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Midlight, new QColor(106, 106, 159));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Dark, new QColor(42, 42, 63));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Mid, new QColor(56, 56, 84));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(85, 85, 127));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.AlternateBase, new QColor(42, 42, 63));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.WindowText, new QColor(42, 42, 63));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(85, 85, 127));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Light, new QColor(127, 127, 191));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Midlight, new QColor(106, 106, 159));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Dark, new QColor(42, 42, 63));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Mid, new QColor(56, 56, 84));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Text, new QColor(42, 42, 63));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(42, 42, 63));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(85, 85, 127));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(85, 85, 127));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.AlternateBase, new QColor(85, 85, 127));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        groupBox.setPalette(palette);
        QFont font = new QFont();
        font.setFamily("Arial");
        font.setPointSize(10);
        font.setBold(true);
        font.setWeight(75);
        groupBox.setFont(font);
        groupBox.setAutoFillBackground(true);
        groupBox.setFlat(false);
        groupBox.setCheckable(false);
        gridLayout_2 = new QGridLayout(groupBox);
        gridLayout_2.setObjectName("gridLayout_2");
        label_DNI = new QLabel(groupBox);
        label_DNI.setObjectName("label_DNI");
        QFont font1 = new QFont();
        font1.setPointSize(8);
        font1.setBold(true);
        font1.setWeight(75);
        label_DNI.setFont(font1);

        gridLayout_2.addWidget(label_DNI, 0, 0, 1, 1);

        lineEdit_DNI = new QLineEdit(groupBox);
        lineEdit_DNI.setObjectName("lineEdit_DNI");
        QFont font2 = new QFont();
        font2.setPointSize(8);
        lineEdit_DNI.setFont(font2);

        gridLayout_2.addWidget(lineEdit_DNI, 0, 1, 1, 1);

        label_Direccion = new QLabel(groupBox);
        label_Direccion.setObjectName("label_Direccion");
        QFont font3 = new QFont();
        font3.setPointSize(8);
        font3.setBold(true);
        font3.setWeight(75);
        label_Direccion.setFont(font3);

        gridLayout_2.addWidget(label_Direccion, 0, 2, 1, 1);

        lineEdit_Direccion = new QLineEdit(groupBox);
        lineEdit_Direccion.setObjectName("lineEdit_Direccion");

        gridLayout_2.addWidget(lineEdit_Direccion, 0, 3, 1, 1);

        label_Nombre = new QLabel(groupBox);
        label_Nombre.setObjectName("label_Nombre");
        QFont font4 = new QFont();
        font4.setPointSize(8);
        font4.setBold(true);
        font4.setWeight(75);
        label_Nombre.setFont(font4);

        gridLayout_2.addWidget(label_Nombre, 1, 0, 1, 1);

        lineEdit_Nombre = new QLineEdit(groupBox);
        lineEdit_Nombre.setObjectName("lineEdit_Nombre");

        gridLayout_2.addWidget(lineEdit_Nombre, 1, 1, 1, 1);

        label_Telefono = new QLabel(groupBox);
        label_Telefono.setObjectName("label_Telefono");
        QFont font5 = new QFont();
        font5.setPointSize(8);
        font5.setBold(true);
        font5.setWeight(75);
        label_Telefono.setFont(font5);

        gridLayout_2.addWidget(label_Telefono, 1, 2, 1, 1);

        lineEdit_Telefono = new QLineEdit(groupBox);
        lineEdit_Telefono.setObjectName("lineEdit_Telefono");
        QFont font6 = new QFont();
        font6.setPointSize(8);
        lineEdit_Telefono.setFont(font6);

        gridLayout_2.addWidget(lineEdit_Telefono, 1, 3, 1, 1);

        label_Apellidos = new QLabel(groupBox);
        label_Apellidos.setObjectName("label_Apellidos");
        QFont font7 = new QFont();
        font7.setPointSize(8);
        font7.setBold(true);
        font7.setWeight(75);
        label_Apellidos.setFont(font7);

        gridLayout_2.addWidget(label_Apellidos, 2, 0, 1, 1);

        lineEdit_Apellidos = new QLineEdit(groupBox);
        lineEdit_Apellidos.setObjectName("lineEdit_Apellidos");

        gridLayout_2.addWidget(lineEdit_Apellidos, 2, 1, 1, 1);

        groupBox_Reservas = new QGroupBox(Dialog);
        groupBox_Reservas.setObjectName("groupBox_Reservas");
        groupBox_Reservas.setGeometry(new QRect(30, 180, 551, 381));
        QPalette palette1= new QPalette();
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.WindowText, new QColor(255, 255, 255));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(85, 85, 127));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Light, new QColor(127, 127, 191));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Midlight, new QColor(106, 106, 159));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Dark, new QColor(42, 42, 63));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Mid, new QColor(56, 56, 84));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(85, 85, 127));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.AlternateBase, new QColor(42, 42, 63));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.WindowText, new QColor(255, 255, 255));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(85, 85, 127));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Light, new QColor(127, 127, 191));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Midlight, new QColor(106, 106, 159));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Dark, new QColor(42, 42, 63));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Mid, new QColor(56, 56, 84));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(85, 85, 127));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.AlternateBase, new QColor(42, 42, 63));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.WindowText, new QColor(42, 42, 63));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(85, 85, 127));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Light, new QColor(127, 127, 191));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Midlight, new QColor(106, 106, 159));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Dark, new QColor(42, 42, 63));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Mid, new QColor(56, 56, 84));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Text, new QColor(42, 42, 63));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(42, 42, 63));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(85, 85, 127));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(85, 85, 127));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.AlternateBase, new QColor(85, 85, 127));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        groupBox_Reservas.setPalette(palette1);
        QFont font8 = new QFont();
        font8.setFamily("Arial");
        font8.setPointSize(10);
        font8.setBold(true);
        font8.setWeight(75);
        groupBox_Reservas.setFont(font8);
        groupBox_Reservas.setAutoFillBackground(true);
        groupBox_Reservas.setFlat(false);
        groupBox_Reservas.setCheckable(false);
        groupBox_2 = new QGroupBox(groupBox_Reservas);
        groupBox_2.setObjectName("groupBox_2");
        groupBox_2.setGeometry(new QRect(10, 120, 531, 251));
        QPalette palette2= new QPalette();
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.WindowText, new QColor(255, 255, 255));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(85, 85, 127));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Light, new QColor(127, 127, 191));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Midlight, new QColor(106, 106, 159));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Dark, new QColor(42, 42, 63));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Mid, new QColor(56, 56, 84));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(0, 0, 0));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(85, 85, 127));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.AlternateBase, new QColor(42, 42, 63));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette2.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.WindowText, new QColor(255, 255, 255));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(85, 85, 127));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Light, new QColor(127, 127, 191));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Midlight, new QColor(106, 106, 159));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Dark, new QColor(42, 42, 63));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Mid, new QColor(56, 56, 84));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(0, 0, 0));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(85, 85, 127));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.AlternateBase, new QColor(42, 42, 63));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette2.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.WindowText, new QColor(42, 42, 63));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(85, 85, 127));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Light, new QColor(127, 127, 191));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Midlight, new QColor(106, 106, 159));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Dark, new QColor(42, 42, 63));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Mid, new QColor(56, 56, 84));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Text, new QColor(42, 42, 63));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(42, 42, 63));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(85, 85, 127));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(85, 85, 127));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.AlternateBase, new QColor(85, 85, 127));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette2.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        groupBox_2.setPalette(palette2);
        QFont font9 = new QFont();
        font9.setFamily("Arial");
        font9.setPointSize(10);
        font9.setBold(true);
        font9.setWeight(75);
        groupBox_2.setFont(font9);
        groupBox_2.setAutoFillBackground(true);
        groupBox_2.setFlat(false);
        groupBox_2.setCheckable(false);
        widget = new QWidget(groupBox_2);
        widget.setObjectName("widget");
        widget.setGeometry(new QRect(10, 26, 511, 221));
        gridLayout_4 = new QGridLayout(widget);
        gridLayout_4.setObjectName("gridLayout_4");
        label_Numero = new QLabel(widget);
        label_Numero.setObjectName("label_Numero");
        QFont font10 = new QFont();
        font10.setPointSize(8);
        font10.setBold(true);
        font10.setWeight(75);
        label_Numero.setFont(font10);

        gridLayout_4.addWidget(label_Numero, 0, 0, 1, 1);

        spinBox_NumeroHabitacion = new QSpinBox(widget);
        spinBox_NumeroHabitacion.setObjectName("spinBox_NumeroHabitacion");

        gridLayout_4.addWidget(spinBox_NumeroHabitacion, 0, 1, 1, 1);

        label_Tipo = new QLabel(widget);
        label_Tipo.setObjectName("label_Tipo");
        QFont font11 = new QFont();
        font11.setPointSize(8);
        font11.setBold(true);
        font11.setWeight(75);
        label_Tipo.setFont(font11);

        gridLayout_4.addWidget(label_Tipo, 2, 0, 1, 1);

        radioButton_Doble = new QRadioButton(widget);
        QButtonGroup buttonGroup_Tipo = new QButtonGroup(Dialog);
        buttonGroup_Tipo.addButton(radioButton_Doble);
        radioButton_Doble.setObjectName("radioButton_Doble");

        gridLayout_4.addWidget(radioButton_Doble, 2, 2, 1, 1);

        radioButton_Individual = new QRadioButton(widget);
        buttonGroup_Tipo.addButton(radioButton_Individual);
        radioButton_Individual.setObjectName("radioButton_Individual");

        gridLayout_4.addWidget(radioButton_Individual, 2, 1, 1, 1);

        lineEdit_ImporteNoche = new QLineEdit(widget);
        lineEdit_ImporteNoche.setObjectName("lineEdit_ImporteNoche");
        lineEdit_ImporteNoche.setMaximumSize(new QSize(50, 16777215));
        QFont font12 = new QFont();
        font12.setPointSize(8);
        lineEdit_ImporteNoche.setFont(font12);

        gridLayout_4.addWidget(lineEdit_ImporteNoche, 0, 3, 1, 1);

        label_ImporteNoche = new QLabel(widget);
        label_ImporteNoche.setObjectName("label_ImporteNoche");
        QFont font13 = new QFont();
        font13.setPointSize(8);
        font13.setBold(true);
        font13.setWeight(75);
        label_ImporteNoche.setFont(font13);

        gridLayout_4.addWidget(label_ImporteNoche, 0, 2, 1, 1);

        radioButton_Familiar = new QRadioButton(widget);
        buttonGroup_Tipo.addButton(radioButton_Familiar);
        radioButton_Familiar.setObjectName("radioButton_Familiar");

        gridLayout_4.addWidget(radioButton_Familiar, 2, 3, 1, 1);

        radioButton_Suite = new QRadioButton(widget);
        buttonGroup_Tipo.addButton(radioButton_Suite);
        radioButton_Suite.setObjectName("radioButton_Suite");

        gridLayout_4.addWidget(radioButton_Suite, 2, 4, 1, 1);

        radioButton_GranSuite = new QRadioButton(widget);
        buttonGroup_Tipo.addButton(radioButton_GranSuite);
        radioButton_GranSuite.setObjectName("radioButton_GranSuite");

        gridLayout_4.addWidget(radioButton_GranSuite, 2, 5, 1, 1);

        groupBox_3 = new QGroupBox(widget);
        groupBox_3.setObjectName("groupBox_3");
        groupBox_3.setMaximumSize(new QSize(500, 140));
        QPalette palette3= new QPalette();
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.WindowText, new QColor(255, 255, 255));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(85, 85, 127));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Light, new QColor(127, 127, 191));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Midlight, new QColor(106, 106, 159));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Dark, new QColor(42, 42, 63));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Mid, new QColor(56, 56, 84));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(0, 0, 0));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(85, 85, 127));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.AlternateBase, new QColor(42, 42, 63));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette3.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.WindowText, new QColor(255, 255, 255));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(85, 85, 127));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Light, new QColor(127, 127, 191));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Midlight, new QColor(106, 106, 159));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Dark, new QColor(42, 42, 63));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Mid, new QColor(56, 56, 84));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(0, 0, 0));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(85, 85, 127));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.AlternateBase, new QColor(42, 42, 63));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette3.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.WindowText, new QColor(42, 42, 63));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(85, 85, 127));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Light, new QColor(127, 127, 191));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Midlight, new QColor(106, 106, 159));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Dark, new QColor(42, 42, 63));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Mid, new QColor(56, 56, 84));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Text, new QColor(42, 42, 63));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(42, 42, 63));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(85, 85, 127));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(85, 85, 127));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.AlternateBase, new QColor(85, 85, 127));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette3.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        groupBox_3.setPalette(palette3);
        QFont font14 = new QFont();
        font14.setFamily("Arial");
        font14.setPointSize(10);
        font14.setBold(true);
        font14.setWeight(75);
        groupBox_3.setFont(font14);
        groupBox_3.setAutoFillBackground(true);
        groupBox_3.setFlat(false);
        groupBox_3.setCheckable(false);
        widget1 = new QWidget(groupBox_3);
        widget1.setObjectName("widget1");
        widget1.setGeometry(new QRect(40, 20, 451, 111));
        gridLayout_5 = new QGridLayout(widget1);
        gridLayout_5.setObjectName("gridLayout_5");
        checkBox_Jacuzzi = new QCheckBox(widget1);
        checkBox_Jacuzzi.setObjectName("checkBox_Jacuzzi");
        checkBox_Jacuzzi.setMaximumSize(new QSize(100, 16777215));
        QFont font15 = new QFont();
        font15.setPointSize(8);
        checkBox_Jacuzzi.setFont(font15);

        gridLayout_5.addWidget(checkBox_Jacuzzi, 0, 2, 1, 1);

        checkBox_WiFi = new QCheckBox(widget1);
        checkBox_WiFi.setObjectName("checkBox_WiFi");
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(checkBox_WiFi.sizePolicy().hasHeightForWidth());
        checkBox_WiFi.setSizePolicy(sizePolicy);
        checkBox_WiFi.setMaximumSize(new QSize(100, 16777215));
        QFont font16 = new QFont();
        font16.setPointSize(8);
        checkBox_WiFi.setFont(font16);

        gridLayout_5.addWidget(checkBox_WiFi, 1, 0, 1, 1);

        checkBox_Bar = new QCheckBox(widget1);
        checkBox_Bar.setObjectName("checkBox_Bar");
        checkBox_Bar.setMaximumSize(new QSize(100, 16777215));
        QFont font17 = new QFont();
        font17.setPointSize(8);
        checkBox_Bar.setFont(font17);

        gridLayout_5.addWidget(checkBox_Bar, 1, 1, 1, 1);

        checkBox_Aire = new QCheckBox(widget1);
        checkBox_Aire.setObjectName("checkBox_Aire");
        checkBox_Aire.setMaximumSize(new QSize(100, 16777215));
        QFont font18 = new QFont();
        font18.setPointSize(8);
        checkBox_Aire.setFont(font18);

        gridLayout_5.addWidget(checkBox_Aire, 2, 2, 1, 1);

        label_Cama = new QLabel(widget1);
        label_Cama.setObjectName("label_Cama");
        QFont font19 = new QFont();
        font19.setPointSize(9);
        label_Cama.setFont(font19);

        gridLayout_5.addWidget(label_Cama, 3, 0, 1, 1);

        radioButton_CamaIndividual = new QRadioButton(widget1);
        QButtonGroup buttonGroup_Cama = new QButtonGroup(Dialog);
        buttonGroup_Cama.addButton(radioButton_CamaIndividual);
        radioButton_CamaIndividual.setObjectName("radioButton_CamaIndividual");
        QFont font20 = new QFont();
        font20.setPointSize(8);
        radioButton_CamaIndividual.setFont(font20);

        gridLayout_5.addWidget(radioButton_CamaIndividual, 4, 0, 1, 1);

        checkBox_Luminosa = new QCheckBox(widget1);
        checkBox_Luminosa.setObjectName("checkBox_Luminosa");
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy1.setHorizontalStretch((byte)0);
        sizePolicy1.setVerticalStretch((byte)0);
        sizePolicy1.setHeightForWidth(checkBox_Luminosa.sizePolicy().hasHeightForWidth());
        checkBox_Luminosa.setSizePolicy(sizePolicy1);
        checkBox_Luminosa.setMaximumSize(new QSize(100, 16777215));
        QFont font21 = new QFont();
        font21.setPointSize(8);
        checkBox_Luminosa.setFont(font21);

        gridLayout_5.addWidget(checkBox_Luminosa, 0, 0, 1, 1);

        checkBox_Banera = new QCheckBox(widget1);
        checkBox_Banera.setObjectName("checkBox_Banera");
        checkBox_Banera.setMaximumSize(new QSize(100, 16777215));
        QFont font22 = new QFont();
        font22.setPointSize(8);
        checkBox_Banera.setFont(font22);

        gridLayout_5.addWidget(checkBox_Banera, 2, 1, 1, 1);

        checkBox_Tele = new QCheckBox(widget1);
        checkBox_Tele.setObjectName("checkBox_Tele");
        checkBox_Tele.setMaximumSize(new QSize(100, 16777215));
        QFont font23 = new QFont();
        font23.setPointSize(8);
        checkBox_Tele.setFont(font23);

        gridLayout_5.addWidget(checkBox_Tele, 1, 2, 1, 1);

        checkBox_Terraza = new QCheckBox(widget1);
        checkBox_Terraza.setObjectName("checkBox_Terraza");
        QSizePolicy sizePolicy2 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy2.setHorizontalStretch((byte)0);
        sizePolicy2.setVerticalStretch((byte)0);
        sizePolicy2.setHeightForWidth(checkBox_Terraza.sizePolicy().hasHeightForWidth());
        checkBox_Terraza.setSizePolicy(sizePolicy2);
        checkBox_Terraza.setMaximumSize(new QSize(100, 16777215));
        QFont font24 = new QFont();
        font24.setPointSize(8);
        checkBox_Terraza.setFont(font24);

        gridLayout_5.addWidget(checkBox_Terraza, 2, 0, 1, 1);

        checkBox_Cafe = new QCheckBox(widget1);
        checkBox_Cafe.setObjectName("checkBox_Cafe");
        checkBox_Cafe.setMaximumSize(new QSize(100, 16777215));
        QFont font25 = new QFont();
        font25.setPointSize(8);
        checkBox_Cafe.setFont(font25);

        gridLayout_5.addWidget(checkBox_Cafe, 0, 1, 1, 1);

        radioButton_CamaMatrimonio = new QRadioButton(widget1);
        buttonGroup_Cama.addButton(radioButton_CamaMatrimonio);
        radioButton_CamaMatrimonio.setObjectName("radioButton_CamaMatrimonio");
        QFont font26 = new QFont();
        font26.setPointSize(8);
        radioButton_CamaMatrimonio.setFont(font26);

        gridLayout_5.addWidget(radioButton_CamaMatrimonio, 4, 1, 1, 1);

        radioButton_CamaKing = new QRadioButton(widget1);
        buttonGroup_Cama.addButton(radioButton_CamaKing);
        radioButton_CamaKing.setObjectName("radioButton_CamaKing");
        QFont font27 = new QFont();
        font27.setPointSize(8);
        radioButton_CamaKing.setFont(font27);

        gridLayout_5.addWidget(radioButton_CamaKing, 4, 2, 1, 1);


        gridLayout_4.addWidget(groupBox_3, 3, 0, 1, 6);

        widget2 = new QWidget(groupBox_Reservas);
        widget2.setObjectName("widget2");
        widget2.setGeometry(new QRect(10, 26, 531, 81));
        gridLayout_3 = new QGridLayout(widget2);
        gridLayout_3.setObjectName("gridLayout_3");
        dateEdit_FechaInicio = new QDateEdit(widget2);
        dateEdit_FechaInicio.setObjectName("dateEdit_FechaInicio");
        QFont font28 = new QFont();
        font28.setPointSize(9);
        dateEdit_FechaInicio.setFont(font28);

        gridLayout_3.addWidget(dateEdit_FechaInicio, 0, 1, 1, 1);

        label_Direccion_2 = new QLabel(widget2);
        label_Direccion_2.setObjectName("label_Direccion_2");
        QFont font29 = new QFont();
        font29.setPointSize(8);
        font29.setBold(true);
        font29.setWeight(75);
        label_Direccion_2.setFont(font29);

        gridLayout_3.addWidget(label_Direccion_2, 0, 2, 1, 1);

        label_FechaInicio = new QLabel(widget2);
        label_FechaInicio.setObjectName("label_FechaInicio");
        QFont font30 = new QFont();
        font30.setPointSize(8);
        font30.setBold(true);
        font30.setWeight(75);
        label_FechaInicio.setFont(font30);

        gridLayout_3.addWidget(label_FechaInicio, 0, 0, 1, 1);

        dateEdit_FechaFin = new QDateEdit(widget2);
        dateEdit_FechaFin.setObjectName("dateEdit_FechaFin");
        QFont font31 = new QFont();
        font31.setPointSize(9);
        dateEdit_FechaFin.setFont(font31);

        gridLayout_3.addWidget(dateEdit_FechaFin, 0, 3, 1, 1);

        lineEdit_Importe = new QLineEdit(widget2);
        lineEdit_Importe.setObjectName("lineEdit_Importe");
        QFont font32 = new QFont();
        font32.setPointSize(8);
        lineEdit_Importe.setFont(font32);

        gridLayout_3.addWidget(lineEdit_Importe, 1, 1, 1, 1);

        label_Nombre_2 = new QLabel(widget2);
        label_Nombre_2.setObjectName("label_Nombre_2");
        QFont font33 = new QFont();
        font33.setPointSize(8);
        font33.setBold(true);
        font33.setWeight(75);
        label_Nombre_2.setFont(font33);

        gridLayout_3.addWidget(label_Nombre_2, 1, 0, 1, 1);

        horizontalSpacer = new QSpacerItem(600, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_3.addItem(horizontalSpacer, 0, 4, 1, 1);

        layoutWidget = new QWidget(Dialog);
        layoutWidget.setObjectName("layoutWidget");
        layoutWidget.setGeometry(new QRect(30, 570, 551, 41));
        horizontalLayout = new QHBoxLayout(layoutWidget);
        horizontalLayout.setObjectName("horizontalLayout");
        horizontalSpacer_2 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout.addItem(horizontalSpacer_2);

        pushButton_Reservar = new QPushButton(layoutWidget);
        pushButton_Reservar.setObjectName("pushButton_Reservar");
        QPalette palette4= new QPalette();
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(85, 85, 127));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(85, 85, 127));
        palette4.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(85, 85, 127));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(85, 85, 127));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(85, 85, 127));
        palette4.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(85, 85, 127));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(85, 85, 127));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(120, 120, 120));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(85, 85, 127));
        palette4.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(85, 85, 127));
        pushButton_Reservar.setPalette(palette4);
        pushButton_Reservar.setStyleSheet("background-color:rgb(85, 85, 127)");

        horizontalLayout.addWidget(pushButton_Reservar);

        pushButton_Cancelar = new QPushButton(layoutWidget);
        pushButton_Cancelar.setObjectName("pushButton_Cancelar");
        QPalette palette5= new QPalette();
        palette5.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(0, 0, 0));
        palette5.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette5.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(0, 0, 0));
        palette5.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(0, 0, 0));
        palette5.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(0, 0, 0));
        palette5.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(255, 255, 255));
        palette5.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(0, 0, 0));
        palette5.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(0, 0, 0));
        palette5.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(0, 0, 0));
        palette5.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(120, 120, 120));
        palette5.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(0, 0, 0));
        palette5.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(0, 0, 0));
        pushButton_Cancelar.setPalette(palette5);
        pushButton_Cancelar.setStyleSheet("background-color:rgb(0, 0, 0)");

        horizontalLayout.addWidget(pushButton_Cancelar);

        label_DNI.setBuddy(lineEdit_DNI);
        label_Direccion.setBuddy(lineEdit_Direccion);
        label_Nombre.setBuddy(lineEdit_Nombre);
        label_Telefono.setBuddy(lineEdit_Telefono);
        label_Apellidos.setBuddy(lineEdit_Apellidos);
        label_Numero.setBuddy(spinBox_NumeroHabitacion);
        label_Tipo.setBuddy(radioButton_Individual);
        label_ImporteNoche.setBuddy(lineEdit_ImporteNoche);
        label_Direccion_2.setBuddy(dateEdit_FechaFin);
        label_FechaInicio.setBuddy(dateEdit_FechaInicio);
        label_Nombre_2.setBuddy(lineEdit_Importe);
        QWidget.setTabOrder(lineEdit_DNI, lineEdit_Direccion);
        QWidget.setTabOrder(lineEdit_Direccion, lineEdit_Nombre);
        QWidget.setTabOrder(lineEdit_Nombre, lineEdit_Telefono);
        QWidget.setTabOrder(lineEdit_Telefono, lineEdit_Apellidos);
        QWidget.setTabOrder(lineEdit_Apellidos, dateEdit_FechaInicio);
        QWidget.setTabOrder(dateEdit_FechaInicio, dateEdit_FechaFin);
        QWidget.setTabOrder(dateEdit_FechaFin, lineEdit_Importe);
        QWidget.setTabOrder(lineEdit_Importe, spinBox_NumeroHabitacion);
        QWidget.setTabOrder(spinBox_NumeroHabitacion, lineEdit_ImporteNoche);
        QWidget.setTabOrder(lineEdit_ImporteNoche, radioButton_Individual);
        QWidget.setTabOrder(radioButton_Individual, radioButton_Doble);
        QWidget.setTabOrder(radioButton_Doble, radioButton_Familiar);
        QWidget.setTabOrder(radioButton_Familiar, checkBox_Luminosa);
        QWidget.setTabOrder(checkBox_Luminosa, checkBox_Cafe);
        QWidget.setTabOrder(checkBox_Cafe, checkBox_Jacuzzi);
        QWidget.setTabOrder(checkBox_Jacuzzi, checkBox_WiFi);
        QWidget.setTabOrder(checkBox_WiFi, checkBox_Bar);
        QWidget.setTabOrder(checkBox_Bar, checkBox_Tele);
        QWidget.setTabOrder(checkBox_Tele, checkBox_Terraza);
        QWidget.setTabOrder(checkBox_Terraza, checkBox_Banera);
        QWidget.setTabOrder(checkBox_Banera, checkBox_Aire);
        QWidget.setTabOrder(checkBox_Aire, radioButton_CamaIndividual);
        QWidget.setTabOrder(radioButton_CamaIndividual, radioButton_CamaMatrimonio);
        QWidget.setTabOrder(radioButton_CamaMatrimonio, radioButton_CamaKing);
        QWidget.setTabOrder(radioButton_CamaKing, pushButton_Reservar);
        QWidget.setTabOrder(pushButton_Reservar, pushButton_Cancelar);
        retranslateUi(Dialog);

        Dialog.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog Dialog)
    {
        Dialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Datos de Usuario", null));
        groupBox.setTitle(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Datos personales", null));
        label_DNI.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "DNI:", null));
        lineEdit_DNI.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Introduzca su DNI", null));
        lineEdit_DNI.setPlaceholderText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Ej. 11111111A", null));
        label_Direccion.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Direcci\u00f3n:", null));
        lineEdit_Direccion.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Introduzca su Direcci\u00f3n", null));
        label_Nombre.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Nombre:", null));
        lineEdit_Nombre.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Introduzca su Nombre", null));
        label_Telefono.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Telefono:", null));
        lineEdit_Telefono.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Introduzca su tel\u00e9fono", null));
        lineEdit_Telefono.setPlaceholderText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Ej. 666118855", null));
        label_Apellidos.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Apellidos:", null));
        lineEdit_Apellidos.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Introduzca sus Apellidos", null));
        groupBox_Reservas.setTitle(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Reserva", null));
        groupBox_2.setTitle(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Habitaci\u00f3n", null));
        label_Numero.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "N\u00famero:", null));
        label_Tipo.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Tipo:", null));
        radioButton_Doble.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Doble", null));
        radioButton_Individual.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Individual", null));
        lineEdit_ImporteNoche.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Introduzca su tel\u00e9fono", null));
        lineEdit_ImporteNoche.setPlaceholderText("");
        label_ImporteNoche.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Importe noche:", null));
        radioButton_Familiar.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Familiar", null));
        radioButton_Suite.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Suite", null));
        radioButton_GranSuite.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Gran Suite", null));
        groupBox_3.setTitle(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Caracter\u00edsticas", null));
        checkBox_Jacuzzi.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Jacuzzi", null));
        checkBox_WiFi.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Wi-Fi", null));
        checkBox_Bar.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Mini bar", null));
        checkBox_Aire.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Aire acond", null));
        label_Cama.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Cama:", null));
        radioButton_CamaIndividual.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Individual", null));
        checkBox_Luminosa.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Luminosa", null));
        checkBox_Banera.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Ba\u00f1era", null));
        checkBox_Tele.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Televisi\u00f3n", null));
        checkBox_Terraza.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Terraza", null));
        checkBox_Cafe.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Cafetera", null));
        radioButton_CamaMatrimonio.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Matrimonio", null));
        radioButton_CamaKing.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "KingSize", null));
        label_Direccion_2.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Fecha fin:", null));
        label_FechaInicio.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Fecha inicio:", null));
        lineEdit_Importe.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Introduzca su Nombre", null));
        label_Nombre_2.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Importe Total:", null));
        pushButton_Reservar.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Reservar", null));
        pushButton_Cancelar.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Cancelar", null));
    } // retranslateUi

}

