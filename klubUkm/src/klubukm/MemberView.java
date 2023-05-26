package klubukm;

import javax.swing.*;
import java.util.List;
import java.awt.BorderLayout;
import klubukm.MemberFormDialog;

public class MemberView {
    private JFrame frame;
    private JTable table;
    private JScrollPane scrollPane;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private MemberController memberController;

    public MemberView(MemberController memberController) {
        this.memberController = memberController;

        frame = new JFrame("Aplikasi Daftar Anggota Klub UKM");
        table = new JTable();
        scrollPane = new JScrollPane(table);
        addButton = new JButton("Tambah");
        updateButton = new JButton("Ubah");
        deleteButton = new JButton("Hapus");

        // Set layout dan tambahkan komponen ke frame
        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> {
            // Implementasikan logika untuk menambah anggota klub
            MemberFormDialog dialog = new MemberFormDialog(frame, new Member()); // Menggunakan konstruktor yang menerima objek Member kosong
            dialog.showDialog();
            if (dialog.isDataValid()) {
                Member newMember = dialog.getMember();
                memberController.addMember(newMember);
                // Refresh tampilan setelah penambahan anggota klub
                getAllMembers();
            }
        });

        updateButton.addActionListener(e -> {
            // Implementasikan logika untuk mengubah anggota klub
            Member selectedMember = getSelectedMember();
            if (selectedMember != null) {
                MemberFormDialog dialog = new MemberFormDialog(frame, selectedMember);
                dialog.showDialog();
                if (dialog.isDataValid()) {
                    Member updatedMember = dialog.getMember();
                    memberController.updateMember(updatedMember);
                    // Refresh tampilan setelah perubahan anggota klub
                    getAllMembers();
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Pilih anggota klub yang ingin diubah.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        });

        deleteButton.addActionListener(e -> {
            // Implementasikan logika untuk menghapus anggota klub
            Member selectedMember = getSelectedMember();
            if (selectedMember != null) {
                int confirm = JOptionPane.showConfirmDialog(frame, "Apakah Anda yakin ingin menghapus anggota klub ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    memberController.deleteMember(selectedMember.getId());
                    // Refresh tampilan setelah penghapusan anggota klub
                    getAllMembers();
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Pilih anggota klub yang ingin dihapus.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    public void displayMembers(List<Member> members) {
        MemberTableModel tableModel = new MemberTableModel(members);
        table.setModel(tableModel);
    }

    public void displayMember(Member member) {
        JOptionPane.showMessageDialog(frame, member.toString(), "Detail Anggota Klub", JOptionPane.INFORMATION_MESSAGE);
    }

    public Member getSelectedMember() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            MemberTableModel tableModel = (MemberTableModel) table.getModel();
            return tableModel.getMemberAt(selectedRow);
        }
        return null;
    }

    public void getAllMembers() {
        memberController.getAllMembers();
    }

    public void show() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

