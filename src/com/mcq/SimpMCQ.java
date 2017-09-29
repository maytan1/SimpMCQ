/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcq;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.UnsupportedLookAndFeelException;
import static javax.swing.filechooser.FileSystemView.getFileSystemView;

/**
 *
 * @author TanmayDesigns
 */
public class SimpMCQ extends javax.swing.JFrame {

    Timer timer = new Timer(1000,null);
    TimerListener listener = new TimerListener();
    int count = 10800;
    String dbName = null;
    String dbNameCrt = null;
    int score = 0;
    short answers[] = new short[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public class TimerListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if(count==0){
                timer.stop();
                lblCountdown.setText("00:00");
                btnPrevious.setEnabled(false);
                btnNext.setEnabled(false);
                int result = checkAnswers();
                JOptionPane.showMessageDialog(null, "Your score is " + result + ". Thanks for taking this test.", "Result", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                count--;
                int mm = count/60;
                int ss = count-mm*60;
                lblCountdown.setText(mm+":"+ss);
            }
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Methods">
    // <editor-fold defaultstate="collapsed" desc="connect">
    public Connection connect() {
        Connection c = null;
        if (dbName == null) {
            JOptionPane.showMessageDialog(menItmOpen, "You have not selected any Tests. Please select a Test from File\\Open to continue.", "Test Not Selected", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:" + dbName);
            } catch (ClassNotFoundException | SQLException cnfe) {
                JOptionPane.showMessageDialog(this, "Error Code: 01\nReport this error by e-mail. See Help\\About Us for details", "Error in Connection", JOptionPane.ERROR_MESSAGE);
            }
        }
        return c;
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="DoNotSee-Ugly">
    public void processQPanel() {
        short i = getCurrentQNo();
        if (answers[i] != 0) {
            switch (i) {
                case 1:
                    btnQ1.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 2:
                    btnQ2.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 3:
                    btnQ3.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 4:
                    btnQ4.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 5:
                    btnQ5.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 6:
                    btnQ6.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 7:
                    btnQ7.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 8:
                    btnQ8.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 9:
                    btnQ9.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 10:
                    btnQ10.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 11:
                    btnQ11.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 12:
                    btnQ12.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 13:
                    btnQ13.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 14:
                    btnQ14.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 15:
                    btnQ15.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 16:
                    btnQ16.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 17:
                    btnQ17.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 18:
                    btnQ18.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 19:
                    btnQ19.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 20:
                    btnQ20.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 21:
                    btnQ21.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 22:
                    btnQ22.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 23:
                    btnQ23.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 24:
                    btnQ24.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 25:
                    btnQ25.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 26:
                    btnQ26.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 27:
                    btnQ27.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 28:
                    btnQ28.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 29:
                    btnQ29.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 30:
                    btnQ30.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 31:
                    btnQ31.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 32:
                    btnQ32.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 33:
                    btnQ33.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 34:
                    btnQ34.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 35:
                    btnQ35.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 36:
                    btnQ36.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 37:
                    btnQ37.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 38:
                    btnQ38.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 39:
                    btnQ39.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 40:
                    btnQ40.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 41:
                    btnQ41.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 42:
                    btnQ42.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 43:
                    btnQ43.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 44:
                    btnQ44.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 45:
                    btnQ45.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 46:
                    btnQ46.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 47:
                    btnQ47.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 48:
                    btnQ48.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 49:
                    btnQ49.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 50:
                    btnQ50.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 51:
                    btnQ51.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 52:
                    btnQ52.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 53:
                    btnQ53.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 54:
                    btnQ54.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 55:
                    btnQ55.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 56:
                    btnQ56.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 57:
                    btnQ57.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 58:
                    btnQ58.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 59:
                    btnQ59.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 60:
                    btnQ60.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 61:
                    btnQ61.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 62:
                    btnQ62.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 63:
                    btnQ63.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 64:
                    btnQ64.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 65:
                    btnQ65.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 66:
                    btnQ66.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 67:
                    btnQ67.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 68:
                    btnQ68.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 69:
                    btnQ69.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 70:
                    btnQ70.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 71:
                    btnQ71.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 72:
                    btnQ72.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 73:
                    btnQ73.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 74:
                    btnQ74.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 75:
                    btnQ75.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 76:
                    btnQ76.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 77:
                    btnQ77.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 78:
                    btnQ78.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 79:
                    btnQ79.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 80:
                    btnQ80.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 81:
                    btnQ81.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 82:
                    btnQ82.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 83:
                    btnQ83.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 84:
                    btnQ84.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 85:
                    btnQ85.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 86:
                    btnQ86.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 87:
                    btnQ87.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 88:
                    btnQ88.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 89:
                    btnQ89.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
                case 90:
                    btnQ90.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
                    break;
            }
        } else {
            switch (i) {
                case 1:
                    btnQ1.setBackground(Color.RED);
                    break;
                case 2:
                    btnQ2.setBackground(Color.RED);
                    break;
                case 3:
                    btnQ3.setBackground(Color.RED);
                    break;
                case 4:
                    btnQ4.setBackground(Color.RED);
                    break;
                case 5:
                    btnQ5.setBackground(Color.RED);
                    break;
                case 6:
                    btnQ6.setBackground(Color.RED);
                    break;
                case 7:
                    btnQ7.setBackground(Color.RED);
                    break;
                case 8:
                    btnQ8.setBackground(Color.RED);
                    break;
                case 9:
                    btnQ9.setBackground(Color.RED);
                    break;
                case 10:
                    btnQ10.setBackground(Color.RED);
                    break;
                case 11:
                    btnQ11.setBackground(Color.RED);
                    break;
                case 12:
                    btnQ12.setBackground(Color.RED);
                    break;
                case 13:
                    btnQ13.setBackground(Color.RED);
                    break;
                case 14:
                    btnQ14.setBackground(Color.RED);
                    break;
                case 15:
                    btnQ15.setBackground(Color.RED);
                    break;
                case 16:
                    btnQ16.setBackground(Color.RED);
                    break;
                case 17:
                    btnQ17.setBackground(Color.RED);
                    break;
                case 18:
                    btnQ18.setBackground(Color.RED);
                    break;
                case 19:
                    btnQ19.setBackground(Color.RED);
                    break;
                case 20:
                    btnQ20.setBackground(Color.RED);
                    break;
                case 21:
                    btnQ21.setBackground(Color.RED);
                    break;
                case 22:
                    btnQ22.setBackground(Color.RED);
                    break;
                case 23:
                    btnQ23.setBackground(Color.RED);
                    break;
                case 24:
                    btnQ24.setBackground(Color.RED);
                    break;
                case 25:
                    btnQ25.setBackground(Color.RED);
                    break;
                case 26:
                    btnQ26.setBackground(Color.RED);
                    break;
                case 27:
                    btnQ27.setBackground(Color.RED);
                    break;
                case 28:
                    btnQ28.setBackground(Color.RED);
                    break;
                case 29:
                    btnQ29.setBackground(Color.RED);
                    break;
                case 30:
                    btnQ30.setBackground(Color.RED);
                    break;
                case 31:
                    btnQ31.setBackground(Color.RED);
                    break;
                case 32:
                    btnQ32.setBackground(Color.RED);
                    break;
                case 33:
                    btnQ33.setBackground(Color.RED);
                    break;
                case 34:
                    btnQ34.setBackground(Color.RED);
                    break;
                case 35:
                    btnQ35.setBackground(Color.RED);
                    break;
                case 36:
                    btnQ36.setBackground(Color.RED);
                    break;
                case 37:
                    btnQ37.setBackground(Color.RED);
                    break;
                case 38:
                    btnQ38.setBackground(Color.RED);
                    break;
                case 39:
                    btnQ39.setBackground(Color.RED);
                    break;
                case 40:
                    btnQ40.setBackground(Color.RED);
                    break;
                case 41:
                    btnQ41.setBackground(Color.RED);
                    break;
                case 42:
                    btnQ42.setBackground(Color.RED);
                    break;
                case 43:
                    btnQ43.setBackground(Color.RED);
                    break;
                case 44:
                    btnQ44.setBackground(Color.RED);
                    break;
                case 45:
                    btnQ45.setBackground(Color.RED);
                    break;
                case 46:
                    btnQ46.setBackground(Color.RED);
                    break;
                case 47:
                    btnQ47.setBackground(Color.RED);
                    break;
                case 48:
                    btnQ48.setBackground(Color.RED);
                    break;
                case 49:
                    btnQ49.setBackground(Color.RED);
                    break;
                case 50:
                    btnQ50.setBackground(Color.RED);
                    break;
                case 51:
                    btnQ51.setBackground(Color.RED);
                    break;
                case 52:
                    btnQ52.setBackground(Color.RED);
                    break;
                case 53:
                    btnQ53.setBackground(Color.RED);
                    break;
                case 54:
                    btnQ54.setBackground(Color.RED);
                    break;
                case 55:
                    btnQ55.setBackground(Color.RED);
                    break;
                case 56:
                    btnQ56.setBackground(Color.RED);
                    break;
                case 57:
                    btnQ57.setBackground(Color.RED);
                    break;
                case 58:
                    btnQ58.setBackground(Color.RED);
                    break;
                case 59:
                    btnQ59.setBackground(Color.RED);
                    break;
                case 60:
                    btnQ60.setBackground(Color.RED);
                    break;
                case 61:
                    btnQ61.setBackground(Color.RED);
                    break;
                case 62:
                    btnQ62.setBackground(Color.RED);
                    break;
                case 63:
                    btnQ63.setBackground(Color.RED);
                    break;
                case 64:
                    btnQ64.setBackground(Color.RED);
                    break;
                case 65:
                    btnQ65.setBackground(Color.RED);
                    break;
                case 66:
                    btnQ66.setBackground(Color.RED);
                    break;
                case 67:
                    btnQ67.setBackground(Color.RED);
                    break;
                case 68:
                    btnQ68.setBackground(Color.RED);
                    break;
                case 69:
                    btnQ69.setBackground(Color.RED);
                    break;
                case 70:
                    btnQ70.setBackground(Color.RED);
                    break;
                case 71:
                    btnQ71.setBackground(Color.RED);
                    break;
                case 72:
                    btnQ72.setBackground(Color.RED);
                    break;
                case 73:
                    btnQ73.setBackground(Color.RED);
                    break;
                case 74:
                    btnQ74.setBackground(Color.RED);
                    break;
                case 75:
                    btnQ75.setBackground(Color.RED);
                    break;
                case 76:
                    btnQ76.setBackground(Color.RED);
                    break;
                case 77:
                    btnQ77.setBackground(Color.RED);
                    break;
                case 78:
                    btnQ78.setBackground(Color.RED);
                    break;
                case 79:
                    btnQ79.setBackground(Color.RED);
                    break;
                case 80:
                    btnQ80.setBackground(Color.RED);
                    break;
                case 81:
                    btnQ81.setBackground(Color.RED);
                    break;
                case 82:
                    btnQ82.setBackground(Color.RED);
                    break;
                case 83:
                    btnQ83.setBackground(Color.RED);
                    break;
                case 84:
                    btnQ84.setBackground(Color.RED);
                    break;
                case 85:
                    btnQ85.setBackground(Color.RED);
                    break;
                case 86:
                    btnQ86.setBackground(Color.RED);
                    break;
                case 87:
                    btnQ87.setBackground(Color.RED);
                    break;
                case 88:
                    btnQ88.setBackground(Color.RED);
                    break;
                case 89:
                    btnQ89.setBackground(Color.RED);
                    break;
                case 90:
                    btnQ90.setBackground(Color.RED);
                    break;
            }
        }
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="checkdbNameVar">
    public boolean checkdbNameVar() {
        return (dbName == null);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="checkdbNameCrtVar">
    public boolean checkdbNameCrtVar() {
        return (dbNameCrt == null);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CurrentQuestionNo">
    public short getCurrentQNo() {
        short no = Short.parseShort(txtId.getText());
        return no;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="ProcessAnswer">
    public void setAnswer() {
        short no = getCurrentQNo();
        Short ans;
        if (rdbOpt1.isSelected()) {
            ans = 1;
        } else if (rdbOpt2.isSelected()) {
            ans = 2;
        } else if (rdbOpt3.isSelected()) {
            ans = 3;
        } else if (rdbOpt4.isSelected()) {
            ans = 4;
        } else {
            ans = 0;
        }
        answers[no] = ans;
    } // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="getQuestion">
    public String[] getQuestion(short i) {
        short ans = answers[i];
        if (ans != 0) {
            switch (ans) {
                case 1:
                    rdbOpt1.setSelected(true);
                    break;
                case 2:
                    rdbOpt2.setSelected(true);
                    break;
                case 3:
                    rdbOpt3.setSelected(true);
                    break;
                case 4:
                    rdbOpt4.setSelected(true);
                    break;
            }
        }
        Connection c = connect();
        Statement stm;
        ResultSet rs;
        try {
            stm = c.createStatement();
            rs = stm.executeQuery("SELECT * FROM questions WHERE id = " + i);
            rs.next();
            String result[] = new String[]{rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)};
            return result;
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(menItmOpen, "Error Code: 02\nContact your Test creater for help with this test.", "Damaged Test", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="setQuestion">
    public void setQuestion(short n) {
        String q[] = getQuestion(n);
        if (q != null) {
            txtAreaQuestion.setText(q[0]);
            txtAreaOpt1.setText(q[1]);
            txtAreaOpt2.setText(q[2]);
            txtAreaOpt3.setText(q[3]);
            txtAreaOpt4.setText(q[4]);
            txtId.setText("" + n);
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="checkAnwer">
    public int checkAnswers() {
        try {
            Connection c = connect();
            Statement stm = c.createStatement();
            System.out.println("Answers\nRight Answer - Your Answer");
            for (int i = 1; i < 91; i++) {
                String sql = "SELECT answer FROM answers WHERE id = " + i;
                ResultSet rs = stm.executeQuery(sql);
                rs.next();
                short ag = answers[i];
                short ar = rs.getShort(1);
                System.out.println(ar + "           -  " + ag);
                if (ag != 0) {
                    if (ag == ar) {
                        score = score + 4;
                    } else {
                        score = score - 1;
                    }
                }
            }
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "Answers not found in Test Pack \"" + dbName + "\"", "Answers Missing", JOptionPane.ERROR_MESSAGE);
        }
        return score;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="hideWelcome">
    public void hideWelcome() {
        btnStartTest.setVisible(false);
        btnCreateTest.setVisible(false);
        lblWelcome.setVisible(false);
        btnExit.setVisible(false);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="clearAllifTest">
    public void clearAllifTest() {
        txtId.setText("0");
        txtAreaQuestion.setText("");
        txtAreaOpt1.setText("");
        txtAreaOpt2.setText("");
        txtAreaOpt3.setText("");
        txtAreaOpt4.setText("");
        btnGrpOptions.clearSelection();
        for (int i = 1; i < 91; i++) {
            answers[i] = 0;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="clearAllifCreate">
    public void clearAllifCreate() {
        txtIdC.setText("0");
        txtAreaQuestionC.setText("");
        txtAreaOptC1.setText("");
        txtAreaOptC2.setText("");
        txtAreaOptC3.setText("");
        txtAreaOptC4.setText("");
        btnGrpOptionsC.clearSelection();
    }
    // </editor-fold>

    // </editor-fold>
    /**
     * Creates new form SimpMCQ
     */
    public SimpMCQ() {
        initComponents();
        // <editor-fold defaultstate="collapsed" desc="Adding Panel Handlers">
        btnQ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ76.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ78.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ79.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ80.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ81.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ82.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ83.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ84.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ85.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ86.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ87.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ88.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ89.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        btnQ90.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQPanelControl(evt);
            }
        });
        // </editor-fold>
        timer = new Timer(1000,listener);
        timer.setRepeats(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGrpOptions = new javax.swing.ButtonGroup();
        btnGrpOptionsC = new javax.swing.ButtonGroup();
        fileChsOpen = new javax.swing.JFileChooser();
        btnGrpThemes = new javax.swing.ButtonGroup();
        dlgAbout = new javax.swing.JDialog();
        lblAboutImg = new javax.swing.JLabel();
        lblAbout1 = new javax.swing.JLabel();
        lblAbout2 = new javax.swing.JLabel();
        lblAbout3 = new javax.swing.JLabel();
        lblAbout4 = new javax.swing.JLabel();
        lblApacheLicenceURI = new javax.swing.JLabel();
        lblAbout5 = new javax.swing.JLabel();
        lblWebsiteURI = new javax.swing.JLabel();
        lblAbout6 = new javax.swing.JLabel();
        lblEMailURI = new javax.swing.JLabel();
        scrlSystemDesc = new javax.swing.JScrollPane();
        txtAreaAbout = new javax.swing.JTextArea();
        btnAbouClose = new javax.swing.JButton();
        dlgHowTo = new javax.swing.JDialog();
        scrlHowTo = new javax.swing.JScrollPane();
        txtAreaHowTo = new javax.swing.JTextArea();
        btnCloseHowTo = new javax.swing.JButton();
        dlgFont = new javax.swing.JDialog();
        lblFont = new javax.swing.JLabel();
        cmbFont = new javax.swing.JComboBox();
        btnOk = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        ifTest = new javax.swing.JInternalFrame();
        lblId = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        scrlQuestion = new javax.swing.JScrollPane();
        txtAreaQuestion = new javax.swing.JTextArea();
        rdbOpt1 = new javax.swing.JRadioButton();
        rdbOpt2 = new javax.swing.JRadioButton();
        rdbOpt3 = new javax.swing.JRadioButton();
        rdbOpt4 = new javax.swing.JRadioButton();
        scrlOpt1 = new javax.swing.JScrollPane();
        txtAreaOpt1 = new javax.swing.JTextArea();
        scrlOpt2 = new javax.swing.JScrollPane();
        txtAreaOpt2 = new javax.swing.JTextArea();
        scrlOpt3 = new javax.swing.JScrollPane();
        txtAreaOpt3 = new javax.swing.JTextArea();
        scrlOpt4 = new javax.swing.JScrollPane();
        txtAreaOpt4 = new javax.swing.JTextArea();
        btnPrevious = new javax.swing.JButton();
        btnFinish = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnStart = new javax.swing.JButton();
        pnlQuesControl = new javax.swing.JPanel();
        lblPhy = new javax.swing.JLabel();
        lblMath = new javax.swing.JLabel();
        lblChem = new javax.swing.JLabel();
        btnQ1 = new javax.swing.JButton();
        btnQ2 = new javax.swing.JButton();
        btnQ3 = new javax.swing.JButton();
        btnQ4 = new javax.swing.JButton();
        btnQ5 = new javax.swing.JButton();
        btnQ6 = new javax.swing.JButton();
        btnQ7 = new javax.swing.JButton();
        btnQ8 = new javax.swing.JButton();
        btnQ9 = new javax.swing.JButton();
        btnQ10 = new javax.swing.JButton();
        btnQ11 = new javax.swing.JButton();
        btnQ12 = new javax.swing.JButton();
        btnQ13 = new javax.swing.JButton();
        btnQ14 = new javax.swing.JButton();
        btnQ15 = new javax.swing.JButton();
        btnQ16 = new javax.swing.JButton();
        btnQ17 = new javax.swing.JButton();
        btnQ18 = new javax.swing.JButton();
        btnQ19 = new javax.swing.JButton();
        btnQ20 = new javax.swing.JButton();
        btnQ21 = new javax.swing.JButton();
        btnQ22 = new javax.swing.JButton();
        btnQ23 = new javax.swing.JButton();
        btnQ24 = new javax.swing.JButton();
        btnQ25 = new javax.swing.JButton();
        btnQ26 = new javax.swing.JButton();
        btnQ27 = new javax.swing.JButton();
        btnQ28 = new javax.swing.JButton();
        btnQ29 = new javax.swing.JButton();
        btnQ30 = new javax.swing.JButton();
        btnQ31 = new javax.swing.JButton();
        btnQ32 = new javax.swing.JButton();
        btnQ33 = new javax.swing.JButton();
        btnQ34 = new javax.swing.JButton();
        btnQ35 = new javax.swing.JButton();
        btnQ36 = new javax.swing.JButton();
        btnQ37 = new javax.swing.JButton();
        btnQ38 = new javax.swing.JButton();
        btnQ39 = new javax.swing.JButton();
        btnQ40 = new javax.swing.JButton();
        btnQ41 = new javax.swing.JButton();
        btnQ42 = new javax.swing.JButton();
        btnQ43 = new javax.swing.JButton();
        btnQ44 = new javax.swing.JButton();
        btnQ45 = new javax.swing.JButton();
        btnQ46 = new javax.swing.JButton();
        btnQ47 = new javax.swing.JButton();
        btnQ48 = new javax.swing.JButton();
        btnQ49 = new javax.swing.JButton();
        btnQ50 = new javax.swing.JButton();
        btnQ51 = new javax.swing.JButton();
        btnQ52 = new javax.swing.JButton();
        btnQ53 = new javax.swing.JButton();
        btnQ54 = new javax.swing.JButton();
        btnQ55 = new javax.swing.JButton();
        btnQ56 = new javax.swing.JButton();
        btnQ57 = new javax.swing.JButton();
        btnQ58 = new javax.swing.JButton();
        btnQ59 = new javax.swing.JButton();
        btnQ60 = new javax.swing.JButton();
        btnQ61 = new javax.swing.JButton();
        btnQ62 = new javax.swing.JButton();
        btnQ63 = new javax.swing.JButton();
        btnQ64 = new javax.swing.JButton();
        btnQ65 = new javax.swing.JButton();
        btnQ66 = new javax.swing.JButton();
        btnQ67 = new javax.swing.JButton();
        btnQ68 = new javax.swing.JButton();
        btnQ69 = new javax.swing.JButton();
        btnQ70 = new javax.swing.JButton();
        btnQ71 = new javax.swing.JButton();
        btnQ72 = new javax.swing.JButton();
        btnQ73 = new javax.swing.JButton();
        btnQ74 = new javax.swing.JButton();
        btnQ75 = new javax.swing.JButton();
        btnQ76 = new javax.swing.JButton();
        btnQ77 = new javax.swing.JButton();
        btnQ78 = new javax.swing.JButton();
        btnQ79 = new javax.swing.JButton();
        btnQ80 = new javax.swing.JButton();
        btnQ81 = new javax.swing.JButton();
        btnQ82 = new javax.swing.JButton();
        btnQ83 = new javax.swing.JButton();
        btnQ84 = new javax.swing.JButton();
        btnQ85 = new javax.swing.JButton();
        btnQ86 = new javax.swing.JButton();
        btnQ87 = new javax.swing.JButton();
        btnQ88 = new javax.swing.JButton();
        btnQ89 = new javax.swing.JButton();
        btnQ90 = new javax.swing.JButton();
        pnlLegend = new javax.swing.JPanel();
        btnMarked = new javax.swing.JButton();
        btnUnmarked = new javax.swing.JButton();
        btnUnseen = new javax.swing.JButton();
        lblMarked = new javax.swing.JLabel();
        lblMarked1 = new javax.swing.JLabel();
        lblMarked2 = new javax.swing.JLabel();
        lblCountdown = new javax.swing.JLabel();
        ifCreate = new javax.swing.JInternalFrame();
        lblIdC = new javax.swing.JLabel();
        txtIdC = new javax.swing.JTextField();
        scrlQuestionC = new javax.swing.JScrollPane();
        txtAreaQuestionC = new javax.swing.JTextArea();
        rdbOptC1 = new javax.swing.JRadioButton();
        rdbOptC2 = new javax.swing.JRadioButton();
        rdbOptC3 = new javax.swing.JRadioButton();
        rdbOptC4 = new javax.swing.JRadioButton();
        scrlOptC1 = new javax.swing.JScrollPane();
        txtAreaOptC1 = new javax.swing.JTextArea();
        scrlOptC2 = new javax.swing.JScrollPane();
        txtAreaOptC2 = new javax.swing.JTextArea();
        scrlOptC3 = new javax.swing.JScrollPane();
        txtAreaOptC3 = new javax.swing.JTextArea();
        scrlOptC4 = new javax.swing.JScrollPane();
        txtAreaOptC4 = new javax.swing.JTextArea();
        btnSet = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        lblWelcome = new javax.swing.JLabel();
        btnStartTest = new javax.swing.JButton();
        btnCreateTest = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        lblWelcomePic = new javax.swing.JLabel();
        menuBarMain = new javax.swing.JMenuBar();
        menFile = new javax.swing.JMenu();
        menItmOpen = new javax.swing.JMenuItem();
        menItmCrtTests = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menItmExit = new javax.swing.JMenuItem();
        menOptions = new javax.swing.JMenu();
        menTheme = new javax.swing.JMenu();
        rdbMenBlackMoon = new javax.swing.JRadioButtonMenuItem();
        rdbMenBlueIce = new javax.swing.JRadioButtonMenuItem();
        rdbMenBlueMoon = new javax.swing.JRadioButtonMenuItem();
        rdbMenGreenDream = new javax.swing.JRadioButtonMenuItem();
        rdbMenOrangeMetallic = new javax.swing.JRadioButtonMenuItem();
        rdbMenMetal = new javax.swing.JRadioButtonMenuItem();
        rdbMenNimbus = new javax.swing.JRadioButtonMenuItem();
        rdbMenWindows = new javax.swing.JRadioButtonMenuItem();
        menItmFont = new javax.swing.JMenuItem();
        menHelp = new javax.swing.JMenu();
        menItmHowToGiveTest = new javax.swing.JMenuItem();
        menItmAbout = new javax.swing.JMenuItem();

        fileChsOpen.setApproveButtonToolTipText("");
        fileChsOpen.setCurrentDirectory(new java.io.File(getFileSystemView().getDefaultDirectory().getAbsolutePath()+"\\SimpTests\\"));
            fileChsOpen.setDialogTitle("Open Test");
            fileChsOpen.setFileFilter(new FileNameExtensionFilter("SimpMCQ Tests","smt"));

            dlgAbout.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            dlgAbout.setTitle("About");
            dlgAbout.setAlwaysOnTop(true);
            dlgAbout.setBounds(new java.awt.Rectangle(250, 50, 450, 510));
            dlgAbout.setPreferredSize(new java.awt.Dimension(450, 510));
            dlgAbout.setResizable(false);
            dlgAbout.setType(java.awt.Window.Type.POPUP);

            lblAboutImg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblAboutImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/SplashAbout.jpg"))); // NOI18N

            lblAbout1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
            lblAbout1.setText("SimpMCQ is a Free and Open Source application");

            lblAbout2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
            lblAbout2.setText("which helps in practicing for JEE (Main) at home");

            lblAbout3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
            lblAbout3.setText("It is a product of TanmayDesigns and is licensed");

            lblAbout4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
            lblAbout4.setText("under ");

            lblApacheLicenceURI.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
            lblApacheLicenceURI.setForeground(new java.awt.Color(51, 51, 255));
            lblApacheLicenceURI.setText("Apache 2.0 License.");
            lblApacheLicenceURI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            lblApacheLicenceURI.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    lblApacheLicenceURIMouseClicked(evt);
                }
            });

            lblAbout5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
            lblAbout5.setText("For more information, go to our website:");

            lblWebsiteURI.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
            lblWebsiteURI.setForeground(new java.awt.Color(51, 51, 255));
            lblWebsiteURI.setText("http:\\\\simpmcq.tanmaydesigns.in");
            lblWebsiteURI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            lblWebsiteURI.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    lblWebsiteURIMouseClicked(evt);
                }
            });

            lblAbout6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
            lblAbout6.setText("Contact us at:");

            lblEMailURI.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
            lblEMailURI.setForeground(new java.awt.Color(51, 51, 255));
            lblEMailURI.setText("simpmcq@tanmaydesigns.in");
            lblEMailURI.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            lblEMailURI.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    lblEMailURIMouseClicked(evt);
                }
            });

            txtAreaAbout.setEditable(false);
            txtAreaAbout.setColumns(20);
            txtAreaAbout.setRows(5);
            scrlSystemDesc.setViewportView(txtAreaAbout);

            btnAbouClose.setText("Close");
            btnAbouClose.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnAbouCloseActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout dlgAboutLayout = new javax.swing.GroupLayout(dlgAbout.getContentPane());
            dlgAbout.getContentPane().setLayout(dlgAboutLayout);
            dlgAboutLayout.setHorizontalGroup(
                dlgAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dlgAboutLayout.createSequentialGroup()
                    .addGap(51, 51, 51)
                    .addGroup(dlgAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblAbout5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblWebsiteURI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblAbout6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(dlgAboutLayout.createSequentialGroup()
                            .addComponent(lblAbout4)
                            .addGap(0, 0, 0)
                            .addComponent(lblApacheLicenceURI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(lblEMailURI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scrlSystemDesc)
                        .addGroup(dlgAboutLayout.createSequentialGroup()
                            .addGroup(dlgAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblAbout3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblAbout2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblAbout1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblAboutImg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGap(51, 51, 51))
                .addGroup(dlgAboutLayout.createSequentialGroup()
                    .addGap(193, 193, 193)
                    .addComponent(btnAbouClose)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            dlgAboutLayout.setVerticalGroup(
                dlgAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dlgAboutLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lblAboutImg, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(lblAbout1)
                    .addGap(0, 0, 0)
                    .addComponent(lblAbout2)
                    .addGap(0, 0, 0)
                    .addComponent(lblAbout3)
                    .addGap(0, 0, 0)
                    .addGroup(dlgAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblAbout4)
                        .addComponent(lblApacheLicenceURI))
                    .addGap(0, 0, 0)
                    .addComponent(lblAbout5)
                    .addGap(0, 0, 0)
                    .addComponent(lblWebsiteURI)
                    .addGap(0, 0, 0)
                    .addComponent(lblAbout6, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(lblEMailURI)
                    .addGap(6, 6, 6)
                    .addComponent(scrlSystemDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnAbouClose)
                    .addGap(27, 27, 27))
            );

            dlgAbout.getAccessibleContext().setAccessibleParent(this);

            dlgHowTo.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            dlgHowTo.setTitle("About");
            dlgHowTo.setAlwaysOnTop(true);
            dlgHowTo.setBounds(new java.awt.Rectangle(250, 140, 400, 400));
            dlgHowTo.setResizable(false);
            dlgHowTo.setType(java.awt.Window.Type.POPUP);

            txtAreaHowTo.setEditable(false);
            txtAreaHowTo.setColumns(20);
            txtAreaHowTo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
            txtAreaHowTo.setLineWrap(true);
            txtAreaHowTo.setRows(5);
            txtAreaHowTo.setText("1. Open a Test file by clicking File\\Open menu.\n2. To go to first question and start, click \"Start\" button.\n3. After that you can browse through all the questions by number buttons or Next/Previous buttons.\n4. To answer, select the radio button alongside your preferred answer and click Next/Previous.\n5. When you are over with the Test, click Finish to end and view your result/marks.\n\nNote:\nYou MUST click Next/Previous to submit answer. If you click Number Buttons after selecting radio, then your answer will not be registered.");
            txtAreaHowTo.setWrapStyleWord(true);
            txtAreaHowTo.setAutoscrolls(false);
            scrlHowTo.setViewportView(txtAreaHowTo);

            btnCloseHowTo.setText("Close");
            btnCloseHowTo.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnCloseHowToActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout dlgHowToLayout = new javax.swing.GroupLayout(dlgHowTo.getContentPane());
            dlgHowTo.getContentPane().setLayout(dlgHowToLayout);
            dlgHowToLayout.setHorizontalGroup(
                dlgHowToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dlgHowToLayout.createSequentialGroup()
                    .addGap(153, 153, 153)
                    .addComponent(btnCloseHowTo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(dlgHowToLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scrlHowTo, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addContainerGap())
            );
            dlgHowToLayout.setVerticalGroup(
                dlgHowToLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dlgHowToLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(scrlHowTo, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)
                    .addComponent(btnCloseHowTo)
                    .addGap(37, 37, 37))
            );

            dlgFont.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            dlgFont.setTitle("Font Size");
            dlgFont.setBounds(new java.awt.Rectangle(100, 100, 267, 117));

            lblFont.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
            lblFont.setText("Choose Font Size");

            cmbFont.setEditable(true);
            cmbFont.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "10", "12", "14", "16", "18", "20" }));
            cmbFont.setSelectedItem(txtAreaQuestion.getFont().getSize());
            cmbFont.setToolTipText("Input a value between 10 to 20");

            btnOk.setText("OK");
            btnOk.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnOkActionPerformed(evt);
                }
            });

            btnCancel.setText("Cancel");
            btnCancel.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnCancelActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout dlgFontLayout = new javax.swing.GroupLayout(dlgFont.getContentPane());
            dlgFont.getContentPane().setLayout(dlgFontLayout);
            dlgFontLayout.setHorizontalGroup(
                dlgFontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dlgFontLayout.createSequentialGroup()
                    .addGroup(dlgFontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dlgFontLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(lblFont)
                            .addGap(18, 18, 18))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dlgFontLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(47, 47, 47)))
                    .addGroup(dlgFontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cmbFont, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancel))
                    .addGap(20, 20, 20))
            );
            dlgFontLayout.setVerticalGroup(
                dlgFontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dlgFontLayout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addGroup(dlgFontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFont)
                        .addComponent(cmbFont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                    .addGroup(dlgFontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancel)
                        .addComponent(btnOk))
                    .addContainerGap())
            );

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setTitle("SimpMCQ");
            setIconImage(new javax.swing.ImageIcon(getClass().getResource("/com/res/SimpMCQ.png")).getImage());
            setMaximizedBounds(new java.awt.Rectangle(1110, 590, 0, 0));
            setMinimumSize(new java.awt.Dimension(1110, 590));
            getContentPane().setLayout(null);

            ifTest.setClosable(true);
            ifTest.setTitle("Test");
            ifTest.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/StartTest.png"))); // NOI18N
            ifTest.setPreferredSize(new java.awt.Dimension(1110, 570));
            ifTest.setVisible(false);

            lblId.setText("Q. No.");

            txtId.setEditable(false);
            txtId.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            txtId.setText("0");

            txtAreaQuestion.setEditable(false);
            txtAreaQuestion.setColumns(20);
            txtAreaQuestion.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
            txtAreaQuestion.setLineWrap(true);
            txtAreaQuestion.setRows(5);
            txtAreaQuestion.setWrapStyleWord(true);
            scrlQuestion.setViewportView(txtAreaQuestion);

            btnGrpOptions.add(rdbOpt1);

            btnGrpOptions.add(rdbOpt2);

            btnGrpOptions.add(rdbOpt3);

            btnGrpOptions.add(rdbOpt4);

            txtAreaOpt1.setEditable(false);
            txtAreaOpt1.setColumns(20);
            txtAreaOpt1.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
            txtAreaOpt1.setLineWrap(true);
            txtAreaOpt1.setRows(5);
            txtAreaOpt1.setWrapStyleWord(true);
            scrlOpt1.setViewportView(txtAreaOpt1);

            txtAreaOpt2.setEditable(false);
            txtAreaOpt2.setColumns(20);
            txtAreaOpt2.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
            txtAreaOpt2.setLineWrap(true);
            txtAreaOpt2.setRows(5);
            txtAreaOpt2.setWrapStyleWord(true);
            scrlOpt2.setViewportView(txtAreaOpt2);

            txtAreaOpt3.setEditable(false);
            txtAreaOpt3.setColumns(20);
            txtAreaOpt3.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
            txtAreaOpt3.setLineWrap(true);
            txtAreaOpt3.setRows(5);
            txtAreaOpt3.setWrapStyleWord(true);
            scrlOpt3.setViewportView(txtAreaOpt3);

            txtAreaOpt4.setEditable(false);
            txtAreaOpt4.setColumns(20);
            txtAreaOpt4.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
            txtAreaOpt4.setLineWrap(true);
            txtAreaOpt4.setRows(5);
            txtAreaOpt4.setWrapStyleWord(true);
            scrlOpt4.setViewportView(txtAreaOpt4);

            btnPrevious.setText("Previous");
            btnPrevious.setEnabled(false);
            btnPrevious.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnPreviousActionPerformed(evt);
                }
            });

            btnFinish.setText("Finish");
            btnFinish.setEnabled(false);
            btnFinish.setMaximumSize(new java.awt.Dimension(73, 23));
            btnFinish.setMinimumSize(new java.awt.Dimension(73, 23));
            btnFinish.setPreferredSize(new java.awt.Dimension(73, 23));
            btnFinish.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnFinishActionPerformed(evt);
                }
            });

            btnNext.setText("Next");
            btnNext.setEnabled(false);
            btnNext.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnNextActionPerformed(evt);
                }
            });

            btnStart.setText("Start");
            btnStart.setMaximumSize(new java.awt.Dimension(73, 23));
            btnStart.setMinimumSize(new java.awt.Dimension(73, 23));
            btnStart.setPreferredSize(new java.awt.Dimension(73, 23));
            btnStart.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnStartActionPerformed(evt);
                }
            });

            pnlQuesControl.setBorder(javax.swing.BorderFactory.createEtchedBorder());
            pnlQuesControl.setEnabled(false);

            lblPhy.setText("Physics");

            lblMath.setText("Math");

            lblChem.setText("Chemistry");

            btnQ1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ1.setText("1");

            btnQ2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ2.setText("2");

            btnQ3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ3.setText("3");

            btnQ4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ4.setText("4");

            btnQ5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ5.setText("5");

            btnQ6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ6.setText("6");

            btnQ7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ7.setText("7");

            btnQ8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ8.setText("8");

            btnQ9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ9.setText("9");

            btnQ10.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ10.setText("10");

            btnQ11.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ11.setText("11");

            btnQ12.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ12.setText("12");

            btnQ13.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ13.setText("13");

            btnQ14.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ14.setText("14");

            btnQ15.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ15.setText("15");

            btnQ16.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ16.setText("16");

            btnQ17.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ17.setText("17");

            btnQ18.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ18.setText("18");

            btnQ19.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ19.setText("19");

            btnQ20.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ20.setText("20");

            btnQ21.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ21.setText("21");

            btnQ22.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ22.setText("22");

            btnQ23.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ23.setText("23");

            btnQ24.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ24.setText("24");

            btnQ25.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ25.setText("25");

            btnQ26.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ26.setText("26");

            btnQ27.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ27.setText("27");

            btnQ28.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ28.setText("28");

            btnQ29.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ29.setText("29");

            btnQ30.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ30.setText("30");

            btnQ31.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ31.setText("1");

            btnQ32.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ32.setText("2");

            btnQ33.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ33.setText("3");

            btnQ34.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ34.setText("4");

            btnQ35.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ35.setText("5");

            btnQ36.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ36.setText("6");

            btnQ37.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ37.setText("7");

            btnQ38.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ38.setText("8");

            btnQ39.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ39.setText("9");

            btnQ40.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ40.setText("10");

            btnQ41.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ41.setText("11");

            btnQ42.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ42.setText("12");

            btnQ43.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ43.setText("13");

            btnQ44.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ44.setText("14");

            btnQ45.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ45.setText("15");

            btnQ46.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ46.setText("16");

            btnQ47.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ47.setText("17");

            btnQ48.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ48.setText("18");

            btnQ49.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ49.setText("19");

            btnQ50.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ50.setText("20");

            btnQ51.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ51.setText("21");

            btnQ52.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ52.setText("22");

            btnQ53.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ53.setText("23");

            btnQ54.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ54.setText("24");

            btnQ55.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ55.setText("25");

            btnQ56.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ56.setText("26");

            btnQ57.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ57.setText("27");

            btnQ58.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ58.setText("28");

            btnQ59.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ59.setText("29");

            btnQ60.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ60.setText("30");

            btnQ61.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ61.setText("1");

            btnQ62.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ62.setText("2");

            btnQ63.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ63.setText("3");

            btnQ64.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ64.setText("4");

            btnQ65.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ65.setText("5");

            btnQ66.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ66.setText("6");

            btnQ67.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ67.setText("7");

            btnQ68.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ68.setText("8");

            btnQ69.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ69.setText("9");

            btnQ70.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ70.setText("10");

            btnQ71.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ71.setText("11");

            btnQ72.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ72.setText("12");

            btnQ73.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ73.setText("13");

            btnQ74.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ74.setText("14");

            btnQ75.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ75.setText("15");

            btnQ76.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ76.setText("16");

            btnQ77.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ77.setText("17");

            btnQ78.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ78.setText("18");

            btnQ79.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ79.setText("19");

            btnQ80.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ80.setText("20");

            btnQ81.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ81.setText("21");

            btnQ82.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ82.setText("22");

            btnQ83.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ83.setText("23");

            btnQ84.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ84.setText("24");

            btnQ85.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ85.setText("25");

            btnQ86.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ86.setText("26");

            btnQ87.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ87.setText("27");

            btnQ88.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ88.setText("28");

            btnQ89.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ89.setText("29");

            btnQ90.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnQ90.setText("30");

            pnlLegend.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Legend", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, null, new java.awt.Color(0, 0, 153)));

            btnMarked.setBackground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
            btnMarked.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnMarked.setText("1");
            btnMarked.setPreferredSize(new java.awt.Dimension(43, 21));

            btnUnmarked.setBackground(Color.RED);
            btnUnmarked.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnUnmarked.setText("1");
            btnUnmarked.setPreferredSize(new java.awt.Dimension(43, 21));

            btnUnseen.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            btnUnseen.setText("1");
            btnUnseen.setPreferredSize(new java.awt.Dimension(43, 21));

            lblMarked.setForeground(Color.getHSBColor(0.41666666f, 1.0f, 0.5019608f));
            lblMarked.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblMarked.setLabelFor(btnMarked);
            lblMarked.setText("Question Seen & Marked");

            lblMarked1.setForeground(Color.RED);
            lblMarked1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblMarked1.setLabelFor(btnUnmarked);
            lblMarked1.setText("Question Seen & UnMarked");

            lblMarked2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblMarked2.setLabelFor(btnUnseen);
            lblMarked2.setText("Question Not Seen");

            javax.swing.GroupLayout pnlLegendLayout = new javax.swing.GroupLayout(pnlLegend);
            pnlLegend.setLayout(pnlLegendLayout);
            pnlLegendLayout.setHorizontalGroup(
                pnlLegendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlLegendLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnlLegendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnMarked, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                        .addComponent(btnUnmarked, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUnseen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(26, 26, 26)
                    .addGroup(pnlLegendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblMarked, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMarked1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMarked2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap())
            );
            pnlLegendLayout.setVerticalGroup(
                pnlLegendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlLegendLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnlLegendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblMarked, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMarked, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(pnlLegendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnUnmarked, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMarked1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(pnlLegendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnUnseen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMarked2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout pnlQuesControlLayout = new javax.swing.GroupLayout(pnlQuesControl);
            pnlQuesControl.setLayout(pnlQuesControlLayout);
            pnlQuesControlLayout.setHorizontalGroup(
                pnlQuesControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlQuesControlLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnlQuesControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlLegend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlQuesControlLayout.createSequentialGroup()
                            .addGroup(pnlQuesControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblPhy)
                                .addGroup(pnlQuesControlLayout.createSequentialGroup()
                                    .addGroup(pnlQuesControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnQ1)
                                        .addComponent(btnQ2)
                                        .addComponent(btnQ3)
                                        .addComponent(btnQ4)
                                        .addComponent(btnQ5)
                                        .addComponent(btnQ6)
                                        .addComponent(btnQ7)
                                        .addComponent(btnQ8)
                                        .addComponent(btnQ9)
                                        .addComponent(btnQ10)
                                        .addComponent(btnQ11)
                                        .addComponent(btnQ12)
                                        .addComponent(btnQ13)
                                        .addComponent(btnQ14)
                                        .addComponent(btnQ15))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(pnlQuesControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnQ16)
                                        .addComponent(btnQ17)
                                        .addComponent(btnQ18)
                                        .addComponent(btnQ19)
                                        .addComponent(btnQ20)
                                        .addComponent(btnQ21)
                                        .addComponent(btnQ22)
                                        .addComponent(btnQ23)
                                        .addComponent(btnQ24)
                                        .addComponent(btnQ25)
                                        .addComponent(btnQ26)
                                        .addComponent(btnQ27)
                                        .addComponent(btnQ28)
                                        .addComponent(btnQ29)
                                        .addComponent(btnQ30))))
                            .addGroup(pnlQuesControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlQuesControlLayout.createSequentialGroup()
                                    .addGap(38, 38, 38)
                                    .addComponent(lblChem)
                                    .addGap(95, 95, 95)
                                    .addComponent(lblMath))
                                .addGroup(pnlQuesControlLayout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(pnlQuesControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnQ31)
                                        .addComponent(btnQ32)
                                        .addComponent(btnQ33)
                                        .addComponent(btnQ34)
                                        .addComponent(btnQ35)
                                        .addComponent(btnQ36)
                                        .addComponent(btnQ37)
                                        .addComponent(btnQ38)
                                        .addComponent(btnQ39)
                                        .addComponent(btnQ40)
                                        .addComponent(btnQ41)
                                        .addComponent(btnQ42)
                                        .addComponent(btnQ43)
                                        .addComponent(btnQ44)
                                        .addComponent(btnQ45))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(pnlQuesControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnQ46)
                                        .addComponent(btnQ47)
                                        .addComponent(btnQ48)
                                        .addComponent(btnQ49)
                                        .addComponent(btnQ50)
                                        .addComponent(btnQ51)
                                        .addComponent(btnQ52)
                                        .addComponent(btnQ53)
                                        .addComponent(btnQ54)
                                        .addComponent(btnQ55)
                                        .addComponent(btnQ56)
                                        .addComponent(btnQ57)
                                        .addComponent(btnQ58)
                                        .addComponent(btnQ59)
                                        .addComponent(btnQ60))
                                    .addGap(18, 18, 18)
                                    .addGroup(pnlQuesControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnQ61)
                                        .addComponent(btnQ62)
                                        .addComponent(btnQ63)
                                        .addComponent(btnQ64)
                                        .addComponent(btnQ65)
                                        .addComponent(btnQ66)
                                        .addComponent(btnQ67)
                                        .addComponent(btnQ68)
                                        .addComponent(btnQ69)
                                        .addComponent(btnQ70)
                                        .addComponent(btnQ71)
                                        .addComponent(btnQ72)
                                        .addComponent(btnQ73)
                                        .addComponent(btnQ74)
                                        .addComponent(btnQ75))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(pnlQuesControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnQ76)
                                        .addComponent(btnQ77)
                                        .addComponent(btnQ78)
                                        .addComponent(btnQ79)
                                        .addComponent(btnQ80)
                                        .addComponent(btnQ81)
                                        .addComponent(btnQ82)
                                        .addComponent(btnQ83)
                                        .addComponent(btnQ84)
                                        .addComponent(btnQ85)
                                        .addComponent(btnQ86)
                                        .addComponent(btnQ87)
                                        .addComponent(btnQ88)
                                        .addComponent(btnQ89)
                                        .addComponent(btnQ90))))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap())
            );

            pnlQuesControlLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnQ1, btnQ10, btnQ11, btnQ12, btnQ13, btnQ14, btnQ15, btnQ16, btnQ17, btnQ18, btnQ19, btnQ2, btnQ20, btnQ21, btnQ22, btnQ23, btnQ24, btnQ25, btnQ26, btnQ27, btnQ28, btnQ29, btnQ3, btnQ30, btnQ4, btnQ5, btnQ6, btnQ7, btnQ8, btnQ9});

            pnlQuesControlLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnQ31, btnQ32, btnQ33, btnQ34, btnQ35, btnQ36, btnQ37, btnQ38, btnQ39, btnQ40, btnQ41, btnQ42, btnQ43, btnQ44, btnQ45, btnQ46, btnQ47, btnQ48, btnQ49, btnQ50, btnQ51, btnQ52, btnQ53, btnQ54, btnQ55, btnQ56, btnQ57, btnQ58, btnQ59, btnQ60});

            pnlQuesControlLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnQ61, btnQ62, btnQ63, btnQ64, btnQ65, btnQ66, btnQ67, btnQ68, btnQ69, btnQ70, btnQ71, btnQ72, btnQ73, btnQ74, btnQ75, btnQ76, btnQ77, btnQ78, btnQ79, btnQ80, btnQ81, btnQ82, btnQ83, btnQ84, btnQ85, btnQ86, btnQ87, btnQ88, btnQ89, btnQ90});

            pnlQuesControlLayout.setVerticalGroup(
                pnlQuesControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlQuesControlLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(pnlQuesControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPhy)
                        .addComponent(lblMath)
                        .addComponent(lblChem))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(pnlQuesControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlQuesControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlQuesControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlQuesControlLayout.createSequentialGroup()
                                    .addComponent(btnQ1)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ2)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ3)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ4)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ5)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ6)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ7)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ8)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ9)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ10)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ11)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ12)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ13)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ14)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ15))
                                .addGroup(pnlQuesControlLayout.createSequentialGroup()
                                    .addComponent(btnQ16)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ17)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ18)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ19)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ20)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ21)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ22)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ23)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ24)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ25)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ26)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ27)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ28)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ29)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ30)))
                            .addGroup(pnlQuesControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnlQuesControlLayout.createSequentialGroup()
                                    .addComponent(btnQ31)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ32)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ33)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ34)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ35)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ36)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ37)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ38)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ39)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ40)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ41)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ42)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ43)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ44)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ45))
                                .addGroup(pnlQuesControlLayout.createSequentialGroup()
                                    .addComponent(btnQ46)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ47)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ48)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ49)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ50)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ51)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ52)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ53)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ54)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ55)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ56)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ57)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ58)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ59)
                                    .addGap(0, 0, 0)
                                    .addComponent(btnQ60))))
                        .addGroup(pnlQuesControlLayout.createSequentialGroup()
                            .addComponent(btnQ61)
                            .addGap(0, 0, 0)
                            .addComponent(btnQ62)
                            .addGap(0, 0, 0)
                            .addComponent(btnQ63)
                            .addGap(0, 0, 0)
                            .addComponent(btnQ64)
                            .addGap(0, 0, 0)
                            .addComponent(btnQ65)
                            .addGap(0, 0, 0)
                            .addComponent(btnQ66)
                            .addGap(0, 0, 0)
                            .addComponent(btnQ67)
                            .addGap(0, 0, 0)
                            .addComponent(btnQ68)
                            .addGap(0, 0, 0)
                            .addComponent(btnQ69)
                            .addGap(0, 0, 0)
                            .addComponent(btnQ70)
                            .addGap(0, 0, 0)
                            .addComponent(btnQ71)
                            .addGap(0, 0, 0)
                            .addComponent(btnQ72)
                            .addGap(0, 0, 0)
                            .addComponent(btnQ73)
                            .addGap(0, 0, 0)
                            .addComponent(btnQ74)
                            .addGap(0, 0, 0)
                            .addComponent(btnQ75))
                        .addGroup(pnlQuesControlLayout.createSequentialGroup()
                            .addComponent(btnQ76)
                            .addGap(0, 0, 0)
                            .addComponent(btnQ77)
                            .addGap(0, 0, 0)
                            .addComponent(btnQ78)
                            .addGap(0, 0, 0)
                            .addComponent(btnQ79)
                            .addGap(0, 0, 0)
                            .addComponent(btnQ80)
                            .addGap(0, 0, 0)
                            .addComponent(btnQ81)
                            .addGap(0, 0, 0)
                            .addComponent(btnQ82)
                            .addGap(0, 0, 0)
                            .addComponent(btnQ83)
                            .addGap(0, 0, 0)
                            .addComponent(btnQ84)
                            .addGap(0, 0, 0)
                            .addComponent(btnQ85)
                            .addGap(0, 0, 0)
                            .addComponent(btnQ86)
                            .addGap(0, 0, 0)
                            .addComponent(btnQ87)
                            .addGap(0, 0, 0)
                            .addComponent(btnQ88)
                            .addGap(0, 0, 0)
                            .addComponent(btnQ89)
                            .addGap(0, 0, 0)
                            .addComponent(btnQ90)))
                    .addGap(18, 18, 18)
                    .addComponent(pnlLegend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(18, Short.MAX_VALUE))
            );

            lblCountdown.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
            lblCountdown.setText("000:00");
            lblCountdown.setBorder(javax.swing.BorderFactory.createEtchedBorder());

            javax.swing.GroupLayout ifTestLayout = new javax.swing.GroupLayout(ifTest.getContentPane());
            ifTest.getContentPane().setLayout(ifTestLayout);
            ifTestLayout.setHorizontalGroup(
                ifTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ifTestLayout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addGroup(ifTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(ifTestLayout.createSequentialGroup()
                            .addGroup(ifTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(ifTestLayout.createSequentialGroup()
                                    .addGroup(ifTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rdbOpt1)
                                        .addComponent(rdbOpt3))
                                    .addGap(6, 6, 6)
                                    .addGroup(ifTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(scrlOpt1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(scrlOpt3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(ifTestLayout.createSequentialGroup()
                                    .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(90, 90, 90)
                                    .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(ifTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ifTestLayout.createSequentialGroup()
                                    .addGap(17, 17, 17)
                                    .addGroup(ifTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(ifTestLayout.createSequentialGroup()
                                            .addComponent(rdbOpt2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(scrlOpt2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ifTestLayout.createSequentialGroup()
                                            .addComponent(rdbOpt4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(scrlOpt4, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(ifTestLayout.createSequentialGroup()
                                    .addGap(62, 62, 62)
                                    .addComponent(btnFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(90, 90, 90)
                                    .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(ifTestLayout.createSequentialGroup()
                            .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(ifTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(ifTestLayout.createSequentialGroup()
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(113, 113, 113)
                                    .addComponent(lblCountdown, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(ifTestLayout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addComponent(scrlQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                    .addComponent(pnlQuesControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(44, Short.MAX_VALUE))
            );
            ifTestLayout.setVerticalGroup(
                ifTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ifTestLayout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addGroup(ifTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ifTestLayout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(lblId))
                        .addGroup(ifTestLayout.createSequentialGroup()
                            .addGroup(ifTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCountdown, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(10, 10, 10)
                            .addComponent(scrlQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(10, 10, 10)
                    .addGroup(ifTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ifTestLayout.createSequentialGroup()
                            .addGroup(ifTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(rdbOpt2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(scrlOpt2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(ifTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rdbOpt4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(scrlOpt4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(ifTestLayout.createSequentialGroup()
                            .addGroup(ifTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(rdbOpt1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(scrlOpt1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(ifTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(scrlOpt3)
                                .addComponent(rdbOpt3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(ifTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnPrevious)
                        .addGroup(ifTestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNext)
                            .addComponent(btnFinish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(50, 50, 50))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ifTestLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(pnlQuesControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );

            getContentPane().add(ifTest);
            ifTest.setBounds(0, 0, 1110, 570);
            try {
                ifTest.setMaximum(true);
            } catch (java.beans.PropertyVetoException e1) {
                e1.printStackTrace();
            }

            ifCreate.setClosable(true);
            ifCreate.setTitle("Create Test");
            ifCreate.setFrameIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/Create.png"))); // NOI18N
            ifCreate.setPreferredSize(new java.awt.Dimension(1110, 520));
            ifCreate.setVisible(false);

            lblIdC.setText("Q. No.");

            txtIdC.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
            txtIdC.setText("0");

            txtAreaQuestionC.setColumns(20);
            txtAreaQuestionC.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
            txtAreaQuestionC.setLineWrap(true);
            txtAreaQuestionC.setRows(5);
            txtAreaQuestionC.setWrapStyleWord(true);
            scrlQuestionC.setViewportView(txtAreaQuestionC);

            btnGrpOptionsC.add(rdbOptC1);

            btnGrpOptionsC.add(rdbOptC2);

            btnGrpOptionsC.add(rdbOptC3);

            btnGrpOptionsC.add(rdbOptC4);

            txtAreaOptC1.setColumns(20);
            txtAreaOptC1.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
            txtAreaOptC1.setLineWrap(true);
            txtAreaOptC1.setRows(5);
            txtAreaOptC1.setWrapStyleWord(true);
            scrlOptC1.setViewportView(txtAreaOptC1);

            txtAreaOptC2.setColumns(20);
            txtAreaOptC2.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
            txtAreaOptC2.setLineWrap(true);
            txtAreaOptC2.setRows(5);
            txtAreaOptC2.setWrapStyleWord(true);
            scrlOptC2.setViewportView(txtAreaOptC2);

            txtAreaOptC3.setColumns(20);
            txtAreaOptC3.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
            txtAreaOptC3.setLineWrap(true);
            txtAreaOptC3.setRows(5);
            txtAreaOptC3.setWrapStyleWord(true);
            scrlOptC3.setViewportView(txtAreaOptC3);

            txtAreaOptC4.setColumns(20);
            txtAreaOptC4.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
            txtAreaOptC4.setLineWrap(true);
            txtAreaOptC4.setRows(5);
            txtAreaOptC4.setWrapStyleWord(true);
            scrlOptC4.setViewportView(txtAreaOptC4);

            btnSet.setText("Set and Go");
            btnSet.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnSetActionPerformed(evt);
                }
            });

            jTextArea1.setEditable(false);
            jTextArea1.setColumns(20);
            jTextArea1.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
            jTextArea1.setLineWrap(true);
            jTextArea1.setRows(5);
            jTextArea1.setText("                 Instructions:\n1. Type the question in the big text area and the options in small ones.\n2. Mark the radio button against the correct option.\n3. Click \"Set and Go\" to set the data in Test file and move on to enter next question.\n\n                     Note:\nThe Test files created are stored with .smt extension in the Documents library in SimpTests folder. Presently the tests do not support display of images so if required; images may be placed in folders with same name as the Test file in SimpTest folder for reference of user.");
            jTextArea1.setWrapStyleWord(true);
            jScrollPane1.setViewportView(jTextArea1);

            javax.swing.GroupLayout ifCreateLayout = new javax.swing.GroupLayout(ifCreate.getContentPane());
            ifCreate.getContentPane().setLayout(ifCreateLayout);
            ifCreateLayout.setHorizontalGroup(
                ifCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ifCreateLayout.createSequentialGroup()
                    .addGroup(ifCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ifCreateLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(lblIdC, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(3, 3, 3)
                            .addComponent(txtIdC, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ifCreateLayout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addGroup(ifCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(scrlQuestionC, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(ifCreateLayout.createSequentialGroup()
                                    .addComponent(rdbOptC1)
                                    .addGap(6, 6, 6)
                                    .addComponent(scrlOptC1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(rdbOptC2)
                                    .addGap(6, 6, 6)
                                    .addComponent(scrlOptC2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(ifCreateLayout.createSequentialGroup()
                                    .addComponent(rdbOptC3)
                                    .addGap(6, 6, 6)
                                    .addComponent(scrlOptC3, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(rdbOptC4)
                                    .addGap(6, 6, 6)
                                    .addComponent(scrlOptC4, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ifCreateLayout.createSequentialGroup()
                            .addGap(319, 319, 319)
                            .addComponent(btnSet, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(46, Short.MAX_VALUE))
            );
            ifCreateLayout.setVerticalGroup(
                ifCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ifCreateLayout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addGroup(ifCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ifCreateLayout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(lblIdC))
                        .addComponent(txtIdC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(10, 10, 10)
                    .addGroup(ifCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(ifCreateLayout.createSequentialGroup()
                            .addComponent(scrlQuestionC, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addGroup(ifCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rdbOptC1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(scrlOptC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rdbOptC2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(scrlOptC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(6, 6, 6)
                            .addGroup(ifCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rdbOptC3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(scrlOptC3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rdbOptC4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(scrlOptC4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane1))
                    .addGap(18, 18, 18)
                    .addComponent(btnSet, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );

            getContentPane().add(ifCreate);
            ifCreate.setBounds(0, 0, 1110, 570);
            try {
                ifCreate.setMaximum(true);
            } catch (java.beans.PropertyVetoException e1) {
                e1.printStackTrace();
            }

            lblWelcome.setFont(new java.awt.Font("Curlz MT", 0, 24)); // NOI18N
            lblWelcome.setForeground(new java.awt.Color(0, 0, 204));
            lblWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            lblWelcome.setText("Welcome Aboard!");
            getContentPane().add(lblWelcome);
            lblWelcome.setBounds(120, 36, 363, 47);

            btnStartTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/StartTest.png"))); // NOI18N
            btnStartTest.setText("Start Test");
            btnStartTest.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            btnStartTest.setVerticalAlignment(javax.swing.SwingConstants.TOP);
            btnStartTest.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
            btnStartTest.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnStartTestActionPerformed(evt);
                }
            });
            getContentPane().add(btnStartTest);
            btnStartTest.setBounds(120, 140, 110, 130);

            btnCreateTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/Create.png"))); // NOI18N
            btnCreateTest.setText("Create Test");
            btnCreateTest.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            btnCreateTest.setVerticalAlignment(javax.swing.SwingConstants.TOP);
            btnCreateTest.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
            btnCreateTest.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnCreateTestActionPerformed(evt);
                }
            });
            getContentPane().add(btnCreateTest);
            btnCreateTest.setBounds(373, 140, 110, 130);

            btnExit.setText("Exit Already");
            btnExit.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnExitActionPerformed(evt);
                }
            });
            getContentPane().add(btnExit);
            btnExit.setBounds(120, 414, 363, 39);

            lblWelcomePic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/Welcome.jpg"))); // NOI18N
            getContentPane().add(lblWelcomePic);
            lblWelcomePic.setBounds(530, 20, 530, 470);

            menFile.setText("File");

            menItmOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/folderOpenIcon.png"))); // NOI18N
            menItmOpen.setText("Open");
            menItmOpen.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    menItmOpenActionPerformed(evt);
                }
            });
            menFile.add(menItmOpen);

            menItmCrtTests.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/CreateTest.png"))); // NOI18N
            menItmCrtTests.setText("Create Tests");
            menItmCrtTests.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    menItmCrtTestsActionPerformed(evt);
                }
            });
            menFile.add(menItmCrtTests);
            menFile.add(jSeparator1);

            menItmExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/javasoft/plaf/synthetica/blackmoon/images/closeIcon.png"))); // NOI18N
            menItmExit.setText("Exit");
            menItmExit.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    menItmExitActionPerformed(evt);
                }
            });
            menFile.add(menItmExit);

            menuBarMain.add(menFile);

            menOptions.setText("Options");

            menTheme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/Themes.png"))); // NOI18N
            menTheme.setText("Themes");

            btnGrpThemes.add(rdbMenBlackMoon);
            rdbMenBlackMoon.setText("Black Moon");
            rdbMenBlackMoon.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    rdbMenBlackMoonActionPerformed(evt);
                }
            });
            menTheme.add(rdbMenBlackMoon);

            btnGrpThemes.add(rdbMenBlueIce);
            rdbMenBlueIce.setText("Blue Ice");
            rdbMenBlueIce.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    rdbMenBlueIceActionPerformed(evt);
                }
            });
            menTheme.add(rdbMenBlueIce);

            btnGrpThemes.add(rdbMenBlueMoon);
            rdbMenBlueMoon.setSelected(true);
            rdbMenBlueMoon.setText("Blue Moon (Default)");
            rdbMenBlueMoon.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    rdbMenBlueMoonActionPerformed(evt);
                }
            });
            menTheme.add(rdbMenBlueMoon);

            btnGrpThemes.add(rdbMenGreenDream);
            rdbMenGreenDream.setText("Green Dream");
            rdbMenGreenDream.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    rdbMenGreenDreamActionPerformed(evt);
                }
            });
            menTheme.add(rdbMenGreenDream);

            btnGrpThemes.add(rdbMenOrangeMetallic);
            rdbMenOrangeMetallic.setText("Orange Metallic");
            rdbMenOrangeMetallic.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    rdbMenOrangeMetallicActionPerformed(evt);
                }
            });
            menTheme.add(rdbMenOrangeMetallic);

            btnGrpThemes.add(rdbMenMetal);
            rdbMenMetal.setText("Metal");
            rdbMenMetal.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    rdbMenMetalActionPerformed(evt);
                }
            });
            menTheme.add(rdbMenMetal);

            btnGrpThemes.add(rdbMenNimbus);
            rdbMenNimbus.setText("Nimbus");
            rdbMenNimbus.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    rdbMenNimbusActionPerformed(evt);
                }
            });
            menTheme.add(rdbMenNimbus);

            btnGrpThemes.add(rdbMenWindows);
            rdbMenWindows.setText("Windows");
            rdbMenWindows.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    rdbMenWindowsActionPerformed(evt);
                }
            });
            menTheme.add(rdbMenWindows);

            menOptions.add(menTheme);

            menItmFont.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/res/FontSize.png"))); // NOI18N
            menItmFont.setText("Font Size");
            menItmFont.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    menItmFontActionPerformed(evt);
                }
            });
            menOptions.add(menItmFont);

            menuBarMain.add(menOptions);

            menHelp.setText("Help");

            menItmHowToGiveTest.setText("How to give Test");
            menItmHowToGiveTest.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    menItmHowToGiveTestActionPerformed(evt);
                }
            });
            menHelp.add(menItmHowToGiveTest);

            menItmAbout.setText("About");
            menItmAbout.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    menItmAboutActionPerformed(evt);
                }
            });
            menHelp.add(menItmAbout);

            menuBarMain.add(menHelp);

            setJMenuBar(menuBarMain);

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void menItmOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menItmOpenActionPerformed
        if (dbNameCrt == null) {
            if (checkdbNameVar()) {
                btnStartTest.doClick();
                hideWelcome();
            } else {
                int returnVal = JOptionPane.showConfirmDialog(menItmOpen, "This will exit your current Test and open a new one. Are you sure you want to continue?", "End Current Test", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (returnVal == JOptionPane.OK_OPTION) {
                    btnStartTest.doClick();
                    clearAllifTest();
                }
            }
        } else {
            int returnVal = JOptionPane.showConfirmDialog(menItmOpen, "This will exit your current Test Creation and open a new Test. Are you sure you want to continue?", "End Current Test", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (returnVal == JOptionPane.OK_OPTION) {                
                clearAllifTest();
                ifCreate.dispose();
                btnStartTest.doClick();
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_menItmOpenActionPerformed

    private void menItmExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menItmExitActionPerformed
        int retVal = JOptionPane.showConfirmDialog(menItmExit, "Are you sure you want to exit? All open Test data will be lost!", "Exit", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (retVal == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_menItmExitActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        setAnswer();
        btnGrpOptions.clearSelection();
        short i = (short) (getCurrentQNo() - 1);
        processQPanel();
        setQuestion(i);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishActionPerformed
        int retVal = JOptionPane.showConfirmDialog(null, "Are you sure you want to finish test?", "End Test", JOptionPane.YES_NO_OPTION);
        if (retVal == JOptionPane.YES_OPTION) {
            int result = checkAnswers();
            timer.stop();
            txtAreaQuestion.setText("");
            txtAreaOpt1.setText("");
            txtAreaOpt2.setText("");
            txtAreaOpt3.setText("");
            txtAreaOpt4.setText("");
            dbName = null;
            JOptionPane.showMessageDialog(this, "Your score is " + result + ". Thanks for taking this test.", "Result", JOptionPane.INFORMATION_MESSAGE);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFinishActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        setAnswer();
        btnGrpOptions.clearSelection();
        processQPanel();
        short i = (short) (getCurrentQNo() + 1);
        setQuestion(i);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnStartTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartTestActionPerformed
        int returnVal = fileChsOpen.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            dbName = fileChsOpen.getSelectedFile().getAbsolutePath();
            System.out.println(dbName);
            hideWelcome();
            if (!ifTest.isVisible()) {
                ifTest.setVisible(true);
            }
        }
// TODO add your handling code here:
    }//GEN-LAST:event_btnStartTestActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
// TODO add your handling code here:
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnCreateTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateTestActionPerformed
        int retVal = JOptionPane.showOptionDialog(ifCreate, "Choose an option to Start", "Create Test", 0, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Create from Existing", "Create New", "Cancel"}, "Create New");
        if (retVal == 1) {
            String s = JOptionPane.showInputDialog(rootPane, "Name Your Test.\nYour test will be stored in \"Documents\\SimpTests\\\" directory", "Test Name", JOptionPane.INFORMATION_MESSAGE);
            if (s != null) {
                dbNameCrt = getFileSystemView().getDefaultDirectory().getAbsolutePath() + "\\SimpTests\\" + s + ".smt";
                System.out.println(dbNameCrt);
                try {
                    Class.forName("org.sqlite.JDBC");
                    try (Connection c = DriverManager.getConnection("jdbc:sqlite:" + dbNameCrt)) {
                        Statement stm = c.createStatement();
                        stm.executeUpdate("CREATE TABLE questions(id int(2), question text(2000), opt1 text(2000), opt2 text(2000), opt3 text(2000), opt4 text(2000))");
                        Statement stmt = c.createStatement();
                        stmt.executeUpdate("CREATE TABLE answers(id int(2), answer int(2))");
                    }
                    hideWelcome();
                    ifCreate.setVisible(true);
                } catch (ClassNotFoundException | SQLException e) {
                    JOptionPane.showMessageDialog(rootPane, e.getClass().getName() + " : " + e.getMessage(), "Unexpected Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (retVal == 0) {
            int returnValue = fileChsOpen.showOpenDialog(ifCreate);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                dbNameCrt = fileChsOpen.getSelectedFile().getAbsolutePath();
                System.out.println(dbNameCrt);
                hideWelcome();
                ifCreate.setVisible(true);
            }
        }
// TODO add your handling code here:
    }//GEN-LAST:event_btnCreateTestActionPerformed

    private void menItmCrtTestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menItmCrtTestsActionPerformed
        if (dbName == null) {
            if (dbNameCrt == null) {
                btnCreateTest.doClick();
                hideWelcome();
            } else {
                int retVal = JOptionPane.showConfirmDialog(menItmCrtTests, "Do you want to close current Test Creation and start a new one?", "Close Current Test", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (retVal == JOptionPane.OK_OPTION) {
                    clearAllifCreate();
                    btnCreateTest.doClick();
                }
            }
        } else {
            int retVal = JOptionPane.showConfirmDialog(menItmCrtTests, "Do you want to close current Test and start Test Creation?\nAll your progress will be lost.", "Close Current Test", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (retVal == JOptionPane.OK_OPTION) {
                ifTest.dispose();
                btnCreateTest.doClick();
            }
        }
// TODO add your handling code here:
    }//GEN-LAST:event_menItmCrtTestsActionPerformed

    private void btnSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetActionPerformed
        try {
            Class.forName("org.sqlite.JDBC");
            try (Connection c = DriverManager.getConnection("jdbc:sqlite:" + dbNameCrt)) {
                Statement stm = c.createStatement();
                String sql = "INSERT INTO questions VALUES(" + txtIdC.getText() + ", \"" + txtAreaQuestionC.getText() + "\", \"" + txtAreaOptC1.getText() + "\", \"" + txtAreaOptC2.getText() + "\", \"" + txtAreaOptC3.getText() + "\", \"" + txtAreaOptC4.getText() + "\")";
                stm.executeUpdate(sql);
                Statement stmt = c.createStatement();
                Short ans = null;
                if (rdbOptC1.isSelected()) {
                    ans = 1;
                } else if (rdbOptC2.isSelected()) {
                    ans = 2;
                } else if (rdbOptC3.isShowing()) {
                    ans = 3;
                } else if (rdbOptC4.isSelected()) {
                    ans = 4;
                }
                sql = "INSERT INTO answers VALUES(" + txtIdC.getText() + ", " + ans + ")";
                stmt.executeUpdate(sql);
            }
            Short n = Short.parseShort(txtIdC.getText());
            ++n;
            txtIdC.setText("" + n);
            txtAreaQuestionC.setText("");
            txtAreaOptC1.setText("");
            txtAreaOptC2.setText("");
            txtAreaOptC3.setText("");
            txtAreaOptC4.setText("");
            btnGrpOptionsC.clearSelection();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(ifCreate, "Some unexpected error occured. Please try again", "Error Reading Test File", JOptionPane.ERROR_MESSAGE);
        }

// TODO add your handling code here:
    }//GEN-LAST:event_btnSetActionPerformed

    private void rdbMenBlackMoonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbMenBlackMoonActionPerformed
        if(rdbMenBlackMoon.isSelected()){
            try {
                UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaBlackMoonLookAndFeel");
                SwingUtilities.updateComponentTreeUI(super.rootPane);
            } catch (    ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(SimpMCQ.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_rdbMenBlackMoonActionPerformed

    private void rdbMenBlueIceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbMenBlueIceActionPerformed
        if(rdbMenBlueIce.isSelected()){
            try {
                UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaBlueIceLookAndFeel");
                SwingUtilities.updateComponentTreeUI(super.rootPane);
            } catch (    ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(SimpMCQ.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_rdbMenBlueIceActionPerformed

    private void rdbMenBlueMoonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbMenBlueMoonActionPerformed
        if(rdbMenBlueMoon.isSelected()){
            try {
                UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaBlueMoonLookAndFeel");
                SwingUtilities.updateComponentTreeUI(super.rootPane);
            } catch (    ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(SimpMCQ.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_rdbMenBlueMoonActionPerformed

    private void rdbMenMetalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbMenMetalActionPerformed
        if(rdbMenMetal.isSelected()){
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                SwingUtilities.updateComponentTreeUI(super.rootPane);
            } catch (    ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(SimpMCQ.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_rdbMenMetalActionPerformed

    private void rdbMenNimbusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbMenNimbusActionPerformed
        if(rdbMenNimbus.isSelected()){
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                SwingUtilities.updateComponentTreeUI(super.rootPane);
            } catch (    ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(SimpMCQ.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_rdbMenNimbusActionPerformed

    private void rdbMenWindowsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbMenWindowsActionPerformed
        if(rdbMenWindows.isSelected()){
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                SwingUtilities.updateComponentTreeUI(super.rootPane);
            } catch (    ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(SimpMCQ.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_rdbMenWindowsActionPerformed

    private void rdbMenGreenDreamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbMenGreenDreamActionPerformed
        if(rdbMenGreenDream.isSelected()){
            try {
                UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaGreenDreamLookAndFeel");
                SwingUtilities.updateComponentTreeUI(super.rootPane);
            } catch (    ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(SimpMCQ.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_rdbMenGreenDreamActionPerformed

    private void rdbMenOrangeMetallicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbMenOrangeMetallicActionPerformed
        if(rdbMenGreenDream.isSelected()){
            try {
                UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaOrangeMetallicLookAndFeel");
                SwingUtilities.updateComponentTreeUI(super.rootPane);
            } catch (    ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                Logger.getLogger(SimpMCQ.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_rdbMenOrangeMetallicActionPerformed

    private void menItmAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menItmAboutActionPerformed
        String system = "System: "+System.getProperty("os.name")+" version "+System.getProperty("os.version");
        String dir = "Test Directory: "+getFileSystemView().getDefaultDirectory()+"\\SimpTests\\";
        String javaver = "Java Runtime: "+System.getProperty("java.runtime.name")+" "+System.getProperty("java.runtime.version");
        txtAreaAbout.setText("");
        txtAreaAbout.append(system+"\n"+javaver+"\n"+dir);
        dlgAbout.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_menItmAboutActionPerformed

    private void menItmHowToGiveTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menItmHowToGiveTestActionPerformed
        dlgHowTo.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_menItmHowToGiveTestActionPerformed

    private void btnCloseHowToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseHowToActionPerformed
        dlgHowTo.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_btnCloseHowToActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        pnlQuesControl.setEnabled(true);
        btnNext.setEnabled(true);
        btnPrevious.setEnabled(true);
        btnFinish.setEnabled(true);
        timer.start();
        btnNext.doClick();
        btnStart.setEnabled(false);        
    }//GEN-LAST:event_btnStartActionPerformed

    private void lblEMailURIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEMailURIMouseClicked
        try {
            java.awt.Desktop.getDesktop().mail(new java.net.URI("mailto:simpmcq@tanmaydesigns.in"));
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(SimpMCQ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblEMailURIMouseClicked

    private void lblWebsiteURIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblWebsiteURIMouseClicked
        try {
            java.awt.Desktop.getDesktop().browse(new java.net.URI("http://www.simpmcq.tanmaydesigns.in"));
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(SimpMCQ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblWebsiteURIMouseClicked

    private void lblApacheLicenceURIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblApacheLicenceURIMouseClicked
        try {
            java.awt.Desktop.getDesktop().browse(new java.net.URI("http://www.apache.org/licenses/LICENSE-2.0.txt"));
        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(SimpMCQ.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lblApacheLicenceURIMouseClicked

    private void btnAbouCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbouCloseActionPerformed
        dlgAbout.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAbouCloseActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        int fontSize = Integer.parseInt(cmbFont.getSelectedItem().toString());
        if(fontSize>=10 && fontSize<=20){
            txtAreaQuestion.setFont(new java.awt.Font("Verdana", 0, fontSize));
            txtAreaOpt1.setFont(new java.awt.Font("Verdana", 0, fontSize));
            txtAreaOpt2.setFont(new java.awt.Font("Verdana", 0, fontSize));
            txtAreaOpt3.setFont(new java.awt.Font("Verdana", 0, fontSize));
            txtAreaOpt4.setFont(new java.awt.Font("Verdana", 0, fontSize));
            txtAreaQuestionC.setFont(new java.awt.Font("Verdana", 0, fontSize));
            txtAreaOptC1.setFont(new java.awt.Font("Verdana", 0, fontSize));
            txtAreaOptC2.setFont(new java.awt.Font("Verdana", 0, fontSize));
            txtAreaOptC3.setFont(new java.awt.Font("Verdana", 0, fontSize));
            txtAreaOptC4.setFont(new java.awt.Font("Verdana", 0, fontSize));
            dlgFont.dispose();
        }
        else{
            JOptionPane.showMessageDialog(dlgFont, "Input a value between 10 and 20!", "Input Wrong", JOptionPane.ERROR_MESSAGE);
        }
// TODO add your handling code here:
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dlgFont.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_btnCancelActionPerformed

    private void menItmFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menItmFontActionPerformed
        dlgFont.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_menItmFontActionPerformed

    // <editor-fold defaultstate="collapsed" desc="btnQPanelControl-ActionListener">
    private void btnQPanelControl(java.awt.event.ActionEvent e){
        short i;
        if(e.getSource().equals(btnQ1)) setQuestion((short) 1);
        else if(e.getSource().equals(btnQ2)) setQuestion((short) 2);
        else if(e.getSource().equals(btnQ3)) setQuestion((short) 3);
        else if(e.getSource().equals(btnQ4)) setQuestion((short) 4);
        else if(e.getSource().equals(btnQ5)) setQuestion((short) 5);
        else if(e.getSource().equals(btnQ6)) setQuestion((short) 6);
        else if(e.getSource().equals(btnQ7)) setQuestion((short) 7);
        else if(e.getSource().equals(btnQ8)) setQuestion((short) 8);
        else if(e.getSource().equals(btnQ9)) setQuestion((short) 9);
        else if(e.getSource().equals(btnQ10)) setQuestion((short) 10);
        else if(e.getSource().equals(btnQ11)) setQuestion((short) 11);
        else if(e.getSource().equals(btnQ12)) setQuestion((short) 12);
        else if(e.getSource().equals(btnQ13)) setQuestion((short) 13);
        else if(e.getSource().equals(btnQ14)) setQuestion((short) 14);
        else if(e.getSource().equals(btnQ15)) setQuestion((short) 15);
        else if(e.getSource().equals(btnQ16)) setQuestion((short) 16);
        else if(e.getSource().equals(btnQ17)) setQuestion((short) 17);
        else if(e.getSource().equals(btnQ18)) setQuestion((short) 18);
        else if(e.getSource().equals(btnQ19)) setQuestion((short) 19);
        else if(e.getSource().equals(btnQ20)) setQuestion((short) 20);
        else if(e.getSource().equals(btnQ21)) setQuestion((short) 21);
        else if(e.getSource().equals(btnQ22)) setQuestion((short) 22);
        else if(e.getSource().equals(btnQ23)) setQuestion((short) 23);
        else if(e.getSource().equals(btnQ24)) setQuestion((short) 24);
        else if(e.getSource().equals(btnQ25)) setQuestion((short) 25);
        else if(e.getSource().equals(btnQ26)) setQuestion((short) 26);
        else if(e.getSource().equals(btnQ27)) setQuestion((short) 27);
        else if(e.getSource().equals(btnQ28)) setQuestion((short) 28);
        else if(e.getSource().equals(btnQ29)) setQuestion((short) 29);
        else if(e.getSource().equals(btnQ30)) setQuestion((short) 30);
        else if(e.getSource().equals(btnQ31)) setQuestion((short) 31);
        else if(e.getSource().equals(btnQ32)) setQuestion((short) 32);
        else if(e.getSource().equals(btnQ33)) setQuestion((short) 33);
        else if(e.getSource().equals(btnQ34)) setQuestion((short) 34);
        else if(e.getSource().equals(btnQ35)) setQuestion((short) 35);
        else if(e.getSource().equals(btnQ36)) setQuestion((short) 36);
        else if(e.getSource().equals(btnQ37)) setQuestion((short) 37);
        else if(e.getSource().equals(btnQ38)) setQuestion((short) 38);
        else if(e.getSource().equals(btnQ39)) setQuestion((short) 39);
        else if(e.getSource().equals(btnQ40)) setQuestion((short) 40);
        else if(e.getSource().equals(btnQ41)) setQuestion((short) 41);
        else if(e.getSource().equals(btnQ42)) setQuestion((short) 42);
        else if(e.getSource().equals(btnQ43)) setQuestion((short) 43);
        else if(e.getSource().equals(btnQ44)) setQuestion((short) 44);
        else if(e.getSource().equals(btnQ45)) setQuestion((short) 45);
        else if(e.getSource().equals(btnQ46)) setQuestion((short) 46);
        else if(e.getSource().equals(btnQ47)) setQuestion((short) 47);
        else if(e.getSource().equals(btnQ48)) setQuestion((short) 48);
        else if(e.getSource().equals(btnQ49)) setQuestion((short) 49);
        else if(e.getSource().equals(btnQ50)) setQuestion((short) 50);
        else if(e.getSource().equals(btnQ51)) setQuestion((short) 51);
        else if(e.getSource().equals(btnQ52)) setQuestion((short) 52);
        else if(e.getSource().equals(btnQ53)) setQuestion((short) 53);
        else if(e.getSource().equals(btnQ54)) setQuestion((short) 54);
        else if(e.getSource().equals(btnQ55)) setQuestion((short) 55);
        else if(e.getSource().equals(btnQ56)) setQuestion((short) 56);
        else if(e.getSource().equals(btnQ57)) setQuestion((short) 57);
        else if(e.getSource().equals(btnQ58)) setQuestion((short) 58);
        else if(e.getSource().equals(btnQ59)) setQuestion((short) 59);
        else if(e.getSource().equals(btnQ60)) setQuestion((short) 60);
        else if(e.getSource().equals(btnQ61)) setQuestion((short) 61);
        else if(e.getSource().equals(btnQ62)) setQuestion((short) 62);
        else if(e.getSource().equals(btnQ63)) setQuestion((short) 63);
        else if(e.getSource().equals(btnQ64)) setQuestion((short) 64);
        else if(e.getSource().equals(btnQ65)) setQuestion((short) 65);
        else if(e.getSource().equals(btnQ66)) setQuestion((short) 66);
        else if(e.getSource().equals(btnQ67)) setQuestion((short) 67);
        else if(e.getSource().equals(btnQ68)) setQuestion((short) 68);
        else if(e.getSource().equals(btnQ69)) setQuestion((short) 69);
        else if(e.getSource().equals(btnQ70)) setQuestion((short) 70);
        else if(e.getSource().equals(btnQ71)) setQuestion((short) 71);
        else if(e.getSource().equals(btnQ72)) setQuestion((short) 72);
        else if(e.getSource().equals(btnQ73)) setQuestion((short) 73);
        else if(e.getSource().equals(btnQ74)) setQuestion((short) 74);
        else if(e.getSource().equals(btnQ75)) setQuestion((short) 75);
        else if(e.getSource().equals(btnQ76)) setQuestion((short) 76);
        else if(e.getSource().equals(btnQ77)) setQuestion((short) 77);
        else if(e.getSource().equals(btnQ78)) setQuestion((short) 78);
        else if(e.getSource().equals(btnQ79)) setQuestion((short) 79);
        else if(e.getSource().equals(btnQ80)) setQuestion((short) 80);
        else if(e.getSource().equals(btnQ81)) setQuestion((short) 81);
        else if(e.getSource().equals(btnQ82)) setQuestion((short) 82);
        else if(e.getSource().equals(btnQ83)) setQuestion((short) 83);
        else if(e.getSource().equals(btnQ84)) setQuestion((short) 84);
        else if(e.getSource().equals(btnQ85)) setQuestion((short) 85);
        else if(e.getSource().equals(btnQ86)) setQuestion((short) 86);
        else if(e.getSource().equals(btnQ87)) setQuestion((short) 87);
        else if(e.getSource().equals(btnQ88)) setQuestion((short) 88);
        else if(e.getSource().equals(btnQ89)) setQuestion((short) 89);
        else if(e.getSource().equals(btnQ90)) setQuestion((short) 90);
    }
    // </editor-fold>
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        // <editor-fold defaultstate="collapsed" desc="Look And Feel( Current - Black Moon)">
        try {
            UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaBlueMoonLookAndFeel");
        } catch (    ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SimpMCQ.class.getName()).log(Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SimpMCQ().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbouClose;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCloseHowTo;
    private javax.swing.JButton btnCreateTest;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnFinish;
    private javax.swing.ButtonGroup btnGrpOptions;
    private javax.swing.ButtonGroup btnGrpOptionsC;
    private javax.swing.ButtonGroup btnGrpThemes;
    private javax.swing.JButton btnMarked;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnQ1;
    private javax.swing.JButton btnQ10;
    private javax.swing.JButton btnQ11;
    private javax.swing.JButton btnQ12;
    private javax.swing.JButton btnQ13;
    private javax.swing.JButton btnQ14;
    private javax.swing.JButton btnQ15;
    private javax.swing.JButton btnQ16;
    private javax.swing.JButton btnQ17;
    private javax.swing.JButton btnQ18;
    private javax.swing.JButton btnQ19;
    private javax.swing.JButton btnQ2;
    private javax.swing.JButton btnQ20;
    private javax.swing.JButton btnQ21;
    private javax.swing.JButton btnQ22;
    private javax.swing.JButton btnQ23;
    private javax.swing.JButton btnQ24;
    private javax.swing.JButton btnQ25;
    private javax.swing.JButton btnQ26;
    private javax.swing.JButton btnQ27;
    private javax.swing.JButton btnQ28;
    private javax.swing.JButton btnQ29;
    private javax.swing.JButton btnQ3;
    private javax.swing.JButton btnQ30;
    private javax.swing.JButton btnQ31;
    private javax.swing.JButton btnQ32;
    private javax.swing.JButton btnQ33;
    private javax.swing.JButton btnQ34;
    private javax.swing.JButton btnQ35;
    private javax.swing.JButton btnQ36;
    private javax.swing.JButton btnQ37;
    private javax.swing.JButton btnQ38;
    private javax.swing.JButton btnQ39;
    private javax.swing.JButton btnQ4;
    private javax.swing.JButton btnQ40;
    private javax.swing.JButton btnQ41;
    private javax.swing.JButton btnQ42;
    private javax.swing.JButton btnQ43;
    private javax.swing.JButton btnQ44;
    private javax.swing.JButton btnQ45;
    private javax.swing.JButton btnQ46;
    private javax.swing.JButton btnQ47;
    private javax.swing.JButton btnQ48;
    private javax.swing.JButton btnQ49;
    private javax.swing.JButton btnQ5;
    private javax.swing.JButton btnQ50;
    private javax.swing.JButton btnQ51;
    private javax.swing.JButton btnQ52;
    private javax.swing.JButton btnQ53;
    private javax.swing.JButton btnQ54;
    private javax.swing.JButton btnQ55;
    private javax.swing.JButton btnQ56;
    private javax.swing.JButton btnQ57;
    private javax.swing.JButton btnQ58;
    private javax.swing.JButton btnQ59;
    private javax.swing.JButton btnQ6;
    private javax.swing.JButton btnQ60;
    private javax.swing.JButton btnQ61;
    private javax.swing.JButton btnQ62;
    private javax.swing.JButton btnQ63;
    private javax.swing.JButton btnQ64;
    private javax.swing.JButton btnQ65;
    private javax.swing.JButton btnQ66;
    private javax.swing.JButton btnQ67;
    private javax.swing.JButton btnQ68;
    private javax.swing.JButton btnQ69;
    private javax.swing.JButton btnQ7;
    private javax.swing.JButton btnQ70;
    private javax.swing.JButton btnQ71;
    private javax.swing.JButton btnQ72;
    private javax.swing.JButton btnQ73;
    private javax.swing.JButton btnQ74;
    private javax.swing.JButton btnQ75;
    private javax.swing.JButton btnQ76;
    private javax.swing.JButton btnQ77;
    private javax.swing.JButton btnQ78;
    private javax.swing.JButton btnQ79;
    private javax.swing.JButton btnQ8;
    private javax.swing.JButton btnQ80;
    private javax.swing.JButton btnQ81;
    private javax.swing.JButton btnQ82;
    private javax.swing.JButton btnQ83;
    private javax.swing.JButton btnQ84;
    private javax.swing.JButton btnQ85;
    private javax.swing.JButton btnQ86;
    private javax.swing.JButton btnQ87;
    private javax.swing.JButton btnQ88;
    private javax.swing.JButton btnQ89;
    private javax.swing.JButton btnQ9;
    private javax.swing.JButton btnQ90;
    private javax.swing.JButton btnSet;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStartTest;
    private javax.swing.JButton btnUnmarked;
    private javax.swing.JButton btnUnseen;
    private javax.swing.JComboBox cmbFont;
    private javax.swing.JDialog dlgAbout;
    private javax.swing.JDialog dlgFont;
    private javax.swing.JDialog dlgHowTo;
    private javax.swing.JFileChooser fileChsOpen;
    private javax.swing.JInternalFrame ifCreate;
    private javax.swing.JInternalFrame ifTest;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblAbout1;
    private javax.swing.JLabel lblAbout2;
    private javax.swing.JLabel lblAbout3;
    private javax.swing.JLabel lblAbout4;
    private javax.swing.JLabel lblAbout5;
    private javax.swing.JLabel lblAbout6;
    private javax.swing.JLabel lblAboutImg;
    private javax.swing.JLabel lblApacheLicenceURI;
    private javax.swing.JLabel lblChem;
    private javax.swing.JLabel lblCountdown;
    private javax.swing.JLabel lblEMailURI;
    private javax.swing.JLabel lblFont;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblIdC;
    private javax.swing.JLabel lblMarked;
    private javax.swing.JLabel lblMarked1;
    private javax.swing.JLabel lblMarked2;
    private javax.swing.JLabel lblMath;
    private javax.swing.JLabel lblPhy;
    private javax.swing.JLabel lblWebsiteURI;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JLabel lblWelcomePic;
    private javax.swing.JMenu menFile;
    private javax.swing.JMenu menHelp;
    private javax.swing.JMenuItem menItmAbout;
    private javax.swing.JMenuItem menItmCrtTests;
    private javax.swing.JMenuItem menItmExit;
    private javax.swing.JMenuItem menItmFont;
    private javax.swing.JMenuItem menItmHowToGiveTest;
    private javax.swing.JMenuItem menItmOpen;
    private javax.swing.JMenu menOptions;
    private javax.swing.JMenu menTheme;
    private javax.swing.JMenuBar menuBarMain;
    private javax.swing.JPanel pnlLegend;
    private javax.swing.JPanel pnlQuesControl;
    private javax.swing.JRadioButtonMenuItem rdbMenBlackMoon;
    private javax.swing.JRadioButtonMenuItem rdbMenBlueIce;
    private javax.swing.JRadioButtonMenuItem rdbMenBlueMoon;
    private javax.swing.JRadioButtonMenuItem rdbMenGreenDream;
    private javax.swing.JRadioButtonMenuItem rdbMenMetal;
    private javax.swing.JRadioButtonMenuItem rdbMenNimbus;
    private javax.swing.JRadioButtonMenuItem rdbMenOrangeMetallic;
    private javax.swing.JRadioButtonMenuItem rdbMenWindows;
    private javax.swing.JRadioButton rdbOpt1;
    private javax.swing.JRadioButton rdbOpt2;
    private javax.swing.JRadioButton rdbOpt3;
    private javax.swing.JRadioButton rdbOpt4;
    private javax.swing.JRadioButton rdbOptC1;
    private javax.swing.JRadioButton rdbOptC2;
    private javax.swing.JRadioButton rdbOptC3;
    private javax.swing.JRadioButton rdbOptC4;
    private javax.swing.JScrollPane scrlHowTo;
    private javax.swing.JScrollPane scrlOpt1;
    private javax.swing.JScrollPane scrlOpt2;
    private javax.swing.JScrollPane scrlOpt3;
    private javax.swing.JScrollPane scrlOpt4;
    private javax.swing.JScrollPane scrlOptC1;
    private javax.swing.JScrollPane scrlOptC2;
    private javax.swing.JScrollPane scrlOptC3;
    private javax.swing.JScrollPane scrlOptC4;
    private javax.swing.JScrollPane scrlQuestion;
    private javax.swing.JScrollPane scrlQuestionC;
    private javax.swing.JScrollPane scrlSystemDesc;
    private javax.swing.JTextArea txtAreaAbout;
    private javax.swing.JTextArea txtAreaHowTo;
    private javax.swing.JTextArea txtAreaOpt1;
    private javax.swing.JTextArea txtAreaOpt2;
    private javax.swing.JTextArea txtAreaOpt3;
    private javax.swing.JTextArea txtAreaOpt4;
    private javax.swing.JTextArea txtAreaOptC1;
    private javax.swing.JTextArea txtAreaOptC2;
    private javax.swing.JTextArea txtAreaOptC3;
    private javax.swing.JTextArea txtAreaOptC4;
    private javax.swing.JTextArea txtAreaQuestion;
    private javax.swing.JTextArea txtAreaQuestionC;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdC;
    // End of variables declaration//GEN-END:variables
}
