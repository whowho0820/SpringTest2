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

	// �׽�Ʈ ���� �ش� ��ȣ�� �Խù��� �����ϴ��� �ݵ�� Ȯ���� ��
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

			// �Խù��� ��ȣ
			vo.setBno(bnoArr[i % 5]);
			vo.setReply("��� �׽�Ʈ " + i);
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

		vo.setReply("������ ����Դϴ�.");

		int count = mapper.update(vo);

		log.info("������ ��� ����: " + count);
	}
	@Test
	public void testList() {

		Criteria cri = new Criteria();

		// 3145745L
		List<ReplyVO> replies = mapper.getListWithPaging(cri, bnoArr[0]);

		replies.forEach(reply -> log.info(reply));

	}
	
	
}
