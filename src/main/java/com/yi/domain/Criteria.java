package com.yi.domain;

import java.util.Collections;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import lombok.Data;

@Data
public class Criteria {

	/** ���� ������ ��ȣ */
	private int currentPageNo;

	/** �������� ����� ������ ���� */
	private int recordsPerPage;

	/** ȭ�� �ϴܿ� ����� ������ ������ */
	private int pageSize;

	/** �˻� Ű���� */
	private String Keyword;

	/** �˻� ���� */
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