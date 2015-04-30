package com.boram3.yanolja.Textlive.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boram3.yanolja.Controller.Action;
import com.boram3.yanolja.Controller.ActionForward;
import com.boram3.yanolja.DAO.TextliveDAO;

public class TextliveEnterRoomAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		int bangnum = Integer.parseInt(request.getParameter("bangnum"));
		System.out.println("TextliveEnterRoomAction "+bangnum);
		
		TextliveDAO textlivedao = new TextliveDAO();
		List roomlist = new ArrayList();
		
		roomlist = textlivedao.enterRoom(bangnum);
		
		if(roomlist == null){
			System.out.println("Null Data 처리");
			return null;
		}
		
		request.setAttribute("roomlist", roomlist);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("textlive/Room.jsp");
		return forward;
	}

}
