package klubukm;

import java.util.List;

public interface MemberDAO {
    List<Member> getAllMembers();
    Member getMemberById(int id);
    void addMember(Member member);
    void updateMember(Member member);
    void deleteMember(int id);
}
