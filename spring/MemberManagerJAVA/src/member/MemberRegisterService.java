package member;

import java.util.Date;

public class MemberRegisterService {

	private MemberDao memberDao;
	
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void regist(RegisterRequest request) throws AlreadyExistingMemberException {
		
		Member member = memberDao.selectByEmail(request.getEmail());
		
		if(member != null) { //null이 아니라면 같은 이메일이 등록되 있다는 뜻
			throw new AlreadyExistingMemberException();
		}
		
		Member newMember = new Member(request.getEmail(), request.getPassword(), request.getName(), new Date());
	
		memberDao.insert(newMember);
	}
	
}
