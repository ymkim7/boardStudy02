package kr.co.controller;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.domain.CartListVO;
import kr.co.domain.CartVO;
import kr.co.domain.GoodsViewVO;
import kr.co.domain.MemberVO;
import kr.co.domain.OrderDetailVO;
import kr.co.domain.OrderListVO;
import kr.co.domain.OrderVO;
import kr.co.domain.ReplyListVO;
import kr.co.domain.ReplyVO;
import kr.co.service.ShopService;

@Controller
@RequestMapping(value = "/shop/*")
public class ShopController {
	
	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);

	@Autowired
	ShopService service;
	
	//카테고리별 상품 리스트
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getList(@RequestParam("c") int cateCode, @RequestParam("l") int level, Model model) throws Exception {
		logger.info("getList");
		
		List<GoodsViewVO> list = null;
		list = service.list(cateCode, level);
		
		model.addAttribute("list", list);
		
	}
	
	//상품조회
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void getView(@RequestParam("n") int gdsNum, Model model) throws Exception {
		logger.info("getView");
		
		GoodsViewVO view = service.goodsView(gdsNum);
		model.addAttribute("view", view);
		
		/*
		 * List<ReplyListVO> reply = service.replyList(gdsNum);
		 * model.addAttribute("reply", reply);
		 */
		
	}
	
	//상품소감
	@ResponseBody
	@RequestMapping(value = "/view/registReply", method = RequestMethod.POST)
	public void registReply(ReplyVO reply, HttpSession session) throws Exception {
		logger.info("registReply");
	   
		MemberVO member = (MemberVO) session.getAttribute("member");
		reply.setUserId(member.getUserId());
	 
		service.registReply(reply);
	 
	}
	
	// 상품 소감(댓글) 목록
	@ResponseBody
	@RequestMapping(value = "/view/replyList", method = RequestMethod.GET)
	public List<ReplyListVO> getReplyList(@RequestParam("n") int gdsNum) throws Exception {
		logger.info("getReplyList");
	   
		List<ReplyListVO> reply = service.replyList(gdsNum);
	 
		return reply;
	 
	}
	
	//상품 소감 삭제
	@ResponseBody
	@RequestMapping(value = "/view/deleteReply", method = RequestMethod.POST)
	public int postReplyList(ReplyVO reply, HttpSession session) throws Exception{
		logger.info("postReplyList");
		
		int result = 0;
		
		MemberVO member = (MemberVO) session.getAttribute("member");
		String userId = service.idCheck(reply.getRepNum());
		
		if(member.getUserId().equals(userId)) {
			reply.setUserId(member.getUserId());
			service.deleteReply(reply);
			
			result = 1;
		}
		
		return result;
	}
	
	//상품 소감 수정
	@ResponseBody
	@RequestMapping(value = "/view/modifyReply", method = RequestMethod.POST)
	public int modifyReply(ReplyVO reply, HttpSession session) throws Exception {
		logger.info("modifyReply");
		
		int result = 0;
		
		MemberVO member = (MemberVO) session.getAttribute("member");
		String userId = service.idCheck(reply.getRepNum());
		
		if(member.getUserId().equals(userId)) {
			reply.setUserId(member.getUserId());
			service.modifyReply(reply);
			result = 1;
		}
		
		return result;
	}
	
	//카트담기
	@ResponseBody
	@RequestMapping(value = "/view/addCart", method = RequestMethod.POST)
	public int addCart(CartVO cart, HttpSession session) throws Exception {
		logger.info("addCart");
		
		int result = 0;
		
		MemberVO member = (MemberVO) session.getAttribute("member");
		
		if(member != null) {
			cart.setUserId(member.getUserId());
			service.addCart(cart);
			result = 1;
		}
		
		return result;
	}
	
	//카트목록
	@RequestMapping(value = "/cartList", method = RequestMethod.GET)
	public void getCartList(HttpSession session, Model model) throws Exception {
		logger.info("getCartList");
		
		MemberVO member = (MemberVO) session.getAttribute("member");
		String userId = member.getUserId();
				
		List<CartListVO> cartList = service.cartList(userId);
		
		model.addAttribute("cartList", cartList);
		
	}
	
	//카트삭제
	@ResponseBody
	@RequestMapping(value = "/deleteCart", method = RequestMethod.POST)
	public int deleteCart(HttpSession session, @RequestParam(value = "chbox[]") List<String> chArr, CartVO cart) throws Exception {
		logger.info("deleteCart");
		
		MemberVO member = (MemberVO) session.getAttribute("member");
		String userId = member.getUserId();
		
		int result = 0;
		int cartNum = 0;
		
		if(member != null) {
			cart.setUserId(userId);
			
			for(String i : chArr) {
				cartNum = Integer.parseInt(i);
				cart.setCartNum(cartNum);
				service.deleteCart(cart);
			}
			result = 1;
		}
		return result = 1;
	}
	
	//주문
	@RequestMapping(value = "/cartList", method = RequestMethod.POST)
	public String order(HttpSession session, OrderVO order, OrderDetailVO orderDetail) throws Exception {
		logger.info("order");
		
		MemberVO member = (MemberVO) session.getAttribute("member");
		String userId = member.getUserId();
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String ym = year + new DecimalFormat("00").format(cal.get(Calendar.MONTH) + 1);
		String ymd = ym + new DecimalFormat("00").format(cal.get(Calendar.DATE));
		String subNum = "";
		
		for(int i=1; i<=6; i++) {
			subNum += (int)(Math.random() * 10);
		}
		
		String orderId = ymd + "_" + subNum;
		
		order.setOrderId(orderId);
		order.setUserId(userId);
		orderDetail.setOrderId(orderId);
		
		service.orderInfo(order);
		service.orderInfo_Detail(orderDetail);
		service.cartAllDelete(userId);
		
		return "redirect:/shop/orderList";
	}
	
	//주문목록
	@RequestMapping(value = "/orderList", method = RequestMethod.GET)
	public void getOrderList(HttpSession session, OrderVO order, Model model) throws Exception {
		logger.info("getOrderList");
		
		MemberVO member = (MemberVO) session.getAttribute("member");
		String userId = member.getUserId();
		
		order.setUserId(userId);
				
		List<OrderVO> orderList = service.orderList(order);
		
		model.addAttribute("orderList", orderList);
		
	}
	
	//주문 상세 목록
	@RequestMapping(value = "/orderView", method = RequestMethod.GET)
	public void getOrderList(HttpSession session, @RequestParam("n") String orderId, OrderVO order, Model model) throws Exception {
		logger.info("getOrderList");
		
		MemberVO member = (MemberVO) session.getAttribute("member");
		String userId = member.getUserId();
		
		order.setUserId(userId);
		order.setOrderId(orderId);
		
		List<OrderListVO> orderView = service.orderView(order);
		
		model.addAttribute("orderView", orderView);
	}
	
}
