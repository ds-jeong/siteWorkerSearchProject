package com.inface.wadms.BoardManagement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inface.wadms.common.utils.DateUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {
	@Autowired
	private BoardServicelmpl boardService;

	

	// #teamList에 업체별 현장리스트를 불러온다.
	@RequestMapping(value = "/teamList")
	public @ResponseBody List<BoardVO> team_list(HttpServletRequest request) {
		BoardVO boardVo = new BoardVO();
		/*
		 * boardVo.setTeam_no(NumberUtils.toInt(request.getParameter("siteNo"))); AJAX로
		 * 전달받은 파라미터를 INT로 형변환하여 VO객체안의 변수에 담아준다.
		 */
		boardVo.setSite_no(NumberUtils.toInt(request.getParameter("site_no")));
		return boardService.team_list(boardVo);
	}

	// #siteList에 업체별 현장리스트를 불러온다.
	@RequestMapping(value = "/siteList")
	public @ResponseBody List<BoardVO> site_list(HttpServletRequest request) {
		Map<String, Object> ret = new HashMap<String, Object>();
		BoardVO boardVo = new BoardVO();
		/*
		 * boardVo.setTeam_no(NumberUtils.toInt(request.getParameter("siteNo"))); AJAX로
		 * 전달받은 파라미터를 INT로 형변환하여 VO객체안의 변수에 담아준다.
		 */
		boardVo.setCompany_no(NumberUtils.toInt(request.getParameter("comapany_no")));
		// ret.put("CODE", "OK");
		// ret.put("siteList", service.site_list(boardVo));
		return boardService.site_list(boardVo);
	}

	// #companyLIst에 업체명리스트를 불러온다.
	@RequestMapping(value = "/list")
	public String company_list(HttpServletRequest request, Model model) {
		BoardVO boardVo = new BoardVO();
		/*
		 * boardVo.setTeam_no(NumberUtils.toInt(request.getParameter("siteNo"))); AJAX로
		 * 전달받은 파라미터를 INT로 형변환하여 VO객체안의 변수에 담아준다.
		 */
		
		//String searchText =  request.getParameter("searchText");
		//log.debug("검색문구 : {}", searchText);
		//log.debug("00000000000000000000000000000000000000000000000000000000000000000000000000");
		boardVo.setCompany_no(NumberUtils.toInt(request.getParameter("company_no")));
		boardVo.setSite_no(NumberUtils.toInt(request.getParameter("site_no")));
		boardVo.setTeam_no(NumberUtils.toInt(request.getParameter("team_no")));
		boardVo.setStartDt(request.getParameter("startDt"));
		boardVo.setEndDt(request.getParameter("endDt"));
		boardVo.setSearchType(StringUtils.defaultString(request.getParameter("searchType")));
		boardVo.setSearchText(StringUtils.defaultString(request.getParameter("searchText")));
		boardVo.setCompany_name(StringUtils.defaultString(request.getParameter("companyName")));
		boardVo.setSite_name(StringUtils.defaultString(request.getParameter("siteName")));
		

		List<BoardVO> search_list = boardService.search_list(boardVo);
		model.addAttribute("search_list", search_list);
		
		List<BoardVO> company_list = boardService.company_list(boardVo);
		model.addAttribute("company_list", company_list);
		
		
		//검색 조건이 있는 경우 현장리스트를 가져가고, 현장번호까지 있으면 팀리스트까지 가져간다.
		if(boardVo != null && boardVo.getCompany_no() != 0) {
			model.addAttribute("siteList", boardService.site_list(boardVo));
			if(boardVo.getSite_no() != 0) {
				model.addAttribute("teamList", boardService.team_list(boardVo));
			}
		}
		
		model.addAttribute("baseInfo", boardVo);


		return "board/index";
	}

}
