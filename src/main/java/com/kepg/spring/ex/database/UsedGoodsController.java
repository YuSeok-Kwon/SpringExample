package com.kepg.spring.ex.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kepg.spring.ex.database.domain.UsedGoods;
import com.kepg.spring.ex.database.service.UsedGoodsService;

// request, response 처리만 담당
@Controller
public class UsedGoodsController {
	
	@Autowired
	private UsedGoodsService usedGoodsService;
	
	// used_goods 테이블의 모든행을 response에 담는다
	@ResponseBody
	@RequestMapping("/db/usedgoods/list")
	public List<UsedGoods> usedGoodsList(){
		// 중고 물품 게시글 정보 얻어오기
		List<UsedGoods> usedGoodsList = usedGoodsService.getUsedGoodsList();
		
		return usedGoodsList;
	}
}
