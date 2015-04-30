package com.boram3.yanolja.Textlive.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boram3.yanolja.Controller.Action;
import com.boram3.yanolja.Controller.ActionForward;
import com.boram3.yanolja.DAO.TextliveDAO;
import com.boram3.yanolja.DTO.TextliveBatterBean;
import com.boram3.yanolja.DTO.TextlivePitcherBean;

public class TextliveViewPlayerInfoAction implements Action {
	@Override
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
	
		//System.out.println(request.getParameter("teamnumber"));
		//System.out.println(request.getParameter("backnumber"));
		System.out.println("TextliveViewPlayerInfoAction");
		int teamnumber = Integer.parseInt(request.getParameter("team_no_fk").trim());
		int backnumber = Integer.parseInt(request.getParameter("b_backnumber").trim());
		
		TextliveDAO playerdao = new TextliveDAO();
		TextliveBatterBean batterdata = new TextliveBatterBean();
		TextlivePitcherBean pitcherdata = new TextlivePitcherBean();

		
		System.out.println("actionteamnumber: " + request.getParameter("teamnumber"));
		System.out.println("actionbacknumber: " + request.getParameter("backnumber"));

		batterdata=playerdao.getDetail(teamnumber, backnumber);
		//pitcherdata=playerdao.getDetail(teamnumber, backnumber);
		
		if(batterdata == null){
			System.out.println("Null Data 처리");
			return null;
		}
		/*if(pitcherdata == null){
			System.out.println("Null Data 처리");
			return null;
		}*/
		
		request.setAttribute("batterdata",batterdata);
		//request.setAttribute("pitcherdata",pitcherdata);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("player/ViewPlayerInfo.jsp");
		return forward;
		
	 }
 }