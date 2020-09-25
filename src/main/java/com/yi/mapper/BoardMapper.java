package com.yi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.yi.domain.BoardVO;
import com.yi.domain.Criteria;

public interface BoardMapper {
//	@Select("select*from member")
	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public void insert(BoardVO board);
	
	public BoardVO read(String mid);
	
	public int delete(int mid);
	
	public int update(BoardVO board);
	
	public int getTotalCount(Criteria cri);

	
//	public void insertSelectkey(BoardVO board);
}
