package com.changon.minipro.member.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.changon.minipro.common.EmployeeVo;
import com.changon.minipro.common.Paging;
import com.changon.minipro.common.Service;
import com.changon.minipro.member.dao.MemberDAO;

public class PagingTest implements Service {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// 페이징
		MemberDAO dao = new MemberDAO();
		
		String pageNo = request.getParameter("pageNo");
		int pg = Integer.parseInt(pageNo);
		Paging paging = new Paging();
		
		paging.setPageNo(pg);
		paging.setPageSize(10);
		paging.setTotalCount(dao.getTotalCnt());
		System.out.println(paging);
		

		dao = new MemberDAO(); // getTotalCnt 호출 후 close 되어버리므로 한 번 더 호출
		List<EmployeeVo> list = dao.getPagingList(pg);
		
		request.setAttribute("list", list);
		request.setAttribute("params", paging);
		return "views/main/main.jsp";
	}

}
