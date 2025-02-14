package com.kepg.spring.ex.database.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kepg.spring.ex.database.domain.UsedGoods;

// 데이터베이스 관련 처리(table 등)
// Mybatis Framework를 활용하기 위해 Interface로 구성
@Mapper
public interface UsedGoodsRepository {

	// used_goods 테이블 모든 행 조회
	public List<UsedGoods> selectUsedGoodsList();
	
	// 메소드 호출 -> 메소드에 매칭된 xml 쿼리 수행 -> 조회결과를 resultType으로 명시된 클래스를 기반으
	// 이름이 일치하는 멤버변수에 저장 -> 그렇게 만들어진 객체들을 리스트에 추가
	// -> return
	
}
