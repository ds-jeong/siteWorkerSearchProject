package com.inface.wadms.BoardManagement;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServicelmpl implements BoardService{
	@Autowired private BoardDAO dao;
	@Override
	public List<BoardVO> company_list(BoardVO boardVo) {
		// TODO Auto-generated method stub
		return dao.company_list(boardVo);

	}
	@Override
	public List<BoardVO> site_list(BoardVO boardVo) {
		// TODO Auto-generated method stub
		return dao.site_list(boardVo);
	}
	@Override
	public List<BoardVO> team_list(BoardVO boardVo) {
		// TODO Auto-generated method stub
		return dao.team_list(boardVo);
	}
	@Override
	public List<BoardVO> search_list(BoardVO boardVo) {
		// TODO Auto-generated method stub
		return dao.search_list(boardVo);
	}


}
