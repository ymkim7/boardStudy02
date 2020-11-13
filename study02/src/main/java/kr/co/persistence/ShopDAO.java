package kr.co.persistence;

import java.util.List;

import kr.co.domain.CartListVO;
import kr.co.domain.CartVO;
import kr.co.domain.GoodsViewVO;
import kr.co.domain.OrderDetailVO;
import kr.co.domain.OrderListVO;
import kr.co.domain.OrderVO;
import kr.co.domain.ReplyListVO;
import kr.co.domain.ReplyVO;

public interface ShopDAO {
	
	//카테고리별 상품 리스트 : 1차분류
	public List<GoodsViewVO> list(int cateCode, int cateCodeRef) throws Exception;

	//카테고리별 상품 리스트 : 2차분류
	public List<GoodsViewVO> list(int cateCode) throws Exception;
	
	//상품조회
	public GoodsViewVO goodsView(int gdsNum) throws Exception;
	
	//상품소감
	public void registReply(ReplyVO reply) throws Exception;
	
	//상품소감 리스트
	public List<ReplyListVO> replyList(int gdsNum) throws Exception;
	
	//상품소감 삭제
	public void deleteReply(ReplyVO reply) throws Exception;
	
	//아이디 체크
	public String idCheck(int repNum) throws Exception;
	
	//소감수정
	public void modifyReply(ReplyVO reply) throws Exception;
	
	//카트담기
	public void addCart(CartVO cart) throws Exception;
	
	//카트리스트
	public List<CartListVO> cartList(String userId) throws Exception;
	
	//카트삭제
	public void deleteCart(CartVO cart) throws Exception;
	
	//주문정보
	public void orderInfo(OrderVO order) throws Exception;
	
	//주문 상세 정보
	public void orderInfo_Detail(OrderDetailVO orderDetail) throws Exception;
	
	//카트삭제
	public void cartAllDelete(String userId) throws Exception;
	
	//주문목록
	public List<OrderVO> orderList(OrderVO order) throws Exception;
	
	//특정 주문목록
	public List<OrderListVO> orderView(OrderVO order) throws Exception;
	
}
