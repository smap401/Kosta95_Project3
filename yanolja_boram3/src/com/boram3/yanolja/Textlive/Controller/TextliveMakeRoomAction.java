package com.boram3.yanolja.Textlive.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boram3.yanolja.Controller.Action;
import com.boram3.yanolja.Controller.ActionForward;
import com.boram3.yanolja.DAO.TextliveDAO;
import com.boram3.yanolja.DTO.TextliveRoomBean;

public class TextliveMakeRoomAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//System.out.println(request.getParameter("user_id_fk"));
		//System.out.println(request.getParameter("bangnum"));
		request.setCharacterEncoding("utf-8");
		TextliveDAO recorddao = new TextliveDAO();
		TextliveRoomBean roomdata = new TextliveRoomBean();
		ActionForward forward = new ActionForward();
		boolean result=false;
		
		//textlivedata.setGamenum(Integer.parseInt(request.getParameter("gamenum").trim()));
		roomdata.setBangnum(Integer.parseInt(request.getParameter("bangnum").trim()));
		//textlivedata.setUserid_fk(request.getParameter("user_id_fk"));
		
		int awayteam=Integer.parseInt(request.getParameter("awayteam"));
		int hometeam=Integer.parseInt(request.getParameter("hometeam"));
		
		result = recorddao.makeRoom(awayteam, hometeam, roomdata);
		System.out.println("TextliveMakeRoomAction " + result);
		if(result==false){
			System.out.println("방개설 실패!");
			return null;
		}
		System.out.println("문자중계방 개설!");
		
		forward.setRedirect(true);
		forward.setPath("./TextliveRoom.te");
		return forward;
		
		
	}

}
