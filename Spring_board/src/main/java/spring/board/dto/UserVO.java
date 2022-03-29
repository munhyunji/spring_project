package spring.board.dto;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserVO {
	
	
	private int id;
	
	@NotBlank (message="사용자 이름을 입력하세요.")
	private String username;
	
	@NotBlank (message="사용자 ID를 입력하세요")
	@Size(min = 0,max=10,  message=" 0-10사이의 글자를 입력해주세요")
	private String userid;
	
	@NotBlank(message = "비밀번호는 필수 입력 값입니다.")
	@Size(min = 0,max=8, message=" 5-10사이의 글자")
	private String userpassword;
	
	private Date regdate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	
	
	
}
