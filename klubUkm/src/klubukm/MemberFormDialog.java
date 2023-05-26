/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package klubukm;

import klubukm.Member;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MemberFormDialog extends JDialog {

    private JTextField nameField;
    private JTextField addressField;
    private JTextField phoneNumberField;
    private JButton saveButton;
    private JButton cancelButton;

    private Member member;
    private boolean dataValid;
    
    public MemberFormDialog(JFrame parent, Member member) {
    super(parent, "Ubah Anggota Klub", true);
    this.member = member;
    initializeUI();
    populateFields();
}



    private void initializeUI() {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        JLabel nameLabel = new JLabel("Nama");
        nameField = new JTextField();
        JLabel addressLabel = new JLabel("Alamat");
        addressField = new JTextField();
        JLabel phoneNumberLabel = new JLabel("Nomor Telepon");
        phoneNumberField = new JTextField();
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(addressLabel);
        inputPanel.add(addressField);
        inputPanel.add(phoneNumberLabel);
        inputPanel.add(phoneNumberField);
        add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        saveButton = new JButton("Simpan");
        cancelButton = new JButton("Batal");
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancel();
            }
        });

        pack();
        setLocationRelativeTo(getParent());
    }

    private void populateFields() {
        nameField.setText(member.getName());
        addressField.setText(member.getAddress());
        phoneNumberField.setText(member.getPhoneNumber());
    }

    private void saveData() {
        String name = nameField.getText().trim();
        String address = addressField.getText().trim();
        String phoneNumber = phoneNumberField.getText().trim();

        if (name.isEmpty() || address.isEmpty() || phoneNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Harap lengkapi semua field.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            dataValid = false;
            return;
        }

        member.setName(name);
        member.setAddress(address);
        member.setPhoneNumber(phoneNumber);
        dataValid = true;
        setVisible(false);
    }

    private void cancel() {
        member = null;
        dataValid = false;
        setVisible(false);
    }

    public void showDialog() {
        setVisible(true);
    }

    public boolean isDataValid() {
        return dataValid;
    }

    public Member getMember() {
        return member;
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
