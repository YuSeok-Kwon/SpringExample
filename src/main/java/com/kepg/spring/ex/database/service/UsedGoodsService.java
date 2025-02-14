package com.kepg.spring.ex.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kepg.spring.ex.database.domain.UsedGoods;
import com.kepg.spring.ex.database.repository.UsedGoodsRepository;

// 로직(business) 담당
// 데이터 가공 및 그 외 복잡한 기능수행
// 일반적으로 Controller에서 필요한 기능 수행
@Service
public class UsedGoodsService {
	
	// 해당 멤버변수에 Spring이 자동으로 객체를 생성해서 <주입>해준다.
	@Autowired
	private UsedGoodsRepository usedGoodsRepository;

	// 메소드로 구성해야 Controller에서 호출 해서 사용 할 수 있음
	// 중고물품 게시글 모두 얻어오기
	public List<UsedGoods> getUsedGoodsList(){
		// used_goods 테이블 모든 행 조회
		List<UsedGoods> usedGoodsList = usedGoodsRepository.selectUsedGoodsList();
		
		// 필요에 따라 데이터 가공도 함
		return usedGoodsList;
	}
}
