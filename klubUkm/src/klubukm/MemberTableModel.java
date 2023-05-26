package klubukm;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class MemberTableModel extends AbstractTableModel {
    private List<Member> members;
    private String[] columnNames = {"ID", "Nama", "Alamat", "Nomor Telepon"};

    public MemberTableModel(List<Member> members) {
        this.members = members;
    }

    @Override
    public int getRowCount() {
        return members.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Member member = members.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return member.getId();
            case 1:
                return member.getName();
            case 2:
                return member.getAddress();
            case 3:
                return member.getPhoneNumber();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public Member getMemberAt(int rowIndex) {
        return members.get(rowIndex);
    }
}
