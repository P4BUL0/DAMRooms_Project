/********************************************************************************
 ** Form generated from reading ui file 'MainWindow.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.6
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package interfazrooms;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Ui_MainWindow implements com.trolltech.qt.QUiForm<QDialog>
{
    public QWidget layoutWidget;
    public QGridLayout gridLayout;
    public QPushButton pushButton_mainReserva;
    public QPushButton pushButton_mainSalir;
    public QPushButton pushButton_mainHabitacion;
    public QPushButton pushButton_mainCliente;
    public QLabel label_Logo;

    public Ui_MainWindow() { super(); }
    
    void abrirReserva(){
        Ui_Reservas reservas = new Ui_Reservas();
        QDialog dialog = new QDialog();
        reservas.setupUi(dialog);
        dialog.setModal(true);
        dialog.show();
    }
    
    void abrirCliente(){
        Ui_Cliente clientes = new Ui_Cliente();
        QDialog dialog = new QDialog();
        clientes.setupUi(dialog);
        dialog.setModal(true);
        dialog.show();
    }
    
    void abrirHabitacion(){
        Ui_Habitaciones habitaciones = new Ui_Habitaciones();
        QDialog dialog = new QDialog();
        habitaciones.setupUi(dialog);
        dialog.setModal(true);
        dialog.show();
    }           

    public void setupUi(QDialog MainWindow){
        MainWindow.setObjectName("MainWindow");
        MainWindow.resize(new QSize(378, 362).expandedTo(MainWindow.minimumSizeHint()));
        MainWindow.setWindowIcon(new QIcon(new QPixmap("Resources/Logos/logo_Icon.png")));
        layoutWidget = new QWidget(MainWindow);
        layoutWidget.setObjectName("layoutWidget");
        layoutWidget.setGeometry(new QRect(10, 120, 351, 220));
        gridLayout = new QGridLayout(layoutWidget);
        gridLayout.setObjectName("gridLayout");
        pushButton_mainReserva = new QPushButton(layoutWidget);
        pushButton_mainReserva.setObjectName("pushButton_mainReserva");
        pushButton_mainReserva.setMinimumSize(new QSize(300, 50));
        pushButton_mainReserva.setMaximumSize(new QSize(16777215, 16777215));
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
        palette.setColor(QPalette.ColorGroup.Active, QPalette.ColorRole.Base, new QColor(152, 210, 236));
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
        palette.setColor(QPalette.ColorGroup.Inactive, QPalette.ColorRole.Base, new QColor(152, 210, 236));
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
        pushButton_mainReserva.setPalette(palette);
        QFont font = new QFont();
        font.setBold(true);
        font.setWeight(75);
        pushButton_mainReserva.setFont(font);
        pushButton_mainReserva.setStyleSheet("background-color:rgb(152, 210, 236)");
        pushButton_mainReserva.setIcon(new QIcon(new QPixmap("Resources/Iconos/Reservar.png")));

        gridLayout.addWidget(pushButton_mainReserva, 0, 0, 1, 1);

        pushButton_mainSalir = new QPushButton(layoutWidget);
        pushButton_mainSalir.setObjectName("pushButton_mainSalir");
        pushButton_mainSalir.setMinimumSize(new QSize(300, 50));
        pushButton_mainSalir.setMaximumSize(new QSize(100, 16777215));
        QFont font1 = new QFont();
        font1.setBold(true);
        font1.setWeight(75);
        pushButton_mainSalir.setFont(font1);
        pushButton_mainSalir.setStyleSheet("background-color:rgb(152, 210, 236)");
        pushButton_mainSalir.setIcon(new QIcon(new QPixmap("Resources/Iconos/Salir.png")));

        gridLayout.addWidget(pushButton_mainSalir, 4, 0, 1, 1);

        pushButton_mainHabitacion = new QPushButton(layoutWidget);
        pushButton_mainHabitacion.setObjectName("pushButton_mainHabitacion");
        pushButton_mainHabitacion.setMinimumSize(new QSize(300, 50));
        pushButton_mainHabitacion.setMaximumSize(new QSize(100, 16777215));
        QFont font2 = new QFont();
        font2.setBold(true);
        font2.setWeight(75);
        pushButton_mainHabitacion.setFont(font2);
        pushButton_mainHabitacion.setStyleSheet("background-color:rgb(152, 210, 236)");
        pushButton_mainHabitacion.setIcon(new QIcon(new QPixmap("Resources/Iconos/Habitaci\u00f3n.png")));

        gridLayout.addWidget(pushButton_mainHabitacion, 3, 0, 1, 1);

        pushButton_mainCliente = new QPushButton(layoutWidget);
        pushButton_mainCliente.setObjectName("pushButton_mainCliente");
        pushButton_mainCliente.setMinimumSize(new QSize(300, 50));
        pushButton_mainCliente.setMaximumSize(new QSize(100, 16777215));
        QFont font3 = new QFont();
        font3.setBold(true);
        font3.setWeight(75);
        pushButton_mainCliente.setFont(font3);
        pushButton_mainCliente.setStyleSheet("background-color:rgb(152, 210, 236)");
        pushButton_mainCliente.setIcon(new QIcon(new QPixmap("Resources/Iconos/Cliente.png")));

        gridLayout.addWidget(pushButton_mainCliente, 2, 0, 1, 1);

        label_Logo = new QLabel(MainWindow);
        label_Logo.setObjectName("label_Logo");
        label_Logo.setGeometry(new QRect(130, 10, 111, 91));
        label_Logo.setLayoutDirection(com.trolltech.qt.core.Qt.LayoutDirection.LeftToRight);
        label_Logo.setAutoFillBackground(false);
        label_Logo.setFrameShape(com.trolltech.qt.gui.QFrame.Shape.NoFrame);
        label_Logo.setPixmap(new QPixmap(("Resources/Logos/logo_size_invert.png")));
        label_Logo.setScaledContents(true);
        label_Logo.setWordWrap(false);
        QWidget.setTabOrder(pushButton_mainReserva, pushButton_mainCliente);
        QWidget.setTabOrder(pushButton_mainCliente, pushButton_mainHabitacion);
        QWidget.setTabOrder(pushButton_mainHabitacion, pushButton_mainSalir);
        retranslateUi(MainWindow);
        
        pushButton_mainReserva.clicked.connect(this, "abrirReserva()");
        pushButton_mainCliente.clicked.connect(this, "abrirCliente()");
        pushButton_mainHabitacion.clicked.connect(this, "abrirHabitacion()");
        pushButton_mainSalir.clicked.connect(MainWindow, "close()");

        MainWindow.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog MainWindow)
    {
        MainWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Men\u00fa", null));
        pushButton_mainReserva.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Reserva", null));
        pushButton_mainSalir.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Salir", null));
        pushButton_mainHabitacion.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Habitaci\u00f3n", null));
        pushButton_mainCliente.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Cliente", null));
        label_Logo.setText("");
    } // retranslateUi

}

