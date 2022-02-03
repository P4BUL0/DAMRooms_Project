/********************************************************************************
 ** Form generated from reading ui file 'Reservas.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package interfazrooms;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_Reservas implements com.trolltech.qt.QUiForm<QDialog>
{
    public QGroupBox groupBox_Reservas;
    public QGroupBox groupBox_2;
    public QWidget layoutWidget;
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
    public QWidget layoutWidget_2;
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
    public QWidget layoutWidget_3;
    public QGridLayout gridLayout_3;
    public QDateEdit dateEdit_FechaInicio;
    public QLabel label_Direccion_2;
    public QLabel label_FechaInicio;
    public QDateEdit dateEdit_FechaFin;
    public QLineEdit lineEdit_Importe;
    public QLabel label_Nombre_2;
    public QSpacerItem horizontalSpacer;
    public QWidget layoutWidget_4;
    public QHBoxLayout horizontalLayout;
    public QSpacerItem horizontalSpacer_2;
    public QPushButton pushButton_eliminar;
    public QPushButton pushButton_modificar;
    public QPushButton pushButton_reservar;
    public QPushButton pushButton_cancelar;
    public QLabel label_2;
    public QLabel label_Titulo;
    public QGroupBox groupBox_cliente;
    public QComboBox comboBox;
    public QLabel label_clienteDNI;
    public QComboBox comboBox_2;
    public QLabel label_cliente_reserva;
    public QGroupBox groupBox_cliente_2;
    public QListView listView_Reservas;

    public Ui_Reservas() { super(); }

    public void setupUi(QDialog Reservas)
    {
        Reservas.setObjectName("Reservas");
        Reservas.resize(new QSize(573, 898).expandedTo(Reservas.minimumSizeHint()));
        groupBox_Reservas = new QGroupBox(Reservas);
        groupBox_Reservas.setObjectName("groupBox_Reservas");
        groupBox_Reservas.setGeometry(new QRect(10, 164, 549, 390));
        groupBox_Reservas.setMinimumSize(new QSize(0, 390));
        QPalette palette= new QPalette();
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.WindowText, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(152, 210, 236));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(255, 255, 255));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(152, 210, 236));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.AlternateBase, new QColor(203, 232, 245));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.WindowText, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(152, 210, 236));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(255, 255, 255));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(152, 210, 236));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.AlternateBase, new QColor(203, 232, 245));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.WindowText, new QColor(76, 105, 118));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(152, 210, 236));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Text, new QColor(76, 105, 118));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(76, 105, 118));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(152, 210, 236));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(152, 210, 236));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.AlternateBase, new QColor(152, 210, 236));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        groupBox_Reservas.setPalette(palette);
        QFont font = new QFont();
        font.setFamily("Arial");
        font.setPointSize(10);
        font.setBold(true);
        font.setWeight(75);
        groupBox_Reservas.setFont(font);
        groupBox_Reservas.setAutoFillBackground(true);
        groupBox_Reservas.setFlat(false);
        groupBox_Reservas.setCheckable(false);
        groupBox_2 = new QGroupBox(groupBox_Reservas);
        groupBox_2.setObjectName("groupBox_2");
        groupBox_2.setGeometry(new QRect(10, 120, 531, 251));
        QPalette palette1= new QPalette();
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.WindowText, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(152, 210, 236));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(255, 255, 255));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(152, 210, 236));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.AlternateBase, new QColor(203, 232, 245));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette1.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.WindowText, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(152, 210, 236));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(255, 255, 255));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(152, 210, 236));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.AlternateBase, new QColor(203, 232, 245));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette1.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.WindowText, new QColor(76, 105, 118));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(152, 210, 236));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Text, new QColor(76, 105, 118));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(76, 105, 118));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(152, 210, 236));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(152, 210, 236));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.AlternateBase, new QColor(152, 210, 236));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette1.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        groupBox_2.setPalette(palette1);
        QFont font1 = new QFont();
        font1.setFamily("Arial");
        font1.setPointSize(10);
        font1.setBold(true);
        font1.setWeight(75);
        groupBox_2.setFont(font1);
        groupBox_2.setAutoFillBackground(true);
        groupBox_2.setFlat(false);
        groupBox_2.setCheckable(false);
        layoutWidget = new QWidget(groupBox_2);
        layoutWidget.setObjectName("layoutWidget");
        layoutWidget.setGeometry(new QRect(10, 26, 511, 221));
        gridLayout_4 = new QGridLayout(layoutWidget);
        gridLayout_4.setObjectName("gridLayout_4");
        label_Numero = new QLabel(layoutWidget);
        label_Numero.setObjectName("label_Numero");
        QFont font2 = new QFont();
        font2.setPointSize(8);
        font2.setBold(true);
        font2.setWeight(75);
        label_Numero.setFont(font2);

        gridLayout_4.addWidget(label_Numero, 0, 0, 1, 1);

        spinBox_NumeroHabitacion = new QSpinBox(layoutWidget);
        spinBox_NumeroHabitacion.setObjectName("spinBox_NumeroHabitacion");

        gridLayout_4.addWidget(spinBox_NumeroHabitacion, 0, 1, 1, 1);

        label_Tipo = new QLabel(layoutWidget);
        label_Tipo.setObjectName("label_Tipo");
        QFont font3 = new QFont();
        font3.setPointSize(8);
        font3.setBold(true);
        font3.setWeight(75);
        label_Tipo.setFont(font3);

        gridLayout_4.addWidget(label_Tipo, 2, 0, 1, 1);

        radioButton_Doble = new QRadioButton(layoutWidget);
        radioButton_Doble.setObjectName("radioButton_Doble");

        gridLayout_4.addWidget(radioButton_Doble, 2, 2, 1, 1);

        radioButton_Individual = new QRadioButton(layoutWidget);
        radioButton_Individual.setObjectName("radioButton_Individual");

        gridLayout_4.addWidget(radioButton_Individual, 2, 1, 1, 1);

        lineEdit_ImporteNoche = new QLineEdit(layoutWidget);
        lineEdit_ImporteNoche.setObjectName("lineEdit_ImporteNoche");
        lineEdit_ImporteNoche.setMaximumSize(new QSize(50, 16777215));
        QFont font4 = new QFont();
        font4.setPointSize(8);
        lineEdit_ImporteNoche.setFont(font4);

        gridLayout_4.addWidget(lineEdit_ImporteNoche, 0, 3, 1, 1);

        label_ImporteNoche = new QLabel(layoutWidget);
        label_ImporteNoche.setObjectName("label_ImporteNoche");
        QFont font5 = new QFont();
        font5.setPointSize(8);
        font5.setBold(true);
        font5.setWeight(75);
        label_ImporteNoche.setFont(font5);

        gridLayout_4.addWidget(label_ImporteNoche, 0, 2, 1, 1);

        radioButton_Familiar = new QRadioButton(layoutWidget);
        radioButton_Familiar.setObjectName("radioButton_Familiar");

        gridLayout_4.addWidget(radioButton_Familiar, 2, 3, 1, 1);

        radioButton_Suite = new QRadioButton(layoutWidget);
        radioButton_Suite.setObjectName("radioButton_Suite");

        gridLayout_4.addWidget(radioButton_Suite, 2, 4, 1, 1);

        radioButton_GranSuite = new QRadioButton(layoutWidget);
        radioButton_GranSuite.setObjectName("radioButton_GranSuite");

        gridLayout_4.addWidget(radioButton_GranSuite, 2, 5, 1, 1);

        groupBox_3 = new QGroupBox(layoutWidget);
        groupBox_3.setObjectName("groupBox_3");
        groupBox_3.setMaximumSize(new QSize(500, 140));
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
        groupBox_3.setPalette(palette2);
        QFont font6 = new QFont();
        font6.setFamily("Arial");
        font6.setPointSize(10);
        font6.setBold(true);
        font6.setWeight(75);
        groupBox_3.setFont(font6);
        groupBox_3.setAutoFillBackground(true);
        groupBox_3.setFlat(false);
        groupBox_3.setCheckable(false);
        layoutWidget_2 = new QWidget(groupBox_3);
        layoutWidget_2.setObjectName("layoutWidget_2");
        layoutWidget_2.setGeometry(new QRect(40, 20, 451, 113));
        gridLayout_5 = new QGridLayout(layoutWidget_2);
        gridLayout_5.setObjectName("gridLayout_5");
        checkBox_Jacuzzi = new QCheckBox(layoutWidget_2);
        checkBox_Jacuzzi.setObjectName("checkBox_Jacuzzi");
        checkBox_Jacuzzi.setMaximumSize(new QSize(100, 16777215));
        QFont font7 = new QFont();
        font7.setPointSize(8);
        checkBox_Jacuzzi.setFont(font7);

        gridLayout_5.addWidget(checkBox_Jacuzzi, 0, 2, 1, 1);

        checkBox_WiFi = new QCheckBox(layoutWidget_2);
        checkBox_WiFi.setObjectName("checkBox_WiFi");
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(checkBox_WiFi.sizePolicy().hasHeightForWidth());
        checkBox_WiFi.setSizePolicy(sizePolicy);
        checkBox_WiFi.setMaximumSize(new QSize(100, 16777215));
        QFont font8 = new QFont();
        font8.setPointSize(8);
        checkBox_WiFi.setFont(font8);

        gridLayout_5.addWidget(checkBox_WiFi, 1, 0, 1, 1);

        checkBox_Bar = new QCheckBox(layoutWidget_2);
        checkBox_Bar.setObjectName("checkBox_Bar");
        checkBox_Bar.setMaximumSize(new QSize(100, 16777215));
        QFont font9 = new QFont();
        font9.setPointSize(8);
        checkBox_Bar.setFont(font9);

        gridLayout_5.addWidget(checkBox_Bar, 1, 1, 1, 1);

        checkBox_Aire = new QCheckBox(layoutWidget_2);
        checkBox_Aire.setObjectName("checkBox_Aire");
        checkBox_Aire.setMaximumSize(new QSize(100, 16777215));
        QFont font10 = new QFont();
        font10.setPointSize(8);
        checkBox_Aire.setFont(font10);

        gridLayout_5.addWidget(checkBox_Aire, 2, 2, 1, 1);

        label_Cama = new QLabel(layoutWidget_2);
        label_Cama.setObjectName("label_Cama");
        QFont font11 = new QFont();
        font11.setPointSize(9);
        label_Cama.setFont(font11);

        gridLayout_5.addWidget(label_Cama, 3, 0, 1, 1);

        radioButton_CamaIndividual = new QRadioButton(layoutWidget_2);
        radioButton_CamaIndividual.setObjectName("radioButton_CamaIndividual");
        QFont font12 = new QFont();
        font12.setPointSize(8);
        radioButton_CamaIndividual.setFont(font12);

        gridLayout_5.addWidget(radioButton_CamaIndividual, 4, 0, 1, 1);

        checkBox_Luminosa = new QCheckBox(layoutWidget_2);
        checkBox_Luminosa.setObjectName("checkBox_Luminosa");
        QSizePolicy sizePolicy1 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy1.setHorizontalStretch((byte)0);
        sizePolicy1.setVerticalStretch((byte)0);
        sizePolicy1.setHeightForWidth(checkBox_Luminosa.sizePolicy().hasHeightForWidth());
        checkBox_Luminosa.setSizePolicy(sizePolicy1);
        checkBox_Luminosa.setMaximumSize(new QSize(100, 16777215));
        QFont font13 = new QFont();
        font13.setPointSize(8);
        checkBox_Luminosa.setFont(font13);

        gridLayout_5.addWidget(checkBox_Luminosa, 0, 0, 1, 1);

        checkBox_Banera = new QCheckBox(layoutWidget_2);
        checkBox_Banera.setObjectName("checkBox_Banera");
        checkBox_Banera.setMaximumSize(new QSize(100, 16777215));
        QFont font14 = new QFont();
        font14.setPointSize(8);
        checkBox_Banera.setFont(font14);

        gridLayout_5.addWidget(checkBox_Banera, 2, 1, 1, 1);

        checkBox_Tele = new QCheckBox(layoutWidget_2);
        checkBox_Tele.setObjectName("checkBox_Tele");
        checkBox_Tele.setMaximumSize(new QSize(100, 16777215));
        QFont font15 = new QFont();
        font15.setPointSize(8);
        checkBox_Tele.setFont(font15);

        gridLayout_5.addWidget(checkBox_Tele, 1, 2, 1, 1);

        checkBox_Terraza = new QCheckBox(layoutWidget_2);
        checkBox_Terraza.setObjectName("checkBox_Terraza");
        QSizePolicy sizePolicy2 = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Fixed);
        sizePolicy2.setHorizontalStretch((byte)0);
        sizePolicy2.setVerticalStretch((byte)0);
        sizePolicy2.setHeightForWidth(checkBox_Terraza.sizePolicy().hasHeightForWidth());
        checkBox_Terraza.setSizePolicy(sizePolicy2);
        checkBox_Terraza.setMaximumSize(new QSize(100, 16777215));
        QFont font16 = new QFont();
        font16.setPointSize(8);
        checkBox_Terraza.setFont(font16);

        gridLayout_5.addWidget(checkBox_Terraza, 2, 0, 1, 1);

        checkBox_Cafe = new QCheckBox(layoutWidget_2);
        checkBox_Cafe.setObjectName("checkBox_Cafe");
        checkBox_Cafe.setMaximumSize(new QSize(100, 16777215));
        QFont font17 = new QFont();
        font17.setPointSize(8);
        checkBox_Cafe.setFont(font17);

        gridLayout_5.addWidget(checkBox_Cafe, 0, 1, 1, 1);

        radioButton_CamaMatrimonio = new QRadioButton(layoutWidget_2);
        radioButton_CamaMatrimonio.setObjectName("radioButton_CamaMatrimonio");
        QFont font18 = new QFont();
        font18.setPointSize(8);
        radioButton_CamaMatrimonio.setFont(font18);

        gridLayout_5.addWidget(radioButton_CamaMatrimonio, 4, 1, 1, 1);

        radioButton_CamaKing = new QRadioButton(layoutWidget_2);
        radioButton_CamaKing.setObjectName("radioButton_CamaKing");
        QFont font19 = new QFont();
        font19.setPointSize(8);
        radioButton_CamaKing.setFont(font19);

        gridLayout_5.addWidget(radioButton_CamaKing, 4, 2, 1, 1);


        gridLayout_4.addWidget(groupBox_3, 3, 0, 1, 6);

        layoutWidget_3 = new QWidget(groupBox_Reservas);
        layoutWidget_3.setObjectName("layoutWidget_3");
        layoutWidget_3.setGeometry(new QRect(10, 26, 531, 81));
        gridLayout_3 = new QGridLayout(layoutWidget_3);
        gridLayout_3.setObjectName("gridLayout_3");
        dateEdit_FechaInicio = new QDateEdit(layoutWidget_3);
        dateEdit_FechaInicio.setObjectName("dateEdit_FechaInicio");
        QFont font20 = new QFont();
        font20.setPointSize(9);
        dateEdit_FechaInicio.setFont(font20);

        gridLayout_3.addWidget(dateEdit_FechaInicio, 0, 1, 1, 1);

        label_Direccion_2 = new QLabel(layoutWidget_3);
        label_Direccion_2.setObjectName("label_Direccion_2");
        QFont font21 = new QFont();
        font21.setPointSize(8);
        font21.setBold(true);
        font21.setWeight(75);
        label_Direccion_2.setFont(font21);

        gridLayout_3.addWidget(label_Direccion_2, 0, 2, 1, 1);

        label_FechaInicio = new QLabel(layoutWidget_3);
        label_FechaInicio.setObjectName("label_FechaInicio");
        QFont font22 = new QFont();
        font22.setPointSize(8);
        font22.setBold(true);
        font22.setWeight(75);
        label_FechaInicio.setFont(font22);

        gridLayout_3.addWidget(label_FechaInicio, 0, 0, 1, 1);

        dateEdit_FechaFin = new QDateEdit(layoutWidget_3);
        dateEdit_FechaFin.setObjectName("dateEdit_FechaFin");
        QFont font23 = new QFont();
        font23.setPointSize(9);
        dateEdit_FechaFin.setFont(font23);

        gridLayout_3.addWidget(dateEdit_FechaFin, 0, 3, 1, 1);

        lineEdit_Importe = new QLineEdit(layoutWidget_3);
        lineEdit_Importe.setObjectName("lineEdit_Importe");
        QFont font24 = new QFont();
        font24.setPointSize(8);
        lineEdit_Importe.setFont(font24);

        gridLayout_3.addWidget(lineEdit_Importe, 1, 1, 1, 1);

        label_Nombre_2 = new QLabel(layoutWidget_3);
        label_Nombre_2.setObjectName("label_Nombre_2");
        QFont font25 = new QFont();
        font25.setPointSize(8);
        font25.setBold(true);
        font25.setWeight(75);
        label_Nombre_2.setFont(font25);

        gridLayout_3.addWidget(label_Nombre_2, 1, 0, 1, 1);

        horizontalSpacer = new QSpacerItem(600, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_3.addItem(horizontalSpacer, 0, 4, 1, 1);

        layoutWidget_4 = new QWidget(Reservas);
        layoutWidget_4.setObjectName("layoutWidget_4");
        layoutWidget_4.setGeometry(new QRect(10, 860, 551, 25));
        horizontalLayout = new QHBoxLayout(layoutWidget_4);
        horizontalLayout.setObjectName("horizontalLayout");
        horizontalSpacer_2 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        horizontalLayout.addItem(horizontalSpacer_2);

        pushButton_eliminar = new QPushButton(layoutWidget_4);
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
        QFont font26 = new QFont();
        font26.setBold(true);
        font26.setWeight(75);
        pushButton_eliminar.setFont(font26);
        pushButton_eliminar.setStyleSheet("background-color:rgb(19, 151, 213)");

        horizontalLayout.addWidget(pushButton_eliminar);

        pushButton_modificar = new QPushButton(layoutWidget_4);
        pushButton_modificar.setObjectName("pushButton_modificar");
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
        pushButton_modificar.setPalette(palette4);
        QFont font27 = new QFont();
        font27.setBold(true);
        font27.setWeight(75);
        pushButton_modificar.setFont(font27);
        pushButton_modificar.setStyleSheet("background-color:rgb(19, 151, 213)");

        horizontalLayout.addWidget(pushButton_modificar);

        pushButton_reservar = new QPushButton(layoutWidget_4);
        pushButton_reservar.setObjectName("pushButton_reservar");
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
        pushButton_reservar.setPalette(palette5);
        QFont font28 = new QFont();
        font28.setBold(true);
        font28.setWeight(75);
        pushButton_reservar.setFont(font28);
        pushButton_reservar.setStyleSheet("background-color:rgb(19, 151, 213)");

        horizontalLayout.addWidget(pushButton_reservar);

        pushButton_cancelar = new QPushButton(layoutWidget_4);
        pushButton_cancelar.setObjectName("pushButton_cancelar");
        QPalette palette6= new QPalette();
        palette6.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(0, 0, 0));
        palette6.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette6.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(0, 0, 0));
        palette6.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(0, 0, 0));
        palette6.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(0, 0, 0));
        palette6.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette6.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(0, 0, 0));
        palette6.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(0, 0, 0));
        palette6.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(0, 0, 0));
        palette6.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(120, 120, 120));
        palette6.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(0, 0, 0));
        palette6.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(0, 0, 0));
        pushButton_cancelar.setPalette(palette6);
        QFont font29 = new QFont();
        font29.setBold(true);
        font29.setWeight(75);
        pushButton_cancelar.setFont(font29);
        pushButton_cancelar.setStyleSheet("");

        horizontalLayout.addWidget(pushButton_cancelar);

        label_2 = new QLabel(Reservas);
        label_2.setObjectName("label_2");
        label_2.setGeometry(new QRect(440, 20, 111, 91));
        label_2.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        label_2.setAutoFillBackground(false);
        label_2.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.NoFrame);
        label_2.setPixmap(new QPixmap(("Logos/logo_size_invert.png")));
        label_2.setScaledContents(true);
        label_2.setWordWrap(false);
        label_Titulo = new QLabel(Reservas);
        label_Titulo.setObjectName("label_Titulo");
        label_Titulo.setGeometry(new QRect(20, 20, 181, 31));
        QFont font30 = new QFont();
        font30.setPointSize(15);
        font30.setBold(true);
        font30.setUnderline(true);
        font30.setWeight(75);
        label_Titulo.setFont(font30);
        label_Titulo.setStyleSheet("");
        groupBox_cliente = new QGroupBox(Reservas);
        groupBox_cliente.setObjectName("groupBox_cliente");
        groupBox_cliente.setEnabled(true);
        groupBox_cliente.setGeometry(new QRect(20, 60, 351, 91));
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
        groupBox_cliente.setPalette(palette7);
        QFont font31 = new QFont();
        font31.setPointSize(10);
        font31.setBold(true);
        font31.setWeight(75);
        groupBox_cliente.setFont(font31);
        groupBox_cliente.setStyleSheet("background-color:rgb(152,210,232)");
        comboBox = new QComboBox(groupBox_cliente);
        comboBox.setObjectName("comboBox");
        comboBox.setGeometry(new QRect(70, 20, 231, 22));
        QPalette palette8= new QPalette();
        palette8.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(152, 210, 232));
        palette8.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(152, 210, 232));
        palette8.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(152, 210, 232));
        palette8.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(152, 210, 232));
        palette8.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(152, 210, 232));
        palette8.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(152, 210, 232));
        palette8.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(152, 210, 232));
        palette8.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(152, 210, 232));
        palette8.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(152, 210, 232));
        comboBox.setPalette(palette8);
        label_clienteDNI = new QLabel(groupBox_cliente);
        label_clienteDNI.setObjectName("label_clienteDNI");
        label_clienteDNI.setGeometry(new QRect(10, 20, 77, 21));
        QFont font32 = new QFont();
        font32.setPointSize(8);
        font32.setBold(true);
        font32.setWeight(75);
        label_clienteDNI.setFont(font32);
        comboBox_2 = new QComboBox(groupBox_cliente);
        comboBox_2.setObjectName("comboBox_2");
        comboBox_2.setGeometry(new QRect(70, 50, 231, 22));
        QPalette palette9= new QPalette();
        palette9.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(152, 210, 232));
        palette9.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(152, 210, 232));
        palette9.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(152, 210, 232));
        palette9.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(152, 210, 232));
        palette9.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(152, 210, 232));
        palette9.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(152, 210, 232));
        palette9.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(152, 210, 232));
        palette9.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(152, 210, 232));
        palette9.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(152, 210, 232));
        comboBox_2.setPalette(palette9);
        label_cliente_reserva = new QLabel(groupBox_cliente);
        label_cliente_reserva.setObjectName("label_cliente_reserva");
        label_cliente_reserva.setGeometry(new QRect(10, 50, 77, 21));
        QFont font33 = new QFont();
        font33.setPointSize(8);
        font33.setBold(true);
        font33.setWeight(75);
        label_cliente_reserva.setFont(font33);
        groupBox_cliente_2 = new QGroupBox(Reservas);
        groupBox_cliente_2.setObjectName("groupBox_cliente_2");
        groupBox_cliente_2.setEnabled(true);
        groupBox_cliente_2.setGeometry(new QRect(10, 560, 551, 291));
        QPalette palette10= new QPalette();
        palette10.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.WindowText, new QColor(0, 0, 0));
        palette10.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Button, new QColor(152, 210, 232));
        palette10.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette10.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette10.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette10.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette10.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette10.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette10.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette10.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(152, 210, 232));
        palette10.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Window, new QColor(152, 210, 232));
        palette10.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette10.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.AlternateBase, new QColor(203, 232, 245));
        palette10.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette10.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette10.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.WindowText, new QColor(0, 0, 0));
        palette10.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Button, new QColor(152, 210, 232));
        palette10.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette10.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette10.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette10.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette10.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Text, new QColor(0, 0, 0));
        palette10.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette10.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ButtonText, new QColor(0, 0, 0));
        palette10.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(152, 210, 232));
        palette10.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Window, new QColor(152, 210, 232));
        palette10.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette10.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.AlternateBase, new QColor(203, 232, 245));
        palette10.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette10.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        palette10.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.WindowText, new QColor(76, 105, 118));
        palette10.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Button, new QColor(152, 210, 232));
        palette10.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Light, new QColor(255, 255, 255));
        palette10.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Midlight, new QColor(203, 232, 245));
        palette10.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Dark, new QColor(76, 105, 118));
        palette10.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Mid, new QColor(101, 140, 157));
        palette10.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Text, new QColor(76, 105, 118));
        palette10.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.BrightText, new QColor(255, 255, 255));
        palette10.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ButtonText, new QColor(76, 105, 118));
        palette10.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Base, new QColor(152, 210, 232));
        palette10.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Window, new QColor(152, 210, 232));
        palette10.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.Shadow, new QColor(0, 0, 0));
        palette10.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.AlternateBase, new QColor(152, 210, 236));
        palette10.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipBase, new QColor(255, 255, 220));
        palette10.setColor(QPalette.ColorGroup.Disabled, QPalette.ColorRole.ToolTipText, new QColor(0, 0, 0));
        groupBox_cliente_2.setPalette(palette10);
        QFont font34 = new QFont();
        font34.setPointSize(10);
        font34.setBold(true);
        font34.setWeight(75);
        groupBox_cliente_2.setFont(font34);
        groupBox_cliente_2.setStyleSheet("background-color:rgb(152,210,232)");
        listView_Reservas = new QListView(groupBox_cliente_2);
        listView_Reservas.setObjectName("listView_Reservas");
        listView_Reservas.setGeometry(new QRect(10, 20, 531, 261));
        label_Numero.setBuddy(spinBox_NumeroHabitacion);
        label_Tipo.setBuddy(radioButton_Individual);
        label_ImporteNoche.setBuddy(lineEdit_ImporteNoche);
        label_Direccion_2.setBuddy(dateEdit_FechaFin);
        label_FechaInicio.setBuddy(dateEdit_FechaInicio);
        label_Nombre_2.setBuddy(lineEdit_Importe);
        label_clienteDNI.setBuddy(dateEdit_FechaInicio);
        label_cliente_reserva.setBuddy(dateEdit_FechaInicio);
        retranslateUi(Reservas);

        Reservas.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog Reservas)
    {
        Reservas.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Reservas", null));
        groupBox_Reservas.setTitle(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Reserva", null));
        groupBox_2.setTitle(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Habitaci\u00f3n", null));
        label_Numero.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "N\u00famero:", null));
        label_Tipo.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Tipo:", null));
        radioButton_Doble.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Doble", null));
        radioButton_Individual.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Individual", null));
        lineEdit_ImporteNoche.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Introduzca su tel\u00e9fono", null));
        lineEdit_ImporteNoche.setPlaceholderText("");
        label_ImporteNoche.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Importe noche:", null));
        radioButton_Familiar.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Familiar", null));
        radioButton_Suite.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Suite", null));
        radioButton_GranSuite.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Gran Suite", null));
        groupBox_3.setTitle(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Caracter\u00edsticas", null));
        checkBox_Jacuzzi.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Jacuzzi", null));
        checkBox_WiFi.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Wi-Fi", null));
        checkBox_Bar.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Mini bar", null));
        checkBox_Aire.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Aire acond", null));
        label_Cama.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Cama:", null));
        radioButton_CamaIndividual.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Individual", null));
        checkBox_Luminosa.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Luminosa", null));
        checkBox_Banera.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Ba\u00f1era", null));
        checkBox_Tele.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Televisi\u00f3n", null));
        checkBox_Terraza.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Terraza", null));
        checkBox_Cafe.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Cafetera", null));
        radioButton_CamaMatrimonio.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Matrimonio", null));
        radioButton_CamaKing.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "KingSize", null));
        label_Direccion_2.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Fecha fin:", null));
        label_FechaInicio.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Fecha inicio:", null));
        lineEdit_Importe.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Introduzca su Nombre", null));
        label_Nombre_2.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Importe Total:", null));
        pushButton_eliminar.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Elliminar", null));
        pushButton_modificar.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Modificar", null));
        pushButton_reservar.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Reservar", null));
        pushButton_cancelar.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Cancelar", null));
        label_2.setText("");
        label_Titulo.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Gesti\u00f3n reservas", null));
        groupBox_cliente.setTitle(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Cliente", null));
        label_clienteDNI.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "DNI", null));
        comboBox_2.clear();
        comboBox_2.addItem(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "1", null));
        label_cliente_reserva.setText(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Reserva", null));
        groupBox_cliente_2.setTitle(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Lista de reservas", null));
        listView_Reservas.setToolTip(com.trolltech.qt.core.QCoreApplication.translate("Reservas", "Lista de reservas", null));
    } // retranslateUi

}

