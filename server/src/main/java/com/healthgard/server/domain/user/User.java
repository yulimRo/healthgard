package com.healthgard.server.domain.user;

import javax.persistence.*;

import com.healthgard.server.domain.common.BaseEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseEntity{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
	private String name;
	@Column(nullable = false)
    private String email;
    private String picture;
    
    @Enumerated(javax.persistence.EnumType.STRING)
    private Role role;
    	
	@Builder
	public User(String name, String email, String picture,Role role) {
		this.name = name;
		this.email = email;
		this.picture = picture;
		this.role = role;
	}

    /*
        구글 사용자 정보가 업데이트 되었을 때를 대비하여 update 기능도 같이 구현.
     */
    public User update(String name, String picture){
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }
    
    
	
	
}
