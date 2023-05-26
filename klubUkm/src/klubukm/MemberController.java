package klubukm;

import java.util.List;

public class MemberController {
    private MemberDAO memberDAO;
    private MemberView memberView;
    
    public MemberController(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }
    
    // Tambahkan setter untuk memberView
    public void setMemberView(MemberView memberView) {
        this.memberView = memberView;
    }
    
    public void getAllMembers() {
        List<Member> members = memberDAO.getAllMembers();
        memberView.displayMembers(members);
    }
    
    public void getMemberById(int id) {
        Member member = memberDAO.getMemberById(id);
        memberView.displayMember(member);
    }
    
    public void addMember(Member member) {
        memberDAO.addMember(member);
    }
    
    public void updateMember(Member member) {
        memberDAO.updateMember(member);
    }
    
    public void deleteMember(int id) {
        memberDAO.deleteMember(id);
    }
}
