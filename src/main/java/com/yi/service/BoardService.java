package com.yi.service;

import java.util.List;

import com.yi.domain.BoardVO;
import com.yi.domain.Criteria;

public interface BoardService {

	public void register(BoardVO voard);
	public BoardVO get(String mid);
	public boolean modify(BoardVO board);
	public boolean remove(int mid);
	public List<BoardVO> getList(int mid); //검색 내용 담아줌
	public int getTotal(Criteria cri);
	public List<BoardVO> getList(Criteria cri);
}
