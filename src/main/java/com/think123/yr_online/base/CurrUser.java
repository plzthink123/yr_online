package com.think123.yr_online.base;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import java.io.Serializable;

/**
 * 封装当前登录用户
 * @author Administrator
 *
 */
@Data
@ToString
@Slf4j
public class CurrUser implements HttpSessionBindingListener, Serializable {

	/*private static final long serialVersionUID = -4966214203200407139L;
	private static List<CurrUser> currUserList=new ArrayList<>();

	private static List<String> currUser_ids=new ArrayList<>();
*/
	private String userId;
	private String userName;

	//private String sessionid;

	//private HttpSession session;

	
	public CurrUser(String userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}


	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		log.info("=========================Session生成=========================");
	/*	session=event.getSession();
		//System.out.println(session.getId());
		sessionid=event.getSession().getId();
		this.setSessionid(sessionid);
		currUserList.add(this);
		currUser_ids.add(this.getUserId());
		for(CurrUser c:currUserList){
			System.out.println(c);
		}

		String id=session.getId();*/
		/*for(int i=0;i<currUserList.size();i++){
			if(currUser_ids.contains(currUserList.get(i).getUserId())){
				currUserList.get(i).getSession().invalidate();
			}
		}*/

	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		log.info("=========================Session销销毁=========================");

		//currUserList.remove(this);

	}
}