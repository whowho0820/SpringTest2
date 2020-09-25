package com.yi.persistence;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.yi.domain.Criteria;
import com.yi.domain.ReplyVO;
import com.yi.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
// Java Config
// @ContextConfiguration(classes = { org.zerock.config.PersistenceConfig.class
// })
@Log4j

public class ReplyMapperTests {

	// 테스트 전에 해당 번호의 게시물이 존재하는지 반드시 확인할 것
	private int[] bnoArr = { 22, 23, 24, 25, 26 };

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;

//	@Test
	public void testMapper() {

		log.info(mapper);
	}
//	@Test
	public void testCreate() {

		IntStream.rangeClosed(1, 10).forEach(i -> {

			ReplyVO vo = new ReplyVO();

			// 게시물의 번호
			vo.setBno(bnoArr[i % 5]);
			vo.setReply("댓글 테스트 " + i);
			vo.setReplyer("replyer" + i);

			mapper.insert(vo);
		});

	}
//	@Test
	public void testRead() {

		int targetrno = 3;

		ReplyVO vo = mapper.read(targetrno);

		log.info(vo);
	}
	
//	@Test
	public void testDelete() {

		int targetRno = 2;

		mapper.delete(targetRno);
	}
//	@Test
	public void testUpdate() {

		int targetRno = 3;

		ReplyVO vo = mapper.read(targetRno);

		vo.setReply("수정된 댓글입니다.");

		int count = mapper.update(vo);

		log.info("수정된 댓글 갯수: " + count);
	}
	@Test
	public void testList() {

		Criteria cri = new Criteria();

		// 3145745L
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);

		replies.forEach(reply -> log.info(reply));

	}
	
	
}
