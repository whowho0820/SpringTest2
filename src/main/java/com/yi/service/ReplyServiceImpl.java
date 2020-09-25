package com.yi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yi.domain.Criteria;
import com.yi.domain.ReplyPageDTO;
import com.yi.domain.ReplyVO;
import com.yi.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class ReplyServiceImpl implements ReplyService {
	private ReplyMapper mapper;
	  
	  @Override
	  public int register(ReplyVO vo) {
	    log.info("register......" + vo);
	    return mapper.insert(vo);
	  }
	  @Override
	  public ReplyVO get(int rno) {
	    log.info("get......" + rno);
	    return mapper.read(rno);
	  }
	  @Override
	  public int modify(ReplyVO vo) {
	    log.info("modify......" + vo);
	    return mapper.update(vo);
	  }
	  @Override
	  public int remove(int rno) {
	    log.info("remove...." + rno);
	    return mapper.delete(rno);
	  }
	  @Override
	  public List<ReplyVO> getList(Criteria cri, int bno) {
	    log.info("get Reply List of a Board " + bno);
	    return mapper.getListWithPaging(cri, bno);
	  }
	  @Override
	  public ReplyPageDTO getListPage(Criteria cri, int bno) {	       
	    return new ReplyPageDTO(
	        mapper.getCountByBno(bno), 
	        mapper.getListWithPaging(cri, bno));
	  }
	}
	  

