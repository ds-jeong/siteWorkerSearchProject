package com.inface.wadms.BoardManagement;

import java.util.List;
import java.util.Map;

public interface BoardService {
	List<BoardVO> company_list(BoardVO boardVo);
	List<BoardVO> site_list(BoardVO boardVo);
	List<BoardVO> team_list(BoardVO boardVo);
	List<BoardVO> search_list(BoardVO boardVo);
}
