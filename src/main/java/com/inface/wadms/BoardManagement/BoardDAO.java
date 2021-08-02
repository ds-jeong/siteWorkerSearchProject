package com.inface.wadms.BoardManagement;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class BoardDAO implements BoardService{

	@Autowired
	private SqlSession sql;

	@Override
	public List<BoardVO> company_list(BoardVO boardVo) {
		// TODO Auto-generated method stub
		return sql.selectList("board.mapper.companyList", boardVo);

	}

	@Override
	public List<BoardVO> site_list(BoardVO boardVo) {
		// TODO Auto-generated method stub
		return sql.selectList("board.mapper.siteList", boardVo);
	}

	@Override
	public List<BoardVO> team_list(BoardVO boardVo) {
		// TODO Auto-generated method stub
		return sql.selectList("board.mapper.teamList", boardVo);
	}

	@Override
	public List<BoardVO> search_list(BoardVO boardVo) {
		// TODO Auto-generated method stub
		log.debug("DAO의 Request객체 : {}",boardVo.toString());
		return sql.selectList("board.mapper.searchList", boardVo);
	}





}
