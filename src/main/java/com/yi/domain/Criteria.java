package com.yi.domain;

import java.util.Collections;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import lombok.Data;

@Data
public class Criteria {

	/** 현재 페이지 번호 */
	private int currentPageNo;

	/** 페이지당 출력할 데이터 개수 */
	private int recordsPerPage;

	/** 화면 하단에 출력할 페이지 사이즈 */
	private int pageSize;

	/** 검색 키워드 */
	private String Keyword;

	/** 검색 유형 */
	private String Type;

	public Criteria() {
		this.currentPageNo = 1;
		this.recordsPerPage = 3;
		this.pageSize = 10;
	}

	public int getStartPage() {
		return (currentPageNo - 1) * recordsPerPage;
	}
	  public String[] getTypeArr() {
		    
		    return Type == null? new String[] {}: Type.split("");
		  }	
}