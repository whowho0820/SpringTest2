package com.yi.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.yi.domain.BoardVO;
import com.yi.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
// Java Config
// @ContextConfiguration(classes = {org.zerock.config.RootConfig.class} )
@Log4j

public class BoardServiceTest {

	@Setter(onMethod_ = { @Autowired })
	private BoardService service;

	@Test
	public void testExist() {

		log.info(service);
		assertNotNull(service);
	}

	@Test
	public void testRegister() {

		BoardVO board = new BoardVO();
		board.setName("�Ǵٿ�4");
		board.setAge(22);
		board.setAddress("�뱸 �޼���1");
		board.setSphone("110-123-1234");

		service.register(board);

		log.info("������ �Խù��� ��ȣ: ");
	}

	@Test
	public void testGetList() {

		// service.getList().forEach(board -> log.info(board));
		service.getList(new Criteria()).forEach(board -> log.info(board));
	}

//	@Test
	public void testGet() {

		log.info(service.get("����"));
	}

//	@Test
	public void testDelete() {

		// �Խù� ��ȣ�� ���� ���θ� Ȯ���ϰ� �׽�Ʈ�� ��
		log.info("REMOVE RESULT: " + service.remove(4));

	}

//	@Test
	public void testUpdate() {

		BoardVO board = service.get("��");

		if (board == null) {
			return;
		}

		board.setName("�Ǵٿ�3");
		log.info("MODIFY RESULT: " + service.modify(board));
	}

}
