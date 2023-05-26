package klubukm;

public class MainApp {
    public static void main(String[] args) {
        MemberDAO memberDAO = new MemberDAOImpl();
        MemberController memberController = new MemberController(memberDAO);
        MemberView memberView = new MemberView(memberController);
        memberController.setMemberView(memberView);
        memberView.show();
    }
}