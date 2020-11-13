package kr.co.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.portable.OutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import kr.co.domain.CategoryVO;
import kr.co.domain.GoodsVO;
import kr.co.domain.GoodsViewVO;
import kr.co.domain.OrderListVO;
import kr.co.domain.OrderVO;
import kr.co.domain.ReplyListVO;
import kr.co.service.AdminService;
import kr.co.utils.UploadFileUtils;
import net.sf.json.JSONArray;

@Controller
@RequestMapping(value = "/admin/*")
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	AdminService adminService;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	//관리자 화면
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public void getIndex() throws Exception {
		logger.info("getIndex");
	}
	
	//상품등록GET
	@RequestMapping(value = "/goods/register", method = RequestMethod.GET)
	public void getGoodsRegister(Model model) throws Exception {
		logger.info("getGoodsRegister");
		
		List<CategoryVO> category = null;
		category = adminService.category();
		model.addAttribute("category", JSONArray.fromObject(category));
		
	}
	
	//상품등록POST
	@RequestMapping(value = "/goods/register", method = RequestMethod.POST)
	public String postGoodsRegister(GoodsVO vo, MultipartFile file) throws Exception {
		logger.info("postGoodsRegister");
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;
		
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {

			fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
			
			//gdsImg에 원본 파일 경로 + 파일명 저장
			vo.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			
			//gdsThumbImg에 썸네일 파일 경로 + 썸네일 파일명 저장
			vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
			
		//첨부된 팔이 없으면
		} else {
			
			//미리 준비된 none.png파일을 대신 출력
			fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
			
			vo.setGdsImg(fileName);
			vo.setGdsThumbImg(fileName);
		
		}
		
		adminService.register(vo);
		
		return "redirect:/admin/index";
	}
	
	//상품목록GET
	@RequestMapping(value = "/goods/list", method = RequestMethod.GET)
	public void getGoodsList(Model model) throws Exception {
		logger.info("getGoodsList");
		
		List<GoodsViewVO> list = adminService.goodslist();
		model.addAttribute("list", list);
		
	}
	
	//상품조회
	@RequestMapping(value = "/goods/view", method = RequestMethod.GET)
	public void getGoodsView(@RequestParam("n") int gdsNum, Model model) throws Exception {
		logger.info("getGoodsView");
		
		GoodsViewVO goods = adminService.goodsView(gdsNum);
		model.addAttribute("goods", goods);
		
	}
	
	//상품수정
	@RequestMapping(value = "/goods/modify", method = RequestMethod.GET)
	public void getGoodsModify(@RequestParam("n") int gdsNum, Model model) throws Exception {
		logger.info("getGoodsModify");
	
		GoodsViewVO goods = adminService.goodsView(gdsNum);
		model.addAttribute("goods", goods);
		
		List<CategoryVO> category = null;
		category = adminService.category();
		model.addAttribute("category", JSONArray.fromObject(category));
		
	}
	
	//상품수정
	@RequestMapping(value = "/goods/modify", method = RequestMethod.POST)
	public String postGoddsModify(GoodsVO vo, MultipartFile file, HttpServletRequest req) throws Exception {
		logger.info("postGoddsModify");
		
		//새로운 파일이 등록되었는지 확인
		if(file.getOriginalFilename() != null && file.getOriginalFilename() != "") {
			//기존파일을 삭제
			new File(uploadPath + req.getParameter("gdsImg")).delete();
			new File(uploadPath + req.getParameter("gdsTumbImg")).delete();
			
			//새로 첨부한 파일을 등록
			String imgUploadPath = uploadPath + File.separator + "imgUpload";
			String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
			String fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
			
			vo.setGdsImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
			vo.setGdsThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		
		//새로운 파일이 등록되지 않았다면
		} else {
			//기존 이미지를 그대로 사용
			vo.setGdsImg(req.getParameter("gdsImg"));
			vo.setGdsThumbImg(req.getParameter("gdsThumbImg"));
		}
		
		adminService.goodsModify(vo);
		
		return "redirect:/admin/index";
		
	}
	
	//상품삭제
	@RequestMapping(value = "/goods/delete", method = RequestMethod.POST)
	public String postGoodsDelete(@RequestParam("n") int gdsNum) throws Exception {
		logger.info("postGoodsDelete");
		
		adminService.goodsDelete(gdsNum);
		
		return "redirect:/admin/index";
		
	}
	
	//CK에디터 파일 업로드
	@RequestMapping(value = "/goods/ckUpload", method = RequestMethod.POST)
	public void postCKEditorImgUpload(HttpServletRequest req, HttpServletResponse res, @RequestParam MultipartFile upload) throws Exception {
		logger.info("postCKEditorImgUpload");
		
		//랜덤 문자 생성
		UUID uid = UUID.randomUUID();
		
		FileOutputStream out = null;
		PrintWriter printWriter = null;
		
		//안코딩
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		
		try {
			
			//파일 이름 가져오기
			String fileName = upload.getOriginalFilename();
			byte[] bytes = upload.getBytes();
			
			//업로드 경로
			String ckUploadPath = uploadPath + File.separator + "ckUpload" + File.separator + uid + "_" + fileName;
			
			out = new FileOutputStream(new File(ckUploadPath));
			out.write(bytes);
			
			//out에 저장된 데이터를 전송하고 초기화
			out.flush();
			
			String callback = req.getParameter("CKEditorFuncNum");
			printWriter = res.getWriter();
			
			//작성화면
			String fileUrl = "/ckUpload0/" + uid + "_" + fileName;
			
			//업로드시 메시지 출력
			printWriter.println(
					"<script type = 'text/javascript'>"
					+ "window.parent.CKEDITOR.tools.callFunction("
					+ callback + ", '" + fileUrl + "', '이미즈를 업로드하였습니다.')"
					+"</script>"
			);
			
			printWriter.flush();
		
		} catch(IOException e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if(out != null) {
					out.close();
				}
				
				if(printWriter != null) {
					printWriter.checkError();
				}
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
		}
		
		return;
	}
	
	//주문 상세 목록
	@RequestMapping(value = "/shop/orderList", method = RequestMethod.GET)
	public void getOrderList(Model model) throws Exception {
		logger.info("getOrderList");
		
		List<OrderVO> orderList = adminService.orderList();
		
		model.addAttribute("orderList", orderList);
	}
	
	//특정 주문 목록
	@RequestMapping(value = "/shop/orderView", method = RequestMethod.GET)
	public void getOrderView(@RequestParam("n") String orderId, OrderVO order, Model model) throws Exception {
		logger.info("getOrderView");
		
		order.setOrderId(orderId);
		List<OrderListVO> orderView = adminService.orderView(order);
		
		model.addAttribute("orderView", orderView);
	}
	
	//주문 상세 목록 - 상태 변경
	@RequestMapping(value = "/shop/orderView", method = RequestMethod.POST)
	public String delivery(OrderVO order) throws Exception {
		logger.info("delivery");
		
		adminService.delivery(order);
		
		List<OrderListVO> orderView = adminService.orderView(order);
		GoodsVO goods = new GoodsVO();
		
		for(OrderListVO i : orderView) {
			goods.setGdsNum(i.getGdsNum());
			goods.setGdsStock(i.getCartStock());
			adminService.changeStock(goods);
		}
		
		return "redirect:/admin/shop/orderView?n=" + order.getOrderId();
	}
	
	//모든 댓글
	@RequestMapping(value = "/shop/allReply", method = RequestMethod.GET)
	public void getAllReply(Model model) throws Exception {
		logger.info("getAllReply");
		
		List<ReplyListVO> reply = adminService.allReply();
		
		model.addAttribute("reply", reply);
	}
	
	//상품삭제
	@RequestMapping(value = "/shop/deleteReply", method = RequestMethod.POST)
	public String postDeleteReply(@RequestParam("n") int repNum) throws Exception {
		logger.info("postDeleteReply");
		
		adminService.deleteReply(repNum);
		
		return "redirect:/admin/shop/allReply";
		
	}
	
}
