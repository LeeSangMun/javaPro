package days25;

public class MemberVO {
	private String name;
	private String position;
	
	public MemberVO() {
		super();
	}

	public MemberVO(String name, String position) {
		super();
		this.name = name;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	
}
