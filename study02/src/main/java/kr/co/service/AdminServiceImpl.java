package kr.co.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.domain.CategoryVO;
import kr.co.domain.GoodsVO;
import kr.co.domain.GoodsViewVO;
import kr.co.domain.OrderListVO;
import kr.co.domain.OrderVO;
import kr.co.domain.ReplyListVO;
import kr.co.persistence.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDAO dao;

	@Override
	public List<CategoryVO> category() throws Exception {
		return dao.category();
	}

	@Override
	public void register(GoodsVO vo) throws Exception {
		dao.register(vo);
		
	}

	@Override
	public List<GoodsViewVO> goodslist() throws Exception {
		return dao.goodslist();
	}

	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		return dao.goodsView(gdsNum);
	}

	@Override
	public void goodsModify(GoodsVO vo) throws Exception {
		dao.goodsModify(vo);
		
	}

	@Override
	public void goodsDelete(int gdsNum) throws Exception {
		dao.goodsDelete(gdsNum);
		
	}

	@Override
	public List<OrderVO> orderList() throws Exception {
		return dao.orderList();
	}

	@Override
	public List<OrderListVO> orderView(OrderVO order) throws Exception {
		return dao.orderView(order);
	}

	@Override
	public void delivery(OrderVO order) throws Exception {
		dao.delivery(order);
		
	}

	@Override
	public void changeStock(GoodsVO goods) throws Exception {
		dao.changeStock(goods);
		
	}

	@Override
	public List<ReplyListVO> allReply() throws Exception {
		return dao.allReply();
	}

	@Override
	public void deleteReply(int repNum) throws Exception {
		dao.deleteReply(repNum);
		
	}

}
